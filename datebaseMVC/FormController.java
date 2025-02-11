package datebaseMVC;

import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class FormController {
	
	private DBConnect db;
	
	public FormController() {
		try {
			db = new DBConnect();
		}catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void submitData(UserData user, FormViewInterface callback) {
		db.insertUser(user, new DatabaseCallback() {

			@Override
			public void onDataEntrySuccess() {
				// TODO Auto-generated method stub
				callback.onSucess();
			}

			@Override
			public void onDataEntryFailure(String error) {
				// TODO Auto-generated method stub
				callback.onFailure(error);
			}
			
		});
	}
	
	public DefaultTableModel retriveUserData() {
		DefaultTableModel model = new DefaultTableModel();
		try {
			model.addColumn("Id");
			model.addColumn("Username");
			model.addColumn("Email");
			model.addColumn("Height");
			model.addColumn("Phone");
			ResultSet rs = db.retriveUserList();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)
				});
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return model;	
	}
	
	public DefaultTableModel retriveUser() {
		DefaultTableModel model = new DefaultTableModel();
		try {
			ResultSetMetaData metaData = (ResultSetMetaData) db.retriveUserSetUsers().getMetaData();
			for(int i=1; i<=metaData.getColumnCount(); i++) {
				model.addColumn(metaData.getColumnName(i));
			}
			ResultSet rs = db.retriveUserList();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)
				});
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return model;
	}
	
	
}
