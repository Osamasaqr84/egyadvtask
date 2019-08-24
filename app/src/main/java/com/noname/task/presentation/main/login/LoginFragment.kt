package com.noname.task.presentation.main.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.noname.basesample.R
import com.noname.task.model.usecases.showDialog
import com.noname.task.model.usecases.showToastBasedOnThrowable
import kotlinx.android.synthetic.main.login_fragment.*
import kotlinx.android.synthetic.main.login_fragment.view.*

class LoginFragment : Fragment() {

    val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        val view =  inflater.inflate(R.layout.login_fragment, container, false)
        view.login.setOnClickListener { viewModel.login(view.username.text.toString(),view.password.text.toString()) }

        ///observe livedata
        viewModel.loadingLivedat.observe(this, Observer { loading -> progress.setVisibility(if (loading!!) View.VISIBLE else View.GONE) })
        viewModel.errorMessage.observe(this, Observer { Toast.makeText(activity,it, Toast.LENGTH_SHORT).show() })
        viewModel.errorLivedat.observe(this, Observer {  showToastBasedOnThrowable(activity,it) })

        viewModel.login.observe(this, Observer {
            if (it?.status==1)////when success
            {
                Toast.makeText(activity,"success",Toast.LENGTH_SHORT).show()
                activity?.let { it1 -> showDialog(it1) }
            }
            else
                Toast.makeText(activity,it?.message,Toast.LENGTH_SHORT).show()
        })

        return  view
    }

}
