package com.example.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.facebook.login.LoginManager
import kotlinx.android.synthetic.main.fragment_profile.*

/**
 * A simple [Fragment] subclass.
 */
class Profile : Fragment() {

    var PhotoURL : String = ""
    var Name : String = ""
    var User : String = ""
    var Pass : String = ""

    fun newInstance(url: String,name : String): Profile {

        val profile = Profile()
        val bundle = Bundle()
        bundle.putString("PhotoURL", url)
        bundle.putString("Name", name)
        profile.setArguments(bundle)

        return profile
    }

    fun newInstance2(user: String, pass : String): Profile {

        val profile = Profile()
        val bundle = Bundle()
        bundle.putString("user", user)
        bundle.putString("pass", pass)
        profile.setArguments(bundle)

        return profile
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val ivProfilePicture = view.findViewById(R.id.iv_profile) as ImageView
        val tvName = view.findViewById(R.id.tv_name) as TextView
        val login_button2 = view.findViewById(R.id.login_button2) as Button
        val btnRecycler = view.findViewById(R.id.recycle) as Button
        val graph = view.findViewById(R.id.graph) as Button

        Glide.with(activity!!.baseContext)
            .load(PhotoURL)
            .into(ivProfilePicture)


        Name?.let{
            Toast.makeText(activity, "Name null!", Toast.LENGTH_SHORT).show()
            Name = User
        }

        tvName.setText(Name)

        login_button2.setOnClickListener{

            val fmAuthen= Authen()
            val mg = fragmentManager
            mg!!.beginTransaction().replace(R.id.layout, fmAuthen, "").commit()

//            LoginManager.getInstance().logOut()
//            activity!!.supportFragmentManager.popBackStack()
        }

        btnRecycler.setOnClickListener{

            val fmRecycler_view= Recycler_view()
            val mg = fragmentManager
            mg!!.beginTransaction().replace(R.id.layout, fmRecycler_view, "").addToBackStack("").commit()

//            LoginManager.getInstance().logOut()
//            activity!!.supportFragmentManager.popBackStack()
        }

        graph.setOnClickListener{

            val fmMainChart = MainChart()
            val mg = fragmentManager
            mg!!.beginTransaction().replace(R.id.layout, fmMainChart, "").addToBackStack("").commit()

//            LoginManager.getInstance().logOut()
//            activity!!.supportFragmentManager.popBackStack()
        }
        // Inflate the layout for this fragment
        return view

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val bundle = arguments
        if (bundle != null) {
            PhotoURL = bundle.getString("PhotoURL").toString()
            Name = bundle.getString("Name").toString()
            User = bundle.getString("user").toString()
            Pass = bundle.getString("pass").toString()
        }

    }

}
