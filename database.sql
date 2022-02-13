user: binancebot
pass: 'qwerty'
database: binancedata


--
-- PostgreSQL database dump
--

-- Dumped from database version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)
-- Dumped by pg_dump version 12.9 (Ubuntu 12.9-0ubuntu0.20.04.1)

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

SET default_table_access_method = heap;

--
-- Name: price_hist; Type: TABLE; Schema: public; Owner: binancebot
--
-- TODO update me - primary key
CREATE TABLE public.price_hist (
    id integer NOT NULL,
    currency_name character varying NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    price numeric NOT NULL
);


ALTER TABLE public.price_hist OWNER TO binancebot;

--
-- Name: price_hist_id_seq; Type: SEQUENCE; Schema: public; Owner: binancebot
--

ALTER TABLE public.price_hist ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.price_hist_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: price_hist; Type: TABLE DATA; Schema: public; Owner: binancebot
--

COPY public.price_hist (id, currency_name, "timestamp", price) FROM stdin;
\.


--
-- Name: price_hist_id_seq; Type: SEQUENCE SET; Schema: public; Owner: binancebot
--

SELECT pg_catalog.setval('public.price_hist_id_seq', 1, false);


--
-- PostgreSQL database dump complete
--



