const express = require("express");
const fs = require("fs");
const path = require("path");

const app = express();
app.use(express.json());

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

// POST /file
app.post("/file", (req, res) => {
    const { filename, content } = req.body;
    const filePath = path.join(__dirname, "files", filename);

    fs.writeFile(filePath, content, (err) => {
        if (err) {
            return res.status(500).json({
                error: "Unable to write file"
            });
        }

        res.status(201).json({ message: "File created successfully" });
    });
});

app.put("/file/:filename", (req, res) => {
    const filePath = path.join(__dirname, "files", req.params.filename);

    fs.writeFile(filePath, req.body.content, (err) => {
        if (err) {
            return res.status(500).send("Unable to update file");
        }

        res.send("File updated successfully");
    });
});

app.delete("/file/:filename", (req, res) => {
    const filePath = path.join(__dirname, "files", req.params.filename);

    fs.unlink(filePath, (err) => {
        if (err) {
            return res.status(404).send("File not found");
        }

        res.send("File deleted successfully");
    });
});

module.exports = app;