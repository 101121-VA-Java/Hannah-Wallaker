import java.util.HashMap;

public class IDandPasswords {

	HashMap<String, String> logininfo = new HashMap<String, String>();

	IDandPasswords() {
		logininfo.put(Hannah, Wallaker);
		logininfo.put(Noah, Wallaker);
		logininfo.put(Jesus, Christ);

	}

	protected HashMap getLoginInfo() {
		return logininfo;

	}
}