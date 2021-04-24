package ba.etf.rma21.projekat.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ba.etf.rma21.projekat.MainActivity
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import ba.etf.rma21.projekat.data.repositories.PitanjaKvizRepository
import ba.etf.rma21.projekat.data.repositories.PitanjeKvizRepository
import com.google.android.material.navigation.NavigationView

class FragmentPokusaj(listaPitanja: List<Pitanje>): Fragment() {


    private lateinit var navigacijaPitanja: NavigationView
    private lateinit var framePitanje: FrameLayout
    lateinit var context: AppCompatActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context as AppCompatActivity
    }
    private var listaPitanja = listaPitanja
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_pokusaj, container, false)

        if (activity is MainActivity) {
            var  mainActivity = activity as MainActivity
            mainActivity.prilagodiBottomNavigation()
        }
        navigacijaPitanja = view.findViewById(R.id.navigacijaPitanja)
        framePitanje = view.findViewById(R.id.framePitanje)
        navigacijaPitanja.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            val fm = context.supportFragmentManager
            val fragmentTransaction: FragmentTransaction
            val fragment = FragmentPitanje(listaPitanja.get(it.title.toString().toInt() - 1))
            fragmentTransaction = fm.beginTransaction()
            fragmentTransaction.replace(R.id.framePitanje, fragment)
                .addToBackStack(null)
            fragmentTransaction.commit()
             true
        })



        return view;
    }

    companion object {
        fun newInstance(listaPitanja: List<Pitanje>): FragmentPokusaj = FragmentPokusaj(listaPitanja);
    }
}