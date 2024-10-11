import com.example.codemastery.user.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class UserRepo {
    private val firestore = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    suspend fun fetchLoggedInUserDetails(): User? {
        return withContext(Dispatchers.IO) {
            // Replace "yourUserId" with the actual logic to get the logged-in user ID
            val userId = getLoggedInUserId()
            if (userId != null) {
                // Fetch user data from Firestore
                val docRef = firestore.collection("users").document(userId)
                val snapshot = docRef.get().await() // Use Kotlin coroutines to wait for the result
                if (snapshot.exists()) {
                    // Assuming the User data class has a fromMap method to create an instance from Firestore data
                    return@withContext snapshot.toObject(User::class.java)
                }
            }
            null // Return null if no user found
        }
    }

    private fun getLoggedInUserId(): String? {

        return auth.currentUser?.uid
    }
}
