CREATE TABLE `japanese_learning`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));

CREATE TABLE `japanese_learning`.`lesson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  `level` VARCHAR(10) NOT NULL,
  `content` LONGTEXT NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `japanese_learning`.`user_progress` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `lesson_id` INT NOT NULL,
    `completed` TINYINT NULL,
    `score` INT NULL,
    `updated_at` DATETIME NULL,
    PRIMARY KEY (`id`),
    INDEX `user_id__fk_idx` (`user_id` ASC) VISIBLE,
    INDEX `lesson_id__fk_idx` (`lesson_id` ASC) VISIBLE,
    CONSTRAINT `user_id__fk`
      FOREIGN KEY (`user_id`)
      REFERENCES `japanese_learning`.`user` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION,
    CONSTRAINT `lesson_id__fk`
      FOREIGN KEY (`lesson_id`)
      REFERENCES `japanese_learning`.`lesson` (`id`)
      ON DELETE NO ACTION
      ON UPDATE NO ACTION);

