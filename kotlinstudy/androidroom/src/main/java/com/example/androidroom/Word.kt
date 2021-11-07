package com.example.androidroom

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
// 이 클래스는 단어의 항목(SQLite 테이블을 나타냄)을 설명합니다.
// 클래스의 각 속성은 테이블의 열을 나타냅니다.
// Room에서는 궁극적으로 이러한 속성을 사용하여 테이블을 만들고 데이터베이스의 행에서 객체를 인스턴스화합니다.
@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name="word") val word: String)
//디비 테이블 이름=word_table // 열 이름= word