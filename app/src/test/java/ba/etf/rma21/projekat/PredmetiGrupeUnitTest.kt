package ba.etf.rma21.projekat

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet
import ba.etf.rma21.projekat.data.repositories.GrupaRepository
import ba.etf.rma21.projekat.data.repositories.PredmetRepository
import ba.etf.rma21.projekat.viewModel.PredmetListViewModel
import org.junit.Assert
import org.junit.Test

class PredmetiGrupeUnitTest {

    @Test
    fun listaPredmetaPoGodini(){

        Assert.assertEquals(3, PredmetRepository.getPredmetsByGodina(1).size)
        Assert.assertEquals(4, PredmetRepository.getPredmetsByGodina(2).size)
        Assert.assertEquals(1, PredmetRepository.getPredmetsByGodina(3).size)
        Assert.assertEquals(0, PredmetRepository.getPredmetsByGodina(4).size)
        Assert.assertEquals(0, PredmetRepository.getPredmetsByGodina(5).size)
    }

    @Test
    fun predmetiPoGodini(){

        var predmetiSaPrveGodine: List<Predmet> = listOf(Predmet("TP",1),
            Predmet("UUP", 1),
            Predmet("FWT", 1))

        Assert.assertEquals(predmetiSaPrveGodine, PredmetRepository.getPredmetsByGodina(1))
    }

    @Test
    fun predmetiPoGodini2() {
        var predmetiSaDrugeGodine: List<Predmet> = listOf(Predmet("RMA",2),
            Predmet("OIS", 2),
            Predmet("ASP", 2),
            Predmet("NRS",2))

        Assert.assertEquals(predmetiSaDrugeGodine, PredmetRepository.getPredmetsByGodina(2))
    }

    @Test
    fun predmetiPoGodini3() {
        var predmetiSaTreceGodine: List<Predmet> = listOf(Predmet("IM1", 3))

        Assert.assertEquals(predmetiSaTreceGodine, PredmetRepository.getPredmetsByGodina(3))
    }

    @Test
    fun predmetiPoGodini4(){
        var predmetiSaCetvrteGodine: List<Predmet> = emptyList()

        Assert.assertEquals(predmetiSaCetvrteGodine, PredmetRepository.getPredmetsByGodina(4))
    }

    @Test
    fun grupeOdPredmetaRMA() {

        var grupeRMA: List<Grupa> = listOf(Grupa("Grupa1","RMA"), Grupa("Grupa2", "RMA"))

        Assert.assertEquals(2, GrupaRepository.getGroupsByPredmet("RMA").size)
        Assert.assertEquals(grupeRMA, GrupaRepository.getGroupsByPredmet("RMA"))

    }

    @Test
    fun grupeOdPredmetaNRS() {

        var grupeNRS: List<Grupa> = listOf(Grupa("Grupa1","NRS"), Grupa("Grupa2", "NRS"), Grupa("Grupa3", "NRS"))

        Assert.assertEquals(3, GrupaRepository.getGroupsByPredmet("NRS").size)
        Assert.assertEquals(grupeNRS, GrupaRepository.getGroupsByPredmet("NRS"))
    }

    @Test
    fun upisaniPredmetiIDodatniPredmet() {
        var listaPredmeta: List<Predmet> = listOf(Predmet("RMA",2), Predmet("UUP", 1), Predmet("NRS", 2))

        Assert.assertEquals(listaPredmeta.size, PredmetRepository.getUpisani().size)
        Assert.assertEquals(listaPredmeta, PredmetRepository.getUpisani())

        PredmetRepository.addPredmetToUpisani(Predmet("OIS",2))
        listaPredmeta += Predmet("OIS",2)

        Assert.assertEquals(listaPredmeta.size, PredmetRepository.getUpisani().size)
        Assert.assertEquals(listaPredmeta, PredmetRepository.getUpisani())

    }
}