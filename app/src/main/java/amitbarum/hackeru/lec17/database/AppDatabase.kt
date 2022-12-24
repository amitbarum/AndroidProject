package amitbarum.hackeru.lec17.database

import amitbarum.hackeru.lec17.database.dao.FilmDao
import amitbarum.hackeru.lec17.database.dao.PeopleDao
import amitbarum.hackeru.lec17.models.*
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

const val DB_NAME = "AppDatabase"
const val DB_VERSION = 1

@Database(entities = [Person::class,Dog::class,Film::class,Reviews::class,FGenre::class,FilmGenreCrossRef::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    //expose the dao's:

    abstract fun peopleDao(): PeopleDao
    abstract fun filmDao():FilmDao

    companion object {
        fun create(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME)
                 //if a new version of the app is installed AND db structure was upgraded => delete the db and re-create it
                .fallbackToDestructiveMigration()
                .build()

    }
}
