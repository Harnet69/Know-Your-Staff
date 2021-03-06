package com.harnet.knowyourstaff.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harnet.knowyourstaff.R;
import com.harnet.knowyourstaff.controller.GameController;
import com.harnet.knowyourstaff.controller.PersonController;
import com.harnet.knowyourstaff.model.Person;

public class GameFragment extends Fragment {
    private OnMessageSendListener onMessageSendListener;

    // interface for exchanging data between fragments
    public interface OnMessageSendListener{
        void onMessageSend(String message);
    }

    public GameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment!!! Do the findViewById available
        View view =  inflater.inflate(R.layout.fragment_game, container, false);

        new GameController(view, onMessageSendListener, getContext());
        //for testing print all celebrities with photo links
//        PersonController personController = PersonController.getInstance();
//        assert personController != null;
//        for(Person person : personController.getStaff()){
//            System.out.println(person.getName() + " : " + person.getPhotoLink() );
//        }
//        Log.i("Link:", "onCreate: " + personController.getStaff().get(0).getPhotoLink());
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            onMessageSendListener = (OnMessageSendListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ "must implemented onMessageSend");
        }
    }
}