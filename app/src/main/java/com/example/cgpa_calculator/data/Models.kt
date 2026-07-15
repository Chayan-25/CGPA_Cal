package com.example.cgpa_calculator.data

data class Subject(
    val name: String,
    val credits: Int,
    val gradePoint: Float? = null
)

data class Semester(
    val number: Int,
    val subjects: List<Subject>
) {
    val totalCredits: Int get() = subjects.sumOf { it.credits }

    val sgpa: Float?
        get() {
            val graded = subjects.filter { it.gradePoint != null }
            if (graded.isEmpty()) return null
            val totalPoints = graded.sumOf { (it.gradePoint!! * it.credits).toDouble() }
            val totalCr = graded.sumOf { it.credits }
            return if (totalCr > 0) (totalPoints / totalCr).toFloat() else null
        }

    val isComplete: Boolean
        get() = subjects.all { it.gradePoint != null }
}

enum class Grade(val label: String, val point: Float) {
    O("O (Outstanding)", 10f),
    A_PLUS("A+ (Excellent)", 9f),
    A("A (Very Good)", 8f),
    B_PLUS("B+ (Good)", 7f),
    B("B (Above Average)", 6f),
    C("C (Average)", 5f),
    P("P (Pass)", 4f),
    F("F (Fail)", 0f);

    companion object {
        fun fromPoint(point: Float): Grade? = entries.find { it.point == point }
    }
}
