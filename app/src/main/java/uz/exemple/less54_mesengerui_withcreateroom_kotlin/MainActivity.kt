package uz.exemple.less54_mesengerui_withcreateroom_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.adapter.ChatAdapter
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.model.Chat
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.model.Message
import uz.exemple.less54_mesengerui_withcreateroom_kotlin.model.Room

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setLayoutManager(GridLayoutManager(this, 1))

        refreshAdapter(getAllChats())
    }

    fun refreshAdapter(chats: ArrayList<Chat>) {
        val adapter = ChatAdapter(this, chats)
        recyclerView.adapter = adapter
    }

    fun getAllChats(): ArrayList<Chat> {
        val chats: ArrayList<Chat> = ArrayList<Chat>()

        val rooms: ArrayList<Room> = ArrayList<Room>()
        rooms.add(Room(null, "Create room"))
        rooms.add(Room(R.drawable.photo1, "Xushnud Boymurotov"))
        rooms.add(Room(R.drawable.photo2, "Barnoxon Kabirova"))
        rooms.add(Room(R.drawable.photo3, "Kamolaxon Nematjonova"))
        rooms.add(Room(R.drawable.photo4, "Abdullatif Nematjonov"))
        rooms.add(Room(R.drawable.photo1, "Xushnud Boymurotov"))
        rooms.add(Room(R.drawable.photo2, "Barnoxon Kabirova"))
        rooms.add(Room(R.drawable.photo3, "Kamolaxon Nematjonova"))
        rooms.add(Room(R.drawable.photo4, "Abdullatif Nematjonov"))

        // Rooms
        chats.add(Chat(rooms))
        val text1 = "Xushnud sent voice message"
        val text2 = "Opamga aytaman"
        val text3 = "Ayam o'zingga buyurdilar"
        val text4 = "Opajon siz chiqib keling"
        // Messages
        chats.add(Chat(Message(R.drawable.photo4, "Abdullatif",text3,"18:12", false)))
        chats.add(Chat(Message(R.drawable.photo3, "Kamolaxon", text4,"18:07",true)))
        chats.add(Chat(Message(R.drawable.photo2, "Barnoxon",text2,"17:45", false)))
        chats.add(Chat(Message(R.drawable.photo1, "Xushnud", text1,"Tue",false)))
        chats.add(Chat(Message(R.drawable.photo4, "Abdullatif",text3,"18:12", true)))
        chats.add(Chat(Message(R.drawable.photo3, "Kamolaxon",text4,"18:07", false)))
        chats.add(Chat(Message(R.drawable.photo2, "Barnoxon",text2,"17:45", true)))
        chats.add(Chat(Message(R.drawable.photo1, "Xushnud",text1,"Tue", true)))
        chats.add(Chat(Message(R.drawable.photo4, "Abdullatif",text3,"18:12", false)))
        chats.add(Chat(Message(R.drawable.photo3, "Kamolaxon",text4,"18:07", true)))
        chats.add(Chat(Message(R.drawable.photo2, "Barnoxon",text2,"17:45", false)))
        chats.add(Chat(Message(R.drawable.photo1, "Xushnud",text1,"Tue", true)))

        return chats
    }
}