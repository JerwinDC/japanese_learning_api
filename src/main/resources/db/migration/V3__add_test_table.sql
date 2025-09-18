CREATE TABLE `test` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `lesson_id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `description` TEXT,
  PRIMARY KEY (`id`),
  CONSTRAINT `test_lesson_fk`
    FOREIGN KEY (`lesson_id`)
    REFERENCES `lesson` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `test_question` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `test_id` INT NOT NULL,
  `question_text` TEXT NOT NULL,
  `type` ENUM('MCQ','FILL_IN_BLANK') NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `question_test_fk`
    FOREIGN KEY (`test_id`)
    REFERENCES `test` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `test_option` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `question_id` INT NOT NULL,
  `option_text` VARCHAR(255) NOT NULL,
  `is_correct` BOOLEAN NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  CONSTRAINT `option_question_fk`
    FOREIGN KEY (`question_id`)
    REFERENCES `test_question` (`id`)
    ON DELETE CASCADE
);

CREATE TABLE `test_history` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `test_id` INT NOT NULL,
  `score` INT NOT NULL,
  `taken_at` DATETIME DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT `history_user_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `user` (`id`)
    ON DELETE CASCADE,
  CONSTRAINT `history_test_fk`
    FOREIGN KEY (`test_id`)
    REFERENCES `test` (`id`)
    ON DELETE CASCADE
);
