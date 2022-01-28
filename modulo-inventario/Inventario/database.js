const mysql = require('mysql');

const connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'Admin123',
    database: 'fisiutiles'
});

module.exports = connection;