package cn.edu.bjut.gct.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagsFunction {
	public static String trimEnter(String text){
		Pattern CRLF = Pattern.compile("([\r\n|\r|\n|\n\r]*$)");
		Matcher m = CRLF.matcher(text.trim());

		if (m.find()) {
			text = m.replaceAll("");
		}
		return text;
	}
	public static String formatHTML(String text, String tags) {
		String html = text;
		Pattern CRLF = Pattern.compile("(\r\n|\r|\n|\n\r)");
		Matcher m = CRLF.matcher(trimEnter(text));

		if (m.find()) {
			html = m.replaceAll(tags);
		}
		return html;
	}

	/**
	 * 数字转中文数字
	 * @param number
	 * @return
	 */
	public static String formatNumber(String number) {
		char[] numArray = { '〇', '一', '二', '三', '四', '五', '六', '七', '八', '九' };
		char[] val = number.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < val.length; i++) {
			int n = Integer.valueOf(val[i] + "");
			sb.append(numArray[n]);
		}
		return sb.toString();
	}
	
	public static String formatBookID(int start, int count) {
		StringBuilder ids = new StringBuilder();
		for (int n = 0; n < count; n += 2) {
			String first = String.format("%03d", start + n);
			first = TagsFunction.formatNumber(first);
			String end = String.format("%03d", start + n + 1);
			end = TagsFunction.formatNumber(end);
			ids.append("第");
			ids.append(first);
			ids.append("册--第");
			ids.append(end);
			ids.append("册,");
		}
		ids.deleteCharAt(ids.length() - 1);
		return ids.toString();
	}
	
	public static void main(String[] args){
		String s = "aa\r\nbbbb\n";
		System.out.println(formatHTML(s, "|||"));
	}

}
