package com.curso.android.app.practica.pyfinal02.view

import org.junit.Assert.*
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.curso.android.app.practica.pyfinal02.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_CompararTextos() {

        // textInputUno sea visible
        Espresso.onView(
            ViewMatchers.withId(R.id.textInputUno)
        ).check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()
                )
            )
        Thread.sleep(1000)

        //Hacer Click en el cuadro de texto
        Espresso.onView(
            ViewMatchers.withId(R.id.textInputUno)
        ).perform(
            ViewActions.click()
        )
        Thread.sleep(1000)

        // Ingresar primer texto
        Espresso.onView(
            ViewMatchers.withId(R.id.textInputUno)
        ).perform(
            ViewActions.typeText("Iniciamos Prueba Uno")
        )
        Thread.sleep(1000)

        //  textInputDos sea visible
        Espresso.onView(
            ViewMatchers.withId(R.id.textInputDos)
        ).check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()
                )
            )
        Thread.sleep(1000)

        //Hacer Click en el cuadro de texto
        Espresso.onView(
            ViewMatchers.withId(R.id.textInputDos)
        ).perform(
            ViewActions.click()
        )
        Thread.sleep(1000)

        // Ingresar segundo texto
        Espresso.onView(
            ViewMatchers.withId(R.id.textInputDos)
        ).perform(
            ViewActions.replaceText("Iniciamos Prueba Dos")
        )
        Thread.sleep(1000)

        // Realizar clic en el botón comparar
        Espresso.onView(
            ViewMatchers.withId(R.id.button2)
        ).perform(
                ViewActions.click()
            )
        Thread.sleep(1000)

        // Verificar resultado
        Espresso.onView(
            ViewMatchers.withId(R.id.viewModelTextResultado)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son diferentes")
            )
        )
        Thread.sleep(1000)

    }
}


