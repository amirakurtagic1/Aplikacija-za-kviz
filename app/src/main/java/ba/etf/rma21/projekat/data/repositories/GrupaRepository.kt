package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.getGroups

class GrupaRepository {
    companion object {
        init {
            var grupe: List<Grupa> = getGroups()
        }

        fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa> {
            var grupe: List<Grupa> = getGroups()
            var groupsByPredmet: List<Grupa> = emptyList()

            for(grupa in grupe){
                if(grupa.nazivPredmeta.equals(nazivPredmeta)) groupsByPredmet.toMutableList().add(grupa)
            }

            return groupsByPredmet
        }
    }
}