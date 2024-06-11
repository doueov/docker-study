const express = require('express')
const bodyParser = require('body-parser')
const apiRoute = require('./routes/api')
const uiRoute = require('./routes/ui')
const app = express()

const port = 3000

app.use(bodyParser.json())
app.use("/api", apiRoute)
app.use("/ui", uiRoute)

app.listen(port, () => {
    console.log('running!')
})