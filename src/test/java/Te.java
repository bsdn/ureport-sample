import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Te {
	public static Random random = new Random();

	private static String getRandomId(String prefix, int num) {
		String idStr = prefix;
		boolean flag = true;
		while (flag) {
			int id = random.nextInt(num);
			if (id > 0) {
				if (id < 10) {
					idStr += "000" + id;
					flag = false;
				} else if (id < 100) {
					idStr += "00" + id;
					flag = false;
				} else if (id < 1000) {
					idStr += "0" + id;
					flag = false;
				} else {
					idStr += "" + id;
					flag = false;
				}
			} else {
				continue;
			}
		}
		return idStr;
	}

	public static void t() {
		for (int i = 1000; i < 2000; i++) {
		}
	}

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		for (int i = 0; i < 1500; i++) {
			c.setTime(getRandomDate());
			System.out.println(sdf.format(c.getTime()) + " "
					+ (c.get(Calendar.MONTH) + 1) + " " + c.get(Calendar.YEAR));
		}
	}

	private static double getRandomDouble(int min, int max) {
		while (true) {
			double t = random.nextDouble() * 1000000;
			if (t >= min && t < max) {
				return t;
			}
		}
	}

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private static int getRandomInt(int min, int max) {
		while (true) {
			int t = random.nextInt(max);
			if (t > min && t < max) {
				return t;
			}
		}
	}

	public static Date getRandomDate() {
		List<String> dList = new ArrayList<String>();
		for (int i = 0; i < 50; i++) {
			if (i < 15) {
				dList.add("2012-" + getRandomInt(1, 12) + "-"
						+ getRandomInt(3, 29));
			} else if (i < 30) {
				dList.add("2013-" + getRandomInt(1, 12) + "-"
						+ getRandomInt(3, 29));
			} else {
				dList.add("2014-" + getRandomInt(1, 12) + "-"
						+ getRandomInt(3, 29));
			}
		}
		try {
			return sdf.parse(dList.get(getRandomInt(1, 50)));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
