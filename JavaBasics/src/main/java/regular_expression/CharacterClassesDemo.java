package main.java.regular_expression;

import static main.java.regular_expression.RegularExpUtil.test;

import java.util.regex.Pattern;

/**
 * @author piyush.agarwal
 * Character Classes used to demonstrate
 * x
 * [abc]
 * [^abc]
 * [a-z]
 * [A-Z]
 * [a-zA-Z]
 * [0-9]
 * [a-zA-Z0-9]
 * [^a-zA-Z0-9]
 * [a-d[m-p]]
 * [a-z&&[def]]
 * [a-z&&[^bc]]
 * [a-z&&[^m-p]]
 */
public class CharacterClassesDemo {

	public static void main(String[] args) {
		
//		test("is", "This is called island");
//		test("[aeiou]", "i do understand vowel?");
//		test("[^ae$%]", "I want my $400");
//		test("[h-p]", "The letters are not arrange");
//		test("[A-Z]", "I got 40 OUT of 100");
//		test("[0-9]", "I got 40 OUT of 100");
//		test("[a-zA-Z0-9]", "I got 40% i.e $500");
//		test("[^a-zA-Z0-9 ]", "I got 40% i.e $500");
//		test("[a-e[m-p]]", "This is union of regex");
//		test("[a-z&&[defu]]", "do you know intersection");
//		test("[a-z&&[^adl]]", "I dont want all");
//		test("[a-z&&[^m-r]]", "dont accept a range");
		
		test("^#{1,1}[^#](.*![a-z]+).*#.*", "#!r#po#");
		String str = "!#!#!!y#b#w!wp!#!lhu!l!uef!lj!!lfmsuyj!!#!#o!!!x#b";
		int index = 0;
		int count = 0;
		int start = 0;
		int end = 0;
		while(str.indexOf("#", index) != -1) {
			start = str.indexOf("#", index);
			end = str.indexOf("#", start+1);
			String temp = str.substring(start+1, end);
			count += Pattern.compile("(![a-z])+").matcher(temp).groupCount();
			index = end + 1;
			
		}
		System.out.println(count);	
		
	}

}
