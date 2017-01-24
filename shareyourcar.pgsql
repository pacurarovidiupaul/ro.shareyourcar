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
    license_plate character varying(60),
    producer character varying(60),
    model character varying(60),
    type character varying(60),
    year_of_production character varying(60),
    nr_of_seats integer,
    fuel_tank_cap double precision,
    consumption double precision,
    start_position_lat character varying(60),
    start_position_long character varying(60),
    end_position_lat character varying(60),
    end_position_long character varying(60),
    price double precision,
    booked boolean,
    owner_user_name character varying(60),
    client_user_name character varying(60),
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
    current_location character varying,
    current_location_long character varying
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
    enabled smallint DEFAULT 1 NOT NULL,
    client_user_name character varying
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

COPY car (license_plate, producer, model, type, year_of_production, nr_of_seats, fuel_tank_cap, consumption, start_position_lat, start_position_long, end_position_lat, end_position_long, price, booked, owner_user_name, client_user_name, id) FROM stdin;
CJ78RIG	BMW	525d	Limousine	2006	5	70	9					120	f	Ovidiu		3
CJ99TOM	MERCEDES	S600	Limousine	2016	4	80	12	46.75104286	23.50416134			250	f	Ovidiu		2
GL07XML	Opel	Astra	Hatchbag	2004	5	48	6	45.44	28.04	44.18	28.63	100	t	Noemi	Tamas	4
CJ23TJY	OPEL	ASTRA	HATCHBACK	2009	5	60	9	46.75532341	23.55794203	46.75106083	23.50416167	120	t	Emil	Alin	6
CJ77PVS	Renault	Megan	Limousin	2003	5	55	12	46.75106083	23.50416167			120	f	Sebi		7
MS05XPS	Renault	Megan	combi	2010	5	60	5	46.55	24.5667	44	44	110	t	Noemi	nanana	5
\.


--
-- Name: car_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('car_id_seq', 7, true);


--
-- Data for Name: client; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY client (first_name, last_name, email_address, phone_number, user_name, password, age, wallet, id, enabled, current_location, current_location_long) FROM stdin;
Pacurar	Sergiu	pacurarsergiu@yahoo.com	0744285504	Sergiu	Jeddah	40	10000	1	1	100	200
Pacurar	Mihaela	miha01ro@yahoo.com	0722128633	Mihaela	tudor2015	35	6900	2	1		
Pop	Mihai	popmihai@yahoo.com	074355336	Mihai	test1234	32	1000	3	1		
Sgshh	asd	asds2@sasda.io	12332415	asdasd	wqeasds	25	122	5	1	21	32
gyorgy	Tamas	tamas@yahoo.com	0744874519	Tamas	123456	29	1000	4	1	44.18	28.63
John	Walker	johny@yahoo.com	0787548962	Johny	123456	54	1000	6	1	45.1	24.3667
irimi	Alin	irimiaalin@yahoo.com	0733425467	Alin	test1234	32	640	7	1	46.75106083	23.50416167
Dani	Petru	dani@yahoo.com	0744123456	Dani	123456	23	400	8	1	46.75532341	23.55794203
joska	lofasz	nanana@kukac.hu	074	nanana	nanana	30	-66	9	1	44	44
\.


--
-- Name: client_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('client_id_seq', 9, true);


--
-- Data for Name: owner; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY owner (first_name, last_name, email_address, phone_number, user_name, password, profit, id, enabled, client_user_name) FROM stdin;
Pacurar	Sergiu	pacurarsergiu@yahoo.com	0744285504	SergiuP	Jeddah38	0	2	1	\N
Pacurar	Ovidiu	pacurarovidiupaul@live.com	0740013456	Ovidiu	maverick	3960	1	1	
Popescu	Emil	popescuemil@yahoo.com	0732445633	Emil	test1234	360	4	1	Alin
Sebi	Ada	sebi@yahoo.com	0744321543	Sebi	123456	600	5	1	
lofasz	joska	lofi@kukac.hu	05866	nanana	nanana	0	6	1	\N
Kovacs	Noemi	tucita14@yahoo.com	0744874519	Noemi	123456	610	3	1	nanana
\.


--
-- Name: owner_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('owner_id_seq', 6, true);


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY user_role (user_role_id, user_name, role) FROM stdin;
1	Ovidiu	ROLE_OWNER
2	SergiuP	ROLE_OWNER
3	Sergiu	ROLE_CLIENT
4	Mihaela	ROLE_CLIENT
5	Noemi	ROLE_OWNER
6	Mihai	ROLE_CLIENT
7	Tamas	ROLE_CLIENT
8	asdasd	ROLE_CLIENT
9	Johny	ROLE_CLIENT
10	Emil	ROLE_OWNER
11	Alin	ROLE_CLIENT
12	Sebi	ROLE_OWNER
13	Dani	ROLE_CLIENT
14	nanana	ROLE_OWNER
15	nanana	ROLE_CLIENT
\.


--
-- Name: user_role_user_role_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_role_user_role_id_seq', 15, true);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, user_name, password, enabled) FROM stdin;
1	Ovidiu	maverick	1
2	SergiuP	Jeddah38	1
3	Sergiu	Jeddah	1
4	Mihaela	tudor2015	1
5	Noemi	123456	1
6	Mihai	test1234	1
7	Tamas	123456	1
8	asdasd	wqeasds	1
9	Johny	123456	1
10	Emil	test1234	1
11	Alin	test1234	1
12	Sebi	123456	1
13	Dani	123456	1
14	nanana	nanana	1
15	nanana	nanana	1
\.


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 15, true);


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

