package com.app.testapplication.realmModel

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class Kelas() : RealmObject {
    var namaKelas: String = ""
    var listMataPelajaran : RealmList<MataPelajaran>? = realmListOf()
    constructor(namaKelas: String, listMataPelajaran : RealmList<MataPelajaran>) : this() {
        this.namaKelas = namaKelas
        this.listMataPelajaran = listMataPelajaran
    }
}
