import requests

def test_sanity():
    assert (1 + 1 == 2)

def test_demo_st_helens():
    r = requests.get('http://localhost:8080/demo?zipcode=97051')
    print(r.text)
    assert (r.status_code == 200)
    assert ("the timezone is Pacific Standard Time" in r.text)

def test_no_zipcode():
    r = requests.get('http://localhost:8080/demo')
    assert (r.status_code == 400)

def test_bad_zipcode():
    r = requests.get('http://localhost:8080/demo?zipcode=A')
    assert (r.status_code == 400)
