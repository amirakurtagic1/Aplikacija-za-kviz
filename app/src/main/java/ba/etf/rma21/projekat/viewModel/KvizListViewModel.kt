package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.KvizRepository

class KvizListViewModel {
    /*fun getMyKvizes(): List<Kviz> {
        return KvizRepository.getMyKvizes()
    }

    fun getAll(): List<Kviz> {
        return KvizRepository.getAll()
    }

    fun getDone(): List<Kviz>{
        return KvizRepository.getDone()
    }

    fun getMyDoneKvizes(): List<Kviz> {
        return KvizRepository.getMyDoneKvizes()
    }

    fun getFuture(): List<Kviz>{
        return KvizRepository.getFuture()
    }

    fun getMyFutureKvizes(): List<Kviz> {
        return KvizRepository.getMyFutureKvizes()
    }

    fun getNotTaken(): List<Kviz>{
        return KvizRepository.getNotTaken()
    }

    fun getMyNotTakenKvizes(): List<Kviz> {
        return KvizRepository.getMyNotTakenKvizes()
    }

    fun addKvizToMyKvizes(predmet: Predmet, grupa: Grupa){
         KvizRepository.addKviz(predmet, grupa)
    }*/

    fun getAll(): List<Kviz> {
        return KvizRepository.getAll();
    }

    fun getById(id: Int): Kviz? {
        return KvizRepository.getById(id);
    }

    fun getUpisani(): List<Kviz> {
        return KvizRepository.getUpisani();
    }
}