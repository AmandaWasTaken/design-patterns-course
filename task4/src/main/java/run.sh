#! /usr/bin/env bash

die() {
	echo $1
	exit 1
}

javac weather_station/*.java || die "Build failed"
java weather_station/Main || die "Run failed" 
