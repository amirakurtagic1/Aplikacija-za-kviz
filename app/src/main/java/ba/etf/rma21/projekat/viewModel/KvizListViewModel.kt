package ba.etf.rma21.projekat.viewModel

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import kotlinx.coroutines.*

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

    val scope = CoroutineScope(Job() + Dispatchers.Main)
     fun getAll(onSuccess: (kvizovi: List<Kviz>?) -> Unit,
                       onError: () -> Unit){

        // Create a new coroutine on the UI thread
        scope.launch{

            // Make the network call and suspend execution until it finishes
            val result = KvizRepository.getAll()
            println(result)
            // Display result of the network request to the user
            when (result) {
                is List<Kviz>? -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }




    suspend fun getById(onSuccess: (kviz: Kviz) -> Unit,
                        onError: () -> Unit, kvizId: Int) {
        scope.launch{

            // Make the network call and suspend execution until it finishes
            val result = KvizRepository.getById(kvizId)
            println(result)
            // Display result of the network request to the user
            when (result) {
                is Kviz -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }

     fun getUpisani(onSuccess: (kvizovi: List<Kviz>?) -> Unit,
                           onError: () -> Unit) {
        scope.launch{

            // Make the network call and suspend execution until it finishes
            val result = KvizRepository.getUpisani()
            println(result)
            // Display result of the network request to the user
            when (result) {
                is List<Kviz>? -> onSuccess?.invoke(result)
                else-> onError?.invoke()
            }
        }
    }

    fun getMyDoneKvizes(onSuccess: (kvizovi: List<Kviz>?) -> Unit,
                        onError: () -> Unit) {
        scope.launch {

            // Make the network call and suspend execution until it finishes
            val result = KvizRepository.getMyDoneKvizes()
            println(result)
            // Display result of the network request to the user
            when (result) {
                is List<Kviz>? -> onSuccess?.invoke(result)
                else -> onError?.invoke()
            }
        }
    }

    fun getMyFutureKvizes(onSuccess: (kvizovi: List<Kviz>?) -> Unit,
                          onError: () -> Unit) {
        scope.launch {

            // Make the network call and suspend execution until it finishes
            val result = KvizRepository.getMyFutureKvizes()
            println(result)
            // Display result of the network request to the user
            when (result) {
                is List<Kviz>? -> onSuccess?.invoke(result)
                else -> onError?.invoke()
            }
        }
    }

    fun getMyNotTakenKvizes(onSuccess: (kvizovi: List<Kviz>?) -> Unit,
                            onError: () -> Unit) {
        scope.launch {

            // Make the network call and suspend execution until it finishes
            val result = KvizRepository.getMyNotTakenKvizes()
            println(result)
            // Display result of the network request to the user
            when (result) {
                is List<Kviz>? -> onSuccess?.invoke(result)
                else -> onError?.invoke()
            }
        }
    }
}