# 📱 Selenium Saucedemo Mobile Automation

This repository contains a mobile automation testing framework for the My Demo App (Saucedemo Android) application using Appium, TestNG, and Maven. It demonstrates how to set up, inspect, and write automated UI tests for Android apps — including environment setup, locator inspection with Appium Inspector, and sample test execution.  

## ✨ Features

- 📱 Android Virtual Device (AVD) or real device support
- 🤖 Appium & Appium Inspector integration for element inspection
- 🧪 Base Test implemented with TestNG
- 🧱 Page Object Model (POM) structure ready for scalable test suites
- 🔍 Sample test: verifies login functionality on My Demo App
- ⚙️ Maven project with easy dependency management

## 📦 Prerequisites

Before running the tests, make sure you have the following installed:

- **Java JDK** (17 or higher recommended)
- **Android Studio** (for AVD creation)
- **Appium** (latest stable version)
- **Appium Inspector**
- **Maven**
- **IntelliJ IDEA** or **Eclipse** (IDE of your choice)

## 🚀 Setup

1. **Clone the repository**  
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```
2. **Start an Android Virtual Device (AVD)**
   - Open Android Studio → Device Manager → Launch a virtual device.
   - Or connect a real Android device with USB debugging enabled.
3. **Launch Appium Server.**
   ```bash
   appium --base-path /wd/hub
    ```
4. **Open Appium Inspector**
   - Configure the desired capabilities for your emulator or device: 
     ```json 
     {
        "platformName": "Android",
        "automationName": "UiAutomator2",
        "deviceName": "emulator-5554",
        "appium:app": "./apks/mda-2.2.0-25.apk"
     }
     ```
   - (✅ Tip: Use a relative path like ./apks/... instead of a full C:\\... path so it works across machines.)
   - Start a session and use the inspector to locate UI elements for your tests.
5. **Run the Base Test.**
    - Open BaseTest.java (or your test class) in your IDE.
    - Click Run ▶️ or right-click and select Run to execute the test.
   
## Project Structure
```css
src/
├── apks/
│    └── mda-2.2.0-25.apk
├── main/
│    └── java/
│         ├── pages/       # Page Object classes (e.g., LoginPage)
│         └── utils/       # Helper classes (WebDriverFactory, ExcelUtil, etc.)
└── test/
     ├── java/
     │     ├── listeners/   # TestNG listeners (TestListener)
     │     └── tests/       # Test classes (LoginTest)
     └── resources/         # Test data files (Excel, CSV)
           └──testdata/
```
BaseTest.java – Contains the initial test case that checks the app logo and name.

## Future Work
- Add more comprehensive test cases for app functionality
- Integrate with CI/CD pipelines
- Add cross-device and cross-platform support

## Notes
This is a personal project for learning and experimentation with mobile automation testing.
