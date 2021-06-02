package ba.etf.rma21.projekat.view

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.UpisPredmet
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.repositories.PitanjeKvizRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class KvizListAdapter(private var kvizovi: List<Kviz>): RecyclerView.Adapter<KvizListAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var nazivPredmeta: TextView = itemView.findViewById(R.id.predmet)
        var nazivKviza: TextView = itemView.findViewById(R.id.brojKviza)
        var datum: TextView = itemView.findViewById(R.id.datumKviza)
        var trajanjeKviza : TextView = itemView.findViewById(R.id.trajanjeKviza)
        var osvojeniBodovi: TextView = itemView.findViewById(R.id.osvojeniBodovi)
        var imgView: ImageView = itemView.findViewById(R.id.bojaKruga)

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
/*
        val dateFormat = SimpleDateFormat("dd.MM.yyyy")
        holder.nazivPredmeta.setText(kvizovi[position].nazivPredmeta)
        holder.nazivKviza.setText(kvizovi[position].naziv)
        //holder.datum.setText(dateFormat.format(kvizovi[position].datumPocetka))
        holder.trajanjeKviza.setText(kvizovi[position].trajanje.toString() + " min")
        if (kvizovi[position].osvojeniBodovi === null) holder.osvojeniBodovi.setText("")
        else holder.osvojeniBodovi.setText(kvizovi[position].osvojeniBodovi.toString())

        if (kvizovi[position].datumRada !== null) {
            holder.datum.setText(dateFormat.format(kvizovi[position].datumRada))
            holder.imgView.setImageResource(R.drawable.plava)
        }
        else if (kvizovi[position].datumPocetka.before(Calendar.getInstance().time) && kvizovi[position].datumKraj.after(Calendar.getInstance().time) && kvizovi[position].datumRada === null) {
            holder.datum.setText(dateFormat.format(kvizovi[position].datumKraj))
            holder.imgView.setImageResource(R.drawable.zelena)
        }
        else if(kvizovi[position].datumPocetka.after(Calendar.getInstance().time)) {
            holder.datum.setText(dateFormat.format(kvizovi[position].datumPocetka))
            holder.imgView.setImageResource(R.drawable.zuta)
        }
        else if(kvizovi[position].datumKraj.before(Calendar.getInstance().time) && kvizovi[position].datumRada === null) {
            holder.datum.setText(dateFormat.format(kvizovi[position].datumKraj))
            holder.imgView.setImageResource(R.drawable.crvena)
        }
        holder.itemView.setOnClickListener{
            val fragmentPokusaj = FragmentPokusaj(PitanjeKvizRepository.getPitanja(kvizovi[position].naziv,kvizovi[position].nazivPredmeta))
                val appCompatActivity = it.context as AppCompatActivity
                    appCompatActivity.supportFragmentManager.
                    beginTransaction()
                        .replace(R.id.placeforFragment, fragmentPokusaj)
                        .addToBackStack(null)
                        .commit()
        }*/


    }
/*
    fun updateKvizes(kvizovi: List<Kviz>) {
        this.kvizovi.toMutableList().clear()
        this.kvizovi = kvizovi
        notifyDataSetChanged()
    }

    fun filterKvizesByDate(kvizovi: List<Kviz>): List<Kviz> {

        //kvizovi.sortedWith(compareByDescending<Kviz> { it.datumPocetka.toString() })
        kvizovi.sortedBy { it.datumPocetka}
        return kvizovi
    }*/
}
