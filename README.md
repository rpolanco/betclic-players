# betclic-players

Test application for Betclic recruitment process 

# Requirements: 
- Docker
- Docker Compose

# To run the project:

```bash
./gradlew buildFatJar
docker build --no-cache -t betclic-players .
docker-compose up -d
```