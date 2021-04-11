package ba.etf.rma21.projekat.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Kviz
import org.w3c.dom.Text

class KvizListAdapter(private var kvizovi: List<Kviz>): RecyclerView.Adapter<KvizListAdapter.MyViewHolder>() {


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nazivPredmeta: TextView = itemView.findViewById(R.id.predmet)
        var nazivKviza: TextView = itemView.findViewById(R.id.brojKviza)
        var datum: TextView = itemView.findViewById(R.id.datumKviza)
        var trajanjeKviza : TextView = itemView.findViewById(R.id.trajanjeKviza)
        var osvojeniBodovi: TextView = itemView.findViewById(R.id.osvojeniBodovi)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.kviz, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return kvizovi.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.nazivPredmeta.setText(kvizovi[position].nazivPredmeta)
        holder.nazivKviza.setText(kvizovi[position].naziv)
        holder.datum.setText(kvizovi[position].datumPocetka.toString())
        holder.trajanjeKviza.setText(kvizovi[position].trajanje.toString())
        holder.osvojeniBodovi.setText(kvizovi[position].osvojeniBodovi.toString())
    }

    fun updateKvizes(kvizovi: List<Kviz>) {
        this.kvizovi.toMutableList().clear()
        this.kvizovi = kvizovi
        notifyDataSetChanged()
    }

    fun filterKvizesByDate(kvizovi: List<Kviz>): List<Kviz> {

        //kvizovi.sortedWith(compareByDescending<Kviz> { it.datumPocetka.toString() })
        kvizovi.sortedBy { it.datumPocetka}
        return kvizovi
    }
}
