# User-Management-System

A robust user management system designed for small teams or companies to streamline shift reporting, vacation requests, view working schedules, clock in/out, send internal emails, and access other team members' reports.

## Purpose

The system is aimed at helping small teams manage timesheets effectively, including viewing shift reports, approving requests (such as shift changes or time off), and ensuring efficient communication within the team.

## Product Features

### For Admins

- Log in/out
- Reset password
- Add, remove, and update users
- View all reports
- Generate shift reports
- Approve requests

### For Normal Users

- Log in/out
- Reset password
- Update user information
- View all reports
- Generate shift reports
- Send requests
- Clock in/out

## Application Structure

This web app follows a traditional organizational hierarchy with two types of users: Supervisor/Admin and Normal User.

### Users

**Supervisor/Admin**
- Super users, or admins, have the highest privileges and can manage users, update information, and approve requests.

**Normal User**
- Employees or non-admin team members with limited privileges.

## Technologies Used

- Java
- Spring Boot
- Bootstrap
- Angular
- Thymeleaf
- HTML/CSS/JS
- AWS
- MySQL
- JUnit

## Software Requirement

- Tomcat server v9 or Wildfly 20
- MySQL for the database
- Web Browser supporting HTML5 (e.g., Google Chrome, Firefox)

## Step-wise Instructions

1. Open the `database.sql` file in your SQL workbench to create the required database.
2. Configure the database password and connection pool in `webcontent/META-INF/context.xml`.
3. Deploy the WAR file on your server.

## Resetting User Password

Users can reset their password by providing their username and employee ID. The password reset process assumes that the user's employee ID is a secret known only to them.

## Viewing Personal Information

Users can view and edit their personal information by clicking on the user icon after signing in. Updating the profile includes changing or resetting the password. Users must log out and log back in to see the most current updates.

## Still Under Development

This user management system is in beta and still under development. Currently implemented features include logging in/out, signing up, updating user information, and resetting passwords. Other features are displayed but not yet implemented.

## Contributing

We welcome contributions! If you'd like to contribute, please follow our guidelines for bug reports, feature requests, or pull requests.

## Known Issues and Future Development

Please check our issue tracker for any known issues. We have plans for additional features in future releases.

## License

This project is licensed under MIT license - see the LICENSE.md file for details.

## Contact Information

For questions or feedback, feel free to contact Abdul at dultechnologies@gmail.com.













