#!/bin/bash

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`

echo $BIN_DIR
echo $DEPLOY_DIR

#echo "whm hello world!!"
ppath=$DEPLOY_DIR/src/main/proto
echo $ppath
jpath=/Users/whm/one/proto/java
opath=/Users/whm/one/proto/objc
echo "start..."
/usr/local/bin/protoc --proto_path=$ppath --java_out=$jpath --objc_out=$opath $ppath/Common.proto
/usr/local/bin/protoc --proto_path=$ppath --java_out=$jpath --objc_out=$opath $ppath/Student.proto
echo "end..."
echo "open $jpath"
open $jpath