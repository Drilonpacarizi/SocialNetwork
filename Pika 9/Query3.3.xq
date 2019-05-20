xquery version "1.0";

for $p in /SocialNetwork1/SocialNetwork/Posts
for $l in /SocialNetwork1/SocialNetwork/Likes
for $k in /SocialNetwork1/SocialNetwork/Comments 
where($p/@post_id = $l/@post_id) and ($k/@post_id = $p/@post_id)
return ($p , $l , $k)
