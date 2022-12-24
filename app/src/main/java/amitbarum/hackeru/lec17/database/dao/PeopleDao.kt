package amitbarum.hackeru.lec17.database.dao

import amitbarum.hackeru.lec17.models.Dog
import amitbarum.hackeru.lec17.models.Person
import amitbarum.hackeru.lec17.models.PersonWithDog
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Relation
import androidx.room.Transaction

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(person: Person)

    @Query("SELECT * FROM people")
    fun getAll():LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(dog: Dog)

    @Query("SELECT * FROM Dog")
    fun getDogs():LiveData<List<Dog>>


    //people with dogs
    @Transaction
    @Query("SELECT * FROM people")
    fun getPeopleWithDog():LiveData<List<PersonWithDog>>
}


