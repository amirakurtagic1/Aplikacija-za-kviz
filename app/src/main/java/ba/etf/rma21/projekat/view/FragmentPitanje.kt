package ba.etf.rma21.projekat.view

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.view.children
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ba.etf.rma21.projekat.MainActivity
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class FragmentPitanje(pitanje: Pitanje): Fragment(), AdapterView.OnItemClickListener {

    private lateinit var tekstPitanja: TextView
    private lateinit var odgovoriLista: ListView
    private lateinit var nav: NavigationView
    private var pitanje = pitanje



    private var arrayAdapter:ArrayAdapter<String>? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_pitanje, container, false)
        var proba = inflater.inflate(R.layout.fragment_pokusaj, container, false)

        tekstPitanja = view.findViewById(R.id.tekstPitanja)
        odgovoriLista = view.findViewById(R.id.odgovoriLista)
        nav = proba.findViewById(R.id.navigacijaPitanja)

        tekstPitanja.setText(pitanje.tekstPitanja)
        val listaPitanja = pitanje.opcije

    //    val listaPitanja = arrayOf(pitanje.opcije.get(0))

        val adapterLista = activity?.let {
            ArrayAdapter(
                it,
                R.layout.odgovor, listaPitanja
            )
        }
        odgovoriLista.adapter = adapterLista
        odgovoriLista.choiceMode = ListView.CHOICE_MODE_SINGLE
        odgovoriLista.onItemClickListener = this

        adapterLista?.setDropDownViewResource(R.layout.odgovor)

  //  arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, listaPitanja)


        return view;
    }

    companion object {
        fun newInstance(pitanje: Pitanje): FragmentPitanje = FragmentPitanje(pitanje);
    }


    @RequiresApi(Build.VERSION_CODES.Q)
    @SuppressLint("ResourceAsColor")
    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if (parent != null) {
            //println(parent.getItemAtPosition(position).toString() + " a pravi odgovor je: " + pitanje.tacan)
            if(position.equals(pitanje.tacan)) {
                parent.getChildAt(position).setBackgroundResource(R.color.correctAnswer)
                odgovoriLista.isEnabled = false
            }
            else{
                parent.getChildAt(position).setBackgroundResource(R.color.wrongAnswer)
                parent.getChildAt(pitanje.tacan).setBackgroundResource(R.color.correctAnswer)
                odgovoriLista.isEnabled = false;
            }
        }
    }
}