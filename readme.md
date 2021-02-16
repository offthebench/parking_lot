# Parking Lot

[![N|Solid](https://cturtle.co/wp-content/uploads/2020/10/gojek_3_zqwl-150x150.jpg)](https://nodesource.com/products/nsolid)

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

Parking Lot application is written in Java.

It uses gradle for building the project.

### Tech

Parking lot uses a number of open source projects to work properly:

* [Gradle] - Gradle is a build automation tool based on Groovy and Kotlin.
* [Java] - Java is a high-level programming language developed by Sun Microsystems.
* [JUnit] - JUnit is a unit testing framework for the Java programming language.

### Installation

Install the dependencies and start the server in Interative mode:
```sh
$ bin/setup
```

To run using input file.
```sh
$ java -jar build/libs/Parking-Lot-1.0-SNAPSHOT.jar testcase.txt
```

To run functional tests.
```sh
$ bin/run_functional_tests
```