package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostFragment extends Fragment {

    TextInputEditText uname,job;
    Button submitBtn;
    ProgressBar loadingPB;
    TextView responseTxt;

    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View postView = inflater.inflate(R.layout.fragment_post, container, false);

        uname = (TextInputEditText) postView.findViewById(R.id.user_name);
        job = (TextInputEditText) postView.findViewById(R.id.editJob);
//        lname = (TextInputEditText) postView.findViewById(R.id.last_name);
//        email = (TextInputEditText) postView.findViewById(R.id.email);

        submitBtn = (Button) postView.findViewById(R.id.post_submit);

        responseTxt = (TextView) postView.findViewById(R.id.response);

        loadingPB = (ProgressBar) postView.findViewById(R.id.LoadingPB);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (uname.getText().toString().isEmpty() && job.getText().toString().isEmpty()) {
                    Toast.makeText(getActivity(), "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                // calling a method to post the data and passing our name and job.
                postData(uname.getText().toString(), job.getText().toString());

                loadingPB.setVisibility(View.VISIBLE);

            }
        });

        return postView;
    }

//    public UserRequest createUser(){
//        UserRequest userRequest = new UserRequest();
//        userRequest.setUsername(uname.getText().toString());
//        userRequest.setFirst_name(fname.getText().toString());
//        userRequest.setLast_name(lname.getText().toString());
//        userRequest.setEmail(email.getText().toString());
//
//        return userRequest;
//    }

    public void postData(String name, String job){


        UserResponse userResponse = new UserResponse(name,job);

        Call<UserResponse> userResponseCall = PostApiClient.getUserService().saveUser(userResponse);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                if (response.isSuccessful()){
                    Toast.makeText(getActivity(), "Request Success", Toast.LENGTH_SHORT).show();

                    UserResponse responseFromApi = response.body();

                    responseTxt.setText("Response Code: " + response.code() + "\nName :"+ responseFromApi.getUsername()+"\nJob :"+ responseFromApi.getJob());

                    loadingPB.setVisibility(View.GONE);
                }

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

                responseTxt.setText("Error found is : " + t.getMessage());

            }
        });

    }

}