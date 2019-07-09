package com.example.day3.V;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ScrollView;

import com.example.day3.M.GrAdapter;
import com.example.day3.M.MyList;
import com.example.day3.M.SoBean;
import com.example.day3.P.BaseActivity;
import com.example.day3.P.Person;
import com.example.day3.R;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private List<SoBean.ResultBean> list = new ArrayList<>();
    private MyList my1;
    private PullToRefreshScrollView pull;
    private GrAdapter grAdapter;
    @Override
    protected int indata() {
        return R.layout.activity_main;

    }
    @Override
    protected void inpoll() {
        pull = findViewById(R.id.pull);
        my1 = findViewById(R.id.my);
        inool();
    }
    private void inool() {
        pull.setMode(PullToRefreshScrollView.Mode.BOTH);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ScrollView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                grAdapter=null;
                list.clear();
                inlast();
            }
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ScrollView> pullToRefreshBase) {
                inlast();
            }
        });
    }
    @Override
    protected void inlast() {
        AsyncTask<Void, Void, List<SoBean.ResultBean>> execute = new AsyncTask<Void, Void, List<SoBean.ResultBean>>() {
            @Override
            protected List<SoBean.ResultBean> doInBackground(Void... voids) {
                String getstr = Person.getstr("http://172.17.8.100/small/commodity/v1/findCommodityListByLabel?labelId=1003&page=1&count=1");
                Gson gson = new Gson();
                SoBean soBean = gson.fromJson(getstr, SoBean.class);
                return soBean.getResult();
            }
            @Override
            protected void onPostExecute(List<SoBean.ResultBean> resultBeans) {
                super.onPostExecute(resultBeans);
                grAdapter=null;
                list.addAll(resultBeans);

                grAdapter = new GrAdapter(list, MainActivity.this);
                my1.setAdapter(grAdapter);
                pull.onRefreshComplete();
            }
        }.execute();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
