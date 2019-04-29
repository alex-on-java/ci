CREATE TABLE ci.sample (
  id         SERIAL PRIMARY KEY   NOT NULL,
  name       VARCHAR(255)         NOT NULL,
  UNIQUE (name)
);