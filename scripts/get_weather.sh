#!/bin/bash
echo $OPENWEATHER_APPID
curl -v "http://api.openweathermap.org/data/2.5/weather?zip=97051&APPID=$OPENWEATHER_APPID"
