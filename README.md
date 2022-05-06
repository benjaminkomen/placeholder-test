# PlaceHolder Programming Test

This repository contains the implementation of a programming test done during the application process of the company
PlaceHolder.

## Execution instructions
Navigate to the root folder of this project in your terminal and execute:
```
./gradlew clean build
./gradlew run
```

This will first build and then run the application. A webserver will
start listening on http://localhost:8080.

Now you can navigate to http://localhost:8080/properties?id=10 or http://localhost:8080/properties/10 which will return
the specific property with property_id 10 or a 404 response if it cannot be found.

The database is preloaded with some sample data you can query:
- a warehouse property with id 1
- an office property with id 2

## Implementation notes
I used the Kotlin framework Ktor (https://ktor.io/) which I had not used yet,
but have heard of previously on conferences and twitter and this seemed like a good
opportunity to try it.

I used [this started project](https://github.com/raharrison/kotlin-ktor-exposed-starter) as a starting point, so I wouldn't
have to reinvent the wheel from scratch.

The `schema.sql` mentions foreign key constrains which make the foreign key relation between the four other tables than the
Properties table and the Properties table, explicit. They safeguard against updating or deleting. I did not implement those,
because my in-memory database implementation gave some errors when I tried to do. I don't think that's such a big deal,
since it is more of an implementation detail of the database.

The json response contains an additional attribute `type` which denotes whether the property is a warehouse or an office.
This attribute can optionally be removed from the output, if required.

A live demo is available via [Google Cloud Run](https://placeholder-test-fxyp3msj7a-ew.a.run.app).
This was done by simply executing `gcloud run deploy placeholder-test --source .` (and fixing some stuff to make a working fat jar)

## Assignment instructions

This test is designed to assess your level of programming ability and the general ways you approach fulfillment of 
technical requirements via software development. You are free to implement this with whatever languages or tools you wish,
 but your solution should be accompanied by instructions that explain how to run your code. Please take as much time as
  you like, but be aware this test is intended to take several hours.

Write a simple web server that handles a single URL and accepts a single integer via a query parameter. For example:
http://localhost/property?id=10

The web server should read the specified property data from a SQL database and return all related information in JSON
 format using an 'application/json' content type.  The exact format of the JSON object is up to you, but it should contain
  all available information on a property. Error conditions should be handled reasonably.

The database is defined in the `schema.sql` file. You can see a visual representation of the schema in the `schema.png` file.
  Properties are stored in the Properties table. Each property is either an office or a warehouse, and as such each row
   in the Properties table has an associated row in either the Offices or Warehouses table. Offices have zero or more
    meeting rooms, each of which is described in the MeetingRooms table. Warehouses have zero or more loading bays,
     each of which is described in the LoadingBays table.

Your code should be efficient, easy to read and understand, and reflect good engineering practice.

Don't hesitate to reach out with any questions or for help!
