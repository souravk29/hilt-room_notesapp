# Hilt + Room Notes App

Using dependency injection with third party library (ROOM DATABASE)

<img src="app_screenshot.png" width="300" />

A simple Notes application built with modern Android development practices. This project demonstrates clean architecture with dependency injection, local persistence, and reactive UI updates.

## Features
- Create, update, delete notes
- Persist notes locally using Room
- Dependency Injection with Hilt
- MVVM architecture with Repository pattern
- Kotlin Coroutines and Flow for async/reactive data
- Lifecycle-aware components
- Material design UI
- Configuration-safe data handling

## Tech Stack
- Language: Kotlin
- Architecture: MVVM + Repository
- Dependency Injection: Hilt (Dagger)
- Database: Room (Jetpack)
- Concurrency/Reactive: Kotlin Coroutines, Flow
- AndroidX: ViewModel, LiveData/StateFlow, Lifecycle
- UI: Android Views or Jetpack Compose (update this if Compose is used)
- Navigation: AndroidX Navigation (if used)
- Build: Gradle (KTS or Groovy)

## High-Level Architecture
- UI Layer: Activities/Fragments (or Composables) observe ViewModels
- Domain/Presentation: ViewModels expose state via LiveData/StateFlow/Flow
- Data Layer:
  - Repository mediates between ViewModel and data sources
  - Room Database with DAO for CRUD operations
- DI: Hilt provides scoped dependencies (Application/Activity/Fragment/ViewModel scopes)

```
App
├─ di/               # Hilt modules and providers
├─ data/
│  ├─ local/         # Room entities, DAO, database
│  ├─ repository/    # Repository implementation
├─ domain/           # (Optional) use cases / models
├─ ui/
│  ├─ ...            # Activities/Fragments/Composables, adapters
└─ utils/            # Helpers, mappers, constants
```

## Modules and Key Components
- Room
  - Entity: Note (id, title, content, timestamp, etc.)
  - DAO: NoteDao with insert/update/delete/query
  - Database: NoteDatabase
- Hilt
  - @HiltAndroidApp Application class
  - Modules to provide Database, DAO, Repository
  - @AndroidEntryPoint Activities/Fragments
  - @HiltViewModel for ViewModels
- ViewModel
  - Exposes notes list and CRUD operations
  - Uses Coroutines/Flows to collect from Room
- Repository
  - Single source of truth
  - Wraps DAO and maps entities to UI models

## Getting Started
1. Clone the repo
2. Open in Android Studio (latest stable)
3. Sync Gradle
4. Run the app on a device/emulator (min SDK per your project config)

## Build & Requirements
- Android Studio Meerkat/Giraffe/Koala (or latest)
- Gradle Plugin: match project configuration
- Min/Target SDK: match project configuration
- Kotlin version: match project configuration


