CREATE TABLE `japanese_learning`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `japanese_learning`.`lesson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `lesson_book_fk`
    FOREIGN KEY (`book_id`)
    REFERENCES `japanese_learning`.`book` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `japanese_learning`.`lesson_section` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lesson_id` INT NOT NULL,
  `type` ENUM('VOCABULARY','GRAMMAR','PHRASE','DIALOGUE') NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `section_lesson_fk`
    FOREIGN KEY (`lesson_id`)
    REFERENCES `japanese_learning`.`lesson` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `japanese_learning`.`vocabulary_item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `section_id` INT NOT NULL,
  `jp` VARCHAR(255) NOT NULL,
  `romaji` VARCHAR(255),
  `en` VARCHAR(255),
  PRIMARY KEY (`id`),
  CONSTRAINT `vocab_section_fk`
    FOREIGN KEY (`section_id`)
    REFERENCES `japanese_learning`.`lesson_section` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `japanese_learning`.`grammar_section` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `section_id` INT NOT NULL,
  `content` TEXT NOT NULL,
  `formula` VARCHAR(255),
  PRIMARY KEY (`id`),
  CONSTRAINT `grammar_section_fk`
    FOREIGN KEY (`section_id`)
    REFERENCES `japanese_learning`.`lesson_section` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `japanese_learning`.`grammar_example` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `grammar_section_id` INT NOT NULL,
  `jp` VARCHAR(255) NOT NULL,
  `en` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `grammar_example_fk`
    FOREIGN KEY (`grammar_section_id`)
    REFERENCES `japanese_learning`.`grammar_section` (`id`)
    ON DELETE CASCADE
);

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
    ON DELETE CASCADE,
  CONSTRAINT `lesson_id__fk`
    FOREIGN KEY (`lesson_id`)
    REFERENCES `japanese_learning`.`lesson` (`id`)
    ON DELETE CASCADE
);