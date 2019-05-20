xquery version "1.0";

for $p in /SocialNetwork1/SocialNetwork/Posts
for $l in /SocialNetwork1/SocialNetwork/Likes
for $u in /SocialNetwork1/SocialNetwork/Users
for $ug in /SocialNetwork1/SocialNetwork/UserGroup
where($p/@post_id = $l/@post_id) and ($p/@user_id = $u/@user_id) and ($u/@Prioriteti = $ug/@Prioriteti) and ($ug/@Prioriteti = "A1")
return ($p , $l , $u , $ug)