package uz.exemple.less54_mesengerui_withcreateroom_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.R
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.model.Chat
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.model.Room


class ChatAdapter(var context: Context, var items: ArrayList<Chat>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_ITEM_ROOM = 0
    private val TYPE_ITEM_MESSAGE = 1

    override fun getItemViewType(position: Int): Int {
        var chat = items[position]
        if (chat.rooms.size > 0)
            return TYPE_ITEM_ROOM
        return TYPE_ITEM_MESSAGE
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_ITEM_ROOM) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_chat_room, parent, false)
            return RoomViewHolder(context, view)
        }
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_chat_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = items[position]

        if (holder is RoomViewHolder) {
            var recyclerView = holder.recyclerView
            refreshAdapter(chat.rooms, recyclerView)
        }

        if (holder is MessageViewHolder) {
            var iv_profile = holder.iv_profile
            var tv_fullname = holder.tv_fullname
            var is_online = holder.is_online
            var tv_message = holder.tv_message
            var tv_time = holder.tv_time

            iv_profile.setImageResource(chat.message!!.profile)
            tv_fullname.text = chat.message!!.fullname
            tv_message.text = "${chat.message!!.message} Kotlin"
            tv_time.text = chat.message!!.time

            if (chat.message!!.isOnline) {
                is_online.visibility = View.VISIBLE
            } else {
                is_online.visibility = View.GONE
            }
        }
    }

    fun refreshAdapter(rooms: ArrayList<Room>, recyclerView: RecyclerView) {
        val adapter = RoomAdapter(context, rooms)
        recyclerView.adapter = adapter
    }

    class RoomViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        var recyclerView: RecyclerView

        init {
            recyclerView = view.findViewById(R.id.recyclerView)
            val manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            recyclerView.setLayoutManager(manager)
        }
    }

    class MessageViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var iv_profile: ShapeableImageView
        var tv_fullname: TextView
        var tv_message: TextView
        var tv_time: TextView
        var is_online: LinearLayout

        init {
            iv_profile = view.findViewById(R.id.iv_profile)
            tv_fullname = view.findViewById(R.id.tv_fullname)
            tv_message = view.findViewById(R.id.tv_message)
            tv_time = view.findViewById(R.id.tv_time)
            is_online = view.findViewById(R.id.is_online)
        }
    }

}