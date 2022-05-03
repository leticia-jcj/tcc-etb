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

CREATE TABLE `cliente` (
  `idCliente` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nome` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `cpf` varchar(11) COLLATE 'utf8_danish_ci' NOT NULL,
  `endereco` varchar(256) COLLATE 'utf8_danish_ci' NOT NULL,
  `email` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `telefone` varchar(11) COLLATE 'utf8_danish_ci' NOT NULL,
  `status` int NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

CREATE TABLE `orcamento` (
  `idOrcamento` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idCliente` int(11) NOT NULL,
  `dataOrcamento` date NOT NULL,
  `status` int NOT NULL,
  FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`)
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

CREATE TABLE `item_orcamento` (
  `idOrcamento` int(11) NOT NULL,
  `idProduto` int(11) NOT NULL,
  `quantidade` int NOT NULL,
  FOREIGN KEY (`idOrcamento`) REFERENCES `orcamento` (`idOrcamento`),
  FOREIGN KEY (`idProduto`) REFERENCES `produto` (`idProduto`)
) ENGINE='InnoDB' COLLATE 'utf8mb4_danish_ci';

CREATE TABLE `perfil` (
  `idPerfil` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nome` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `dataCadastro` date NOT NULL,
  `status` int NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

CREATE TABLE `usuario` (
  `idUsuario` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idPerfil` int(11) NOT NULL,
  `nome` varchar(45) COLLATE 'utf8_danish_ci' NOT NULL,
  `login` varchar(50) COLLATE 'utf8_danish_ci' NOT NULL,
  `senha` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `status` int NOT NULL,
  FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`)
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

CREATE TABLE `venda` (
  `idVenda` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `idCliente` int(11) NOT NULL,
  `idOrcamento` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `status` int NOT NULL,
  FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`),
  FOREIGN KEY (`idOrcamento`) REFERENCES `orcamento` (`idOrcamento`),
  FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`)
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

CREATE TABLE `menu` (
  `idMenu` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nome` varchar(128) COLLATE 'utf8_danish_ci' NOT NULL,
  `link` varchar(256) COLLATE 'utf8_danish_ci' NOT NULL,
  `icone` varchar(256) COLLATE 'utf8_danish_ci' NULL,
  `status` int NOT NULL
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

CREATE TABLE `menu_perfil` (
  `idMenu` int(11) NOT NULL,
  `idPerfil` int(11) NOT NULL,
  FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`),
  FOREIGN KEY (`idPerfil`) REFERENCES `perfil` (`idPerfil`)
) ENGINE='InnoDB' COLLATE 'utf8_danish_ci';

ALTER TABLE `produto`
ADD `estoque` int(11) NOT NULL AFTER `quantidade`;

ALTER TABLE `produto`
DROP `quantidade`;

USE `idealvans`;


