DROP DATABASE test;
CREATE DATABASE test;
USE test;
CREATE TABLE tickets
(
  id              INT unsigned NOT NULL AUTO_INCREMENT,
  user_id			INT unsigned NOT NULL,
  from_station            VARCHAR(150) NOT NULL,               
  to_station           VARCHAR(150) NOT NULL, 
  fare				INT unsigned NOT NULL,
  payment_method	VARCHAR(150) NOT NULL,
  is_cancelled		boolean,
  _date           DATE NOT NULL,                       
  _time			TIME NOT NULL,
  PRIMARY KEY     (id)            
);
-- INSERT INTO tickets(user_id,from_station,to_station,fare,payment_method,is_cancelled,_date,_time)
-- values(234,'kitasuna','omori',345,'credit',false,'2023-11-30','083000'),(456,'heiwajima','yokohama',567,'cash',true,current_date(),current_time());
DELIMITER $$

CREATE PROCEDURE generate_data()
BEGIN
  DECLARE i INT DEFAULT 1;
  
  WHILE i <= 300 DO
    INSERT INTO tickets (user_id, from_station, to_station, fare, payment_method, is_cancelled, _date, _time)
    VALUES (
      FLOOR(RAND() * 100) + 1, -- user_id
      CONCAT('Station ', FLOOR(RAND() * 10) + 1), -- from_station
      CONCAT('Station ', FLOOR(RAND() * 10) + 1), -- to_station
      FLOOR(RAND() * 100) + 10, -- fare
      IF(RAND() < 0.5, 'cash', 'credit'), -- payment_method
      IF(RAND() < 0.5, 1, 0), -- is_cancelled
      DATE_ADD(CURDATE(), INTERVAL FLOOR(RAND() * 365) DAY), -- _date
      CURTIME() -- _time
    );
    
    SET i = i + 1;
  END WHILE;
END $$

DELIMITER ;

CALL generate_data();
SELECT * FROM tickets;