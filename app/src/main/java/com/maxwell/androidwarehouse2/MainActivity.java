package com.maxwell.androidwarehouse2;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.maxwell.androidwarehouse2.R;
import com.maxwell.androidwarehouse2.adapters.RVAdapter;
import com.maxwell.androidwarehouse2.models.Items;
import com.maxwell.androidwarehouse2.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.rvItems)
    RecyclerView rvItems;
    RVAdapter adapter;
    List<Items> itemsList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    ArrayList<ActivityInfo> mActivities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rvItems.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(layoutManager);

        populateList();
        setAdapter();
    }

    void populateList(){
        try {
            PackageInfo pi = getPackageManager().getPackageInfo(
                    getPackageName(), PackageManager.GET_ACTIVITIES);

            mActivities = new ArrayList<>(Arrays.asList(pi.activities));

            for (ActivityInfo item:mActivities) {
                if(!item.name.contains("MainActivity")){
                    Class cl = Class.forName(item.name);
                    String className = item.name.replace(item.packageName + ".activities.", "");
                    itemsList.add(new Items(cl, className));
                }
            }

        } catch (PackageManager.NameNotFoundException e) {
            Log.e(Constants.DEBUG,e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void setAdapter(){
        adapter = new RVAdapter(itemsList, this);
        rvItems.setAdapter(adapter);
    }
}
