package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetFragment extends Fragment {

    RecyclerView recyclerView;
    ArrayList<UserResponse> userResponseArrayList = new ArrayList<UserResponse>();
    GetAdapter getAdapter;


//    TextView txt;

    public GetFragment() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View getView = inflater.inflate(R.layout.fragment_get, container, false);

        recyclerView = (RecyclerView) getView.findViewById(R.id.recycler_view);

        getAdapter = new GetAdapter(getActivity(),userResponseArrayList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(getAdapter);
//        txt = getView.findViewById(R.id.textView);

        getUser();


        return getView;
//        userResponseArrayList.add(new UserResponse("ashdg","hsad"));
//        userResponseArrayList.add(new UserResponse("ashddsfg","hsadfdd"));


    }

    public void getUser(){
        Call<List<UserResponse>> call = GetApiClient.getInstance().getUserService().getUser();

        call.enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {

                if (response.isSuccessful()&&response.body()!=null){
                    userResponseArrayList.addAll(response.body());
                    getAdapter.notifyDataSetChanged();
//                List<UserResponse> userList = response.body();
//                String[] oneUserName = new String[userList.size()];
//                String[] oneUserJob = new String[userList.size()];
//
//                for (int i=0;i<userList.size();i++){
//                    oneUserName[i] = userList.get(i).getUsername();
//                    oneUserJob[i] = userList.get(i).getJob();

//                    userResponseArrayList.add(new UserResponse(oneUserName[i],oneUserJob[i] ));
                }

//                for (int i=0;i<userList.size();i++){
//                    userResponseArrayList.add(new UserResponse(oneUserName[i],oneUserJob[i] ));
//                }


            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {

                Toast.makeText(getActivity(), "Failed to get value", Toast.LENGTH_SHORT).show();

            }
        });
    }
}