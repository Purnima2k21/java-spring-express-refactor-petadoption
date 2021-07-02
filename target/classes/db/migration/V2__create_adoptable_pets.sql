DROP TABLE IF EXISTS adoptable_pets CASCADE;
CREATE TABLE adoptable_pets (
  id SERIAL PRIMARY KEY,
  name VARCHAR (255) NOT NULL,
  img_url VARCHAR (500) NOT NULL,
  age INTEGER,
  vaccination_status BOOLEAN,
  adoption_story TEXT NOT NULL,
  adoption_status VARCHAR (255) NOT NULL,
  type_id INTEGER REFERENCES pet_types(id)
);
INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Toby', 'https://thumbs-prod.si-cdn.com/X3peG9bDdVCwk4EiZClKtzDA3qg=/1072x720/filters:no_upscale():focal(2135x711:2136x712)/https://public-media.si-cdn.com/filer/77/8b/778bb007-831c-4c81-a475-05487cd7b53b/adult-brown-labrador-retriever-1010121_3.jpg', 3, true, 'Toby is a friendly dog who is seeking for his new home. He loves belly rubs and cuddling.', 'Not Adopted', 1);
INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Yeti', 'https://www.yourpurebredpuppy.com/dogbreeds/photos-EFGH/goldenretrieversf1.jpg', 5, true, 'Yeti is a cute dog who loves playing with kids. Please take him home and make your kids happy.', 'Waiting', 1);
INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Shadow', 'https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg', 4, true, 'Shadow is a happy dog. He loves to protect his human family and eagerly waiting to have one.', 'Waiting', 1);
INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Lola', 'https://i.redd.it/l0692dkqktj01.jpg', 2, true, 'Lola is a rescue dog. She loves to sit in the couch and nap.', 'Not Adopted', 1);

INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Lily', 'https://cdn.mos.cms.futurecdn.net/otjbibjaAbiifyN9uVaZyL.jpg', 1 , true, 'Lily is a cutie pie who loves to sleep on a fuzzy cushion', 'Not Adopted', 2);
INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Abbey', 'https://public-media.si-cdn.com/filer/a0/15/a015251a-6a1d-449c-bf13-8c1c129c4cc5/egypt_kitty_mobile.jpg', 3 , true, 'Abbey loves to show her tongue and dress up.', 'Pending', 2);
INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Sam', 'https://c.files.bbci.co.uk/12A9B/production/_111434467_gettyimages-1143489763.jpg', 2 , true, 'Sam is a sweet guy and in love with the couch.', 'Not Adopted', 2);