package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Pitanje

class PitanjeKvizRepository {
    companion object {
        fun getPitanja(nazivKviza: String, nazivPredmeta: String): List<Pitanje> {
            return listOf(Pitanje("Pitanje1", "Ovo je prvo pitanje?", listOf("Odgovor1", "Odgovor2", "Tacan"), 2),
                          Pitanje("Pitanje2", "Ovo je drugo pitanje?", listOf("Tacan", "Odgovor2", "Odgovor3"), 0),
                          Pitanje("Pitanje3", "Ovo je trece pitanje?", listOf("Odgovor1", "Tacan", "Odgovor3"), 1))
        }
    }
}