-- WHERE : row 
SELECT * 
FROM Customers 
WHERE Country="Mexico";

SELECT *
FROM Customers
WHERE CustomerID = 1;

SELECT * FROM Products
WHERE Price = 18;

SELECT * FROM Products
WHERE Price > 30;

SELECT * FROM Products
WHERE Price < 30;

SELECT * FROM Products
WHERE Price >= 30;

SELECT * FROM Products
WHERE Price <= 30;

SELECT * FROM Products
WHERE Price <> 30;

SELECT * FROM Products
WHERE Price != 30;

SELECT * FROM Products
WHERE Price BETWEEN 53 AND 55;

SELECT * FROM Customers
WHERE City LIKE 's%' ;

SELECT * FROM Customers
WHERE City LIKE '%g';

SELECT * FROM Customers
WHERE City LIKE '%z%';

SELECT * FROM Customers
WHERE Country LIKE '%us%';

SELECT * FROM Customers
WHERE City In ('Paris','London','Berlin');

SELECT * FROM Customers
WHERE City != 'Berlin';

SELECT * FROM Customers
WHERE NOT City = 'Berlin';

SELECT * FROM Customers
WHERE Country = 'Germany' AND City = 'Berlin';

SELECT * FROM Customers
WHERE City = 'Berlin' OR City = 'Munchen';

SELECT * FROM Customers
WHERE Country = 'Germany' OR (CustomerName LIKE '%s%' AND City LIKE '%ch%');

SELECT * FROM Customers
WHERE Country ="Germany" AND (City='Berlin' OR City='Munchen');

SELECT * FROM Customers
WHERE NOT Country='Germany' AND NOT Country='USA';

SELECT
* FROM Customers
WHERE 
City = 'Berlin'
AND
PostalCode
= 12209;

SELECT
*FROM Customers
WHERE
	City = 'Berlin' OR City = 'London';