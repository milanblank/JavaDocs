CREATE USER milans IDENTIFIED BY milans; -- you should replace my user name with yours. “IDENTIFIED BY” means the password.
GRANT CREATE SESSION TO milans; -- necessary for connecting to the database with your new user.
GRANT CREATE ANY INDEX TO milans; -- we use indexes for faster queries.
GRANT ALTER ANY INDEX TO milans;
GRANT DROP ANY INDEX TO milans;
GRANT CREATE ANY PROCEDURE TO milans; -- we will use them in following workshops.
GRANT ALTER ANY PROCEDURE TO milans;
GRANT DROP ANY PROCEDURE TO milans;
GRANT EXECUTE ANY PROCEDURE TO milans;
GRANT CREATE ANY SEQUENCE TO milans; -- we need sequences for inserting data.
GRANT ALTER ANY SEQUENCE TO milans;
GRANT DROP ANY SEQUENCE TO milans;
GRANT SELECT ANY SEQUENCE TO milans;
GRANT CREATE ANY TABLE TO milans;
GRANT ALTER ANY TABLE TO milans;
GRANT DELETE ANY TABLE TO milans;
GRANT DROP ANY TABLE TO milans;
GRANT INSERT ANY TABLE TO milans;
GRANT LOCK ANY TABLE TO milans;
GRANT SELECT ANY TABLE TO milans;
GRANT UPDATE ANY TABLE TO milans;
GRANT CREATE TABLESPACE TO milans;
GRANT ALTER TABLESPACE TO milans;
GRANT DROP TABLESPACE TO milans;
GRANT CREATE ANY VIEW TO milans;
GRANT DROP ANY VIEW TO milans;
GRANT UNDER ANY VIEW TO milans;
alter user milans quota 50m on system;
