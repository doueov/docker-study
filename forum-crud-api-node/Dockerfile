FROM node:20.14-alpine
WORKDIR /app
COPY package.json /app/package.json
RUN npm install
COPY . /app
RUN npm install
EXPOSE 3000
CMD ["node", "app.js"]