const mysql = require('mysql2')

const pool = mysql.createPool({
    host: 'mysql-container',
    port: 3306,
    user: 'root',
    password: '1234',
    database: 'forum_crud_db'
})

module.exports = {
    pool
}