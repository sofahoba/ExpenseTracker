Expense Tracker
----------------

-Expense Tracker is a web application built using Spring Boot that allows users to track their income and expenses, view statistics, and manage their financial data. It uses MySQL for data storage and Postman for testing the APIs.

Features

    - Track Expenses and Income: Add, update, and view your income and expenses.
    - Statistics API: View a summary of your income and expenses over a specified period.
    - MySQL Database: Data is stored securely in a MySQL database.
    - DTO Implementation: Used Data Transfer Objects (DTO) to manage data efficiently across layers.
    - API Testing with Postman: APIs are thoroughly tested with Postman to ensure they work as expected.

Technologies Used

    - Spring Boot: For building the backend services and APIs.
    - MySQL: For data storage and management.
    - DTO (Data Transfer Object): For efficient data transfer between layers.
    - Postman: For testing and validating the APIs.
    - Maven: For managing the project dependencies.


API Endpoints::

1. Get Expenses and Income Data:-

- Endpoint: /api/stats/graph-data

         Fetches the statistics data for expenses and income over the last 5 days.

- Endpoint: /api/stats/expense/all

           Description: This endpoint fetches all expense records from the database

- Endpoint: /api/stats/expense/{id}

           Description:  This endpoint fetches expense records from the database with id = {id}
  
- Endpoint: /api/stats/income/all 

            Description: This endpoint fetches all income records from the database.

- Endpoint: /api/stats/income/{id}

            Description: This endpoint fetches income records from the database with id = {id}.
  

- Endpoint: /api/stats

             Description: This endpoint returns statistics for expenses and income, including the total amount of expenses and income, the latest expense and income, the minimum and maximum values for both expense and income, and the balance (income - expense).


2- Delete Expenses and Income Data:-

Endpoint: /api/stats/expense/{id}
              
        Description: This endpoint deletes the expense record with the specified id from the database.

Endpoint: /api/stats/income/{id}

        Description: This endpoint deletes the income record with the specified id from the database.





3- Post Expenses and Income Data:-

Endpoint: /api/stats/expense

      Description: This endpoint creates a new expense record in the database.

Endpoint: /api/stats/income

      Description: This endpoint creates a new income record in the database.



4- Put Expenses and Income Data:-

Endpoint: /api/stats/expense/{id}

    Description: This endpoint updates the expense record with the specified id in the database.

Endpoint: /api/stats/income/{id}

    Description: This endpoint updates the income record with the specified id in the database.








Response:

    201 OK: Returns a list of all expense records.

    404 Internal Server Error: If there is an error retrieving the data.



------------------------
| Setup Instructions:- |
------------------------

-Clone the repository:

    - git clone https://github.com/sofahoba/ExpenseTracker.git

-Navigate to the project folder:

    cd ExpenseTracker

-Install dependencies using Maven:

    mvn install

-Configure MySQL Database:

    Create a new database in MySQL (e.g., expense_tracker).

    Update the application.properties file with your MySQL connection details:

    spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
    spring.datasource.username=your_username
    spring.datasource.password=your_password

-Run the application:

    mvn spring-boot:run

-Access the application:

    The backend will be running on http://localhost:8080.
