create table UserGroup(
Prioriteti int NOT NULL primary key,
)

--Aksesi per User
insert into UserGroup VALUES(1)
--ADMIN
insert into UserGroup VALUES(2)




CREATE TABLE Users(
	user_id int NOT NULL IDENTITY(1,1) primary key,
	email VARCHAR(255) NOT NULL unique,
	username VARCHAR(25) NOT NULL unique,
	password VARCHAR(255) NOT NULL,
	Prioriteti int foreign key references UserGroup(prioriteti) ,
	Emri VARCHAR(255) NOT NULL,
	Mbiemri VARCHAR(255) NOT NULL,
	Gjinia char(1) not null check(Gjinia = 'M' or Gjinia = 'F'),
	Qyteti VARCHAR(255),
	Shteti VARCHAR(255),
	[Data e lindjes] DATE,
	Mosha as datediff(year,[Data e lindjes],CONVERT(date, getdate())),
	[Data e krijimit] date   NOT NULL,
	active bit
)



CREATE TABLE Posts(
	post_id int NOT NULL IDENTITY(1,1) primary key,
	user_id int NOT NULL,
	Pershkrimi VARCHAR(255),
	Lloji varchar(5) check (lloji = 'video' or lloji='foto' or lloji='text'),
	[Linku i postimit] VARCHAR(255) NOT NULL,
	[Data e krijimit] DATETIME NOT NULL,
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
)



CREATE TABLE Followings(
	user_id INT NOT NULL , 
	following_id INT NOT NULL , 
	Data DATE NOT NULL,
	PRIMARY KEY (user_id, following_id),
	UNIQUE (following_id, user_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id),
	FOREIGN KEY (following_id) REFERENCES Users(user_id)
)



CREATE TABLE Comments(
	comment_id INT NOT NULL IDENTITY(1,1),
	post_id INT NOT NULL,
	user_id INT NOT NULL,
	[Data e komentimit] DATETIME NOT NULL,
	[Data e ndryshimit] DATETIME,
	PRIMARY KEY (comment_id),
	FOREIGN KEY (post_id) REFERENCES Posts(post_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
)


CREATE TABLE Messages(
	message_id INT NOT NULL IDENTITY(1,1),
	user_id_from INT NOT NULL,
	user_id_to INT NOT NULL,
	Texti text NOT NULL,
	[Data e dergimit] DATETIME NOT NULL,
	[Ora e leximit] DATETIME ,
	PRIMARY KEY (message_id),
	FOREIGN KEY (user_id_from) REFERENCES Users(user_id),
	FOREIGN KEY (user_id_to) REFERENCES Users(user_id)
)


CREATE TABLE Likes(
	Likes_ID INT NOT NULL IDENTITY(1,1),
	user_id INT NOT NULL,
	post_id int NOT NULL,
	[Koha e Like-t] DATETIME NOT NULL,
	PRIMARY KEY (user_id, post_id),
	UNIQUE (post_id, user_id),
	FOREIGN KEY (post_id) REFERENCES Posts(post_id),
	FOREIGN KEY (user_id) REFERENCES Users(user_id)
)


create table Verejtje(
IDVrejtja int identity(1,1) PRIMARY KEY,
Data date not null,
Pershkrimi varchar(255) not null,
[User_from] int not null foreign key references Users(user_id),
[User_to] int not null foreign key references Users(user_id),
unique (User_from , User_to)
)


create table Bllok(
IDBllok int identity(1,1) primary key,
Data date not null,
Arsyeja text not null,
[User from] int not null foreign key references Users(user_id),
[User to] int not null foreign key references Users(user_id),
unique([User from] , [User to])
)

create table HyrjeDalje (
IDHyrjeDalje int identity(1,1) primary key,
Logout time(0) not null,
Login time(0),
Perdoruesi varchar(25) not null foreign key references Users(username)
)

create table Shitja (
user_id INT not null,
username varchar(25) not null,
add_id int not null,
Koha datetime not null,
Produkti text )

-------------------------------------------------------------------------------------------------

ALTER TABLE Shitja
ADD CONSTRAINT Shitja_PK Primary Key (user_id , add_id)

ALTER TABLE SHITJA
ADD CONSTRAINT Shitja_FK Foreign KEY (username) references Users(username)

ALTER TABLE Shitja
DROP CONSTRAINT Shitja_PK

ALTER TABLE Shitja
DROP COLUMN Shitja_ID

Alter table Posts
drop column [Linku i postimit]

ALTER TABLE Comments
ADD Permbajtja TEXT NOT NULL

DROP TABLE Shitja


DELETE m
FROM Messages m inner join Users u on m.user_id_from = u.user_id inner join Users u2 on u2.user_id = m.user_id_to
WHERE u.username = 'drilonpacarizi' and u2.username = 'trimmuharremi'


update Users
set password = '123456'
WHERE username = 'flamurjahiri'

-----------------------------------------------------------------------------------------------------------------------








