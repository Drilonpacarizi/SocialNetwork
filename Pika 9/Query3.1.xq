xquery version "1.0";

(:SELECT k.permbajtja
from Comments k inner join Posts p on k.post_id = p.post_id inner join Users u on k.user_id = u.user_id
:)

for $k in /SocialNetwork1/SocialNetwork/Comments 
for $p in /SocialNetwork1/SocialNetwork/Posts
for $u in /SocialNetwork1/SocialNetwork/Users

where ($k/@post_id = $p/@post_id) and ($u/@user_id = $k/@user_id)
return ($k/Permbajtja , $p)
