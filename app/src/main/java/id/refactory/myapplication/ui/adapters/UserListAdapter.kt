package id.refactory.myapplication.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.refactory.domain.User
import id.refactory.myapplication.R

class UserListAdapter(
    private val context: Context,
    private val users: MutableList<User>): RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    override fun getItemCount(): Int = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.users_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.tvUserName?.text = user.name
    }

    inner class ViewHolder(row: View): RecyclerView.ViewHolder(row) {
        var tvUserName: TextView? = null

        init {
            tvUserName = row.findViewById(R.id.tv_user_name) as TextView
        }
    }
}