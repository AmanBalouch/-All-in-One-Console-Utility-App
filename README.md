📌 All-in-One Console Utility App (Java)
This is a Java-based console application built as a Programming Fundamentals Semester Project.
It integrates multiple utilities into a single app, providing user authentication (sign-up/login) and tools like a calculator, converter, games, area calculations, file handling, and more.
✨ Features
🔑 Authentication
Sign Up
Create an account with a custom password (must meet strength rules).
Or generate a secure auto-password.
Login → Access with credentials stored in passwords.txt.
Credentials & user history are securely saved in text files.
🛠 Utilities
🧮 Calculator – Perform arithmetic operations.
🔄 Converter – Convert values (units, currency, etc.).
🎮 Games – Play mini console games.
📏 Area Calculator – Calculate areas of geometric shapes.
📂 File Handling – Demonstration of file read/write.
✅ Checker – Input validation & logic checks.
📜 History Viewer – See your usage history from History.txt.
🚪 Exit Option – Safely close the program.
📂 Project Structure
FinalProject.java    # Main entry point
Calculator.java      # Calculator module
Converter.java       # Converter module
Games.java           # Games module
AreaCalculator.java  # Area calculator module
lastLab.java         # File handling module
Checker.java         # Checker module
passwords.txt        # Stores user credentials
History.txt          # Stores user activity log
README.md            # Documentation
🔒 Password Rules
✔ Minimum 8 characters long
✔ At least 1 uppercase letter
✔ At least 1 lowercase letter
✔ At least 1 digit
✔ At least 1 special character
💡 Alternatively → The system can auto-generate a secure password.
▶️ How to Run
Compile the project
javac FinalProject.java
Run the program
java FinalProject
Sign Up / Log In
Enter 1 → Sign up (create an account).
Enter 2 → Log in (existing account).
Choose from Main Menu
Options 1–7 → Utilities
Option 8 → Exit
📖 History Management
Every action is recorded in History.txt.
Users can review past actions like calculator, games, or conversions.
Sessions are separated with:
-------------------------------------------------------------------
🚀 Future Enhancements
Add scientific & matrix calculators.
Extend converter (temperature, currency API, etc.).
Add more mini games.
Upgrade UI using Swing/JavaFX.
👨‍💻 Author
Developed as a Programming Fundamentals Semester Project
By: Dur Muhammad Khan✨
