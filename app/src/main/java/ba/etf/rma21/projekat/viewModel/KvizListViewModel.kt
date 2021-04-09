package ba.etf.rma21.projekat.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.repositories.KvizRepository

class KvizListViewModel {
    @RequiresApi(Build.VERSION_CODES.O)
    fun getMyKvizes(): List<Kviz> {
        return KvizRepository.getMyKvizes()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getAll(): List<Kviz> {
        return KvizRepository.getAll()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getDone(): List<Kviz> {
        return KvizRepository.getDone()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getFuture(): List<Kviz> {
        return KvizRepository.getFuture()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getNotTaken(): List<Kviz> {
        return KvizRepository.getNotTaken()
    }
}