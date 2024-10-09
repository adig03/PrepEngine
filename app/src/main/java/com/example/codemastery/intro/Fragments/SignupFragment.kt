package com.example.codemastery.intro.Fragments

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.codemastery.R
import com.example.codemastery.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Suppress("DEPRECATION")
class SignupFragment : Fragment(R.layout.fragment_signup) {
    private lateinit var binding: FragmentSignupBinding
    val signUpAuth: FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var SignUpPD: ProgressDialog
    val firestore= FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_signup, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        SignUpPD = ProgressDialog(activity)

        binding.goToLoginText.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

        binding.SignUpButton.setOnClickListener {
            val email = binding.signupEmail.text.toString()
            val name = binding.UserName.text.toString()
            val Password = binding.signuppassword.toString()

            if (name.isEmpty()) {
                Toast.makeText(activity, "Name Cant be Empty", Toast.LENGTH_SHORT).show()
            }
            if (Password.isEmpty()) {
                Toast.makeText(activity, "Password Cant be Empty", Toast.LENGTH_SHORT).show()
            }
            if (email.isEmpty()) {
                Toast.makeText(activity, "Email Cant be Empty", Toast.LENGTH_SHORT).show()
            }


            if (name.isNotEmpty() && email.isNotEmpty() && Password.isNotEmpty()) {
                getTheUserSignUp(name, email, Password)
            }


        }
    }

    private fun getTheUserSignUp(name: String, email: String, password: String) {
        SignUpPD.show()
        SignUpPD.setMessage("Creating Account")

        signUpAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            if (task.isSuccessful) {
                signUpAuth.currentUser?.sendEmailVerification()
                    ?.addOnSuccessListener {
                        Toast.makeText(
                            activity,
                            "Verification mail has been sent , Please verify your mail",
                            Toast.LENGTH_SHORT
                        ).show()
                    }?.addOnFailureListener {
                        Toast.makeText(activity, "Failed to send verification email: ${it.message}", Toast.LENGTH_SHORT)
                            .show()
                    }

                val user = signUpAuth.currentUser

                val hashMap = hashMapOf(
                    "userId" to user!!.uid,
                    "user_name" to name,
                    "user_email" to email,
                    "user_age" to "",
                    "user_image" to "https://robohash.org/${name}"
                )

                // Set user data in Firestore and handle success or failure
                firestore.collection("Users").document(user.uid).set(hashMap)
                    .addOnSuccessListener {
                        Toast.makeText(activity, "User data successfully stored in Firestore", Toast.LENGTH_SHORT).show()
                        SignUpPD.dismiss()
                        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
                    }
                    .addOnFailureListener {
                        Toast.makeText(activity, "Failed to store user data: ${it.message}", Toast.LENGTH_SHORT).show()
                        SignUpPD.dismiss()
                    }

            } else {
                Toast.makeText(activity, "Signup failed: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                SignUpPD.dismiss()
            }
        }
    }

}


