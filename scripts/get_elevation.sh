#!/bin/bash
echo $GOOGLE_API_KEY
curl "https://maps.googleapis.com/maps/api/elevation/json?locations=39.7391536,-104.9847034&key=$GOOGLE_API_KEY"
