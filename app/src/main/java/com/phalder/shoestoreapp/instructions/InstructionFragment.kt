package com.phalder.shoestoreapp.instructions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.phalder.shoestoreapp.R
import com.phalder.shoestoreapp.databinding.FragmentInstructionBinding
import com.phalder.shoestoreapp.databinding.FragmentLoginBinding


/**
 * A simple [Fragment] subclass.
 * Use the [InstructionFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class InstructionFragment : Fragment() {

    private lateinit var binding: FragmentInstructionBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_instruction, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Instructions"
        return binding.root
    }


}