INSERT INTO user (username, password, activated) VALUES ('admin', 'b8f57d6d6ec0a60dfe2e20182d4615b12e321cad9e2979e0b9f81e0d6eda78ad9b6dcfe53e4e22d1', true);

INSERT INTO authority (name) VALUES ('ROLE_USER');
INSERT INTO authority (name) VALUES ('ROLE_ADMIN');

INSERT INTO user_authority (username, authority) VALUES ('admin', 'ROLE_USER');
INSERT INTO user_authority (username, authority) VALUES ('admin', 'ROLE_ADMIN');

INSERT INTO obra VALUES (1);
INSERT INTO obra VALUES (2);