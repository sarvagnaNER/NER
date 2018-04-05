import java.util.regex.*;
import java.util.*;

class RegexNER
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();

		String regexCheckerPercent = "[100]%&|^[0-9]{2}%$";	
		String regexCheckerPhone = "(?:(?:\\+|0{0,2})91(\\s*[\\- ]\\s*)?|[0 ]?)?[789]\\d{9}|(\\d[ -]?){10}\\d";
		//String regexCheckerURL = "\\b((https?|ftp|file|ldap)://)?[A-Za-z0-9+&@#/%?=~_|!:,.;]*[-AZa-z0-9+&@#/%=~_|]";
		String regexCheckerURL = "((https?|ftp|file|ldap)://)?[w]{3}\\.[A-Za-z]{2,25}\\.[A-Za-z]{2,6}(\\.[A-Za-z]{2,6})?";
		String regexCheckerDate = "((0?[13578]|10|12)(-|\\/)(([1-9])|(0[1-9])|([12])([0-9]?)|(3[01]?))(-|\\/)((19)([2-9])(\\d{1})|(20)([01])(\\d{1})|([8901])(\\d{1}))|(0?[2469]|11)(-|\\/) (([1-9])|(0[1-9])|([12])([09]?)|(3[0]?))(-|\\/)((19)([2-9])(\\d{1})|(20)([01])(\\d{1})|([8901])(\\d{1})))";
		String regexCheckerTime = "(([0-1]?[0-9])|([2][0-3])):([05]?[0-9])(:([0-5]?[0-9]))?";
		String regexCheckerZIP = "^[1-9][0-9]{5}$";
		String[] regexChecker=  {regexCheckerPercent,regexCheckerPhone,regexCheckerURL,regexCheckerDate,regexCheckerTime,regexCheckerZIP};
		String[] label = {"Percentage","Phone","URL","Date","Time","ZIP"};


		for(int i=0;i<6;i++)
		{
			Pattern check = Pattern.compile(regexChecker[i]);
			Matcher regexMatcher = check.matcher(test);
			while(regexMatcher.find())
			{
				if(regexMatcher.group().length()!=0)
				{
					System.out.println(regexMatcher.group().trim()+" : "+label[i]);
				}
			}
		}
	}
}