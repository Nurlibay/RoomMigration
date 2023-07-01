package uz.nurlibaydev.roommigration.database

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.DeleteColumn
import androidx.room.RenameColumn
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import uz.nurlibaydev.roommigration.database.model.User

@Database(
    entities = [User::class],
    version = 4,
    autoMigrations = [
        AutoMigration(
            from = 1,
            to = 2
        ),
        AutoMigration(
            from = 2,
            to = 3,
            spec = MainDatabase.Migration2To3::class
        ),
        AutoMigration(
            from = 3,
            to = 4,
            spec = MainDatabase.Migration3To4::class
        )
    ]
)
abstract class MainDatabase : RoomDatabase() {

    abstract fun userDao(): MainDao

    companion object {
        fun getInstance(context: Context): MainDatabase {
            return Room.databaseBuilder(
                context,
                MainDatabase::class.java,
                "users.db"
            ).build()
        }
    }

    @RenameColumn(tableName = "User", fromColumnName = "age", toColumnName = "userAge")
    class Migration2To3 : AutoMigrationSpec

    @DeleteColumn(tableName = "User", columnName = "userAge")
    class Migration3To4 : AutoMigrationSpec
}