--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

-- Started on 2020-06-07 05:59:46

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 82261)
-- Name: customer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.customer (
    id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    joindate date DEFAULT CURRENT_DATE NOT NULL
);


ALTER TABLE public.customer OWNER TO postgres;

--
-- TOC entry 197 (class 1259 OID 82270)
-- Name: food; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.food (
    id integer NOT NULL,
    name text NOT NULL,
    seller integer NOT NULL,
    price integer NOT NULL,
    category text NOT NULL
);


ALTER TABLE public.food OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 82316)
-- Name: invoice; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice (
    id integer NOT NULL,
    customer integer NOT NULL,
    date date DEFAULT CURRENT_DATE NOT NULL,
    invoice_status text NOT NULL,
    delivery_fee integer,
    promo text,
    payment_type text NOT NULL,
    total_price integer NOT NULL
);


ALTER TABLE public.invoice OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 82325)
-- Name: invoice_food; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.invoice_food (
    invoice integer NOT NULL,
    food integer NOT NULL,
    quantity integer DEFAULT 1 NOT NULL,
    id integer NOT NULL
);


ALTER TABLE public.invoice_food OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 82335)
-- Name: invoice_food_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.invoice_food_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.invoice_food_id_seq OWNER TO postgres;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 203
-- Name: invoice_food_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.invoice_food_id_seq OWNED BY public.invoice_food.id;


--
-- TOC entry 200 (class 1259 OID 82301)
-- Name: location; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.location (
    id integer NOT NULL,
    province text NOT NULL,
    description text NOT NULL,
    city text NOT NULL
);


ALTER TABLE public.location OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 82285)
-- Name: promo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.promo (
    id integer NOT NULL,
    code text NOT NULL,
    discount integer NOT NULL,
    minprice integer NOT NULL,
    active boolean DEFAULT true NOT NULL
);


ALTER TABLE public.promo OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 82293)
-- Name: seller; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.seller (
    id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    phonenumber text NOT NULL,
    location integer NOT NULL
);


ALTER TABLE public.seller OWNER TO postgres;

--
-- TOC entry 2719 (class 2604 OID 82337)
-- Name: invoice_food id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_food ALTER COLUMN id SET DEFAULT nextval('public.invoice_food_id_seq'::regclass);


--
-- TOC entry 2855 (class 0 OID 82261)
-- Dependencies: 196
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, name, email, password, joindate) FROM stdin;
1	user	user@gmail.com	User1234	2020-05-31
2	Mustofa	mustofa@gmail.com	Qwer1234	2020-06-01
3	Qwer	qwer@gmail.com	Qwer1234	2020-06-02
4	kamal	kamal@gmail.com	Kamal1234	2020-06-07
\.


--
-- TOC entry 2856 (class 0 OID 82270)
-- Dependencies: 197
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.food (id, name, seller, price, category) FROM stdin;
1	food1	1	10000	Bakery
3	food2	2	4600	Bakery
4	food3	3	6900	Bakery
5	food4	4	9200	Bakery
6	food5	5	11500	Bakery
7	food6	6	13800	Bakery
8	food7	7	16100	Bakery
2	food0	1	20000	Coffee
\.


--
-- TOC entry 2860 (class 0 OID 82316)
-- Dependencies: 201
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice (id, customer, date, invoice_status, delivery_fee, promo, payment_type, total_price) FROM stdin;
9	2	2020-06-02	Ongoing	10000	\N	Cash	20000
4	1	2020-06-01	Cancelled	12500	\N	Cash	32500
5	1	2020-06-02	Cancelled	12500	\N	Cash	32500
6	1	2020-06-02	Cancelled	12500	\N	Cash	32500
7	1	2020-06-02	Cancelled	12500	\N	Cash	32500
10	1	2020-06-02	Cancelled	10000	\N	Cash	20000
2	1	2020-06-01	Cancelled	12500	\N	Cash	32500
3	1	2020-06-01	Cancelled	12500	\N	Cash	32500
8	1	2020-06-02	Ongoing	12500	\N	Cash	32500
12	4	2020-06-07	Finished	10000	\N	Cash	14600
13	4	2020-06-07	Finished	\N	firstBuy	Cashless	6500
11	3	2020-06-07	Cancelled	10000	\N	Cash	145900
14	3	2020-06-07	Finished	\N	null	Cashless	18400
\.


--
-- TOC entry 2861 (class 0 OID 82325)
-- Dependencies: 202
-- Data for Name: invoice_food; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice_food (invoice, food, quantity, id) FROM stdin;
11	3	1	58
11	5	1	59
11	8	1	60
11	6	1	61
11	3	1	62
11	7	1	63
11	8	1	64
12	3	1	65
13	6	1	66
14	4	1	67
14	6	1	68
\.


--
-- TOC entry 2859 (class 0 OID 82301)
-- Dependencies: 200
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location (id, province, description, city) FROM stdin;
1	Jawa Barat	Jauh	Bekasi
\.


--
-- TOC entry 2857 (class 0 OID 82285)
-- Dependencies: 198
-- Data for Name: promo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.promo (id, code, discount, minprice, active) FROM stdin;
3	test	1000	1000	t
1	firstBuy	5000	10000	t
\.


--
-- TOC entry 2858 (class 0 OID 82293)
-- Dependencies: 199
-- Data for Name: seller; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seller (id, name, email, phonenumber, location) FROM stdin;
1	Rafid	rafid@gmail.com	0812345678	1
2	Sel2	sel2@gmail.com	081808180818	1
3	Sel3	sel3@gmail.com	081808180818	1
4	Sel4	sel4@gmail.com	081808180818	1
5	Sel5	sel5@gmail.com	081808180818	1
6	Sel6	sel6@gmail.com	081808180818	1
7	Sel7	sel7@gmail.com	081808180818	1
8	Sel7	sel8@gmail.com	081808180818	1
\.


--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 203
-- Name: invoice_food_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invoice_food_id_seq', 68, true);


--
-- TOC entry 2721 (class 2606 OID 82269)
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 82277)
-- Name: food food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (id);


--
-- TOC entry 2733 (class 2606 OID 82339)
-- Name: invoice_food invoice_food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_food
    ADD CONSTRAINT invoice_food_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 82324)
-- Name: invoice invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (id);


--
-- TOC entry 2729 (class 2606 OID 82308)
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 82292)
-- Name: promo promo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promo
    ADD CONSTRAINT promo_pkey PRIMARY KEY (id);


--
-- TOC entry 2727 (class 2606 OID 82300)
-- Name: seller seller_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seller
    ADD CONSTRAINT seller_pkey PRIMARY KEY (id);


-- Completed on 2020-06-07 05:59:47

--
-- PostgreSQL database dump complete
--

