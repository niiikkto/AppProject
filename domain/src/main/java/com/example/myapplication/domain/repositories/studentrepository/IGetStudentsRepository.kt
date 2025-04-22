package com.example.myapplication.domain.repositories.studentrepository

import com.example.myapplication.domain.models.Student


interface IGetStudentsRepository {
    suspend fun getStudents(): List<com.example.myapplication.domain.models.Student>
}