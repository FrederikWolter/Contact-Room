package com.example.roomapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomapp.model.User

import android.database.sqlite.SQLiteDatabase

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.RoomMasterTable.TABLE_NAME


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addUser(user: User)

    @Update
    fun updateUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    fun deleteAllUsers()

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun getUser(id: Int): User

}