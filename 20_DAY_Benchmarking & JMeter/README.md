# Advanced Java Performance Benchmarking with JMeter

This repository contains a step-by-step guide to using [Apache JMeter](https://jmeter.apache.org/) for performance testing Java backend applications. It is part of a 30-day advanced Java learning plan focused on backend development, performance optimization, and modern Java features.

## Table of Contents
- [Overview](#overview)
- [Installation](#installation)
- [Usage](#usage)
  - [Running JMeter in GUI Mode](#running-jmeter-in-gui-mode)
  - [Running JMeter in Non-GUI Mode](#running-jmeter-in-non-gui-mode)
- [Test Plan Example](#test-plan-example)
- [Generating and Viewing Reports](#generating-and-viewing-reports)
- [Next Steps](#next-steps)
- [Contributing](#contributing)
- [License](#license)

## Overview

This guide explains how to set up and run performance tests for your Java backend using JMeter. You will learn:
- How to download and set up JMeter.
- How to create a basic test plan using the JMeter GUI.
- How to run tests in non-GUI mode and generate an HTML report.
- How the output is structured and what key metrics to look for.

## Installation

1. **Download Apache JMeter:**
   - Download the latest version (e.g., `apache-jmeter-5.6.3.zip`) from the [official download page](https://jmeter.apache.org/download_jmeter.cgi).

2. **Extract the Archive:**
   ```bash
   unzip apache-jmeter-5.6.3.zip -d apache-jmeter

3. **Navigate to the JMeter bin Directory:**
  - cd apache-jmeter/apache-jmeter-5.6.3/bin

4. **Ensure Java is Installed:**  
  - java -version


## Usage
Running JMeter in GUI Mode

1. **Start the JMeter GUI:**
 - ./jmeter
2. **Create a Test Plan:**
- Add a Thread Group: Right-click on Test Plan → Add → Threads (Users) → Thread Group.
- Configure the Thread Group: Set the number of threads (users), ramp-up period, and loop count.
- Add an HTTP Request Sampler: Right-click on Thread Group → Add → Sampler → HTTP Request. Configure the server (e.g., localhost), port (e.g., 8080), and endpoint path (e.g., /api/v1/users).
- Add Listeners: Right-click on Thread Group → Add → Listener → View Results Tree and Summary Report for monitoring test results.

3. **Run the Test: Click the green Start button in the JMeter GUI and observe the results.**
 **Running JMeter in Non-GUI Mode**
 1. Save Your Test Plan: From the GUI, save your test plan as testplan.jmx.

2. Create an Output Folder for the Report:
Ensure the folder exists and is writable. For example:
- mkdir -p /mnt/c/Users/user/Downloads/jmeter-report

3. Run the Test from the Command Line:
- ./jmeter -n -t /mnt/c/Users/user/Downloads/testplan.jmx -l /mnt/c/Users/user/Downloads/results.jtl -e -o /mnt/c/Users/user/Downloads/jmeter-report -f

- **-n:** Runs JMeter in non-GUI mode.
- **-t:** Specifies the path to the .jmx test plan.
- **-l:** Specifies the path to save the results (in .jtl format).
- **-e:** Tells JMeter to generate the HTML dashboard report.
- **-o:** pecifies the output folder for the report.
- **-f:** Forces the output folder to be overwritten if it already exists.






