/*All User's gets stored in APP_USER table*/
create table APP_USER (
   id number NOT NULL primary key,
   sso_id VARCHAR2(30) NOT NULL unique,
   password VARCHAR2(100) NOT NULL,
   first_name VARCHAR2(30) NOT NULL,
   last_name  VARCHAR2(30) NOT NULL,
   email VARCHAR2(30) NOT NULL
);

create sequence APP_USER_SEQ start with 1 cache 10 nocycle;

/* USER_PROFILE table contains all possible roles */ 
create table USER_PROFILE(
   id NUMBER NOT NULL PRIMARY KEY,
   type VARCHAR2(30) NOT NULL UNIQUE
);


/* Populate USER_PROFILE Table */
INSERT INTO USER_PROFILE
VALUES (1,'USER');

INSERT INTO USER_PROFILE
VALUES (2,'ADMIN');

INSERT INTO USER_PROFILE
VALUES (3,'DBA');


/* JOIN TABLE for MANY-TO-MANY relationship*/  
CREATE TABLE APP_USER_USER_PROFILE (
    user_id NUMBER NOT NULL,
    user_profile_id NUMBER NOT NULL,
    constraint APP_USER_USER_PROFILE_PK primary key (user_id, user_profile_id),
    CONSTRAINT FK_APP_USER FOREIGN KEY (user_id) REFERENCES APP_USER (id),
    CONSTRAINT FK_USER_PROFILE FOREIGN KEY (user_profile_id) REFERENCES USER_PROFILE (id)
);


/* Create persistent_logins Table used to store rememberme related stuff*/
CREATE TABLE persistent_logins (
    username VARCHAR2(64) NOT NULL,
    series VARCHAR2(64) NOT NULL  PRIMARY KEY,
    token VARCHAR2(64) NOT NULL,
    last_used TIMESTAMP NOT NULL
);

drop table persistent_logins