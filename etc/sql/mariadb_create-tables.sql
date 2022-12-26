use demo;

drop table task;

CREATE TABLE task(
  id INT NOT NULL AUTO_INCREMENT,
  version INTEGER,
  name VARCHAR(50) NOT NULL,
  owner VARCHAR(200),
  status VARCHAR(10) NOT NULL,
  created TIMESTAMP,
  claimed TIMESTAMP,
  finished TIMESTAMP,
  PRIMARY KEY(id)
);



