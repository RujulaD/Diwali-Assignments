const express = require('express');
const router = express.Router();
const db = require('../config/db');

// Route to register user
router.post('/register', (req, res) => {
  const { firstName, lastName, email, userId, password } = req.body;

  // Validation check
  if (!firstName || !lastName || !email || !userId || !password) {
    return res.status(400).json({ message: 'All fields are required' });
  }

  const sql = 'INSERT INTO Users (firstName, lastName, email, userId, password) VALUES (?, ?, ?, ?, ?)';
  db.query(sql, [firstName, lastName, email, userId, password], (err, result) => {
    if (err) {
      console.error('❌ Error inserting data:', err);
      return res.status(500).json({ message: 'Database error' });
    }
    res.status(200).json({ message: '✅ User registered successfully!' });
  });
});

module.exports = router;
