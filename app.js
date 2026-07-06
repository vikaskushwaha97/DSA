const express = require("express");
const fs = require("fs");
const path = require("path");

const app = express();

// GET /files
app.get("/files", (req, res) => {
    fs.readdir("./files", (err, files) => {
        if (err) {
            return res.status(500).json({
                error: "Unable to read directory"
            });
        }

        res.status(200).json(files);
    });
});

// GET /file/:filename
app.get("/file/:filename", (req, res) => {
    const filePath = path.join(__dirname, "files", req.params.filename);

    fs.readFile(filePath, "utf8", (err, data) => {
        if (err) {
            return res.status(404).send("File not found");
        }

        res.status(200).send(data);
    });
});

// Any other route
app.use((req, res) => {
    res.status(404).send("Not Found");
});

module.exports = app;