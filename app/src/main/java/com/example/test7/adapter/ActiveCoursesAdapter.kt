package com.example.test7.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test7.databinding.ActiveCoursesItemBinding
import com.example.test7.extensions.setImage
import com.example.test7.model.ActiveCourse

class ActiveCoursesAdapter : RecyclerView.Adapter<ActiveCoursesAdapter.ActiveCoursesViewHolder>() {

    private var activeCoursesList = listOf<ActiveCourse>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActiveCoursesAdapter.ActiveCoursesViewHolder {
        return ActiveCoursesViewHolder(
            ActiveCoursesItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: ActiveCoursesAdapter.ActiveCoursesViewHolder,
        position: Int
    ) {
        holder.onBind()
    }

    override fun getItemCount() = activeCoursesList.size

    inner class ActiveCoursesViewHolder(private var binding: ActiveCoursesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind() {
            binding.item.setBackgroundColor(Color.parseColor("#7D".plus(activeCoursesList[adapterPosition].mainColor)))
            binding.ivImage.setImage(activeCoursesList[adapterPosition].image)
            binding.tvBookingTime.text  = "Booking For".plus(activeCoursesList[adapterPosition].bookingTime)
            binding.tvBookingTimeSec.text  = "Booking For".plus(activeCoursesList[adapterPosition].bookingTime)
            binding.indicator.progress = activeCoursesList[adapterPosition].progress.toInt()
        }
    }


    fun setData(data: List<ActiveCourse>) {
        val diffUtil = DiffUtils(activeCoursesList, data)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        activeCoursesList = data
        diffResult.dispatchUpdatesTo(this)
    }

    class DiffUtils(
        private val newList: List<ActiveCourse>,
        private val oldList: List<ActiveCourse>
    ):DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition].id == newList[newItemPosition].id

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

}