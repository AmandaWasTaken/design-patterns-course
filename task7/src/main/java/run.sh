#! /usr/bin/env bash

die() {
	echo $1
	exit 1
}

trap "echo Exited" SIGINT

javac game/*.java || die "Build failed"
java game/Main || die "Run failed"
