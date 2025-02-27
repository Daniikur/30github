CI/CD Pipeline with GitHub Actions and Jenkins for Java Projects
This repository provides a comprehensive guide to setting up a Continuous Integration and Continuous Deployment (CI/CD) pipeline for Java applications using GitHub Actions and Jenkins. The pipeline automates building, testing, and deploying Java applications, ensuring efficient and reliable software delivery.

Table of Contents
Overview
Prerequisites
Setup Instructions
1. Install Jenkins on Ubuntu
2. Configure Jenkins
3. Set Up GitHub Actions Workflow
4. Create a Jenkins Pipeline Job
Usage
Contributing
Overview
This project demonstrates the integration of GitHub Actions and Jenkins to establish a robust CI/CD pipeline for Java applications. By leveraging both tools, developers can achieve seamless automation from code commit to deployment.

Prerequisites
Operating System: Ubuntu 20.04 or later
Java Development Kit (JDK): OpenJDK 17
Maven: Build automation tool for Java projects
Git: Version control system
GitHub Account: To host your repository
Jenkins Server: Installed on your Ubuntu machine
Setup Instructions
1. Install Jenkins on Ubuntu
Update System Packages:
sudo apt update && sudo apt upgrade -y
Install Java: Jenkins requires Java to run.



sudo apt install openjdk-17-jdk -y
Add Jenkins Repository:
curl -fsSL https://pkg.jenkins.io/debian/jenkins.io.key | sudo tee \
/usr/share/keyrings/jenkins-keyring.asc > /dev/null
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
https://pkg.jenkins.io/debian binary/ | sudo tee \
/etc/apt/sources.list.d/jenkins.list > /dev/null

Install Jenkins:
sudo apt update
sudo apt install jenkins -y
Start and Enable Jenkins:
sudo systemctl start jenkins
sudo systemctl enable jenkins

2. Configure Jenkins
Access Jenkins: Open a browser and navigate to http://localhost:8080.

Unlock Jenkins: Retrieve the initial admin password:
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
Enter this password on the Jenkins setup page.

Install Suggested Plugins: Follow the on-screen instructions to install the recommended plugins.

Create Admin User: Set up your admin user credentials as prompted.

Configure Tools:

Maven: Install Maven on your system:
sudo apt install maven -y
In Jenkins, navigate to Manage Jenkins > Global Tool Configuration and add Maven.

Git: Ensure Git is installed:
sudo apt install git -y

3. Set Up GitHub Actions Workflow
Define the Workflow File: In your repository, create .github/workflows/ci-cd.yml with the following content:

name: CI/CD Pipeline

on:
  push:
    branches:
      - main

jobs:
  build:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Code
        uses: actions/checkout@v3

      - name: Set Up JDK 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Build with Maven
        run: mvn clean package

      - name: Deploy to Jenkins
        run: |
          curl -X POST http://localhost:8080/job/YOUR_JENKINS_JOB_NAME/build \
          --user "admin:YOUR_JENKINS_PASSWORD"
Replace YOUR_JENKINS_JOB_NAME with your Jenkins job name and YOUR_JENKINS_PASSWORD with your Jenkins admin password.
4. Create a Jenkins Pipeline Job
Create a New Pipeline Job: In Jenkins, select New Item, enter a name, choose Pipeline, and click OK.

Configure Pipeline:

Pipeline Definition: Choose Pipeline script from SCM.
SCM: Select Git and provide your repository URL.
Script Path: Ensure it points to your Jenkinsfile.
Save and Build: Save the configuration and trigger a build to test the setup.

Usage
After completing the setup:

Code Changes: Push changes to the main branch of your GitHub repository.

Automated Pipeline: The GitHub Actions workflow triggers:

Builds the project using Maven.
Deploys the build to Jenkins for further processing.
Continuous Deployment: Jenkins handles deployment to your specified environment upon successful builds.

Contributing
Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.