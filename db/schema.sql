CREATE SCHEMA `sport_calendar`;

CREATE TABLE `sport_calendar`.`cities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `sport_calendar`.`stadiums` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `_city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `_city_id_idx` (`_city_id` ASC) VISIBLE,
  CONSTRAINT `_city_id_stadium`
    FOREIGN KEY (`_city_id`)
    REFERENCES `sport_calendar`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE);

CREATE TABLE `sport_calendar`.`sports` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `sport_calendar`.`teams` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `_city_id` INT NOT NULL,
  `_stadium_id` INT NULL,
  `_sport_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `_city_id_idx` (`_city_id` ASC) VISIBLE,
  INDEX `_stadium_id_idx` (`_stadium_id` ASC) VISIBLE,
  INDEX `_sport_id_idx` (`_sport_id` ASC) VISIBLE,
  CONSTRAINT `_city_id_team`
    FOREIGN KEY (`_city_id`)
    REFERENCES `sport_calendar`.`cities` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `_stadium_id_team`
    FOREIGN KEY (`_stadium_id`)
    REFERENCES `sport_calendar`.`stadiums` (`id`)
    ON DELETE NO ACTION
    ON UPDATE CASCADE,
  CONSTRAINT `_sport_id_team`
    FOREIGN KEY (`_sport_id`)
    REFERENCES `sport_calendar`.`sports` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `sport_calendar`.`matches` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `date` DATETIME NOT NULL,
  `_home_team_id` INT NOT NULL,
  `_away_team_id` INT NOT NULL,
  `_stadium_id` INT NOT NULL,
  `_sport_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `_home_team_id_match_idx` (`_home_team_id` ASC) VISIBLE,
  INDEX `_away_team_id_match_idx` (`_away_team_id` ASC) VISIBLE,
  INDEX `_stadium_id_match_idx` (`_stadium_id` ASC) VISIBLE,
  INDEX `_sport_id_match_idx` (`_sport_id` ASC) VISIBLE,
  CONSTRAINT `_home_team_id_match`
    FOREIGN KEY (`_home_team_id`)
    REFERENCES `sport_calendar`.`teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `_away_team_id_match`
    FOREIGN KEY (`_away_team_id`)
    REFERENCES `sport_calendar`.`teams` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `_stadium_id_match`
    FOREIGN KEY (`_stadium_id`)
    REFERENCES `sport_calendar`.`stadiums` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `_sport_id_match`
    FOREIGN KEY (`_sport_id`)
    REFERENCES `sport_calendar`.`sports` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
			
CREATE VIEW `sport_calendar`.`match_view` AS
    SELECT 
        `m`.`date` AS `DATE`,
        `t1`.`name` AS `HOME_TEAM`,
        `t2`.`name` AS `AWAY_TEAM`,
        `c`.`name` AS `CITY`,
        `sp`.`name` AS `SPORT`,
        `st`.`name` AS `STADIUM`
    FROM
        (((((`sport_calendar`.`matches` `m`
        LEFT JOIN `sport_calendar`.`teams` `t1` ON ((`m`.`_home_team_id` = `t1`.`id`)))
        LEFT JOIN `sport_calendar`.`teams` `t2` ON ((`m`.`_away_team_id` = `t2`.`id`)))
        LEFT JOIN `sport_calendar`.`stadiums` `st` ON ((`m`.`_stadium_id` = `st`.`id`)))
        LEFT JOIN `sport_calendar`.`sports` `sp` ON ((`m`.`_sport_id` = `sp`.`id`)))
        JOIN `sport_calendar`.`cities` `c` ON ((`st`.`_city_id` = `c`.`id`)));

INSERT INTO `sport_calendar`.`cities` (`name`) VALUES ('Vienna');
INSERT INTO `sport_calendar`.`cities` (`name`) VALUES ('Bratislava');
INSERT INTO `sport_calendar`.`cities` (`name`) VALUES ('Budapest');
INSERT INTO `sport_calendar`.`cities` (`name`) VALUES ('Prague');
INSERT INTO `sport_calendar`.`cities` (`name`) VALUES ('Warsaw');
INSERT INTO `sport_calendar`.`cities` (`name`) VALUES ('Berlin');

INSERT INTO `sport_calendar`.`sports` (`name`) VALUES ('Football');
INSERT INTO `sport_calendar`.`sports` (`name`) VALUES ('Basketball');
INSERT INTO `sport_calendar`.`sports` (`name`) VALUES ('Baseball');
INSERT INTO `sport_calendar`.`sports` (`name`) VALUES ('Hockey');
INSERT INTO `sport_calendar`.`sports` (`name`) VALUES ('Water polo');
INSERT INTO `sport_calendar`.`sports` (`name`) VALUES ('Volleyball');

INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Puskás Aréna', '3');
INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Duna Aréna', '3');
INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Allianz-Stadion', '1');
INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Strahov Stadium', '4');
INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Tehelné pole', '2');
INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Stadion Narodowy', '5');
INSERT INTO `sport_calendar`.`stadiums` (`name`, `_city_id`) VALUES ('Olympiastadion', '6');

INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_sport_id`) VALUES ('Team Lion', '2', '3');
INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_sport_id`) VALUES ('Team Monkey', '1', '5');
INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_stadium_id`, `_sport_id`) VALUES ('Team Water', '3', '2', '5');
INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_stadium_id`, `_sport_id`) VALUES ('Team Fire', '1', '3', '3');
INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_stadium_id`, `_sport_id`) VALUES ('Team Dog', '5', '6', '2');
INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_sport_id`) VALUES ('Team Seal', '4', '5');
INSERT INTO `sport_calendar`.`teams` (`name`, `_city_id`, `_stadium_id`, `_sport_id`) VALUES ('Team Elephant', '6', '7', '2');

INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-01-08 12:30:00','1','4','2','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-01-10 13:30:00','3','2','1','2');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-01-15 16:00:00','6','5','2','1');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-01-10 20:30:00','4','1','2','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-01-20 12:00:00','4','2','2','6');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-01-03 13:30:00','5','2','4','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-02-08 15:30:00','1','4','2','4');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-02-12 16:30:00','3','2','1','2');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-02-13 16:00:00','6','5','2','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-02-10 20:00:00','4','1','2','5');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-02-24 18:30:00','3','2','2','6');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-03 16:30:00','5','2','4','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-08 12:30:00','1','4','2','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-10 13:00:00','3','2','1','2');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-20 16:00:00','2','4','2','6');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-10 20:30:00','4','1','2','3');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-20 12:00:00','3','2','2','6');
INSERT INTO `sport_calendar`.`matches` (`date`,`_home_team_id`,`_away_team_id`,`_stadium_id`,`_sport_id`) VALUES ('2022-03-03 16:30:00','1','2','4','5');
