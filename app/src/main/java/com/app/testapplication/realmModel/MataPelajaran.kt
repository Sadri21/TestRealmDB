package com.app.testapplication.realmModel

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

open class MataPelajaran(): RealmObject {
    var namaMataPelajaran: String = ""

    constructor(namaMataPelajaran: String) : this() {
        this.namaMataPelajaran = namaMataPelajaran
    }
}

