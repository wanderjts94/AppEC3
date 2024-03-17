package pe.edu.idat.appec3

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.appec3.databinding.ItemListaresenaBinding

class AdapterLista(val listaResena:List<Resena>,val context :Context)
    :RecyclerView.Adapter<AdapterLista.ViewHolder>(){
    inner class ViewHolder(val binding: ItemListaresenaBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListaresenaBinding
            .inflate(LayoutInflater.from(parent.context), parent ,false)

        return ViewHolder(binding)
    }

    override fun getItemCount()= listaResena.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listaResena[position]) {
                binding.tvparadero.text = paradero
                binding.tvok.text = fechaok
                binding.tvpasajeros.text = pasajeros
                binding.ivresena.setImageResource(img)
                binding.cvresena.setOnClickListener(View.OnClickListener {
                    Toast.makeText(context, "Click Item Reseña", Toast.LENGTH_LONG).show()
                })


            }
        }
    }

}
