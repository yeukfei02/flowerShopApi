create table shop (
  shopId serial primary key,
  image text not null,
  shopName varchar(255) not null,
  phone varchar(255) not null,
  address varchar(255) not null,
  createdBy timestamp not null default CURRENT_TIMESTAMP,
  updatedBy timestamp not null default CURRENT_TIMESTAMP
);

create table flower (
  flowerId serial primary key,
  image text not null,
  flowerName varchar(255) not null,
  color varchar(255) not null,
  flowerType varchar(255) not null,
  price decimal(10, 2) not null,
  occasion varchar(255) not null,
  shopId int not null references shop (shopId),
  createdBy timestamp not null default CURRENT_TIMESTAMP,
  updatedBy timestamp not null default CURRENT_TIMESTAMP
);

CREATE INDEX index_shop_on_image ON shop(image);
CREATE INDEX index_shop_on_shopName ON shop(shopName);
CREATE INDEX index_shop_on_phone ON shop(phone);
CREATE INDEX index_shop_on_address ON shop(address);
CREATE INDEX index_shop_on_createdBy ON shop(createdBy);
CREATE INDEX index_shop_on_updatedBy ON shop(updatedBy);

CREATE INDEX index_flower_on_image ON flower(image);
CREATE INDEX index_flower_on_flowerName ON flower(flowerName);
CREATE INDEX index_flower_on_color ON flower(color);
CREATE INDEX index_flower_on_flowerType ON flower(flowerType);
CREATE INDEX index_flower_on_price ON flower(price);
CREATE INDEX index_flower_on_occasion ON flower(occasion);
CREATE INDEX index_flower_on_shopId ON flower(shopId);
CREATE INDEX index_flower_on_createdBy ON flower(createdBy);
CREATE INDEX index_flower_on_updatedBy ON flower(updatedBy);