package com.cqsx.rgzn.smartagriculture.Activity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cqsx.rgzn.smartagriculture.R;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HttpUrlConnectionActivity extends AppCompatActivity {
    HttpURLConnection connection;
    TextView tv_1,tv_2,tv_3,tv_4,tv_5,tv_f,tv_f1,tv_f2,tv_f3,tv_f4,tv_f5,tv_f6,tv_f7,tv_f8,tv_f9,tv_10,tv_11,tv_12,tv_13,tv_14,tv_15;
    EditText ed_input;
    Button btn_button;
    ImageView img_test;
  //  String temperature="";
   // String weather="";
    String cityName="";
  //  List<Weather> weatherClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connection);
        initView();
        btn_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cityName=ed_input.getText().toString();
                tv_1.setText("");
                tv_2.setText("");
                tv_3.setText("");
             //   tv_7.setText("");
             //   tv_1.setText("");
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL url=new URL("http://apis.juhe.cn/simpleWeather/query?city="+cityName+"&key=6d05df96eeb0c186020ba2cfd8e37423");
                            Log.d("HttpUrl","URL:"+"http://apis.juhe.cn/simpleWeather/query?city="+cityName+"&key=6d05df96eeb0c186020ba2cfd8e37423");
                            connection= (HttpURLConnection) url.openConnection();
                            //Http请求的方法，GET表示从服务器获取数据
                            connection.setRequestMethod("GET");
                            //设置连接超时时间
                            connection.setConnectTimeout(5000);
                            //设置读取超时时间
                            connection.setReadTimeout(5000);
                            InputStream inputStream=connection.getInputStream();
                            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                            String line ;
                            //一行一行的从流中取出消息内容，直到为空
                            //字节字符缓冲流
                            String receiveMsg = "";
                            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                            while ((line=bufferedReader.readLine())!=null)
                            {
                                receiveMsg = receiveMsg+line;//拼接取出的内容
                            }
                            Log.d("HttpUrl","123467234667899"+receiveMsg);
                            final Weather weather = new Gson().fromJson(receiveMsg, Weather.class);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv_1.setText(weather.getResult().getRealtime().getTemperature()+"℃");
                                    tv_5.setText(weather.getResult().getRealtime().getInfo());
                                    tv_4.setText(weather.getResult().getRealtime().getDirect());

                                    tv_f.setText(weather.getResult().getFuture().get(0).getDate());
                                    tv_f1.setText(weather.getResult().getFuture().get(0).getWeather());
                                    tv_f2.setText(weather.getResult().getFuture().get(0).getDirect());
                                    tv_f3.setText(weather.getResult().getFuture().get(0).getTemperature());

                                    tv_f4.setText(weather.getResult().getFuture().get(1).getDate());
                                    tv_f5.setText(weather.getResult().getFuture().get(1).getWeather());
                                    tv_f6.setText(weather.getResult().getFuture().get(1).getDirect());
                                    tv_f7.setText(weather.getResult().getFuture().get(1).getTemperature());

                                    tv_f8.setText(weather.getResult().getFuture().get(2).getDate());
                                    tv_f9.setText(weather.getResult().getFuture().get(2).getWeather());
                                    tv_10.setText(weather.getResult().getFuture().get(2).getDirect());
                                    tv_11.setText(weather.getResult().getFuture().get(2).getTemperature());

                                    tv_12.setText(weather.getResult().getFuture().get(3).getDate());
                                    tv_13.setText(weather.getResult().getFuture().get(3).getWeather());
                                    tv_14.setText(weather.getResult().getFuture().get(3).getDirect());
                                    tv_15.setText(weather.getResult().getFuture().get(3).getTemperature());
                                    //  tv_text1.setText("空气质量: "+weather.getResult().getRealtime().getAqi());
                                   // aaa.setText(weather.getResult().getRealtime().getTemperature());
                                //    tv_7.setText(weather.getResult().getFuture().get(0).getTemperature());
                                    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日" );
                                    Date date=new Date(System.currentTimeMillis());
                                    tv_3.setText(simpleDateFormat.format(date));
                                    tv_2.setText(weather.getResult().getCity());
                                }
                            });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }finally {
                            connection.disconnect();
                        }
                    }
                }).start();
            }
        });


    }

    private void initView() {
        //当天温度
        tv_1=this.findViewById(R.id.frag_tv_currenttemp);

        ed_input=this.findViewById(R.id.ed_input);
        btn_button=this.findViewById(R.id.btn_button);
//城市
        tv_2=this.findViewById(R.id.frag_tv_city);
//日期
        tv_3=this.findViewById(R.id.frag_tv_date);
//风向
        tv_4=this.findViewById(R.id.frag_tv_wind);
        //多云、晴
        tv_5=this.findViewById(R.id.frag_tv_condition);

        tv_f=this.findViewById(R.id.item_center_tv_date);
        tv_f1=this.findViewById(R.id.item_center_tv_con);
        tv_f2=this.findViewById(R.id.item_center_iv);
        tv_f3=this.findViewById(R.id.item_center_tv_temp);

        tv_f4=this.findViewById(R.id.item_center_tv_date2);
        tv_f5=this.findViewById(R.id.item_center_tv_con2);
        tv_f6=this.findViewById(R.id.item_center_iv2);
        tv_f7=this.findViewById(R.id.item_center_tv_temp2);


        tv_f8=this.findViewById(R.id.item_center_tv_date3);
        tv_f9=this.findViewById(R.id.item_center_tv_con3);
        tv_10=this.findViewById(R.id.item_center_iv3);
        tv_11=this.findViewById(R.id.item_center_tv_temp3);

        tv_12=this.findViewById(R.id.item_center_tv_date4);
        tv_13=this.findViewById(R.id.item_center_tv_con4);
        tv_14=this.findViewById(R.id.item_center_iv4);
        tv_15=this.findViewById(R.id.item_center_tv_temp4);
    }
}