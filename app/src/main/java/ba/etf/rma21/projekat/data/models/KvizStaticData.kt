package ba.etf.rma21.projekat.data.models

import android.annotation.SuppressLint
import android.os.Build
import android.util.Half.toFloat
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*
import java.util.EnumSet.of
import java.util.List.of

@SuppressLint("HalfFloat")
@RequiresApi(Build.VERSION_CODES.O)
fun kvizes(): List<Kviz>{
    val date = Date(3600000)
    return listOf(Kviz("Kviz1", "RMA", Date(1616662800000), Date(1617094800000), Date(1616922000000), 2, "Grupa1", toFloat((2.5).toShort())),
            Kviz("Kviz2", "RMA", Date(1616662800000), Date(1617094800000), date, 2, "Grupa2", toFloat((-1.0).toShort())),
             Kviz("Kviz3", "RMA", Date(1618909200000), Date(1619514000000), date, 2, "Grupa2", toFloat((-1.0).toShort())),
            Kviz("Kviz1", "UUP", Date(1617267600000), Date(1617958800000), date, 5, "Grupa1", toFloat((-1.0).toShort())),
            Kviz("Kviz2", "UUP", Date(1617354000000), Date(1617526800000), date, 5, "Grupa2", toFloat((-1.0).toShort())),
            Kviz("Kviz1", "ASP", Date(1617526800000), Date(1618477200000), date, 10, "Grupa1", toFloat((-1.0).toShort())),
            Kviz("Kviz2", "ASP", Date(1617613200000), Date(1618563600000), date, 10, "Grupa2", toFloat((-1.0).toShort())),
            Kviz("Kviz1", "TP", Date(1616662800000), Date(1617354000000), date, 5, "Grupa1", toFloat((-1.0).toShort())),
            Kviz("Kviz2", "TP", Date(1617008400000), Date(1617699600000), date, 5, "Grupa2", toFloat((-1.0).toShort())),
            Kviz("Kviz1", "NRS", Date(1617613200000), Date(1618045200000), date, 7, "Grupa1", toFloat((-1.0).toShort())),
            Kviz("Kviz2", "NRS", Date(1617613200000), Date(1618045200000), date, 7, "Grupa2", toFloat((-1.0).toShort()))
            )
}

@SuppressLint("HalfFloat")
@RequiresApi(Build.VERSION_CODES.O)
fun myKvizes(): List<Kviz>{
    val date = Date(3600000)
    return listOf(Kviz("Kviz1", "RMA", Date(1616662800000), Date(1617094800000), Date(1616922000000), 2, "Grupa1", toFloat((2.5).toShort())),
            Kviz("Kviz3", "RMA", Date(1618909200000), Date(1619514000000), date, 2, "Grupa2", toFloat((-1.0).toShort())),
            Kviz("Kviz1", "UUP", Date(1617267600000), Date(1617958800000), date, 5, "Grupa1", toFloat((-1.0).toShort())),
            Kviz("Kviz1", "NRS", Date(1617613200000), Date(1618045200000), date, 7, "Grupa1", toFloat((-1.0).toShort())))
}

@RequiresApi(Build.VERSION_CODES.O)
fun doneKvizes(): List<Kviz>{

    var mojiKvizovi: List<Kviz> = myKvizes()
    var uradjeniKvizovi: List<Kviz> = emptyList()

    for(kviz in mojiKvizovi) if(kviz.osvojeniBodovi >= 0) uradjeniKvizovi += kviz

    return uradjeniKvizovi
}

@RequiresApi(Build.VERSION_CODES.O)
fun futureKvizes(): List<Kviz>{
    var mojiKvizovi: List<Kviz> = myKvizes()
    var buduciKvizovi: List<Kviz> = emptyList()
    for(kviz in mojiKvizovi) if(kviz.datumPocetka.after(Calendar.getInstance().time)) buduciKvizovi += kviz
    return buduciKvizovi
}

@SuppressLint("HalfFloat")
@RequiresApi(Build.VERSION_CODES.O)
fun notTakenKvizes(): List<Kviz>{
    var mojiKvizovi: List<Kviz> = myKvizes()
    var prosliKvizoviNisuRadjeni: List<Kviz> = emptyList()

    for(kviz in mojiKvizovi) {
        if(kviz.datumKraj.before(Calendar.getInstance().time) && kviz.osvojeniBodovi.equals(toFloat((-1.0).toShort()))) {
            println("Dosao sam u funkciju notTakenKvizes")
            prosliKvizoviNisuRadjeni += kviz
        }
    }

    return prosliKvizoviNisuRadjeni
}


fun parseFloat(double: Double): Float {
    return parseFloat(double)
}