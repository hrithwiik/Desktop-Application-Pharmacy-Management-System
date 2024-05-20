-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 30, 2024 at 03:37 AM
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
-- Database: `pharmacy`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `BatchNo` varchar(255) NOT NULL,
  `MedicineName` varchar(255) NOT NULL,
  `BrandName` varchar(255) NOT NULL,
  `MedicineType` varchar(255) NOT NULL,
  `Qty` int(255) NOT NULL,
  `GST` varchar(255) NOT NULL,
  `Amount` int(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ide` int(11) NOT NULL,
  `MobileNo` varchar(255) NOT NULL,
  `FirstName` varchar(255) NOT NULL,
  `Lastname` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `City` varchar(255) NOT NULL,
  `Pincode` varchar(255) NOT NULL,
  `GSTN` varchar(255) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ide`, `MobileNo`, `FirstName`, `Lastname`, `Address`, `City`, `Pincode`, `GSTN`, `date`) VALUES
(2, '9786188232', 'Ramnath ', 'Das', '25 M.R.-4, Mahalaxmi Nagar, Indore, Indore, Madhya Pradesh, 452010', 'Pune', '411028', 'AADCS0472N', NULL),
(3, '8180996578', 'Swapnil', 'Singh', 'Level 1, Opp Jalgam Vengal Rao Park, Road no. 1, Banjara Hills, Mid Town Plaza, Hyderabad, Hyderabad, Telangana, 500034', 'Hyderabad', '500034', 'AAICS1406R', NULL),
(4, '8180996578', 'Nikhil', 'Rao', '1st Floor, Neelkanth - I, Bhawani Singh Road, Opp Nehru Sahkar, C Scheme, Jaipur - 30200', 'Jaipur', '302001', 'AADCS0472N', NULL),
(5, '7249102934', 'Suman', 'Kaur', 'No. 100, Prestige Towers, Unit 101 ‘A’, 1st Floor, Field Marshal K. M. Cariappa Road (Residency Road), Bengaluru - 560025. Karnataka', 'Bengaluru', '506002', '-', NULL),
(6, '8674588123', 'Adarsh ', 'Bijlani', '5, Suzlon House, Shrimali Society, Nr. Shri Krishna Centre, Mithakhali, Navrangpura, Ahemdabad - 380009', 'chennai', '388091', '-', NULL),
(7, '8180999482', 'Riddhi', 'rajput', 'Nr. Water Tank,, H-24/25, Mahatma Gandhi Udyog Nagar,, Compound of Suzlon Energy Ltd., Dabhel, Nani Daman, Daman, Dadra and Nagar Haveli and Daman and Diu, 396210', '-', '396201', '-', NULL),
(8, '7245678945', 'Pritam', 'dorjay', '#6-3-219, RAMNAGAR Extension. ANANTAPUR-- 515004 ANDHRA PRADESH', 'jammu', '515004', '-', NULL),
(9, '9786188232', 'Nilam', 'Namgili', '5, Suzlon House, Shrimali Society, Nr. Shri Krishna Centre, Mithakhali, Navrangpura, Ahemdabad - 380009', 'Pune', '380009', 'BYLPT7689A', NULL),
(10, '8180099077', 'Rahul', 'Pandey', '104, Delta Wing, 177, Anna Salai, Chennai-600002', 'chennai', '600002', '-', NULL),
(14, '8180999480', 'Hrithwik', 'Singh', 'Swargate', 'Pune', '423087', 'BYLPT4565A', '2024-04-21');

-- --------------------------------------------------------

--
-- Table structure for table `distributor`
--

CREATE TABLE `distributor` (
  `id` int(11) NOT NULL,
  `GSTIN` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `DrugNo` varchar(255) NOT NULL,
  `BankName` varchar(255) NOT NULL,
  `BankAccount` varchar(255) NOT NULL,
  `IFSCCode` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Mobile` varchar(255) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `distributor`
--

INSERT INTO `distributor` (`id`, `GSTIN`, `Name`, `DrugNo`, `BankName`, `BankAccount`, `IFSCCode`, `Email`, `Mobile`, `Address`, `Description`, `date`) VALUES
(3, '26AADCS0472N1Z4', 'Suresh Singh', '-', ' State Bank of India', '20250240844', 'SBIN0000051', 'sureshsingh@gmail.com', '818099234', 'KVM Residence, 5/148, Kanjirakunnam, Kodumbu, Palakkad - 678551', 'Old dealer', NULL),
(4, '32AAICS2717D1ZR', 'Ramesh Kumar', '-', 'State bank of India', '33241821578', 'SBIN0000688', 'RameshSing200@gmail.com', '9876459860', 'V/296A,MOOLAKKADA,VILLAGE SHOLAYOOR,Palakkad,678581', '-', NULL),
(5, '36AADCS0472N1Z3', 'Prithvi das', '-', 'State bank of India', '32528434011', 'SBIN0000568', 'dasprithvi0@gmail.com', '8156879045', 'S.No.42/2 - 3, 54/1 -8, BHENSNLORE, NEAR CHECKPOST, VILLAGE DENUTHA, Daman, Daman and Diu, 396210', 'New Dealer', NULL),
(6, '26AAICS1406R1ZZ', 'Akash Gawahne', '-', 'State bank of India', '34678534011', 'SBIN0000568', 'gawahneak@gmail.com', '7245678332', '104, Delta Wing, 177, Anna Salai, Chennai-600002', 'New Dealer', NULL),
(7, '36AAICS2717D1ZJ', 'Rohan chaugale', '-', 'State bank of India', '23454368711', 'SBIN0000678', 'chaugalelp@gmail.com', '8091000253', 'Level 1, Opp Jalgam Vengal Rao Park, Road no. 1, Banjara Hills, Mid Town Plaza, Hyderabad, Hyderabad, Telangana, 500034', 'Old Dealer', NULL),
(8, '08AAICS2717D1ZI', 'Reddy iyer', '-', 'State bank of India', '22345668745', 'SBIN0000234', 'reddy@gmail.com', '8180005633', '1st Floor, Neelkanth - I, Bhawani Singh Road, Opp Nehru Sahkar, C Scheme, Jaipur - 302001', 'Old Dealer', NULL),
(9, '27AAICS2717D1ZI', 'Pardeep Singh', '-', 'State bank of India', '20291740930', 'SBIN0000123', 'pradeep4567@gmail.com', '7986467889', 'Sr. No 170/1 to 8, One Earth, Opp Magarpatta City, Sade Satra Nali, Hadapsar, Pune - 411028', 'Old Dealer', NULL),
(10, '23AAICS2717D2ZP', 'Swapnil Thakur', '-', 'State bank of India', '32528780131', 'SBIN0000324', 'swapnilsT@gmail.com', '9845676554', '25 M.R.-4, Mahalaxmi Nagar, Indore, Indore, Madhya Pradesh, 452010', 'New Dealer', NULL),
(11, '63AAIUS2717D2ZI', 'Jatin sharma', '-', 'State bank of India', '29528757385', 'SBIN0000824', 'sjatin234@gmail.com', '8795677856', '56 kalyani Nagar, Indore, Indore, Madhya Pradesh, 452010', 'New Dealer', NULL),
(12, '29AAICS2717D1ZE', 'Aarush Bhola', '-', 'State bank of India', '2954814678', 'SBIN0000674', 'AnkitKumar@gmail.com', '8145688546', 'No. 100, Prestige Towers, Unit 101 ‘A’, 1st Floor, Field Marshal K. M.', 'New Dealer', NULL),
(13, '24AAICS2717D1ZO', 'Samarth addarsh', '-', 'State bank of India', '32557371292 ', 'SBIN0000456', 'sam3456@gmail.com', '8794661235', '5, Suzlon House, Shrimali Society, Nr. Shri Krishna Centre, Mithakhali, Navrangpura, Ahemdabad - 380009', 'Old Dealer', NULL),
(14, '37AAICS2717D2ZG', 'JP Singh', '-', 'State bank of India', '36557357865', 'SBIN0000786', 'jppsingh678@gmail.com', '8769566789', '#6-3-219, RAMNAGAR Extension. ANANTAPUR-- 515004 ANDHRA PRADESH', 'Old Dealer', NULL),
(15, '36AAICS1406R1ZY', 'Nikhil Chinapa', '-', 'State bank of India', '27857345678', 'SBIN0000345', 'nikkichinapa@gmail.com', '8745788346', 'Level 1, Opp Jalgam Vengal Rao Park, Road no. 1, Banjara Hills, Mid Town Plaza, Hyderabad, Hyderabad, Telangana, 500034', 'New Dealer', NULL),
(16, '30AAICS2787D1ZR', 'Rahul ponia', '-', 'State bank of India', '33241821578', 'SBIN0000783', 'Rahulponia@gmail.com', '9866454567', 'Addarsh,MOOLAKKADA,VILLAGE SHOLAYOOR,Palakkad,678581', '-', NULL),
(17, '33AAICS1406R1Z4', 'Dogra Singh', '-', 'State bank of India', '36248829578', 'SBIN0000783', 'dograraosingh@gmail.com', '8765334560', 'Addarsh,MOOLAKKADA,VILLAGE SHOLAYOOR,Palakkad,678581', 'Old Dealar', NULL),
(18, '08AAICS1406R1ZX', 'Omsai das', '-', 'State bank of India', '36248345654', 'SBIN0000789', 'saidas@gmail.com', '768445678', '1st Floor, Neelkanth - I, Bhawani Singh Road, Opp Nehru Sahkar, C Scheme, Jaipur - 302001', 'Old Dealar', NULL),
(20, '27AAICS1406R3ZV1', 'Siddhi Singh', '-', 'State bank of India', '20167136806', 'SBIN0000397', 'Sddhi@gmail.com', '8796188564', 'Sr. No 170/1 to 8, One Earth, Opp Magarpatta City, Sade Satra Nali, Hadapsar, Pune - 411028', 'Old Dealar', '2024-04-20'),
(21, '27AAICS1406R3ZV11', 'Riddhi Singh', '-', 'State bank of India', '20167136806', 'SBIN0000397', 'riddhi@gmail.com', '8796188564', 'Sr. No 170/1 to 8, One Earth, Opp Magarpatta City, Sade Satra Nali, Hadapsar, Pune - 411028', 'Old Dealar', '2024-04-20');

-- --------------------------------------------------------

--
-- Table structure for table `purchase`
--

CREATE TABLE `purchase` (
  `id` int(11) NOT NULL,
  `Distributor` varchar(255) NOT NULL,
  `BatchNo` int(255) NOT NULL,
  `ExpiryDate` date NOT NULL,
  `MedicineName` varchar(255) NOT NULL,
  `BrandName` varchar(255) NOT NULL,
  `MedicineType` varchar(255) NOT NULL,
  `MRP` double NOT NULL,
  `RetailPrice` double NOT NULL,
  `SupplierPrice` double NOT NULL,
  `Qty` int(255) NOT NULL,
  `Discount` double NOT NULL,
  `GST` varchar(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchase`
--

INSERT INTO `purchase` (`id`, `Distributor`, `BatchNo`, `ExpiryDate`, `MedicineName`, `BrandName`, `MedicineType`, `MRP`, `RetailPrice`, `SupplierPrice`, `Qty`, `Discount`, `GST`, `date`) VALUES
(10, 'Suresh Singh', 101, '2025-04-11', 'Dolo', 'Cipla', 'a', 123, 110, 100, 2, 0, '1', '2024-04-20');

-- --------------------------------------------------------

--
-- Table structure for table `sale`
--

CREATE TABLE `sale` (
  `id` int(11) NOT NULL,
  `BatchNo` int(255) NOT NULL,
  `MedicineName` varchar(255) NOT NULL,
  `BrandName` varchar(255) NOT NULL,
  `MedicineType` varchar(255) NOT NULL,
  `Qty` int(255) NOT NULL,
  `GST` varchar(255) NOT NULL,
  `Amount` int(255) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `sale`
--

INSERT INTO `sale` (`id`, `BatchNo`, `MedicineName`, `BrandName`, `MedicineType`, `Qty`, `GST`, `Amount`, `date`) VALUES
(1, 1234, 'cetrizine', 'emcure', 'Tablets', 2, '18', 160, '2024-04-22'),
(2, 1013, 'Dolo', 'Cipla', 'Lotion', 2, '18', 197, '2024-04-11'),
(3, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(4, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(5, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(6, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(7, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(8, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(9, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(10, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(11, 101, 'Dolo', 'Cipla', 'a', 3, 'null', 365, '2024-04-30'),
(12, 101, 'Dolo', 'Cipla', 'a', 3, '15', 365, '2024-04-30'),
(13, 101, 'Dolo', 'Cipla', 'a', 3, '15', 358, '2024-04-30'),
(14, 101, 'Dolo', 'Cipla', 'a', 3, '15', 358, '2024-04-30'),
(15, 101, 'Dolo', 'Cipla', 'a', 3, '15', 358, '2024-04-30'),
(16, 101, 'Dolo', 'Cipla', 'a', 4, '18', 472, '2024-04-30'),
(17, 101, 'Dolo', 'Cipla', 'a', 4, '18', 472, '2024-04-30'),
(18, 101, 'Dolo', 'Cipla', 'a', 4, '18', 472, '2024-04-30'),
(19, 101, 'Dolo', 'Cipla', 'a', 4, '15', 472, '2024-04-30'),
(20, 101, 'Dolo', 'Cipla', 'a', 4, '15', 472, '2024-04-30'),
(21, 101, 'Dolo', 'Cipla', 'a', 4, '15', 472, '2024-04-30'),
(22, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30'),
(23, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30'),
(24, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30'),
(25, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30'),
(26, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30'),
(27, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30'),
(28, 101, 'Dolo', 'Cipla', '45', 1, '18', 122, '2024-04-30');

-- --------------------------------------------------------

--
-- Table structure for table `sample`
--

CREATE TABLE `sample` (
  `id` int(255) NOT NULL,
  `BatchNo` int(255) NOT NULL,
  `GST` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ide`);

--
-- Indexes for table `distributor`
--
ALTER TABLE `distributor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `purchase`
--
ALTER TABLE `purchase`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sample`
--
ALTER TABLE `sample`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `ide` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `distributor`
--
ALTER TABLE `distributor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `purchase`
--
ALTER TABLE `purchase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `sale`
--
ALTER TABLE `sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `sample`
--
ALTER TABLE `sample`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
