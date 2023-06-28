DROP TABLE IF EXISTS loans;

CREATE TABLE loans
(
    `loan_number`        int AUTO_INCREMENT NOT NULL PRIMARY KEY ,
    `customer_id`        int          NOT NULL,
    `start_date`         date         NOT NULL,
    `loan_type`          varchar(100) NOT NULL,
    `created_date`       date DEFAULT NULL,
    `total_loan`         int          NOT NULL,
    `amount_paid`        int          NOT NULL,
    `outstanding_amount` int          NOT NULL
);


INSERT INTO loans(customer_id, start_date, loan_type, created_date, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2022-10-13', 'Home', '2022-10-13', 200000, 15000, 185000);

INSERT INTO loans(customer_id, start_date, loan_type, created_date, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2023-01-22', 'Vehicle', '2022-10-13', 50000, 20000, 30000);

INSERT INTO loans(customer_id, start_date, loan_type, created_date, total_loan, amount_paid, outstanding_amount)
VALUES (1, '2020-10-13', 'Battle Ship', '2020-10-13', 2000000, 150000, 1850000);
