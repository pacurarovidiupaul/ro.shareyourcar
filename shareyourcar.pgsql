--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.1
-- Dumped by pg_dump version 9.6.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: car; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE car (
    license_plate character varying,
    producer character varying,
    model character varying,
    type character varying,
    year_of_production integer,
    nr_of_seats integer,
    fuel_tank_cap double precision,
    consumption double precision,
    start_position_lat character varying,
    start_position_long character varying,
    end_position_lat character varying,
    end_position_long character varying,
    price double precision,
    booked boolean,
    id integer NOT NULL
);


ALTER TABLE car OWNER TO postgres;

--
-- Name: car_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE car_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE car_id_seq OWNER TO postgres;

--
-- Name: car_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE car_id_seq OWNED BY car.id;


--
-- Name: client; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE client (
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    email_address character varying NOT NULL,
    phone_number character varying NOT NULL,
    user_name character varying NOT NULL,
    password character varying NOT NULL,
    age integer NOT NULL,
    wallet double precision NOT NULL,
    id integer NOT NULL,
    enabled smallint DEFAULT 1 NOT NULL,
    current_location character varying
);


ALTER TABLE client OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE client_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_id_seq OWNER TO postgres;

--
-- Name: client_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE client_id_seq OWNED BY client.id;


--
-- Name: owner; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE owner (
    first_name character varying NOT NULL,
    last_name character varying NOT NULL,
    email_address character varying NOT NULL,
    phone_number character varying NOT NULL,
    user_name character varying NOT NULL,
    password character varying NOT NULL,
    profit double precision NOT NULL,
    id integer NOT NULL,
    enabled smallint DEFAULT 1 NOT NULL
);


ALTER TABLE owner OWNER TO postgres;

--
-- Name: owner_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE owner_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE owner_id_seq OWNER TO postgres;

--
-- Name: owner_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE owner_id_seq OWNED BY owner.id;


--
-- Name: user_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE user_role (
    user_role_id integer NOT NULL,
    user_name character varying(60) NOT NULL,
    role character varying(60) NOT NULL
);


ALTER TABLE user_role OWNER TO postgres;

--
-- Name: user_role_user_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_role_user_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE user_role_user_role_id_seq OWNER TO postgres;

--
-- Name: user_role_user_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_role_user_role_id_seq OWNED BY user_role.user_role_id;


--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE users (
    id integer NOT NULL,
    user_name character varying(60) NOT NULL,
    password character varying(60) NOT NULL,
    enabled smallint DEFAULT 1 NOT NULL
);


ALTER TABLE users OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- Name: car id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY car ALTER COLUMN id SET DEFAULT nextval('car_id_seq'::regclass);


--
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: owner id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner ALTER COLUMN id SET DEFAULT nextval('owner_id_seq'::regclass);


--
-- Name: user_role user_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role ALTER COLUMN user_role_id SET DEFAULT nextval('user_role_user_role_id_seq'::regclass);


--
-- Name: users id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- Data for Name: car; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY car (license_plate, producer, model, type, year_of_production, nr_of_seats, fuel_tank_cap, consumption, start_position_lat, start_position_long, end_position_lat, end_position_long, price, booked, id) FROM stdin;
\.


--
-- Name: car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('car_id_seq', 1, true);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client (first_name, last_name, email_address, phone_number, user_name, password, age, wallet, id, enabled, current_location) FROM stdin;
Pacurar	Ovidiu	pacurarovidiupaul@live.com	0740013456	Ovidiu	maverick	35	200	1	1	\N
Pacurar	Mihaela	pacurarmihaela@yahoo.com	0722128633	Mihaela	Tudor	0	0	2	1	Cluj-Napoca
Pacurar ex Morar	Monica	pacurarmonica@yahoo.com	072344245	Monica	Tudor	0	0	3	1	Cluj-Napoca
\.


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 3, true);


--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner (first_name, last_name, email_address, phone_number, user_name, password, profit, id, enabled) FROM stdin;
Pacurar	Sergiu	pacurarovidiupaul@live.com	0744285504	Sergiu	vladimir	0	3	1
Pacurar	Ovidiu	pacurarovidiupaul@live.com	0740013456	Ovidiu	maverick	0	1	1
\.


--
-- Name: owner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('owner_id_seq', 3, true);


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_role (user_role_id, user_name, role) FROM stdin;
1	Ovidiu	ROLE_OWNER
3	Sergiu	ROLE_OWNER
4	Mihaela	ROLE_CLIENT
5	Monica	ROLE_CLIENT
\.


--
-- Name: user_role_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_role_user_role_id_seq', 6, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, user_name, password, enabled) FROM stdin;
3	Sergiu	vladimir	1
4	Mihaela	Tudor	1
5	Monica	Tudor	1
1	Ovidiu	maverick	1
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 5, true);


--
-- Name: car car_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY car
    ADD CONSTRAINT car_pkey PRIMARY KEY (id);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: owner owner_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner
    ADD CONSTRAINT owner_pkey PRIMARY KEY (id);


--
-- Name: user_role uni_user_name_role_user; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT uni_user_name_role_user UNIQUE (user_name, role);


--
-- Name: user_role user_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT user_role_pkey PRIMARY KEY (user_role_id);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- Name: user_role fk_user_name_idx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY user_role
    ADD CONSTRAINT fk_user_name_idx FOREIGN KEY (user_role_id) REFERENCES users(id);


--
-- PostgreSQL database dump complete
--

