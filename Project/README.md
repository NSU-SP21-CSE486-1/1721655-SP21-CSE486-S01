
<p align = "center">
<img width="310" height="270" src="../Readme_files/nsu_logo.png">

</p>
<p align = "center">

# Project Name: The CPC App<br>
### Course: CSE 486 <br>
### Section: 01 <br>
### Semester: Spring 2021<br>

### Faculty Name: Shaikh Sawon Arefin Shimon
---

<br>

### Student Name: Abdullah Al Sayem  <br>
### Student ID: 1721655642<br>
### Email: abdullah.sayem@northsouth.edu<br>

<br>

### Date prepared: 26/05/2021<br><br>
</p>

<p align = "left">


## Table of Contents<br>

<ol>
<a href="#intro"><li><h3>Introduction</h3></li></a><br>
<a href="#features"><li><h3>Features</h3></li></a><br>
<a href="#data"><li><h3>Data Management</h3></li></a><br>
<a href="#design"><li><h3>Design Pattern</h3></li></a><br>
<a href="#road"><li><h3>Roadblocks</h3></li></a><br>

</ol>

---

<br>

<h2 id=intro>Introduction</h2><br>

<p text-align: left>
  The CPC App was developed for Carrier & Placement Center of North South University. This app will help students find job offered by companies. Using this app students can easily apply for jobs posted by CPC and send their resume to CPC for filtering process. This app also support admin login, CPC admins can create, delete, update job posts using this app.
  
</p>

<br>

<h2 id=features>Features</h2><br>
<p text-align: left>

### Student Registration <br>
<p>Only students of North South University can register with this app.</p><br>

<img width="250" height="500" src="../Readme_files/student_registration.PNG"><br><br>

### Login <br>
<p>Both admins and students can login from the app.</p><br>

<img width="250" height="500" src="../Readme_files/login.PNG"><br><br>

### Student Home Screen <br>
<p>Home screen for student users.</p><br>

<img width="250" height="500" src="../Readme_files/home.PNG"><br><br>

### Student Side-menu <br>
<p>Side-menu for student users to navigate & logout</p><br>
<img width="250" height="500" src="../Readme_files/side-menu.PNG"><br><br>

### Student Profile <br>
<p>Students can edit/update their information from profile. They can also upload resume to firebase server from their profile.</p><br>
<img width="250" height="500" src="../Readme_files/student_profile_1.PNG"><br>
<img width="250" height="500" src="../Readme_files/student_profile_2.PNG"><br><br>

### Notice Board <br>
<p>Notice Board to see all jobs posted by CPC.</p><br>
<img width="250" height="500" src="../Readme_files/notice_board.PNG"><br><br>

### Job Details <br>
<p>Whenever a job post is tapped from notice board list another activity with post details will open. Where students can apply for that job.</p><br>
<img width="250" height="500" src="../Readme_files/job_post_details.PNG"><br><br>

### Admin Dashboard <br>
<p>Admin dashboard will be only avilable to admins when they login. From here they can add, delete job posts and events.</p><br>
<img width="250" height="500" src="../Readme_files/admin_dashboard.PNG"><br><br>

### Admin Side-menu <br>
<p>Admin side-menu to navigate & logout.</p><br>
<img width="250" height="500" src="../Readme_files/admin_sidemenu.PNG"><br><br>

### Admin Job Post <br>
<p>Admin job post activity to post jobs with description. Only PDF & image files are allowed for job description.</p><br>
<img width="250" height="500" src="../Readme_files/add_job.PNG"><br><br>

</p><br>

<h2 id=data>Data Management</h2><br>
<p text-align: left>
 Firebase realtime database is used for databse storage and firebase storag is used to store PDF or image files and for authentication firebase authentication is used. Only the user session related data and information is stored locally using Shared Preference. 
</p><br>

<h2 id=design>Design Pattern</h2><br>
<p text-align: left>
  The Model-View-ViewModel (MVVM) pattern is used to build this app as android supports this architecture. I also used the singleton pattern in the app repository and observer pattern using livedata in recyclerview.   
</p><br>

<h2 id=road>Roadblocks</h2><br>

<p text-align: left>
Gradle Problem: At the initial stage of developement I encountered a gradle build related problem with the app and had to start from the very beginning.

Andoid Library: As android is shifting to androidx libraries, a lot of old libraries and funtions are deprecated, and since lot of tutorials are with the deprecated library functions, so it was a bit touugh for me to find the alternatives.
</p><br>

</p>



