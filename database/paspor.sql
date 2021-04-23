-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 16 Mar 2021 pada 13.59
-- Versi server: 10.1.39-MariaDB
-- Versi PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `paspor`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `datacostumer`
--

CREATE TABLE `datacostumer` (
  `NamaLengkap` varchar(100) NOT NULL,
  `Username` varchar(100) NOT NULL,
  `admin` varchar(10) NOT NULL DEFAULT 'non',
  `gender` varchar(10) NOT NULL,
  `password` varchar(100) NOT NULL,
  `noTelp` varchar(12) NOT NULL,
  `date` date NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `NIK` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `datacostumer`
--

INSERT INTO `datacostumer` (`NamaLengkap`, `Username`, `admin`, `gender`, `password`, `noTelp`, `date`, `Alamat`, `NIK`) VALUES
('', 'admin', 'yes', '', 'admin', '', '0000-00-00', '', ''),
('michael septian', 'septi123', 'non', 'Male', '123', '0812421421', '2000-09-15', 'tki 1 i 34', '1245234543645623'),
('michael hieronimus', 'sep', 'non', 'male', '123', '082112345678', '2000-09-15', 'Taman Kopo Indah blok i -87', '32000123456789'),
('Francicus', 'icus', 'non', 'Female', '333', '0812314234', '2019-11-01', 'kopo', '32090901239312'),
('yeremia joy', 'joy', 'non', 'Male', '111', '08123352353', '2000-01-04', 'sukammenak', '32124431513421'),
('bokir indo', 'bokir@gmail.co.id', 'non', 'Female', '1111', '08123124121', '2000-06-01', 'dipatiukur no 25', '329044927432'),
('candra', 'candra', 'non', 'Female', '123', '012022139312', '2020-01-30', 'tki', '42131232412412'),
('Reynold Yehezkiel', 'reynyan', 'non', 'male', 'blabla', '085959100514', '2000-05-25', 'Jl. Bukit Resik No.9A', '871492384574'),
('Ryuga Eka', 'ryu234', 'non', 'male', 'ryu', '0819425', '2019-11-12', 'Dimana aja', '8976546578798');

-- --------------------------------------------------------

--
-- Struktur dari tabel `formpermohonan`
--

CREATE TABLE `formpermohonan` (
  `NamaKantor` varchar(100) NOT NULL,
  `Alamat` varchar(100) NOT NULL,
  `tglKedatangan` varchar(100) NOT NULL,
  `waktuKedatangan` varchar(100) NOT NULL,
  `kodeBooking` varchar(100) NOT NULL,
  `NIK` varchar(100) NOT NULL,
  `namaLengkap` varchar(100) NOT NULL,
  `noTelp` varchar(100) NOT NULL,
  `status` int(10) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `formpermohonan`
--

INSERT INTO `formpermohonan` (`NamaKantor`, `Alamat`, `tglKedatangan`, `waktuKedatangan`, `kodeBooking`, `NIK`, `namaLengkap`, `noTelp`, `status`) VALUES
('Imigrasi Ciamis', '', '2019-11-28', 'Siang (13:00 - 16:00)', 'EG-1LO8YQ', '32090901239312', 'Francicus', '0812314234', 1),
('ULP Bandung', 'Sekeloa No.5', '2020-01-30', 'Siang (13:00 - 16:00)', 'FK-3LB8CG', '42131232412412', 'candra', '012022139312', 0),
('Kantor Imigrasi Bandung', 'Dipatiukur no 15', '2019-11-20', 'Siang (13:00 - 16:00)', 'FV-4BL1VY', '8976546578798', 'Ryuga Eka', '0819425', 1),
('Kantor Imigrasi Bandung', 'Dipatiukur no 15', '2019-11-22', 'Siang (13:00 - 16:00)', 'HH-0FT3KM', '32000123456789', 'michael hieronimus', '082112345678', 0),
('Imigrasi Ciamis', '', '2019-11-30', 'Pagi (08:00 - 12:00)', 'SX-7FK5OA', '32124431513421', 'yeremia joy', '08123352353', 1),
('Imigrasi Ciamis', '', '2020-03-02', 'Siang (13:00 - 16:00)', 'WK-4HY7OY', '32000123456789', 'michael hieronimus', '082112345678', 1),
('ULP Bandung', 'Sekeloa No.5', '2021-03-19', 'Siang (13:00 - 16:00)', 'YU-6TB5ZF', '1245234543645623', 'michael septian', '0812421421', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `kuota`
--

CREATE TABLE `kuota` (
  `idkuota` int(11) NOT NULL,
  `tanggal` varchar(100) NOT NULL,
  `month` varchar(10) NOT NULL,
  `nik` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kuota`
--

INSERT INTO `kuota` (`idkuota`, `tanggal`, `month`, `nik`) VALUES
(8, '2020-03-02', '03', '32000123456789'),
(9, '2019-11-28', '11', '32090901239312'),
(10, '2019-11-22', '11', '32000123456789'),
(11, '2019-11-20', '11', '8976546578798'),
(12, '2019-11-30', '11', '32124431513421'),
(13, '2020-01-30', '01', '42131232412412'),
(14, '2021-03-19', '03', '1245234543645623');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kuotaperbulan`
--

CREATE TABLE `kuotaperbulan` (
  `bulan` varchar(10) NOT NULL,
  `kuota` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `kuotaperbulan`
--

INSERT INTO `kuotaperbulan` (`bulan`, `kuota`) VALUES
('11', 10),
('12', 20),
('01', 10),
('02', 20),
('03', 9),
('04', 25),
('11', 10),
('12', 20),
('01', 10),
('02', 20),
('03', 9),
('04', 25);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `datacostumer`
--
ALTER TABLE `datacostumer`
  ADD PRIMARY KEY (`NIK`);

--
-- Indeks untuk tabel `formpermohonan`
--
ALTER TABLE `formpermohonan`
  ADD PRIMARY KEY (`kodeBooking`);

--
-- Indeks untuk tabel `kuota`
--
ALTER TABLE `kuota`
  ADD PRIMARY KEY (`idkuota`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `kuota`
--
ALTER TABLE `kuota`
  MODIFY `idkuota` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
