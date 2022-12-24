package amitbarum.hackeru.lec17.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
@Entity
data class Reviews(
    val text:String,

    //each review must belong to a movie
    val reviewFilmId:String,

    @PrimaryKey
    val reviewId:String = UUID.randomUUID().toString()
)