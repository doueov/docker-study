FROM node:latest
WORKDIR /app
COPY package.json /app/package.json
# 글로벌 접근 가능하게 nodemon 설치
RUN npm install -g nodemon
RUN npm install
COPY . /app
# https://stackoverflow.com/questions/39239686/nodemon-doesnt-restart-in-windows-docker-environment
CMD ["nodemon", "--legacy-watch", "src/app.js"]