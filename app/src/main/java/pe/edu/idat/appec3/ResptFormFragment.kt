package pe.edu.idat.appec3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import pe.edu.idat.appec3.databinding.FragmentResptFormBinding

class ResptFormFragment : Fragment() {

    private lateinit var binding: FragmentResptFormBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResptFormBinding.inflate(layoutInflater)

        val ListaDatos = arguments?.getStringArrayList("ListaDatos")

        ListaDatos?.let {
            val adapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_list_item_1,
                it
            )
            binding.lvDatos.adapter = adapter
        }

        return binding.root
    }
}
