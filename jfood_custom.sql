PGDMP     ;    6                x            jfood    11.5    11.5     1           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            2           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            3           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            4           1262    82260    jfood    DATABASE     �   CREATE DATABASE jfood WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_Indonesia.1252' LC_CTYPE = 'English_Indonesia.1252';
    DROP DATABASE jfood;
             postgres    false            �            1259    82261    customer    TABLE     �   CREATE TABLE public.customer (
    id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    password text NOT NULL,
    joindate date DEFAULT CURRENT_DATE NOT NULL
);
    DROP TABLE public.customer;
       public         postgres    false            �            1259    82270    food    TABLE     �   CREATE TABLE public.food (
    id integer NOT NULL,
    name text NOT NULL,
    seller integer NOT NULL,
    price integer NOT NULL,
    category text NOT NULL
);
    DROP TABLE public.food;
       public         postgres    false            �            1259    82316    invoice    TABLE       CREATE TABLE public.invoice (
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
       public         postgres    false            �            1259    82325    invoice_food    TABLE     �   CREATE TABLE public.invoice_food (
    invoice integer NOT NULL,
    food integer NOT NULL,
    quantity integer DEFAULT 1 NOT NULL,
    id integer NOT NULL
);
     DROP TABLE public.invoice_food;
       public         postgres    false            �            1259    82335    invoice_food_id_seq    SEQUENCE     �   CREATE SEQUENCE public.invoice_food_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.invoice_food_id_seq;
       public       postgres    false    202            5           0    0    invoice_food_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.invoice_food_id_seq OWNED BY public.invoice_food.id;
            public       postgres    false    203            �            1259    82301    location    TABLE     �   CREATE TABLE public.location (
    id integer NOT NULL,
    province text NOT NULL,
    description text NOT NULL,
    city text NOT NULL
);
    DROP TABLE public.location;
       public         postgres    false            �            1259    82285    promo    TABLE     �   CREATE TABLE public.promo (
    id integer NOT NULL,
    code text NOT NULL,
    discount integer NOT NULL,
    minprice integer NOT NULL,
    active boolean DEFAULT true NOT NULL
);
    DROP TABLE public.promo;
       public         postgres    false            �            1259    82293    seller    TABLE     �   CREATE TABLE public.seller (
    id integer NOT NULL,
    name text NOT NULL,
    email text NOT NULL,
    phonenumber text NOT NULL,
    location integer NOT NULL
);
    DROP TABLE public.seller;
       public         postgres    false            �
           2604    82337    invoice_food id    DEFAULT     r   ALTER TABLE ONLY public.invoice_food ALTER COLUMN id SET DEFAULT nextval('public.invoice_food_id_seq'::regclass);
 >   ALTER TABLE public.invoice_food ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    203    202            '          0    82261    customer 
   TABLE DATA               G   COPY public.customer (id, name, email, password, joindate) FROM stdin;
    public       postgres    false    196   [       (          0    82270    food 
   TABLE DATA               A   COPY public.food (id, name, seller, price, category) FROM stdin;
    public       postgres    false    197   �       ,          0    82316    invoice 
   TABLE DATA               u   COPY public.invoice (id, customer, date, invoice_status, delivery_fee, promo, payment_type, total_price) FROM stdin;
    public       postgres    false    201   H       -          0    82325    invoice_food 
   TABLE DATA               C   COPY public.invoice_food (invoice, food, quantity, id) FROM stdin;
    public       postgres    false    202           +          0    82301    location 
   TABLE DATA               C   COPY public.location (id, province, description, city) FROM stdin;
    public       postgres    false    200   \        )          0    82285    promo 
   TABLE DATA               E   COPY public.promo (id, code, discount, minprice, active) FROM stdin;
    public       postgres    false    198   �        *          0    82293    seller 
   TABLE DATA               H   COPY public.seller (id, name, email, phonenumber, location) FROM stdin;
    public       postgres    false    199   �        6           0    0    invoice_food_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.invoice_food_id_seq', 68, true);
            public       postgres    false    203            �
           2606    82269    customer customer_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT customer_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.customer DROP CONSTRAINT customer_pkey;
       public         postgres    false    196            �
           2606    82277    food food_pkey 
   CONSTRAINT     L   ALTER TABLE ONLY public.food
    ADD CONSTRAINT food_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.food DROP CONSTRAINT food_pkey;
       public         postgres    false    197            �
           2606    82339    invoice_food invoice_food_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.invoice_food
    ADD CONSTRAINT invoice_food_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.invoice_food DROP CONSTRAINT invoice_food_pkey;
       public         postgres    false    202            �
           2606    82324    invoice invoice_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.invoice
    ADD CONSTRAINT invoice_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.invoice DROP CONSTRAINT invoice_pkey;
       public         postgres    false    201            �
           2606    82308    location location_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.location
    ADD CONSTRAINT location_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.location DROP CONSTRAINT location_pkey;
       public         postgres    false    200            �
           2606    82292    promo promo_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.promo
    ADD CONSTRAINT promo_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.promo DROP CONSTRAINT promo_pkey;
       public         postgres    false    198            �
           2606    82300    seller seller_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.seller
    ADD CONSTRAINT seller_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.seller DROP CONSTRAINT seller_pkey;
       public         postgres    false    199            '   h   x�3�,-N-鹉�9z�����@����	����������!��oiqI~Z"g.�FRX���L����,�YX�b2�J#.���������GUl����� A`3U      (   e   x�Eα� ����0�(��k�����o/�һ�~Ƙ�f��5���ߏ��@��5�FDhsͦ		M\�4#�9;c��cu����,�aՉ�s���܈��.B      ,   �   x��н� ��x���h�j�/��hmI&b�^�`i,1�F�q��Z  N���g7<� y(�Np��1�PL.Í����7@R	��T���%�.�ȳzcB*�P��f���r�5�3~�I�RG,28��y��~z���ރ��#��In%(U�\��7Y�t�F��c��
      -   G   x�=��� �w<LU��.�?G1H�D'�!͍��W�Rm�+�DI�lҐ���n�A�	��4�����cz      +   $   x�3��J,OTpJ,J,2K38�R��3�b���� ��c      )   +   x�3�,I-.�4400�%\��i�E�%N����0a�x� �
�      *   k   x�u�;
�0E�z��`�S�mm�?	���
S�[CC��B'��-���Q��:bb2�ҸVK׳?�9 �d�<��Q 
@AF(E%��d�bMZ)u9�M�     