# Back-end

Back-end permettant la gestion de produits définis plus bas.

- Java/Spring Boot
- Java 21
- Maven 4

Un produit a les caractéristiques suivantes :

```typescript
class Product {
  id: number;
  code: string;
  name: string;
  description: string;
  price: number;
  quantity: number;
  inventoryStatus: string;
  category: string;
  image: string;
  rating: number;
}
```

# Server

- server.port=8081
- server.servlet.context-path=/shop

Le back-end gére les API REST suivantes :

| Resource        | POST                  | GET                            | PATCH                                    | PUT | DELETE           |
| --------------- | --------------------- | ------------------------------ | ---------------------------------------- | --- | ---------------- |
| **/products**   | Create a new products | Retrieve all products          | X                                        | X   | X                |
| **/products/1** | X                     | Retrieve details for product 1 | Update details of product 1 if it exists | X   | Remove product 1 |

# Lancement API

- Dézipper l'archive
- Ouvrir un terminal
  - Se placer dans le dossier
  - mvn -install
  - Récupérer le JAR dans le dossier target et l'éxecuter
- Ouvrir un navigateur
- se rendre à l'adresse http://localhost:8081/shop/products

# Test Postman

- https://www.postman.com/lively-api-mediatheque/workspace/api-shop-alten/folder/13698905-2c5a608f-08c7-41cf-bb49-5ef9d113ad62?ctx=documentation

# Data Source - Postgresql

- Postgresql 16
- base : altenshop
- table : product

# Configuration nécessaire pour la data Source

- Configuration du fichier application.properties ( A changer si autre BDD )
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/altenshop
spring.datasource.username=postgres
spring.datasource.password=***********************
```

- Configuration du driver dans pom.xml ( A changer si autre BDD )
```xml
<dependency>
<groupId>org.postgresql</groupId>
<artifactId>postgresql</artifactId>
<version>42.6.0</version>
</dependency>
```

# Script sql

```sql
CREATE TABLE product(
id INTEGER NOT NULL PRIMARY KEY
,code VARCHAR(9) NOT NULL
,name VARCHAR(255) NOT NULL
,description VARCHAR(255)
,image VARCHAR(255)
,price INTEGER NOT NULL
,category VARCHAR(255) NOT NULL
,quantity INTEGER NOT NULL
,status VARCHAR(255) NOT NULL
,rating INTEGER NOT NULL
);

INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1000,'f230fh0g3','Bamboo Watch','Product Description','bamboo-watch.jpg',65,'Accessories',24,'INSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1001,'nvklal433','Black Watch','Product Description','black-watch.jpg',72,'Accessories',61,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1002,'zz21cz3c1','Blue Band','Product Description','blue-band.jpg',79,'Fitness',2,'LOWSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1003,'244wgerg2','Blue T-Shirt','Product Description','blue-t-shirt.jpg',29,'Clothing',25,'INSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1004,'h456wer53','Bracelet','Product Description','bracelet.jpg',15,'Accessories',73,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1005,'av2231fwg','Brown Purse','Product Description','brown-purse.jpg',120,'Accessories',0,'OUTOFSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1006,'bib36pfvm','Chakra Bracelet','Product Description','chakra-bracelet.jpg',32,'Accessories',5,'LOWSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1007,'mbvjkgip5','Galaxy Earrings','Product Description','galaxy-earrings.jpg',34,'Accessories',23,'INSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1008,'vbb124btr','Game Controller','Product Description','game-controller.jpg',99,'Electronics',2,'LOWSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1009,'cm230f032','Gaming Set','Product Description','gaming-set.jpg',299,'Electronics',63,'INSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1010,'plb34234v','Gold Phone Case','Product Description','gold-phone-case.jpg',24,'Accessories',0,'OUTOFSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1011,'4920nnc2d','Green Earbuds','Product Description','green-earbuds.jpg',89,'Electronics',23,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1012,'250vm23cc','Green T-Shirt','Product Description','green-t-shirt.jpg',49,'Clothing',74,'INSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1013,'fldsmn31b','Grey T-Shirt','Product Description','grey-t-shirt.jpg',48,'Clothing',0,'OUTOFSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1014,'waas1x2as','Headphones','Product Description','headphones.jpg',175,'Electronics',8,'LOWSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1015,'vb34btbg5','Light Green T-Shirt','Product Description','light-green-t-shirt.jpg',49,'Clothing',34,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1016,'k8l6j58jl','Lime Band','Product Description','lime-band.jpg',79,'Fitness',12,'INSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1017,'v435nn85n','Mini Speakers','Product Description','mini-speakers.jpg',85,'Clothing',42,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1018,'09zx9c0zc','Painted Phone Case','Product Description','painted-phone-case.jpg',56,'Accessories',41,'INSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1019,'mnb5mb2m5','Pink Band','Product Description','pink-band.jpg',79,'Fitness',63,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1020,'r23fwf2w3','Pink Purse','Product Description','pink-purse.jpg',110,'Accessories',0,'OUTOFSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1021,'pxpzczo23','Purple Band','Product Description','purple-band.jpg',79,'Fitness',6,'LOWSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1022,'2c42cb5cb','Purple Gemstone Necklace','Product Description','purple-gemstone-necklace.jpg',45,'Accessories',62,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1023,'5k43kkk23','Purple T-Shirt','Product Description','purple-t-shirt.jpg',49,'Clothing',2,'LOWSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1024,'lm2tny2k4','Shoes','Product Description','shoes.jpg',64,'Clothing',0,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1025,'nbm5mv45n','Sneakers','Product Description','sneakers.jpg',78,'Clothing',52,'INSTOCK',4);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1026,'zx23zc42c','Teal T-Shirt','Product Description','teal-t-shirt.jpg',49,'Clothing',3,'LOWSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1027,'acvx872gc','Yellow Earbuds','Product Description','yellow-earbuds.jpg',89,'Electronics',35,'INSTOCK',3);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1028,'tx125ck42','Yoga Mat','Product Description','yoga-mat.jpg',20,'Fitness',15,'INSTOCK',5);
INSERT INTO product(id,code,name,description,image,price,category,quantity,status,rating) VALUES (1029,'gwuby345v','Yoga Set','Product Description','yoga-set.jpg',20,'Fitness',25,'INSTOCK',8);
```
