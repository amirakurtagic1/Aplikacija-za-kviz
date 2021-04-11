package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.PredmetRepository

class PredmetListViewModel {

    fun addPredmetToUpisani(predmet: Predmet){
        return PredmetRepository.addPredmetToUpisani(predmet)
    }

    fun getUpisani(): List<Predmet> {
        return PredmetRepository.getUpisani()
    }

    fun getAll(): List<Predmet> {
        return PredmetRepository.getAll()
    }

    fun getPredmetsByGodina(godina: Int): List<Predmet> {
        return PredmetRepository.getPredmetsByGodina(godina)
    }
}