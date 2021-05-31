package ba.etf.rma21.projekat.data.models

import java.util.*

data class Kviz(
    val id: Int, val naziv: String, val datumPocetka: Date, val datumKraja: Date, val trajanje: Int
) {

}