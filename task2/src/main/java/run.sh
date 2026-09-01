#! /usr/bin/env bash

die() {
	echo $1
	echo $?
	exit 1
}

javac ascii/*.java || die "Build failed"
java ascii/Main || die "Run failed" 
