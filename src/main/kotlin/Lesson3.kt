// модуль userRepository
// публичный интерфейс который поставляет юзера
interface UserRepository {
    suspend fun getUser(token: String): User
}


// имплементация, область видимости которой только внутри модуля
internal class UserRepositoryImpl(private val userDataSource: UserDataSource) : UserRepository {
    override suspend fun getUser(token: String): User {
        return userDataSource.syncUser(token)
    }
}

// фабрика которая поставляет UserRepository
object UserRepositoryFabric {
    fun getUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }
}

// интерфейс UserDataSource, имплементация которого будет поставлятся в фабрику
interface UserDataSource {
    suspend fun syncUser(token: String): User
}
