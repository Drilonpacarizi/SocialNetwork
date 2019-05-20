xquery version "1.0";

for $u in /SocialNetwork1/SocialNetwork/Users
where $u/username = 'flamurjahiri'
return $u