package com.example.taskmanager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class TaskPickFragment extends Fragment {

    private String[] taks;
    private TasksViewModel tasksModel;
    private OnMessageSendListener mListener;


    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int buttonIndex = grid.indexOfChild(v);
            String currentTask = strings[buttonIndex];
            taksModel.addTasks(currentTask);

        }
    };

    public TaskPickFragment() {

    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnMessageSendListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnMessageSendListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // get the resources String Array bellow
        tasks = getResources().getStringArray(R.array.tasks_array);
        taskssModel = new ViewModelProvider(getActivity()).get(TasksViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_pick, container, false);
    }
}