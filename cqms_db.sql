-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 01, 2023 at 07:53 PM
-- Server version: 8.0.29
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cqms_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `advisors_tbl`
--

CREATE TABLE `advisors_tbl` (
  `id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `advisors_tbl_entries_ref`
--

CREATE TABLE `advisors_tbl_entries_ref` (
  `Advisor_id` varchar(255) NOT NULL,
  `entriesAssigned_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `entries_ref`
--

CREATE TABLE `entries_ref` (
  `id` int NOT NULL,
  `response` varchar(255) DEFAULT NULL,
  `response_date` date DEFAULT NULL,
  `advisorId_id` varchar(255) DEFAULT NULL,
  `entryNo_entry_no` int DEFAULT NULL,
  `supervisorId_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `entries_tbl`
--

CREATE TABLE `entries_tbl` (
  `entry_no` int NOT NULL,
  `category` varchar(255) NOT NULL,
  `details` varchar(255) NOT NULL,
  `request_date` date NOT NULL,
  `status` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `studentId_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `entries_tbl`
--

INSERT INTO `entries_tbl` (`entry_no`, `category`, `details`, `request_date`, `status`, `type`, `studentId_id`) VALUES
(1, 'Progress Report', 'Where is my Progress report?', '2023-03-30', 'UNRESOLVED', 'QUERY', '10002'),
(2, 'Progress Report', 'Enter Your Query or Complaint', '2023-03-30', 'UNRESOLVED', 'QUERY', '10002'),
(3, 'Progress Report', 'skdfkdkdkdkdkdkd', '2023-03-31', 'UNRESOLVED', 'QUERY', '10002'),
(4, 'Progress Report', '', '2023-03-31', 'UNRESOLVED', 'QUERY', '10002');

-- --------------------------------------------------------

--
-- Table structure for table `students_tbl`
--

CREATE TABLE `students_tbl` (
  `contact` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `students_tbl`
--

INSERT INTO `students_tbl` (`contact`, `email`, `id`) VALUES
('422-3432', 'pc@gmail.com', '10002');

-- --------------------------------------------------------

--
-- Table structure for table `students_tbl_entries_tbl`
--

CREATE TABLE `students_tbl_entries_tbl` (
  `Student_id` varchar(255) NOT NULL,
  `entriesLogged_entry_no` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supervisors_tbl`
--

CREATE TABLE `supervisors_tbl` (
  `id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supervisors_tbl_entries_ref`
--

CREATE TABLE `supervisors_tbl_entries_ref` (
  `Supervisor_id` varchar(255) NOT NULL,
  `entries_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `users_tbl`
--

CREATE TABLE `users_tbl` (
  `id` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userRole` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_tbl`
--

INSERT INTO `users_tbl` (`id`, `first_name`, `last_name`, `password`, `userRole`) VALUES
('10002', 'Carl', 'Peterson', 'cat', 'STUDENT');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `advisors_tbl`
--
ALTER TABLE `advisors_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `advisors_tbl_entries_ref`
--
ALTER TABLE `advisors_tbl_entries_ref`
  ADD UNIQUE KEY `UK_tsqbi2mws8rvh58pjx8ptjlu` (`entriesAssigned_id`),
  ADD KEY `FKssm5145gc2cqht04sowe56hd5` (`Advisor_id`);

--
-- Indexes for table `entries_ref`
--
ALTER TABLE `entries_ref`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK80m71qmg3fe1nki89rrk45bb5` (`advisorId_id`),
  ADD KEY `FK5ekp8aduqpk8gr0bo2yxo2k7w` (`entryNo_entry_no`),
  ADD KEY `FKgseycfayqob4r9fkwotpot4a8` (`supervisorId_id`);

--
-- Indexes for table `entries_tbl`
--
ALTER TABLE `entries_tbl`
  ADD PRIMARY KEY (`entry_no`),
  ADD KEY `FKt4u8dr6owo3ylqm6uqn3sfjxr` (`studentId_id`);

--
-- Indexes for table `students_tbl`
--
ALTER TABLE `students_tbl`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ei6t3qhfupeehvh0cijbgm28h` (`email`),
  ADD UNIQUE KEY `UK_l9tlo1sfose6rv6cfal2bealu` (`contact`);

--
-- Indexes for table `students_tbl_entries_tbl`
--
ALTER TABLE `students_tbl_entries_tbl`
  ADD UNIQUE KEY `UK_gdseuspw5387jqwbb6sbsx7sv` (`entriesLogged_entry_no`),
  ADD KEY `FKfxrhosvdjl3hvcr2yqjv4hi5r` (`Student_id`);

--
-- Indexes for table `supervisors_tbl`
--
ALTER TABLE `supervisors_tbl`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `supervisors_tbl_entries_ref`
--
ALTER TABLE `supervisors_tbl_entries_ref`
  ADD UNIQUE KEY `UK_r8vkhdijur24llb86q2e6j9rj` (`entries_id`),
  ADD KEY `FK96xis3ghuhdk4bpg4lbrr9han` (`Supervisor_id`);

--
-- Indexes for table `users_tbl`
--
ALTER TABLE `users_tbl`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `entries_ref`
--
ALTER TABLE `entries_ref`
  MODIFY `id` int NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `entries_tbl`
--
ALTER TABLE `entries_tbl`
  MODIFY `entry_no` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `advisors_tbl`
--
ALTER TABLE `advisors_tbl`
  ADD CONSTRAINT `FKqnpribhf3fg0jt0neim8y5v1t` FOREIGN KEY (`id`) REFERENCES `users_tbl` (`id`);

--
-- Constraints for table `advisors_tbl_entries_ref`
--
ALTER TABLE `advisors_tbl_entries_ref`
  ADD CONSTRAINT `FKd3ltyqvh70mxqbh59xmpioekf` FOREIGN KEY (`entriesAssigned_id`) REFERENCES `entries_ref` (`id`),
  ADD CONSTRAINT `FKssm5145gc2cqht04sowe56hd5` FOREIGN KEY (`Advisor_id`) REFERENCES `advisors_tbl` (`id`);

--
-- Constraints for table `entries_ref`
--
ALTER TABLE `entries_ref`
  ADD CONSTRAINT `FK5ekp8aduqpk8gr0bo2yxo2k7w` FOREIGN KEY (`entryNo_entry_no`) REFERENCES `entries_tbl` (`entry_no`),
  ADD CONSTRAINT `FK80m71qmg3fe1nki89rrk45bb5` FOREIGN KEY (`advisorId_id`) REFERENCES `advisors_tbl` (`id`),
  ADD CONSTRAINT `FKgseycfayqob4r9fkwotpot4a8` FOREIGN KEY (`supervisorId_id`) REFERENCES `supervisors_tbl` (`id`);

--
-- Constraints for table `entries_tbl`
--
ALTER TABLE `entries_tbl`
  ADD CONSTRAINT `FKt4u8dr6owo3ylqm6uqn3sfjxr` FOREIGN KEY (`studentId_id`) REFERENCES `students_tbl` (`id`);

--
-- Constraints for table `students_tbl`
--
ALTER TABLE `students_tbl`
  ADD CONSTRAINT `FK9oyu60a247wboig217caepopb` FOREIGN KEY (`id`) REFERENCES `users_tbl` (`id`);

--
-- Constraints for table `students_tbl_entries_tbl`
--
ALTER TABLE `students_tbl_entries_tbl`
  ADD CONSTRAINT `FKcakn73sq0r39x8mihfneetth4` FOREIGN KEY (`entriesLogged_entry_no`) REFERENCES `entries_tbl` (`entry_no`),
  ADD CONSTRAINT `FKfxrhosvdjl3hvcr2yqjv4hi5r` FOREIGN KEY (`Student_id`) REFERENCES `students_tbl` (`id`);

--
-- Constraints for table `supervisors_tbl`
--
ALTER TABLE `supervisors_tbl`
  ADD CONSTRAINT `FKfsic23r6vqg7hd72ac25vhpeu` FOREIGN KEY (`id`) REFERENCES `users_tbl` (`id`);

--
-- Constraints for table `supervisors_tbl_entries_ref`
--
ALTER TABLE `supervisors_tbl_entries_ref`
  ADD CONSTRAINT `FK96xis3ghuhdk4bpg4lbrr9han` FOREIGN KEY (`Supervisor_id`) REFERENCES `supervisors_tbl` (`id`),
  ADD CONSTRAINT `FKqcsi59ukbp7pufeaef3bou4wb` FOREIGN KEY (`entries_id`) REFERENCES `entries_ref` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
