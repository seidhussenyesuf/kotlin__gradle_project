# Library Management System - Kotlin Exercise

##  Project Overview

This project is a simple **Library Management System** implemented in Kotlin. It serves as a hands-on exercise to practice Kotlin fundamentals and Gradle build tool basics. The code is intentionally incomplete - your task is to complete the implementation by following the application behavior.

---

##  Learning Objectives

- Understand **Gradle** as a build tool (essential for Android development)
- Practice **Kotlin** core language concepts
- Navigate and complete an existing codebase
- Build and run executable JAR files

---

##  Prerequisites & Setup

### 1. **Learn Gradle Basics**
Gradle is the build tool we'll use throughout Android development. Complete the beginner tutorial:
- [Gradle Getting Started Guide](https://docs.gradle.org/current/userguide/part1_gradle_init.html)

> ⚠️ **Note**: Download the latest Gradle version and practice in a separate project before returning to this one.

### 2. **Master Kotlin Fundamentals**
Choose your learning path:

**Option A - Google's Android Pathway (Recommended for beginners):**
- [Android Basics in Kotlin - Unit 1](https://developer.android.com/courses/pathways/android-basics-compose-unit-1-pathway-1)

**Option B - Official Kotlin Documentation:**
- [Kotlin Getting Started Guide](https://kotlinlang.org/docs/getting-started.html)

**Minimum Requirements:** Understand concepts covered in class + Chapter 3 materials.

---



## 🎮 Your Task

### **Primary Goal**
Complete the missing implementation by:

1. **Run the provided JAR** to see how the application should behave:
   ```bash
   java -jar app.jar
   ```
   Observe all features and workflows.

2. **Navigate to the entry point**: `ConsoleApp.kt`

3. **Fill in all the blanks** (`TODO` sections) to make your code produce the same behavior as the runnable JAR.

---

## 🚀 How to Build & Run

### **Build the Project**
```bash
# Clean and build
./gradlew clean build

# Create runnable JAR
./gradlew jar

# Create distribution package
./gradlew distZip
```

### **Run the Application**
```bash
# Option 1: Run directly with Gradle
./gradlew run

# Option 2: Run the JAR file
java -jar build/libs/app.jar

# Option 3: Run from distribution
./gradlew distZip
cd build/distributions/
unzip app.zip
cd app/bin
./app  # (or app.bat on Windows)
```

---

## ✅ Expected Features (What the completed app should do)

When complete, the application should:

- 📖 **Add books** to the library (ISBN, title, author, year)
- 👤 **Register patrons** (ID, name, email, phone)
- 📤 **Borrow books** (with availability and limit checks)
- 📥 **Return books**
- 🔍 **Search books** by title or author
- 📋 **List all books** (available/borrowed status)
- 👥 **View all patrons** and their borrowed books

---

## 📝 Implementation Notes

- The code follows a layered architecture:
  - `model/` - Data classes (already complete)
  - `repository/` - Data access interface (to be implemented)
  - `service/` - Business logic (to be completed)
  - `ui/` - Console interface (already complete)

- Focus on implementing the missing parts in:
  - `InMemoryRepository.kt`
  - `DefaultLibraryService.kt`

- Use the runnable JAR as your **specification** - match its behavior exactly

---

## 🆘 Getting Help

If stuck:
1. Review the Kotlin learning materials
2. Check Gradle documentation
3. Run the provided JAR to understand expected behavior
4. Ask questions in group


---
# submission instruction

- Fork the Repository
- Clone and Work on the Code
- Commit Your Changes and Push to Your Fork
