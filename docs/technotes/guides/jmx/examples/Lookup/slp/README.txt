#
# Copyright (c) 2004, 2023, Oracle and/or its affiliates. All rights reserved.
# ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
#

# ==============================================================================
#
# Example of using SLP as Lookup service - registering and looking up
# an RMI Connector (IIOP/JRMP)
#
# ==============================================================================
#
# Requirements:
#
# The code provided in this example is build against Sun's Java
# implementation of SLP - compliant to RFC 2614 see
# [http://www.ietf.org/rfc/rfc2614.txt]. Sun's Java implementation
# of SLP is available on Solaris systems under /usr/share/lib/slp
#
#
# Before running this example you will have to:
# ---------------------------------------------
#
# If you are not running Solaris:
#
#     You will have to get a Java implementation of SLP compliant to
#     RFC 2614, section 5. You can download the OpenSLP Java implementation
#     from http://www.openslp.org/. Then you may have to modify Client.java
#     and Server.java in order to use <my-slp-impl>.slp instead of
#     com.sun.slp. If your SLP implementation is RFC 2614 compliant
#     the changes should be limited to replacing 'com.sun.slp' in the
#     import clauses by '<my-slp-impl>.slp'.
#
# If you wish to use an external directory for the RMI JMX Connectors
# (URLs of the form jmx:service:[rmi|iiop]:/host:port/jndi/jndi-url)
# then:
#
#   o If you wish to use rmiregistry in conjunction with the RMI/JRMP
#     JMX Connector you will have to start a rmiregistry (see below).
#
#   o If you wish to use CORBA Naming Service in conjunction with the RMI/IIOP
#     JMX Connector you will have to start an ORB daemon (see below).
#
#   o If you wish to use LDAP in conjunction with the RMI JMX Connectors
#     you will have to install/setup a directory server
#
# In order to compile and run the example, make a copy of this README file, and
# then simply cut and paste all the commands as needed into a terminal window.
#
# This README makes the assumption that you are running under Java SE 6 on Unix,
# you are familiar with SLP, the JMX technology, with LDAP and JNDI, and with
# the bourne shell or korn shell syntax.
#
# All the commands below are defined using Unix korn shell syntax.
#
# If you are not running Unix and korn shell you are expected to be able to
# adapt these commands to your favorite OS and shell environment.
#

# Solaris:
#
SLP_HOME=/usr/share/lib/slp

# Define the following variables:
#
SLPLIB=$SLP_HOME

classp=$SLPLIB/slp.jar

#-------------------------------------------------------------------------------
# The SLP daemon needs to be launched with root privilege on each
# host who uses the SLP API. To launch the SLP daemon, simply type
# the following command line:
#
su root -c "java -cp $SLPLIB/slpd.jar com.sun.slp.slpd &"

#-------------------------------------------------------------------------------
# Start an rmiregistry
#
rmiregistry 9999 &

#-------------------------------------------------------------------------------
# Start an ORB daemon:
#
rm -rf ./orb.db
orbd -ORBInitialPort 7777 &

#-------------------------------------------------------------------------------
# Start an LDAP Server, and create a new dc=Test suffix inside.
#
# (only needed if you wish to register the RMI or IIOP stubs in
# LDAP, instead of using CORBA Naming Service or RMI registry)
#
# On Solaris 9 you should first login as root and execute
# the following commands:

# Setup an LDAP server (you don't need to do this if the
# server has already been configured).
#
/usr/sbin/directoryserver setup

# Start the console, and if needed create a new suffix, a database,
# and a root node (e.g. dc=Test)
#
/usr/sbin/directoryserver startconsole

# NOTE: if you're not using Solaris 9 Directory Server you will have
#       to make sure the Java Schema (RFC 2713:
#       http://www.ietf.org/rfc/rfc2713.txt) is known by that server

#-------------------------------------------------------------------------------
# Compile Server.java and Client.java
#
# * Server.java: creates an MBeanServer, creates and starts an
#                RMI connector (JRMP/IIOP)
# * Client.java: lookup a connector in SLP
#                list all MBeans.
#
javac -d . -classpath $classp Server.java Client.java

#-------------------------------------------------------------------------------
# LDAP Parameters

# Supply the appropriate hostname below, and define this variable:
#
ldaphost=gigondas

# Supply the appropriate port number below, and define this variable:
#
ldapport=6666

# Supply the appropriate principal below, and define this variable:
#
principal="cn=Directory Manager"

# Supply the appropriate credentials below, and define this variable:
#
credentials=

#-------------------------------------------------------------------------------
# JNDI URLs
#
jndirmi="rmi://localhost:9999"
jndiiiop="iiop://localhost:7777"
jndildap="ldap://$ldaphost:$ldapport"

#-------------------------------------------------------------------------------
# JMX Service URLs
#
jmxiiopurl="service:jmx:iiop:///jndi/${jndiiiop}/server"
jmxrmiurl="service:jmx:rmi:///jndi/${jndirmi}/server"
jmxiiopldapurl="service:jmx:iiop:///jndi/${jndildap}/cn=x,dc=Test"
jmxrmildapurl="service:jmx:rmi:///jndi/${jndildap}/cn=x,dc=Test"
jmxstuburl="service:jmx:rmi://"
jmxiorurl="service:jmx:iiop://"

#-------------------------------------------------------------------------------
# Below we illustrate the different JMX Connector Servers
# which you have the choice to start. 
# There are seven cases labelled (a) to (f):
#
#   * RMI Connectors
#       + over JRMP
#           - without any external directory (a)
#           - using rmiregistry as external directory (b)
#           - using LDAP as external directory (c)
#       + over IIOP
#           - without any external directory (d)
#           - using CORBA Naming Service as external directory (e)
#           - using LDAP as external directory (f)

# NOTE-1: As defined in section 6.1 "Terminology" of the "JMX Remote API 1.0
# Specification" document, an agent is composed of one MBean Server and of
# one or more Connector Servers. There can be several agents running in one JVM.
# For flexibility of this example, the slp.Server class creates an agent which
# is composed of one MBean Server and of only one Connector Server. The class
# slp.Server decides which type of Connector Server to create depending on the
# value given to the "url" system property when you start the example.

# NOTE-2: The value of the "agent.name" system property is the value that the
# slp.Server class will give to the "AgentName" lookup attribute when it
# registers the connector's URL in the lookup service. As defined in Table 6.1
# "Lookup attributes for connectors" of the "JMX Remote API 1.0 Specification"
# document: the "AgentName" lookup attribute is a simple name used to identify
# the *AGENT* to which the connector is attached. It makes it possible to
# search, with a query to the lookup service, for all the connectors registered
# by a given agent.

# (a) You can start an agent with an RMI Connector Server over JRMP
#     without using any external directory
#
java -classpath .:$classp -Ddebug=true \
     -Dagent.name=test-server-a \
     -Durl="service:jmx:rmi://" \
     slp.Server &

# (b) Or you can start an agent with an RMI Connector Server over JRMP
#     using rmiregistry as external directory
#     (Start rmiregistry first, if not yet started)
#
java -classpath .:$classp -Ddebug=true \
     -Dagent.name=test-server-b \
     -Durl="service:jmx:rmi:///jndi/${jndirmi}/server" \
     slp.Server &

# (c) Or you can start an agent with an RMI Connector Server over JRMP
#     using LDAP as external directory
#     (First start an LDAP server and create the dc=Test suffix)
#
java -classpath .:$classp -Ddebug=true \
     -Dagent.name=test-server-c \
     -Durl="service:jmx:rmi:///jndi/${jndildap}/cn=x,dc=Test" \
     -Djava.naming.security.principal="$principal" \
     -Djava.naming.security.credentials="$credentials" \
     slp.Server &

# (d) Or you can start an agent with an RMI Connector Server over IIOP
#     without using any external directory
#
java -classpath .:$classp -Ddebug=true \
     -Dagent.name=test-server-d \
     -Durl="service:jmx:iiop://" \
     slp.Server &

# (e) Or you can start an agent with an RMI Connector Server over IIOP
#     using CORBA Naming Service as external directory
#     (Start ORBD first if not yet started).
#
java -classpath .:$classp -Ddebug=true \
     -Dagent.name=test-server-e \
     -Durl="service:jmx:iiop:///jndi/${jndiiiop}/server" \
     slp.Server &

# (f) Or you can start an agent with an RMI Connector Server over IIOP
#     using LDAP as external directory
#     (First start an LDAP server and create the dc=Test suffix) 
#
java -classpath .:$classp -Ddebug=true \
     -Dagent.name=test-server-f \
     -Durl="service:jmx:iiop:///jndi/${jndildap}/cn=x,dc=Test" \
     -Djava.naming.security.principal="$principal" \
     -Djava.naming.security.credentials="$credentials" \
     slp.Server &

# Once you have started one or more agents, you can start the Client.
# Note that for the client to look up through SLP an agent you have just
# started, you must start the client before your agent's SLP lease has
# expired. You can update the Server.java file and recompile it to change
# the lease period.
#
java -classpath .:$classp -Ddebug=true \
     -Djava.naming.security.principal="$principal" \
     -Djava.naming.security.credentials="$credentials" \
     slp.Client

#-------------------------------------------------------------------------------
