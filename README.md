# Training-Administration-Portal

# Training Management System

## Project Summary

This web application is designed to streamline the process of creating, scheduling, and managing training sessions. It primarily targets Training Coordinators, allowing them to efficiently handle Courses, Trainers, and Trainings. Here are the key features:

### Course Management
- Create, edit, and delete courses (e.g., Java, Python, Javascript, Go).
- Course attributes include Name, Description, Category, Intended audience, Benefits, and more.

### Trainer Management
- Create, edit, and delete Trainer details.
- Trainer attributes include Name, Qualification, Short Description, Years of experience, and more.

### Training Scheduling
- Create, schedule, edit, and delete training sessions for a selected Course and Trainer.
- Training attributes include Display Name, Course, Trainer, Date(s), Starting and ending time, Location, Fee Amount, Discount Amount, Batch Size, and more.

### Search Capability
- Users can search for Courses, Trainers, and Trainings, making it easier to find specific information.

### Technical Considerations
- Users cannot delete a Course if there are any upcoming Trainings scheduled for that Course.
- Users cannot delete a Trainer if there are any upcoming Trainings scheduled for that Trainer. Optionally, users can replace the Trainer with a different one.
- Users cannot schedule duplicate trainings, ensuring that there are no conflicts with the same Course, Trainer, Date & Time.

## Instructions

1. **Initial Analysis:** Begin by conducting an initial analysis of the project requirements to ensure a clear understanding.

2. **Mentor Session:** Have a quick session with mentors to clarify any questions or uncertainties regarding the project.

3. **High-Level Design:** Create a high-level design document that outlines the overall structure and flow of the application, including user interfaces and major components.

4. **Bill of Materials (BOM):** Prepare a list of software and hardware to be used in the project, ensuring all necessary resources are available.

5. **Modularized Code:** Design and implement well-modularized code to enhance maintainability and scalability.

6. **Database Schema:** Design a normalized database schema that efficiently stores and manages Course, Trainer, and Training data.

7. **Authentication:** Implement authentication to ensure that only authorized users can access the application.

## Bill of Materials (BOM)

### Software:
- Web Application Framework (e.g., Django, Ruby on Rails)
- Database Management System (e.g., PostgreSQL, MySQL)
- Frontend Framework (e.g., React, Angular, Vue.js)
- Version Control System (e.g., Git)
- Authentication Framework (e.g., OAuth, JWT)
- Hosting Service (e.g., AWS, Azure, Heroku)
- Text Editor or Integrated Development Environment (IDE)

### Hardware:
- Server/Hosting Infrastructure
- Database Server
- Development and Testing Machines
- Networking Equipment (if self-hosting)

## Getting Started

Follow these steps to set up and run the project locally:

1. Clone the repository to your local machine.
2. Install the required software and dependencies as mentioned in the project documentation.
3. Configure the database and other environment settings.
4. Run database migrations to create the necessary tables.
5. Start the development server.
6. Access the application through your web browser.
7. Authenticate using valid credentials to access the features.

## Project Contributors

- Harmanjot Singh
- Shreya Tiwari
- Govind Gurawa

## Acknowledgments

We would like to express our gratitude to our mentors and anyone who contributed to the development of this project.

---


