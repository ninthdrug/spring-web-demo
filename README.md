## A Simple Demo of Spring Web
Implements an endpoint:
```http://localhost:8080/demo?zipcode=XXXXXXX```

Which returns a simple string:
```
At the location $CITY_NAME, the temperature is $TEMPERATURE, the timezone is $TIMEZONE, and the elevation is $ELEVATION
```

### To Build
```./gradlew build```
### To Run
```
export GOOGLE_API_KEY=****
export OPENWEATHER_APPID=****
./gradlew bootRun
```
Change **** to your api keys.

### To Test
```curl http://localhost:8080/demo?zipcode=97051```

```
pip install pytest
cd src/test/python
python -m pytest test_demo.py

```


