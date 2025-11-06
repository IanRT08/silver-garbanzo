package mx.edu.utez.silvergarbanzo.data.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ReseniaPeliculaDao {
    @Insert
    suspend fun insertResenia(resenia: ReseniaPelicula)
    @Query("SELECT * FROM resenia_pelicula ORDER BY id DESC")
    fun getAllResenias(): Flow<List<ReseniaPelicula>>
    @Query("SELECT * FROM resenia_pelicula WHERE id = :id")
    suspend fun getReseniaById(id: Int): ReseniaPelicula?
    @Update
    suspend fun updateResenia(resenia: ReseniaPelicula)
    @Delete
    suspend fun deleteResenia(resenia: ReseniaPelicula)
}