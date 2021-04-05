package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.groups
import ba.etf.rma21.projekat.data.models.groupsByPredmet

class GrupaRepository {
    companion object {
        init {

        }

        fun getGroups(): List<Grupa>{
            return groups()
        }


        fun getGroupsByPredmet(nazivPredmeta: String): List<Grupa> {
            return groupsByPredmet(nazivPredmeta)
        }
    }
}