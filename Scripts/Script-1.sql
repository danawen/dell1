CREATE TABLE appointments (
	id INTEGER PRIMARY KEY AUTOINCREMENT,
	apptDateTime INTEGER NOT NULL,
	clientId INTEGER,
	reason TEXT(255) NOT NULL,
	comments TEXT(255),
	scheduleComplete INTEGER DEFAULT 0 NOT NULL
);