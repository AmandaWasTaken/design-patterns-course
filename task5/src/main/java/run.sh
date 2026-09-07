#! /usr/bin/env bash

die() {
	echo $1
	echo $?
	exit 1
}

javac logger/*.java || die "Build failed"
java logger/Main || die "Run failed" 
