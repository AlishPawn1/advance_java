package datebaseMVC;

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
}
