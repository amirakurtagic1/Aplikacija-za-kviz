package ba.etf.rma21.projekat.data.models

fun groups(): List<Grupa>{
    return listOf(Grupa("Grupa1", "RMA"),
            Grupa("Grupa2", "RMA"),
            Grupa("Grupa1", "OIS"),
            Grupa("Grupa2", "OIS"),
            Grupa("Grupa1", "NRS"),
            Grupa("Grupa2", "NRS"),
            Grupa("Grupa3", "NRS"),
            Grupa("Grupa1", "TP"),
            Grupa("Grupa2", "TP"),
            Grupa("Grupa1", "UUP"),
            Grupa("Grupa2", "UUP"),
            Grupa("Grupa1", "RS"),
            Grupa("Grupa2", "RS"),
            Grupa("Grupa1", "FWT"),
            Grupa("Grupa2", "FWT"),
            Grupa("Grupa1", "RP"),
            Grupa("Grupa2", "RP"),
            Grupa("Grupa1", "PJP"),
            Grupa("Grupa2", "PJP"),
            Grupa("Grupa1", "ASP"),
            Grupa("Grupa2", "ASP"),
            Grupa("Grupa1", "IM1"),
            Grupa("Grupa2", "IM1"),
            Grupa("Grupa1", "IM2"),
            Grupa("Grupa2", "IM2"),
            Grupa("Grupa1", "MLTI"),
            Grupa("Grupa2", "MLTI")
    )
}


fun groupsByPredmet(nazivPredmeta: String): List<Grupa>{
    var grupe: List<Grupa> = groups()
    var groupsByPredmet: List<Grupa> = emptyList()

    for(grupa in grupe){
        if(grupa.nazivPredmeta.equals(nazivPredmeta)) groupsByPredmet += grupa
    }
    return groupsByPredmet
}
