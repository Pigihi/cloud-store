# import selenium
# from selenium.webdriver.common.by import By
# from selenium.webdriver.common.keys import Keys
# from selenium import webdriver
#
# expectedUrl = "http://localhost:3000"
#
# print("Starting GeckoDriver")
# driver = webdriver.Firefox()
# print("Going to login url")
# driver.get("http://localhost:3000/login")
# print("Entering email and password")
# driver.find_element(By.ID, "emailLogin") .send_keys("astg4527customer1@gmail.com")
# driver.find_element(By.ID, "passLogin").send_keys("QWERTY@123qwerty")
# print("Performing Submit")
# driver.find_element(By.ID, "submitLogin").click()
# driver.implicitly_wait(10)
#
# currentUrl = driver.current_url
#
# if expectedUrl == currentUrl:
#     print("Test Case 2 Failed")
# else:
#     print("Test Case 2 Passed")





# import selenium
# from selenium.webdriver.common.by import By
# from selenium.webdriver.common.keys import Keys
# from selenium import webdriver
#
# expectedUrl = "http://localhost:3000"
#
# print("Starting GeckoDriver")
# driver = webdriver.Firefox()
# print("Going to login url")
# driver.get("http://localhost:3000/login")
# print("Perform click on logo")
# driver.find_element(By.ID, "logoText") .click()
# driver.implicitly_wait(10)
#
# currentUrl = driver.current_url
#
# if expectedUrl == currentUrl:
#     print("Test Case 3 Failed")
# else:
#     print("Test Case 3 Passed")
import time

import selenium
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium import webdriver

expectedUrl = "http://localhost:3000"

print("Starting GeckoDriver")
driver = webdriver.Firefox()
print("Going to login url")
driver.get("http://localhost:3000/login")
print("Entering email and password")
driver.find_element(By.ID, "emailLogin") .send_keys("astg4527customer1@gmail.com")
driver.find_element(By.ID, "passLogin").send_keys("QWERTY@123qwerty")
print("Performing Submit")
driver.find_element(By.ID, "submitLogin").click()
time.sleep(5)

driver.find_element(By.ID, "logoutButton").click()
time.sleep(5)

currentUrl = driver.current_url

if expectedUrl == currentUrl:
    print("Test Case 4 Failed")
else:
    print("Test Case 4 Passed")


