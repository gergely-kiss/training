/*
 * HSQLDB script.
 * Load the database with reference data and unit test data.
 */

INSERT INTO Greeting (text) VALUES ('Hello World!');
INSERT INTO Greeting (text) VALUES ('Hola Mundo!');

-- password is 'password'
INSERT INTO Account (referenceId, username, password, enabled, credentials_expired, expired, locked, version, created_by, created_at, updated_by, updated_at) VALUES ('a07bd221-3ecd-4893-a0f0-78d7c0fbf94e', 'user', '$2a$10$9/44Rne7kQqPXa0cY6NfG.3XzScMrCxFYjapoLq/wFmHz7EC9praK', true, false, false, false, 0, 'user', NOW(), 'System Admin', NOW());
-- password is 'operations'
INSERT INTO Account (referenceId, username, password, enabled, credentials_expired, expired, locked, version, created_by, created_at, updated_by, updated_at) VALUES ('7bd137c8-ab64-4a45-bf2d-d9bae3574622', 'operations', '$2a$10$CoMVfutnv1qZ.fNlHY1Na.rteiJhsDF0jB1o.76qXcfdWN6As27Zm', true, false, false, false, 0, 'user', NOW(), 'System Admin', NOW());

INSERT INTO Role (id, code, label) VALUES (1, 'ROLE_USER', 'User');
INSERT INTO Role (id, code, label) VALUES (2, 'ROLE_ADMIN', 'Admin');
INSERT INTO Role (id, code, label) VALUES (3, 'ROLE_SYSADMIN', 'System Admin');

INSERT INTO Account_Role (account_id, role_id) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'user' and r.id = 1;
INSERT INTO Account_Role (account_id, role_id) SELECT a.id, r.id FROM Account a, Role r WHERE a.username = 'operations' and r.id = 3;
