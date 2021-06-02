package ba.etf.rma21.projekat

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Kviz
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.KvizRepository
import ba.etf.rma21.projekat.viewModel.KvizListViewModel
import org.junit.Assert
import org.junit.Test
import java.util.*
/*
class ListaFiltriranihKvizovaUnitTest {
    @Test
    fun dohvatiSveKvizove() {

        Assert.assertEquals(17, KvizRepository.getAll().size)
    }

    @Test
    fun dohvatiMojeSveProsleKvizove(){

        var brojac = 0
        var kvizovi: List<Kviz> = KvizRepository.getMyKvizes()

        for(kviz in kvizovi){
            if(kviz.datumKraj.before(Calendar.getInstance().time) && kviz.osvojeniBodovi == null) brojac++;
        }

        Assert.assertEquals(brojac, KvizRepository.getMyNotTakenKvizes().size)
    }

    @Test
    fun dohvatiMojeBuduceKvizove(){

        var buduciKvizovi: List<Kviz> = emptyList()
        buduciKvizovi +=Kviz("Kviz3", "RMA", Date(1618909200000), Date(1619514000000), null, 2, "Grupa2", null)

     //   Assert.assertSame(buduciKvizovi, KvizRepository.getMyFutureKvizes())
        Assert.assertEquals(buduciKvizovi, KvizRepository.getMyFutureKvizes())

  /*  }

    @Test
    fun dohvatiSveMojeUradjeneKvizove() {

        Assert.assertEquals(1, KvizRepository.getMyDoneKvizes().size)
        Assert.assertEquals((2.5).toFloat(), KvizRepository.getMyDoneKvizes()[0].osvojeniBodovi)
        Assert.assertEquals("RMA", KvizRepository.getMyDoneKvizes()[0].nazivPredmeta)
    }

    @Test
    fun dohvatiMojeKvizoveKadSeDodaNovi(){
        KvizRepository.addKviz(Predmet("OIS",2), Grupa("Grupa2","OIS"))
        Assert.assertEquals(5, KvizRepository.getMyKvizes().size)
        Assert.assertEquals(Kviz("Kviz2", "OIS", Date(1619082000000), Date(1619686800000), null, 7, "Grupa2", null), KvizRepository.getMyKvizes()[KvizRepository.getMyKvizes().lastIndex])
    }

}*/