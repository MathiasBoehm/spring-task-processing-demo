drop table task;

CREATE TABLE task(
                     id SERIAL PRIMARY KEY,
                     version INTEGER,
                     name VARCHAR(50) NOT NULL,
                     owner VARCHAR(200),
                     status VARCHAR(10) NOT NULL,
                     created TIMESTAMP,
                     claimed TIMESTAMP,
                     finished TIMESTAMP
);