-- ####### access control #######
-- authority
CREATE TABLE authority (
  name VARCHAR(50) NOT NULL PRIMARY KEY
);

-- user
CREATE TABLE user (
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  password VARCHAR(500),
  activated BOOLEAN DEFAULT FALSE
);

-- user's authority
CREATE TABLE user_authority (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES user (username),
    FOREIGN KEY (authority) REFERENCES authority (name),
    UNIQUE INDEX user_authority_idx_1 (username, authority)
);

-- access token
CREATE TABLE oauth_access_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR(256) DEFAULT NULL,
  user_name VARCHAR(256) DEFAULT NULL,
  client_id VARCHAR(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR(256) DEFAULT NULL
);

-- refresh token
CREATE TABLE oauth_refresh_token (
  token_id VARCHAR(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
);

-- ####### model #######
-- obra
CREATE TABLE obra (
  id INTEGER IDENTITY(1,1) NOT NULL,
  autor VARCHAR(50),
  titulo VARCHAR(50),
  ano INTEGER,
  edicao INTEGER,
  local VARCHAR(50),
  editora VARCHAR(50),
  paginas VARCHAR(50),
  isbn VARCHAR(50),
  issn VARCHAR(50)
);