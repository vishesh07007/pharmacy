# Sunrise Pharmacy Management Web Application : <br>

> A modern Spring Boot web application for managing a small pharmacy / medical store — medicines, customers, and prescription requests — with a clean, responsive UI built using Thymeleaf.


## Project Description : Sunrise Pharmacy Management

The **Sunrise Pharmacy Management** web application is a focused tool designed to help a pharmacy streamline day‑to‑day operations.  
It provides a simple, intuitive interface for managing medicine inventory, customer details, and prescription requests, making it easier to serve patients quickly and accurately.


## Features

- **Home & Marketing Pages**
  - Modern landing page with quick actions for prescriptions, inventory, and customers.
  - Informational pages: `Home`, `About`, and `Contact`.

- **Medicine Inventory Management**
  - Add, edit, and delete medicines.
  - Track details like name, description, manufacturer, category, price, and stock quantity.
  - Low‑stock view for medicines with critically low inventory.
  - Search medicines by name.

- **Customer Management**
  - View all registered customers.
  - Store customer name, phone, email, and address.
  - Search for customers by phone number.

- **Prescription Requests (Model in place)**
  - Domain model for prescriptions including:
    - Customer name and phone.
    - Uploaded prescription image path.
    - Preferred pickup time.
    - Status (e.g. `PENDING`).
    - Notes and timestamps.
  - UI hooks and routes ready for upload and workflow screens (implementation can be extended).

- **Technology & Developer Experience**
  - Built with **Spring Boot 3.5.x** and **Maven**.
  - Uses **Thymeleaf** templates for rich, dynamic pages.
  - Uses **Spring Data JPA** with **MySQL** for persistence.
  - **Lombok** for concise entity and model code.
  - Hot reload support via **Spring Boot DevTools**.


## Technologies Used

- **Backend**
  - Spring Boot `3.5.5`
  - Spring Web (REST & MVC)
  - Spring Data JPA

- **Frontend**
  - Thymeleaf template engine
  - HTML5, CSS3, Bootstrap‑style components and icons

- **Database**
  - MySQL (relational database)
  - Hibernate / JPA for ORM

- **Build & Tooling**
  - Maven
  - Lombok
  - Spring Boot DevTools

- **IDE / Tools**
  - Compatible with Spring Tool Suite (STS), IntelliJ IDEA, Eclipse, or any Maven‑capable IDE.


## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/pharmacy.git
cd pharmacy
```

> Replace `your-username` and repository name with your actual GitHub details if different.


### 2. Import into Your IDE

In **STS / Eclipse**:
- `File` > `Import...`  
- `Maven` > `Existing Maven Projects`  
- Browse to the `pharmacy` project folder and click **Finish**.

In **IntelliJ IDEA**:
- `File` > `New` > `Project from Existing Sources...`  
- Select the `pom.xml` file and open as a Maven project.


### 3. Configure the Database

The application uses MySQL. Update `src/main/resources/application.properties` with your own database settings:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/medical_store_db?serverTimezone=UTC
spring.datasource.username=YOUR_DB_USERNAME
spring.datasource.password=YOUR_DB_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080
spring.application.name=pharmacy
```

- Create the database manually in MySQL (e.g. `CREATE DATABASE medical_store_db;`) or use your preferred name and update the URL.
- Tables are created automatically on startup via `spring.jpa.hibernate.ddl-auto=update`.


### 4. Build and Run the Application

Run using **Maven**:

```bash
mvn spring-boot:run
```

Or run the main class directly from your IDE:

- Main class: `com.sunrise.pharmacy.PharmacyApplication`
- Right‑click on the class or project > `Run As` > `Spring Boot App`.

Once started, open the application in your browser:

```text
http://localhost:8080/
```


## Application Structure & Key Endpoints

- **Home & Info Pages**
  - `GET /` → Home page (`home.html`)
  - `GET /about` → About page (`about.html`)
  - `GET /contact` → Contact page (`contact.html`)

- **Medicines**
  - `GET /medicines` → List all medicines
  - `GET /medicines/add` → Show form to add a new medicine
  - `POST /medicines/add` → Save a new medicine
  - `GET /medicines/edit/{id}` → Edit existing medicine
  - `POST /medicines/edit/{id}` → Update existing medicine
  - `GET /medicines/delete/{id}` → Delete a medicine
  - `GET /medicines/search?keyword=...` → Search medicines by name
  - `GET /medicines/low-stock` → View low‑stock medicines

- **Customers**
  - `GET /customers` → List all customers
  - `GET /customers/register` → Register a new customer (save and redirect)
  - `GET /customers/search?phone=...` → Search customer by phone number

- **Prescriptions (Model & Views prepared)**
  - Prescriptions are represented by the `Prescription` entity with fields for customer, image path, pickup time, status, notes, and timestamps.
  - UI templates exist for listing and uploading prescriptions, and for status tracking; the controller logic can be extended to complete the full workflow.


## Preview (Pages & Modules)

You can add screenshots here once you upload them to your repository or an image host (e.g. GitHub assets, Imgur):

- **Home / Dashboard** – Hero section, quick actions for pending orders, low stock, and new customers.
- **Medicine Inventory** – Table view with search, stock indicators, and edit/delete actions.
- **Customers** – Table of customers with contact details and registration link.
- **Prescriptions** – List of prescription requests with status badges and actions (designed in templates).
- **Error Page** – Custom error layout for a better user experience.

Example markdown block for a screenshot (replace with your real URLs):

```markdown
![home](https://your-image-url-here/home.png)
```


## Future Improvements (Ideas)

- Complete the full prescription upload and processing workflow (file storage, validation, status transitions).
- Add authentication and role‑based access (e.g. Admin vs. Staff).
- Generate printable invoices and basic sales reports.
- Add pagination and advanced filtering for large medicine/customer lists.


## License

This project is for learning and demonstration purposes. You can adapt it for your own experiments or as a starting point for a real pharmacy system. Add a formal license (e.g. MIT) if you plan to publish it publicly.

