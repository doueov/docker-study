const express = require('express')
const { pool } = require("../database")
router = express.Router()

// router.get("/test", (req, res) => {
//     return "(api) test"
// })

router.post("/posts", (req, res) => {
    console.log(req.body)
    pool.query(
        'INSERT INTO posts (title, author, content, password) VALUES(?, ?, ?, ?)',
        [req.body.title, req.body.author, req.body.content, req.body.password],
        function (err, rows, fields) {
            if (err) res.json({ result: err })
            else res.json({ result: "success" })
        }
    )
})

router.get("/posts", (req, res) => {
    pool.query(
        'SELECT * FROM posts',
        function (err, rows) {
            res.json(rows)
        }
    )
})

router.get("/post/:id", (req, res) => {
    const id = req.params.id
    pool.query(
        'SELECT * FROM posts WHERE id = ?',
        function (err, rows, fields) {
            if(rows.length === 0) {
                res.status(404).end()
                
            }
            else {
                res.json(row[0])
            }
        }
    )
})

router.delete("/post/:id", (req, res) => {
    const id = res.params.id
    const password = req.body.password

    // { "password": 1234 }
    // 먼저 해당 id를 가진 행이 있는지부터 검사
    // 만약 없으면 404
    // 있으면 행의 password와 위에서 받은 password가 일치하는지 검사해서 일치하느느 경우에 delete 요청 보내기
    // 안일치하면 403
    pool.query(
        'SELECT * FROM posts WHERE id = ?',
        function (err, rows, fields) {
            
        }
    )
})

module.exports = router