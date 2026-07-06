const express = require('express');
const fs = require('fs');
const path = require('path');
const app = express();

app.use(express.json());

app.get('/', function(req,res){
    res.send("Hello World");

})








const PORT = process.env.PORT || 3000;
app.listen(PORT ,()=>{
    console.log(`server is running on http://localhost:${PORT}`);
})
