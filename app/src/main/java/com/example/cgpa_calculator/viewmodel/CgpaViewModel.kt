package com.example.cgpa_calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.cgpa_calculator.data.Semester
import com.example.cgpa_calculator.data.SemesterCatalog

class CgpaViewModel : ViewModel() {

    var semesters by mutableStateOf(SemesterCatalog.allSemesters())
        private set

    var selectedSemester by mutableStateOf<Int?>(null)
        private set

    fun selectSemester(number: Int) {
        selectedSemester = number
    }

    fun clearSelection() {
        selectedSemester = null
    }

    fun updateGrade(semesterNumber: Int, subjectIndex: Int, gradePoint: Float?) {
        semesters = semesters.map { semester ->
            if (semester.number != semesterNumber) semester
            else semester.copy(
                subjects = semester.subjects.mapIndexed { index, subject ->
                    if (index != subjectIndex) subject
                    else subject.copy(gradePoint = gradePoint)
                }
            )
        }
    }

    val cgpa: Float?
        get() {
            val allGraded = semesters.asSequence().flatMap { it.subjects }.filter { it.gradePoint != null }.toList()
            if (allGraded.isEmpty()) return null
            val totalPoints = allGraded.sumOf { (it.gradePoint!! * it.credits).toDouble() }
            val totalCredits = allGraded.sumOf { it.credits }
            return if (totalCredits > 0) (totalPoints / totalCredits).toFloat() else null
        }

    val totalCreditsEntered: Int
        get() = semesters.flatMap { it.subjects }
            .filter { it.gradePoint != null }
            .sumOf { it.credits }

    val completedSemesters: Int
        get() = semesters.count { it.isComplete }

    fun resetAll() {
        semesters = SemesterCatalog.allSemesters()
        selectedSemester = null
    }

    fun semester(number: Int): Semester? = semesters.find { it.number == number }
}
