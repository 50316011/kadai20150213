package kadai; 
 
 
 import kadai.FrameSystemView; 
 import kadai.DB_connect; 
 
 
 import java.awt.BorderLayout; 
 import java.awt.Component; 
 import java.awt.Label; 
 import java.awt.TextField; 
 import java.sql.ResultSet; 
 import java.sql.SQLException; 
 
 
 import org.jfree.chart.ChartFactory; 
 import org.jfree.chart.ChartPanel; 
 import org.jfree.chart.JFreeChart; 
 import org.jfree.chart.plot.PlotOrientation; 
 import org.jfree.data.category.DefaultCategoryDataset; 
 
 
 public class Kadai_main { 
 	 
 	static String name; 
 	static int rank,income; 
 	static ResultSet rs; 
 
 
 	public static void main(String[] args) { 
 		// TODO Auto-generated method stub 
 		FrameSystemView frame = new FrameSystemView(); 
 		DB_connect db = new DB_connect(); 
		DefaultCategoryDataset data = new DefaultCategoryDataset(); 
 		 
 		rs = db.selectAll(); 
 		 
 		try { 
 			while(rs.next()){ 
 				rank = rs.getInt("rank"); 
 			    name = rs.getString("name"); 
 			    income = rs.getInt("income"); 
 			    frame.add(new Label("rank" + String.valueOf(rank))); 
 			    frame.add(new Label("jobs" + String.valueOf(name))); 
 			    frame.add(new Label("income" + String.valueOf(income))); 
 			    data.addValue(income, "income", String.valueOf(name)); 
 
 
 			} 
 			JFreeChart chart =  
 					ChartFactory.createBarChart("income ranking of jobs", 
 				                                   "jobs", 
 				                                   "income", 
 				                                   data, 
 				                                   PlotOrientation.VERTICAL, 
 				                                   true, 
 				                                   false, 
 				                                   false); 
 
 
 				    ChartPanel cpanel = new ChartPanel(chart); 
 		frame.add(cpanel, BorderLayout.CENTER); 
 		} catch (SQLException e) { 
 			// TODO Auto-generated catch block 
 			e.printStackTrace(); 
 		} 
 	} 
 	} 
