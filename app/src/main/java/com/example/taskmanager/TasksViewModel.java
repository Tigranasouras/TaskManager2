package com.example.taskmanager;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.LinkedList;

public class TasksViewModel extends ViewModel {

    private MutableLiveData<LinkedList<String>> tasksLL;
    private TasksViewModel taskViewModel;

    private TasksViewModel() {
        tasksLL = new MutableLiveData<>();
        LinkedList<String> l = new LinkedList<>();
        tasksLL.setValue(l);
    }

    public MutableLiveData<LinkedList<String>> getTaks() {
        return tasksLL;
    }

    public void setTasks(LinkedList<String> l) {
        tasksLL.setValue(l);
    }

    public LinkedList<String> gettasks() {
        return tasksLL.getValue();
    }

    public void addTask(String c) {
        LinkedList<String> l = gettasks();
        l.add(c);
        Log.i("Tasks", l.toString());
        tasksLL.setValue(l);


    }
}
