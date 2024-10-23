package com.example.codemastery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.codemastery.Models.QModel
import com.example.codemastery.Questions.Fragments.QuestionViewFragment
import com.example.codemastery.R
import com.example.codemastery.databinding.RvQuestionItemBinding

class QuestionAdapter(private val questions: List<QModel>) :
    RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder>() {

    class QuestionViewHolder(val binding: RvQuestionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(question: QModel) { // Change to QModel
            binding.questionText.text = question.Question
            binding.QuestionNumber.text = "Q.${question.id}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        // Inflate the layout using View Binding
        val binding = RvQuestionItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return QuestionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(questions[position])
//
      holder.itemView.setOnClickListener {
            QuestionViewFragment.questionList = questions
          QuestionViewFragment.currentIndex = questions[position].id

          it.findNavController().navigate(R.id.action_questionListFragment_to_questionViewFragment)
       }
    }

    override fun getItemCount(): Int {
        return questions.size
    }
}
