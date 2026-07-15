# CGPA Calculator 🎓

A modern and intuitive Android application built with **Jetpack Compose** and **Material 3** to help university students track their academic performance by calculating Semester Grade Point Average (SGPA) and Cumulative Grade Point Average (CGPA).

## ✨ Features

- **Multi-Semester Support**: Easily manage grades across different semesters.
- **Real-time Calculations**: Instant SGPA and CGPA updates as you input your grades.
- **Pre-defined Subject Catalog**: Structured input based on standard semester curricula.
- **Modern UI/UX**: Clean interface using Material Design 3 with smooth animated transitions between screens.
- **Grade Mapping**: Standardized grade points (O, A+, A, B+, B, etc.) for accurate calculation.
- **Summary Dashboard**: View your overall academic progress and total earned credits at a glance.
- **Persistent State**: Managed via ViewModel for a seamless user experience during navigation.

## 🛠 Tech Stack

- **Language**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose)
- **Architecture**: MVVM (Model-View-ViewModel)
- **Navigation**: [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- **Design System**: Material Design 3

## 📸 Screenshots

| Semester Selection | Grade Entry | Summary View |
|:---:|:---:|:---:|
| ![Semester Select](https://via.placeholder.com/200x400?text=Semester+Select) | ![Grade Entry](https://via.placeholder.com/200x400?text=Grade+Entry) | ![Summary](https://via.placeholder.com/200x400?text=Summary) |

## 🚀 Getting Started

### Prerequisites

- Android Studio Ladybug (or newer)
- JDK 17 or higher
- Android SDK 24+

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/cgpa-calculator.git
   ```
2. Open the project in Android Studio.
3. Wait for Gradle sync to complete.
4. Run the app on an emulator or physical device.

## 📂 Project Structure

```text
app/src/main/java/com/example/cgpa_calculator/
├── data/           # Data models and Semester/Subject catalog
├── ui/
│   ├── navigation/ # Navigation graph and route definitions
│   ├── screens/    # Compose UI screens (Select, Entry, Summary)
│   └── theme/      # Material 3 Theme definitions
├── viewmodel/      # Business logic and state management
└── MainActivity.kt # Entry point of the application
```

## 🤝 Contributing

Contributions are welcome! If you find a bug or have a feature request, please open an issue or submit a pull request.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

Distributed under the MIT License. See `LICENSE` for more information.

---
Built with ❤️ by [Chayan]
