package ba.etf.rma21.projekat.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.MainActivity
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Pitanje
import com.google.android.material.navigation.NavigationView

class FragmentPokusaj(listaPitanja: List<Pitanje>): Fragment() {
    protected open var bottomNavigationViewVisibility = View.VISIBLE


    private lateinit var navigacijaPitanja: NavigationView
    private lateinit var framePitanje: FrameLayout
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


        return view;
    }

    companion object {
        fun newInstance(listaPitanja: List<Pitanje>): FragmentPokusaj = FragmentPokusaj(listaPitanja);
    }
}