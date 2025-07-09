package datebaseMVC;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
public class FormController {
	private DBConnect db;
	private ResultSet rs;
	public FormController() {
		try {
			db = new DBConnect();
		}catch(Exception e){
			System.out.println(e);
		}
	}
	public void submitData(UserData user, FormViewInterface callback) {
		db.insertUser(user, new DatabaseCallback() 		{
			@Override
			public void onDataEntrySuccess() {
				callback.onSucess();
			}
			@Override
			public void onDataEntryFailure(String error) {
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
			rs = db.retriveUserList();
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
			rs = db.retriveUserSetUsers();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getString(5)
				});
			}
		}catch(Exception e) {
			System.out.println(e);
			return new DefaultTableModel();
		}
		return model;
	}
	public void updateTableDatas(UserData user) {
		try {
			rs.moveToInsertRow();
			rs.updateString(2, user.getName());
			rs.updateString(3, user.getEmail());
			rs.updateFloat(4, user.getHeight());
			rs.updateString(5, String.valueOf(user.getPhone()));
			rs.insertRow();
		}catch(Exception e) {}
	}
	public void deleteRow() {
		try {
			rs.last();
			rs.deleteRow();
		}catch(Exception e) {}
	}
}
