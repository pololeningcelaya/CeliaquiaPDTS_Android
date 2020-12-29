package ar.edu.mdp.fi.celiaquia.screens.listasderecetas

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.edu.mdp.fi.celiaquia.database.RecetasDatabase
import ar.edu.mdp.fi.celiaquia.model.Receta
import ar.edu.mdp.fi.celiaquia.repository.RecetasRepository

class ListaDeRecetasViewModel(
    private val database: RecetasDatabase,
    val application: Application
) : ViewModel() {

    private val repository: RecetasRepository = RecetasRepository(database)
    val list : LiveData<List<Receta>> = repository.recetas

    private val _navigateToRecetaDetail = MutableLiveData<Long>()

    val navigateToRecetaDetail: LiveData<Long>
        get() = _navigateToRecetaDetail

    fun onRecetaClicked(recetaId: Long) {
        _navigateToRecetaDetail.value = recetaId
    }

    fun onRecetaDetailNavigated() {
        _navigateToRecetaDetail.value = null
    }

}