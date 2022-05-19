-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema interdistillerydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `interdistillerydb` ;

-- -----------------------------------------------------
-- Schema interdistillerydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `interdistillerydb` DEFAULT CHARACTER SET utf8 ;
USE `interdistillerydb` ;

-- -----------------------------------------------------
-- Table `job_listings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_listings` ;

CREATE TABLE IF NOT EXISTS `job_listings` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `requirements` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL,
  `pay range` VARCHAR(45) NULL,
  `benefits` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practice_quiz`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practice_quiz` ;

CREATE TABLE IF NOT EXISTS `practice_quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quiz_topic` VARCHAR(45) NULL,
  `questions` VARCHAR(45) NULL,
  `answers` VARCHAR(45) NULL,
  `grade` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `study_guide`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `study_guide` ;

CREATE TABLE IF NOT EXISTS `study_guide` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `topic` VARCHAR(45) NULL,
  `learning_objectives` VARCHAR(45) NULL,
  `sg_body` VARCHAR(45) NULL,
  `review` VARCHAR(45) NULL,
  `practice_quiz_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_study_guide_practice_quiz1_idx` (`practice_quiz_id` ASC),
  CONSTRAINT `fk_study_guide_practice_quiz1`
    FOREIGN KEY (`practice_quiz_id`)
    REFERENCES `practice_quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `careers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `careers` ;

CREATE TABLE IF NOT EXISTS `careers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `career_field` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `job_listings_id` INT NOT NULL,
  `study_guide_id` INT NOT NULL,
  `practice_quiz_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_careers_job_listings1_idx` (`job_listings_id` ASC),
  INDEX `fk_careers_study_guide1_idx` (`study_guide_id` ASC),
  INDEX `fk_careers_practice_quiz1_idx` (`practice_quiz_id` ASC),
  CONSTRAINT `fk_careers_job_listings1`
    FOREIGN KEY (`job_listings_id`)
    REFERENCES `job_listings` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_careers_study_guide1`
    FOREIGN KEY (`study_guide_id`)
    REFERENCES `study_guide` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_careers_practice_quiz1`
    FOREIGN KEY (`practice_quiz_id`)
    REFERENCES `practice_quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `progress_report`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `progress_report` ;

CREATE TABLE IF NOT EXISTS `progress_report` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `score` VARCHAR(45) NULL,
  `date` VARCHAR(45) NULL,
  `careers_id` INT NOT NULL,
  `practice_quiz_id` INT NOT NULL,
  PRIMARY KEY (`id`, `careers_id`),
  INDEX `fk_progress_report_careers1_idx` (`careers_id` ASC),
  INDEX `fk_progress_report_practice_quiz1_idx` (`practice_quiz_id` ASC),
  CONSTRAINT `fk_progress_report_careers1`
    FOREIGN KEY (`careers_id`)
    REFERENCES `careers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_progress_report_practice_quiz1`
    FOREIGN KEY (`practice_quiz_id`)
    REFERENCES `practice_quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_resume`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_resume` ;

CREATE TABLE IF NOT EXISTS `user_resume` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contact_info` VARCHAR(45) NULL,
  `introduction` VARCHAR(45) NULL,
  `experience` VARCHAR(45) NULL,
  `skills` VARCHAR(45) NULL,
  `education` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `discussion_board`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `discussion_board` ;

CREATE TABLE IF NOT EXISTS `discussion_board` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL,
  `post_description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `emaiil` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `date_created` VARCHAR(45) NULL,
  `active` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  `career_id` VARCHAR(45) NULL,
  `progress_report_id` INT NULL,
  `user_resume_id` INT NULL,
  `discussion_board_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_User_progress_report1_idx` (`progress_report_id` ASC),
  INDEX `fk_User_user_resume1_idx` (`user_resume_id` ASC),
  INDEX `fk_User_discussion_board1_idx` (`discussion_board_id` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  CONSTRAINT `fk_User_progress_report1`
    FOREIGN KEY (`progress_report_id`)
    REFERENCES `progress_report` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_user_resume1`
    FOREIGN KEY (`user_resume_id`)
    REFERENCES `user_resume` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_discussion_board1`
    FOREIGN KEY (`discussion_board_id`)
    REFERENCES `discussion_board` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mock_interview`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mock_interview` ;

CREATE TABLE IF NOT EXISTS `mock_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mock_id` VARCHAR(45) NULL,
  `user_id` VARCHAR(45) NULL,
  `comment_content` VARCHAR(45) NULL,
  `mock_date` VARCHAR(45) NULL,
  `interviewer_id` VARCHAR(45) NULL,
  `interviewee_id` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project` ;

CREATE TABLE IF NOT EXISTS `project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project_members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_members` ;

CREATE TABLE IF NOT EXISTS `project_members` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS user@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'user'@'localhost' IDENTIFIED BY 'user';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'user'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `user`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `user` (`id`, `first_name`, `last_name`, `emaiil`, `username`, `password`, `date_created`, `active`, `role`, `career_id`, `progress_report_id`, `user_resume_id`, `discussion_board_id`) VALUES (1, NULL, NULL, NULL, 'admin', 'password', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;

