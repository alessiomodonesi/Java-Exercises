#
# Copyright (c) 2004, 2023, Oracle and/or its affiliates. All rights reserved.
# ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
#

# ==============================================================================
#
#  JMX Tutorial Introductory Example : Instrumenting Your Own Applications.
#                                      Using Descriptors and the DescriptorKey
#                                      meta-annotation.
#
#  The aim of this example is to show how the new DescriptorKey meta-annotation
#  can be used in order to add new descriptor items to the Descriptors for a
#  Standard MBean (or MXBean) via annotations in the Standard MBean (or MXBean)
#  interface. The MXBeans example will be the starting point for this example.
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
# The Java classes used in this example are contained in the com.example.mxbeans
# Java package.
#
# * Main.java: gets the Platform MBean Server, and creates
#              and registers the QueueSampler MXBean on it.
#
# * QueueSampler.java: implements the QueueSampler MXBean.
#
# * QueueSamplerMXBean.java: the management interface exposed
#                            by the QueueSampler MXBean.
#
# * QueueSample.java: the Java type returned by the getQueueSample()
#                     method in the QueueSampler MXBean interface.
#
# * DisplayName.java: This annotation is used in QueueSamplerMXBean to supply
#                     a display name for a method in the MBean interface.
#
# * Author.java: This annotation is used in QueueSamplerMXBean to supply
#                the name of the creator of the MBean interface.
#
# * Version.java: This annotation is used in QueueSamplerMXBean to supply
#                 the current version of the MBean interface.
#

javac com/example/mxbeans/*.java

# Start the Main application
#

java com.example.mxbeans.Main

# Start jconsole on a different shell window on the same machine
#
# JConsole is located in $(J2SE_HOME)/bin/jconsole
#

jconsole

# ==============================================================================
