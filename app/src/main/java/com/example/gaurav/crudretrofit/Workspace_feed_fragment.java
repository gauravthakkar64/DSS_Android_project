package com.example.gaurav.crudretrofit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gaurav.crudretrofit.model.Workspace;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Workspace_feed_fragment extends Fragment {

    private RecyclerView rv;
    public RecyclerView.LayoutManager layoutManager;
    private List<Workspace> workspaceList=new ArrayList<>();
    WorkspaceAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView=inflater.inflate(R.layout.fragment_workspace_feed_fragment,null);
        rv= (RecyclerView) rootView.findViewById(R.id.recyclerView_Workspace);





        workspaceList.add(
                new Workspace(
                        1,
                        "Apple MacBook Air Core i5 5th Gen - (8 GB/128 GB SSD/Mac OS Sierra)",
                        "13.3 inch, Silver, 1.35 kg",
                        60000,
                        R.drawable.img_0465));

        workspaceList.add(
                new Workspace(
                        1,
                        "Dell Inspiron 7000 Core i5 7th Gen - (8 GB/1 TB HDD/Windows 10 Home)",
                        "14 inch, Gray, 1.659 kg",
                        60000,
                        R.drawable.img_0465));

        workspaceList.add(
                new Workspace(
                        1,
                        "Microsoft Surface Pro 4 Core m3 6th Gen - (4 GB/128 GB SSD/Windows 10)",
                        "13.3 inch, Silver, 1.35 kg",
                        60000,
                        R.drawable.img_0465));






       LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
        mAdapter = new WorkspaceAdapter(getActivity(),workspaceList);
        rv.setAdapter(mAdapter);
        return rootView;

    }

}
