# HandsOn_
Cognizant Handson   


# Case Study - Flight Management :

Technology Used:
Spring-boot (mvc) 
Hibernate (jpa)
lombok -(For Getter and Setter Boilerplate)

Run On port number: 8080

Operations:


1.Create a Flight (Flight Type = Economy or Business)

2.Create a Passenger (Vip - true or False)

3.View All Flights

i) Has functionality of adding a pasenger in flight. (Non Vip passengers in  Economy Flight type only)

ii) Has functionality of Removing a pasenger in flight.(Vip Passengers cannot be removed)

iii) Has functionality of view all  pasengers in  a particular flight.



4.View ALL passengers

5.View All Business Flights

i) Has functionality of adding a pasenger in flight. (Non Vip passengers in  Economy Flight type only)

ii) Has functionality of Removing a pasenger in flight.(Vip Passengers cannot be removed)

iii) Has functionality of view all  pasengers in  a particular flight.


6.View All Economy Flights:

i) Has functionality of adding a pasenger in flight. (Non Vip passengers in  Economy Flight type only)

ii) Has functionality of Removing a pasenger in flight.(Vip Passengers cannot be removed)

iii) Has functionality of view all  pasengers in  a particular flight.


7.View All Vip Passengers


8.View All Non-Vip Passengers



# Case Study Patient Intake System

 The application uses console input and output to communicate with the user, this has a main menu with 2 subsystems

a. Add a patient appointment

b. View all appointments



# Case Study TraineeMamger

The purpose of the application is to manage a list of trainees based on their cohort code. This will be a menu driven console application which will have the following options

a. Register trainee: add a new trainee to the repository

b. Remove trainee: remove an existing trainee from the repository

c. Find by name: find if a trainee is present under the cohort

d. Find all: find all trainees in a cohort


Data validation constraints

1. Make sure email is in correct format

2. The name fields cannot have numeric data

3. Empid has to have 6 numbers

4. Cohort code should be in the following format, AAAXXAAXX, A is for alphabet and X is for number



#  Handson-56 
This is the Hands-on of day 56 
It executes various queries and fucntalities has mentioned in the document


#  Handson-57
This is the Hands-on of day 56 
It executes various queries and fucntalities has mentioned in the document

ormlearn - This project performs all the queries of the stock database. (As mentioned in the document)

payroll - This project performs all the queries of the payroll databsase(Employee, department and skill) . [As mentioend in the document] 

# Practice Check (TruYum)

Technology Used:
Spring-boot (mvc) 
Hibernate (jpa)
Html (FrontEnd)
CSS(Front End)

Run On port number: 8080
Databse design - 
user - cart (one to one relation) (one user can have one cart)
cart-menuitem -(many to many relation ) ( because many carts can have many menu items )
Schema and tables - Created by Hibernate 

Operations -Customer:

1.-Register a new user
2-Login  in into the website
3-logout  from the website
4-To view list of menuItems 
5-To view Cart
6- To add a menu-item to the cart 
7- To delete a menu item from cart



Operations -Admin:


1-Login  in into the website
2-logout  from the website
3-To view list of menuItems 
4-To edit a menuItem

Note - The list of menuitems are instered directly from backend (directly from sql workbecnh) 
        Values insert is in file truyum-data.sql( folder sql/truyum-data.sql)
