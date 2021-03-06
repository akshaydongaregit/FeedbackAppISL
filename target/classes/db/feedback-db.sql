create database feedback_app_prod ;
use feedback_app_prod ;

SET FOREIGN_KEY_CHECKS = 0 ;

drop table CLASS_DETAILS ;
drop table SUBJECT_DETAILS ;
drop table STUDENT_DETAILS ;
drop table TEACHER_DETAILS ;
drop table SUBJECT_TEACHER_MAPPING ;
drop table QUESTION_STRUCTURE_MASTER ;
drop table QUESTION_MASTER ;
drop table EVALUATION_FACTORS_DETAILS ;
drop table CORE_FEEDBACK_DETAILS ;
drop table TEACHERS_FEEDBACK_DETAILS ;
drop table FACILITIES_FEEDBACK_DETAILS ;
drop table GENERAL_FEEDBACK_DETAILS ;

SET FOREIGN_KEY_CHECKS = 1 ;

CREATE TABLE CLASS_DETAILS (
	CLASS_ID INT PRIMARY KEY ,
	CLASS_NAME VARCHAR(16) ,
	IS_ACTIVE INT(1)
); 

CREATE TABLE SUBJECT_DETAILS (
	SUBJECT_ID INT PRIMARY KEY,
	CLASS_ID INT ,
	SUBJECT_NAME VARCHAR(30) ,
	IS_ACTIVE INT(1) ,
	FOREIGN KEY (CLASS_ID) REFERENCES CLASS_DETAILS (CLASS_ID) ON DELETE CASCADE
);

CREATE TABLE STUDENT_DETAILS (
	STUDENT_ID INT PRIMARY KEY ,
	CLASS_ID INT ,
	STUDENT_NAME VARCHAR(20) ,
	GENDER VARCHAR(6) ,
	DOB DATE ,
	ADDRESS VARCHAR(100) ,
	CONTACT VARCHAR(12) ,
	IS_ACTIVE INT(1) ,
	FOREIGN KEY (CLASS_ID) REFERENCES CLASS_DETAILS(CLASS_ID) ON DELETE CASCADE
);

CREATE TABLE TEACHER_DETAILS (
	TEACHER_ID INT PRIMARY KEY ,
	TEACHER_NAME VARCHAR(30) ,
	GENDER VARCHAR(6) ,
	DOB DATE ,
	ADDRESS VARCHAR(100) ,
	CONTACT VARCHAR(12) ,
	IS_ACTIVE INT(1)
);

CREATE TABLE SUBJECT_TEACHER_MAPPING (
	MAPPING_ID INT PRIMARY KEY ,
	SUBJECT_ID INT ,
	TEACHER_ID INT ,
	START_DATE DATE ,
	END_DATE DATE ,
	FOREIGN KEY (SUBJECT_ID) REFERENCES SUBJECT_DETAILS(SUBJECT_ID)  ON DELETE CASCADE,
	FOREIGN KEY (TEACHER_ID) REFERENCES TEACHER_DETAILS(TEACHER_ID)  ON DELETE CASCADE
);

CREATE TABLE QUESTION_STRUCTURE_MASTER (
	STRUCT_ID INT PRIMARY KEY ,
	SECTION_NAME VARCHAR(30),
	IS_ACTIVE INT(1) 
);

CREATE TABLE QUESTION_MASTER (
	QUESTION_ID INT PRIMARY KEY ,
	STRUCT_ID INT  ,
	QUESTION VARCHAR(100) ,
	IS_ACTIVE INT(1) ,
	FOREIGN KEY (STRUCT_ID) REFERENCES QUESTION_STRUCTURE_MASTER ( STRUCT_ID) ON DELETE CASCADE
);

CREATE TABLE EVALUATION_FACTORS_DETAILS (
   FACTOR_ID INT PRIMARY KEY ,
   FACTOR VARCHAR(100) ,
   IS_ACTIVE INT(1) 
   
);

CREATE TABLE CORE_FEEDBACK_DETAILS (
	CORE_FEEDBACK_ID INT PRIMARY KEY ,
	STUDENT_ID INT ,
	FEEDBACK_TYPE VARCHAR(10) ,
	SUBMITTED_DATE DATE ,
	FOREIGN KEY (STUDENT_ID) REFERENCES STUDENT_DETAILS ( STUDENT_ID) ON DELETE CASCADE
);

CREATE TABLE TEACHERS_FEEDBACK_DETAILS (
	TEACHERS_FEEDBACK_ID INT PRIMARY KEY ,
	CORE_FEEDBACK_ID INT ,
	FACTOR_ID INT ,
	TEACHER_ID INT ,
	FEEDBACK INT ,
	FOREIGN KEY (CORE_FEEDBACK_ID) REFERENCES CORE_FEEDBACK_DETAILS ( CORE_FEEDBACK_ID) ON DELETE CASCADE ,
	FOREIGN KEY (FACTOR_ID) REFERENCES EVALUATION_FACTORS_DETAILS (FACTOR_ID) ON DELETE CASCADE ,
	FOREIGN KEY (TEACHER_ID) REFERENCES TEACHER_DETAILS (TEACHER_ID) ON DELETE CASCADE 
);

CREATE TABLE FACILITIES_FEEDBACK_DETAILS (
	FACILITIES_FEEDBACK_ID INT PRIMARY KEY ,
	CORE_FEEDBACK_ID INT ,
	QUESTION_ID INT ,
	FEEDBACK INT ,
	FOREIGN KEY (CORE_FEEDBACK_ID) REFERENCES CORE_FEEDBACK_DETAILS (CORE_FEEDBACK_ID) ON DELETE CASCADE ,
	FOREIGN KEY (QUESTION_ID) REFERENCES QUESTION_MASTER ( QUESTION_ID) ON DELETE CASCADE
);

CREATE TABLE GENERAL_FEEDBACK_DETAILS(
 GENERAL_FEEDBACK_ID INT PRIMARY KEY ,
 CORE_FEEDBACK_ID INT ,
 FEEDBACK INT ,
 FOREIGN KEY (CORE_FEEDBACK_ID) REFERENCES CORE_FEEDBACK_DETAILS ( CORE_FEEDBACK_ID ) ON DELETE CASCADE
);

SELECT * FROM 
 CLASS_DETAILS ,
 SUBJECT_DETAILS ,
 STUDENT_DETAILS ,
 TEACHER_DETAILS ,
 SUBJECT_TEACHER_MAPPING ,
 QUESTION_STRUCTURE_MASTER ,
 QUESTION_MASTER ,
 EVALUATION_FACTORS_DETAILS ,
 CORE_FEEDBACK_DETAILS ,
 TEACHERS_FEEDBACK_DETAILS ,
 FACILITIES_FEEDBACK_DETAILS ,
 GENERAL_FEEDBACK_DETAILS ;
