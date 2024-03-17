package pe.edu.idat.appec3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.appec3.databinding.FragmentListadoBinding


class ListadoFragment : Fragment() {
    private var _binding:FragmentListadoBinding?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListadoBinding.inflate(inflater,container,false)
        val view= binding.root
        val listaResena= obtenerResenas()
        binding.rvlista.layoutManager = LinearLayoutManager(context)
        binding.rvlista.adapter = AdapterLista(listaResena,requireContext())

        return view

    }
    private fun obtenerResenas(): List<Resena>{
        val listaResena = ArrayList<Resena>()
        listaResena.add(Resena("Paradero 1","OK: 12/10/2020 13:30","Pasajeros:2",R.drawable.paradero_1))
        return listaResena
    }



}