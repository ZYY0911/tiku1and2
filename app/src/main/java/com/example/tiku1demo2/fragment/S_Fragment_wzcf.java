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
import com.example.tiku1demo2.bean.s_no;
import com.example.tiku1demo2.bean.s_yes;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dell on 2019/9/18.
 */
@SuppressLint("ValidFragment")
public class S_Fragment_wzcf extends Fragment {
    private List<s_yes> myes;
    private Map<String,Float> map;

    private PieChart pieChart;
    private PieData data;
    private PieDataSet dataSet;
    private float chongfu,buchongfu;
    private List<PieEntry> pieEntries;
    private List<Integer> myColor;
    public S_Fragment_wzcf(Map<String,Float> map,List<s_yes> myess)
    {
        this.map=map;
        this.myes=myess;
        chongfu  =(float)map.size()/(float) myess.size();
        buchongfu=1-chongfu;

    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.s_fragment_wzcf,null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pieChart = getActivity().findViewById(R.id.whetherChart);
        inview();


    }

    private void setColr() {
        myColor.add(Color.parseColor("#923233"));
        myColor.add(Color.parseColor("#365A92"));
    }

    private void adddata() {

        map = new HashMap<>();
        pieEntries = new ArrayList<>();
        myColor = new ArrayList<>();

      float  y = chongfu;
        float n = buchongfu;
        pieEntries.add(new PieEntry(y*100,"有重复违章"));
        pieEntries.add(new PieEntry(n*100,"无重复违章"));
    }
    private void setLegend() {
        Legend legend = pieChart.getLegend();
        legend.setEnabled(true);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
    }

    private void setLine() {
        dataSet.setValueLinePart1OffsetPercentage(80f);//数据连接线距图形片内部边界的距离，为百分数
        dataSet.setValueLinePart1Length(1.0f);
        dataSet.setValueLinePart2Length(1.0f);
        dataSet.setValueLineColor(Color.parseColor("#923233"));
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
    }
    private void inview() {
        adddata();
        setColr();
        dataSet = new PieDataSet(pieEntries,"");
        dataSet.setColors(myColor);
        dataSet.setSliceSpace(4f);
        setLine();
        data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        pieChart.setRotationEnabled(false);
        pieChart.setDrawHoleEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setEntryLabelColor(Color.BLACK);
        setLegend();
        pieChart.setData(data);

    }
}
