# 🧑‍🎓Student Information Management App

## Description
This project demonstrates the use of **Google Firebase Firestore** to develop a **Realtime Student Information Management Application**. The app provides functionalities for managing users, student records, and certificates while supporting data import/export operations. It is designed with role-based access control to ensure secure and efficient management of student information.

---

## 🗝️Key Features
1. **User Account Management**:
   - User login and profile updates.
   - Role-based access control (Admin, Manager, Employee).
   - View, add, update, and delete user accounts.
   - View login history for users.

2. **Student Management**:
   - Add, update, delete, and view student records.
   - Sort and search student lists based on multiple criteria.
   - Manage detailed student profiles, including a list of certificates.

3. **Certificate Management**:
   - Add, update, delete, and view certificates.
   - Link certificates to specific students.

4. **Data Import/Export**:
   - Import/export student and certificate data in Excel/CSV formats.

5. **Role-Based Permissions**:
   - Admin: Full access to all features.
   - Manager: Full access to student-related functionalities.
   - Employee: Read-only access with the ability to update their profile picture.

---

## ⚙️Technologies Used
- **Frontend**: Android XML for UI Design.
- **Backend**: Google Firebase Firestore for real-time database operations.
- **Authentication**: Firebase Authentication.
- **Data Import/Export**: CSV/Excel file handling.

---

## Installation Instructions
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/pkucpkam/student-hub-mobile-app.git
   ```

2. **Open in Android Studio**:
   - Open Android Studio.
   - Select "Open an Existing Project" and navigate to the cloned repository.

3. **Setup Firebase**:
   - Create a Firebase project in the [Firebase Console](https://console.firebase.google.com/).
   - Add an Android app to the project and download the `google-services.json` file.
   - Place the `google-services.json` file in the `app/` directory of the project.

4. **Build the Project**:
   - Sync Gradle files.
   - Resolve any dependency issues.

5. **Run the Application**:
   - Connect an Android device or use an emulator.
   - Click "Run" to deploy the application.

---

## Usage
- **Login**:
  - Use the following credentials for testing:
    - Admin: 
      - Username: `a@a.com`
      - Password: `123456`
    - Manager:
      - Username: `b@b.com`
      - Password: `123456`
    - Employee:
      - Username: `c@c.com`
      - Password: `123456`

- **Features**:
  - Navigate through the app to manage users, students, and certificates.
  - Import/export data through the respective menu options.

---

## Demo Video
A walkthrough of the application can be accessed via the following link:
[Demo Video](https://www.youtube.com/watch?v=sAt_ONX6kqk)

---

## 🧑‍💻Author
* [Võ Nhật Hào](https://github.com/nhathao512)

* [Phạm Văn Phúc](https://github.com/pkucpkam)

---

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE.md) file for more details.

---

## Notes
- Ensure that the Firebase project is configured correctly before running the app.
- The provided accounts are for demo purposes only; please create new accounts for production use. 
- Refer to the report for detailed documentation on the app's development process.
