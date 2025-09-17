# Mobile Automation Testing Project

This repository contains the setup and initial test framework for automating Android app testing using **Appium**. It includes environment setup, basic configuration, and a base test to verify core app elements.  

## Features

- Android Virtual Device (AVD) setup for testing  
- Appium and Appium Inspector configuration  
- Base Test that validates app logo and app name  
- Foundation for building scalable automated test suites  

## Prerequisites

Before running the tests, make sure you have the following installed:

- **Java Development Kit (JDK)**  
- **Android Studio** (for AVD)  
- **Appium**  
- **Appium Inspector**  
- **Maven** or **Gradle** (if using a Java project)  
- **IDE** such as IntelliJ IDEA or Eclipse  

## Setup

1. **Clone the repository**  
   ```bash
   git clone <repository-url>
   cd <repository-folder>
2. **Start an Android Virtual Device (AVD) using Android Studio.**
3. **Launch Appium Server.**
4. **Open Appium Inspector and configure the desired capabilities for your AVD.**
```json
{
    "platformName": "Android",
    "appium:automationName": "UiAutomator2",
    "appium:deviceName": "<YourDeviceName>",
    "appium:app": "C:\\Users\\<YourUser>\\apks\\mda-2.2.0-25.apk"
}
```
5. **Run the Base Test.**

## Project Structure
```css
src/
 └── main/
      └── java/
           └── tests/
                └── BaseTest.java
```
BaseTest.java – Contains the initial test case that checks the app logo and name.

## Getting Started
1. Make sure AVD is running.
2. Start Appium Server.
   ```bash
    appium --base-path /wd/hub
3. Open BaseTest.java in your IDE.
4. Right-click the file and select Run, or use your IDE’s run button to execute the test.

## Future Work
- Add more comprehensive test cases for app functionality
- Integrate with CI/CD pipelines
- Add cross-device and cross-platform support

## Notes
This is a personal project for learning and experimentation with mobile automation testing.
