#!/bin/bash
echo $GOOGLE_API_KEY
curl -v "https://maps.googleapis.com/maps/api/timezone/json?location=38.908133,-77.047119&timestamp=1458000000&key=$GOOGLE_API_KEY"
