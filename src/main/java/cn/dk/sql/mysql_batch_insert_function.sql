DELIMITER $$

DELIMITER $$

USE `dk_test`$$

DROP PROCEDURE IF EXISTS `banch_insert_iddatetime_data`$$
-- 根据时间范围插入指定数量的 id_datetime 表记录
CREATE DEFINER=`root`@`%` PROCEDURE `banch_insert_iddatetime_data`(
  n INT,
  startdate DATETIME,
  enddate DATETIME
)
BEGIN
  DECLARE i INT DEFAULT 0 ;
  DECLARE v_to_commit BOOLEAN DEFAULT FALSE ;
  -- 一次插入 5000 条记录
  DECLARE v_commit INT DEFAULT 5000 ;
  DECLARE v_table_column TEXT DEFAULT 'insert into id_datetime(date,content) values' ;
  DECLARE v_datetime DATETIME ;
  DECLARE v_content VARCHAR(256) ;
  -- 使用用户变量存储动态 sql 字符串
  SET @sql = v_table_column ;
  WHILE
    i < n DO SET v_datetime = random_datetime (startdate, enddate) ;
    SET v_content = 100 * RAND() ;
    -- 拼接批量插入的 sql
    SET @sql = CONCAT(
      @sql,
      '(''',
      v_datetime,
      ''',''',
      v_content,
      ''')'
    ) ;
    SET v_to_commit = i % v_commit = 0 
    OR i = n ;
    -- 进行尾部判断
    IF v_to_commit = 0 
    THEN SET @sql = CONCAT(@sql, ',') ;
    END IF ;
    IF v_to_commit = 1 
    THEN SET @sql = CONCAT(@sql, ';') ;
    -- 执行批量 insert
    PREPARE stmt FROM @sql ;
    EXECUTE stmt ;
    DEALLOCATE PREPARE stmt ;
    -- sql 字符串复位
    SET @sql = v_table_column ;
    END IF ;
    SET i = i + 1 ;
  END WHILE ;
END$$

DELIMITER ;