package br.info.nextsistemas.controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
 
@ManagedBean
public class ChartView implements Serializable {
 
    private LineChartModel lineModel1;
     
    @PostConstruct
    public void init() {
        createLineModels();
    }
     
    public LineChartModel getLineModel1() {
		return lineModel1;
	}

	private void createLineModels() {
         
		lineModel1 = initLinearModel();
        lineModel1.setTitle("Gráfico de estimativa de Processos");
        lineModel1.setLegendPosition("e");
        lineModel1.setAnimate(true);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Dias"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Processos");
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
     
    
	private LineChartModel initLinearModel() {
        LineChartModel model = new LineChartModel();
 
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Meus Processos");
 
        series1.set(1, Math.random() * 9);
        series1.set(2, Math.random() * 9);
        series1.set(3, Math.random() * 9);
        series1.set(4, Math.random() * 9);
        series1.set(5, Math.random() * 9);
        series1.set(6, Math.random() * 9);
        series1.set(7, Math.random() * 9);
        series1.set(8, Math.random() * 9);
        series1.set(9, Math.random() * 9);
        series1.set(10, Math.random() * 9);
        series1.set(11, Math.random() * 9);
        series1.set(12, Math.random() * 9);
        series1.set(13, Math.random() * 9);
        series1.set(14, Math.random() * 9);
        series1.set(15, Math.random() * 9);
        series1.set(11, Math.random() * 9);
        series1.set(17, Math.random() * 9);
        series1.set(18, Math.random() * 9);
        series1.set(19, Math.random() * 9);
        series1.set(20, Math.random() * 9);
        series1.set(21, Math.random() * 9);
        series1.set(22, Math.random() * 9);
        series1.set(23, Math.random() * 9);
        series1.set(24, Math.random() * 9);
        series1.set(25, Math.random() * 9);
        series1.set(26, Math.random() * 9);
        series1.set(27, Math.random() * 9);
        series1.set(28, Math.random() * 9);
        series1.set(29, Math.random() * 9);
        series1.set(30, Math.random() * 9);
        series1.set(31, Math.random() * 9);
 
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Todos Processos");
 
        series2.set(1, Math.random() * 9);
        series2.set(2, Math.random() * 9);
        series2.set(3, Math.random() * 9);
        series2.set(4, Math.random() * 9);
        series2.set(5, Math.random() * 9);
        series2.set(6, Math.random() * 9);
        series2.set(7, Math.random() * 9);
        series2.set(8, Math.random() * 9);
        series2.set(9, Math.random() * 9);
        series2.set(10, Math.random() * 9);
        series2.set(11, Math.random() * 9);
        series2.set(12, Math.random() * 9);
        series2.set(13, Math.random() * 9);
        series2.set(14, Math.random() * 9);
        series2.set(15, Math.random() * 9);
        series2.set(11, Math.random() * 9);
        series2.set(17, Math.random() * 9);
        series2.set(18, Math.random() * 9);
        series2.set(19, Math.random() * 9);
        series2.set(20, Math.random() * 9);
        series2.set(21, Math.random() * 9);
        series2.set(22, Math.random() * 9);
        series2.set(23, Math.random() * 9);
        series2.set(24, Math.random() * 9);
        series2.set(25, Math.random() * 9);
        series2.set(26, Math.random() * 9);
        series2.set(27, Math.random() * 9);
        series2.set(28, Math.random() * 9);
        series2.set(29, Math.random() * 9);
        series2.set(30, Math.random() * 9);
        series2.set(31, Math.random() * 9);
 
        model.addSeries(series1);
        model.addSeries(series2);
         
        return model;
    }
 
}