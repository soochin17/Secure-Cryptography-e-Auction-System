# Secure Cryptographic e-Auction system

This electronic auction system is developed using *Java* language with utilization of 
RSA asymmetric encryption, hash function and digital signature with the support of 
Java Cryptography Architecture (JCA). It consists of three phases: **Setup**, **Bid** and **Open**.

There are 2 entities involved in this system, which are Auctioneer and Bidder. In the proposed system, the bidder’s plain bid is encrypted first using the auctioneer’s
*pk* of the selected auction by the bidder during the transmission of a bid to the system. Next, the encrypted bid (*st*) signature is created and stored in the database 
to ensure the integrity of the bid. The proposed system follows the auction rule of FPSBA, as all the bidders can only place one bid for the same auction. Following 
the auction deadline, the proposed system moves on to bid opening. It retrieves the lists of sealed-bid (*T*) and signature of sealed-bid (*ST*), then decrypts the sealed-bid 
using the auctioneer’s *sk* once it passes the signature verification. All the opening bids are then compared to determine the winner. Once the highest bid (*max*) is 
determined, the system publishes and updates the winning price. All the auction participants can view the winning price only, and only the winner can view his winning 
product in his bidder panel.

For publication, please refer here https://ijtech.eng.ui.ac.id/article/view/5827

# Setup
1. The following tools are the requirements for setting up the system:
   - [Java SE Development Kit (JDK) 16.0.2](https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html) 
   - [H2 database](https://github.com/soochin17/HappyAuction/blob/main/h2-setup-2022-01-17.rar)
   - [.JAR file of the system](https://github.com/soochin17/HappyAuction/blob/main/HappyAuction-1.0.jar) 
2. Once the H2 database is installed, runs the *H2 Console*. Type ***"jdbc:h2:~/happyauction"*** in the JDBC URL field and clicks on Connect button.
3. Copy and paste the SQL queries that saved inside [*database.sql*](https://github.com/soochin17/HappyAuction/blob/main/database.sql) in the textbox, and runs the queries.
4. After the creation of database tables, disconnect the database.
5. Runs the *.JAR file* of the system.
6. The system will be displayed on the screen.

## Algorithm of RSA Asymmetric Encryption and Digital Signature Scheme
![a](https://user-images.githubusercontent.com/93151327/200515614-ec512fe1-0c8a-4e30-acfc-dfd68c0f7b7a.jpg)

## Algorithm for *Setup*, *Bid*, and *Open* phase
![b](https://user-images.githubusercontent.com/93151327/200513829-ce040ab6-839a-4e79-b2e8-8daa13dfcd6d.jpg)

## Screenshots of system
![c](https://user-images.githubusercontent.com/93151327/200518580-6e56f6ec-c4d3-4da7-aa87-cb84efc55cb7.jpg)

