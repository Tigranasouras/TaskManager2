package com.example.taskmanager;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnMessageSendListener {
    FragmentManager fg;
    TasksViewModel tasksModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null){
            tasksModel = new ViewModelProvider(this).get(TasksViewModel.class);
            fg = getSupportFragmentManager();
            FragmentTransaction trans = fg.beginTransaction();
            TaskPickFragment cf = new TaskPickFragment();
            trans.add(R.id.TaskPick, cf, "taskFrag");
            TaskPickFragment cl = new TaskPickFragment();
            trans.add(R.id.ListFragment, cl, "listFrag");
            trans.commit();

        }

    }
    @Override
    public void onMessageSend(String message){
    }
}
