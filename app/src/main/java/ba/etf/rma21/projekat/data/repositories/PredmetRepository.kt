package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.models.getPredmeti

class PredmetRepository {
    companion object {
        fun getUpisani(): List<Predmet> {
            var getUpisani: List<Predmet> = getUpisani()
            return getUpisani
        }

        fun getAll(): List<Predmet> {
            var getAll: List<Predmet> = getPredmeti()
            return getAll
        }
        // TODO: Implementirati i ostale potrebne metode
    }

}