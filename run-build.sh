#!/bin/sh

set -e

mvn -s settings.xml clean install -Dmaven.wagon.http.ssl.insecure=true -Dmaven.test.skip=true --no-transfer-progress