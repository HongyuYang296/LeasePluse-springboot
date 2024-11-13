# LeasePluse Spring Boot Backend
This repository contains the backend for the LeasePluse application, implemented in Java using the Spring Boot framework. This backend exposes RESTful APIs to perform salary package calculations based on various factors such as company type, employment type, and educational background.
## Project Structure
```bash
src
└── main
    └── java
        └── com.leasepluse.backend
            ├── config
            │   └── WebConfig.java
            ├── controller
            │   └── SalaryCalculatorController.java
            ├── model
            │   └── Employee.java
            ├── service
            │   └── SalaryPackageService.java
            └── BackendApplication.java
```
### Directory and Class Overview

- **config**: Contains configuration classes for the Spring Boot application.
  - `WebConfig.java`: Configures CORS (Cross-Origin Resource Sharing) to allow the frontend to communicate with the backend by defining allowed origins, methods, and headers.

- **controller**: Contains controller classes that define the API endpoints for the backend.
  - `SalaryCalculatorController.java`: Exposes a REST endpoint (`/api/calculate`) to calculate the salary packaging limit based on information about the employee. It accepts POST requests with employee details and returns the calculated limit.

- **model**: Contains model classes representing the application's core data structures.
  - `Employee.java`: Represents the employee data model. This class defines fields like company type, employment type, salary, hours worked, and educational background, which are used in salary package calculations.

- **service**: Contains service classes that handle the business logic.
  - `SalaryPackageService.java`: Contains the logic for calculating the salary package limit based on the employee's details, such as company type, employment type, and education level.

- **BackendApplication.java**: The main class that bootstraps and runs the Spring Boot application. It serves as the entry point for the backend.
### API Overview

#### Endpoint

- **POST /api/calculate**:
  - Accepts a JSON object representing an `Employee`.
  - Calculates the salary packaging limit based on the employee's details.
  - Returns a JSON response with the calculated limit.

#### Example Request

```http
POST /api/calculate
Content-Type: application/json
```
```json
{
  "salary": 60000,
  "companyType": "Hospital",
  "employmentType": "Full-time",
  "hoursWorked": 38,
  "isEducated": true
}
```
### Example Response
```json
{
  "calculatedLimit": 17000
}
```
### Running the Application

1. **Build the Project**: Run the following command to build the project:
   ```bash
   ./gradlew build
   ```
   
2. **Run the Application**: Start the application using one of the following commands
   - **Run directly:**
    ```bash
     ./gradlew bootRun
    ```
   - **Or run the generated JAR file:**
     ```bash
     java -jar build/libs/your-app-name.jar
     ```
3. **Access the API**: The application runs by default on port 8080. You can test the API at:
   - http://localhost:8080/api/calculate using tools like Postman.
