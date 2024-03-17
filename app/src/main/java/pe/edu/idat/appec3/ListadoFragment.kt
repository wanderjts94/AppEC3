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
        listaResena.add(Resena("Paradero 1","OK: 12/12/2023 13:30","Pasajeros:2",R.drawable.paradero_1))
        listaResena.add(Resena("Paradero 2","OK: 13/12/2023 15:30","Pasajeros:5",R.drawable.paradero_2))
        listaResena.add(Resena("Paradero 3","OK: 16/12/2023 18:00","Pasajeros:15",R.drawable.paradero_3))
        listaResena.add(Resena("Paradero 4","OK: 18/12/2023 17:30","Pasajeros:20",R.drawable.paradero_4))
        listaResena.add(Resena("Paradero 5","OK: 21/12/2023 12:30","Pasajeros:28",R.drawable.paradero_5))
        listaResena.add(Resena("Paradero 6","OK: 25/12/2023 11:20","Pasajeros:19",R.drawable.paradero_6))
        listaResena.add(Resena("Paradero 7","OK: 28/12/2023 15:00","Pasajeros:8",R.drawable.paradero_7))
        listaResena.add(Resena("Paradero 8","OK: 01/02/2024 19:00","Pasajeros:17",R.drawable.paradero_8))
        listaResena.add(Resena("Paradero 9","OK: 05/03/2024 20:45","Pasajeros:26",R.drawable.paradero_9))
        listaResena.add(Resena("Paradero 10","OK: 17/03/2024 17:10","Pasajeros:15",R.drawable.paradero_10))
        return listaResena
    }



}