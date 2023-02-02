package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostFragment extends Fragment {

    TextInputEditText uname,fname,lname,email;
    Button submitBtn;

    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View postView = inflater.inflate(R.layout.fragment_post, container, false);

        uname = (TextInputEditText) postView.findViewById(R.id.user_name);
        fname = (TextInputEditText) postView.findViewById(R.id.first_name);
        lname = (TextInputEditText) postView.findViewById(R.id.last_name);
        email = (TextInputEditText) postView.findViewById(R.id.email);

        submitBtn = (Button) postView.findViewById(R.id.post_submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveUser(createUser());

            }
        });

        return postView;
    }

    public UserRequest createUser(){
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername(uname.getText().toString());
        userRequest.setFirst_name(fname.getText().toString());
        userRequest.setLast_name(lname.getText().toString());
        userRequest.setEmail(email.getText().toString());

        return userRequest;
    }

    public void saveUser(UserRequest userRequest){

        Call<UserResponse> userResponseCall = PostApiClient.getUserService().saveUser(userRequest);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.isSuccessful()){
                    Toast.makeText(getActivity(), "Request Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getActivity(), "Request Failed", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                Toast.makeText(getActivity(), "Request Failed  " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

}