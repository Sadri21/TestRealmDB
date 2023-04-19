package com.app.testapplication.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.testapplication.RealmConfiguration.createConfigRealm
import com.app.testapplication.realmModel.Mahasiswa
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.query.RealmResults

class MahasiswaViewModel: ViewModel() {

    val mahasiswa =  MutableLiveData<List<Mahasiswa>>()
    private val realm =  Realm.open(createConfigRealm())

    fun addAllMahasiswa(listMahasiswa: List<Mahasiswa>) {
        val items: RealmResults<Mahasiswa> = realm.query<Mahasiswa>().find()
        realm.writeBlocking {
            for (data in listMahasiswa) {
                if (items.none { it._idMahasiswa == data._idMahasiswa }) {
                    copyToRealm(data)
                }
            }
        }
    }

    fun getMahasiswa() {
        val items: RealmResults<Mahasiswa> = realm.query<Mahasiswa>().find()
        mahasiswa.postValue(items)
    }
}