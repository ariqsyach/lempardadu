package com.example.challenge

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ItemDao {
    @Query("SELECT * FROM items_table ORDER BY skor DESC")
    suspend fun getSkor() : List<Dadu>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(dadu: Dadu)
}