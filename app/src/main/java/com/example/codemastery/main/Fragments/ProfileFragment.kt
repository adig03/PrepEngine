package com.example.codemastery.main.Fragments

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.codemastery.Models.Badge
import com.example.codemastery.R
import com.example.codemastery.adapters.BadgeAdapter
import com.example.codemastery.databinding.FragmentProfileBinding
import com.example.codemastery.intro.IntroActivity
import com.google.firebase.auth.FirebaseAuth


@Suppress("DEPRECATION")
class ProfileFragment : Fragment(R.layout.fragment_profile) {
   private lateinit var binding :FragmentProfileBinding
   private lateinit var auth: FirebaseAuth
   private lateinit var progressDialog :ProgressDialog
   private lateinit var badgeAdapter: BadgeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_profile, container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth =  FirebaseAuth.getInstance()
        progressDialog = ProgressDialog(activity)

        binding.toolbar.setNavigationOnClickListener{
            findNavController().navigate(R.id.action_profileFragment_to_homeFragment)
        }
        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", 0)
        val userName = sharedPreferences.getString("username", "Guest") // "Guest" is the default value if not found




        if (userName != null) {
            Glide.with(requireContext()).load("https://robohash.org/${userName}?bgset=bg1").into(binding.profileImage)
        }




        binding.LogoutButton.setOnClickListener {
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

        displayBadges(view)



    }

    private fun displayBadges(view: View) {
        val grid: GridView = view.findViewById<GridView>(R.id.badgesGrid)

        // Create a list of Badge objects with the required badge names
        val allbadges = arrayListOf(
            Badge("Newbie", "Welcome to the platform! You've just started your journey.", "Level 1",
                R.drawable.newbie_badge
            ),
            Badge("Rookie", "Great start! You've successfully completed your first milestone.", "Level 2",
                R.drawable.rookie_badge
            ),
            Badge("Conqueror", "You’ve completed major challenges and conquered your fears!", "Level 3",
                R.drawable.conqueror_badge
            ),
            Badge("Expert", "Your knowledge has reached expert levels. Well done!", "Level 4",
                R.drawable.expert_badge
            ),
            Badge("Legend", "You’ve achieved legendary status by completing all tasks flawlessly!", "Level 5",
                R.drawable.legend_badge
            ),
            Badge("Explorer", "You've explored every section of the app. Keep discovering!", "Level 6",
                R.drawable.explorer_badge
            )
        )

        // Set the adapter to the GridView
        val badgeAdapter = BadgeAdapter(view.context, allbadges)
        grid.adapter = badgeAdapter
    }

}


