# Language Comparison Client - Scala

## To create a project

http://scalatutorials.com/beginner/2013/07/18/getting-started-with-sbt/

## Standard Library

Note that there is no standard Scala HTTP library.  There are 3rd party clients, and there is the base Java implementation.

Although I want to stay as stdlib as possible, Scala tastes different enough from Java that I will be using Finagle with Argonaut for this example.

## To run

First you'll want to clone the server and get it running: https://github.com/barrettclark/location-comparison-server

    ./sbt run
