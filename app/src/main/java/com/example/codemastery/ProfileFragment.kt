package com.example.codemastery

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.codemastery.databinding.FragmentProfileBinding
import com.example.codemastery.intro.IntroActivity
import com.google.firebase.auth.FirebaseAuth


@Suppress("DEPRECATION")
class ProfileFragment : Fragment(R.layout.fragment_profile) {
   private lateinit var binding :FragmentProfileBinding
   private lateinit var auth: FirebaseAuth
   private lateinit var progressDialog :ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater ,R.layout.fragment_profile, container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth =  FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(activity)

        binding.logoutButton.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Logout")
            builder.setMessage("Are you sure you want to log out?")


            builder.setPositiveButton("Yes") { dialog, _ ->
                progressDialog.show()
                progressDialog.setMessage("Signing Out")
                auth.signOut()


                val intent = Intent(activity, IntroActivity::class.java)


                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)


                startActivity(intent)


                requireActivity().finish()

                dialog.dismiss()
            }


            builder.setNegativeButton("No") { dialog, _ ->
                dialog.dismiss()
            }


            val dialog = builder.create()
            dialog.show()
        }

    }
    }


