#!/bin/bash
curl -X 'POST' \
  'http://localhost:8080/process' \
  -H 'accept: */*' \
  -H 'Content-Type: application/json' \
  -d '{
  "id": "1",
  "url": "/home/lk/projects/hvd/ai-docs/server/src/test/resources/com/hvd/docs/conversion/XslxTest.sample1.xlsx",
  "contentType": ""
}'