package com.phalder.shoestoreapp.shoelist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.phalder.shoestoreapp.R
import com.phalder.shoestoreapp.databinding.FragmentInstructionBinding
import com.phalder.shoestoreapp.databinding.ShoeListFragmentBinding
import com.phalder.shoestoreapp.models.Shoe

class ShoeListFragment : Fragment() {

    companion object {
        fun newInstance() = ShoeListFragment()
    }

    private lateinit var viewModel: ShoeListViewModel
    private lateinit var binding: ShoeListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.shoe_list_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel.shoeListLiveData.observe(viewLifecycleOwner, Observer { shoeList ->
            Log.i("ShoeListFragment", "Got Shoe List")
            updateShoeList(shoeList)
        })
    }

    private fun updateShoeList(shoeList: List<Shoe>) {
        for (shoe in shoeList) {
            var view: View = layoutInflater.inflate(R.layout.item_layout,null)
            var nameTV: TextView = view.findViewById(R.id.nameText)
            var companyTV: TextView = view.findViewById(R.id.companyText)

            binding.mainLayout.addView(view)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}