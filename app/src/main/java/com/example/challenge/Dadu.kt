package com.example.challenge

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "items_table")
data class Dadu (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "skor")
    var skor: Int = 0,

    @ColumnInfo(name = "user")
    var user: String? = ""


)