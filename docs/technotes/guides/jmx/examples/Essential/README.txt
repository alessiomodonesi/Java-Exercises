#
# Copyright (c) 2004, 2023, Oracle and/or its affiliates. All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions
# are met:
#
#   - Redistributions of source code must retain the above copyright
#     notice, this list of conditions and the following disclaimer.
#
#   - Redistributions in binary form must reproduce the above copyright
#     notice, this list of conditions and the following disclaimer in the
#     documentation and/or other materials provided with the distribution.
#
#   - Neither the name of Oracle or the names of its
#     contributors may be used to endorse or promote products derived
#     from this software without specific prior written permission.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
# IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
# THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
# PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
# CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
# EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
# PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
# PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
# LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
# NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
# 

# ==============================================================================
#
#  JMX Tutorial Introductory Example : Instrumenting Your Own Applications.
#
#  The aim of this introductory example is to show the basic features of
#  the JMX technology first by instrumenting a simple resource and second
#  by performing operations on it using the jconsole tool. This example
#  shows the implementation of a standard MBean, how to register it in the
#  platform's MBean Server and how to perform remote operations on it by
#  connecting to the RMI connector server using the jconsole tool. Besides
#  monitoring the application, jconsole will also allow you to observe the
#  built-in JVM instrumentation as the JVM's MBeans are also registered in
#  the platform's MBean Server. This examples also shows how the existing
#  platform's MBean Server can be shared between the JVM and the application
#  itself to register the application MBeans, thus avoiding the creation of
#  multiple MBean Server instances on the same JVM.
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
# The Java classes used in this example are contained in the com.example.mbeans
# Java package.
#
# * Main.java: gets the Platform MBean Server, and creates
#              and registers the Hello World MBean on it.
#
# * Hello.java: implements the Hello World standard MBean.
#
# * HelloMBean.java: the management interface exposed by
#                    the Hello World standard MBean.
#

javac com/example/mbeans/*.java

# Start the Main application
#

java com.example.mbeans.Main

# Start jconsole on a different shell window on the same machine
#
# JConsole is located in $(J2SE_HOME)/bin/jconsole
#

jconsole

# ==============================================================================
