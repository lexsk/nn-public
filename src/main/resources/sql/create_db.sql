CREATE SEQUENCE test_country_id_seq;

CREATE TABLE test_country
(
  id integer NOT NULL DEFAULT nextval('test_country_id_seq'::regclass),
  name character varying(50) NOT NULL,
  CONSTRAINT test_country_id_pk PRIMARY KEY (id)
);

CREATE SEQUENCE test_city_id_seq;

CREATE TABLE test_city
(
  id integer NOT NULL DEFAULT nextval('test_city_id_seq'::regclass),
  name character varying(50) NOT NULL,
  country_id integer NOT NULL
);
