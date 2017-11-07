package com.gwtjs.icustom.lottery;

import java.util.List;

/**
 * dlt
 * @author aGuang
 *
 */
public class Sample1 {

	public static void main(String[] args) {

		String s1 = "01 02 04 07 09 12 17 18 20 23 34";
		String s2 = "02 03 05 08 12 13 19 24 26 27 34";// 3
		String s3 = "01 03 05 07 08 11 22 25 27 33 35";
		String s4 = "03 04 08 09 15 19 21 24 26 28 33";
		String s5 = "03 09 15 17 21 23 24 28 30 33 34";// 3
		String s6 = "01 05 06 09 19 20 22 29 30 34 35";
		String s7 = "01 02 05 06 08 09 18 22 29 30 35";
		String s8 = "02 05 06 09 13 15 18 23 24 29 34";
		String s9 = "09 10 13 15 19 21 22 24 26 33 35";
		String s10 = "04 05 06 18 21 25 28 29 32 34 35";
		//String s11 = "2 3 6 9 12 14 15 18 23 26 27 28 30 31";// 3
		//String s12 = "8 13";// 有人双胆全包
		//String s13 = "7 27";// 有人双胆全包
		String s14 = "32 33 34 35";// 有人四胆全包
		String s15 = "1 7 9 17 34 35";// 杀号
		Combination com = new Combination();
		List<int[]> list = null;
		try {
			list = com.combine(Combination.bigLottery, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("1:"+list.size());

		// 三连号
		list = Combination.filterContinuation(list, 3, 5);
		System.out.println("过滤三连号:"+list.size());

		// 过滤以上合买复式，重点是第二个参数，表示有多少个号相同就抛弃，例如4个号相同就抛弃，即能中3个
		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s1, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 4, 5,
				Combination.initOther(s2, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s3, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s4, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 4, 5,
				Combination.initOther(s5, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s6, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s7, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s8, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s9, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 5,
				Combination.initOther(s10, Combination.typeBig));
		System.out.println(list.size());

		/*list = Combination.filterOther(list, 4, 5,
				Combination.initOther(s11, Combination.typeBig));*/
		System.out.println(list.size());

		list = Combination.filterOther(list, 4, 5,
				Combination.initOther(s14, Combination.typeBig));
		System.out.println(list.size());

		/*list = Combination.filterOther(list, 2, 5,
				Combination.initOther(s12, Combination.typeBig));*/
		System.out.println(list.size());

		/*list = Combination.filterOther(list, 2, 5,
				Combination.initOther(s13, Combination.typeBig));*/
		System.out.println(list.size());

		list = Combination.filterOther(list, 1, 5,
				Combination.initOther(s15, Combination.typeBig));
		System.out.println(list.size());
		// 打印结果
		Combination.printf(list);
		// String real="6 9 15 24 25 26";
		// Combination.checkResult(list,real,Combination.typeDouble);

	}

}
