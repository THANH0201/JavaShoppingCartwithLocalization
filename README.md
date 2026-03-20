# Java Shopping Cart with Localization

A Java console application that calculates the total cost of items in a shopping cart and supports multilingual output (English, Finnish, Swedish, Japanese). The project includes unit tests, Docker containerization, and a Jenkins CI/CD pipeline.

---

##  Overview

This application allows users to:

- Select a preferred language (EN / FI / SV / JP)
- Enter the number of items
- Provide price and quantity for each item
- Calculate total cost per item and total cart cost
- Run inside a Docker container
- Build and test automatically using Jenkins:
    - Maven build
    - Unit testing
    - JaCoCo coverage generation
    - Docker image build
    - Docker Hub push
    - The pipeline is configured to run automatically using GitHub SCM.
All text output uses UTF‑8 encoding and Java ResourceBundle localization.

---

##  Running the Application with Docker Desktop

You can run this application without downloading the source code.  
Just follow these steps:

### 1. Install Docker Desktop
Download and install Docker Desktop from: https://www.docker.com/products/docker-desktop/

### 2. Open a terminal (Command Prompt, PowerShell, or macOS Terminal)

### 3. Run the application using Docker Hub
Docker will automatically pull the image if it is not already on your machine:

```bash
docker run -it thanh0201/javashoppingcartwithlocalization:latest

