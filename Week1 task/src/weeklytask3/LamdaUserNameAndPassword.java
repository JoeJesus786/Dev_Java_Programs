package weeklytask3;

import java.util.function.BiPredicate;

public class LamdaUserNameAndPassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BiPredicate<String, String> authenticate = (username, password) -> "admin".equals(username) && "1234".equals(password);
		
		System.out.println(authenticate.test("admin", "1234"));
		System.out.println(authenticate.test("user", "pass"));
	}

}
