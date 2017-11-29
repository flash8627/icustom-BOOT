package com.gwtjs.icustom.kindeditor.util;

/**
 * 文本转义
 * @author aGuang
 *
 */
public class HtmlSpecialChars {
	
	
	/**
	 * 输入字符转义
	 * 不够 再加字符
	 * @param inChars
	 * @return
	 */
	static public String inHtmlspecialchars(String inChars)
	{
		if(inChars==null || inChars.equals(""))
			return "";
		String str = inChars;
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		str = str.replaceAll("\'", "&#39;");
		str = str.replaceAll("%", "&#37;");
		str = str.replaceAll("+", "&#43;");
		return str;
	}
	
	/**
	 * 输入字符转义
	 * @param outChars
	 * @return
	 */
	static public String outHtmlspecialchars(String outChars)
	{
		String chars = "";
		
		return chars;
	}
	
}
