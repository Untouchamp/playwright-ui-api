Project Showcase: Java & Playwright
This project is a showcase of how to write automated tests in Java using Playwright. It consists of two parts: API tests for a custom backend service for a todo app, and UI testing framework for a Playwright website, implemented using the Page Object Model.

Contents
Overview
Setup
Running Tests
Project Structure
Overview
The project demonstrates how to implement automated tests in Java for both backend APIs and frontend UIs using Playwright. It aims to showcase best practices in test automation, including using the Page Object Model for UI tests and structuring tests for maintainability and readability.

Setup
To set up the project, follow these steps:

Clone the repository to your local machine.
Ensure you have Java and Maven installed.
Install the necessary dependencies using Maven.
Running Tests
To run the tests, execute the following commands:

For API tests:
bash
Copy code
mvn test -Dtest=APITestSuite
For UI tests:
bash
Copy code
mvn test -Dtest=UITestSuite
Project Structure
The project structure is organized as follows:

src/main/java: Contains the main Java source files.
src/test/java: Contains the test source files.
api: Contains API test cases and related utilities.
ui: Contains UI test cases and page objects.
resources: Contains additional resources such as test data or configuration files.
Feel free to explore the code and test cases to understand how the automation framework is implemented.

This project is maintained by David Kuchukhidze. For any questions or feedback, please contact untouchamp@gmail.com.
