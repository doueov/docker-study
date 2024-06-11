const express = require('express')
const mysql = require('mysql2');

const connection = mysql.createConnection({
    // 컨테이너 이름을 도메인으로 사용하는 것을 유의!
    host: 'mysql-container',
    user: 'root',
    password: '1234',
    database: 'mydatabase'
});

async function redisTestFunc() {
    const client = redis.createClient({
        // 컨테이너 이름을 도메인으로 사용하는 것을 유의!
        url: 'redis://redis-container:6379'
    })
    // 레디스 연결
    await client.connect();
    // 키, 값 설정
    await client.set('hello', 'world');
    const value = await client.get('hello');
    console.log(value);
    await client.disconnect();
}
redisTestFunc();

// MySQL 서버에 연결
connection.connect(function (err) {
    if (err) {
        console.error('Error connecting to MySQL database: ' + err.stack);
        return;
    }
    console.log('Connected to MySQL database as id ' + connection.threadId);
});

const app = express();
const port = 3000;

app.get('/', (req, res) => {
    res.send('Hello World!')
})

app.get('/add', (req, res) => {
    const newUserData = { username: 'new user', email: 'newuser@example.com' };
    connection.query('INSERT INTO users SET ?', newUserData, function (err, results, fields) {
        if (err) {
            console.error('Error inserting data into MySQL database: ' + err.stack);
            res.status(500).send();
            return;
        }
        console.log('Inserted new user with ID ' + results.insertId);
        res.status(200).send();
    });
})

app.get('/users', (req, res) => {
    connection.query('SELECT * FROM users', (err, rows) => {
        if (err) {
            console.error('Error selecting data from MySQL database: ' + err.stack);
            // 상태 코드 500을 돌려줍니다.
            res.status(500).send();
            return;
        }
        // 상태 코드 200을 돌려줍니다.
        res.json(rows);
    });
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})