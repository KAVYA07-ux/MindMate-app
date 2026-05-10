# 🧠 MindMate — Daily Mood Tracker

<div align="center">

![MindMate](https://img.shields.io/badge/MindMate-Mood%20Tracker-6C3FFF?style=for-the-badge&logo=android&logoColor=white)

[![Platform](https://img.shields.io/badge/Platform-Android-brightgreen?style=flat-square&logo=android)](https://android.com)
[![Language](https://img.shields.io/badge/Language-Kotlin%20%2B%20Java-orange?style=flat-square&logo=kotlin)](https://kotlinlang.org)
[![AI Powered](https://img.shields.io/badge/AI-Powered%20Analysis-purple?style=flat-square)](https://github.com/KAVYA07-ux/MindMate)
[![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)](LICENSE)

**A smart Android app to track your daily mood, get AI-powered emotional insights, and visualize your emotional patterns over time.**

[📥 Download APK](#-installation) · [✨ Features](#-features) · [🛠️ Tech Stack](#️-tech-stack) · [🚀 Getting Started](#-getting-started)

</div>

---

## 📱 Screenshots

<div align="center">

| 🏠 Mood Selection | 💜 Mood Insight | 📊 Mood History |
|:-----------------:|:---------------:|:---------------:|
| ![Mood Selection](screenshots/mood_selection.png) | ![Mood Insight](screenshots/mood_insight.png) | ![History](screenshots/mood_history.png) |
| *Pick your current mood* | *AI quote & reflection* | *7-day chart + entries* |

</div>

---

## ✨ Features

- 😊 **6 Mood Cards** — Tap to select from Happy, Sad, Anxious, Angry, Calm, or Tired
- ✍️ **Free Text Input** — Describe how you feel in your own words
- ✨ **AI Mood Analysis** — Get personalized insights and motivational quotes based on your mood
- 📊 **7-Day Mood Chart** — Visual bar chart showing your emotional trends over the past week
- 📜 **Recent Entries** — Scrollable history list with mood emoji, label, and timestamp
- 🌙 **Dark Theme UI** — Clean, eye-friendly dark interface with purple accents
- 📱 **Offline First** — All data stored locally using SharedPreferences, no internet required for core features

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Kotlin** | Primary language for data models & logic |
| **Java** | Activity & adapter implementation |
| **Android Studio** | IDE & development environment |
| **XML Layouts** | UI screens & components |
| **RecyclerView + Adapter** | Dynamic mood history list |
| **SharedPreferences** | Local mood data persistence |
| **Room Database** | Structured mood entry storage |
| **Bar Chart (Canvas)** | 7-day mood visualization |
| **AI Integration** | Mood-based quote & analysis generation |
| **Material Design** | UI components & dark theme |

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- Android device or emulator (**API 21+**)
- Kotlin 1.9+

### Option 1 — Download APK *(Easiest)*

1. Go to [**Releases**](../../releases/latest)
2. Download `app-debug.apk`
3. Transfer to your Android phone
4. Enable **Install from Unknown Sources**:
   ```
   Settings → Security → Install Unknown Apps → ON
   ```
5. Open the APK and install!

### Option 2 — Build from Source

```bash
# 1. Clone the repository
git clone https://github.com/KAVYA07-ux/MindMate.git

# 2. Open in Android Studio
#    File → Open → Select the MindMate folder

# 3. Let Gradle sync complete

# 4. Run on device or emulator
#    Click ▶ Run  or press  Shift + F10
```

---

## 🎯 How It Works

```
Open App
   ↓
Select a Mood  →  😊 Happy / 😢 Sad / 😰 Anxious / 😡 Angry / 😌 Calm / 😴 Tired
   ↓
Optional: Type how you feel in the text box
   ↓
       ┌─────────────────────────────────┐
       │  ✨ ANALYZE WITH AI             │  →  Get a motivational quote & insight
       │  📊 VIEW MOOD HISTORY           │  →  See your 7-day chart & entries
       └─────────────────────────────────┘
   ↓
Mood saved with timestamp to local storage
```

---

## 📂 Project Structure

```
MindMate/
├── app/
│   └── src/
│       └── main/
│           ├── java/com.kavya.mindmate/
│           │   ├── MainActivity.java         # Home screen — mood selection
│           │   ├── HistoryActivity.java      # Mood history + bar chart
│           │   └── MoodAdapter.java          # RecyclerView adapter
│           ├── kotlin/com.kavya.mindmate/
│           │   └── db/
│           │       └── MoodEntry.kt          # Room entity — mood data model
│           ├── res/
│           │   ├── layout/                   # XML UI layouts
│           │   ├── drawable/                 # Icons & backgrounds
│           │   └── values/                   # Colors, strings, themes
│           └── AndroidManifest.xml
├── build.gradle
└── README.md
```

---

## 🔮 Planned Features

- [ ] 🔔 Daily mood reminder notifications
- [ ] 📤 Export mood history as PDF/CSV
- [ ] 🔐 App lock with fingerprint / PIN
- [ ] ☁️ Cloud backup & sync
- [ ] 🎨 Custom mood themes


<div align="center">

⭐ **If you like MindMate, please star this repo!** ⭐

*Built with 💜 using Kotlin, Java & Android Studio*

</div>
