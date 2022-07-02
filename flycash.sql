-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 22, 2021 at 05:34 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flycash`
--

-- --------------------------------------------------------

--
-- Table structure for table `admins`
--

CREATE TABLE `admins` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `openning_date` timestamp NULL DEFAULT NULL,
  `profit` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `admins`
--

INSERT INTO `admins` (`id`, `name`, `email`, `password`, `type`, `phone`, `nid`, `dob`, `openning_date`, `profit`, `created_at`, `updated_at`) VALUES
(3, 'Faiyaz Shahrear', 'shahrearfaiyaz@gmail.com', '12345678', 'admin', '01749549840', '021556231322', '11-1-1995', NULL, '500', '2021-07-02 12:36:27', '2021-07-02 12:36:27');

-- --------------------------------------------------------

--
-- Table structure for table `agents`
--

CREATE TABLE `agents` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `balance` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `openning_date` timestamp NULL DEFAULT NULL,
  `transaction_status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `agents`
--

INSERT INTO `agents` (`id`, `name`, `email`, `password`, `type`, `phone`, `nid`, `dob`, `balance`, `openning_date`, `transaction_status`, `created_at`, `updated_at`) VALUES
(1, 'Borno', 'Borno@gmail.com', '12345678', 'agent', '01749549840', '021556231321', '11-1-1995', '500', NULL, '1', '2021-07-02 12:36:49', '2021-07-02 12:36:49'),
(2, 'Faiyaz', 'sfaiyaz@gmail.com', '12345678', 'agent', '012587495', '522445857424', '2021-07-06', '20', NULL, '1', '2021-07-02 14:44:42', '2021-07-02 14:44:42');

-- --------------------------------------------------------

--
-- Table structure for table `agentstransactions`
--

CREATE TABLE `agentstransactions` (
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `transaction_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `balance` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `agentstransactions`
--

INSERT INTO `agentstransactions` (`email`, `phone`, `transaction_type`, `amount`, `balance`, `date`, `created_at`, `updated_at`) VALUES
('Borno@gmail.com.', '01749549840', 'Add Money', '50000', '50000', '2021-07-02 12:37:14', '2021-07-02 12:37:14', '2021-07-02 12:37:14');

-- --------------------------------------------------------

--
-- Table structure for table `campaigns`
--

CREATE TABLE `campaigns` (
  `title` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sdate` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `edate` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `id` bigint(20) UNSIGNED NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `campaigns`
--

INSERT INTO `campaigns` (`title`, `sdate`, `edate`, `image`, `id`, `created_at`, `updated_at`) VALUES
('project', '2021-07-09', '2021-07-21', '1625279340.png', 1, '2021-07-02 14:29:00', '2021-07-02 14:29:00');

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `balance` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `transaction_status` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `openning_date` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`id`, `name`, `email`, `password`, `type`, `phone`, `nid`, `dob`, `balance`, `transaction_status`, `openning_date`, `created_at`, `updated_at`) VALUES
(1, 'JahidulHasan', 'joy@gmail.com', '1234567', 'customer', '01973545413', '0215561321', '11-1-1995', '1250463', 'blocked', NULL, '2021-07-02 12:38:06', '2021-08-19 23:24:52'),
(2, 'ridoy', 'kabir@gmail.com', '12345678', 'customer', '01796270545', '2155451', '2010-10-03', '20', '1', NULL, '2021-07-02 13:15:32', '2021-07-02 13:15:32'),
(7, 'Jahidul Hasan', 'hasanjoy28@gmail.com', 'as', 'customer', '01631137535', '9164794324', '2021-08-13', '20', 'unblocked', NULL, '2021-08-17 20:14:49', '2021-08-17 20:14:49'),
(9, 'MD KAMAL SHARIF RANA', 'hasanjsasdfdoy28@gmail.com', 'a4applee%', 'customer', '01112235548', '01231212548', '2021-08-25', '20', 'unblocked', NULL, '2021-08-19 23:03:33', '2021-08-19 23:03:33');

-- --------------------------------------------------------

--
-- Table structure for table `customerstransactions`
--

CREATE TABLE `customerstransactions` (
  `id` int(100) NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `transaction_type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `amount` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `balance` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customerstransactions`
--

INSERT INTO `customerstransactions` (`id`, `email`, `phone`, `transaction_type`, `amount`, `balance`, `date`, `created_at`, `updated_at`) VALUES
(1, 'joy@gmail.com', '01749549840', 'Add Money', '5000', '50000', '2021-08-09 22:23:41', '2021-07-02 12:41:23', '2021-07-02 12:41:23'),
(6, 'joy@gmail.com', '01631137535', 'Add Money', '500', '10500', '2021-08-15 21:36:06', '2021-08-15 21:36:06', '2021-08-15 21:36:06'),
(8, 'joy@gmail.com', '01631137535', 'Add Money', '500', '11000', '2021-08-15 21:39:25', '2021-08-15 21:39:25', '2021-08-15 21:39:25'),
(10, 'joy@gmail.com', '01631137535', 'Cash out', '500', '11500', '2021-08-15 21:40:18', '2021-08-15 21:40:18', '2021-08-15 21:40:18'),
(12, 'joy@gmail.com', '01631137535', 'Transfer money', '500', '12000', '2021-08-15 21:40:34', '2021-08-15 21:40:34', '2021-08-15 21:40:34'),
(14, 'joy@gmail.com', '01631137535', 'Mobile Recharge', '500', '12500', '2021-08-15 21:41:14', '2021-08-15 21:41:14', '2021-08-15 21:41:14'),
(16, 'joy@gmail.com', '01631137535', 'Payment', '500', '13000', '2021-08-15 21:42:06', '2021-08-15 21:42:06', '2021-08-15 21:42:06'),
(18, 'joy@gmail.com', '01631137535', 'Mobile Recharge', '1234567', '1247567', '2021-08-15 21:46:27', '2021-08-15 21:46:27', '2021-08-15 21:46:27'),
(20, 'joy@gmail.com', '01631137535', 'Cash out', '4', '1247571', '2021-08-15 21:52:49', '2021-08-15 21:52:49', '2021-08-15 21:52:49'),
(25, 'joy@gmail.com', '01631137535', 'Add Money', '500', '2983', '2021-08-15 22:03:49', '2021-08-15 22:03:49', '2021-08-15 22:03:49'),
(26, 'joy@gmail.com', '01631137535', 'Add Money', '500', '3483', '2021-08-15 22:04:57', '2021-08-15 22:04:57', '2021-08-15 22:04:57'),
(27, 'joy@gmail.com', '01631137535', 'Add Money', '500', '3983', '2021-08-15 22:07:28', '2021-08-15 22:07:28', '2021-08-15 22:07:28'),
(28, 'joy@gmail.com', '01953335453', 'Add Money', '5000', '8983', '2021-08-15 22:11:17', '2021-08-15 22:11:17', '2021-08-15 22:11:17'),
(29, 'joy@gmail.com', '01631137535', 'Add Money', '500', '9483', '2021-08-15 22:20:12', '2021-08-15 22:20:12', '2021-08-15 22:20:12'),
(30, 'joy@gmail.com', '01631137535', 'Cash out', '500', '8983', '2021-08-15 22:23:17', '2021-08-15 22:23:17', '2021-08-15 22:23:17'),
(31, 'joy@gmail.com', '01631137535', 'Send Money', '83', '8900', '2021-08-15 22:28:45', '2021-08-15 22:28:45', '2021-08-15 22:28:45'),
(32, 'joy@gmail.com', '01631137535', 'Add Money', '500', '9400', '2021-08-15 22:35:58', '2021-08-15 22:35:58', '2021-08-15 22:35:58'),
(33, 'joy@gmail.com', '01631137535', 'Cash out', '400', '9000', '2021-08-15 22:43:29', '2021-08-15 22:43:29', '2021-08-15 22:43:29'),
(34, 'joy@gmail.com', 'MASTUL Foundation', 'Donate', '500', '8500', '2021-08-15 22:47:39', '2021-08-15 22:47:39', '2021-08-15 22:47:39'),
(35, 'joy@gmail.com', '01631137535', 'Payment', '500', '8000', '2021-08-16 19:03:07', '2021-08-16 19:03:07', '2021-08-16 19:03:07'),
(36, 'joy@gmail.com', '01631137535', 'Add Money', '1234567', '1242567', '2021-08-16 19:03:26', '2021-08-16 19:03:26', '2021-08-16 19:03:26'),
(37, 'joy@gmail.com', '01631137535', 'Send Money', '500', '1242067', '2021-08-17 15:21:28', '2021-08-17 15:21:28', '2021-08-17 15:21:28'),
(38, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1242567', '2021-08-17 15:21:44', '2021-08-17 15:21:44', '2021-08-17 15:21:44'),
(39, 'joy@gmail.com', '01631137535', 'Send Money', '500', '1242067', '2021-08-17 16:40:29', '2021-08-17 16:40:29', '2021-08-17 16:40:29'),
(40, 'joy@gmail.com', '01631137535', 'Send Money', '4', '1242063', '2021-08-17 16:41:17', '2021-08-17 16:41:17', '2021-08-17 16:41:17'),
(41, 'joy@gmail.com', '01631137535', 'Send Money', '500', '1241563', '2021-08-17 17:07:51', '2021-08-17 17:07:51', '2021-08-17 17:07:51'),
(42, 'joy@gmail.com', '01631137535', 'Send Money', '500', '1241063', '2021-08-17 17:12:01', '2021-08-17 17:12:01', '2021-08-17 17:12:01'),
(43, 'joy@gmail.com', '01631137535', 'Cash out', '500', '1240563', '2021-08-17 17:12:52', '2021-08-17 17:12:52', '2021-08-17 17:12:52'),
(44, 'joy@gmail.com', '01631137535', 'Transfer money', '500', '1240063', '2021-08-18 20:11:14', '2021-08-18 20:11:14', '2021-08-18 20:11:14'),
(45, 'joy@gmail.com', '01631137535', 'Transfer money', '500', '1239563', '2021-08-18 20:14:48', '2021-08-18 20:14:48', '2021-08-18 20:14:48'),
(46, 'joy@gmail.com', '01631137535', 'Transfer money', '500', '1239063', '2021-08-18 20:15:35', '2021-08-18 20:15:35', '2021-08-18 20:15:35'),
(47, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1239563', '2021-08-18 21:15:43', '2021-08-18 21:15:43', '2021-08-18 21:15:43'),
(48, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1240063', '2021-08-18 21:25:29', '2021-08-18 21:25:29', '2021-08-18 21:25:29'),
(49, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1240563', '2021-08-18 21:26:51', '2021-08-18 21:26:51', '2021-08-18 21:26:51'),
(50, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1241063', '2021-08-18 21:27:39', '2021-08-18 21:27:39', '2021-08-18 21:27:39'),
(51, 'joy@gmail.com', '01973545413', 'Add Money', '500', '1241563', '2021-08-18 21:27:55', '2021-08-18 21:27:55', '2021-08-18 21:27:55'),
(52, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1242063', '2021-08-19 01:36:07', '2021-08-19 01:36:07', '2021-08-19 01:36:07'),
(53, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1242563', '2021-08-19 01:36:58', '2021-08-19 01:36:58', '2021-08-19 01:36:58'),
(54, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1243063', '2021-08-19 01:48:05', '2021-08-19 01:48:05', '2021-08-19 01:48:05'),
(55, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1243563', '2021-08-19 02:05:58', '2021-08-19 02:05:58', '2021-08-19 02:05:58'),
(56, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1244063', '2021-08-19 04:22:47', '2021-08-19 04:22:47', '2021-08-19 04:22:47'),
(57, 'joy@gmail.com', '01631137535', 'Send Money', '500', '1243563', '2021-08-19 04:44:08', '2021-08-19 04:44:08', '2021-08-19 04:44:08'),
(58, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1244063', '2021-08-19 04:44:51', '2021-08-19 04:44:51', '2021-08-19 04:44:51'),
(59, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1244563', '2021-08-19 04:45:55', '2021-08-19 04:45:55', '2021-08-19 04:45:55'),
(60, 'joy@gmail.com', '01973545413', 'Add Money', '5000', '1249563', '2021-08-19 04:46:46', '2021-08-19 04:46:46', '2021-08-19 04:46:46'),
(61, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1250063', '2021-08-19 04:47:13', '2021-08-19 04:47:13', '2021-08-19 04:47:13'),
(62, 'joy@gmail.com', '12312312111', 'Mobile Recharge', '100', '1249963', '2021-08-19 16:17:30', '2021-08-19 16:17:30', '2021-08-19 16:17:30'),
(63, 'joy@gmail.com', '01631137535', 'Add Money', '500', '1250463', '2021-08-19 23:24:52', '2021-08-19 23:24:52', '2021-08-19 23:24:52');

-- --------------------------------------------------------

--
-- Table structure for table `loginusers`
--

CREATE TABLE `loginusers` (
  `id` int(10) UNSIGNED NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_loggedin` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `loginusers`
--

INSERT INTO `loginusers` (`id`, `email`, `password`, `phone`, `nid`, `type`, `last_loggedin`, `created_at`, `updated_at`) VALUES
(1, 'joy@gmail.com', '1234567', '01749569840', '0215561321', 'customer', NULL, '2021-07-02 12:41:47', '2021-07-02 12:41:47'),
(2, 'Borno@gmail.com', '12345678', '01749449840', '021556231321', 'agent', NULL, '2021-07-02 12:41:47', '2021-07-02 12:41:47'),
(3, 'shahrearfaiyaz@gmail.com', '12345678', '01749549840', '021556231322', 'admin', NULL, '2021-07-02 12:41:48', '2021-07-02 12:41:48'),
(4, 'raridoy@gmail.com', 'needhelp', '01743369163', '3453453453', 'officer', NULL, '2021-07-02 12:41:48', '2021-07-02 12:41:48'),
(11, 'hasanjoy28@gmail.com', 'as', '01631137535', '9164794324', 'customer', NULL, '2021-08-17 20:14:49', '2021-08-17 20:14:49'),
(12, 'asds@aiub.com', 'a4applee%', '01973545413', '45623154541', 'customer', NULL, '2021-08-19 23:02:20', '2021-08-19 23:02:20'),
(13, 'hasanjsasdfdoy28@gmail.com', 'a4applee%', '01112235548', '01231212548', 'customer', NULL, '2021-08-19 23:03:33', '2021-08-19 23:03:33');

-- --------------------------------------------------------

--
-- Table structure for table `officers`
--

CREATE TABLE `officers` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dob` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `type` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `image` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `officers`
--

INSERT INTO `officers` (`id`, `name`, `email`, `password`, `phone`, `nid`, `dob`, `type`, `image`, `created_at`, `updated_at`) VALUES
(1, 'Ruhul', 'raridoy@gmail.com', 'needhelp', '01743369163', '3453453453', '05-02-1998', 'officer', NULL, '2021-07-02 12:42:10', '2021-07-02 12:42:10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `admins_email_unique` (`email`),
  ADD UNIQUE KEY `admins_phone_unique` (`phone`),
  ADD UNIQUE KEY `admins_nid_unique` (`nid`);

--
-- Indexes for table `agents`
--
ALTER TABLE `agents`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `agents_email_unique` (`email`),
  ADD UNIQUE KEY `agents_phone_unique` (`phone`),
  ADD UNIQUE KEY `agents_nid_unique` (`nid`);

--
-- Indexes for table `campaigns`
--
ALTER TABLE `campaigns`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `customers_email_unique` (`email`),
  ADD UNIQUE KEY `customers_phone_unique` (`phone`),
  ADD UNIQUE KEY `customers_nid_unique` (`nid`);

--
-- Indexes for table `customerstransactions`
--
ALTER TABLE `customerstransactions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loginusers`
--
ALTER TABLE `loginusers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `loginusers_email_unique` (`email`),
  ADD UNIQUE KEY `loginusers_phone_unique` (`phone`),
  ADD UNIQUE KEY `loginusers_nid_unique` (`nid`);

--
-- Indexes for table `officers`
--
ALTER TABLE `officers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `officers_email_unique` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `agents`
--
ALTER TABLE `agents`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `campaigns`
--
ALTER TABLE `campaigns`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `customerstransactions`
--
ALTER TABLE `customerstransactions`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT for table `loginusers`
--
ALTER TABLE `loginusers`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `officers`
--
ALTER TABLE `officers`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
