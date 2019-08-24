package com.noname.task.presentation.main.login

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import com.noname.basesample.R
import com.noname.basesample.model.usecases.userLogin
import com.noname.task.model.entities.Login
import com.noname.task.model.entities.UserLogin
import com.noname.task.model.helper.MyApplication.context
import com.noname.task.model.usecases.getServergetway

class LoginViewModel : ViewModel() {

    val login: MutableLiveData<Login> = MutableLiveData()
    val errorLivedat: MutableLiveData<Throwable> = MutableLiveData()
    val loadingLivedat: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()


    fun login (usernam:String,password:String)
    {
        if (validate(UserLogin(usernam,password))) {
            loadingLivedat.postValue(true)
            userLogin(getServergetway(), usernam, password, login, errorLivedat, loadingLivedat)
        }
    }

    private fun validate(user: UserLogin): Boolean {
        if (user.username.trim() == "" || user.pass.trim() =="") {
            errorMessage.postValue(context.getText(R.string.complete).toString())
            return false
        } else
            return true
    }

}
