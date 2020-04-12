package com.example.jsonbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    //I have used logcat to display the result u can you text view also you just need to set the text there that's is
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    val url = "https://jsonplaceholder.typicode.com/todos/1"
        val queue = Volley.newRequestQueue(this)

        // json object request
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET,url,null,Response.Listener {
            response -> Log.d("all data in json file ","Response: %s".format(response.toString()))
            Log.d("title in json file","Response: %s".format(response.getString("title").toString()))
            Log.d("user id in json file","Response: %s".format(response.getString("userId").toString()))},
                Response.ErrorListener
                {  Log.d("json","Response: Error") })


        val url2 = "https://jsonplaceholder.typicode.com/todos"
                //.. json array request
        val jsonarrayrequest = JsonArrayRequest(Request.Method.GET,url2, null,Response.Listener { response ->
            Log.d("arrayjson","Response: %s".format(response.toString()))
        },Response.ErrorListener { Log.d("arrayjson","Response: in array Error") })


        // this is for one single json file
        queue.add(jsonObjectRequest)

        //this is for an array of json file
        queue.add(jsonarrayrequest)
    }

}
