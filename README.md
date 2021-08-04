###This project was written for understanding and doing testing of next:
1. RestAPI 
2. SQL
3. Git
4. GitHub
5. Docker

###User roles:
1. **USER_ROLE** - allow get/post/put
2. **ADMIN_ROLE** - allow get/post/put/delete

### API endpoints:
```
GET /books - returns all books from Book table

GET /books/{bookId} - returns book by id

POST /books - add new book

PUT /books/{bookId} - update existing book

DELETE /books/{bookId} - delete book by id
```

### Book entry:
1. **id**: unique id
2. **name**: String value with 50 max symbols
3. **author:** String value with 30 max symbols
4. **rating:** Float value from 0.0 to 5.0
5. **price:** Float value from 0 to 250000 max value

**Response example**:
```
{
    "id": 1,
    "name": "Clean Code",
    "author": "Robert C. Martin",
    "rating": 4.6,
    "price": 640
}
```

### How to run:
`
docker-compose up --build
`