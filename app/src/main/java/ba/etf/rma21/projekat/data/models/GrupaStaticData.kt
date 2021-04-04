package ba.etf.rma21.projekat.data.models

fun getGroups(): List<Grupa>{

    return listOf(Grupa("Grupa1", "RMA"),
                  Grupa("Grupa2", "RMA"),
            Grupa("Grupa1", "OIS"),
            Grupa("Grupa2", "OIS"),
            Grupa("Grupa3", "NRS"),
            Grupa("Grupa1", "NRS"),
            Grupa("Grupa2", "NRS"))
}