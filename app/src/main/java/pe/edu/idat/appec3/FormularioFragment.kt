package pe.edu.idat.appec3

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import pe.edu.idat.appec3.databinding.FragmentFormularioBinding

class FormularioFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentFormularioBinding

    private var ListaDatos = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFormularioBinding.inflate(inflater, container, false)
        binding.btnBuscar.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.btnBuscar -> {
                if (validarFormulario()) {
                    capturarDatos()
                    val bundle = Bundle().apply {
                        putStringArrayList("ListaDatos", ListaDatos)
                    }

                    val navOptions = NavOptions.Builder()
                        .setPopUpTo(R.id.formularioFragment, true)
                        .build()

                    findNavController().navigate(R.id.action_formularioFragment_to_resptFormFragment, bundle, navOptions)
                } else {
                    Toast.makeText(context, "Datos incompletos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



    private fun capturarDatos() {
        val distrito = binding.etDistrito.text.toString()
        val fechaInicio = binding.etInit.text.toString()
        val fechaFin = binding.etFi.text.toString()

        ListaDatos.clear()
        ListaDatos.add(distrito)
        ListaDatos.add(fechaInicio)
        ListaDatos.add(fechaFin)

        // Imprimir los datos usando Log.i
        // Ejemplo de salida (Villa el salvador, 24-05-2024, 24-08-2024)
        val datosString = ListaDatos.joinToString(separator = ", ")
        Log.i("ListaDatos", datosString)
    }

    private fun validarFormulario(): Boolean {
        val distrito = binding.etDistrito.text.toString()
        val fechaInicio = binding.etInit.text.toString()
        val fechaFin = binding.etFi.text.toString()

        return distrito.isNotEmpty() && fechaInicio.isNotEmpty() && fechaFin.isNotEmpty()
    }

}
