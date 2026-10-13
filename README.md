# CS 320 Software Testing Portfolio
### Eric Long
Southern New Hampshire University

## Overview

This repository contains artifacts from CS 320: Software Testing, which focused on software quality, automation, unit testing, and validation of software requirements.

### Included Artifacts

#### Project One
Contact Service Files:
- Contact.java
- ContactService.java
- ContactTest.java
- ContactServiceTest.java

#### Project Two
- Summary and Reflections Report

These artifacts demonstrate my ability to:
- Develop and test software based on requirements
- Create and execute JUnit tests
- Apply software testing techniques
- Measure and evaluate test coverage
- Identify and prevent software defects
- Practice quality assurance and validation

---

# Reflection

## How can I ensure that my code, program, or software is functional and secure?

I ensure that software is functional and secure by developing tests directly from the project requirements and validating both expected and unexpected inputs. Throughout this course, I used JUnit testing to verify that objects and services behaved correctly and rejected invalid data. I created positive-path tests, negative-path tests, and boundary-value tests to exercise critical code paths. I also used code coverage tools to identify areas that were not being tested. My final test suite achieved 86% instruction coverage, helping me confirm that important functionality was being executed during testing. Testing early and frequently helps identify defects before software is released and reduces the risk of security and reliability issues.

## How do I interpret user needs and incorporate them into a program?

I begin by analyzing the requirements and identifying the rules that the software must enforce. Once the requirements are understood, I translate them into program features and corresponding test cases. For example, the Contact, Task, and Appointment services each contained specific validation requirements for IDs, names, dates, and descriptions. I created tests that directly reflected those requirements to ensure the software behaved as the user expected. Writing tests alongside development helped verify that user needs were implemented correctly and remained functional as the software evolved.

## How do I approach designing software?

I approach software design by breaking the problem into smaller, manageable components and defining clear responsibilities for each class. In this course, I separated data objects from service classes, allowing validation logic and business operations to remain organized and maintainable. I then developed tests to validate each component independently before testing service behavior. This approach supports modular design, improves readability, simplifies debugging, and makes future enhancements easier to implement. Designing with testing in mind also helps reduce technical debt and improves long-term software quality.

---

## Skills Demonstrated

- Java Programming
- Object-Oriented Design
- Unit Testing with JUnit 5
- Software Validation
- Boundary Value Analysis
- Equivalence Partitioning
- Test Coverage Analysis
- Quality Assurance
- Debugging and Defect Prevention
- GitHub Version Control
