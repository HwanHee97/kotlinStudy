package com.example.androidroom

import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel(private val repository: WordRepository):ViewModel() {
val allWords:LiveData<List<Word>> = repository.allWords.asLiveData()

    fun insert(word:Word)=viewModelScope.launch {//저장소의 insert호출
        repository.insert(word)
    }
}
//
class WordViewModelFactory(private val repository: WordRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordRepository::class.java)){
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}