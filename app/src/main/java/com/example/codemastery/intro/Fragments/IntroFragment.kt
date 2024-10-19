package com.example.codemastery.intro.Fragments

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.codemastery.R
import com.example.codemastery.databinding.FragmentIntroBinding

import com.google.android.gms.auth.api.signin.GoogleSignInOptions

import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import android.util.Log
import android.widget.Toast
import com.example.codemastery.main.MainActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient

@Suppress("DEPRECATION")
class IntroFragment : Fragment(R.layout.fragment_intro) {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var binding: FragmentIntroBinding
    private lateinit var googleSignInClient: GoogleSignInClient
    private lateinit var auth: FirebaseAuth
    private val RC_SIGN_IN = 9001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Configure Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_intro, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.loginButton.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_loginFragment)
        }

        progressDialog = ProgressDialog(activity)

        binding.registerButton.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_signupFragment)
        }

        binding.signInWithGoogle.setOnClickListener {
            progressDialog.show()
            progressDialog.setMessage("Loading")
            googleSignIn()
        }
    }

    private fun googleSignIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Handle Google Sign-In result
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign-In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign-In failed
                Log.w("IntroFragment", "Google sign in failed", e)
                Toast.makeText(requireContext(), "Google sign-in failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity(), ) { task ->
                if (task.isSuccessful){
                    progressDialog.dismiss()
                    val user: FirebaseUser? = auth.currentUser
                    updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("IntroFragment", "signInWithCredential:failure", task.exception)
                    Toast.makeText(requireContext(), "Authentication Failed.", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
    }




    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            // Navigate to the next screen or update the UI to show the user's details
           startActivity(Intent(requireContext() , MainActivity::class.java))
        } else {
            // Handle sign-out case or error case
            Toast.makeText(requireContext(), "Sign-in failed", Toast.LENGTH_SHORT).show()
        }
    }
}









































