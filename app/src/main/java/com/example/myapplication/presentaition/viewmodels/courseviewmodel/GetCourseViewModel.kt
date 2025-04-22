package com.example.myapplication.presentaition.viewmodels.courseviewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.models.Course
import com.example.myapplication.domain.models.User
import com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase
import com.example.myapplication.domain.usecases.userusecase.GetUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GetCourseViewModel(private val getCoursesUseCase: com.example.myapplication.domain.usecases.courseusecase.GetCoursesUseCase) : ViewModel(){

    private val _courses = MutableStateFlow<List<com.example.myapplication.domain.models.Course>>(emptyList())
    val courses: StateFlow<List<com.example.myapplication.domain.models.Course>> = _courses

    init {
        fetchCourses()
    }



    private fun fetchCourses() = viewModelScope.launch {

        val result = getCoursesUseCase()
        _courses.value=  result
    }


}