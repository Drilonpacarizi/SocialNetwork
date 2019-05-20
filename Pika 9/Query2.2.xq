xquery version "1.0";

declare namespace ext="http://www.altova.com/xslt-extensions";
(:SELECT u.username as Pranuesi , u2.username as Derguesi
FROM Messages m inner join Users u on m.user_id_to = u.user_id inner join Users u2 on u2.user_id = m.user_id_from
WHERE @usernameyT = u2.username or @usernameyT = u.username:)

for $u in /SocialNetwork1/SocialNetwork/Users
for $m in /SocialNetwork1/SocialNetwork/Messages
for $u1 in /SocialNetwork1/SocialNetwork/Users

where ($m/@user_id_to=$u/@user_id) and ($u1/@user_id=$m/@user_id_from) and (('flamurjahiri'=$u1/username) or ('flamurjahiri'=$u/username))

return ($u/username,$u1/username , $m)

