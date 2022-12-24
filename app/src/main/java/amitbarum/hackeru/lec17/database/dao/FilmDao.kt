package amitbarum.hackeru.lec17.database.dao

import amitbarum.hackeru.lec17.models.*
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface FilmDao {
    @Insert
    suspend fun add(film: Film)

    @Insert
    suspend fun add(reviews: Reviews)

    @Query("SELECT * FROM Film")
    fun getFilms(): LiveData<List<Film>>

    @Query("SELECT * FROM Reviews")
    fun getReviews():LiveData<List<Reviews>>

    @Transaction
    @Query("SELECT * FROM Film")
    fun getFilmWithReviews(): LiveData<List<FilmWithReviews>>

    @Insert
    suspend fun add(genre:FGenre)

    @Insert
    suspend fun add(genreCrossRef: FilmGenreCrossRef)

    @Transaction
    @Query("SELECT * FROM Film")
    fun getFilmsWithGenres(): LiveData<List<FilmsWithGenres>>

}