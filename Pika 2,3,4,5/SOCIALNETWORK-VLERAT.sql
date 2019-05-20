USE SocialNetwork

--Tabela USERS
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Flamur' , 'Jahiri' , 'M' , 'Prishtine' , 'Kosove' , CAST('18-AUG-1999' as date) ,CONVERT(date, getdate()) , 'flamurjahiri' , '123456' , 'jahiriflamur@gmail.com' , 2, 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Drilon' , 'Pacarizi' , 'M' , 'Prishtine' , 'Kosove' , CAST('15-MAR-1999' as date), CONVERT(date, getdate()) , 'drilonpacarizi' , '123456' , 'drilonpacarizi@gmail.com' , 2 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Ardi' , 'Krasniqi' , 'M' , 'Terpez e poshtme' , 'Kosove' , CAST('20-Sep-1999' as date), CONVERT(date, getdate()) , 'ardikrasniqi' , '123456' , 'ardikrasniqi@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Trim' , 'Muharremi' , 'M' , 'Ferizaj' , 'Kosove' , CAST('15-Jan-1999' as date), CONVERT(date, getdate()) , 'trimmuharremi' , '123456' , 'trimmuharremi@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Vullkan' , 'Topanica' , 'M' , 'Prishtine' , 'Kosove' , CAST('23-FEB-1998' as date), CONVERT(date, getdate()) , 'vullkantopanica' , '123456' , 'vullkantopanica@gmail.com' , 1 , 0  ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Mark' , 'Ndrecaj' , 'M' , 'Kline' , 'Kosove' , CAST('18-Jan-2000' as date), CONVERT(date, getdate()) , 'mn' , '123456' , 'mn@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Antigona' , 'Bajraktari' , 'F' , 'Prishtine' , 'Kosove' , CAST('23-OCT-1999' as date) , CONVERT(date, getdate()), 'antigonaB' , '123456' , 'ab@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Tringa' , 'Tahiri' , 'F' , 'Peje' , 'Kosove' , CAST('20-Dec-1999' as date) , CONVERT(date, getdate()), 'tringaTahiri' , '123456' , 'tringa-t@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Teuta' , 'Januzi' , 'F' , 'Mitrovic' , 'Kosove' , CAST('19-June-1999' as date), CONVERT(date, getdate()) , 'teuta123' , '123456' , 'teuta_jonuzi@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Xhyla' , 'Gollopani' , 'F' , 'Koliqi' , 'Kosove' , CAST('17-Jul-1999' as date) , CONVERT(date, getdate()) ,  'xhylangaKolici' , '123456' , 'xhyla9@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Magbule' , 'Hajdari' , 'F' , 'Kuks' , 'Shqiperia' , CAST('23-Nov-1999' as date) , CONVERT(date, getdate()) ,  'magbulja' , '123456' , 'magbuljasw@gmail.com' , 1 , 1   ); 
insert into Users(Emri , Mbiemri , Gjinia , Qyteti , Shteti , [Data e lindjes] , [Data e krijimit] , username , password , email, Prioriteti , active) values 
('Kushtrim' , 'Hajdari' , 'M' , 'Diber' , 'Shqiperia' , CAST('23-Dec-1999' as date) , CONVERT(date, getdate()) ,  'kusha' , '123456' , 'kusha123@gmail.com' , 1 , 1   ); 




--Tabela Posts
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (1,'Fotografia e pare', 'foto', '2016-09-03 12:05:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (5,'video e pare', 'video', '2016-09-03 12:05:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (7,'video e pare', 'video', '2016-09-03 12:06:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (6,'Fotografia e pare', 'foto', '2016-09-03 12:07:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (6,'Fotografia e dyte', 'foto', '2016-09-03 12:08:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (1,'Texti i pare', 'text', '2016-09-03 12:09:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (1,'Texti i dyte', 'text', '2016-09-03 12:10:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (1,'Texti i trete', 'text', '2016-09-03 12:20:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (2,'video e pare', 'video', '2016-09-03 12:20:00')
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (5,'foto e pare', 'foto', CONVERT(date, getdate()) )
insert into Posts(user_id , pershkrimi,lloji,[Data e krijimit]) values (5,'Texti i pare', 'Text', CONVERT(datetime, GETDATE()) )



--Tabela MESSAGES
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (11,4,'Pershendetje ! ','2016-09-04 01:00:00','2016-09-04 01:10:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (2,5,'A po mi qon detyrat e kimise.','2017-09-03 11:00:00','2017-09-03 11:05:02')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (1,7,'Kur po dalum me msu ne biblotek.','2017-10-03 12:01:00','2017-10-03 12:02:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (4,12,'Kur mujna me u taku !','2018-09-03 12:00:00','2018-09-03 12:05:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (6,6,'Detyra 1 : Ku lindi Migjeni ? ','2018-09-03 02:00:57','2018-09-03 02:01:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (5,10,'Ne rregull','2018-05-08 13:00:00','2018-05-09 12:15:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (7,1,'Neser','2018-04-08 12:00:00','2018-04-09 12:15:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (1,8,'<3','2019-01-01 00:00:00','2019-01-031 00:00:01')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (7,8,'Hello','2018-04-08 01:00:00','2018-09-03 01:15:00')
insert into Messages(user_id_from, user_id_to, texti, [Data e dergimit],[Ora e leximit]) values  (7,8,'Pershendetje','2019-01-02 12:00:00','2019-01-02 12:15:00')



--Tabela Following
insert into Followings(user_id , following_id , Data) values (1 , 2 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (4 , 2 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (1 , 6 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (6 , 1 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (3 , 4 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (4 , 5 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (2 , 7 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (5 , 2 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (8 , 2 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (7 , 6 , CONVERT(date, getdate()));
insert into Followings(user_id , following_id , Data) values (7 , 5 , CONVERT(date, getdate()));


--Tabela Komentet
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (1,1,'komenti 1' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (2,1,'komenti 2' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (2,1,'komenti 3' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (4,5,'komenti 1' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (5,5,'komenti 1' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (6,1,'komenti 1' , '2016-09-03 12:09:00' , CONVERT(datetime, GETDATE()))
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (7,7,'komenti 1' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (8,5,'komenti 1' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (11,1,'komenti 1' , CONVERT(datetime, GETDATE()),null)
insert into Comments(post_id, user_id, permbajtja, [Data e komentimit], [Data e ndryshimit]) values (12,2,'komenti 1' , CONVERT(datetime, GETDATE()),null)


--Tabela Likes
insert into Likes(user_id, post_id,[Koha e Like-t]) values (1,1,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (1,2,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (1,4,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (2,1,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (2,1,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (2,5,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (5,1,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (5,1,CONVERT(datetime, GETDATE())) 
insert into Likes(user_id, post_id,[Koha e Like-t]) values (1,1,CONVERT(datetime, GETDATE()))
insert into Likes(user_id, post_id,[Koha e Like-t]) values (4,1,CONVERT(datetime, GETDATE())) 
 


--Tabela Verejtje

insert into Verejtje(Data,Pershkrimi ,  User_from , user_to) values (CONVERT(date, getdate()) , 'SPAM' , 2, 1)
insert into Verejtje(Data,Pershkrimi ,  User_from , user_to) values (CONVERT(date, getdate()) , 'Report : Mosha jo e sakte' , 2, 8)
insert into Verejtje(Data,Pershkrimi ,  User_from , user_to) values (CONVERT(date, getdate()) , 'Report : Komente banale' , 2, 4)
insert into Verejtje(Data,Pershkrimi ,  User_from , user_to) values (CONVERT(date, getdate()) , 'Report : IP Adresa ka tentuar te log-in si user te tjere' , 2, 7)



--Tabela Shitja
insert into Shitja(user_id,username, add_id, koha ,produkti) values (1,'flamurjahiri', 0, '2018-09-03 12:05:00', 'PC')
insert into Shitja(user_id ,username, add_id, koha ,produkti) values (2,'drilonpacarizi', 0, '2018-10-03 01:05:00', 'Telefon')
insert into Shitja(user_id ,username, add_id, koha ,produkti) values (3,'ardikrasniqi', 0, '2018-09-09 05:05:00', 'Veture')
insert into Shitja(user_id ,username, add_id, koha ,produkti) values (4,'trimmuharremi', 1, '2018-09-03 12:05:00', 'PC')
insert into Shitja(user_id ,username, add_id, koha ,produkti) values (5,'vullkantopanica', 1, '2019-01-01 02:05:00', 'Banese')

