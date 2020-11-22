package com.phalder.shoestoreapp.shoelist

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
import com.phalder.shoestoreapp.databinding.FragmentShoeDetailBinding
import com.phalder.shoestoreapp.databinding.ShoeListFragmentBinding
import com.phalder.shoestoreapp.models.Shoe


/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    // View Model is based on Activity Scope. This ViewModel is shared between multiple activities.
    private val viewModel: ShoeListViewModel by activityViewModels()
    private lateinit var binding: FragmentShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_shoe_detail, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Add Shoe"

        binding.shoelistVM = viewModel
        binding.setLifecycleOwner (this)

        binding.buttonCancel.setOnClickListener {view: View ->
            goBackToShoeList(view)
        }
        binding.buttonSave.setOnClickListener {view: View ->
            saveNewShoeAndGoBackToShoeList(view)
        }
        return binding.root
    }

    private fun goBackToShoeList(view: View){
        view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
    }


    private fun saveNewShoeAndGoBackToShoeList(view: View) {
            viewModel.addShoeToList()
            goBackToShoeList(view)
    }

}