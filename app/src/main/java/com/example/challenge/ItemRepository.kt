package com.example.challenge

class ItemRepository(private val itemDao: ItemDao){
    suspend fun getSkor(): List<Dadu>{
        return itemDao.getSkor()
    }
    suspend fun insertData(dadu: Dadu){
        itemDao.insert(dadu)
    }
}