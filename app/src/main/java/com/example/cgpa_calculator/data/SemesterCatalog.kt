package com.example.cgpa_calculator.data

object SemesterCatalog {

    fun allSemesters(): List<Semester> = listOf(
        semester(1, listOf(
            "Chemistry" to 3,
            "Calculus" to 4,
            "English" to 2,
            "Basic Electronics" to 2,
            "Engineering Elective 1" to 2,
            "HASS Elective" to 2,
            "Chemistry Lab" to 1,
            "Engineering Lab" to 1,
            "Workshop" to 1,
            "Yoga" to 1,
            "Communication Lab" to 1
        )),
        semester(2, listOf(
            "Physics" to 3,
            "Diff. Eqn & Linear Algebra" to 4,
            "Science Elective" to 2,
            "Engineering Elective 2" to 2,
            "Science of Living Systems" to 2,
            "Environmental Sciences" to 2,
            "Physics Lab" to 1,
            "Programming Lab" to 4,
            "Engineering Drawing & Graphics" to 1
        )),
        semester(3, listOf(
            "Scientific & Technical Writing" to 2,
            "Probability & Statistics" to 4,
            "IND" to 4,
            "Data Structures" to 4,
            "Digital System Design" to 3,
            "Theory of Computation" to 4,
            "DS Lab" to 1,
            "DSD Lab" to 1
        )),
        semester(4, listOf(
            "EOD" to 3,
            "Discrete Structures" to 4,
            "Operating Systems" to 3,
            "OOP Java" to 3,
            "DBMS" to 3,
            "COA" to 4,
            "OS Lab" to 1,
            "Java Lab" to 1,
            "DBMS Lab" to 1
        )),
        semester(5, listOf(
            "Engineering Economics" to 3,
            "Design & Analysis of Algorithms" to 3,
            "Software Engineering" to 4,
            "Computer Networks" to 3,
            "Elective 1" to 3,
            "Elective 2" to 3,
            "Algo Lab" to 1,
            "Computer Networks Lab" to 1
        )),
        semester(6, listOf(
            "Machine Learning" to 4,
            "Artificial Intelligence" to 3,
            "Elective 1" to 3,
            "Elective 2" to 3,
            "Open Elective" to 3,
            "Universal Human Values" to 3,
            "AI Lab" to 1,
            "Application Development Lab" to 2,
            "Mini Project" to 2
        )),
        semester(7, listOf(
            "Elective 1" to 3,
            "Engineering Professional Practice" to 2,
            "Open Elective" to 3,
            "Project 1" to 5,
            "Internship" to 2,
            "ML Computing Lab" to 2
        )),
        semester(8, listOf(
            "Elective 1" to 3,
            "Minor" to 3,
            "Project 2" to 9
        ))
    )

    private fun semester(number: Int, subjects: List<Pair<String, Int>>): Semester =
        Semester(
            number = number,
            subjects = subjects.map { (name, credits) ->
                Subject(name = name, credits = credits)
            }
        )
}
