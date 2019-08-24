package com.noname.basesample.model.usecases

import android.annotation.SuppressLint
import android.arch.lifecycle.MutableLiveData
import com.noname.task.datalayer.apidata.ServerGateway
import com.noname.task.datalayer.repositries.userlogin
import com.noname.task.model.entities.Login
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


@SuppressLint("CheckResult")
fun userLogin(serverGateway: ServerGateway, username:String, password:String, login: MutableLiveData<Login>, errorLiveData: MutableLiveData<Throwable>, loadingLivedata: MutableLiveData<Boolean>) {
    userlogin(serverGateway,username,password).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
        subscribe({login.postValue(it);
        loadingLivedata.postValue(false)},{
        errorLiveData.postValue(it);loadingLivedata.postValue(false) })
}


