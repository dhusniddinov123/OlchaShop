package doston.olchashop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import doston.olchashop.database.dao.UserDao
import doston.olchashop.database.entity.UserData

@Database(entities = [UserData::class], version = 1)

abstract class AppDataBase: RoomDatabase() {
    abstract fun getUserDao():UserDao

    companion object{
        var instance:AppDataBase? = null

        fun getInstance(context: Context):AppDataBase{
            if(instance == null){
                instance = Room.databaseBuilder(context,AppDataBase::class.java,"app_db")
                    .allowMainThreadQueries().build()
            }
            return instance!!
        }
    }

}