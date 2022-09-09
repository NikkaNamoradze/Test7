package com.example.test7.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test7.databinding.NewCoursesItemBinding
import com.example.test7.model.NewCourse

class NewCoursesAdapter : RecyclerView.Adapter<NewCoursesAdapter.NewCoursesViewHolder>() {

    private var newCoursesList = listOf<NewCourse>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NewCoursesAdapter.NewCoursesViewHolder {
        return NewCoursesViewHolder(
            NewCoursesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: NewCoursesAdapter.NewCoursesViewHolder,
        position: Int
    ) {
        holder.onBind()
    }

    override fun getItemCount() = newCoursesList.size

    inner class NewCoursesViewHolder(private var binding: NewCoursesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.item.setBackgroundColor(Color.parseColor("#".plus(newCoursesList[adapterPosition].mainColor)))
            binding.tvTitle.text = newCoursesList[adapterPosition].title
            binding.tvQuestion.text = newCoursesList[adapterPosition].question
        }
    }


    fun setData(data: List<NewCourse>) {
        val diffUtil = DiffUtils(newCoursesList, data)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        newCoursesList = data
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffUtils(
        private val newList: List<NewCourse>,
        private val oldList: List<NewCourse>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

}