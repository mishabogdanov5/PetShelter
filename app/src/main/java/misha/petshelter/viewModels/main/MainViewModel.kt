package misha.petshelter.viewModels.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import misha.petshelter.R
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    val unionPictId = MutableLiveData(R.drawable.union_big)
    val addPictId = MutableLiveData(R.drawable.ic_add_outline)
    val profilePictId = MutableLiveData(R.drawable.ic_profile_outline)

    fun switchUnionPict() {
        unionPictId.value = R.drawable.union_big
        addPictId.value = R.drawable.ic_add_outline
        profilePictId.value = R.drawable.ic_profile_outline
    }

    fun switchAddPict() {
        addPictId.value = R.drawable.ic_add
        unionPictId.value = R.drawable.union_outline
        profilePictId.value = R.drawable.ic_profile_outline
    }

    fun switchProfilePict() {
        profilePictId.value = R.drawable.ic_profile
        addPictId.value = R.drawable.ic_add_outline
        unionPictId.value = R.drawable.union_outline
    }
}