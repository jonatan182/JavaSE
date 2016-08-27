

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.*;
import java.applet.*;
import java.text.NumberFormat;
import java.util.Properties;
import javax.swing.*;
import java.lang.Math;
import java.lang.reflect.InvocationTargetException;
// JFreeChart
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
// JMathTools
import org.math.plot.*;
import static org.math.array.DoubleArray.*;
import org.math.plot.plotObjects.*;
import static org.math.array.StatisticSample.*;

// JCCKit
import jcckit.GraphicsPlotCanvas;
import jcckit.data.DataPlot;
import jcckit.data.DataCurve;
import jcckit.util.*;
import jcckit.data.*;
import jcckit.data.DataPoint;
import jcckit.GraphicsPlotCanvas2;

public class JApplet_Principal extends javax.swing.JApplet implements ItemListener {

    private javax.swing.JFormattedTextField Amplitud, velocidad, londa, periodo;
    private javax.swing.JFormattedTextField Fase;
    private javax.swing.JFormattedTextField Frecuencia;
    private javax.swing.JTextField dc;
    private javax.swing.JButton Visualizar;
    private javax.swing.JComboBox jComboBox1,jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4, jLabel6, jLabel7, jLabel8, jLabel9;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    
    /**
     * Initializes the applet JApplet_Principal
     */
    @Override
    public void init() {
        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                        System.err.println("Error al cargar formato.");
                    }
                    initComponents();
                }
            });
        } catch (InterruptedException | InvocationTargetException ex) {
        }
    }

    private void initComponents() {
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NumberFormat Formato = NumberFormat.getNumberInstance();
        //Formato.setMinimunFractionDigits(2);
        Formato.setMinimumFractionDigits(3);
        Amplitud = new JFormattedTextField(Formato);
        dc = new JTextField(20);
        Fase = new JFormattedTextField(Formato);

        Frecuencia = new JFormattedTextField(Formato);
        periodo = new JFormattedTextField();
        velocidad = new JFormattedTextField("300000000");
        Visualizar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        londa = new JFormattedTextField();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Amplitud");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 40, -1, 20));

        jLabel2.setText("Fase");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 100, -1, 20));

        jLabel3.setText("Frecuencia");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 70, -1, 20));

        jLabel5.setText("NIvel Dc");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 130, -1, 20));

        getContentPane().add(Amplitud, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 140, -1));

        getContentPane().add(Fase, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 140, -1));

        getContentPane().add(Frecuencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 140, -1));

        getContentPane().add(dc, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 140, -1));
        
        getContentPane().add(velocidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 460, 140, -1));
        
        getContentPane().add(londa, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 140, -1));
        getContentPane().add(periodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 520, 140, -1));
        
        
        velocidad.setEditable(false);
        londa.setEnabled(false);
        Visualizar.setText("Graficar");
        Visualizar.setPreferredSize(new java.awt.Dimension(55, 23));
        Visualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VisualizarActionPerformed(evt);
            }
        });

        getContentPane().add(Visualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 130, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(400,400));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 720, 430));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Senoidal", "JMathTools", "JCCKit", "Triangular", "Cuadratica"}));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 140, -1));
        
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"Luz En El Vacio/aire", "Luz En El Agua", "Sonido En El Aire", "Sonido En El Agua", "Personalizado"}));
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 140, -1));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Velocidad De La Onda: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360,460,130, 20));
        
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Longitud De La Onda: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360,490,130, 20));
        
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Periodo De La Onda: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(360,520,130, 20));
        
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Elaborado Por: Jonatan Javier Velandia Vanegas");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450,600,300, 20));
        
        
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Grafica");
        
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 160, 60, 20));
        
        getContentPane().setBackground(Color.red);
        
        jComboBox2.addItemListener(this);
        
    }// //GEN-END:initComponents

    private void VisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VisualizarActionPerformed

        //calculamos longitud
        int vel = Integer.parseInt(velocidad.getText().toString());
        String frecue = Frecuencia.getText();
        char a[] = frecue.toCharArray();
        
        String fe = a[0]+"";
        
        int f = Integer.parseInt(fe);
        
        londa.setText((vel/f)+"");
        
        //calculamos periodo
        double p = f;
        periodo.setText((1/p)+"");
        // Variables Generales
        double t_v = 0;

        // Variables usadas para JFreeChart     
        double y_v = 0;

        // Variables usadas para JMathTools
        double[] x = new double[201];
        double[] y = new double[201];
        int i = 0;

        // Variables de JCCKit
        double maximo = 0;
        double minimo = 0;
        double valor = 0;

        String nivelDc = dc.getText();
        int valorDc = 0;
        valorDc = Integer.parseInt(nivelDc);

        
        // JFreeChart

        if (jComboBox1.getSelectedItem().equals("Senoidal")) {


            // declaro la serie de tipo xy
            // al declarar cargo la denominación de la serie
            XYSeries series = new XYSeries("Amplitud:" + Amplitud.getValue() + " Frecuencia:" + Frecuencia.getValue() + " Fase:" + Fase.getValue());
            
            // cargo de datos la serie
            series.add(t_v, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
            while (t_v < 1) {
                t_v = t_v + 0.01;
                series.add(t_v, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                System.out.println(t_v + "+ " + ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue()) + valorDc);

            }

            // creo el dataset
            XYDataset juegoDatos = new XYSeriesCollection(series);
            
            // genero el gráfico
            JFreeChart chart =
                    ChartFactory.createXYLineChart("Senoidal",
                    "T", "A", juegoDatos, PlotOrientation.VERTICAL,
                    true,
                    true,
                    true // Show legend
                    );
            

            // cargo la imagen       
            ChartPanel myChart = new ChartPanel(chart,
                    false,
                    true,
                    true,
                    true,
                    false);

            // borro todos los componentes del Jpanel
            jPanel1.setBackground(Color.red);
            jPanel1.removeAll();
            // agrego el gráfico nuevo al Jpanel       
            jPanel1.add(myChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));
            // hago no visible y visible al Jpanel para actualizar 
            // no encontre otra forma
            jPanel1.setVisible(false);
            jPanel1.setVisible(true);
        }




        if (jComboBox1.getSelectedItem().equals("Triangular")) {

            // declaro la serie de tipo xy
            // al declarar cargo la denominación de la serie
            XYSeries series = new XYSeries("Amplitud:" + Amplitud.getValue() + " Frecuencia:" + Frecuencia.getValue() + " Fase:" + Fase.getValue()+"\n"+
                                            "Periodo: "+periodo.getText());

            // cargo de datos la serie
            series.add(t_v, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
            t_v = 0;
            while (t_v < 1) {
                t_v = t_v + 0.25;
                if (Frecuencia.getText().equals("1,000")) {

                    series.add(t_v, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                } else if (Frecuencia.getText().equals("2,000")) {
                    series.add(0.12, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.12) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.38, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.38) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.63, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.63) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.88, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.88) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(1.0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 1.0) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                } else if (Frecuencia.getText().equals("3,000")) {
                    series.add(0.080, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.080) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.25, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.25) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.42, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.42) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.58, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.58) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.75, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.75) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(0.92, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.92) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                    series.add(1.0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 1.0) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                }

            }






            // creo el dataset
            XYDataset juegoDatos = new XYSeriesCollection(series);

            // genero el gráfico
            JFreeChart chart =
                    ChartFactory.createXYLineChart("Triangular",
                    "t", "S(t)", juegoDatos, PlotOrientation.VERTICAL,
                    true,
                    true,
                    true // Show legend
                    );

            // cargo la imagen       
            ChartPanel myChart = new ChartPanel(chart,
                    false,
                    true,
                    true,
                    true,
                    false);

            // borro todos los componentes del Jpanel
            jPanel1.removeAll();
            // agrego el gráfico nuevo al Jpanel       
            jPanel1.add(myChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));
            // hago no visible y visible al Jpanel para actualizar 
            // no encontre otra forma
            jPanel1.setVisible(false);
            jPanel1.setVisible(true);
        }




        if (jComboBox1.getSelectedItem().equals("Cuadratica")) {

            // declaro la serie de tipo xy
            // al declarar cargo la denominación de la serie
            XYSeries series = new XYSeries("Amplitud:" + Amplitud.getValue() + " Frecuencia:" + Frecuencia.getValue() + " Fase:" + Fase.getValue());

            // cargo de datos la serie
            series.add(t_v, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
            if (Frecuencia.getText().equals("1,000")) {
                series.add(0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.250) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                series.add(0.50, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.250) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                series.add(0.50, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.75) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                series.add(1.0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.75) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
                series.add(1.0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * 0.0) + ((Number) Fase.getValue()).doubleValue()) + valorDc);
            }else if(Frecuencia.getText().equals("2,000")){
                series.add(0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.1)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.12)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0.25, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.12)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0.25, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.37)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0.5, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.37)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0.5, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.62)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0.750, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.62)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(0.750, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.87)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(1.0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.87)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
                series.add(1.0, ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2f*Math.PI*((Number) Frecuencia.getValue()).doubleValue()*0.0)+((Number) Fase.getValue()).doubleValue())+valorDc);                                              
            }
            // creo el dataset
            XYDataset juegoDatos = new XYSeriesCollection(series);
            // genero el gráfico
            JFreeChart chart =
                    ChartFactory.createXYLineChart("Cuadrada",
                    "t", "S(t)", juegoDatos, PlotOrientation.VERTICAL,
                    true,
                    true,
                    true // Show legend
                    );

            // cargo la imagen       
            ChartPanel myChart = new ChartPanel(chart,
                    false,
                    true,
                    true,
                    true,
                    false);

            // borro todos los componentes del Jpanel
            jPanel1.removeAll();
            // agrego el gráfico nuevo al Jpanel       
            jPanel1.add(myChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));
            // hago no visible y visible al Jpanel para actualizar 
            // no encontre otra forma
            jPanel1.setVisible(false);
            jPanel1.setVisible(true);
        }




        //JMathTools
        if (jComboBox1.getSelectedItem().equals("JMathTools")) {

            // Cargo los datos
            x[i] = t_v;
            y[i] = ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2 * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue());
            while (t_v < 2) {
                t_v = t_v + 0.01;
                i = i + 1;
                x[i] = t_v;
                y[i] = ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2 * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue());
            }


            // Creo el Panel
            Plot2DPanel plot = new Plot2DPanel();

            // Indico donde va a ir la leyenda del Gráfico
            plot.addLegend("WEST");


            // Genero el gráfico
            plot.addLinePlot("Amplitud:" + Amplitud.getValue() + " Frecuencia:" + Frecuencia.getValue() + " Fase:" + Fase.getValue(), x, y);


            //Agrego título
            BaseLabel title = new BaseLabel("Señales Periódicas", Color.RED, 0.5, 1.1);
            title.setFont(new Font("Courier", Font.BOLD, 20));
            plot.addPlotable(title);

            // Nombre de las Series
            plot.setAxisLabels("t", "f(t)");


            // borro todos los componentes del Jpanel
            jPanel1.removeAll();

            // agrego el gráfico nuevo al Jpanel
            jPanel1.add(plot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, -1, -1));
            // hago no visible y visible al Jpanel para actualizar 
            // no encontre otra forma
            jPanel1.setVisible(false);
            jPanel1.setVisible(true);
        }

        // JCCKit
        if (jComboBox1.getSelectedItem().equals("JCCKit")) {


            // Creo el arreglo donde se van a cargar las variables 
            DataCurve curve = new DataCurve("Amplitud:" + Amplitud.getValue() + " Frecuencia:" + Frecuencia.getValue() + " Fase:" + Fase.getValue());

            // Cargo los datos
            valor = ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2 * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue());
            curve.addElement(new DataPoint(t_v, valor));

            maximo = valor;
            minimo = valor;

            while (t_v < 2) {
                t_v = t_v + 0.01;
                valor = ((Number) Amplitud.getValue()).doubleValue() * Math.sin((2 * Math.PI * ((Number) Frecuencia.getValue()).doubleValue() * t_v) + ((Number) Fase.getValue()).doubleValue());
                curve.addElement(new DataPoint(t_v, valor));
                if (maximo < valor) {
                    maximo = valor;
                }

                if (minimo > valor) {
                    minimo = valor;
                }
            }

            // Creo un DataPlot
            DataPlot myPlot = new DataPlot();

            // Asocio el arreglo de datos al DataPlot
            myPlot.addElement(curve);

            // Determino las propiedades del Gráfico
            Properties props = new Properties();
            ConfigParameters config = new ConfigParameters(new PropertiesBasedConfigData(props));

            props.put("background", "0xffffff");

            props.put("defaultCoordinateSystem/grid", "true");
            props.put("defaultCoordinateSystem/ticLength", "0");
            props.put("defaultCoordinateSystem/axisAttributes/lineColor", "255");
            props.put("defaultCoordinateSystem/axisAttributes/lineThickness", "0.002");

            props.put("plot/legendVisible", "true");
            props.put("plot/coordinateSystem/xAxis/", "defaultCoordinateSystem/");
            props.put("plot/coordinateSystem/xAxis/minimum", "0.0");
            props.put("plot/coordinateSystem/xAxis/maximum", "2.0");
            props.put("plot/coordinateSystem/xAxis/axisLabel", "t");

            props.put("plot/coordinateSystem/yAxis/", "defaultCoordinateSystem/");
            props.put("plot/coordinateSystem/yAxis/axisLabel", "s(t)");
            props.put("plot/coordinateSystem/yAxis/maximum", "" + maximo);
            props.put("plot/coordinateSystem/yAxis/minimum", "" + minimo);

            props.put("plot/curveFactory/definitions", "curve");
            props.put("plot/curveFactory/curve/symbolFactory/attributes/className", "jcckit.graphic.ShapeAttributes");
            props.put("plot/curveFactory/curve/symbolFactory/attributes/fillColor", "0xfe8000");
            props.put("plot/curveFactory/curve/symbolFactory/attributes/lineColor", "0");
            props.put("plot/curveFactory/curve/symbolFactory/size", "0.08");


            // Creo un Canvas Para el JPanel
            GraphicsPlotCanvas2 myCanvas = new GraphicsPlotCanvas2(config);

            // Asocio el Canvas al DataPlot
            myCanvas.connect(myPlot);

            // borro todos los componentes del Jpanel
            jPanel1.removeAll();
            // agrego el gráfico nuevo al Jpanel       
            jPanel1.add(myCanvas.getGraphicsJPanel(), new org.netbeans.lib.awtextra.AbsoluteConstraints(-100, 1, 830, 400));
            // hago no visible y visible al Jpanel para actualizar 
            // no encontre otra forma
            jPanel1.setVisible(false);
            jPanel1.setVisible(true);
        }



    }//GEN-LAST:event_VisualizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(jComboBox2.getSelectedIndex()==0){
            velocidad.setText("300000000");
        }else if(jComboBox2.getSelectedIndex()==1){
            velocidad.setText("225000000");
        }else if(jComboBox2.getSelectedIndex()==2){
            velocidad.setText("340");
        }else if(jComboBox2.getSelectedIndex()==3){
            velocidad.setText("1600");
        }else if(jComboBox2.getSelectedIndex()==4){
            velocidad.setText("");
            velocidad.setEditable(true);
        }
    }

}