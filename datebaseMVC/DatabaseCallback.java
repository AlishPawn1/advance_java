package datebaseMVC;

public interface DatabaseCallback {

	void onDataEntrySuccess();
	void onDataEntryFailure(String error);
	
}
