CREATE TABLE team_member (
    user_id VARCHAR(15) PRIMARY KEY,
    first_name VARCHAR(15) NOT NULL,
    last_name VARCHAR(15) NOT NULL,
    team VARCHAR(15),
    img_url VARCHAR(1000)
);
