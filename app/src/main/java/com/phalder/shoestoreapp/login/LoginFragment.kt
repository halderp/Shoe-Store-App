package com.phalder.shoestoreapp.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.phalder.shoestoreapp.R
import com.phalder.shoestoreapp.databinding.FragmentLoginBinding
import com.phalder.shoestoreapp.shoelist.ShoeListViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_login, container, false)

        binding.loginButton.setOnClickListener {view: View ->
            finishLogIn(view)
        }
        binding.loginExisting.setOnClickListener {view: View ->
            finishLogIn(view)
        }
        return binding.root
    }

    private fun finishLogIn(view: View) {
        viewModel.logInCompleted()
        view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
    }

}