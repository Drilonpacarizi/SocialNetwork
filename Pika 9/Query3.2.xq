xquery version "1.0";

for $l in /SocialNetwork1/SocialNetwork/Likes 
for $p in /SocialNetwork1/SocialNetwork/Posts
for $u in /SocialNetwork1/SocialNetwork/Users

where ($l/@post_id = $p/@post_id) and ($u/@user_id = $l/@user_id)
return ($l/user_id,  $p)

