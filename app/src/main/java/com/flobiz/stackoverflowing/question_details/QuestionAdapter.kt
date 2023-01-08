package com.flobiz.stackoverflowing.question_details

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.flobiz.stackoverflowing.data.api.Question
import java.text.SimpleDateFormat
import java.util.*

class QuestionAdapter(
    private val context: Context,
    private val onClickListener: OnClickListener
) : ListAdapter<Question, QuestionAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder private constructor(private val binding: QuestionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(question: Question) {
            binding.question = question
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = QuestionItemBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(question)
        }
        holder.bind(question)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Question>() {
        override fun areItemsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Question, newItem: Question): Boolean {
            return oldItem.title == newItem.title
        }
    }

    class OnClickListener(val clickListener: (question: Question) -> Unit) {
        fun onClick(question: Question) = clickListener(question)
    }
}
