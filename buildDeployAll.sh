#!/bin/bash
mvn clean deploy -Prelease,deploy -Dmaven.test.skip=true