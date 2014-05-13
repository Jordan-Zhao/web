package com.findher.web.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.findher.web.vo.Location;

public class Db {
	private static final Map<String, List<Location>> db = new HashMap<String, List<Location>>();

	public static void addContacter(String phoneNumber, String contacterNumber) {
		if (!db.containsKey(phoneNumber)) {
			db.put(phoneNumber, getTestLocation());
		}
		boolean b = false;	//联系人是否已存在
		for (Location loc : db.get(phoneNumber)) {
			if (loc.getPhoneNumber().equals(contacterNumber)) {
				b = true;
				break;
			}
		}
		if (!b) {
			Location location = new Location();
			location.setPhoneNumber(contacterNumber);
			location.setLat(getRandomLat());
			location.setLon(getRandomLon());
			db.get(phoneNumber).add(location);
		}
	}

	public static void updateMyLoc(String phoneNumber, double lat, double lon) {
		for (String key : db.keySet()) {
			for (Location loc : db.get(key)) {
				if (loc.getPhoneNumber().equals(phoneNumber)) {
					loc.setLat(lat);
					loc.setLon(lon);
				}
			}
		}
	}

	public static List<Location> updateContacterLoc(String myPhone) {
		return db.get(myPhone);
	}

	private static List<Location> getTestLocation() {
		List<Location> list = new ArrayList<Location>();
		for (int i = 0; i < 1; i++) {
			Location lo = new Location();
			lo.setPhoneNumber(getRandomPhone());
			lo.setLon(getRandomLon());
			lo.setLat(getRandomLat());
			list.add(lo);
			try {
				Thread.sleep((long) (new Random().nextDouble() * 100));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private static String getRandomPhone() {
		return "test" + String.valueOf(System.currentTimeMillis() % 139980235);
	}

	private static double getRandomLat() {
		return 30.232554 + new Random().nextDouble() / 100;
	}

	private static double getRandomLon() {
		return 120.000871 + new Random().nextDouble() / 100;
	}

	public static void main(String[] ar) {
		System.out.println(System.currentTimeMillis() % 139980235 + "---" + System.currentTimeMillis());
		System.out.println(new Random().nextDouble());

	}

}
