# Advanced Java Practice Project

This repository contains a collection of advanced Java programs and mini-projects, focusing on GUI development (Swing), database connectivity (JDBC), JavaBeans, and MVC architecture. The code is organized into several directories, each demonstrating different Java concepts and best practices.

## Table of Contents
- [Project Structure](#project-structure)
- [Features](#features)
- [Setup & Requirements](#setup--requirements)
- [How to Run](#how-to-run)
- [Directory Overview](#directory-overview)
- [License](#license)

---

## Project Structure

```
advance_java/
├── datebaseMVC/      # MVC pattern with database CRUD using Swing
├── practice_q/       # Practice questions: JDBC, table creation, data insertion, queries
├── Java_bean/        # JavaBeans, introspection, persistence, bound properties
├── SampleGraphics.java         # Drawing shapes with Java2D
├── MySqlConnectionExample.java # Simple MySQL JDBC connection
├── PanelTest.java              # Swing panel and layout demo
├── GridBagLayoutExample.java   # GridBagLayout usage in Swing
├── InitialFrame.java           # User login form with Swing
├── MouseAdapterTest.java       # MouseAdapter class example
├── MouseEventHandling.java     # Mouse event handling in Swing
├── FontsAndImage.java          # Using fonts and images in Swing
```

## Features
- **Swing GUI**: Multiple examples of building user interfaces with Java Swing.
- **JDBC**: Database connectivity with MySQL, including table creation, data insertion, and queries.
- **MVC Architecture**: Example of Model-View-Controller pattern for user data management.
- **JavaBeans**: Demonstrates JavaBean conventions, introspection, persistence, and property change support.
- **Event Handling**: Mouse and button event handling in GUI applications.
- **Graphics**: Drawing shapes and displaying images in Java.

## Setup & Requirements
- **Java JDK**: 8 or higher
- **MySQL**: Running MySQL server (for database examples)
- **MySQL JDBC Driver**: Add `mysql-connector-java` to your classpath
- **IDE**: (Optional) Eclipse, IntelliJ IDEA, or NetBeans for easier GUI development

## How to Run
1. **Clone the repository**
   ```sh
   git clone <repo-url>
   cd advance_java
   ```
2. **Compile the Java files**
   ```sh
   javac -cp .;path/to/mysql-connector-java.jar <JavaFile>.java
   ```
3. **Run the desired program**
   ```sh
   java -cp .;path/to/mysql-connector-java.jar <MainClass>
   ```
   - For GUI programs, the main class is usually the file with a `main` method (e.g., `InitialFrame`, `PanelTest`, etc.)
   - For database programs, ensure your MySQL server is running and credentials in the code match your setup.

## Directory Overview

### 1. `datebaseMVC/`
Implements a user management system using the MVC pattern with Swing and MySQL. Features:
- User form for data entry (name, email, height, phone)
- Data validation and feedback
- List and update users
- Database connection and CRUD operations

**Main entry:** `datebaseMVC/MainClass.java`

### 2. `practice_q/`
Practice programs for:
- Creating tables in MySQL
- Inserting and viewing student data
- Simple JDBC connection management

**Main entry:** `practice_q/MainClass.java`

### 3. `Java_bean/`
Examples of JavaBeans, including:
- Bean properties and serialization
- Introspection (analyzing bean properties at runtime)
- Bound and vetoable properties

**Main entry:** `Java_bean/MainClass.java`

### 4. Standalone Java Files
- **SampleGraphics.java**: Draws shapes (rectangles, ovals, polygons) using Java2D.
- **PanelTest.java**: Demonstrates use of panels and layouts in Swing.
- **GridBagLayoutExample.java**: Shows advanced layout management.
- **InitialFrame.java**: User login form with validation and event handling.
- **MouseAdapterTest.java**: Basic MouseAdapter subclass.
- **MouseEventHandling.java**: Handles mouse events to change background color.
- **FontsAndImage.java**: Displays custom fonts and images in a Swing window.
- **MySqlConnectionExample.java**: Simple example of connecting to MySQL using JDBC.

## License
This project is for educational purposes. Feel free to use and modify the code for your own learning. 