package cat.api.testapi.fragments

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cat.api.testapi.common.AuthorData
import cat.api.testapi.R
import cat.api.testapi.api.ApiActions
import cat.api.testapi.api.ServiceBuilder
import cat.api.testapi.common.AuthorAdapter
import cat.api.testapi.common.SharedViewModel
import cat.api.testapi.databinding.FragmentGetResultBinding
import retrofit2.Call
import retrofit2.Callback

class GetResultFragment : Fragment() {

    lateinit var progressDialog: ProgressDialog
    lateinit var recyclerView: RecyclerView

    //lateinit var adapter: AuthorAdapter
    lateinit var binding: FragmentGetResultBinding
    val model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    lateinit var authors: ArrayList<AuthorData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGetResultBinding>(
            inflater,
            R.layout.fragment_get_result, container, false
        )

        recyclerView = binding.authorRV
        recyclerView.adapter = AuthorAdapter(authors, requireContext())
        recyclerView.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)



        return binding.root
    }

    private fun getData() {
        //val call: Call<List<AuthorData>> = ApiClient.getClient.getPhotos()
        val retrofit = ServiceBuilder.buildService(ApiActions::class.java)
        //retrofit.
    }

}