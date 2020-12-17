# User-Management-System
A simple user management system for a small team or company to make shift report, request vacation and view working schedule, clock in and out, send an internal email and viewing other team members report.

#Purpose
To help a small team of employees/ company managing time sheet for their employees. To see shift report from employees, approve employees requests including shift change, time off and etc.

#Product Features
<ul>
<h1>For Admins </h1>
  <li>Log-in</li>
  <li>Log-out</li>
  <li>reset password</li>
  <li>Add new users</li>
  <li>Remove users</li>
  <li>Update user information </li>
  <li>View all reports</li>
  <li>Make a shift report</li>
  <li>Approve requests</li>
</ul>

<ul>
<h1>For Normal Users </h1>
  <li>Log-in</li>
  <li>Log-out</li>
  <li>reset password</li>
  <li>Update user information </li>
  <li>View all reports</li>
  <li>Make a shift report</li>
  <li>Send requests</li>
  <li>Clock-in and out</li>
</ul>

#Application Structure
The structure of this simple web app follows the traditional organizations hierarchy. There is a two types of users. Supervisor/Admin and normal user.

<dl>
<h1>Users</h1>
(Note: Username for UMS is ‘admin’; password is ‘password’. Username for admin cannot be changed)
<dt>Supervisor/Admin</dt>
<dd> - Also known as a super user. A super user in this simple web app, is the supervisor of the organization/team/company. A super user is given the <b>username: admin</b> and <b>password: password </b>. No one can have admin username except for to the dedicated admin or signup as an admin. The Admin has the highest privilege, she/he can add and remove users. He/she can update every user information except for the password and username. 
</dd>
<dt>Normal User</dt>
<dd> - Normal users are employees or non admin team members. They have the least privilege, they can view shift reports from other team members, clock-in and out, request time off, view their weekly schedule and request for a schedule change. Normal users can also update their user information including first and last name. Here it's assumed that there is an hypothetical process/approval for updating employees informations, and for that reason, if a user update their information, they will have to logout and log back in with their new credentials and everything will look updated.
</dd>
</dl>

#Technologies used:

<ul>
<li>HTML 5

<li>w3css.com

<li>JavaScript

<li>SQL

<li>Jsp

<li>Expression Language

<li>Java
<li>Servlet
<li>Internet connection to get w3css.
</ul>


#Software Requirement:

<ul>
<li>Tomcat server v9 or Widlfly 20 etc.

<li>MySQL for database

<li>Web Browser supporting HTML5 : Google Chrome(recommended) / Firefox 
</ul>

#Step-wise Instructions:
<ul>
<h1>setting up<h1>
<li>Open the database.sql file given in the zip folder in your sql workbench to create the required database to run this app. </li>
<li>Setup your own password for your database by configuring the password and connection pool under the webcontent/META-INF/context.xml.</li>
<li>Deploy the war file on your server</li>
</ul>
<h1>Resetting user password</h1>
Here we assume the user's employee id is a secret to them and no one else knows it.
To reset a password, the user must know their username and employee id.<br>
First,
<ul>
<li> click on reset password on the web gui </li>
<li> Input the requested information.</li>
If the passed username and employee id are correct, the password will be reset to the new one. user should be able to login with their new credentials.
</ul>

#Viewing personal information
A user can view their personal information by clicking on the user icon at the top left side of the web once they are signed in. There, the user should be able to view their profile and edit if they wish by clicking on the edit button at the bottom of the page. Updating profile also includes changing or resetting their password. As mention earlier, there is an hypothetical process for validation of user information from a different vendor. So, user must logout and log back in to see their most current updated informations.
#Still under development
This user management system is a beta, it's still under development. There isn't much a user can do on the page currently. Here are the implemented features: logging in, logging out, signing up, updating user information and reseting password. All other features are there for display but they are not implemented yet.
