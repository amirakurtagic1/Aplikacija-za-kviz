package ba.etf.rma21.projekat.data.repositories


class AccountRepository {

    companion object {
        //TODO Ovdje trebate dodati hash string vašeg accounta
        var acHash: String = "e9336960-63fd-4158-af6a-a7a2b2984288"

        fun postaviHash(acHash: String): Boolean {
            this.acHash = acHash
            return true
        }

        fun getHash(): String {
            return acHash
        }


    }
}