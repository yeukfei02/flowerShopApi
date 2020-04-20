
create table shop (
  shopId serial primary key,
  shopName varchar(255) not null,
  phone varchar(255) not null,
  createdBy timestamp not null default CURRENT_TIMESTAMP,
  updatedBy timestamp not null default CURRENT_TIMESTAMP
);

create table flower (
  flowerId serial primary key,
  flowerName varchar(255) not null,
  color varchar(255) not null,
  flowerType varchar(255) not null,
  price decimal(10, 2) not null,
  occasion varchar(255) not null,
  shopId int not null references shop (shopId),
  createdBy timestamp not null default CURRENT_TIMESTAMP,
  updatedBy timestamp not null default CURRENT_TIMESTAMP
);

--DROP TABLE flower;
--DROP TABLE shop;