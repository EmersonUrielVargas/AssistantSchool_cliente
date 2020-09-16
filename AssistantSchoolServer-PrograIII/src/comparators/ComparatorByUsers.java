package comparators;

import java.util.Comparator;

import models.User;

public class ComparatorByUsers implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		int result = 0;
		if (user1.getNickName().compareTo(user2.getNickName()) > 0) {
			result = 1;
		}
		if (user1.getNickName().compareTo(user2.getNickName()) < 0) {
			result = -1;
		}
		if (user1.getNickName().compareTo(user2.getNickName()) == 0) {
			result = 0;
		}

		return result;
	}
}
