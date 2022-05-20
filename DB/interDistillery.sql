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
-- Table `user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user` ;

CREATE TABLE IF NOT EXISTS `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `date_created` DATETIME NULL,
  `active` TINYINT NULL,
  `role` VARCHAR(45) NULL,
  `profile_image_url` VARCHAR(2000) NULL,
  `banner_image_url` VARCHAR(2000) NULL,
  `biography` TEXT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mock_interview`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mock_interview` ;

CREATE TABLE IF NOT EXISTS `mock_interview` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `interview_date` DATE NULL,
  `interview_time` TIME NULL,
  `topic` TEXT NULL,
  `interviewee_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mock_interview_user1_idx` (`interviewee_id` ASC),
  CONSTRAINT `fk_mock_interview_user1`
    FOREIGN KEY (`interviewee_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `career_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `career_category` ;

CREATE TABLE IF NOT EXISTS `career_category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `career`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `career` ;

CREATE TABLE IF NOT EXISTS `career` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `career_title` VARCHAR(45) NULL,
  `description` TEXT NULL,
  `image_url` VARCHAR(2000) NULL,
  `low_salary` DECIMAL(10,2) NULL,
  `high_salary` DECIMAL(10,2) NULL,
  `career_catogory_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_career_career_catogory1_idx` (`career_catogory_id` ASC),
  CONSTRAINT `fk_career_career_catogory1`
    FOREIGN KEY (`career_catogory_id`)
    REFERENCES `career_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `job_listing`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_listing` ;

CREATE TABLE IF NOT EXISTS `job_listing` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `requirements` TEXT NULL,
  `company` VARCHAR(200) NULL,
  `pay_range_min` DECIMAL(10,2) NULL,
  `pay_range_max` DECIMAL(10,2) NULL,
  `benefits` TEXT NULL,
  `job_posting_url` VARCHAR(2000) NULL,
  `job_post_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `pay_scale_type` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_job_listing_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_job_listing_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project` ;

CREATE TABLE IF NOT EXISTS `project` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `project_name` VARCHAR(200) NULL,
  `description` TEXT NULL,
  `created_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  `career_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_project_user1_idx` (`user_id` ASC),
  INDEX `fk_project_career1_idx` (`career_id` ASC),
  CONSTRAINT `fk_project_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_career1`
    FOREIGN KEY (`career_id`)
    REFERENCES `career` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project_members`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_members` ;

CREATE TABLE IF NOT EXISTS `project_members` (
  `id` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `education_level`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `education_level` ;

CREATE TABLE IF NOT EXISTS `education_level` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `education_level` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `resume`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `resume` ;

CREATE TABLE IF NOT EXISTS `resume` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `contact_info` VARCHAR(200) NULL,
  `introduction` TEXT NULL,
  `experience` TEXT NULL,
  `degreed` TINYINT NULL,
  `user_id` INT NOT NULL,
  `job_listing_id` INT NULL,
  `education_level_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_resume_user1_idx` (`user_id` ASC),
  INDEX `fk_resume_job_listing1_idx` (`job_listing_id` ASC),
  INDEX `fk_resume_education_level1_idx` (`education_level_id` ASC),
  CONSTRAINT `fk_user_resume_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resume_job_listing1`
    FOREIGN KEY (`job_listing_id`)
    REFERENCES `job_listing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_resume_education_level1`
    FOREIGN KEY (`education_level_id`)
    REFERENCES `education_level` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_comment` ;

CREATE TABLE IF NOT EXISTS `user_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `content` TEXT NULL,
  `comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `in_reply_to_id` INT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_user_comment_user_comment1_idx` (`in_reply_to_id` ASC),
  CONSTRAINT `fk_user_comment_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_comment_user_comment1`
    FOREIGN KEY (`in_reply_to_id`)
    REFERENCES `user_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `study_guide`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `study_guide` ;

CREATE TABLE IF NOT EXISTS `study_guide` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `topic` VARCHAR(200) NULL,
  `learning_objectives` TEXT NULL,
  `content` TEXT NULL,
  `review` TEXT NULL,
  `career_id` INT NOT NULL,
  `resource_url` VARCHAR(2000) NULL,
  `user_id` INT NOT NULL,
  `image_url` VARCHAR(2000) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_study_guide_career1_idx` (`career_id` ASC),
  INDEX `fk_study_guide_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_study_guide_career1`
    FOREIGN KEY (`career_id`)
    REFERENCES `career` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_study_guide_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practice_quiz`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practice_quiz` ;

CREATE TABLE IF NOT EXISTS `practice_quiz` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `quiz_topic` VARCHAR(45) NULL,
  `study_guide_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_practice_quiz_study_guide1_idx` (`study_guide_id` ASC),
  CONSTRAINT `fk_practice_quiz_study_guide1`
    FOREIGN KEY (`study_guide_id`)
    REFERENCES `study_guide` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_has_study_guide`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_has_study_guide` ;

CREATE TABLE IF NOT EXISTS `user_has_study_guide` (
  `user_id` INT NOT NULL,
  `study_guide_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `study_guide_id`),
  INDEX `fk_user_has_study_guide_study_guide1_idx` (`study_guide_id` ASC),
  INDEX `fk_user_has_study_guide_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_has_study_guide_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_study_guide_study_guide1`
    FOREIGN KEY (`study_guide_id`)
    REFERENCES `study_guide` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `practice_quiz_question`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practice_quiz_question` ;

CREATE TABLE IF NOT EXISTS `practice_quiz_question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question` VARCHAR(200) NULL,
  `correct_answer` VARCHAR(200) NULL,
  `point_amount` INT NULL,
  `practice_quiz_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_practice_quiz_question_practice_quiz1_idx` (`practice_quiz_id` ASC),
  CONSTRAINT `fk_practice_quiz_question_practice_quiz1`
    FOREIGN KEY (`practice_quiz_id`)
    REFERENCES `practice_quiz` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user_quiz_answer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_quiz_answer` ;

CREATE TABLE IF NOT EXISTS `user_quiz_answer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_answer` VARCHAR(200) NULL,
  `practice_quiz_question_id` INT NOT NULL,
  `quiz_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `is_correct` TINYINT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_quiz_answer_practice_quiz_question1_idx` (`practice_quiz_question_id` ASC),
  INDEX `fk_user_quiz_answer_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_user_quiz_answer_practice_quiz_question1`
    FOREIGN KEY (`practice_quiz_question_id`)
    REFERENCES `practice_quiz_question` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_quiz_answer_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `study_guide_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `study_guide_comment` ;

CREATE TABLE IF NOT EXISTS `study_guide_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `content` TEXT NULL,
  `comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `in_reply_to_id` INT NULL,
  `study_guide_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_user_comment_user_comment1_idx` (`in_reply_to_id` ASC),
  INDEX `fk_user_comment_copy1_study_guide1_idx` (`study_guide_id` ASC),
  CONSTRAINT `fk_user_comment_user10`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_comment_user_comment10`
    FOREIGN KEY (`in_reply_to_id`)
    REFERENCES `study_guide_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_comment_copy1_study_guide1`
    FOREIGN KEY (`study_guide_id`)
    REFERENCES `study_guide` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project_has_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_has_user` ;

CREATE TABLE IF NOT EXISTS `project_has_user` (
  `project_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`project_id`, `user_id`),
  INDEX `fk_project_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_project_has_user_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_project_has_user_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `project_comment`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `project_comment` ;

CREATE TABLE IF NOT EXISTS `project_comment` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NULL,
  `content` TEXT NULL,
  `comment_date` DATETIME NULL,
  `user_id` INT NOT NULL,
  `in_reply_to_id` INT NULL,
  `project_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_comment_user1_idx` (`user_id` ASC),
  INDEX `fk_user_comment_user_comment1_idx` (`in_reply_to_id` ASC),
  INDEX `fk_project_comment_project1_idx` (`project_id` ASC),
  CONSTRAINT `fk_user_comment_user11`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_comment_user_comment11`
    FOREIGN KEY (`in_reply_to_id`)
    REFERENCES `project_comment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_project_comment_project1`
    FOREIGN KEY (`project_id`)
    REFERENCES `project` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mock_interviewer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mock_interviewer` ;

CREATE TABLE IF NOT EXISTS `mock_interviewer` (
  `mock_interview_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`mock_interview_id`, `user_id`),
  INDEX `fk_mock_interview_has_user_user1_idx` (`user_id` ASC),
  INDEX `fk_mock_interview_has_user_mock_interview1_idx` (`mock_interview_id` ASC),
  CONSTRAINT `fk_mock_interview_has_user_mock_interview1`
    FOREIGN KEY (`mock_interview_id`)
    REFERENCES `mock_interview` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mock_interview_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `skill` ;

CREATE TABLE IF NOT EXISTS `skill` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` TEXT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `job_skill`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `job_skill` ;

CREATE TABLE IF NOT EXISTS `job_skill` (
  `skill_id` INT NOT NULL,
  `resume_id` INT NOT NULL,
  `years_experience` INT NULL,
  PRIMARY KEY (`skill_id`, `resume_id`),
  INDEX `fk_skill_has_resume_resume1_idx` (`resume_id` ASC),
  INDEX `fk_skill_has_resume_skill1_idx` (`skill_id` ASC),
  CONSTRAINT `fk_skill_has_resume_skill1`
    FOREIGN KEY (`skill_id`)
    REFERENCES `skill` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill_has_resume_resume1`
    FOREIGN KEY (`resume_id`)
    REFERENCES `resume` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `date_created`, `active`, `role`, `profile_image_url`, `banner_image_url`, `biography`) VALUES (1, 'Nathan', 'Hafley', 'nhafley@interDistillery.com', 'nhadmin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `date_created`, `active`, `role`, `profile_image_url`, `banner_image_url`, `biography`) VALUES (2, 'Charley', 'Brown', 'cbrown@interDistillery.com', 'cbadmin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `user` (`id`, `first_name`, `last_name`, `email`, `username`, `password`, `date_created`, `active`, `role`, `profile_image_url`, `banner_image_url`, `biography`) VALUES (3, 'Angel', 'Casillas', 'aCasillas@interDistillery.com', 'acadmin', 'admin', NULL, NULL, NULL, NULL, NULL, NULL);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mock_interview`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `mock_interview` (`id`, `interview_date`, `interview_time`, `topic`, `interviewee_id`) VALUES (1, NULL, NULL, 'java', 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `career_category`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `career_category` (`id`, `name`, `description`) VALUES (1, 'Software Devlopment', 'Software development refers to a set of computer science activities dedicated to the process of creating, designing, deploying and supporting software. Software itself is the set of instructions or programs that tell a computer what to do. It is independent of hardware and makes computers programmable.');
INSERT INTO `career_category` (`id`, `name`, `description`) VALUES (2, 'Database Adminstration ', 'Database administrators use specialized software to store and organize data. The role may include capacity planning, installation, configuration, database design, migration, performance monitoring, security, troubleshooting, as well as backup and data recovery.');
INSERT INTO `career_category` (`id`, `name`, `description`) VALUES (3, 'Accounting', 'Accounting is the process of recording financial transactions pertaining to a business. The accounting process includes summarizing, analyzing, and reporting these transactions to oversight agencies, regulators, and tax collection entities.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `career`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `career` (`id`, `career_title`, `description`, `image_url`, `low_salary`, `high_salary`, `career_catogory_id`) VALUES (1, 'Java Developer', 'A Java Developer is responsible for the design, development, and management of Java-based applications. Because Java is used so widely, particularly by large organizations, the daily roles vary widely, but can include owning a particular application or working on several at one time', NULL, 70000, 115000, 1);
INSERT INTO `career` (`id`, `career_title`, `description`, `image_url`, `low_salary`, `high_salary`, `career_catogory_id`) VALUES (2, 'MySQL Database Administrator', 'A MySQL database administrator, sometimes shortened to DBA, manages databases for a website or company using the MySQL software. Your responsibilities are developing and maintaining the organization\'s information databases, setting up the database host, and ensuring secure storage of company information.', NULL, 71000, 110000, 2);
INSERT INTO `career` (`id`, `career_title`, `description`, `image_url`, `low_salary`, `high_salary`, `career_catogory_id`) VALUES (3, 'Python Developer', 'Python developers are computer programmers who specialize in writing server-side web application logic. Their job is to use the Python programming language to develop, debug, and implement application projects.', NULL, 65000, 120000, 1);
INSERT INTO `career` (`id`, `career_title`, `description`, `image_url`, `low_salary`, `high_salary`, `career_catogory_id`) VALUES (4, 'Accountant', 'Accountants ensure all financial records and statements are in line with laws, regulations, and generally accepted accounting principles (GAAP). Accountants must also resolve any discrepancies or irregularities they find in records, statements, or documented transactions.', NULL, 57000, 97000, 3);

COMMIT;


-- -----------------------------------------------------
-- Data for table `education_level`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `education_level` (`id`, `education_level`, `description`) VALUES (1, 'Bachelors', '4 year computer science degree');

COMMIT;


-- -----------------------------------------------------
-- Data for table `resume`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `resume` (`id`, `contact_info`, `introduction`, `experience`, `degreed`, `user_id`, `job_listing_id`, `education_level_id`) VALUES (1, 'hi', 'This is an introduction', '5  years experience with java', 1, 1, NULL, 1);

COMMIT;


-- -----------------------------------------------------
-- Data for table `mock_interviewer`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `mock_interviewer` (`mock_interview_id`, `user_id`) VALUES (1, 2);

COMMIT;


-- -----------------------------------------------------
-- Data for table `skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `skill` (`id`, `name`, `description`) VALUES (1, 'Java', 'Write Java Applications');
INSERT INTO `skill` (`id`, `name`, `description`) VALUES (2, 'Accounting', 'Recording financial transactions pertaining to a business.');

COMMIT;


-- -----------------------------------------------------
-- Data for table `job_skill`
-- -----------------------------------------------------
START TRANSACTION;
USE `interdistillerydb`;
INSERT INTO `job_skill` (`skill_id`, `resume_id`, `years_experience`) VALUES (1, 1, 5);

COMMIT;

