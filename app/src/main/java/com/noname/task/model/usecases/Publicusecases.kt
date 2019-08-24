package com.noname.task.model.usecases

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import com.noname.basesample.R
import com.noname.basesample.presentation.main.main.MainFragment
import com.noname.task.datalayer.apidata.ApiClient
import com.noname.task.datalayer.apidata.ServerGateway
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

fun showToastBasedOnThrowable(context: Context?,throwable: Throwable?)
{
    var messege = "error occure"
    when (throwable) {
        is IOException -> messege="Something Went Wrong"
        is UnknownHostException ->messege= "No internet connectivity"
        is SocketTimeoutException ->messege= "Slow Internet connectivity"
        else -> throwable?.message
    }

    Toast.makeText(context,messege,Toast.LENGTH_SHORT).show()
}


val Context.isConnected: Boolean
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected == true
    }


@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun changecolor(context: Activity) {
    val window = context.getWindow()
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
    window.setStatusBarColor(ContextCompat.getColor(context, R.color.orange))
}

fun showDialog(activity: Activity) {
    AlertDialog.Builder(activity).apply {
       // val dialogView = activity.layoutInflater.inflate(R.layout.custom_dialog, null)
        //setView(dialogView)
        setTitle("Login Success")
        setMessage("click ok to complete...")
        setPositiveButton("Ok") { _, _ ->
            (activity as AppCompatActivity).supportFragmentManager.beginTransaction().add(R.id.main_fram,
                MainFragment(), "Main").commit()
        }
    }.create().show()
}


fun getServergetway () : ServerGateway
{
    return ApiClient.getClient().create(ServerGateway::class.java)
}




