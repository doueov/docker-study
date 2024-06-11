FROM node:latest
WORKDIR /app

COPY package.json /app/package.json
RUN npm install
COPY . /app

ENV MY_PORT_NUM=3000
EXPOSE ${MY_PORT_NUM}

CMD ["node", "app.js"]
