package com.example.codemastery.adapters



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.codemastery.R
import com.example.codemastery.Responses.Item
import com.example.codemastery.VideoLecture.Fragments.VideolistFragmentDirections
import com.example.codemastery.databinding.ItemVideoLectureBinding

class VideoLectureAdapter : RecyclerView.Adapter<VideoLectureAdapter.VideoViewHolder>() {

    // ViewHolder that binds video data to the UI
    inner class VideoViewHolder(private val binding: ItemVideoLectureBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(video: Item) {
            binding.apply {

                tvVideoTitle.text = video.snippet.title


                Glide.with(itemView.context)
                    .load(video.snippet.thumbnails.default.url)
                    .into(ivThumbnail)


             itemView.setOnClickListener{
                 val action = VideolistFragmentDirections.actionVideolistFragmentToVideoWebviewFragment(video.snippet.thumbnails.high.url)
                 it.findNavController().navigate(action)
             }
            }
        }
    }

    // DiffUtil for optimized list updates
    private val differCallback = object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id  // Compare by unique video ID
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem  // Check equality based on data fields
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoLectureBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = differ.currentList[position]
        holder.bind(video)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}
