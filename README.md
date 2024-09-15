Car Rental System
=================

Overview
--------

This is a Car Rental System implemented using Java technologies. It features both a web-based interface using Servlets and JSP, and a desktop application using Swing. The system utilizes MySQL for database management and follows the MVC (Model-View-Controller) architecture.

Features
--------

*   **Web Interface**: Built with Servlets and JSP for managing car rentals via a browser.
    
*   **Desktop Application**: Built with Swing for a standalone desktop experience.
    
*   **Database**: Uses MySQL for storing and managing data.
    
*   **MVC Architecture**: Separates data (Model), user interface (View), and application logic (Controller) for better organization and maintainability.
    

Technologies Used
-----------------

*   **Java Servlet API**: For handling HTTP requests and responses on the web.
    
*   **JSP (JavaServer Pages)**: For rendering dynamic web content.
    
*   **Swing**: For creating the desktop UI.
    
*   **MySQL**: For database management.
    
*   **MVC Architecture**: To separate concerns and enhance code structure.
    

Getting Started
---------------

### Prerequisites

*   Java Development Kit (JDK) 8 or higher
    
*   Apache Tomcat or any other Java Servlet container
    
*   MySQL Database Server
    
*   IDE like Eclipse or IntelliJ IDEA (optional)
    

### Setting Up the Database

1.  Create a MySQL database and user for the car rental system.
    
2.  bashCopy codemysql -u \[username\] -p \[database\_name\] < schema.sql
    

### Web Application Setup

1.  Deploy the car-rental-web WAR file to your servlet container (e.g., Apache Tomcat).
    
2.  Configure the database connection in web.xml or a properties file.
    

### Desktop Application Setup

1.  Open the car-rental-desktop project in your Java IDE.
    
2.  Ensure that the MySQL JDBC driver is included in your classpath.
    
3.  Run the CarRentalDesktopApp class to start the desktop application.
    

Usage
-----

### Web Interface

1.  Open your web browser and navigate to http://localhost:8080/car-rental-web.
    
2.  Use the provided forms to manage car rentals, view available cars, and process bookings.
    

### Desktop Application

1.  Launch the desktop application.
    
2.  Use the GUI to manage rentals, view car details, and perform other actions.
    

Contact
-------

For any questions or feedback, please reach out to \[your email address\].

Feel free to adjust the details as needed to match your specific project setup and requirements!
