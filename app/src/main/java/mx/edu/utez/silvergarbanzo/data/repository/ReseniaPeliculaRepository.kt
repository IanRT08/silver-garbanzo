package mx.edu.utez.silvergarbanzo.data.repository

import kotlinx.coroutines.flow.Flow
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPelicula
import mx.edu.utez.silvergarbanzo.data.model.ReseniaPeliculaDao

class ReseniaPeliculaRepository(private val reseniaPeliculaDao: ReseniaPeliculaDao) {
    val allResenias: Flow<List<ReseniaPelicula>> = reseniaPeliculaDao.getAllResenias()

    suspend fun insertResenia(resenia: ReseniaPelicula){
        reseniaPeliculaDao.insertResenia(resenia)
    }
    suspend fun updateResenia(resenia: ReseniaPelicula) {
        reseniaPeliculaDao.updateResenia(resenia)
    }
    suspend fun deleteResenia(resenia: ReseniaPelicula) {
        reseniaPeliculaDao.deleteResenia(resenia)
    }

    suspend fun getReseniaById(id: Int): ReseniaPelicula? {
        return reseniaPeliculaDao.getReseniaById(id)
    }

}