-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th9 08, 2023 lúc 05:37 PM
-- Phiên bản máy phục vụ: 10.4.27-MariaDB
-- Phiên bản PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `market3`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `CatagoryID` int(10) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Description` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`CatagoryID`, `Name`, `Description`) VALUES
(1, 'Fruit', 'The kind that can be eaten without cooking'),
(2, 'Green Vegetables', 'The kind used to make salads or soups'),
(3, 'Spices', 'The kind used to enhance the taste of food');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Fullname` varchar(40) NOT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `City` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customers`
--

INSERT INTO `customers` (`CustomerID`, `Password`, `Fullname`, `Address`, `City`) VALUES
(1, 'Abcd1234', 'John Smith', '30 Broadway', 'London'),
(2, 'Abcd1234', 'Jonny English', '99 River View', 'Reading'),
(4, 'Abcd1234', 'Beatrix', '66 Royal Crescent', 'Bath'),
(6, '123', 'Huong', 'Thu Duc', 'HCM'),
(7, '', 'John Smith', '30 Broadway 1111', 'London 1111'),
(8, '123', 'thanh', 'q5', 'binh duong'),
(73, 'szfcasda', 'dasdsa', 'dasd', 'dasda'),
(74, 'dwad', 'da', 'wawdwa', 'awdwa'),
(75, 'wd', 'awdawddwadwadwdawd', 'wadwad', 'dwada');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(76);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order`
--

CREATE TABLE `order` (
  `OrderID` int(10) UNSIGNED NOT NULL,
  `CustomerID` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Total` float NOT NULL,
  `Note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `order`
--

INSERT INTO `order` (`OrderID`, `CustomerID`, `Date`, `Total`, `Note`) VALUES
(0, 3, '2023-04-05', 160000, 'rfrdw'),
(1, 2, '2021-08-16', 235000, ''),
(2, 3, '2021-08-16', 65000, 'Need fast delivery'),
(3, 3, '2021-08-17', 80000, ''),
(20, 1, '2023-04-05', 280000, 'abc'),
(21, 2, '2023-04-04', 330000, 'eeeeeeeeeeeeeee'),
(22, 6, '2023-04-05', 137000, 'tham ngan'),
(23, 8, '2023-04-04', 5415000, 'yyyyyyyyyyyyyyyyyyy'),
(24, 4, '2023-04-05', 178000, 'dddddd'),
(25, 7, '2023-04-05', 119000, 'dddwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww'),
(26, 7, '2023-04-05', 195000, ''),
(27, 8, '2023-04-05', 975000, 'qqqqq'),
(29, 6, '2023-04-05', 225000, 'sadsda'),
(30, 4, '2023-04-05', 77000, 'rffEFFGREATWEATWETW'),
(31, 8, '2023-04-05', 130000, 'WERGFWEWSDADAS'),
(32, 7, '2023-04-05', 190000, ''),
(33, 7, '2023-04-05', 255000, '23123123'),
(34, 3, '2023-04-05', 185000, 'ee'),
(35, 3, '2023-04-05', 124000, 'wfwfw'),
(36, 6, '2023-04-05', 190000, 'effer'),
(37, 3, '2023-04-05', 150000, 'dawdawd'),
(38, 2, '2023-04-05', 225000, 'dwadw'),
(39, 2, '2023-04-05', 260000, 'dwadwad'),
(40, 3, '2023-04-05', 460000, 'szdad'),
(41, 4, '2023-04-05', 154000, 'dfsfsfsfs'),
(42, 2, '2023-04-05', 45000, 'asrwedaadwadwa'),
(43, 3, '2023-04-05', 225000, 'essfsdffsd'),
(44, 2, '2023-04-05', 280000, 'wreweffeefws'),
(45, 3, '2023-04-05', 194000, 'effeeeffsaefs'),
(46, 2, '2023-04-05', 255000, 'sacfssdasda'),
(48, 4, '2023-04-05', 430000, 'rawdawd'),
(49, 3, '2023-04-05', 545000, 'xdfsefse'),
(50, 2, '2023-04-05', 310000, 'ewrrwr'),
(51, 2, '2023-04-05', 670000, 'sdffsfwefse'),
(52, 2, '2023-04-05', 430000, 'fferwsefsef'),
(53, 2, '2023-04-05', 490000, 'dwdqdw'),
(54, 1, '2023-04-05', 465000, 'dwawdwa'),
(55, 3, '2023-04-05', 152000, 'efwfewsfwefw'),
(57, 3, '2023-04-05', 460000, 'qwdqwdqwd'),
(58, 2, '2023-04-05', 189000, ''),
(60, 3, '2023-04-05', 154000, 'swswqsw'),
(61, 2, '2023-04-05', 112000, 'dadawd'),
(62, 4, '2023-04-05', 280000, 'dasdasdas'),
(63, 3, '2023-04-05', 152000, 'adwadwad'),
(64, 8, '2023-04-05', 150000, 'dawawdaw'),
(65, 3, '2023-04-05', 675000, 'fasfsdfsdf'),
(68, 2, '2023-04-05', 295000, ''),
(69, 3, '2023-04-05', 415000, 'dwadwad'),
(70, 2, '2023-04-05', 105000, 'adwda'),
(72, 4, '2023-04-05', 36000, 'hfdghgfh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetail`
--

CREATE TABLE `orderdetail` (
  `OrderID` int(10) UNSIGNED NOT NULL,
  `VegetableID` int(10) NOT NULL,
  `Quantity` tinyint(4) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `orderdetail`
--

INSERT INTO `orderdetail` (`OrderID`, `VegetableID`, `Quantity`, `Price`) VALUES
(0, 1, 3, 90000),
(0, 8, 1, 120000),
(1, 4, 1, 80000),
(1, 2, 1, 35000),
(1, 3, 1, 150000),
(2, 5, 1, 35000),
(2, 7, 2, 30000),
(3, 6, 2, 80000),
(21, 1, 1, 30000),
(21, 3, 2, 300000),
(23, 1, 2, 60000),
(23, 2, 3, 105000),
(23, 3, 3, 450000),
(24, 8, 9, 18000),
(24, 6, 4, 160000),
(25, 5, 1, 35000),
(25, 6, 2, 80000),
(25, 8, 2, 4000),
(26, 1, 3, 90000),
(26, 2, 3, 105000),
(29, 5, 3, 105000),
(29, 6, 3, 120000),
(30, 5, 1, 35000),
(30, 6, 1, 40000),
(30, 8, 1, 2000),
(31, 1, 2, 60000),
(31, 2, 2, 70000),
(32, 5, 2, 70000),
(32, 6, 3, 120000),
(33, 5, 5, 175000),
(33, 6, 2, 80000),
(34, 1, 3, 90000),
(34, 2, 3, 105000),
(34, 3, 1, 150000),
(34, 5, 1, 35000),
(38, 1, 4, 120000),
(38, 2, 3, 105000),
(39, 5, 4, 140000),
(39, 6, 3, 120000),
(40, 1, 3, 90000),
(40, 2, 2, 70000),
(40, 3, 2, 300000),
(0, 2, 2, 70000),
(41, 5, 2, 70000),
(41, 6, 2, 80000),
(41, 8, 2, 4000),
(42, 7, 3, 45000),
(44, 1, 2, 60000),
(44, 2, 2, 70000),
(44, 3, 1, 150000),
(48, 1, 2, 60000),
(48, 2, 2, 70000),
(48, 3, 2, 300000),
(49, 1, 2, 60000),
(49, 2, 1, 35000),
(49, 3, 3, 450000),
(52, 1, 2, 60000),
(52, 2, 2, 70000),
(52, 3, 2, 300000),
(53, 1, 4, 120000),
(53, 2, 2, 70000),
(53, 3, 2, 300000),
(54, 1, 2, 60000),
(54, 2, 3, 105000),
(54, 3, 2, 300000),
(55, 5, 2, 70000),
(55, 6, 2, 80000),
(55, 8, 1, 2000),
(57, 1, 3, 90000),
(57, 2, 2, 70000),
(57, 3, 2, 300000),
(60, 5, 2, 70000),
(60, 6, 2, 80000),
(60, 8, 2, 4000),
(62, 1, 2, 60000),
(62, 2, 2, 70000),
(62, 3, 1, 150000),
(65, 1, 2, 60000),
(65, 7, 1, 15000),
(65, 3, 4, 600000),
(64, 3, 1, 150000),
(68, 1, 2, 60000),
(68, 2, 2, 70000),
(68, 3, 1, 150000),
(68, 7, 1, 15000),
(69, 1, 3, 90000),
(69, 2, 5, 175000),
(69, 3, 1, 150000),
(22, 6, 3, 120000),
(22, 8, 1, 2000),
(22, 7, 1, 15000),
(20, 1, 2, 60000),
(20, 2, 5, 175000),
(20, 7, 3, 45000),
(70, 2, 3, 105000),
(27, 3, 3, 450000),
(27, 5, 15, 525000),
(72, 8, 3, 6000),
(72, 7, 2, 30000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `vegetable`
--

CREATE TABLE `vegetable` (
  `VegetableID` int(11) NOT NULL,
  `CatagoryID` int(10) NOT NULL,
  `Vegetable_Name` varchar(50) DEFAULT NULL,
  `Unit` varchar(20) NOT NULL,
  `Amount` int(10) NOT NULL,
  `Image` varchar(50) NOT NULL,
  `Price` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Đang đổ dữ liệu cho bảng `vegetable`
--

INSERT INTO `vegetable` (`VegetableID`, `CatagoryID`, `Vegetable_Name`, `Unit`, `Amount`, `Image`, `Price`) VALUES
(1, 1, 'Tomato', 'kg', 10, 'images/tomato.jpg', 30000),
(2, 1, 'potato', 'kg', 150, 'images/potato.jpg', 35000),
(3, 1, 'Apple', 'bag', 50, 'images/apple.jpg', 150000),
(4, 1, 'melon', 'per', 45, 'rser', 454545),
(5, 2, ' broccolieeeeeeee', 'kg', 50, 'images/broccoli.jpg', 35000),
(6, 2, 'celery', 'kg', 80, 'images/celery.jpg', 40000),
(7, 3, ' spring onion', 'bunch', 50, 'images/springonion.jpg', 15000),
(8, 2, 'Melon', 'kg', 30, 'images/melon.jpg', 2000),
(14, 1, 'sjdfsdjk', 'g', 45777, 'images/melon.jpg', 45378);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`CatagoryID`);

--
-- Chỉ mục cho bảng `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`);

--
-- Chỉ mục cho bảng `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`OrderID`),
  ADD KEY `CustomerID` (`CustomerID`);

--
-- Chỉ mục cho bảng `orderdetail`
--
ALTER TABLE `orderdetail`
  ADD KEY `OrderID` (`OrderID`),
  ADD KEY `VegetableID` (`VegetableID`);

--
-- Chỉ mục cho bảng `vegetable`
--
ALTER TABLE `vegetable`
  ADD PRIMARY KEY (`VegetableID`),
  ADD KEY `CatagoryID` (`CatagoryID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT cho bảng `vegetable`
--
ALTER TABLE `vegetable`
  MODIFY `VegetableID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
