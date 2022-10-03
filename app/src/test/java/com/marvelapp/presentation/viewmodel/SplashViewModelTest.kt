package com.marvelapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.test.*
import org.junit.*
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class SplashViewModelTest {

    private val splashViewModel = SplashViewModel()

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
    fun `start animation`() = runTest {
            splashViewModel.runAnimation().join()
            Assert.assertEquals(
                SplashViewModel.SplashStates.FINISH_ANIMATION,
                splashViewModel.state.value
            )
    }

}
