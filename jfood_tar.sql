toc.dat                                                                                             0000600 0004000 0002000 00000017037 13667017374 0014465 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP       8    7                x            jfood    11.5    11.5     1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false         2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false         3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false         4           1262    82260    jfood    DATABASE     �   CREATE DATABASE jfood WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';
    DROP DATABASE jfood;
             postgres    false         �            1259    82261    customer    TABLE     �   CREATE TABLE public.customer (
    id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    joindate date DEFAULT CURRENT_DATE NOT NULL
);
    DROP TABLE public.customer;
       public         postgres    false         �            1259    82270    food    TABLE     �   CREATE TABLE public.food (
    id integer NOT NULL,
    name text NOT NULL,
    seller integer NOT NULL,
    price integer NOT NULL,
    category text NOT NULL
);
    DROP TABLE public.food;
       public         postgres    false         �            1259    82316    invoice    TABLE       CREATE TABLE public.invoice (
    id integer NOT NULL,
    customer integer NOT NULL,
    date date DEFAULT CURRENT_DATE NOT NULL,
    invoice_status text NOT NULL,
    delivery_fee integer,
    promo text,
    payment_type text NOT NULL,
    total_price integer NOT NULL
);
    DROP TABLE public.invoice;
       public         postgres    false         �            1259    82325    invoice_food    TABLE     �   CREATE TABLE public.invoice_food (
    invoice integer NOT NULL,
    food integer NOT NULL,
    quantity integer DEFAULT 1 NOT NULL,
    id integer NOT NULL
);
     DROP TABLE public.invoice_food;
       public         postgres    false         �            1259    82335    invoice_food_id_seq    SEQUENCE     �   CREATE SEQUENCE public.invoice_food_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.invoice_food_id_seq;
       public       postgres    false    202         5           0    0    invoice_food_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.invoice_food_id_seq OWNED BY public.invoice_food.id;
            public       postgres    false    203         �            1259    82301    location    TABLE     �   CREATE TABLE public.location (
    id integer NOT NULL,
    province text NOT NULL,
    description text NOT NULL,
    city text NOT NULL
);
    DROP TABLE public.location;
       public         postgres    false         �            1259    82285    promo    TABLE     �   CREATE TABLE public.promo (
    id integer NOT NULL,
    code text NOT NULL,
    discount integer NOT NULL,
    minprice integer NOT NULL,
    active boolean DEFAULT true NOT NULL
);
    DROP TABLE public.promo;
       public         postgres    false         �            1259    82293    seller    TABLE     �   CREATE TABLE public.seller (
    id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    phonenumber text NOT NULL,
    location integer NOT NULL
);
    DROP TABLE public.seller;
       public         postgres    false         �
           2604    82337    invoice_food id    DEFAULT     r   ALTER TABLE ONLY public.invoice_food ALTER COLUMN id SET DEFAULT nextval('public.invoice_food_id_seq'::regclass);
 >   ALTER TABLE public.invoice_food ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    202         '          0    82261    customer 
   TABLE DATA               G   COPY public.customer (id, name, email, password, joindate) FROM stdin;
    public       postgres    false    196       2855.dat (          0    82270    food 
   TABLE DATA               A   COPY public.food (id, name, seller, price, category) FROM stdin;
    public       postgres    false    197       2856.dat ,          0    82316    invoice 
   TABLE DATA               u   COPY public.invoice (id, customer, date, invoice_status, delivery_fee, promo, payment_type, total_price) FROM stdin;
    public       postgres    false    201       2860.dat -          0    82325    invoice_food 
   TABLE DATA               C   COPY public.invoice_food (invoice, food, quantity, id) FROM stdin;
    public       postgres    false    202       2861.dat +          0    82301    location 
   TABLE DATA               C   COPY public.location (id, province, description, city) FROM stdin;
    public       postgres    false    200       2859.dat )          0    82285    promo 
   TABLE DATA               E   COPY public.promo (id, code, discount, minprice, active) FROM stdin;
    public       postgres    false    198       2857.dat *          0    82293    seller 
   TABLE DATA               H   COPY public.seller (id, name, email, phonenumber, location) FROM stdin;
    public       postgres    false    199       2858.dat 6           0    0    invoice_food_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.invoice_food_id_seq', 68, true);
            public       postgres    false    203         �
           2606    82269    customer customer_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public         postgres    false    196         �
           2606    82277    food food_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.food DROP CONSTRAINT food_pkey;
       public         postgres    false    197         �
           2606    82339    invoice_food invoice_food_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.invoice_food
    ADD CONSTRAINT invoice_food_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.invoice_food DROP CONSTRAINT invoice_food_pkey;
       public         postgres    false    202         �
           2606    82324    invoice invoice_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.invoice DROP CONSTRAINT invoice_pkey;
       public         postgres    false    201         �
           2606    82308    location location_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.location DROP CONSTRAINT location_pkey;
       public         postgres    false    200         �
           2606    82292    promo promo_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.promo
    ADD CONSTRAINT promo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.promo DROP CONSTRAINT promo_pkey;
       public         postgres    false    198         �
           2606    82300    seller seller_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.seller
    ADD CONSTRAINT seller_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.seller DROP CONSTRAINT seller_pkey;
       public         postgres    false    199                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         2855.dat                                                                                            0000600 0004000 0002000 00000000266 13667017374 0014277 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	user	user@gmail.com	User1234	2020-05-31
2	Mustofa	mustofa@gmail.com	Qwer1234	2020-06-01
3	Qwer	qwer@gmail.com	Qwer1234	2020-06-02
4	kamal	kamal@gmail.com	Kamal1234	2020-06-07
\.


                                                                                                                                                                                                                                                                                                                                          2856.dat                                                                                            0000600 0004000 0002000 00000000272 13667017374 0014275 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	food1	1	10000	Bakery
3	food2	2	4600	Bakery
4	food3	3	6900	Bakery
5	food4	4	9200	Bakery
6	food5	5	11500	Bakery
7	food6	6	13800	Bakery
8	food7	7	16100	Bakery
2	food0	1	20000	Coffee
\.


                                                                                                                                                                                                                                                                                                                                      2860.dat                                                                                            0000600 0004000 0002000 00000001126 13667017374 0014267 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        9	2	2020-06-02	Ongoing	10000	\N	Cash	20000
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


                                                                                                                                                                                                                                                                                                                                                                                                                                          2861.dat                                                                                            0000600 0004000 0002000 00000000163 13667017374 0014270 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        11	3	1	58
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


                                                                                                                                                                                                                                                                                                                                                                                                             2859.dat                                                                                            0000600 0004000 0002000 00000000036 13667017374 0014276 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Jawa Barat	Jauh	Bekasi
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  2857.dat                                                                                            0000600 0004000 0002000 00000000060 13667017374 0014271 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        3	test	1000	1000	t
1	firstBuy	5000	10000	t
\.


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                2858.dat                                                                                            0000600 0004000 0002000 00000000455 13667017374 0014302 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        1	Rafid	rafid@gmail.com	0812345678	1
2	Sel2	sel2@gmail.com	081808180818	1
3	Sel3	sel3@gmail.com	081808180818	1
4	Sel4	sel4@gmail.com	081808180818	1
5	Sel5	sel5@gmail.com	081808180818	1
6	Sel6	sel6@gmail.com	081808180818	1
7	Sel7	sel7@gmail.com	081808180818	1
8	Sel7	sel8@gmail.com	081808180818	1
\.


                                                                                                                                                                                                                   restore.sql                                                                                         0000600 0004000 0002000 00000016100 13667017374 0015400 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

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

DROP DATABASE jfood;
--
-- Name: jfood; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE jfood WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';


ALTER DATABASE jfood OWNER TO postgres;

\connect jfood

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
-- Name: invoice_food_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.invoice_food_id_seq OWNED BY public.invoice_food.id;


--
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
-- Name: invoice_food id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_food ALTER COLUMN id SET DEFAULT nextval('public.invoice_food_id_seq'::regclass);


--
-- Data for Name: customer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.customer (id, name, email, password, joindate) FROM stdin;
\.
COPY public.customer (id, name, email, password, joindate) FROM '$$PATH$$/2855.dat';

--
-- Data for Name: food; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.food (id, name, seller, price, category) FROM stdin;
\.
COPY public.food (id, name, seller, price, category) FROM '$$PATH$$/2856.dat';

--
-- Data for Name: invoice; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice (id, customer, date, invoice_status, delivery_fee, promo, payment_type, total_price) FROM stdin;
\.
COPY public.invoice (id, customer, date, invoice_status, delivery_fee, promo, payment_type, total_price) FROM '$$PATH$$/2860.dat';

--
-- Data for Name: invoice_food; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.invoice_food (invoice, food, quantity, id) FROM stdin;
\.
COPY public.invoice_food (invoice, food, quantity, id) FROM '$$PATH$$/2861.dat';

--
-- Data for Name: location; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.location (id, province, description, city) FROM stdin;
\.
COPY public.location (id, province, description, city) FROM '$$PATH$$/2859.dat';

--
-- Data for Name: promo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.promo (id, code, discount, minprice, active) FROM stdin;
\.
COPY public.promo (id, code, discount, minprice, active) FROM '$$PATH$$/2857.dat';

--
-- Data for Name: seller; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.seller (id, name, email, phonenumber, location) FROM stdin;
\.
COPY public.seller (id, name, email, phonenumber, location) FROM '$$PATH$$/2858.dat';

--
-- Name: invoice_food_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.invoice_food_id_seq', 68, true);


--
-- Name: customer customer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);


--
-- Name: food food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (id);


--
-- Name: invoice_food invoice_food_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice_food
    ADD CONSTRAINT invoice_food_pkey PRIMARY KEY (id);


--
-- Name: invoice invoice_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (id);


--
-- Name: location location_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);


--
-- Name: promo promo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promo
    ADD CONSTRAINT promo_pkey PRIMARY KEY (id);


--
-- Name: seller seller_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.seller
    ADD CONSTRAINT seller_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                