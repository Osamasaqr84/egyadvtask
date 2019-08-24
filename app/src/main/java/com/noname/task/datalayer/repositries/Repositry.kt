package com.noname.task.datalayer.repositries

import com.noname.task.datalayer.apidata.ServerGateway
import com.noname.task.model.entities.Login
import io.reactivex.Observable

fun userlogin(server: ServerGateway, username:String, password:String): Observable<Login> {
    return server.login(username,password)
}

