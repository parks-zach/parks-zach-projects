import requests
import re

url = "http://yahoo.com"

response = requests.get(url, allow_reditects = True)

full = response.content
full = full.decode('iso_8859_1')
print(full)

patter = re.compile('<a.*/a>')
stuff = patter.finall(full)
print("I found:")
print(stuff)
