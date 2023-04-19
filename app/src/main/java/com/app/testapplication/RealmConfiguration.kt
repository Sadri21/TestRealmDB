package com.app.testapplication

import com.app.testapplication.realmModel.Kelas
import com.app.testapplication.realmModel.Mahasiswa
import com.app.testapplication.realmModel.MataPelajaran
import io.realm.kotlin.Configuration
import io.realm.kotlin.RealmConfiguration
import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.RealmList

object RealmConfiguration {
    fun createConfigRealm(): Configuration {

        return RealmConfiguration.Builder(
            setOf(Mahasiswa::class, Kelas::class, MataPelajaran::class)
        ).build()
    }

    fun collectDataMahasiswa(): List<Mahasiswa> {
        val mahasiswa1 = Mahasiswa(1, "Gana", collectDataKelas()[0])
        val mahasiswa2 = Mahasiswa(2, "Rahmann", collectDataKelas()[2])
        val mahasiswa3 = Mahasiswa(3, "Budi", collectDataKelas()[1])
        val mahasiswa4 = Mahasiswa(4, "Septiyana", collectDataKelas()[0])
        val mahasiswa5 = Mahasiswa(5, "Herman", collectDataKelas()[2])
        return listOf(mahasiswa1, mahasiswa2, mahasiswa3, mahasiswa4, mahasiswa5)
    }

    fun collectDataKelas() : List<Kelas> {
        val listMapel = createMapelData()
        val mapel1 = realmListOf(listMapel[0], listMapel[1], listMapel[2])
        val mapel2 = realmListOf(listMapel[3], listMapel[4], listMapel[5])
        val mapel3 = realmListOf(listMapel[6], listMapel[7], listMapel[8])
        val kelas1 = Kelas( "Seruni 1", mapel1)
        val kelas2 = Kelas( "Seruni 2", mapel2)
        val kelas3 = Kelas( "Seruni 3", mapel3)
        return listOf(kelas1, kelas2, kelas3)
    }

    fun createMapelData() : RealmList<MataPelajaran> {
        val mapel1 = MataPelajaran("Matematika")
        val mapel2 = MataPelajaran("Bhs Indoneisa")
        val mapel3 = MataPelajaran("Bhs Inggris")
        val mapel4 = MataPelajaran("Fisika")
        val mapel5 = MataPelajaran("Kimia")
        val mapel6 = MataPelajaran("Biologin")
        val mapel7 = MataPelajaran("Ekonomi dan akuntansi")
        val mapel8 = MataPelajaran("geografi")
        val mapel9 = MataPelajaran("Sosiologi")
        return realmListOf(mapel1, mapel2, mapel3, mapel4, mapel5, mapel6, mapel7, mapel8, mapel9)
    }

}