package mx.edu.utez.silvergarbanzo.data.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ReseniaPelicula::class], version = 1)
abstract class VetDatabase : RoomDatabase() {
    abstract fun reseniaPeliculaDao(): ReseniaPeliculaDao
}