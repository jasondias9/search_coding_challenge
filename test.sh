#!/usr/bin/env bash

set -e

javac $(find . -name '*.java')

java -cp test:src aerofs.search.SearchTest