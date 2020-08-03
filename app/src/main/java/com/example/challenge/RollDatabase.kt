package com.example.challenge

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi


@Database(entities = [Dadu::class], version = 1, exportSchema = false)
abstract class RollDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        @Volatile
        private var Instansi: RollDatabase? = null
        @InternalCoroutinesApi
        fun getDatabase(context: Context): RollDatabase {
            val tempInstance = Instansi
            if (tempInstance != null) {
                return tempInstance
            }
            kotlinx.coroutines.internal.synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RollDatabase::class.java,
                    "my_database"
                ).build()
                Instansi = instance
                return instance
            }
        }
    }
}