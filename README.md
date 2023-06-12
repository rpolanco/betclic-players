# betclic-players

Test application for Betclic recruitment process. 

# Requirements: 
- Docker
- Docker Compose

# To run the project:

```bash
mkdir ~/betclic
cd ~/betclic 
git clone https://github.com/rpolanco/betclic-players.git
cd ~/betclic/betclic-players
./gradlew buildFatJar
docker build --no-cache -t betclic-players .
docker-compose up -d
```