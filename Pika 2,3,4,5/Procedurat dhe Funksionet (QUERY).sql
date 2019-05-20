USE SocialNetwork
GO

create procedure shtoUser 
@emri varchar(255),
@mbiemri varchar(255),
@datlindja varchar(255),
@gjinia char(1),
@qyteti varchar(255),
@shteti varchar(255),
@username varchar(255),
@password varchar(255),
@email varchar(255)
as 
BEGIN
insert into Users(Emri, Mbiemri , [Data e lindjes], [Data e krijimit] , Gjinia , Qyteti , Shteti , active , username , password , email , prioriteti )values
(@emri , @mbiemri , CONVERT(date, @datlindja) , CONVERT(date, getdate()) , @gjinia , @qyteti , @shteti , 0 , @username , @password , @email , 1)
END
go
drop procedure shtoUser
select *
from users
---------------------------------------------------------------------------------------------------------
create procedure checkLOGIN
@username varchar(255),
@password varchar(255)
as
BEGIN
SELECT user_id
FROM Users
WHERE username = @username and password = @password and active = 1
END
GO

---------------------------------------------------------------------------------------------------------
create function Mosha(@data date)
RETURNS int
AS
Begin
DECLARE @NR int;
SELECT @NR = DATEDIFF(YEAR, @data , CONVERT(date , getdate()))
RETURN @Nr;
END;
GO

EXEC Mosha '17-Jul-1999'
----------------------------------------------------------------------------------------------------------

create function Postet(@user_id int)
RETURNS int
AS
Begin
DECLARE @NR int;
SELECT @NR = COUNT(p.user_id)
			FROM Users u inner join Posts p on u.user_id = p.user_id
			WHERE @user_id = u.user_id;
RETURN @Nr;
END;
GO



EXEC Postet 1


----------------------------------------------------------------------------------------------------------
create procedure shtoLike
@username varchar(255),
@post_id int
as
BEGIN
INSERT into Likes(user_id , post_id , [Koha e Like-t]) values ((SELECT user_id FROM Users WHERE @username = username) , @post_id , CONVERT(date , GETDATE()))
END
GO
---------------------------------------------------------------------------------------------------------
create procedure shtoKomente
@permbajtja text,
@username varchar(255),
@post_id int
as
BEGIN
INSERT into Comments(user_id , Permbajtja , post_id , [Data e komentimit] , [Data e ndryshimit]) values ((SELECT user_id FROM Users WHERE @username = username) , @permbajtja, @post_id , CONVERT(date , GETDATE()) , null)
END
GO

---------------------------------------------------------------------------------------------------------
create procedure checkPrioriteti
@username varchar(255)
as
BEGIN
SELECT prioriteti
FROM Users
WHERE username = @username
END
go

------------------------------------------------------------------------------------------------------------
create procedure getMesazhat
@username varchar(255)
as
BEGIN
SELECT m.* , u2.username
FROM Messages m inner join Users u on m.user_id_to = u.user_id inner join Users u2 on u2.user_id = m.user_id_from
WHERE @username = u.username
END
GO



----------------------------------------------------------------------------------------------------------
create procedure getMesazhet2
@usernameyT varchar(255)
as
BEGIN
SELECT m.* , u.username
FROM Messages m inner join Users u on m.user_id_to = u.user_id inner join Users u2 on u2.user_id = m.user_id_from
WHERE @usernameyT = u2.username 
END
GO

exec getMesazhet2 'ardikrasniqi'

-----------------------------------------------------------------------------------------------------------

create procedure getALLMesazhet
@usernameyT varchar(255)
as
BEGIN
SELECT u.username as Pranuesi , u2.username as Derguesi
FROM Messages m inner join Users u on m.user_id_to = u.user_id inner join Users u2 on u2.user_id = m.user_id_from
WHERE @usernameyT = u2.username or @usernameyT = u.username
END
GO


---------------------------------------------------------------------------------------------------------
create procedure getMesazhatSipasDates
@usernameyT varchar(255)
as
BEGIN
SELECT u.username as Pranuesi , u2.username as Derguesi , m.[Data e dergimit]
FROM Messages m inner join Users u on m.user_id_to = u.user_id inner join Users u2 on u2.user_id = m.user_id_from
WHERE @usernameyT = u2.username or @usernameyT = u.username
ORDER BY m.[Data e dergimit] desc
END
GO


--------------------------------------------------------------------------------------------------------
create procedure getMesazhatUsers
@derguesi varchar(255),
@pranuesi varchar(255)
as
BEGIN
SELECT m.Texti , m.[Data e dergimit] , m.[Ora e leximit]
FROM Messages m inner join Users u on m.user_id_to = u.user_id inner join Users u2 on u2.user_id = m.user_id_from
WHERE @derguesi = u2.username or @pranuesi = u.username
END
go

SELECT *
FROM Messages

------------------------------------------------------------------------------------------------------------------
create procedure dergoMesazh
@user_id_from int,
@user_id_to int,
@texti text
as
BEGIN
insert into Messages(user_id_from , user_id_to , Texti , [Data e dergimit] ) values (@user_id_from , @user_id_to , @texti , CONVERT(datetime , GETDATE()))
END
go

--------------------------------------------------------------------------------------------------------------------

create procedure getFollowings
@username varchar(255)
as
BEGIN
SELECT u2.username
FROM Followings f inner join Users u on f.following_id = u.user_id inner join users u2 on u2.user_id = f.user_id
WHERE @username = u.username
END
go

drop procedure getFollowings

exec getFollowings 'flamurjahiri' --followers
exec FollowersTu 'flamurjahiri' --following


---------------------------------------------------------------------------------
create procedure FollowersTu
@username varchar(255)
as
BEGIN
SELECT u2.username
FROM Followings f inner join Users u on f.user_id = u.user_id inner join Users u2 on f.following_id = u2.user_id
WHERE @username = u.username
END
go

drop procedure FollowersTu

EXEC FollowersTu 'flamurjahiri'

-------------------------------------------------------------------------------------
create procedure getUsername
@user_id int
as
BEGIN
SELECT username
FROM Users
WHERE user_id = @user_id
END
go

---------------------------------------------------------------------------------------
create procedure getUserID
@username varchar(255)
as
BEGIN
SELECT user_id
FROM Users
WHERE username = @username;
END
go

---------------------------------------------------------------------------------------------------------
create procedure fshijMesazhat
@usernameFROM varchar(255),
@usernameTO varchar(255)
as
BEGIN
DELETE m
FROM Messages m inner join Users u on m.user_id_from = u.user_id inner join Users u2 on u2.user_id = m.user_id_to
WHERE u.username = @usernameFROM and u2.username = @usernameTO
END
go

/**DELETE m
FROM Messages m inner join Users u on m.user_id_from = u.user_id inner join Users u2 on u2.user_id = m.user_id_to
WHERE u.username = 'drilonpacarizi' and u2.username = 'trimmuharremi'
SELECT *
From Messages

SELECT *
FROM Users*//
------------------------------------------------------------------------------

go
CREATE PROCEDURE fshijPOSTET
@username varchar(255)
as
BEGIN
DELETE p
FROM Posts p inner join Users u on p.user_id = u.user_id 
WHERE u.username = @username 
END
go

------------------------------------------------------------------------------------

CREATE PROCEDURE jekFOLLOWING
@usernameFROM varchar(255),
@usernameTO varchar(255)
as
BEGIN
DELETE f
FROM Followings f inner join Users u on f.user_id = u.user_id inner join Users u2 on f.following_id = u2.user_id
WHERE u.username = @usernameFROM and u2.username = @usernameTO
END
go	

exec jekFOLLOWING 'vullkantopanica' , 'flamurjahiri'

SELECT *
FROM Bllok
-------------------------------------------------------------------------------------

CREATE PROCEDURE fshijKomente
@usernameJot varchar(255),
@usernameTi varchar(255)
as
BEGIN
DELETE k
FROM Comments k inner join Posts p on k.post_id = p.post_id inner join Users u on p.user_id = u.user_id inner join Users u2 on u2.user_id = k.user_id
WHERE u.username = @usernameJot and u2.username = @usernameTi
END
go

---------------------------------------------------------------------------------------------------------

create procedure shikoBllokimet
@username varchar(255)
as
BEGIN
SELECT b.*
FROM Bllok b inner join Users u on b.[User from] = u.user_id
WHERE u.username = @username 
END
GO

----------------------------------------------------------------------------------------------------------------
create procedure updatePassword
@username varchar(255),
@password varchar(255)
as
BEGIN
update Users
set password = @password
WHERE username = @username
END
GO



-----------------------------------------------------------------------------------------------------------
create procedure updateEmail
@username varchar(255),
@email varchar(255)
as
BEGIN
update Users
set email = @email
WHERE username = @username
END
GO


-----------------------------------------------------------------------------------------------------------
create procedure updateUsername
@username varchar(255),
@usernameRi varchar(255)
as
BEGIN
update Users
set username = @usernameRi
WHERE username = @username
END
GO


--------------------------------------------------------------------------------------------------------
create procedure updateDatenElindjes
@username varchar(255),
@data date
as
BEGIN
update Users
set [Data e lindjes] = @data
WHERE username = @username
END
GO


--------------------------------------------------------------------------------------------------------------

create procedure updateQyteti
@Username varchar(255),
@QytetiRi varchar(255)
as
BEGIN
update Users
set Qyteti = @QytetiRi
WHERE username = @username
END
GO

--------------------------------------------------------------------------------------------------------------
create procedure updateShteti
@Username varchar(255),
@ShtetiRi varchar(255)
as
BEGIN
update Users
set Shteti = @ShtetiRi
WHERE username = @username
END
GO

--------------------------------------------------------------------------------------------------------------
create procedure updateMbiemri
@Username varchar(255),
@Mbiemri varchar(255)
as
BEGIN
update Users
set Mbiemri = @Mbiemri
WHERE username = @username
END
GO

--------------------------------------------------------------------------------------------------------------
create procedure shikoPostet 
@username varchar(255)
as
BEGIN
SELECT p.*
FROM Posts p inner join Users u on p.user_id = u.user_id
WHERE u.username = @username
END
GO

select *
from Users
--------------------------------------------------------------------------------------------------------------

create procedure zgjedhPostin
@Pershkrimi varchar(255)
as
BEGIN
SELECT post_id
FROM Posts
WHERE Pershkrimi = @Pershkrimi
END
go

drop procedure shikoLiket

select *
from Likes
-------------------------------------------------------------------------------------------------------------

create procedure fshijePostin
@post_id int
as
BEGIN
DELETE from Posts
WHERE post_id = @post_id
END
GO

------------------------------------------------------------------------------------------------------------
create procedure editoPostin
@post_id int,
@pershkrimi varchar(255)
as
BEGIN
UPDATE Posts
set Pershkrimi = @pershkrimi
WHERE post_id = @post_id
END
GO


-------------------------------------------------------------------------------------------------------------
create procedure shikoLiket
@post_id int
as
BEGIN
SELECT count(l.post_id) 
FROM Users u inner join Likes l on u.user_id = l.user_id inner join Posts p on l.post_id = p.post_id
WHERE p.post_id = @post_id
END
GO

exec shikoLiket 1

drop procedure shikoKomentet



------------

create procedure shikoKomentet
@post_id int
as
BEGIN
SELECT count(k.post_id)
FROM Users u inner join Comments k on u.user_id = k.user_id inner join Posts p on k.post_id = p.post_id
WHERE p.post_id = @post_id
END
GO

-----------------------------------------------------------

create procedure shikoGjinin
@Gjinia char(1)
as 
BEGIN
select Emri , Mbiemri , Username
from Users
where Gjinia=@Gjinia 
END
GO

----------------------------------------------------------------------------------------------------------------
create procedure mesazhatData
@username varchar(255),
@data varchar(255)
as
BEGIN
SELECT m.* 
FROM Messages m inner join Users u on m.user_id_to = u.user_id
WHERE u.username = @username and CONVERT(date,@data) > m.[Data e dergimit]
END
GO


-----------------------------------------------------------------------------------------------------------------

create procedure MesazhatMasShumti
@username varchar(255)
as
BEGIN
SELECT u2.Username , COUNT(u2.UserName)
FROM Users u inner join Messages m on u.user_id = m.user_id_to inner join Users u2 on u2.user_id = m.user_id_from
WHERE u.username = @username
GROUP by u2.username
ORDER by u2.username desc
END
GO

SELECT m.*
from Messages m
SELECT *
FROM Users
--------------------------------------------------------------------------------------------------------------

create procedure userMeShumLike
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i likeve]
FROM Users u inner join Likes l on u.user_id = l.user_id
GROUP BY u.UserName
HAVING count(u.Username) >= ALL (SELECT COUNT(u.UserName)
								FROM Users u inner join Likes l on u.user_id = l.user_id
								GROUP by u.username)

END
go

----------------------------------------------------

create procedure userMePakLike
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i likeve]
FROM Users u  inner join Likes l on u.user_id = l.user_id
GROUP BY u.UserName
HAVING count(u.Username) <= ALL (SELECT COUNT(u.UserName)
								FROM Users u inner join Likes l on u.user_id = l.user_id
								GROUP by u.username)
END
go


----------------------------------------------------------------------------------


create procedure userMeShumKomente
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i komenteve]
FROM Users u inner join Comments k on u.user_id = k.user_id
GROUP BY u.UserName
HAVING count(u.Username) >= all(SELECT COUNT(u.UserName)
								FROM Users u inner join Comments l on u.user_id = l.user_id
								GROUP by u.username)

END
go


---------------------------------------------------------------------------------

create procedure userMePakKomente
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i komenteve]
FROM Users u inner join Comments k on u.user_id = k.user_id
GROUP BY u.UserName
HAVING count(u.Username) <= all(SELECT COUNT(u.UserName)
								FROM Users u inner join Comments l on u.user_id = l.user_id
								GROUP by u.username)

END
go


--------------------------------------------------------------------------


create procedure DerguesiMeIMadhIMesazhave
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i Mesazhave]
FROM Users u  inner join Messages k on u.user_id = k.user_id_to
GROUP BY u.UserName
HAVING count(u.Username) >= all(SELECT COUNT(u.user_id)
								FROM Users u inner join Messages m on u.user_id = m.user_id_to
								GROUP by u.user_id)

END
go

----------------------------------------------------------------------------

create procedure DerguesiMeIVogelIMesazhave
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i Mesazhave]
FROM Users u  inner join Messages k on u.user_id = k.user_id_to
GROUP BY u.UserName
HAVING count(u.Username) <= all(SELECT COUNT(u.user_id)
								FROM Users u inner join Messages m on u.user_id = m.user_id_to
								GROUP by u.user_id)

END
go

---------------------------------------------------------

create procedure PranuesiMeIMadhIMesazhave
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i Mesazhave]
FROM Users u  inner join Messages k on u.user_id = k.user_id_from
GROUP BY u.UserName
HAVING count(u.Username) >= all(SELECT COUNT(u.user_id)
								FROM Users u inner join Messages m on u.user_id = m.user_id_from
								GROUP by u.user_id)

END
go


-----------------------------------------------------------------------

create procedure PranuesiMeIVogelIMesazhave
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i Mesazhave]
FROM Users u  inner join Messages k on u.user_id = k.user_id_from
GROUP BY u.UserName
HAVING count(u.Username) <= all(SELECT COUNT(u.user_id)
								FROM Users u inner join Messages m on u.user_id = m.user_id_from
								GROUP by u.user_id)

END
go

--------------------------------------------------------------------------------------

create procedure shikoUserAktiv
as
BEGIN
SELECT username
FROM Users
WHERE active = 1
END
GO
use socialNetwork
drop procedure shikoUserDEAKTIV
--------------------------------------------------------------------------------------

create procedure shikoUserDEAKTIV
as
BEGIN
SELECT Username
FROM Users
WHERE active = 0
END
GO

---------------------------------------------------------------------------------

create procedure AktivizoUser
@username varchar(255)
as
BEGIN
UPDATE Users
SET Active = 1
WHERE username = @username
END
GO

SELECT * FROM USERS
----------------------------------------------------------------------------------

create procedure DeaktivizoUSER
@username varchar(255)
as
BEGIN
UPDATE Users
SET active = 0
WHERE username = @username
END
GO

------------------------------------------------------------------------

create procedure shtoPost
@username varchar(255),
@pershkrimi varchar(255),
@lloji varchar(5)
as
BEGIN
INSERT into Posts(user_id , Pershkrimi , Lloji , [Data e krijimit] )
values ((SELECT user_id FROM Users WHERE username = @username) , @pershkrimi , @lloji , CONVERT(datetime, getdate()))
END
GO

drop procedure shtoPost
----------------------------------------------------------------------------

CREATE PROCEDURE GjejKomentet
@username varchar(255),
@post_id int
as
BEGIN
SELECT k.permbajtja
from Comments k inner join Posts p on k.post_id = p.post_id inner join Users u on k.user_id = u.user_id
WHERE p.post_id = @post_id
END
GO

drop procedure GjejKomentet

EXEC GjejKomentet 'flamurjahiri' , 2


SELECT *
FROM Followings

-------------------------------------------------------------------------
CREATE PROCEDURE TeDhenat
@username varchar(255)
as
BEGIN
SELECT Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , Mosha
FROM Users
WHERE username = @username
END
GO


-----------------------------------------------------------------------------
CREATE PROCEDURE FollowUser
@usernameYt varchar(255),
@username varchar(255)
as
BEGIN
insert into Followings(user_id , following_id , Data) values ((SELECT user_id FROM Users WHERE username = @usernameYt) , (SELECT user_id FROM Users WHERE username = @username) , convert(DATETIME , GETDATE()))
END
go
-------------------------------------------------------------------------

create procedure shikoFollowsatEfundit
@username varchar(255)
as
BEGIN
SELECT u.UserName , f.Data
FROM Users u2 inner join Followings f on u2.user_id = f.following_id inner join Users u on u.user_id = f.user_id
WHERE u2.username = @username
order by CONVERT(date , f.Data ) DESC
END
GO

--------------------------------------------------------------------------

create procedure userMeShumVerejtje
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i Verejtjeve]
FROM Users u inner join Verejtje v on u.user_id = v.User_to
GROUP BY u.UserName
HAVING count(u.Username) >= all(SELECT COUNT(u.UserName)
								FROM Users u inner join Verejtje v on u.user_id = v.User_to
								GROUP by u.username)

END
go

---------------------------------------------------------------------

create procedure userMePakVerejtje
as
BEGIN
SELECT u.UserName , count(U.USERNAME) as [Numri i Verejtjeve]
FROM Users u inner join Verejtje v on u.user_id = v.User_to
GROUP BY u.UserName
HAVING count(u.Username) <= all(SELECT COUNT(u.UserName)
								FROM Users u inner join Verejtje v on u.user_id = v.User_to
								GROUP by u.username)

END
go

---------------------------------------------------------------------

create procedure shikoUserinMeUserName
@username varchar(255)
as
BEGIN
SELECT Emri , Mbiemri , Qyteti , Shteti 
FROM Users
WHERE username = @username
END 
GO

---------------------------------------------------------------------

create procedure shikoUserinMeEmerMbiemer
@Emri varchar(255),
@mbiemri varchar(255)
as
BEGIN
SELECT Emri , Mbiemri , Qyteti , Shteti , username
FROM Users
WHERE Emri = @Emri and Mbiemri = @mbiemri
END 
GO

----------------------------------------------------------------
CREATE procedure SelectAllUsers

@search varchar(255)

as

select * from Users 

where
(emri LIKE @search + '%' OR

Mbiemri LIKE @search + '%' OR
Qyteti LIKE @search + '%' OR
Shteti LIKE @search + '%' OR

email LIKE @search + '%' OR
username LIKE @search + '%' OR
Gjinia LIKE @search + '%')
AND active = 1
go
------------------------------------------------------------

CREATE procedure SelectAllUsersByPosts

@search varchar(255)

as

select * from Users u inner join Posts p on u.user_id = p.user_id

where
(p.Pershkrimi LIKE @search + '%' OR

p.Lloji LIKE @search + '%' OR
p.[Data e krijimit] LIKE @search + '%'
or p.user_id  LIKE @search + '%'
)
AND active = 1
go

-----------------------------------------

CREATE procedure SelectAllUsersByComments

@search varchar(255)

as

select * from Users u inner join Comments k on u.user_id = k.user_id

where
(k.[Data e komentimit] LIKE @search + '%' OR

k.[Data e ndryshimit] LIKE @search + '%' OR
k.Permbajtja LIKE @search + '%' 
or k.user_id like @search + '%'
)
AND active = 1
go


--------------------------------------------------
create procedure gjejPostinMeMeSeShumtiLikeNgaUsers
as
BEGIN
SELECT p.post_id , COUNT(l.post_id) as [Numri i likeve ne post]
FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
WHERE u2.Prioriteti = 1 
GROUP BY p.post_id
HAVING COUNT(l.Post_id) >= all( SELECT COUNT(l.post_id)
								FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
								WHERE u2.Prioriteti = 1
								GROUP BY l.post_id )
END
go

------------------------------------------------------------

create procedure gjejPostinMeMeSePakuLikeNgaUsers
as
BEGIN
SELECT p.post_id , COUNT(l.post_id) as [Numri i likeve ne post]
FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
WHERE u2.Prioriteti = 1 
GROUP BY p.post_id
HAVING COUNT(l.Post_id) <= all( SELECT COUNT(l.post_id)
								FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
								WHERE u2.Prioriteti = 1
								GROUP BY l.post_id )
END
go

-------------------------------------------------------------------------------
create procedure gjejPostinMeMeSeShumtiLikeNgaAdmini
as
BEGIN
SELECT u.user_id , COUNT(l.post_id) as [Numri i likeve]
FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
WHERE u2.Prioriteti = 2
GROUP BY p.post_id , u.user_id
HAVING COUNT(l.Post_id) >=all ( SELECT COUNT(l.post_id)
								FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
								WHERE u2.Prioriteti = 2
								GROUP BY l.post_id )
END
go

-------------------------------------------------------------------------------------------
create procedure gjejPostinMeMeSePakuLikeNgaAdmini
as
BEGIN
SELECT u.user_id , COUNT(l.post_id) as [Numri i likeve]
FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
WHERE u2.Prioriteti = 2
GROUP BY p.post_id , u.user_id
HAVING COUNT(l.Post_id) <=all ( SELECT COUNT(l.post_id)
								FROM Posts p inner join Likes l on p.post_id = l.post_id inner join Users u on p.user_id = u.user_id inner join UserGroup u2 on u.Prioriteti = u2.Prioriteti
								WHERE u2.Prioriteti = 2
								GROUP BY l.post_id )
END
go

------------------------------------------------------------------------------------

create procedure unblock
@username varchar(255),
@usernameUnblock varchar(255)
as
BEGIN
Delete b
FROM Bllok b inner join Users u on b.[User from] = u.user_id inner join Users u2 on u2.user_id = b.[User to]
WHERE @username = u.username and @usernameUnblock = u2.username
END
GO

-----------------------------------------------------------------------------------------------

create procedure getBlock
@username varchar(255)
as
BEGIN
SELECT u.username
FROM Users u inner join Bllok b on u.user_id = b.[User to] inner join Users u2 on b.[User from] = u2.user_id
WHERE u2.username = @username
END
GO


------------------------------------------------------------------------------------------------

SELECT *
FROM Comments k inner join Posts p on k.post_id = p.post_id inner join Likes l on p.post_id = l.post_id 

SELECT u.Emri as [Derguesi] , u2.Emri as [Pranuesi] , m.Texti
FROM Users u inner join Messages m on u.user_id = m.user_id_from inner join Users u2 on u2.user_id = m.user_id_to

----------------------------------------------------------------------------------------------------
