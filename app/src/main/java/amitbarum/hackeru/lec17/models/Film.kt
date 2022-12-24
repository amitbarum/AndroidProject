package amitbarum.hackeru.lec17.models

import androidx.room.*
import java.util.UUID

@Entity
data class Film(
    val title:String,

    @PrimaryKey
    val filmId:String = UUID.randomUUID().toString()
)

//many to many
@Entity (primaryKeys =["filmId","genreId"] )
data class FilmGenreCrossRef(
    val filmId: String,
    val genreId:String,
)

data class FilmsWithGenres(
    @Embedded
    val film:String,

    @Relation(
        parentColumn = "filmId",
        entityColumn = "genreId",
        associateBy = Junction(FilmGenreCrossRef::class)
    )
    val genres:List<FGenre>
)



//one to many
//View

data class FilmWithReviews(

    @Embedded
    val film:Film,

    @Relation(
        parentColumn ="filmId",
        entityColumn = "reviewFilmId"

    )
    val reviews: List<Reviews>?
)