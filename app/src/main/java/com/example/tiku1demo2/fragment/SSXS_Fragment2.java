package com.example.tiku1demo2.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiku1demo2.AppClient;
import com.example.tiku1demo2.R;
import com.example.tiku1demo2.bean.HJZB;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 张瀛煜 on 2019-09-18
 */
public class SSXS_Fragment2 extends Fragment {
    private LineChart lineChart;
    private List<HJZB> hjzbs;
    private List<Entry> entries;
    private LineData data;
    private LineDataSet dataSet;
    private List<String> xValue;
    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            initView();
            return false;
        }
    });

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ssxs_fragment2, null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lineChart = getView().findViewById(R.id.lineChart2);
        new Thread() {
            @Override
            public void run() {
                super.run();
                do {
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } while (true);
            }
        }.start();
    }

    private void initView() {

        hjzbs = AppClient.getHjzbs();
        entries = new ArrayList<>();
        setData();
        dataSet = new LineDataSet(entries, "");
        dataSet.setCircleColor(Color.GRAY);
        dataSet.setColor(Color.GRAY);
        dataSet.setDrawCircleHole(false);
        dataSet.setLineWidth(4f);
        dataSet.setCircleSize(7f);
        dataSet.setValueTextSize(30f);
        data = new LineData(dataSet);
        setX();
        setY();
        lineChart.setData(data);
        lineChart.getLegend().setEnabled(false);
        lineChart.getDescription().setEnabled(false);
        lineChart.invalidate();
    }

    private void setY() {
        YAxis yAxisR = lineChart.getAxisRight();
        yAxisR.setStartAtZero(true);
        yAxisR.setEnabled(false);
        YAxis yAxisL = lineChart.getAxisLeft();
        yAxisL.setStartAtZero(true);
        yAxisL.setAxisMaximum(30);
        yAxisL.setTextSize(30f);

    }

    private void setX() {
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawGridLines(false);
        xAxis.setTextSize(30f);
        xAxis.setLabelCount(xValue.size());
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xValue));
        xAxis.setLabelRotationAngle(-90);

    }

    private void setData() {
        xValue = new ArrayList<>();
        for (int i = 0; i < hjzbs.size(); i++) {
            HJZB hjzb = hjzbs.get(i);
            entries.add(new Entry(i, hjzb.getHumidity()));
            xValue.add(hjzb.getTi());
        }
    }
}
