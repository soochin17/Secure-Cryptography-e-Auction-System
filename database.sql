CREATE TABLE auction (
	auctionID BIGINT AUTO_INCREMENT NOT NULL,
	product_name VARCHAR(60) NOT NULL,
	product_desc VARCHAR(200) NOT NULL,
	floor_price DECIMAL(7,2) NOT NULL,
	status INTEGER DEFAULT 0,
	auctioneerID INTEGER NOT NULL,
	starttime TIMESTAMP,
	endtime TIMESTAMP,
	winnerID INTEGER DEFAULT 0,
	winning_price INTEGER DEFAULT NULL,
	PRIMARY KEY (auctionID)
);
CREATE TABLE auctioneer (
	auctioneerID BIGINT AUTO_INCREMENT NOT NULL,
	auctioneer_name VARCHAR(20) NOT NULL,
	auctioneer_pass VARCHAR(250) NOT NULL,
	eligibility INTEGER DEFAULT 0 NOT NULL,
	pk VARBINARY(30000) NOT NULL,
	sk VARBINARY(30000) NOT NULL,
	PRIMARY KEY (auctioneerID)
);
CREATE TABLE bid (
	bidID BIGINT AUTO_INCREMENT NOT NULL,
	token VARBINARY(60000) DEFAULT NULL,
	placing_time TIMESTAMP NOT NULL,
	bidderID INTEGER NOT NULL,
	auctionID INTEGER NOT NULL,
	PRIMARY KEY (bidID)
);
CREATE TABLE bidder (
	bidderID BIGINT AUTO_INCREMENT NOT NULL,
	bidder_name VARCHAR(20) NOT NULL,
	bidder_pass CHARACTER(60) NOT NULL,
	PRIMARY KEY (bidderID)
);

ALTER TABLE auction
	ADD FOREIGN KEY (auctioneerID) 
	REFERENCES auctioneer (auctioneerID);


ALTER TABLE bid
	ADD FOREIGN KEY (bidderID) 
	REFERENCES bidder (bidderID);

ALTER TABLE bid
	ADD FOREIGN KEY (auctionID) 
	REFERENCES auction (auctionID);