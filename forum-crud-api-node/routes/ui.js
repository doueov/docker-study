const express = require('express')
const { pool } = require('../database')
router = express.Router()

const template = `<!DOCTYPE html>
<html>
    <body>
        <div>%data</div>
    </body>
</html>`

router.get("/posts", (req, res) => {
    res.setHeader("Content-Type", "text/html")
    pool.query("SELECT * FROM posts",
        function (err, rows, fields) {
            res.send(template.replace("%data", "<ul>" + (rows.map(row => `<li>${row.title}</li>`)).join("\n") + "</ul>"))
        })
})

router.get("/posts/:id", (req, res) => {
    const id = req.params.id
    pool.query("SELECT * FROM posts WHERE id = ?",
        [id],
        function (err, rows, fields) {
            if (rows.length === 0) {
                res.status(404).send(template.replace("%data", "not found"))
            } else {
                const post = rows[0]
                res.send(template.replace("%data", `<h1>${post.title}</h1><h2>${post.author}</h2><p>${post.content}</p>`))
            }
        }
    )
})

module.exports = router