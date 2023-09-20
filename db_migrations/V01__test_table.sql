CREATE TABLE IF NOT EXISTS test_example
(
    id               INT GENERATED ALWAYS AS IDENTITY,
    test_column      VARCHAR(128) NOT NULL,
    test_description VARCHAR(128) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO dbo.test_example(test_column, test_description) SELECT 'COLUMN1', 'DESCRIPTION1';
INSERT INTO dbo.test_example(test_column, test_description) SELECT 'COLUMN2', 'DESCRIPTION2';