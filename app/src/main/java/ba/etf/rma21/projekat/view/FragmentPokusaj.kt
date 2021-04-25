package ba.etf.rma21.projekat.view

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ba.etf.rma21.projekat.MainActivity
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class FragmentPokusaj(listaPitanja: List<Pitanje>): Fragment() {


    private lateinit var navigacijaPitanja: NavigationView
    private lateinit var framePitanje: FrameLayout
    lateinit var context: AppCompatActivity

        private val procenatTacnosti: Int = 0
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.context = context as AppCompatActivity
    }
    private var listaPitanja = listaPitanja
    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_pokusaj, container, false)

        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.predajKviz -> {
                    var  mainActivity = activity as MainActivity
                    mainActivity.bottomNav.menu.findItem(R.id.kvizovi).setVisible(true);
                    mainActivity.bottomNav.menu.findItem(R.id.predmeti).setVisible(true);
                    mainActivity.bottomNav.menu.findItem(R.id.predajKviz).setVisible(false)
                    mainActivity.bottomNav.menu.findItem(R.id.zaustaviKviz).setVisible(false)
                    val fragmentPoruka = FragmentPoruka.newInstance("Završili ste kviz ${listaPitanja.get(0).naziv} sa tačnosti ");
                    activity?.supportFragmentManager?.beginTransaction()
                        ?.replace(R.id.placeforFragment, fragmentPoruka, "findThisFragment")
                        ?.addToBackStack(null)
                        ?.commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        if (activity is MainActivity) {
            var  mainActivity = activity as MainActivity
            mainActivity.prilagodiBottomNavigation()
            mainActivity.bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        }
        navigacijaPitanja = view.findViewById(R.id.navigacijaPitanja)
        framePitanje = view.findViewById(R.id.framePitanje)



        for(i in 0..listaPitanja.size-1){
            navigacijaPitanja.menu.add(R.menu.navigationview, i,Menu.NONE, (i+1).toString())
            //println("Menu item id:" + navigacijaPitanja.menu.get(i-1))
        }

        navigacijaPitanja.setItemBackgroundResource(R.color.black)
        navigacijaPitanja.setItemTextAppearance(R.color.white)

        navigacijaPitanja.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener {
            val fm = context.supportFragmentManager
            val fragmentTransaction: FragmentTransaction
            val fragment = FragmentPitanje(listaPitanja.get(it.itemId))
            val args = Bundle()
            args.putString("item", it.itemId.toString())
            fragment.setArguments(args)
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