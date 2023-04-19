package com.app.testapplication.realmModel

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Mahasiswa() : RealmObject {
    @PrimaryKey
    var _idMahasiswa: Int = 0
    var namaMahasiswa: String = ""
    var kelas : Kelas? = null
    constructor(_idMahasiswa: Int, namaMahasiswa: String , kelas: Kelas) : this() {
        this._idMahasiswa = _idMahasiswa
        this.namaMahasiswa = namaMahasiswa
        this.kelas = kelas
    }
}