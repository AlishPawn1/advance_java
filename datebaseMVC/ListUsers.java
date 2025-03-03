package datebaseMVC;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ListUsers extends JPanel {
	private FormController controller;
	
	public ListUsers() {
		setLayout(new BorderLayout());
		controller = new FormController();
		
		try {
			JTable table = new JTable();
			table.setModel(controller.retriveUserData());
			JScrollPane scrollPane = new JScrollPane(table);
			add(scrollPane, BorderLayout.CENTER);
			
			JTable table1 = new JTable();
			table1.setModel(controller.retriveUser());
			JScrollPane scrollPane1 = new JScrollPane(table1);
			add(scrollPane1, BorderLayout.NORTH);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		controller.updateTableDatas(new UserData("update", "update@gmail.com", ( float ) 5.6, ( long ) 9874521));
		controller.deleteRow();
	}
	
	
}
