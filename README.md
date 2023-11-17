# Vote4Change

### 𝐒𝐭𝐞𝐩 - 𝟏 : 𝐃𝐨𝐰𝐧𝐥𝐨𝐚𝐝 𝐚𝐧𝐲 𝐨𝐟 𝐭𝐡𝐞 𝐜𝐨𝐦𝐩𝐫𝐞𝐬𝐬𝐞𝐝 𝐟𝐢𝐥𝐞𝐬 𝐚𝐧𝐝 𝐞𝐱𝐭𝐫𝐚𝐜𝐭 𝐢𝐧 𝐨𝐧𝐞 𝐟𝐨𝐥𝐝𝐞𝐫.

### 𝐒𝐭𝐞𝐩 - 𝟐 : 𝐂𝐨𝐧𝐟𝐢𝐠𝐮𝐫𝐞 𝐀𝐩𝐜𝐡𝐞 𝐓𝐨𝐦𝐜𝐚𝐭 𝐒𝐞𝐫𝐯𝐞𝐫 𝐢𝐧 𝐲𝐨𝐮𝐫 𝐏𝐂 𝐚𝐧𝐝 𝐬𝐞𝐭 𝐢𝐧 𝐲𝐨𝐮𝐫 𝐈𝐃𝐄 𝐢𝐟 𝐲𝐨𝐮 𝐝𝐨𝐧'𝐭 𝐡𝐚𝐯𝐞.

### 𝐒𝐭𝐞𝐩 - 𝟑 : 𝐈𝐟 𝐲𝐨𝐮 𝐡𝐚𝐯𝐞 𝐎𝐫𝐚𝐜𝐥𝐞 𝐃𝐁 𝐢𝐧 𝐲𝐨𝐮𝐫 𝐜𝐨𝐦𝐩𝐮𝐭𝐞𝐫 𝐭𝐡𝐞𝐧 𝐢𝐭'𝐬 𝐠𝐨𝐨𝐝 𝐛𝐮𝐭 𝐢𝐟 𝐲𝐨𝐮 𝐝𝐨𝐧'𝐭 𝐡𝐚𝐯𝐞 𝐎𝐫𝐚𝐜𝐥𝐞 𝐃𝐛 𝐭𝐡𝐞𝐧 𝐃𝐨𝐰𝐧𝐥𝐨𝐚𝐝 𝐚𝐧𝐝 𝐜𝐨𝐧𝐟𝐢𝐠𝐮𝐫𝐞 𝐭𝐡𝐚𝐭 𝐛𝐞𝐟𝐨𝐫𝐞 𝐠𝐞𝐭 𝐬𝐭𝐚𝐫𝐭𝐞𝐝 𝐰𝐢𝐭𝐡 𝐭𝐡𝐞 𝐩𝐫𝐨𝐣𝐞𝐜𝐭.

### 𝐒𝐭𝐞𝐩 - 𝟒 : 𝐀𝐟𝐭𝐞𝐫 𝐭𝐡𝐚𝐭 𝐂𝐫𝐞𝐚𝐭𝐞 𝐚 𝐮𝐬𝐞𝐫 𝐢𝐧 𝐃𝐁 𝐨𝐟 𝐧𝐚𝐦𝐞 "𝐞𝐯𝐨𝐭𝐢𝐧𝐠" 𝐚𝐬 𝐮𝐬𝐞𝐫𝐧𝐚𝐦𝐞 𝐚𝐧𝐝 "𝐞𝐯𝐨𝐭𝐢𝐧𝐠" 𝐚𝐬 𝐩𝐚𝐬𝐬𝐰𝐨𝐫𝐝 𝐚𝐧𝐝 𝐫𝐮𝐧 𝐭𝐡𝐢𝐬 𝐜𝐨𝐦𝐦𝐚𝐧𝐝𝐬 𝐭𝐨 𝐜𝐫𝐞𝐚𝐭𝐞 𝐭𝐚𝐛𝐥𝐞 𝐢𝐧 𝐃𝐁.

### 𝐒𝐭𝐞𝐩 - 𝟓 : 𝐌𝐚𝐤𝐞 𝟑 𝐭𝐚𝐛𝐥𝐞𝐬 𝐈 𝐚𝐦 𝐝𝐞𝐬𝐜𝐫𝐢𝐛𝐢𝐧𝐠 𝐭𝐚𝐛𝐥𝐞𝐬 𝐛𝐞𝐥𝐨𝐰.

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

```sh
table name : "candidate"

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
### 𝐒𝐭𝐞𝐩 - 𝟔 : 𝐀𝐝𝐝 𝐭𝐡𝐞𝐬𝐞 𝐜𝐨𝐧𝐬𝐭𝐫𝐚𝐢𝐧𝐭𝐬 𝐢𝐧 𝐭𝐡𝐞 𝐭𝐚𝐛𝐥𝐞 𝐬𝐨 𝐭𝐡𝐚𝐭 𝐲𝐨𝐮 𝐜𝐚𝐧 𝐬𝐲𝐧𝐜 𝐰𝐢𝐭𝐡 𝐭𝐡𝐞 𝐩𝐫𝐨𝐣𝐞𝐜𝐭 𝐟𝐥𝐨𝐰.

```sh
Alter table user_details add constraint ud_an_pk primary key(adhar_no);

Alter table candidate add constraint cd_cid_pk primary key(candidate_id);

Alter table candidate add constraint cd_uid_fk foreign key(user_id) references user_details(adhar_no);

Alter table voting add constraint vt_cid_fk foreign key(candidate_id) references candidate(candidate_id);

Alter table voting add constraint vt_vid_pk primary key(voter_id);

Alter table voting add constraint vt_vid_fk foreign key(voter_id) references user_details(adhar_no);
```

### 𝐒𝐭𝐞𝐩 - 𝟕 : 𝐍𝐨𝐰 𝐲𝐨𝐮 𝐚𝐫𝐞 𝐫𝐞𝐚𝐝𝐲 𝐭𝐨 𝐠𝐨 𝐣𝐮𝐬𝐭 𝐫𝐮𝐧 𝐭𝐡𝐞 𝐩𝐫𝐨𝐣𝐞𝐜𝐭 𝐟𝐫𝐨𝐦 𝐫𝐞𝐠𝐢𝐬𝐭𝐫𝐚𝐭𝐢𝐨𝐧.𝐡𝐭𝐦𝐥 𝐦𝐚𝐤𝐞 𝐬𝐮𝐫𝐞 𝐭𝐨 𝐚𝐝𝐝 𝐚 𝐮𝐬𝐞𝐫 𝐨𝐟 𝐭𝐲𝐩𝐞 "𝐀𝐝𝐦𝐢𝐧" 𝐨𝐧 𝐭𝐡𝐞 𝐭𝐚𝐛𝐥𝐞 𝐮𝐬𝐞𝐫_𝐝𝐞𝐭𝐚𝐢𝐥𝐬 𝐦𝐚𝐮𝐚𝐥𝐥𝐲 𝐬𝐨 𝐭𝐡𝐚𝐭 𝐲𝐨𝐮 𝐜𝐚𝐧 𝐝𝐨 𝐭𝐡𝐞 𝐰𝐨𝐫𝐤𝐬 𝐨𝐟 𝐀𝐝𝐦𝐢𝐧.

𝐈𝐟 𝐲𝐨𝐮 𝐅𝐚𝐜𝐞 𝐚𝐧𝐲 𝐝𝐢𝐟𝐟𝐢𝐜𝐮𝐥𝐭𝐢𝐞𝐬 𝐨𝐫 𝐲𝐨𝐮 𝐡𝐚𝐯𝐞 𝐚𝐧𝐲 𝐝𝐨𝐮𝐛𝐭 𝐨𝐧 𝐭𝐡𝐞 𝐟𝐥𝐨𝐰 𝐨𝐟 𝐩𝐫𝐨𝐣𝐞𝐜𝐭 𝐦𝐚𝐤𝐞 𝐬𝐮𝐫𝐞 𝐭𝐨 𝐜𝐨𝐧𝐧𝐞𝐜𝐭 𝐰𝐢𝐭𝐡 𝐦𝐞 𝐨𝐧 𝐋𝐢𝐧𝐤𝐞𝐝𝐈𝐧 𝐈'𝐦 𝐚𝐭𝐭𝐚𝐜𝐡𝐢𝐧𝐠 𝐭𝐡𝐞 𝐥𝐢𝐧𝐤 𝐨𝐟 𝐦𝐲 𝐥𝐢𝐧𝐤𝐞𝐝𝐈𝐧 𝐩𝐫𝐨𝐟𝐢𝐥𝐞 𝐛𝐞𝐥𝐨𝐰 : 
      𝐩𝐫𝐨𝐟𝐢𝐥𝐞 𝐥𝐢𝐧𝐤 -  𝐡𝐭𝐭𝐩𝐬://𝐰𝐰𝐰.𝐥𝐢𝐧𝐤𝐞𝐝𝐢𝐧.𝐜𝐨𝐦/𝐢𝐧/𝐚𝐝𝐚rsh-𝐤𝐫/
