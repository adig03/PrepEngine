package com.example.codemastery.adapters



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.codemastery.Models.QuizModel
import com.example.codemastery.Quizes.Fragments.QuizQuesFragment
import com.example.codemastery.Quizes.Fragments.QuizTypeFragmentDirections
import com.example.codemastery.R
import com.example.codemastery.databinding.QuizItemRecyclerRowBinding


// Adapter class for RecyclerView
class QuizListAdapter(private val quizModelList: List<QuizModel>) :
    RecyclerView.Adapter<QuizListAdapter.MyViewHolder>() {

    // ViewHolder class that binds the data to the view
    class MyViewHolder(private val binding: QuizItemRecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

        // Function to bind the data from the model to the views
        fun bind(model: QuizModel) {
            binding.apply {
              quizTitleText.text =model.title
            quizTimeText.text = model.time
            quizSubtitleText.text = model.subtitle// Set the quiz time text
            }
        }
    }

    // Inflates the layout for each row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = QuizItemRecyclerRowBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MyViewHolder(binding)
    }

    // Returns the size of the list
    override fun getItemCount(): Int {
        return quizModelList.size
    }

    // Binds data to the view holder based on the position
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(quizModelList[position])


        holder.itemView.setOnClickListener {

            QuizQuesFragment.questionModelList = quizModelList[position].QuestionList
            QuizQuesFragment.timer = quizModelList[position].time
            it.findNavController().navigate(R.id.action_quizTypeFragment_to_quizQuesFragment)

        }
    }
}
