Drinks Shop Mobile App

Drinks Shop is a mobile application designed to manage and streamline the operations of a multi-branch drinks shop. With a central branch handling distribution and restocking for all the branches, the app ensures efficient inventory and supply chain management. The app was built in Java using Android Studio, with Firestore as the backend database and Firebase Authentication for user management.

Features

Centralized control for managing inventory and restocking across multiple branches.
User authentication using Firebase Auth.
Real-time data synchronization with Firestore.
Tested on physical devices and Android Virtual Devices (AVDs) for seamless performance.
Setup and Installation
To set up the project on your local machine, follow these steps:

Prerequisites

Android Studio installed on your computer. Download it from here.
A Google Firebase account with Firestore and Firebase Auth enabled.
A physical Android device (optional) or an Android Virtual Device (AVD) for testing.

Steps

Clone the repository:
bash
Copy
Edit
git clone https://github.com/ddalizu/Drinks-Shop-Mobile-App.git
Open the project in Android Studio:
Launch Android Studio.
Select File → Open and navigate to the cloned project folder.

Configure Firebase:

Download the google-services.json file from your Firebase console.
Place the file in the app/ directory of the project.
Sync the project with Gradle:
Click the Sync Now button in Android Studio to ensure all dependencies are installed.

Run the application:

Connect a physical device or set up an AVD in Android Studio.
Click the Run button or press Shift + F10 to build and run the app.
Testing
The app has been tested on:
Multiple Android Virtual Devices (AVDs).
A physical Android phone to ensure real-world usability.

Technologies Used

Java: Core language for building the app.
Android Studio: Development environment.
Firestore: Backend database for real-time data synchronization.
Firebase Auth: User authentication and management.

License
This project is licensed under the MIT License. See the LICENSE file for more details.
