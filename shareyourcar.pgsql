--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.0
-- Dumped by pg_dump version 9.6.0

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
-- Name: owner_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE owner_role (
    owner_role_id integer NOT NULL,
    user_name character varying NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE owner_role OWNER TO postgres;

--
-- Name: owner_role_owner_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE owner_role_owner_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE owner_role_owner_role_id_seq OWNER TO postgres;

--
-- Name: owner_role_owner_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE owner_role_owner_role_id_seq OWNED BY owner_role.owner_role_id;


--
-- Name: owner id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner ALTER COLUMN id SET DEFAULT nextval('owner_id_seq'::regclass);


--
-- Name: owner_role owner_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner_role ALTER COLUMN owner_role_id SET DEFAULT nextval('owner_role_owner_role_id_seq'::regclass);


--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner (first_name, last_name, email_address, phone_number, user_name, password, profit, id, enabled) FROM stdin;
Pacurar	Ovidiu	pacurarovidiupaul@live.com	+40740013456	Ovidiu	maverick	0	1	1
Pacurar	Sergiu	pacurarsergiu@yahoo.com	0744285504	Sergiu	vladimir	0	2	1
Gavris	Gelu	gavrisgelu@yahoo.com	+40740013456	Gavris	vremuribune	0	3	1
Mihai	Baciu	mihaibaciu@yahoo.com	0742444254	Mihai	faraparola	0	4	1
Popescu	Marian	popescumarian@yahoo.com	0723645112	Marian	marian	0	6	1
Tudor	Pacurar	pacurartudor@live.com	0740013456	Tudor	maverick	0	7	1
Emilian	Pop	popemilian@yahoo.com	0743233444	Emilian	maverick	0	8	1
\.


--
-- Name: owner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('owner_id_seq', 8, true);


--
-- Data for Name: owner_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner_role (owner_role_id, user_name, role) FROM stdin;
1	Ovidiu	ROLE_OWNER
2	Sergiu	ROLE_OWNER
3	Gavris	ROLE_OWNER
4	Mihai	ROLE_OWNER
6	Marian	ROLE_OWNER
7	Tudor	ROLE_OWNER
8	Emilian	ROLE_OWNER
\.


--
-- Name: owner_role_owner_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('owner_role_owner_role_id_seq', 8, true);


--
-- Name: owner owner_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner
    ADD CONSTRAINT owner_pkey PRIMARY KEY (id);


--
-- Name: owner_role owner_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner_role
    ADD CONSTRAINT owner_role_pkey PRIMARY KEY (owner_role_id, user_name, role);


--
-- Name: owner_role uni_user_name_role; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner_role
    ADD CONSTRAINT uni_user_name_role UNIQUE (role, user_name);


--
-- Name: owner_role fk_user_name_idx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner_role
    ADD CONSTRAINT fk_user_name_idx FOREIGN KEY (owner_role_id) REFERENCES owner(id);


--
-- PostgreSQL database dump complete
--

