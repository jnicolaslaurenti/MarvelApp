package com.marvelapp.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.marvelapp.data.CharacterEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
@OptIn(ExperimentalCoroutinesApi::class)
class CharacterViewModelTest {

    private val characterViewModel = CharacterViewModel()

    private val testDispatcher = TestCoroutineDispatcher()

    private val listTest = listOf(CharacterEntity("Batman", ""), CharacterEntity("Superman", ""))

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        Dispatchers.setMain(testDispatcher)
    }

    @After
    fun after() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @Test
    fun `when the character screen is starting, the list is charged`() = runTest {
        characterViewModel.showCharacters().join()
        Assert.assertEquals(CharacterViewModel.CharactersState.SHOW_CHARACTERS, characterViewModel.state.value.state)
        Assert.assertEquals(listTest, characterViewModel.state.value.data)
    }

}
