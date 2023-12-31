#
# Copyright (c) 2004, 2023, Oracle and/or its affiliates. All rights reserved.
# ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
#

# ==============================================================================
#
#  Example of a secure RMI connector.
#
#  This example uses:
#
#  - the RMI SSL socket factories for encryption,
#  - the password authenticator based on the JMXAuthenticator interface for
#    user authentication,
#  - the file access controller based on the MBeanServerForwarder interface
#    for user access level authorization.
#
# ==============================================================================
#
# In order to compile and run the example, make a copy of this README file, and
# then simply cut and paste all the commands as needed into a terminal window.
#
# All the commands below are defined using Unix korn shell syntax.
#
# If you are not running Unix and korn shell you are expected to be able to
# adapt these commands to your favorite OS and shell environment.
#

# Compile Java classes
#
# * Server.java: creates an MBeanServer and creates and starts a secure RMI
#                connector server (JRMP).
#
# * Client.java: creates a secure RMI connector (JRMP), creates and registers
#                a Simple standard MBean and performs operations on it.
#
# * ClientListener.java: implements a generic notification listener.
#
# * SimpleStandard.java: implements the Simple standard MBean.
#
# * SimpleStandardMBean.java: the management interface exposed by the Simple
#                             standard MBean.
#

javac mbeans/SimpleStandard.java \
      mbeans/SimpleStandardMBean.java \
      server/Server.java \
      client/Client.java \
      client/ClientListener.java

# Start the RMI registry:
#

export CLASSPATH=server ; rmiregistry 9999 &

# Start the Server:
#

java -classpath server:mbeans \
     -Djavax.net.ssl.keyStore=config/keystore \
     -Djavax.net.ssl.keyStorePassword=password \
     Server &

# Start the Client:
#

java -classpath client:server:mbeans \
     -Djavax.net.ssl.trustStore=config/truststore \
     -Djavax.net.ssl.trustStorePassword=trustword \
     Client

# ==============================================================================
