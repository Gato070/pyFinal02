package com.curso.android.app.practica.pyfinal02

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.practica.pyfinal02.view.PracticaViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class ComenzaremosPruebasSobreNuestraApp {

    private lateinit var viewModel: PracticaViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup(){
        Dispatchers.setMain(dispatcher)
        viewModel = PracticaViewModel()
    }

    @After
    fun tearDown(){
        Dispatchers.resetMain()
    }

    @Test
    fun practicaViewModel_CheckInitialValue() = runTest {
        val value = viewModel.practicaModel.value?.textoUno
        assertEquals("", value)
    }

    @Test
    fun practicaViewModel_LimpiarTodo() = runTest {
        launch {
            viewModel.limpiar()
        }
        advanceUntilIdle()

        val value = viewModel.practicaModel.value?.textoDos
        assertEquals("", value)

    }

    @Test
    fun compararTextos_Iguales_Correctos() = runTest {

        // Inicio
        val viewModel = PracticaViewModel()
        val textoUno = "Gato probando"
        val textoDos = "Gato probando"

        //Vista
        viewModel.compararTexto(textoUno, textoDos)

        //Comparacion
        val result = viewModel.practicaModel.value?.textoResultadoFin
        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun compararTextos_No_Iguales() = runTest {

        // Inicio
        val viewModel = PracticaViewModel()
        val textoUno = "Gato probando"
        val textoDos = "Gato reprobado"

        //Vista
        viewModel.compararTexto(textoUno, textoDos)

        //Comparacion
        val result = viewModel.practicaModel.value?.textoResultadoFin
        assertEquals("Los textos son diferentes", result)
    }

    @Test
    fun compararTextos_Con_Minima_Diferencia() = runTest {

        // Inicio
        val viewModel = PracticaViewModel()
        val textoUno = "Gato probando"
        val textoDos = "gato probando"

        //Vista
        viewModel.compararTexto(textoUno, textoDos)

        //Comparacion
        val result = viewModel.practicaModel.value?.textoResultadoFin
        assertEquals("Los textos son diferentes", result)
    }



}

