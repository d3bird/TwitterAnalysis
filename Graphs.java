package twitter;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;

	

//@WebServlet(name = "DoChart", urlPatterns = {"/DoChart"})

public class Graphs extends ApplicationFrame {

	public Graphs(String title, double p, double n, double ne) {
	      super( title ); 
	      setContentPane(createGraph(p, n, ne ));
	}
 
	 private static PieDataset createDataset(double positive, double negative, double neutral ) {
	     
		 double p;
		 double n;
		 double ne;
		 
		 double total = positive + negative + neutral;
		 
		 p = positive/total;
		 n = negative/total;
		 ne = neutral/total;
		 
		  DefaultPieDataset dataset = new DefaultPieDataset( );
	      dataset.setValue( "Possitve" , p);  
	      dataset.setValue( "Negative" , n);   
	      dataset.setValue( "Neutral" , ne );    
	      return dataset;         
	   }
	 
	 private static JFreeChart createChart( PieDataset dataset ) {
	      JFreeChart chart = ChartFactory.createPieChart(      
	         "twitter stats",   // chart title 
	         dataset,          // data    
	         true,             // include legend   
	         true, 
	         false);

	      return chart;
	   }
	 
	 public static JPanel createGraph( double p, double n, double ne) {
	      JFreeChart chart = createChart(createDataset(p, n, ne ) );  
	      return new ChartPanel( chart ); 
	   }
	
	
}
