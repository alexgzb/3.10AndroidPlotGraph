package com.gezelbom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.PointLabelFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Activity that plots two series of Y-Values in a graph
 */
public class GraphActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        //Get the intent
        Intent intent = getIntent();

        //Get the plot from the view
        XYPlot plot = (XYPlot) findViewById(R.id.plot);

        //Fetch the Integer ArrayLists from the intents
        ArrayList<Integer> values1 = intent.getIntegerArrayListExtra("1");
        ArrayList<Integer> values2 = intent.getIntegerArrayListExtra("2");

        // Create the series the values
        XYSeries series1 = new SimpleXYSeries(values1, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");
        XYSeries series2 = new SimpleXYSeries(values2, SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "");

        // create formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter seriesFormat = new LineAndPointFormatter();
        seriesFormat.setPointLabelFormatter(new PointLabelFormatter());
        seriesFormat.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels);

        LineAndPointFormatter seriesFormat2 = new LineAndPointFormatter();
        seriesFormat2.setPointLabelFormatter(new PointLabelFormatter());
        seriesFormat2.configure(getApplicationContext(),
                R.xml.line_point_formatter_with_labels2);

        // add the series' to the plot:
        plot.addSeries(series1, seriesFormat);
        plot.addSeries(series2, seriesFormat2);

        //No Decimals in the plots
        plot.setRangeValueFormat(new DecimalFormat("0"));
        plot.setDomainValueFormat(new DecimalFormat("0"));

        // rotate domain labels 45 degrees to make them more compact horizontally:
        plot.getGraphWidget().setDomainLabelOrientation(-45);

    }
}
