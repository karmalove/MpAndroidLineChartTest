package com.qcy_bracelet.qcy.mpandroidlinecharttest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private LineChart mLineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLineChart = (LineChart) findViewById(R.id.lineChart);
        LineData mLineData = getLineData(10, 800);
        showLineChart(mLineChart, mLineData, Color.rgb(123, 234, 125));
    }

    /**
     * 生成一个数据
     *
     * @param count 表示图表中有多少个坐标点
     * @param range 生成range以内一个随机数
     * @return
     */
    private LineData getLineData(int count, float range) {

        ArrayList<String> xValues = new ArrayList<String>();
        for (int i = 0; i <= count; i++) {
            //x轴显示的数据
            xValues.add(" " + i);
        }
        ArrayList<Entry> yValues = new ArrayList<Entry>();
        for (int i = 0; i <= count; i++) {
            float value = (float) (Math.random() * range) + 3;
            //y轴显示的数据
            yValues.add(new Entry(value, i));
        }
        //y轴的数据集合
        LineDataSet lineDataSet = new LineDataSet(yValues, "");
        lineDataSet.setLineWidth(2);//设置线的大小
        lineDataSet.setColor(Color.WHITE);
        //设置填充，在折线与x轴之间填充颜色
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawCubic(true);//设置允许曲线平滑
        //设置曲线的平滑度
        lineDataSet.setCubicIntensity(0.6f);
        //设置允许填充
        lineDataSet.setDrawFilled(true);
        //设置填充的颜色
        lineDataSet.setFillColor(Color.GREEN);

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<ILineDataSet>();
        lineDataSets.add(lineDataSet);
        LineData lineData = new LineData(xValues, lineDataSets);
        return lineData;
    }

    /**
     * @param lineChart
     * @param mLineData
     * @param rgb
     */
    private void showLineChart(LineChart lineChart, LineData mLineData, int rgb) {
        lineChart.setDrawBorders(false);//是否在折线图上添加边框
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴在下方
        xAxis.setDrawGridLines(false);
        xAxis.setEnabled(false);
        // 设置右侧坐标轴
        YAxis rightAxis = lineChart.getAxisRight();
        rightAxis.setEnabled(false);
        rightAxis.setDrawGridLines(false);

        //数据描述
        lineChart.setDescription("");
        //如果没有数据的时候，会显示以下内容
        lineChart.setNoDataText("NoData to show!");
        //设置是否可以触摸
        lineChart.setTouchEnabled(true);
        //设置是否可以拖动
        lineChart.setDragEnabled(true);
        //设置是否可以缩放
        lineChart.setScaleEnabled(true);
        //设置背景
        lineChart.setBackgroundColor(Color.WHITE);
        //设置数据
        lineChart.setData(mLineData);
        //设置比例图示，就是那一个y的value
        Legend mLegeng = lineChart.getLegend();
        //样式
        mLegeng.setForm(Legend.LegendForm.LINE);
        //字体
        mLegeng.setFormSize(6f);
        //颜色
        mLegeng.setTextColor(Color.RED);
        //立即执行动画，x轴
        lineChart.animateX(2500);
    }

    private ArrayList<String> getXAxisShowLable() {
        ArrayList<String> m = new ArrayList<String>();
        m.add("Jan");
        m.add("Feb");
        m.add("Mar");
        m.add("Apr");
        m.add("May");
        m.add("Jun");
        m.add("Jul");
        m.add("Aug");
        m.add("Sep");
        m.add("Okt");
        m.add("Nov");
        m.add("Dec");
        return m;
    }

    private ArrayList<Integer> getYAxisShowLable() {
        ArrayList<Integer> n = new ArrayList<Integer>();
        n.add(200);
        n.add(100);
        n.add(50);
        n.add(150);
        return n;

    }

}
