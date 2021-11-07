package com.example.androidroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao//Room의 Dao클래스로 식별
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>//모든 단어를 가져와서 리스트를 반환 하는 함수(오름차순으로)
    //데이터 변경사항을 관찰하려면 kotlinx-coroutines의 Flow를 사용한다.

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)//한단어 삽입함수 // OnConflictStrategy.IGNORE = 이미 목록에 있는단어와 같으면 새단어를 무시

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()//모든단어 삭제 함수
}