const express = require("express");
const bodyParser = require("body-parser");
const mysql = require("mysql2");
const path = require("path");

const app = express();
const PORT = 3005;

// MySQL Database connection
const db = mysql.createConnection({
  host: "localhost",
  user: "root",        // change if you have a different user
  password: "Tushar@123",        // add your MySQL password here
  database: "mysql" // make sure this DB exists
});

db.connect(err => {
  if (err) {
    console.log("❌ Database connection failed:", err);
  } else {
    console.log("✅ Connected to MySQL Database");
  }
});

// Middleware
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static(path.join(__dirname, "public")));

// Routes
app.post("/register", (req, res) => {
  const { firstname, lastname, email, userid, password } = req.body;

  const sql = "INSERT INTO users (firstname, lastname, email, userid, password) VALUES (?, ?, ?, ?, ?)";
  db.query(sql, [firstname, lastname, email, userid, password], (err, result) => {
    if (err) {
      console.error("Error inserting data:", err);
      res.send("❌ Error saving data");
    } else {
      console.log("✅ Data inserted successfully");
      res.send("✅ Registration successful!");
    }
  });
});

app.listen(PORT, () => {
  console.log(`🚀 Server is running on http://localhost:${PORT}`);
});
