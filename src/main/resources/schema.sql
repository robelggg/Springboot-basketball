CREATE TABLE IF NOT EXISTS player (
    name VARCHAR(255) PRIMARY KEY,  -- This corresponds to the @Id annotation and unique constraint
    team VARCHAR(255),
    blocks DOUBLE,
    steals DOUBLE,
    rebounds DOUBLE,
    assists DOUBLE,
    minutes_played DOUBLE,
    points_per_game DOUBLE
);
