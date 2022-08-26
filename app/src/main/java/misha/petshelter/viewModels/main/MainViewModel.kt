package misha.petshelter.viewModels.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import misha.petshelter.R
import misha.petshelter.models.MainScreenStates
import misha.petshelter.models.PetInfo
import misha.petshelter.services.network.retrofit.RetrofitService
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val network: RetrofitService
): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val screenState = MutableLiveData(MainScreenStates.ADVERTS)

    val unionPictId = MutableLiveData(R.drawable.union_big)
    val addPictId = MutableLiveData(R.drawable.ic_add_outline)
    val profilePictId = MutableLiveData(R.drawable.ic_profile_outline)

    val pets = MutableLiveData(listOf<PetInfo>())

    fun onUnionPictClick() {
        unionPictId.value = R.drawable.union_big
        addPictId.value = R.drawable.ic_add_outline
        profilePictId.value = R.drawable.ic_profile_outline

        screenState.value = MainScreenStates.ADVERTS

    }

    fun onAddPictClick() {
        addPictId.value = R.drawable.ic_add
        unionPictId.value = R.drawable.union_outline
        profilePictId.value = R.drawable.ic_profile_outline

        screenState.value = MainScreenStates.CREATE_ADVERTS
    }

    fun onProfilePictClick() {
        profilePictId.value = R.drawable.ic_profile
        addPictId.value = R.drawable.ic_add_outline
        unionPictId.value = R.drawable.union_outline

        screenState.value = MainScreenStates.PROFILE
    }


    fun getAllPets() {
        compositeDisposable.add(network.getAllPets()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    pets.value = it
                },
                {
                    pets.value = listOf()
                }
            )
        )
    }

}