package com.kavya.mindmate.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MoodDao {
    @Insert
    suspend fun insertMood(entry: MoodEntry)

    @Query("SELECT * FROM mood_entries ORDER BY timestamp DESC")
    suspend fun getAllMoods(): List<MoodEntry>

    @Query("SELECT * FROM mood_entries WHERE timestamp >= :startTime ORDER BY timestamp ASC")
    suspend fun getMoodsAfter(startTime: Long): List<MoodEntry>

    @Delete
    suspend fun deleteMood(entry: MoodEntry)
}