package uz.exemple.less54_mesengerui_withcreateroom_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.google.android.material.imageview.ShapeableImageView
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.R
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.model.Room


class RoomAdapter(var context: Context, var items: ArrayList<Room>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ROOM_CREATE = 0
    private val TYPE_ITEM_PROFILE = 1

    override fun getItemViewType(position: Int): Int {
        val item = items[position]
        if (item.profile == null)
            return TYPE_ROOM_CREATE
        return TYPE_ITEM_PROFILE
    }
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_ROOM_CREATE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.create_room_view, parent, false)
            return CreateRoomViewHolder(view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_room_view, parent, false)
        return RoomViewHolder(view)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val room = items[position]

        if (holder is RoomViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            iv_profile.setImageResource(room.profile!!)
            tv_fullname.text = room.fullname
        }
    }

    class RoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
        }
    }
    class CreateRoomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}