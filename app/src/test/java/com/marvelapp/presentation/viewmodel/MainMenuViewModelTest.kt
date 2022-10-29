package com.marvelapp.presentation.viewmodel

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainMenuViewModelTest {

    private val mainMenuViewModel = MainMenuViewModel()

    @Test
    fun `when the button is pressed change de screen`() {
        mainMenuViewModel.buttonPressed()
        Assert.assertEquals(
            MainMenuViewModel.MainMenuStates.GO_TO_CHARACTER_SCREEN,
            mainMenuViewModel.state.value
        )
    }
}
