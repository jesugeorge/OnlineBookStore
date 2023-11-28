# OnlineBookStore


Steps to download and install postgres
Step 1: Download postgres using the following link: https://www.postgresql.org/download/windows/
Step 2: Install the exe file
Step 3: Provide download location
Step 4: Provide super user (postgres) credentials
Step 5: Proceed to install



Steps to run the project locally
Step 1: Ensure Java is installed in your machine. Typically Java 8 or later
Step 2: Clone the project to your machine.
Step 3: Open a terminal or command prompt and navigate to the root directory of your project. Use the following commands based on your build tool: mvn clean install
Step 4: After a successful build, you can run the application using the following command: mvn spring-boot:run 


URL: /books
HTTP Method: GET
Description: Returns a list of all books.
```
[
  {
    "id": 1,
    "title": "Book1",
    "author": "Author1",
    "ISBN": "ISBN1",
    "publishedDate": "2022-01-01",
    "genre": "Genre1"
  }
]

```

Get Book by ID Endpoint
URL: /books/{bookId}
HTTP Method: GET
Description: Returns the details of a specific book based on the provided bookId.
```
{
  "id": 1,
  "title": "Book1",
  "author": "Author1",
  "ISBN": "ISBN1",
  "publishedDate": "2022-01-01",
  "genre": "Genre1"
}
```

Add New Book Endpoint
URL: /books
HTTP Method: POST
Description: Adds a new book to the system.
{
  "id": 3,
  "title": "NewBook",
  "author": "NewAuthor",
  "ISBN": "NewISBN",
  "publishedDate": "2022-03-01",
  "genre": "NewGenre"
}


Update Book Endpoint
URL: /books
HTTP Method: PUT
Description: Updates an existing book.
{
  "id": 1,
  "title": "UpdatedBook",
  "author": "UpdatedAuthor",
  "ISBN": "UpdatedISBN",
  "publishedDate": "2022-04-01",
  "genre": "UpdatedGenre"
}


Delete Book by ID Endpoint
URL: /books/{bookId}
HTTP Method: DELETE
Description: Deletes a book based on the provided bookId.
{
  "id": 1,
  "title": "DeletedBook",
  "author": "DeletedAuthor",
  "ISBN": "DeletedISBN",
  "publishedDate": "2022-05-01",
  "genre": "DeletedGenre"
}


