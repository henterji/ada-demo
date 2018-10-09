#!/bin/sh

#set -ev

publishReport() {
  for entry in $(pwd)/target/cucumber-html-report/$1/*
  do
    if [ -f "$entry" ];then
      echo $(basename "$entry")
    fi
  done
}

publishReport

for entry in $(pwd)/target/cucumber-report.json
do
  if [ -f "$entry" ];then
    echo $(basename "$entry")
  fi
done
