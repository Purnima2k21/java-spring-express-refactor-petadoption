DROP TABLE IF EXISTS pet_types;

CREATE TABLE pet_types (
  id SERIAL PRIMARY KEY,
  type VARCHAR (255) NOT NULL,
  img_url VARCHAR (500) NOT NULL,
  description TEXT
);
 INSERT INTO pet_types (type, img_url, description) VALUES ('Dogs', 'https://static01.nyt.com/images/2019/06/17/science/17DOGS/17DOGS-mobileMasterAt3x-v2.jpg', 'Dogs are humans best friends');

 INSERT INTO pet_types (type, img_url, description) VALUES ('Cats', 'https://i.natgeofe.com/n/f0dccaca-174b-48a5-b944-9bcddf913645/01-cat-questions-nationalgeographic_1228126.jpg', 'Cats are cute and cozy');

