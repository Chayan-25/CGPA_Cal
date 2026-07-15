package com.example.cgpa_calculator.ui.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cgpa_calculator.ui.screens.GradeEntryScreen
import com.example.cgpa_calculator.ui.screens.SemesterSelectScreen
import com.example.cgpa_calculator.ui.screens.SummaryScreen
import com.example.cgpa_calculator.viewmodel.CgpaViewModel

object Routes {
    const val SEMESTER_SELECT = "semester_select"
    const val GRADE_ENTRY = "grade_entry/{semesterNumber}"
    const val SUMMARY = "summary"

    fun gradeEntry(semesterNumber: Int) = "grade_entry/$semesterNumber"
}

@Composable
fun AppNavigation(viewModel: CgpaViewModel = viewModel()) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SEMESTER_SELECT,
        enterTransition = {
            fadeIn(tween(300)) + slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(300)
            )
        },
        exitTransition = {
            fadeOut(tween(300)) + slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                animationSpec = tween(300)
            )
        },
        popEnterTransition = {
            fadeIn(tween(300)) + slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(300)
            )
        },
        popExitTransition = {
            fadeOut(tween(300)) + slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                animationSpec = tween(300)
            )
        }
    ) {
        composable(Routes.SEMESTER_SELECT) {
            SemesterSelectScreen(
                semesters = viewModel.semesters,
                onSemesterSelected = { number ->
                    viewModel.selectSemester(number)
                    navController.navigate(Routes.gradeEntry(number))
                },
                onViewSummary = {
                    navController.navigate(Routes.SUMMARY)
                },
                cgpa = viewModel.cgpa,
                completedCount = viewModel.completedSemesters
            )
        }

        composable(Routes.GRADE_ENTRY) { backStackEntry ->
            val semesterNumber = backStackEntry.arguments
                ?.getString("semesterNumber")
                ?.toIntOrNull() ?: return@composable

            val semester = viewModel.semester(semesterNumber) ?: return@composable

            GradeEntryScreen(
                semester = semester,
                onBack = {
                    viewModel.clearSelection()
                    navController.popBackStack()
                },
                onGradeSelected = { index, grade ->
                    viewModel.updateGrade(semesterNumber, index, grade)
                }
            )
        }

        composable(Routes.SUMMARY) {
            SummaryScreen(
                semesters = viewModel.semesters,
                cgpa = viewModel.cgpa,
                totalCredits = viewModel.totalCreditsEntered,
                onBack = { navController.popBackStack() },
                onReset = {
                    viewModel.resetAll()
                    navController.popBackStack(
                        route = Routes.SEMESTER_SELECT,
                        inclusive = false
                    )
                }
            )
        }
    }
}
