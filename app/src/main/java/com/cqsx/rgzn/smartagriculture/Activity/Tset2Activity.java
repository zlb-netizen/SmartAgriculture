package com.cqsx.rgzn.smartagriculture.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cqsx.rgzn.smartagriculture.R;
import com.cqsx.rgzn.smartagriculture.Untils.PieChart;
import com.cqsx.rgzn.smartagriculture.Untils.PieChartBean;

import java.util.ArrayList;
import java.util.List;

public class Tset2Activity extends AppCompatActivity {
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tset2);
        int[] color = {getApplication().getResources().getColor(R.color.colorAccent), getApplication().getResources().getColor(R.color.colorPrimaryDark), 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
                0xFFE6B800};

        pieChart = findViewById(R.id.PieChart);
        List<PieChartBean> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            PieChartBean bean = new PieChartBean();
            bean.setColor(color[i]);
            bean.setVaule(i + 1);
            list.add(bean);
        }
        pieChart.setData(list);
        pieChart.startAnimation(6000);
    }
}

