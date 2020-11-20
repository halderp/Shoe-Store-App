package com.phalder.shoestoreapp.shoelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.phalder.shoestoreapp.R
import com.phalder.shoestoreapp.databinding.FragmentInstructionBinding
import com.phalder.shoestoreapp.databinding.ShoeListFragmentBinding
import com.phalder.shoestoreapp.models.Shoe

class ShoeListFragment : Fragment() {

    // View Model is based on Activity Scope. This ViewModel is shared between multiple activities.
    private val viewModel: ShoeListViewModel by activityViewModels()

    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.shoe_list_fragment, container, false)
        (activity as AppCompatActivity).supportActionBar?.title = "Shoe List"
        binding.floatingActionButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // TODO: Use the ViewModel
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->
            Log.i("ShoeListFragment", "Got Shoe List")
            updateShoeList(shoeList)
        })
    }

    private fun updateShoeList(shoeList: List<Shoe>) {
        for (shoe in shoeList) {
            var view: View = layoutInflater.inflate(R.layout.card_item_layout,null)
            var nameTV: TextView = view.findViewById(R.id.name_text)
            nameTV.text = shoe.name

            var companyTV: TextView = view.findViewById(R.id.company_text)
            companyTV.text = shoe.company

            var sizeTV: TextView = view.findViewById(R.id.size_text)
            sizeTV.text = shoe.size.toString()

            var descriptionTV: TextView = view.findViewById(R.id.description_text)
            descriptionTV.text = shoe.description
            
            binding.mainLayout.addView(view)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}