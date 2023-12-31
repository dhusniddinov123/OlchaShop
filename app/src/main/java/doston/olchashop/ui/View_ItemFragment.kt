package doston.olchashop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import doston.olchashop.R
import doston.olchashop.ViewPagerAdapter
import doston.olchashop.database.AppDataBase
import doston.olchashop.databinding.FragmentViewItemBinding
import doston.olchashop.model.Product

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [View_ItemFragment.newInstance] factory method to
 * create an instance of this fragment.
 */


class View_ItemFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: Product? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getSerializable(ARG_PARAM1) as Product
            param2 = it.getString(ARG_PARAM2)
        }
    }

    val appDatabase: AppDataBase by lazy {
        AppDataBase.getInstance(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentViewItemBinding.inflate(inflater, container, false)

//        binding.productImg.load(param1!!.thumbnail)

        var adapter = ViewPagerAdapter(param1!!.images)

        binding.productImgViewPager.adapter = adapter

        binding.namae.setText(param1!!.title)
        binding.desc.setText(param1!!.description)
        val user = appDatabase.getUserDao().getUser()
        binding.cart.setOnClickListener {

            if (user.get(user.size - 1).name == "") {
                parentFragmentManager.beginTransaction().replace(R.id.main,LoginFragment()).addToBackStack("Product").commit()
            } else {
                parentFragmentManager.beginTransaction().replace(R.id.main,CartFragment()).addToBackStack("Product").commit()

            }
        }


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment View_ItemFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: Product) =
            View_ItemFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_PARAM1,param1)

                }
            }
    }
}