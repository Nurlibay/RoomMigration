package uz.nurlibaydev.roommigration.repository

import kotlinx.coroutines.flow.Flow
import uz.nurlibaydev.roommigration.database.MainDao
import uz.nurlibaydev.roommigration.database.model.User
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainDao: MainDao
) {

    suspend fun insertUser(user: User) {
        mainDao.insertUser(user)
    }

    fun getAllUsers(): Flow<List<User>> = mainDao.getAllUserList()
}