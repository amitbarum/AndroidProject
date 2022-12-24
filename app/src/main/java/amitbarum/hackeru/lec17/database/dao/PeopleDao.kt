package amitbarum.hackeru.lec17.database.dao

import amitbarum.hackeru.lec17.models.Person
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PeopleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(person: Person)

    @Query("SELECT * FROM people")
    fun getAll():LiveData<List<Person>>
}