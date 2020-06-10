package com.example.tiku1demo2.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tiku1demo2.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2019/9/18.
 */

@SuppressLint("ValidFragment")
public class S_Fragment_wzcs extends Fragment {
    private int a,b,c;
    private HorizontalBarChart barChart;
    private BarData data ;
    private BarDataSet dataSet;
    private List<String> mX;
    private List<BarEntry> mY;
    private List<Integer> color;
    public S_Fragment_wzcs(int a, int b, int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( R.layout.s_fragment_wzcs,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        inview();
        addaData();
    }
    public void setColor()
    {
        color.add(Color.parseColor("#7DC53E"));
        color.add(Color.parseColor("#4068AE"));
        color.add(Color.parseColor("#A8000A"));
    }
    private void addaData() {
        mY.add(new BarEntry(0,(float)a/(a+b+c)*100));
        mY.add(new BarEntry(1,(float)b/(a+b+c)*100));
        mY.add(new BarEntry(2,(float)c/(a+b+c)*100));
        dataSet.notifyDataSetChanged();
        setColor();
        dataSet.setColors(color);//设置每条柱状条的颜色
        data.notifyDataChanged();
        dataSet.setValueFormatter(new PercentFormatter());
        barChart.postInvalidate();
    }

    private void inview() {
        barChart = getView().findViewById(R.id.wzcs);
        mX=new ArrayList<>();
        mY= new ArrayList<>();
        color = new ArrayList<>();
        dataSet  =new BarDataSet(mY,"");
        mX.add("1-2条违章"); mX.add("3-5条违章"); mX.add("5条以上违章");
        data = new BarData(dataSet);
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(3);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(mX));
        YAxis yAxis = barChart.getAxisRight();
        yAxis.setValueFormatter(new PercentFormatter());
        yAxis.setAxisMaximum(100);
        yAxis.setLabelCount(8);
        barChart.getAxisLeft().setEnabled(false);
        barChart.getAxisLeft().setStartAtZero(true);
        barChart.setData(data);
        barChart.getLegend().setEnabled(false);
        barChart.setDescription(null);
        barChart.setTouchEnabled(false);

    }
}
