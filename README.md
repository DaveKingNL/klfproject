This project was built with Java 1.8, Spring Boot, Maven, H2 Database and Netbeans. 

Since I used H2, no other database is needed and I've set it to a relative path. After loading up the project in an IDE of your choice, 
you will however need to remove the comments on both schema.sql and data.sql for the first run to set up the database with some entries.

I have completed all three assignements in this one application, though the query is a bit easier, since I didn't need a second join to get 
the name from users (I used the username as primary key in users). So just in case, the query needed to solve the assignement with both joins:

select u.name, a.name, count(*) as 'amount', min(occurence) as first_occurrence, max(occurence) as last_occurrence 
from users u 
join user_activity ua on u.id = ua.user_id 
join activity a on ua.activity_id = a.id 
where monthname(occurence)='October' 
and year(occurence)='2019'
group by user_id, activity_id;

On the statistics page of the webapp you will find a table with a similair build. 

Thank you again for the opportunity and have a great day.

Dave



Steps:
1: remove comments from both sql files in main/resources for the first run
2: enter a valid gmail and password in MailSender.java class in the service package. You might also need to go into google settings and turn on 
"allow less secure passwords" in security settings. or use an App password for 2-Step verification.
3: to login on the app without making a new user:
	username: klfuser
	password: password
