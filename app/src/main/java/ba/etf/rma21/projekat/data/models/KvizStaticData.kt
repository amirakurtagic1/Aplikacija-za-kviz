package ba.etf.rma21.projekat.data.models

import android.annotation.SuppressLint
import android.os.Build
import android.util.Half.toFloat
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.util.*


fun kvizes(): List<Kviz>{
    val date = Date(3600000)

    return listOf(Kviz("Kviz1", "RMA", Date(1616662800000), Date(1617094800000), Date(1616922000000), 2, "Grupa1",(2.5).toFloat()),
            Kviz("Kviz2", "RMA", Date(1616662800000), Date(1617094800000), null, 2, "Grupa2", null),
            Kviz("Kviz3", "RMA", Date(1618909200000), Date(1619514000000), null, 2, "Grupa2", null),
            Kviz("Kviz1", "UUP", Date(1617267600000), Date(1617958800000), null, 5, "Grupa1", null),
            Kviz("Kviz2", "UUP", Date(1617354000000), Date(1617526800000), null, 5, "Grupa2", null),
            Kviz("Kviz1", "ASP", Date(1617526800000), Date(1618477200000), null, 10, "Grupa1", null),
            Kviz("Kviz2", "ASP", Date(1617613200000), Date(1618563600000), null, 10, "Grupa2",null),
            Kviz("Kviz1", "TP", Date(1616662800000), Date(1617354000000), null, 5, "Grupa1", null),
            Kviz("Kviz2", "TP", Date(1617008400000), Date(1617699600000), null, 5, "Grupa2", null),
            Kviz("Kviz1", "NRS", Date(1617613200000), Date(1618045200000), null, 7, "Grupa1", null),
            Kviz("Kviz2", "NRS", Date(1617613200000), Date(1618045200000), null, 7, "Grupa2", null),
            Kviz("Kviz1", "FWT", Date(1615798800000), Date(1616403600000), Date(1616073699000), 7, "Grupa1", (1.5).toFloat()),
            Kviz("Kviz1", "OIS", Date(1619168400000), Date(1619773200000), null, 7, "Grupa1", null),
            Kviz("Kviz2", "FWT", Date(1615971600000), Date(1616576400000), null, 7, "Grupa2", null),
            Kviz("Kviz2", "OIS", Date(1619082000000), Date(1619686800000), null, 7, "Grupa2", null),
            Kviz("Kviz1", "IM1", Date(1613984400000), Date(1614589200000), null, 7, "Grupa1", null),
            Kviz("Kviz2", "IM1", Date(1614157200000), Date(1614762000000), null, 7, "Grupa2", null)
            )
}

fun myKvizes(): List<Kviz>{
    val date = Date(3600000)
    return listOf(Kviz("Kviz1", "RMA", Date(1616662800000), Date(1617094800000), Date(1616922000000), 2, "Grupa1", (2.5).toFloat()),
            Kviz("Kviz3", "RMA", Date(1618909200000), Date(1619514000000), null, 2, "Grupa2", null),
            Kviz("Kviz1", "UUP", Date(1617267600000), Date(1617958800000), null, 5, "Grupa1", null),
            Kviz("Kviz1", "NRS", Date(1617613200000), Date(1618045200000), null, 7, "Grupa1", null))
}


fun doneKvizes(): List<Kviz>{
    var sviKvizovi: List<Kviz> = kvizes()
    var sviUradjeniKvizovi = emptyList<Kviz>()
    for(kviz in sviKvizovi) if(kviz.osvojeniBodovi !== null) sviUradjeniKvizovi += kviz;

    return sviUradjeniKvizovi
}

fun myDoneKvizes(): List<Kviz>{

    var mojiKvizovi: List<Kviz> = myKvizes()
    var uradjeniKvizovi: List<Kviz> = emptyList()

    for(kviz in mojiKvizovi) if(kviz.osvojeniBodovi !== null) uradjeniKvizovi += kviz

    return uradjeniKvizovi
}

fun futureKvizes(): List<Kviz>{
    var sviKvizovi: List<Kviz> = kvizes()
    var buduciKvizovi: List<Kviz> = emptyList()
    for(kviz in sviKvizovi) if(kviz.datumPocetka.after(Calendar.getInstance().time)) buduciKvizovi += kviz
    return buduciKvizovi
}

fun myFutureKvizes(): List<Kviz>{
    var mojiKvizovi: List<Kviz> = myKvizes()
    var buduciKvizovi: List<Kviz> = emptyList()
    for(kviz in mojiKvizovi) if(kviz.datumPocetka.after(Calendar.getInstance().time)) buduciKvizovi += kviz
    return buduciKvizovi
}

fun notTakenKvizes(): List<Kviz>{
    var sviKvizovi: List<Kviz> = kvizes()
    var prosliKvizoviNisuRadjeni: List<Kviz> = emptyList()

    for(kviz in sviKvizovi) {
        if(kviz.datumKraj.before(Calendar.getInstance().time) && kviz.osvojeniBodovi === null) {
            println("Dosao sam u funkciju notTakenKvizes")
            prosliKvizoviNisuRadjeni += kviz
        }
    }
    return prosliKvizoviNisuRadjeni
}


fun myNotTakenKvizes(): List<Kviz>{
    var mojiKvizovi: List<Kviz> = myKvizes()
    var prosliKvizoviNisuRadjeni: List<Kviz> = emptyList()

    for(kviz in mojiKvizovi) {
        if(kviz.datumKraj.before(Calendar.getInstance().time) && kviz.osvojeniBodovi === null) {
           // println("Dosao sam u funkciju notTakenKvizes")
            prosliKvizoviNisuRadjeni += kviz
        }
    }
    return prosliKvizoviNisuRadjeni
}


fun parseFloat(double: Double): Float {
    return parseFloat(double)
}