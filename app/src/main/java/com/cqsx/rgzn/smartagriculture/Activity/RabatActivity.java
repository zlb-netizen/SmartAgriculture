package com.cqsx.rgzn.smartagriculture.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.cqsx.rgzn.smartagriculture.Adapter.RabatAdapter;
import com.cqsx.rgzn.smartagriculture.R;
import com.cqsx.rgzn.smartagriculture.Untils.Rabat;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class RabatActivity extends AppCompatActivity {
    private int sendIcon = R.mipmap.mei;
    private  int robIcon = R.mipmap.kefu;;
    private ListView listView;
    private Button qingkong;
    private Button send;
    private EditText text;
    private ArrayList list;
    private BaseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rabat);
        initView();
    }

    private void initView() {
        list = new ArrayList();
        listView  = findViewById(R.id.lv_fei_content);
       // qingkong = findViewById(R.id.bt_fei_qingkong);
        send  = findViewById(R.id.bt_fei_send);
        text = findViewById(R.id.ev_fei_text);
       // Rabat rabat = new Rabat(robIcon,"请问有什么需要帮助的吗？",false);
        //addData(rabat);
        adapter = new RabatAdapter(this,list);
        listView.setAdapter(adapter);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String edstr = text.getText().toString();
                Log.d("tag1", "edstr: "+edstr);
                if(edstr == null){
                    return;
                }
                Rabat msg = new Rabat(sendIcon,edstr,true);
                addData(msg);
                getNetData(edstr);
            }
        });
    }

    private void addData(Rabat rabat) {
        if(list==null){
            list = new ArrayList();
        }

        list.add(rabat);
        if(adapter!=null) {
            adapter.notifyDataSetChanged();
            Log.d("tag", adapter.getCount() + "");
        }

    }
    private  void getNetData(final String data){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String urlstr =  "http://api.qingyunke.com/api.php?key=free&appid=0&msg="+data;
                try {
                    URL url = new URL(urlstr);
                    HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    int code = connection.getResponseCode();
                    if(code == 200){
                        InputStream in  = connection.getInputStream();
                        BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
                        String result = "";
                        String line = "";
                        while ((line =br.readLine()) !=null){
                            result+=line;
                        }
                        Log.d("tag1", "getNetData: "+result);
                        JSONObject object = new JSONObject(result);
                        String data1 =    object.get("content").toString();
                        Log.d("tag1", "getNetData: "+data1);
                        final Rabat msg = new Rabat(robIcon,data1,false);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                addData(msg);
                            }
                        });
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}


