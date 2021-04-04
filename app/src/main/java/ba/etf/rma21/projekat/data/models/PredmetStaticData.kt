package ba.etf.rma21.projekat.data.models

fun getPredmeti(): List<Predmet>{
    return listOf(Predmet("RMA", 2),
                  Predmet("OIS",2),
                  Predmet("TP",1),
                  Predmet("UUP", 1),
                  Predmet("RS", 1),
                  Predmet("NRS",2))
}


fun getUpisani(): List<Predmet>{
    return listOf(Predmet("RMA",2), Predmet("UUP", 1), Predmet("NRS", 2));
}