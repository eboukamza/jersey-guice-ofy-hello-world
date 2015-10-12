jersey-guice-ofy-hello-word
===========================

This is a basic poc of using Jersey v2 &amp; Guice v3 &amp; Objectify v4 in a Java Appengine application.

Step 1
The application exposes a REST api in /api/ that allows to create Hello resources

Hello schema is:

    {
        id: Long,
        name: String,
        user: User
    }

 - [GET] /hello/ for retrieve all entities
 - [GET] /hello/{id} for retrieve a hello entity by id
 - [POST] in /hello/ with a hello body to create new Hello entity

Uses Security constraint and use of UserService for retrieve user info and store it in Hello entity
