CREATE DATABASE sports_db;

use sports_db;

CREATE TABLE sports (
sport_id INT NOT NULL auto_increment,
sport_name VARCHAR (50) NOT NULL,
primary key (sport_id)
);