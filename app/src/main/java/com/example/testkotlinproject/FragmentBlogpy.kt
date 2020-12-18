package com.example.testkotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testkotlinproject.databinding.FragmentBlogpyBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentBlogpy.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentBlogpy : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var mBinding: FragmentBlogpyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_blogpy, container, false)
        mBinding = FragmentBlogpyBinding.bind(view)

        val modelList = ArrayList<Model>()
        Collections.addAll(modelList,
            Model("title1", "description1"),
            Model("title2", "description2"),
            Model("title3", "description3"),
            Model("title4", "description4"),
            Model("title5", "description5"),
            Model("title6", "description6"))


        val mAdapter = RecyclerAdapter(activity as MainActivity, modelList)

        mBinding.rv.apply {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentBlogpy.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentBlogpy().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}