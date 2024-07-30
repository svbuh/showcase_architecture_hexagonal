INSERT INTO USERS (id, username, privileged)
VALUES
    (RANDOM_UUID(), 'albus', true),
    (RANDOM_UUID(), 'severus', true),
    (RANDOM_UUID(), 'hagrid', true),
    (RANDOM_UUID(), 'draco', false),
    (RANDOM_UUID(), 'hermine', false),
    (RANDOM_UUID(), 'ron', false),
    (RANDOM_UUID(), 'harry', false);