-- Create Database
CREATE DATABASE IF NOT EXISTS demo CHARACTER SET UTF8 COLLATE UTF8_BIN;

-- Create User
CREATE USER 'demo' IDENTIFIED BY 'demo';

-- Grant Permissions to use and access Server
GRANT USAGE ON *.* TO 'demo'@'%' IDENTIFIED BY 'demo';

-- Grant all privileges to database
GRANT ALL PRIVILEGES on `demo`.* TO 'demo'@'%';