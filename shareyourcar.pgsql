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
    current_location character varying NOT NULL,
    id integer NOT NULL,
    enabled smallint DEFAULT 1 NOT NULL
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
-- Name: client_role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE client_role (
    client_role_id integer NOT NULL,
    user_name character varying NOT NULL,
    role character varying NOT NULL
);


ALTER TABLE client_role OWNER TO postgres;

--
-- Name: client_role_client_role_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE client_role_client_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE client_role_client_role_id_seq OWNER TO postgres;

--
-- Name: client_role_client_role_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE client_role_client_role_id_seq OWNED BY client_role.client_role_id;


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
-- Name: client id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client ALTER COLUMN id SET DEFAULT nextval('client_id_seq'::regclass);


--
-- Name: client_role client_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client_role ALTER COLUMN client_role_id SET DEFAULT nextval('client_role_client_role_id_seq'::regclass);


--
-- Name: owner id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner ALTER COLUMN id SET DEFAULT nextval('owner_id_seq'::regclass);


--
-- Name: owner_role owner_role_id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner_role ALTER COLUMN owner_role_id SET DEFAULT nextval('owner_role_owner_role_id_seq'::regclass);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client (first_name, last_name, email_address, phone_number, user_name, password, age, wallet, current_location, id, enabled) FROM stdin;
Pacurar	Ovidiu	pacurarovidiupaul@live.com	0740013456	Ovidiu	maverick	35	200	Cluj	1	1
\.


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 1, true);


--
-- Data for Name: client_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client_role (client_role_id, user_name, role) FROM stdin;
1	Ovidiu	ROLE_CLIENT
\.


--
-- Name: client_role_client_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_role_client_role_id_seq', 1, true);


--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner (first_name, last_name, email_address, phone_number, user_name, password, profit, id, enabled) FROM stdin;
Pacurar	Sergiu	pacurarsergiu@yahoo.com	0740013456	Sergiu	vladimir	0	2	1
\.


--
-- Name: owner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('owner_id_seq', 2, true);


--
-- Data for Name: owner_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner_role (owner_role_id, user_name, role) FROM stdin;
2	Sergiu	ROLE_OWNER
\.


--
-- Name: owner_role_owner_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('owner_role_owner_role_id_seq', 2, true);


--
-- Name: client client_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);


--
-- Name: client_role client_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client_role
    ADD CONSTRAINT client_role_pkey PRIMARY KEY (user_name, client_role_id, role);


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
-- Name: client_role uni_user_name_role_client; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client_role
    ADD CONSTRAINT uni_user_name_role_client UNIQUE (role, user_name);


--
-- Name: client_role fk_user_name_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY client_role
    ADD CONSTRAINT fk_user_name_id FOREIGN KEY (client_role_id) REFERENCES client(id);


--
-- Name: owner_role fk_user_name_idx; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY owner_role
    ADD CONSTRAINT fk_user_name_idx FOREIGN KEY (owner_role_id) REFERENCES owner(id);


--
-- PostgreSQL database dump complete
--

