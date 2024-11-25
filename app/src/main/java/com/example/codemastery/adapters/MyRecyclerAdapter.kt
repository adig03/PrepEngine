package com.example.codemastery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codemastery.Models.SubjectsResponseItem
import com.example.codemastery.R
import com.example.codemastery.VideoLecture.Fragments.VideolistFragmentDirections
import com.example.codemastery.databinding.TopiclistRvBinding

class MyRecyclerAdapter : RecyclerView.Adapter<MyRecyclerAdapter.SubjectViewHolder>() {

    // ViewHolder for binding subject data to the UI
    inner class SubjectViewHolder(private val binding: TopiclistRvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(subject: SubjectsResponseItem) {
            binding.apply {
                // Bind subject name to the title text view
                cardTitleText.text = subject.name

                // Load subject image using Glide
                Glide.with(itemView.context)
                    .load(subject.image)
                    // Placeholder while loading
                    .into(cardImageView)


                itemView.setOnClickListener {
                    val action = VideolistFragmentDirections
                        .actionVideolistFragmentToVideoWebviewFragment(subject._id)
                    it.findNavController().navigate(action)
                }
            }
        }
    }

    // DiffUtil for optimized list updates
    private val differCallback = object : DiffUtil.ItemCallback<SubjectsResponseItem>() {
        override fun areItemsTheSame(oldItem: SubjectsResponseItem, newItem: SubjectsResponseItem): Boolean {
            return oldItem._id == newItem._id // Compare by unique ID
        }

        override fun areContentsTheSame(oldItem: SubjectsResponseItem, newItem: SubjectsResponseItem): Boolean {
            return oldItem == newItem // Compare all fields
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val binding = TopiclistRvBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SubjectViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val subject = differ.currentList[position]
        holder.bind(subject)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
