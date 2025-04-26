-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 12, 2025 at 04:55 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbecommerce_orders`
--

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `order_date` datetime NOT NULL,
  `order_status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `product_id`, `quantity`, `order_date`, `order_status`) VALUES
(1, 9, 2, '2025-03-01 03:00:00', 'CREATED'),
(3, 9, 15, '2025-03-01 03:00:00', 'CREATED'),
(4, 7, 15, '2025-03-01 03:00:00', 'CREATED'),
(5, 3, 15, '2025-03-01 03:00:00', 'CREATED'),
(6, 5, 15, '2025-03-01 03:00:00', 'CREATED'),
(7, 6, 15, '2025-03-01 03:00:00', 'CREATED'),
(8, 7, 15, '2025-03-01 03:00:00', 'CREATED'),
(9, 8, 15, '2025-03-01 03:00:00', 'CREATED'),
(10, 9, 15, '2025-03-01 03:00:00', 'CREATED'),
(11, 9, 15, '2025-03-01 03:00:00', 'CREATED'),
(12, 9, 18, '2025-03-01 03:00:00', 'CREATED'),
(13, 22, 18, '2025-03-01 03:00:00', 'CREATED');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
