package doston.olchashop.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import doston.olchashop.database.entity.UserData
@Dao

interface UserDao {
    @Query("select * from userdata")
    fun getUser():List<UserData>

    @Insert
    fun addUser(userData: UserData)
}