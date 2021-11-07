package com.example.androidroom

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

//저장소 구현
//저장소는 쿼리를 관리, 데이터를 네트워크에서 가져올지 또는 로컬 DB에서 가져올지 결정하는 로직구현
class WordRepository (private val wordDao: WordDao){
    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
//DAO는 전체 데이터베이스가 아닌 저장소 생성자에 전달됩니다.
// DAO에 데이터베이스의 모든 읽기/쓰기 메서드가 포함되어 있으므로 DAO 액세스만 필요하기 때문입니다. 전체 데이터베이스를 저장소에 노출할 필요가 없습니다.