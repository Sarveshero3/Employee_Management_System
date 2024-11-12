# Employee Management System

![Employee Management System](employee_group_solid_icon_235378.ico) <!-- Optional: Add a screenshot or logo -->

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Usage](#usage)
  - [Running the Application](#running-the-application)
  - [First-Time Setup](#first-time-setup)
- [Project Structure](#project-structure)
  - [Folder Overview](#folder-overview)
  - [Key Directories and Files](#key-directories-and-files)
- [Building from Source](#building-from-source)
  - [Prerequisites](#prerequisites)
  - [Terminal Commands](#terminal-commands)
- [Contributing](#contributing)
- [License](#license)

## Overview

The **Employee Management System** is a comprehensive Java-based application designed to help organizations manage their employee data efficiently. Whether you're a small business or a large enterprise, this system provides an intuitive interface to handle employee records, track positions, manage salaries, and generate detailed reports.

## Features

- **Add New Employees:** Easily add detailed employee information, including personal details, position, and salary.
- **View Employee Details:** Access comprehensive profiles of all employees.
- **Update Records:** Modify existing employee information as needed.
- **Delete Employees:** Remove employee records securely.
- **Generate Reports:** Create position count reports, salary reports, and more.
- **User Authentication:** Secure access with password protection.
- **Data Persistence:** Employee data is stored in an `EmployeeData.xlsx` file for easy access and portability.
- **Logging:** Integrated logging using Log4j2 for tracking application events and debugging.

## Usage

### Running the Application

You can run the **SynchroStaff.exe** either by using the provided Windows executable (`.exe`) or by running the .class file directly.

#### Option 1: Using the Windows Executable

1. **Locate the Executable:**
   - Navigate to the `EmployeeManagementSystem/` directory.
   - Find the `SynchroStaff.exe` file.

2. **Run the Application:**
   - Double-click on `SynchroStaff.exe` to launch the application.

#### Option 2: Running the .class file
   - Compile the Source Code

   - javac -d bin -cp ".\lib\*" src\main\Main.java src\controller\*.java src\model\*.java src\view\*.java

   - To run the program

   - java -cp ".\bin;.\lib\*" main.Main

1. **Ensure Java is Installed:**
   - Verify that Java is installed on your system. You can download it from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use the bundled JRE if available.

2. **Navigate to the Project Directory:**
   - Open your terminal or command prompt.
   - Navigate to the `EmployeeManagementSystem/target/` directory:


### First-Time Setup

Upon launching the application for the first time, you will be prompted to set up a secure password:

1. **Set Password:**
   - Enter a new password and confirm it. This password will be required for all subsequent logins to access the application.

2. **Data File Creation:**
   - After setting the password, the application will automatically create the `EmployeeData.xlsx` file in the application's directory. This file stores all employee records.

3. **Logging In:**
   - Use the password you just set to log into the application and start managing employee data.

## Project Structure

Understanding the project structure will help you navigate the source code and resources efficiently.

### Folder Overview

Getting Started
Prerequisites

    Java Development Kit (JDK) 8 or higher installed.
    Apache POI Library: Included in the lib directory.

Project Structure

EmployeeManagementSystem/
├── src/                  # Source code (.java files)
├── bin/                  # Compiled class files (.class files)
├── lib/                  # External libraries (JAR files)
├── EmployeeData.xlsx     # Employee data file (created after first run)
└── README.md             # Project documentation


## Understanding the Directories

    src/: Contains the source code organized into packages:
        main/: Contains the Main.java file which is the entry point.
        controller/: Contains controller classes.
        model/: Contains model classes.
        view/: Contains view classes.
    bin/: Contains compiled .class files mirroring the structure in src/.
    lib/: Contains external libraries required by the application (e.g., Apache POI).

## Dependencies

- The lib directory includes all the necessary JAR files:

  -  Apache POI: For handling Excel files.
  -  Log4j2: For logging purposes.
  -  Other Commons Libraries: Such as commons-io, commons-math3, etc.

Ensure that these libraries are present in the lib directory to avoid ClassNotFoundException errors.
Tips for Efficient Usage

   - Copy and Paste Commands: Use the terminal commands provided in this README to run and compile the application efficiently.
   - Maintain Directory Structure: Keep the src, bin, and lib directories as they are to avoid path issues.
   - Java Version: Make sure your Java version is compatible (Java 8 or higher).

## Common Issues

- Application Doesn't Start:
        Verify that you're in the correct directory.
        Ensure all dependencies are in the lib directory.
- Compilation Errors:
        Check that all source files are included in the javac command.
        Ensure that the classpath is set correctly.
- Password Issues:
        If you forget your password, delete the EmployeeData.xlsx file to reset the application (note: this will delete all employee data).

Contributing

Contributions are welcome! Feel free to:

    Submit pull requests for improvements.
    Report issues or bugs.

License

This project is licensed under the MIT License.
Contact

For any inquiries or support, please contact:

    Email: sarveshero7@gmail.com
    GitHub: Sarveshero3

Developed with ❤️ by Team SynchroStaff (Sarvesh, Swaraj, Kulvansh)

Thank you for using the SynchroStaff ! Your feedback is appreciated.