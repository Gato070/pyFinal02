package com.curso.android.app.practica.pyfinal02.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.pyfinal02.model.PracticaModel

class PracticaViewModel: ViewModel() {

    val practicaModel: LiveData<PracticaModel?> get() = _practicaModel
    private var _practicaModel = MutableLiveData<PracticaModel>(
        PracticaModel(
            textoUno = "",
            textoDos = "",
            textoResultadoFin = ""))

    fun compararTexto(textoUno: String, textoDos: String) {

        val resultado = if (textoUno == textoDos) {
            "Los textos son iguales"
        } else {
            "Los textos son diferentes"
        }

        val updatedModel = _practicaModel.value?.copy(textoResultadoFin = resultado)
        _practicaModel.value = updatedModel!!

    }

    fun limpiar() {

        val copiaModelo = _practicaModel.value
        val actualizarModelo = copiaModelo?.copy(
            textoUno = "", textoDos = "", textoResultadoFin = "")
        _practicaModel.value = actualizarModelo!!

    }
}


