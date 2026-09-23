#! /usr/bin/env bash

die() {
	echo $1
	exit 1
}

javac sorting/*.java || die "Build failed"
java sorting/Main || die "Run failed"
