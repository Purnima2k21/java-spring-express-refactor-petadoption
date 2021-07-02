import pg from "pg"

const pool = new pg.Pool({
  connectionString: "postgres://postgres:password@localhost:5432/adopt_a_pet"
})

class Seeder {
  static async seed() {
    try {
      await pool.query(
        "INSERT INTO pet_types (type, img_url, description) VALUES ('Dogs', 'https://static01.nyt.com/images/2019/06/17/science/17DOGS/17DOGS-mobileMasterAt3x-v2.jpg', 'Dogs are humans best friends');"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Toby', 'https://thumbs-prod.si-cdn.com/X3peG9bDdVCwk4EiZClKtzDA3qg=/1072x720/filters:no_upscale():focal(2135x711:2136x712)/https://public-media.si-cdn.com/filer/77/8b/778bb007-831c-4c81-a475-05487cd7b53b/adult-brown-labrador-retriever-1010121_3.jpg', 3, true, 'Toby is a friendly dog who is seeking for his new home. He loves belly rubs and cuddling.', 'Not Adopted', 1);"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Yeti', 'https://www.yourpurebredpuppy.com/dogbreeds/photos-EFGH/goldenretrieversf1.jpg', 5, true, 'Yeti is a cute dog who loves playing with kids. Please take him home and make your kids happy.', 'Waiting', 1);"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Shadow', 'https://highlandcanine.com/wp-content/uploads/2020/12/iStock-926735822.jpg', 4, true, 'Shadow is a happy dog. He loves to protect his human family and eagerly waiting to have one.', 'Waiting', 1);"
      )
      await pool.query(
        "INSERT INTO adoptable_pets (name, img_url, age, vaccination_status, adoption_story, adoption_status, type_id ) VALUES ('Lola', 'https://i.redd.it/l0692dkqktj01.jpg', 2, true, 'Lola is a rescue dog. She loves to sit in the couch and nap.', 'Not Adopted', 1);"
      )

      pool.end()
    } catch (error) {
      console.error(error)
      pool.end()
    }
  }
}

export default Seeder
