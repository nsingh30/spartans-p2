package com.example.recipegenie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class MainViewModelTest {
lateinit var viewModel: MainViewModel

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: RecipeRepository

    @Before
    fun setup () {
        MockitoAnnotations.openMocks(this)
        viewModel = MainViewModel( repository)
    }
    @Test
    fun getAllRecipesTest()  {
        var fakeList :List<Recipe> = (listOf<Recipe>(
            Recipe(234,"fromtest","","","","","")
        ))

        // mock the function call to the api
        Mockito.`when`(repository.getAllRecipes())
            .thenReturn(MutableLiveData(fakeList))

        var result = viewModel.getAllRecipes()
        assertEquals(result,fakeList)

    }

























}