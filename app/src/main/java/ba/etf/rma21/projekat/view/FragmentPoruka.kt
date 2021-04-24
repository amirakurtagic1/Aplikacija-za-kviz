package ba.etf.rma21.projekat.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ba.etf.rma21.projekat.R
import ba.etf.rma21.projekat.data.models.Grupa

class FragmentPoruka(string: String): Fragment() {

    private lateinit var txtView: TextView
    private var poruka =string

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_poruka, container, false)
        txtView = view.findViewById(R.id.tvPoruka)
        txtView.setText(poruka)
            return view
    }
    companion object {
        fun newInstance(string:String): FragmentPoruka = FragmentPoruka(string).apply {
            arguments = Bundle().apply {
                putString("message", string)
            }
        }
    }

}