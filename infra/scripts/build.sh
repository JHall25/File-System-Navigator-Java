#!/bin/bash
cd ../../
mvn clean verify
cp file-navigator-client/target/file-navigator-client-0.1-SNAPSHOT.jar infra/scripts/
cp file-navigator-server/target/file-navigator-server-0.1-SNAPSHOT.jar infra/scripts/