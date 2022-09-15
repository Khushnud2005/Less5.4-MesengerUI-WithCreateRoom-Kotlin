package uz.exemple.less54_mesengerui_withcreateroom_kotlin.model

data class Message(var profile: Int, var fullname: String,var message:String, var time:String,var isOnline: Boolean = false) {

}