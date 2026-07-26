-- NutriCI - Script de création de la base de données
-- MySQL / MariaDB (XAMPP)

CREATE DATABASE IF NOT EXISTS nutrici
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_unicode_ci;

USE nutrici;

CREATE TABLE IF NOT EXISTS produit (
    reference VARCHAR(6) NOT NULL,
    nom VARCHAR(100) NOT NULL,
    categorie VARCHAR(50) NOT NULL,
    prix_unitaire DOUBLE NOT NULL,
    qte_stock INT NOT NULL,
    PRIMARY KEY (reference)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Catalogue de démonstration : 40 produits
INSERT INTO produit (reference, nom, categorie, prix_unitaire, qte_stock)
VALUES
    ('VIT001', 'Vitamine C', 'Vitamines', 5000, 20),
    ('VIT002', 'Vitamine D3', 'Vitamines', 7500, 18),
    ('VIT003', 'Vitamine B12', 'Vitamines', 6800, 14),
    ('VIT004', 'Complexe Vitamines B', 'Vitamines', 9000, 11),
    ('VIT005', 'Multivitamines Adultes', 'Vitamines', 12000, 25),
    ('VIT006', 'Vitamine E', 'Vitamines', 7200, 8),
    ('OME001', 'Oméga 3', 'Acides gras', 8500, 12),
    ('OME002', 'Huile de Poisson Premium', 'Acides gras', 11000, 16),
    ('OME003', 'Oméga 3-6-9', 'Acides gras', 12500, 9),
    ('OME004', 'Huile de Krill', 'Acides gras', 15000, 7),
    ('MAG001', 'Magnésium', 'Minéraux', 6500, 4)
    ,('MIN001', 'Zinc', 'Minéraux', 4800, 20)
    ,('MIN002', 'Calcium Marin', 'Minéraux', 7000, 13)
    ,('MIN003', 'Fer Bisglycinate', 'Minéraux', 6200, 6)
    ,('MIN004', 'Sélénium', 'Minéraux', 5500, 10)
    ,('MIN005', 'Potassium', 'Minéraux', 5800, 15)
    ,('PRO001', 'Whey Protéine Vanille', 'Protéines', 22000, 18)
    ,('PRO002', 'Whey Protéine Chocolat', 'Protéines', 22000, 17)
    ,('PRO003', 'Protéine Végétale', 'Protéines', 19500, 12)
    ,('PRO004', 'Collagène Marin', 'Protéines', 17500, 14)
    ,('PRO005', 'Acides Aminés BCAA', 'Protéines', 14500, 9)
    ,('PLA001', 'Spiruline Bio', 'Plantes', 8000, 24)
    ,('PLA002', 'Moringa Bio', 'Plantes', 6500, 30)
    ,('PLA003', 'Ginseng Rouge', 'Plantes', 10500, 8)
    ,('PLA004', 'Curcuma et Pipérine', 'Plantes', 7800, 19)
    ,('PLA005', 'Thé Vert Extrait', 'Plantes', 7000, 15)
    ,('PLA006', 'Ashwagandha', 'Plantes', 9500, 11)
    ,('DIG001', 'Probiotiques 10 Souches', 'Digestion', 13000, 13)
    ,('DIG002', 'Fibres de Psyllium', 'Digestion', 7500, 21)
    ,('DIG003', 'Enzymes Digestives', 'Digestion', 10000, 8)
    ,('ENE001', 'Coenzyme Q10', 'Énergie', 13500, 10)
    ,('ENE002', 'Guarana Naturel', 'Énergie', 6500, 16)
    ,('ENE003', 'L-Carnitine', 'Énergie', 12000, 12)
    ,('SOM001', 'Mélatonine', 'Sommeil', 6000, 20)
    ,('SOM002', 'Valériane et Passiflore', 'Sommeil', 7800, 14)
    ,('IMM001', 'Échinacée', 'Immunité', 7000, 17)
    ,('IMM002', 'Propolis Royale', 'Immunité', 8500, 13)
    ,('BEA001', 'Biotine Cheveux et Ongles', 'Beauté', 9000, 18)
    ,('BEA002', 'Acide Hyaluronique', 'Beauté', 14000, 7)
    ,('BEA003', 'Collagène Beauté', 'Beauté', 16000, 10)
ON DUPLICATE KEY UPDATE
    nom = VALUES(nom),
    categorie = VALUES(categorie),
    prix_unitaire = VALUES(prix_unitaire),
    qte_stock = VALUES(qte_stock);
