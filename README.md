# Automated testing of site lamoda - online clothing store.

Tests include:
  1. Search engine testing.
  2. Sorting testing.
  3. Testing the cart.

To run the tests on your machine, run the containers in Docker and run the testNg.xml file in your IDE.
You can also run through Jenkins before running the tests, make sure that your Docker containers are running.
After running the tests, you will have access to the Allure report.
To run from the console, go to the directory where you cloned the project, make sure that the Docker containers are running and enter the command "mvn clean test".
