package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.models.predmeti
import ba.etf.rma21.projekat.data.models.predmetiByGodina
import ba.etf.rma21.projekat.data.models.upisani

class PredmetRepository {
    companion object {
        fun getUpisani(): List<Predmet> {
            var getUpisani: List<Predmet> = upisani()
            return getUpisani
        }

        fun getAll(): List<Predmet> {
            var getAll: List<Predmet> = predmeti()
            return getAll
        }

        fun getPredmetsByGodina(godina: Int): List<Predmet>{
            return predmetiByGodina(godina)
        }
        // TODO: Implementirati i ostale potrebne metode
    }

}