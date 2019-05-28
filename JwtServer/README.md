# springJwtSecurityDemo

> NOTE: it is not complete YET :(

This a JWT server (not a client).In this demo, an API is secured using JWT. In a JWT server, the user credentials are checked against a database,... and then the user is authenticated.
Access roles and other authentication and authorization information are bundled together and signed as a JWT. The client of the API will use JWT in subsequent API call for authentication/authorization. 

Unlike JWT client (OAth2, OpenID connect), for establishing JWT server we have to do a lot more configurations.

