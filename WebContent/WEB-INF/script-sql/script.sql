SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS `produto`;
DROP TABLE IF EXISTS `fornecedor`;

CREATE TABLE `fornecedor` (
  `idFornecedor` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `razaoSocial` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `nomeContato` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `email` varchar(128) COLLATE 'utf8_danish_ci' NULL,
  `telefone` varchar(11) COLLATE 'utf8_danish_ci' NOT NULL,
  `cnpj` varchar(14) COLLATE 'utf8_danish_ci' NOT NULL,
  `status` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

CREATE TABLE `produto` (
  `idProduto` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idFornecedor` int(11) NOT NULL,
  `nome` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `descricao` varchar(128) COLLATE 'utf8mb4_danish_ci' NULL,
  `quantidade` int NOT NULL,
  `precoUnitario` decimal NOT NULL,
  `status` int NOT NULL,
  FOREIGN KEY (`idFornecedor`) REFERENCES `fornecedor` (`idFornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_danish_ci;

USE `idealvans`;


