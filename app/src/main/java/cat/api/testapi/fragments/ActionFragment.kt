package cat.api.testapi.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.text.isDigitsOnly
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import cat.api.testapi.api.ApiActionService
import cat.api.testapi.common.AuthorData
import cat.api.testapi.R
import cat.api.testapi.common.SharedViewModel
import cat.api.testapi.databinding.FragmentActionBinding

class ActionFragment : Fragment() {

    lateinit var binding: FragmentActionBinding
    val model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentActionBinding>(
            inflater,
            R.layout.fragment_action, container, false
        )

        binding.postButton.setOnClickListener {
            if (binding.postInput.text.toString().isEmpty()) {
                Toast.makeText(context, "Cal omplir el camp", Toast.LENGTH_LONG)
                    .show()
            } else {
                postAuthor(binding.postInput.text.toString())
            }
        }

        binding.getButton.setOnClickListener {
            if (binding.getInput.text.isNullOrBlank()) {
                model.setId(-1)
                model.setNom("")
            } else {
                if (binding.getInput.text.toString().isDigitsOnly()) {
                    model.setId(binding.getInput.text.toString().toInt())
                    model.setNom("")
                }
                else {
                    model.setNom(binding.getInput.text.toString())
                    model.setId(-1)
                }
            }

            view?.findNavController()?.navigate(R.id.action_actionFragment_to_getResultFragment)

        }

        return binding.root
    }

    private fun postAuthor(name: String) {
        val apiService = ApiActionService()
        val autorInfo = AuthorData(idAutor = null, nomAutor = name)

        apiService.addAutor(autorInfo) {
            if (it?.idAutor != null) {
                // it = newly added user parsed as response
                // it?.id = newly added user ID
            } else {
                showAlert()
            }
        }
    }

    private fun showAlert() {
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle("Error")
        builder.setMessage("Error afegint al autor")
        builder.setPositiveButton("Tanca", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

}