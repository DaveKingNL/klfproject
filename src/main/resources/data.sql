/*
INSERT INTO users (username, password, enabled, email)
	values('user', 'password', true, 'user@hotmail.com');
    
INSERT INTO users (username, password, enabled, email)
	values('admin', 'password', true, 'admin@gmail.com');
    
INSERT INTO users (username, password, enabled, email)
	values('klfuser', 'password', true, 'user@klf.ca');
    
INSERT INTO authorities (username, authority)
	values('user', 'ROLE_USER');
    
INSERT INTO authorities (username, authority)
	values('admin', 'ROLE_ADMIN');
    
INSERT INTO authorities (username, authority)
	values('klf', 'ROLE_ADMIN');

INSERT INTO activity (id, activity_name)
        values(null, 'update_profile');

INSERT INTO activity (id, activity_name)
        values(null, 'send_message');

INSERT INTO activity (id, activity_name)
        values(null, 'press_button');

INSERT INTO user_activity (id, user_id, activity_id, occurrence)
        values(null, 'user', '1', current_timestamp);

INSERT INTO user_activity (id, user_id, activity_id, occurrence)
        values(null, 'user', '2', current_timestamp);

INSERT INTO user_activity (id, user_id, activity_id, occurrence)
        values(null, 'user', '3', current_timestamp);*/