package ar.edu.mdp.fi.celiaquia.recetadetail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.modelo.Receta
import ar.edu.mdp.fi.celiaquia.repository.RecetasRepository

class RecetaDetailViewModel(
    private val recetaId: Long,
    private val database: RecetasDatabase,
    private val application: Application
):  ViewModel() {

    private val repository: RecetasRepository = RecetasRepository(database)

    val receta: LiveData<Receta> = repository.getReceta(recetaId)
}