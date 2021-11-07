package com.example.androidroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
//Room데이터 베이스 추가하기
//Room 데이터베이스란?
//Room은 SQLite 데이터베이스 위에 있는 데이터베이스 레이어입니다.
//Room은 개발자가 SQLiteOpenHelper를 사용하여 처리하던 일반적인 작업을 처리합니다.
//Room은 DAO를 사용하여 데이터베이스에 쿼리를 실행합니다.
//기본적으로 UI 성능 저하를 방지하기 위해 Room에서는 기본 스레드에서 쿼리를 실행할 수 없습니다. Room 쿼리가 Flow를 반환하면 쿼리는 자동으로 백그라운드 스레드에서 비동기식으로 실행됩니다.
//Room은 SQLite 문의 컴파일 시간 확인을 제공합니다.
@Database(entities = arrayOf(Word::class), version = 1, exportSchema = false)//주석매개변수를 통해 항목선언, 버전번호 설정, exportSchema는 빌드 경고를 피하기위해 false
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao

    companion object {//싱글톤
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}