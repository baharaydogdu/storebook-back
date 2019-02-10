package com.pluralsight.storebook.util;

import java.util.Random;

public class IsbnGenarator implements NumberGenerator {

	@Override
	public String generateNumber() {
		return "13-" + Math.abs(new Random().nextInt());
	}
	

}
