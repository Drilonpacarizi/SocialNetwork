xquery version "1.0";

for $u in SocialNetwork1/SocialNetwork/Users
for $p in SocialNetwork1/SocialNetwork/Posts
where $u/@user_id = $p/@user_id
return $p
