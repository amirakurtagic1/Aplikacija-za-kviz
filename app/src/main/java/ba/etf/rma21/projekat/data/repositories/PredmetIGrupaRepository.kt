package ba.etf.rma21.projekat.data.repositories

import ba.etf.rma21.projekat.data.models.Grupa
import ba.etf.rma21.projekat.data.models.Predmet

class PredmetIGrupaRepository {

    companion object{

        fun getPredmeti():List<Predmet>{

            return listOf();
        }
        fun getGrupe():List<Grupa>{
            return listOf();
        }

        fun getGrupeZaPredmet(idPredmeta:Int):List<Grupa>{
            return listOf();
        }
        fun upisiUGrupu(idGrupa:Int):Boolean{

            return true;
        }
        fun getUpisaneGrupe():List<Grupa>{
            return listOf();
        }
    }
}