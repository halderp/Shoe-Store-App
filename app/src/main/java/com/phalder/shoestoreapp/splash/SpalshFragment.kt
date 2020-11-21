package com.phalder.shoestoreapp.splash

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.phalder.shoestoreapp.R
import com.phalder.shoestoreapp.shoelist.ShoeListViewModel

/**
 * An example full-screen fragment that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SpalshFragment : Fragment() {

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?  ): View? {
        return inflater.inflate(R.layout.fragment_spalsh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.isLoggedInLiveData.observe(viewLifecycleOwner,{ isLoggedIn ->
            Log.i("SpalshFragment", "isLoggedIn")
            if (isLoggedIn == false){
                requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
                (activity as AppCompatActivity)?.supportActionBar?.show()
                view.findNavController().navigate(R.id.action_spalshFragment_to_loginFragment)
            }
        })
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        (activity as AppCompatActivity)?.supportActionBar?.hide()
    }

    override fun onDetach() {
        super.onDetach()

        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        (activity as AppCompatActivity)?.supportActionBar?.show()
    }
}