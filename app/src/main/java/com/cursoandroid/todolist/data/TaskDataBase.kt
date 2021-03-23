package com.cursoandroid.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.cursoandroid.todolist.dependencyInjection.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Task::class], version = 1)
abstract class TaskDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    class Callback @Inject constructor(
        private val database: Provider<TaskDataBase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Lavar trastes"))
                dao.insert(Task("Estudiar"))
                dao.insert(Task("Seguir buscando empleo", important = true))
                dao.insert(Task("Prueba 2", completed = true))
                dao.insert(Task("Prueba 3"))
                dao.insert(Task("Hacer comida", completed = true))
            }

        }
    }

}