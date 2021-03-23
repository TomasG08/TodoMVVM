package com.cursoandroid.todolist.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.cursoandroid.todolist.data.TaskDao
import javax.inject.Inject

class TasksViewModel @ViewModelInject constructor(private val taskDao: TaskDao) : ViewModel() {
}