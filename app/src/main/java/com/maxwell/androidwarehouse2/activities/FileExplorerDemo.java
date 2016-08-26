package com.maxwell.androidwarehouse2.activities;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.adapters.FileAdapter;
import com.maxwell.androidwarehouse2.models.File;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Maximiliano on 02/11/15.
 */
public class FileExplorerDemo extends AppCompatActivity {
    List<File> mListFile = new ArrayList<>();
    @Bind(R.id.customRecyclerView)
    RecyclerView rv;
    @Bind(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    FileAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_recycleview);
        ButterKnife.bind(this);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        adapter = new FileAdapter(mListFile,this);
        rv.setAdapter(adapter);

        buildFilesList();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                buildFilesList();
            }
        });
    }

    private void buildFilesList() {
        mListFile.clear();

        String path = Environment.getExternalStorageDirectory().toString() + "/Download";
        java.io.File f = new java.io.File(path);
        java.io.File file[] = f.listFiles();

        for (int i=0; i < file.length; i++)
        {
            mListFile.add(new File(file[i].getName()));
        }

        adapter.notifyDataSetChanged();

        swipeRefreshLayout.setRefreshing(false);
    }
}
