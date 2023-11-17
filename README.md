# Vote4Change

##### Step - 1 : Download any of the compressed files and extract in one folder.

##### Step - 2 : Configure Apche Tomcat Server in your PC and set in your IDE if you don't have.

##### Step - 3: If you have Oracle DB in your computer then it's good but if you don't have Oracle Db then Download and configure that before get started with the project.

##### Step - 4 : After that Create a user in DB of name "evoting" as username and "evoting" as password and run this commands to create table in DB.

##### Step - 5 : Make 3 tables I am describing tables below.

```table name : "user_details"```

```sh
Name                                      Null?    Type\n
 ----------------------------------------- -------- ----------------------------
 ADHAR_NO                                  NOT NULL VARCHAR2(20)\n
 PASSWORD                                           VARCHAR2(30)
 USERNAME                                           VARCHAR2(50)
 ADDRESS                                            VARCHAR2(100)
 CITY                                               VARCHAR2(50)
 EMAIL                                              VARCHAR2(50)
 MOBILE_NO                                          VARCHAR2(13)
 USER_TYPE                                          VARCHAR2(10)
 GENDER                                             VARCHAR2(25)
```
___

```table name : "candidate"```

```sh
 Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CANDIDATE_ID                              NOT NULL VARCHAR2(20)
 PARTY                                              VARCHAR2(20)
 USER_ID                                            VARCHAR2(30)
 SYMBOL                                             BLOB
 CITY                                               VARCHAR2(100)
 ```
 ___
 
 ```table name : "voting"```
 
 ```sh
  Name                                      Null?    Type
 ----------------------------------------- -------- ----------------------------
 CANDIDATE_ID                                       VARCHAR2(10)
 VOTER_ID                                  NOT NULL VARCHAR2(20)
 GENDER                                             VARCHAR2(25)
```
___

##### Step - 6: Add these constraints in the table so that you can sync with the project flow.

```sh
Alter table user_details add constraint ud_an_pk primary key(adhar_no);

Alter table candidate add constraint cd_cid_pk primary key(candidate_id);

Alter table candidate add constraint cd_uid_fk foreign key(user_id) references user_details(adhar_no);

Alter table voting add constraint vt_cid_fk foreign key(candidate_id) references candidate(candidate_id);

Alter table voting add constraint vt_vid_pk primary key(voter_id);

Alter table voting add constraint vt_vid_fk foreign key(voter_id) references user_details(adhar_no);
```

##### Step - 7: Now you are ready to go just run the project from registration.html make sure to add a user of type "Admin" on the table user_details maually so that you can do the works of Admin.

##### If you Face any difficulties or you have any doubt on the flow of project make sure to connect with me on LinkedIn I'm attaching the link of my linkedIn profile below :



