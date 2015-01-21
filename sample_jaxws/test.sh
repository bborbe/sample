#!/bin/sh

curl -X POST -d @src/test/resources/utf8.xml http://localhost:9648/rest/post?param=utf8 --header "Content-Type:text/xml; charset=UTF-8"
curl -X POST -d @src/test/resources/iso.xml http://localhost:9648/rest/post?param=iso --header "Content-Type:text/xml; charset=latin1"