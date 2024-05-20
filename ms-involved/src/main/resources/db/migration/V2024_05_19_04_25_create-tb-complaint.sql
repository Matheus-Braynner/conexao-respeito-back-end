CREATE TABLE tb_complaint (
    id_complaint BIGSERIAL NOT NULL,
    complaint_reason TEXT,
    educational_institution VARCHAR(255),
    name_aggressor VARCHAR(255),
    place_violation_occurred VARCHAR(255),
    registration VARCHAR(255),
    PRIMARY KEY (id_complaint)
);
