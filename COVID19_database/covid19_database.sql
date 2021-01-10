-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema covid19
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema covid19
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `covid19` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `covid19` ;

-- -----------------------------------------------------
-- Table `covid19`.`day_global`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `covid19`.`day_global` (
  `stdDay` TEXT NULL DEFAULT NULL,
  `areaName` TEXT NULL DEFAULT NULL,
  `nationName` TEXT NULL DEFAULT NULL,
  `defCnt` INT NULL DEFAULT NULL,
  `dayDefCnt` INT NULL DEFAULT NULL,
  `deathCnt` INT NULL DEFAULT NULL,
  `dayDeathCnt` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `covid19`.`day_sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `covid19`.`day_sido` (
  `stdDay` INT NULL DEFAULT NULL,
  `sido` TEXT NULL DEFAULT NULL,
  `dayDefCnt` INT NULL DEFAULT NULL,
  `dayDeathCnt` INT NULL DEFAULT NULL,
  `totalDefCnt` INT NULL DEFAULT NULL,
  `totalDeathCnt` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `covid19`.`total_global`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `covid19`.`total_global` (
  `stdDay` TEXT NULL DEFAULT NULL,
  `defCnt` INT NULL DEFAULT NULL,
  `dayDefCnt` INT NULL DEFAULT NULL,
  `deathCnt` INT NULL DEFAULT NULL,
  `dayDeathCnt` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `covid19`.`total_sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `covid19`.`total_sido` (
  `stdDay` INT NULL DEFAULT NULL,
  `sido` TEXT NULL DEFAULT NULL,
  `dayDefCnt` INT NULL DEFAULT NULL,
  `dayDeathCnt` INT NULL DEFAULT NULL,
  `totalDefCnt` INT NULL DEFAULT NULL,
  `totalDeathCnt` INT NULL DEFAULT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
