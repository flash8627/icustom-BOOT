package com.gwtjs.icustom.lottery;

import java.util.List;

/**
 * @author aGuang
 *
 */
public class CopyOfSample1 {

	public static void main(String[] args) {

		String s1 = "02 03 04 06 09 12 16 18 20 23 24 31";
		String s2 = "01 03 09 10 14 17 19 20 23 25 30 33";
		String s3 = "09 10 11 12 14 16 17 21 23 24 27 32";
		String s4 = "05 06 07 10 14 17 19 21 22 23 26 32";
		String s5 = "04 11 15 17 19 22 23 24 26 27 29 33";
		String s6 = "01 06 10 12 14 15 18 22 23 25 28 33";
		String s7 = "01 06 10 12 14 15 18 22 23 25 28 33";
		String s8 = "01 03 04 07 10 11 12 23 26 28 30 33";
		String s9 = "05 06 09 10 11 15 16 19 25 26 27 33";
		String s10 = "02 04 05 06 07 08 15 20 25 27 30 31";
		String s11 = "02 04 05 06 07 08 15 20 25 27 30 31";
		//String s12 = "8 13";// 有人双胆全包
		//String s13 = "7 27";// 有人双胆全包
		/*String s14 = "32 33 34 35";// 有人四胆全包
		String s15 = "1 7 9 17 34 35";*/// 杀号
		Combination com = new Combination();
		List<int[]> list = null;
		try {
			list = com.combine(Combination.bigLottery, 6);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("1:"+list.size());

		// 三连号
		list = Combination.filterContinuation(list, 4, 6);
		System.out.println("过滤三连号:"+list.size());

		// 过滤以上合买复式，重点是第二个参数，表示有多少个号相同就抛弃，例如4个号相同就抛弃，即能中3个
		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s1, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 4, 6,
				Combination.initOther(s2, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s3, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s4, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 4, 6,
				Combination.initOther(s5, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s6, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s7, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s8, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s9, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 3, 6,
				Combination.initOther(s10, Combination.typeBig));
		System.out.println(list.size());

		list = Combination.filterOther(list, 4, 6,
				Combination.initOther(s11, Combination.typeBig));
		System.out.println(list.size());

		/*list = Combination.filterOther(list, 4, 5,
				Combination.initOther(s14, Combination.typeBig));
		System.out.println(list.size());*/

		/*list = Combination.filterOther(list, 2, 5,
				Combination.initOther(s12, Combination.typeBig));
		System.out.println(list.size());
				*/

		/*list = Combination.filterOther(list, 2, 5,
				Combination.initOther(s13, Combination.typeBig));
		System.out.println(list.size());
				*/

		/*list = Combination.filterOther(list, 1, 5,
				Combination.initOther(s15, Combination.typeBig));
		System.out.println(list.size());*/
		// 打印结果
		Combination.printf(list);
		// String real="6 9 15 24 25 26";
		// Combination.checkResult(list,real,Combination.typeDouble);

	}

}
