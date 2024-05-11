package com.example.taskmanager

import androidx.room.*

@Dao
interface DAO {
    @Insert
    suspend fun insertTask(entity: Entity)

    @Update
    suspend fun updateTask(entity: Entity)

    @Delete
    suspend fun deleteTask(entity: Entity)

    @Query("Delete from To_Do")
    suspend fun deleteAll()

    @Query("Select * from To_Do")
    suspend fun getTasks(): List<CardInfo>
}
