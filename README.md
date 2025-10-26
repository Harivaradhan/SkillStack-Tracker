🎯 SkillStack Tracker Backend

This is the Java (J2EE + JDBC) backend for the SkillStack Tracker project. It provides REST APIs to manage skills (CRUD operations) which are consumed by the React frontend.



🛠️ Tech Stack

Java 17+ ☕

J2EE Servlets (Jakarta Servlet API)

JDBC (MySQL database)

MySQL 8+ 🐬




📌 Prerequisites

Java Development Kit (JDK)
Install JDK 17 or above.

Eclipse IDE for Enterprise Java Developers

Make sure Eclipse is installed with Web/Java EE support.

Apache Tomcat (v9 or above)

Used as the server to run servlets.

Configure in Eclipse:

Window > Preferences > Server > Runtime Environments





MySQL Database

Create a database called skillstack 🗄️

CREATE DATABASE skillstack;
USE skillstack;

----->  CREATE TABLE skills (
    id INT AUTO_INCREMENT PRIMARY KEY,
    skill_name VARCHAR(255) NOT NULL,
    resource_type VARCHAR(255),
    platform VARCHAR(255),
    start_date DATE,
    status VARCHAR(50),
    hours_spent INT,
    notes TEXT
);





🏗️ Project Setup in Eclipse
1️⃣ Clone the Repository
git clone <your-backend-repo-url>

2️⃣ Import into Eclipse

Open Eclipse → File → Import → Existing Maven/Java Project

Select the project folder → Finish ✅

3️⃣ Configure Tomcat Server

Right-click project → Properties → Targeted Runtimes → Select Apache Tomcat

4️⃣ Configure Database Connection

Open DBConnection.java in com.skillstack.util package

Update DB URL, username, and password:

private static final String URL = "jdbc:mysql://localhost:3306/skillstack";
private static final String USER = "root";
private static final String PASSWORD = "yourpassword";

▶️ Run the Project

Right-click project → Run As → Run on Server → Select Tomcat → Finish

Tomcat will start, and your servlets will be available at:

http://localhost:8080/SkillStack/




⚡ Available API Endpoints
Action	Endpoint	Method
Add Skill	/addSkill	POST
Get All Skills	/getAllSkills	GET
Update Skill	/UpdateServlet	PUT
Delete Skill	/DeleteServlet	DELETE

💡 Tip: Make sure your frontend is running on http://localhost:3000 to avoid CORS issues.
