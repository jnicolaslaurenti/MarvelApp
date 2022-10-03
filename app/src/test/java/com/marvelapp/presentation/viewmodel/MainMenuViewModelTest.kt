package com.marvelapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class MainMenuViewModelTest {

    private val mainMenuViewModel = MainMenuViewModel()

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun after() {
        Dispatchers.resetMain()
    }

    @Test
    fun `change screen when the button is pressed`() = runTest {
        mainMenuViewModel.goToCharacterScreen().join()
        Assert.assertEquals(
            MainMenuViewModel.MainMenuStates.BUTTON_PRESSED,
            mainMenuViewModel.state.value
        )
    }
}
