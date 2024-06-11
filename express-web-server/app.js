const express = require('express')
const app = express()
const port = process.env.MY_PORT_NUM

app.get('/', (req, res) => {
    res.send('Hello World!' + port)
})

app.listen(port, () => {
    console.log(`Example app listening on port ${port}`)
})
