--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 10.5

-- Started on 2018-10-10 15:32:41 EDT

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12544)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2503 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 197 (class 1259 OID 139628)
-- Name: contact; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.contact (
    rank bigint NOT NULL,
    notification_order bigint NOT NULL,
    contact_order bigint NOT NULL,
    value character varying(255) NOT NULL,
    type character varying(255) NOT NULL,
    id bigint NOT NULL,
    member_fk bigint
);


ALTER TABLE public.contact OWNER TO guardian;

--
-- TOC entry 196 (class 1259 OID 139626)
-- Name: Contact_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public."Contact_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Contact_id_seq" OWNER TO guardian;

--
-- TOC entry 2504 (class 0 OID 0)
-- Dependencies: 196
-- Name: Contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public."Contact_id_seq" OWNED BY public.contact.id;


--
-- TOC entry 207 (class 1259 OID 147838)
-- Name: level; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.level (
    id bigint NOT NULL,
    name character varying(255) NOT NULL,
    organization_fk bigint
);


ALTER TABLE public.level OWNER TO guardian;

--
-- TOC entry 205 (class 1259 OID 147834)
-- Name: level_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.level_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.level_id_seq OWNER TO guardian;

--
-- TOC entry 2505 (class 0 OID 0)
-- Dependencies: 205
-- Name: level_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.level_id_seq OWNED BY public.level.id;


--
-- TOC entry 206 (class 1259 OID 147836)
-- Name: level_organization_fk_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.level_organization_fk_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.level_organization_fk_seq OWNER TO guardian;

--
-- TOC entry 2506 (class 0 OID 0)
-- Dependencies: 206
-- Name: level_organization_fk_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.level_organization_fk_seq OWNED BY public.level.organization_fk;


--
-- TOC entry 201 (class 1259 OID 139650)
-- Name: member; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.member (
    id bigint NOT NULL,
    first_name character varying(255) NOT NULL,
    middle_name character varying(255),
    last_name character varying(255) NOT NULL,
    name_suffix character varying(255),
    common_name character varying(255) NOT NULL,
    date_of_birth timestamp with time zone
);


ALTER TABLE public.member OWNER TO guardian;

--
-- TOC entry 200 (class 1259 OID 139648)
-- Name: member_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.member_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.member_id_seq OWNER TO guardian;

--
-- TOC entry 2507 (class 0 OID 0)
-- Dependencies: 200
-- Name: member_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.member_id_seq OWNED BY public.member.id;


--
-- TOC entry 211 (class 1259 OID 164204)
-- Name: membership; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.membership (
    id bigint NOT NULL,
    created timestamp with time zone NOT NULL,
    organization_fk bigint,
    level_fk bigint,
    term_fk bigint
);


ALTER TABLE public.membership OWNER TO guardian;

--
-- TOC entry 210 (class 1259 OID 164202)
-- Name: membership_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.membership_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.membership_id_seq OWNER TO guardian;

--
-- TOC entry 2508 (class 0 OID 0)
-- Dependencies: 210
-- Name: membership_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.membership_id_seq OWNED BY public.membership.id;


--
-- TOC entry 202 (class 1259 OID 147818)
-- Name: membership_member; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.membership_member (
    membership_id bigint NOT NULL,
    member_id bigint NOT NULL,
    type character varying NOT NULL
);


ALTER TABLE public.membership_member OWNER TO guardian;

--
-- TOC entry 204 (class 1259 OID 147828)
-- Name: organization; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.organization (
    id bigint NOT NULL,
    name character varying(255) NOT NULL
);


ALTER TABLE public.organization OWNER TO guardian;

--
-- TOC entry 203 (class 1259 OID 147826)
-- Name: organization_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.organization_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.organization_id_seq OWNER TO guardian;

--
-- TOC entry 2509 (class 0 OID 0)
-- Dependencies: 203
-- Name: organization_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.organization_id_seq OWNED BY public.organization.id;


--
-- TOC entry 199 (class 1259 OID 139639)
-- Name: picture; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.picture (
    id bigint NOT NULL,
    type character varying(255) NOT NULL,
    is_default boolean NOT NULL,
    name character varying(255) NOT NULL,
    uri character varying(255) NOT NULL,
    media_type character varying(255) NOT NULL,
    height bigint NOT NULL,
    width bigint NOT NULL,
    rank bigint NOT NULL,
    member_fk bigint
);


ALTER TABLE public.picture OWNER TO guardian;

--
-- TOC entry 198 (class 1259 OID 139637)
-- Name: picture_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.picture_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.picture_id_seq OWNER TO guardian;

--
-- TOC entry 2510 (class 0 OID 0)
-- Dependencies: 198
-- Name: picture_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.picture_id_seq OWNED BY public.picture.id;


--
-- TOC entry 209 (class 1259 OID 147847)
-- Name: term; Type: TABLE; Schema: public; Owner: guardian
--

CREATE TABLE public.term (
    id bigint NOT NULL,
    start date NOT NULL,
    duration bigint NOT NULL,
    organization_fk bigint
);


ALTER TABLE public.term OWNER TO guardian;

--
-- TOC entry 208 (class 1259 OID 147845)
-- Name: term_id_seq; Type: SEQUENCE; Schema: public; Owner: guardian
--

CREATE SEQUENCE public.term_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.term_id_seq OWNER TO guardian;

--
-- TOC entry 2511 (class 0 OID 0)
-- Dependencies: 208
-- Name: term_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: guardian
--

ALTER SEQUENCE public.term_id_seq OWNED BY public.term.id;


--
-- TOC entry 2335 (class 2604 OID 139631)
-- Name: contact id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.contact ALTER COLUMN id SET DEFAULT nextval('public."Contact_id_seq"'::regclass);


--
-- TOC entry 2339 (class 2604 OID 147841)
-- Name: level id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.level ALTER COLUMN id SET DEFAULT nextval('public.level_id_seq'::regclass);


--
-- TOC entry 2340 (class 2604 OID 147842)
-- Name: level organization_fk; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.level ALTER COLUMN organization_fk SET DEFAULT nextval('public.level_organization_fk_seq'::regclass);


--
-- TOC entry 2337 (class 2604 OID 139653)
-- Name: member id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.member ALTER COLUMN id SET DEFAULT nextval('public.member_id_seq'::regclass);


--
-- TOC entry 2342 (class 2604 OID 164207)
-- Name: membership id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.membership ALTER COLUMN id SET DEFAULT nextval('public.membership_id_seq'::regclass);


--
-- TOC entry 2338 (class 2604 OID 147831)
-- Name: organization id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.organization ALTER COLUMN id SET DEFAULT nextval('public.organization_id_seq'::regclass);


--
-- TOC entry 2336 (class 2604 OID 139642)
-- Name: picture id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.picture ALTER COLUMN id SET DEFAULT nextval('public.picture_id_seq'::regclass);


--
-- TOC entry 2341 (class 2604 OID 147850)
-- Name: term id; Type: DEFAULT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.term ALTER COLUMN id SET DEFAULT nextval('public.term_id_seq'::regclass);


--
-- TOC entry 2482 (class 0 OID 139628)
-- Dependencies: 197
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.contact (rank, notification_order, contact_order, value, type, id, member_fk) FROM stdin;
1	0	1	(413) 626-6101	phone	450	393
2	1	2	(413) 626-6101	txt	451	393
3	2	3	POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX	slack	452	393
4	3	0	ian.cooper.rose	twitter	453	393
1	0	1	(860) 558-9530	phone	454	394
2	1	2	(860) 558-9530	txt	455	394
3	2	3	POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX	slack	456	394
1	0	1	(413) 626-6101	phone	457	396
2	1	2	(413) 626-6101	txt	458	396
3	2	3	POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX	slack	459	396
4	3	0	ian.cooper.rose	twitter	460	396
1	0	1	(860) 558-9530	phone	461	397
2	1	2	(860) 558-9530	txt	462	397
3	2	3	POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX	slack	463	397
1	0	1	(413) 626-6101	phone	464	399
2	1	2	(413) 626-6101	txt	465	399
3	2	3	POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX	slack	466	399
4	3	0	ian.cooper.rose	twitter	467	399
1	0	1	(860) 558-9530	phone	468	400
2	1	2	(860) 558-9530	txt	469	400
3	2	3	POST https://hooks.slack.com/services/T00000000/B00000000/XXXXXXXXXXXXXXXXXXXXXXXX	slack	470	400
\.


--
-- TOC entry 2492 (class 0 OID 147838)
-- Dependencies: 207
-- Data for Name: level; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.level (id, name, organization_fk) FROM stdin;
51	Turtle Track	36
52	Turtle Track	37
53	Turtle Track	38
\.


--
-- TOC entry 2486 (class 0 OID 139650)
-- Dependencies: 201
-- Data for Name: member; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.member (id, first_name, middle_name, last_name, name_suffix, common_name, date_of_birth) FROM stdin;
392	Elizabeth	Cooper	Rose	II	Lizzie	2015-09-01 00:00:00-04
393	Ian	Cooper	Rose	\N	Ian	1969-12-22 00:00:00-05
394	Laurel	Marie	Pickard	\N	Laurel	1982-10-18 00:00:00-04
395	Elizabeth	Cooper	Rose	II	Lizzie	2015-09-01 00:00:00-04
396	Ian	Cooper	Rose	\N	Ian	1969-12-22 00:00:00-05
397	Laurel	Marie	Pickard	\N	Laurel	1982-10-18 00:00:00-04
398	Elizabeth	Cooper	Rose	II	Lizzie	2015-09-01 00:00:00-04
399	Ian	Cooper	Rose	\N	Ian	1969-12-22 00:00:00-05
400	Laurel	Marie	Pickard	\N	Laurel	1982-10-18 00:00:00-04
\.


--
-- TOC entry 2496 (class 0 OID 164204)
-- Dependencies: 211
-- Data for Name: membership; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.membership (id, created, organization_fk, level_fk, term_fk) FROM stdin;
95	2018-08-25 17:53:37-04	36	51	45
96	2018-08-25 17:53:37-04	37	52	46
97	2018-08-25 17:53:37-04	38	53	47
\.


--
-- TOC entry 2487 (class 0 OID 147818)
-- Dependencies: 202
-- Data for Name: membership_member; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.membership_member (membership_id, member_id, type) FROM stdin;
95	392	ward
95	393	guardian
95	394	guardian
96	395	ward
96	396	guardian
96	397	guardian
97	398	ward
97	399	guardian
97	400	guardian
\.


--
-- TOC entry 2489 (class 0 OID 147828)
-- Dependencies: 204
-- Data for Name: organization; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.organization (id, name) FROM stdin;
36	Arisia
37	Arisia
38	Arisia
\.


--
-- TOC entry 2484 (class 0 OID 139639)
-- Dependencies: 199
-- Data for Name: picture; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.picture (id, type, is_default, name, uri, media_type, height, width, rank, member_fk) FROM stdin;
309	profile	t	elizabeth_cooper_rose.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1	image/jpeg	300	300	1	392
310	profile	t	ian_cooper_rose.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7	image/jpeg	300	300	1	393
311	profile	t	laurel_marie_pickard.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6	image/jpeg	300	300	1	394
312	profile	t	elizabeth_cooper_rose.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1	image/jpeg	300	300	1	395
313	profile	t	ian_cooper_rose.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7	image/jpeg	300	300	1	396
314	profile	t	laurel_marie_pickard.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6	image/jpeg	300	300	1	397
315	profile	t	elizabeth_cooper_rose.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/1	image/jpeg	300	300	1	398
316	profile	t	ian_cooper_rose.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/7	image/jpeg	300	300	1	399
317	profile	t	laurel_marie_pickard.jpeg	http://guardian.houserose.com/guardian/organization/images/profile/00/00/00/6	image/jpeg	300	300	1	400
\.


--
-- TOC entry 2494 (class 0 OID 147847)
-- Dependencies: 209
-- Data for Name: term; Type: TABLE DATA; Schema: public; Owner: guardian
--

COPY public.term (id, start, duration, organization_fk) FROM stdin;
45	2019-01-18	4	36
46	2019-01-18	4	37
47	2019-01-18	4	38
\.


--
-- TOC entry 2512 (class 0 OID 0)
-- Dependencies: 196
-- Name: Contact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public."Contact_id_seq"', 470, true);


--
-- TOC entry 2513 (class 0 OID 0)
-- Dependencies: 205
-- Name: level_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.level_id_seq', 53, true);


--
-- TOC entry 2514 (class 0 OID 0)
-- Dependencies: 206
-- Name: level_organization_fk_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.level_organization_fk_seq', 1, false);


--
-- TOC entry 2515 (class 0 OID 0)
-- Dependencies: 200
-- Name: member_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.member_id_seq', 400, true);


--
-- TOC entry 2516 (class 0 OID 0)
-- Dependencies: 210
-- Name: membership_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.membership_id_seq', 97, true);


--
-- TOC entry 2517 (class 0 OID 0)
-- Dependencies: 203
-- Name: organization_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.organization_id_seq', 38, true);


--
-- TOC entry 2518 (class 0 OID 0)
-- Dependencies: 198
-- Name: picture_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.picture_id_seq', 317, true);


--
-- TOC entry 2519 (class 0 OID 0)
-- Dependencies: 208
-- Name: term_id_seq; Type: SEQUENCE SET; Schema: public; Owner: guardian
--

SELECT pg_catalog.setval('public.term_id_seq', 47, true);


--
-- TOC entry 2344 (class 2606 OID 139636)
-- Name: contact Contact_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT "Contact_pkey" PRIMARY KEY (id);


--
-- TOC entry 2355 (class 2606 OID 147844)
-- Name: level level_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.level
    ADD CONSTRAINT level_pkey PRIMARY KEY (id);


--
-- TOC entry 2351 (class 2606 OID 147825)
-- Name: membership_member membership_member_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.membership_member
    ADD CONSTRAINT membership_member_pkey PRIMARY KEY (membership_id, member_id);


--
-- TOC entry 2359 (class 2606 OID 164209)
-- Name: membership membership_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.membership
    ADD CONSTRAINT membership_pkey PRIMARY KEY (id);


--
-- TOC entry 2353 (class 2606 OID 147833)
-- Name: organization organization_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.organization
    ADD CONSTRAINT organization_pkey PRIMARY KEY (id);


--
-- TOC entry 2349 (class 2606 OID 139658)
-- Name: member person_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.member
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- TOC entry 2347 (class 2606 OID 139647)
-- Name: picture picture_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.picture
    ADD CONSTRAINT picture_pkey PRIMARY KEY (id);


--
-- TOC entry 2357 (class 2606 OID 147852)
-- Name: term term_pkey; Type: CONSTRAINT; Schema: public; Owner: guardian
--

ALTER TABLE ONLY public.term
    ADD CONSTRAINT term_pkey PRIMARY KEY (id);


--
-- TOC entry 2345 (class 1259 OID 139688)
-- Name: fki_person_fkey; Type: INDEX; Schema: public; Owner: guardian
--

CREATE INDEX fki_person_fkey ON public.picture USING btree (member_fk);


-- Completed on 2018-10-10 15:32:41 EDT

--
-- PostgreSQL database dump complete
--

