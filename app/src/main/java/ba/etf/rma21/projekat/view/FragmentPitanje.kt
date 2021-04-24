package ba.etf.rma21.projekat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje

class FragmentPitanje(pitanje: Pitanje): Fragment() {

    private lateinit var tekstPitanja: TextView
    private lateinit var odgovoriLista: ListView
    private var pitanje = pitanje
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_pitanje, container, false)

        tekstPitanja = view.findViewById(R.id.tekstPitanja)
        odgovoriLista = view.findViewById(R.id.odgovoriLista)

        tekstPitanja.setText(pitanje.tekst)
        val arrayAdapter: ArrayAdapter<*>
        val listaPitanja = pitanje.opcije

        val adapterLista = activity?.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_list_item_1, listaPitanja
            )
        }
        odgovoriLista.adapter = adapterLista

        return view;
    }

    companion object {
        fun newInstance(pitanje: Pitanje): FragmentPitanje = FragmentPitanje(pitanje);
    }
}