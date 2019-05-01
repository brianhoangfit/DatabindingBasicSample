package com.brian.databindingbasic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * @author Brian
 * @date: 2019-05-01
 */


class ProfileViewModel : ViewModel() {

    private val _name = MutableLiveData("Brian")
    private val _lastName = MutableLiveData("Hoang")
    private val _likes = MutableLiveData(0)

    val name: LiveData<String> = _name

    val lastName: LiveData<String> = _lastName

    val likes: LiveData<Int> = _likes


    fun onLike() {
        _likes.value = (_likes.value ?: 0) + 1
    }

    val popularity: LiveData<Popularity> = Transformations.map(_likes) {
        when {
            it > 9 -> Popularity.STAR
            it > 4 -> Popularity.POPULAR
            else -> Popularity.NORMAL
        }
    }

}

enum class Popularity {
    NORMAL,
    POPULAR,
    STAR
}