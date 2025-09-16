Android Application: Flight Booking App

This project is a mobile application developed in Android Studio that simulates an airline reservation system. The app features a two-activity structure: a data entry form for flight information and a confirmation page to display a summary of all submitted reservations. It demonstrates proficiency in user interface design, data persistence using ArrayList, and managing the Android activity lifecycle to ensure a seamless user experience.

Technical Stack

Languages: Java/Kotlin

Development Environment: Android Studio

Core Concepts: Activities, ConstraintLayout, ScrollView, Intent with Extra Data, ArrayList, UI Controls, Resource Files (strings.xml, colors.xml), Activity Lifecycle Management

UI Controls: EditText, Spinner, Button, and others

Core Features

Data Entry Form: The app's first activity features a data entry form for an airline reservation. It includes at least five pieces of information, input using a minimum of three different controls.

Dynamic Data Storage: Submitted form information is stored in an ArrayList. This demonstrates the ability to manage and persist data within the application's memory.

Calculated Field: The display activity includes at least one field that is the result of a calculation, such as the total price of add-ons or upgrades for a reservation.

Interactive Buttons: The form includes a "Submit" button that launches the second activity and a "Reset" button that clears all form fields and the ArrayList.

Data Display: The confirmation activity receives the ArrayList data via an Intent object and displays the information from all submitted forms in a single view.

Responsive Layout: The app uses ConstraintLayout to manage the positions and colors of layouts and widgets. Both activities are placed within a 

ScrollView to handle long forms, and the app correctly restarts with current data when the device is rotated.

Resource Management: All strings and colors are defined in XML resource files (strings.xml and colors.xml), ensuring clean and maintainable code.

Object-Oriented Design & Implementation

This project was a comprehensive exercise in applying key Android development concepts. It showcases the use of multiple activities, passing data between them using 

Intent objects, and managing the application's state across device rotations. By using an 

ArrayList to store form data, the application efficiently handles and displays multiple submissions. The choice of 

ConstraintLayout demonstrates a modern and flexible approach to UI design, avoiding the ten-point deduction associated with LinearLayout. The app is built with code headers and comments for clarity and follows best practices for a well-documented project.

Future Enhancements

Implement a login feature to save and retrieve past reservations.

Add a feature for users to edit or cancel a reservation.

Integrate with a real-time API to fetch live flight data.
