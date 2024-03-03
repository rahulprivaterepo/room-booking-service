CREATE DATABASE IF NOT EXISTS room_bookings CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE room_bookings;

CREATE TABLE IF NOT EXISTS `rooms`
(
    `id`               bigint(13)    NOT NULL AUTO_INCREMENT,
    `room_number`      int           NOT NULL UNIQUE,
    `floor`            tinyint(3)    NOT NULL,
    `is_booked`        BOOLEAN       NOT NULL,
    `room_type_id`     bigint(13)    NOT NULL,
    `occupant_id`      bigint(6),
    `check_in_date`   datetime(3)    DEFAULT NULL,
    `check_out_date`   datetime(3)   DEFAULT NULL,
    `created_at`       datetime(3)   NOT NULL DEFAULT NOW(3),
    `updated_at`       datetime(3)   NOT NULL DEFAULT NOW(3) ON UPDATE NOW(3),
    PRIMARY KEY (`id`),
    FOREIGN KEY (occupant_id)  REFERENCES customers(id),
    FOREIGN KEY (room_type_id) REFERENCES room_types(id),
    INDEX `floor` (`floor`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;


CREATE TABLE IF NOT EXISTS `customers`
(
    `id`               bigint(13)    NOT NULL AUTO_INCREMENT,
    `customer_name`    varchar(512)  NOT NULL,
    `hashed_address`   char(64)      NOT NULL,
    `created_at`       datetime(3)   NOT NULL DEFAULT NOW(3),
    `updated_at`       datetime(3)   NOT NULL DEFAULT NOW(3) ON UPDATE NOW(3),
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `room_types`
(
    `id`               bigint(13)    NOT NULL AUTO_INCREMENT,
    `type_name`        varchar(64)   NOT NULL UNIQUE,
    `description`      VARCHAR(255)  NOT NULL,
    `created_at`       datetime(3)   NOT NULL DEFAULT NOW(3),
    `updated_at`       datetime(3)   NOT NULL DEFAULT NOW(3) ON UPDATE NOW(3),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

