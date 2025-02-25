# Redis-Caching
**Spring Boot Application that Integrates with Redis to Cache User Data.**

Steps to Run API:
- If you have Redis installed run it using command line -> redis-server
- If you haven't Redis installed run it using docker -> docker run --name myredis -p 6379:6379 -d redis

After running the Spring Boot application test the API using URL -> http://localhost:8080/users/1

Application Componenets:
- User Model - This class to store user data
- Redis Configuration
  - This class configures Spring Data Redis to store objects as JSON in Redis.
  - It ensures Redis can serialize & deserialize Java objects correctly.
- User Service with Redis Caching
  - This First, check if the user exists in Redis.
  - If found in Redis, return it (faster).
  - If not found, fetch from the database, store it in Redis for 5 minutes.
- Rest Controller
  - This class provides routing for fetching data

Test the API with postman:<br>
1️⃣ First Request: Fetches data from "database" (simulated) & caches it.<br>
2️⃣ Second Request: Fetches data instantly from Redis.

What We Built?<br>
✅ Integrated Spring Boot + Redis <br>
✅ Implemented user caching (reduce DB calls) <br>
✅ Improved API performance <br>
✅ Used Spring Data Redis for easy management
