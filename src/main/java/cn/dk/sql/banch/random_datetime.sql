DELIMITER $$

USE `dk_test`$$

DROP FUNCTION IF EXISTS `random_datetime`$$

CREATE DEFINER=`root`@`%` FUNCTION `random_datetime`(startdate DATETIME, enddate DATETIME) RETURNS DATETIME
BEGIN
    DECLARE interval_minute INT DEFAULT 0;
    DECLARE result_datetime DATETIME DEFAULT startdate;
    SET interval_minute = TIMESTAMPDIFF(MINUTE, startdate, enddate);
    SET result_datetime = TIMESTAMPADD(MINUTE, FLOOR(interval_minute * RAND()),startdate);
    RETURN result_datetime;
    END$$

DELIMITER ;