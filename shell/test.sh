#!/bin/bash

#echo "whm hello world!!"
ppath=/Volumes/one/IdeaProjects/pbTestMaven/src/main/proto
jpath=/Users/whm/one/proto/java
opath=/Users/whm/one/proto/objc
echo "start..."
/usr/local/bin/protoc --proto_path=$ppath --java_out=$jpath --objc_out=$opath $ppath/Common.proto
/usr/local/bin/protoc --proto_path=$ppath --java_out=$jpath --objc_out=$opath $ppath/Student.proto