package com.gwtjs.icustom.lottery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Combination {

	public final static int typeDouble = 33;
	public final static int typeBig = 35;

	// 大乐透
	public static final int[] bigLottery = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
			12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
			29, 30, 31, 32, 33, 34, 35 };

	// 双色球
	public static final int[] doublecolor = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27,
			28, 29, 30, 31, 32, 33 };

	static String s1 = "4 6 7 11 12 13 17 22 14 28 29 33";
	static String s2 = "1 4 10 11 14 18 29 30 33";
	static String s3 = "1 2 5 9 12 13 14 18 23 27 30 31";
	static String s4 = "6 10 11 12 13 14 18 19 21 28 31 35";
	static String s5 = "3 6 10 13 21 23 24 25 26 32 33";
	static String s6 = "2 4 6 7 11 13 17 18 19 21 23 24 25 26 31 32 35";
	static String s7 = "1 7 10 13 15 17 22 25 26 32 33 34";
	static String s8 = "1 5 6 10 11 12 15 25 29 30 31 35";
	static String s9 = "4 8 11 12 21 23 24 27 32";
	static String s10 = "4 7 9 11 16 23 26 31 34";
	static String s11 = "3 5 6 9 16 22 24 27 31 32";
	static String s12 = "1 2 4 7 10 12 14 18 26 29 30 32 34";
	static String s13 = "2 10 13 16 19 22 25 28 29 31 33 34 35";
	static String s14 = "2 9 10 15 16 17 22 23 25 26 32 33 34";
	static String s15 = "2 3 10 14 16 17 20 22 24 27 28 31 32";
	static String s16 = "2 4 7 8 10 12 16 17 23 24 27 31 34";
	static String s17 = "2 6 7 9 12 21 22 23 25 29 31 33 35";
	static String s18 = "1 6 9 11 12 15 16 19 23 27 28 31 33";
	static String s19 = "4 6 8 11 12 16 17 24 25 26 31 33 35";
	static String s20 = "2 7 8 9 10 11 16 18 19 28 31 32 33";
	static String s21 = "4 7 8 9 10 12 15 16 23 29 31 32 33";
	static String s22 = "3 4 7 8 9 14 15 17 20 21 26 27 29 34 35";
	static String s23 = "1 4 6 10 13 14 18 19 20 25 26 27 28 32 34";
	static String s24 = "1 2 4 9 12 13 17 18 19 22 23 25 27 30 33";
	static String s25 = "3 5 6 10 13 15 16 17 19 21 27 33 35";
	static String s26 = "2 3 6 8 11 13 18 19 20 22 25 27 28";
	static String s27 = "2 3 4 12 14 16 19 22 24 25 26 33 34";
	static String s28 = "4 5 6 7 8 10 11 12 15 16 18 19 20 24 26 27 28 32";
	static String s29 = "4 11 17 20 29";

	public static void main(String[] args) {

		Combination com = new Combination();
		List<int[]> list = null;
		try {
			list = com.combine(bigLottery, 5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// com.print(list);
		System.out.println(list.size());

		list = filterContinuation(list, 3, 5);

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s1, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s2, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s3, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s4, typeBig));

		System.out.println(list.size());
		list = filterOther(list, 3, 5, initOther(s5, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s6, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s7, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s8, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s9, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s10, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s11, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s12, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s13, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s14, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s15, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s16, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s17, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s18, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s19, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s20, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s21, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s22, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s23, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s24, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s25, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s26, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s27, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 3, 5, initOther(s28, typeBig));

		System.out.println(list.size());

		list = filterOther(list, 1, 5, initOther(s29, typeBig));

		System.out.println(list.size());

		printf(list);
	}

	/**
	 * 移位组合算法
	 * 
	 * @param base
	 * @param num
	 * @return
	 * @throws Exception
	 */
	public List<int[]> combine(int[] base, int num) throws Exception {
		System.out.println(base.toString());
		int n = base.length;
		if (num > n) {
			throw new Exception("错误！数组a中只有" + n + "个元素。" + num + "大于" + n
					+ "!!!");
		}

		List<int[]> result = new ArrayList<int[]>();

		int[] bs = new int[n];
		for (int i = 0; i < n; i++) {
			bs[i] = 0;
		}
		// 初始化 66.
		for (int i = 0; i < num; i++) {
			bs[i] = 1;
		}
		boolean flag = true;
		boolean tempFlag = false;
		int pos = 0;
		int sum = 0;
		// 首先找到第一个10组合，然后变成01，同时将左边所有的1移动到数组的最左边 74.
		do {
			sum = 0;
			pos = 0;
			tempFlag = true;

			result.add(bs.clone());

			for (int i = 0; i < n - 1; i++) {
				if (bs[i] == 1 && bs[i + 1] == 0) {
					bs[i] = 0;
					bs[i + 1] = 1;
					pos = i;
					break;
				}
			}
			// 将左边的1全部移动到数组的最左边
			for (int i = 0; i < pos; i++) {
				if (bs[i] == 1) {
					sum++;
				}
			}
			for (int i = 0; i < pos; i++) {
				if (i < sum) {
					bs[i] = 1;
				} else {
					bs[i] = 0;
				}
			}

			// 检查是否所有的1都移动到了最右边 104.
			for (int i = n - num; i < n; i++) {
				if (bs[i] == 0) {
					tempFlag = false;
					break;
				}
			}
			if (tempFlag == false) {
				flag = true;
			} else {
				flag = false;
			}

		} while (flag);

		result.add(bs.clone());
		// viewResults(result);
		return result;
	}

	/**
	 * 打印
	 *
	 * @param l
	 */
	public static void print(List<int[]> list) {
		for (int i = 0; i < list.size(); i++) {
			int[] a = (int[]) list.get(i);
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[j] + "\t");
			}
			System.out.println();
		}
	}

	/**
	 * 打印结果
	 *
	 * @param l
	 */
	public static void printf(List<int[]> list) {
		for (int i = 0; i < list.size(); i++) {
			int[] a = (int[]) list.get(i);
			for (int j = 0; j < a.length; j++) {
				if (a[j] == 1) {
					System.out.print(j + 1 + "\t");
				}

			}
			System.out.println();
		}
	}

	/**
	 * 过滤连号
	 * 
	 * @param seqNUm
	 *            连号个数
	 * @param total
	 *            球个数
	 */
	public static List<int[]> filterContinuation(List<int[]> base, int seqNUm,
			int total) {
		Iterator<int[]> i = base.iterator();
		List<int[]> rtn = new LinkedList<int[]>();
		int[] tmp = null;
		int nums = 0;// 遇到红球个数计数
		int same = 0;// 连号个数计数
		boolean isValid = true;// 是否符合要求
		while (i.hasNext()) {
			tmp = (int[]) i.next();

			for (int k = 0; k < tmp.length; k++) {
				if (tmp[k] == 1) {
					nums++;
					same++;
					if (same == seqNUm) {// 连号个数达到设定
						isValid = false;
						break;
					}
					if (nums == total) {// 对比结束，不往后循环
						break;
					}
				} else {
					same = 0;
				}
			}
			if (isValid) {
				rtn.add(tmp);
			}
			isValid = true;
			nums = 0;
		}
		return rtn;
	}

	/**
	 * 过滤其他人的号
	 * 
	 * @param seqNUm
	 *            同号个数
	 * @param total
	 *            球个数
	 */
	public static List<int[]> filterOther(List<int[]> base, int seqNUm,
			int total, int[] other) {
		Iterator<int[]> i = base.iterator();
		List<int[]> rtn = new LinkedList<int[]>();
		int[] tmp = null;
		int nums = 0;// 遇到红球个数计数
		int same = 0;// 连号个数计数
		boolean isValid = true;// 是否符合要求
		while (i.hasNext()) {
			tmp = (int[]) i.next();

			for (int k = 0; k < tmp.length; k++) {
				if (tmp[k] == 1) {
					nums++;
					if (other[k] == 1) {
						same++;
						if (same == seqNUm) {// 同号个数达到设定
							isValid = false;
							break;
						}
					}

					if (nums == total) {// 对比结束，不往后循环
						break;
					}
				}
			}
			if (isValid) {
				rtn.add(tmp);
			}
			isValid = true;
			nums = 0;
			same = 0;
		}
		return rtn;
	}

	/**
	 * 打印result内容
	 * 
	 * @param result
	 */
	public static void viewResults(List<int[]> result) {
		Iterator<int[]> i = result.iterator();
		while (i.hasNext()) {
			int[] rs = (int[]) i.next();
			for (int inti = 0; inti < rs.length; inti++) {
				System.out.print(rs[inti]);
			}
			System.out.println();
		}
	}

	/**
	 * 解析投注为有效处理投注
	 * 
	 * @param s
	 * @return
	 */
	public static int[] initOther(String s, int type) {
		int[] other = new int[type];
		String[] nums = s.split(" ");
		for (int i = 0; i < nums.length; i++) {
			other[Integer.parseInt(nums[i]) - 1] = 1;
		}
		return other;
	}

	/**
	 * 解析投注为有效处理投注
	 * 
	 * @param s
	 * @return
	 */
	public static void checkResult(List<int[]> result, String real, int type) {
		int[] re = initOther(real, type);
		int same = 0;
		for (int i = 0; i < result.size(); i++) {
			int[] a = (int[]) result.get(i);
			for (int j = 0; j < a.length; j++) {
				if (a[j] == 1) {
					System.out.print(j + 1 + "\t");
					if (re[j] == 1) {
						same++;
					}
				}

			}
			System.out.print(same);
			if ((type == typeDouble && same == 6)
					|| (type == typeBig && same == 5)) {
				return;
			}
			same = 0;
			System.out.println();
		}
	}

	/**
	 * 将01代码转换为实际球
	 *
	 * @param base
	 *            计算出的01编码结果集
	 * @param actual
	 *            实际数字
	 * @param num
	 *            目标结果大小，
	 * @return
	 */
	private int[] codeToReal(int[] base, int[] actual, int num) {
		int[] result = new int[num];
		int pos = 0;
		for (int i = 0; i < base.length; i++) {
			if (base[i] == 1) {
				result[pos] = actual[i];
				pos++;
			}
		}
		return result;
	}

	/**
	 * 过滤其他人的号
	 * 
	 * @param seqNUm
	 *            同号个数
	 * @param total
	 *            球个数
	 */
	private static List<int[]> filterKill(List<int[]> base, int seqNUm,
			int total, int[] other) {
		Iterator<int[]> i = base.iterator();
		List<int[]> rtn = new LinkedList<int[]>();
		int[] tmp = null;
		int nums = 0;// 遇到红球个数计数
		int same = 0;// 连号个数计数
		boolean isValid = true;// 是否符合要求
		while (i.hasNext()) {
			tmp = (int[]) i.next();

			for (int k = 0; k < tmp.length; k++) {
				if (tmp[k] == 1) {
					nums++;
					if (other[k] == 1) {
						same++;
						if (same == seqNUm) {// 同号个数达到设定
							isValid = false;
							break;
						}
					}

					if (nums == total) {// 对比结束，不往后循环
						break;
					}
				}
			}
			if (isValid) {
				rtn.add(tmp);
			}
			isValid = true;
			nums = 0;
			same = 0;
		}
		return rtn;
	}

}
