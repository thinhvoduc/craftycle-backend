# Craftycle 
---
Table of contents
[1. Introduction](#introduction)  
[2. Requirement](#requirements)
[3. Setup](#setup)
[4. Testing with Postman](#tesing)

## 1. Introduction
---
A Maven-based project for Craftycle Java EE backend.

## 2. Requirements
---
  * Netbeans IDE  
  * JDK 1.8+  
  * Apache Maven(Bundled in Netbeans)

## 3. Setup
---

1. Clone the project to your computer.
2. Open Netbeans, select File -> Open Project... -> Select the cloned project.
3. Open `ImageFileManager.java` in `com.categoryapp.resources.utils`.
...In `storageFilePath()` method, it currently returns `"/Users/thinh/Documents/images/"`, replace the the image directory on your machine.
...Notes: The image directory should be writeable since we are going to send images from our iOS client. And the directory should ends with `/`.
4. You need a pre-set of images to run the projects. Download the (these images)[https://drive.google.com/drive/folders/1eO9lSLOKPpmJRHhv8HprEgqXbwj5_Qa-?usp=sharing] and put them into the previous image directory you just defined.
5. Hit run and play
6. Optional. In case you are not able to deploy onto your server. Replace your server with (this one)

## 4. Testing with PostMan
---
When the project is running, fire up your Postman

1. `GET` all categories: Make a Get request to this url: `http://localhost:8080/CategoryApp/webresources/categories`.
2. `POST` a category: Make a Post request to this url: `http://localhost:8080/CategoryApp/webresources/categories`.
...In Body section, select `form-data`.
...Create `category_name` key and value for category name.
...Create `file` key, select file as its type for the value and select a random image on your machine.
...Hit Send button and your category is created. The uploaded image will be stored in the directory you defined previously.
...You would receive a successful response if you followed the previous steps correctly.
