All-in-One Console Utility App (Java)
This is a Java-based console application built as a Programming Fundamentals semester project.
It integrates multiple utilities into a single app, providing user authentication (sign-up/login) and features like calculator, converter, games, area calculations, file handling, and more.
Features
Authentication
Sign Up → Create an account with either:
A custom password (must meet strength requirements).
An auto-generated secure password.
Login → Access with username and password stored in passwords.txt.
Credentials and activity history stored in text files.
Utilities
Calculator → Perform basic arithmetic operations.
Converter → Convert values (e.g., units, currency, etc.).
Games → Access mini console games.
Area Calculator → Calculate areas of geometric shapes.
File Handling → Demonstrates file reading/writing.
Checker → Input validation/logic checking module.
History Viewer → See a record of your past actions stored in History.txt.
Exit Option → Gracefully close the program.
File Structure
FinalProject.java → Main entry point of the project
Calculator.java → Calculator module
Converter.java → Converter module
Games.java → Games module
AreaCalculator.java → Area calculator module
lastLab.java → File handling module
Checker.java → Checker module
passwords.txt → Stores user credentials
History.txt → Stores user activity log
README.md → Documentation
Password Rules
Minimum 8 characters long.
Must contain:
At least 1 uppercase letter
At least 1 lowercase letter
At least 1 digit
At least 1 special character
Alternatively, the system can auto-generate a secure password.
Usage Instructions
Compile the project:
javac FinalProject.java
Run the program:
java FinalProject
Sign Up / Log In:
Choose option 1 to sign up (create an account).
Choose option 2 to log in with existing credentials.
Select Utilities from the main menu:
Enter numbers 1–7 to use a feature.
Enter 8 to exit.
History Management
Every action is recorded in History.txt.
Users can view their past actions (calculator use, conversions, etc.).
History is separated per session with a line of dashes.
Future Enhancements
Add more advanced calculators (scientific, matrix).
Extend converter with more units (temperature, currency API integration).
Add more games.
Improve UI with Swing/JavaFX.
Author
Developed as a Programming Fundamentals Semester Project
By: Dur Muhammad Khan
