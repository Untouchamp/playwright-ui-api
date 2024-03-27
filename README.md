# Project Showcase: Java & Playwright

This project is a showcase of how to write automated tests in Java using Playwright. It consists of two parts: API tests for a custom backend service for a todo app, and UI testing framework for a Playwright website, implemented using the Page Object Model.

## Contents
- [Overview](#overview)
- [Setup](#setup)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)

## Overview
The project demonstrates how to implement automated tests in Java for both backend APIs and frontend UIs using Playwright. It aims to showcase best practices in test automation, including using the Page Object Model for UI tests and structuring tests for maintainability and readability.

## Setup
To set up the project, follow these steps:
1. Clone the repository to your local machine.
2. Ensure you have Java and Maven installed.
3. Install the necessary dependencies using Maven.

## Running Tests
To run the tests, execute the following commands:
- For API tests:
 `mvn clean test -Ptest=APITests -DthreadCount=%test_thread_count%`
- For UI tests:
 `mvn clean test -Ptest=UITests -DthreadCount=%test_thread_count%`

## Project Structure
The project structure is organized as follows:
- `src/main/java`: Contains the main Java source files.
- `src/test/java`: Contains the test source files.
- `api`: Contains API test cases and related utilities.
- `ui`: Contains UI test cases and page objects.
- `resources`: Contains additional resources such as test data or configuration files.

Feel free to explore the code and test cases to understand how the automation framework is implemented.

---
This project is maintained by David Kuchukhidze. For any questions or feedback, please contact untouchamp@gmail.com.
