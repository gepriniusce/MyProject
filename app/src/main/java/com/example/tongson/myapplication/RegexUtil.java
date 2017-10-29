package com.example.tongson.myapplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <b>Create Date:</b> 2017/10/29<br>
 * <b>Email:</b> 289286298@qq.com<br>
 * <b>Description:</b>  <br>
 *
 * @author Tongson
 */
public class RegexUtil {
    /**
     * @param email E Mail address
     * @return boolean Flag demonstrating if it's a valid email
     */
    public boolean isValidEmail(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";

        isValid = matchPattern(expression, email);

        return isValid;
    }

    /**
     * @param phone Mobile phone number
     * @return boolean Flag indicating if it's a valid mobile phone
     */
    public boolean isValidMobilePhone(String phone) {
        boolean isValid = false;
        String expression = "^[1-9]{3}[-, ][0-9]{3}[-, ][0-9]{4}$";

        if (phone.length() > 9) {
            if (Character.isDigit(phone.charAt(3)) && Character.isDigit(phone.charAt(7))) {
                phone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);

                System.out.println("Phone : " + phone);
            }

            isValid = matchPattern(expression, phone);
        }

        return isValid;
    }

    /**
     * @param name Person's first name
     * @return boolean Flag indicating if it's a valid first name of person
     */
    public boolean isValidFirstName(String name) {
        boolean isValid = false;
        String expression = "[a-zA-Z]+(')*[a-zA-Z]+";

        isValid = matchPattern(expression, name);

        return isValid;
    }

    /**
     * @param name Person's last name
     * @return boolean Flag indicating if it's a valid last name
     */
    public boolean isValidLastName(String name) {
        boolean isValid = false;
        String expression = "[a-zA-Z]+(')*[a-zA-Z]+";

        isValid = matchPattern(expression, name);

        return isValid;
    }

    /**
     * @param uri URI/URL
     * @return boolean Flag indicating if it's valid URI / URL
     */
    public boolean isValidURI(String uri) {
        boolean isValid = false;
        String expression = "^(http|https|ftp)\\:\\/\\/(((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])|([a-zA-Z0-9_\\-\\.])+\\.(com|net|org|edu|int|mil|gov|arpa|biz|aero|name|coop|info|pro|museum|uk|me))((:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\\-\\._\\?\\,\\'/\\\\\\+&amp;%\\$#\\=~])*)$";

        isValid = matchPattern(expression, uri);

        return isValid;
    }

    /**
     * @param amount Amount number
     * @return boolean Flag indicating if it's valid amount in dollar
     */
    public boolean isValidAmountInDollar(String amount) {
        boolean isValid = false;
        String expression = "^(\\$)?(([1-9]\\d{0,2}(\\,\\d{3})*)|([1-9]\\d*)|(0))(\\.\\d{2})?$";

        isValid = matchPattern(expression, amount);

        return isValid;
    }

    /**
     * @param fileName File name
     * @return boolean Flag indicating if it's valid file name
     */
    public boolean isValidFileName(String fileName) {
        boolean isValid = false;
        String expression = "([a-zA-Z0-9]*\\.)[a-z]{1,4}$";

        isValid = matchPattern(expression, fileName);

        return isValid;
    }

    /**
     * @param fileName      File name
     * @param fileExtension file extension that needs to be validated in the given file name
     * @return boolean Flag indicating if it's a valid file name along with it's provided extension.
     */
    public boolean isValidFileName(String fileName, String fileExtension) {
        boolean isValid = false;
        String expression = "([a-zA-Z0-9]*\\.)" + fileExtension + "$";

        isValid = matchPattern(expression, fileName);

        return isValid;
    }

    /**
     * @param s Input string
     * @return boolean Flag indicating if it's valid alpha numeric word
     */
    public boolean isValidAlphaNumericWord(String s) {
        boolean isValid = false;
        String expression = "[A-Za-z0-9]+";

        isValid = matchPattern(expression, s);

        return isValid;
    }

    /**
     * @param c Input character
     * @return boolean Flag indicating if it's valid alpha numeric character
     */
    public boolean isValidAlphaNumericCharacter(Character c) {
        boolean isValid = false;
        String expression = "[A-Za-z0-9]";

        isValid = matchPattern(expression, c.toString());

        return isValid;
    }

    /**
     * @param s Input string
     * @return boolean Flag indicating if it's valid alphabetic word
     */
    public boolean isAlphabeticWords(String s) {
        boolean isValid = false;
        String expression = "[a-zA-Z]+";

        isValid = matchPattern(expression, s);

        return isValid;
    }

    /**
     * @param c Input character
     * @return boolean Flag indicating if it's valid alphabetic character
     */
    public boolean isAlphabeticCharacter(Character c) {
        boolean isValid = false;
        String expression = "[a-zA-Z]";

        isValid = matchPattern(expression, c.toString());

        return isValid;
    }

    /**
     * @param number Input number
     * @return boolean Flag indicating if it's valid hexadecimal number
     */
    public boolean isValidHexadecimalNumber(int number) {
        boolean isValid = false;
        String expression = "[A-Fa-f0-9]+";

        isValid = matchPattern(expression, String.valueOf(number));

        return isValid;
    }

    /**
     * @param number Input number
     * @return boolean Flag indicating if it's valid octal number
     */
    public boolean isValidOctalNumber(int number) {
        boolean isValid = false;
        String expression = "[0-7]+";

        isValid = matchPattern(expression, String.valueOf(number));

        return isValid;
    }

    /**
     * @param number Input number
     * @return boolean Flag indicating if it's valid integer number
     */
    public boolean isValidInteger(String number) {
        boolean isValid = false;
        String expression = "^([0-9]+)([0-9,]*)";

        isValid = matchPattern(expression, number);

        return isValid;
    }

    /**
     * @param number Input number
     * @return boolean Flag indicating if it's valid float number
     */
    public boolean isValidFloat(String number) {
        boolean isValid = false;
        String expression = "^([0-9]+)([\\d,]*).([0-9]+)";

        isValid = matchPattern(expression, number);

        return isValid;
    }

    /**
     * @param s Input string
     * @return boolean Flag indicating if it's valid string
     */
    public boolean isValidString(String s) {
        boolean isValid = false;
        String expression = "^[^<>`~!/@\\#}$%:;)(_^{&*=|'+]+$";

        isValid = matchPattern(expression, s);

        return isValid;
    }

    /**
     * @param date Input date
     * @return boolean Flag indicating if date is in a valid format
     */
    public boolean isValidDate(String date) {
        boolean isValid = false;
        String expression = "^([\\d]{4})([-:/])((0?[1-9])|((1)([0-2])))([-:/])((0?[1-9])|((1)[0-9])|((2)[0-9])|((3)[0-1]))$";

        isValid = matchPattern(expression, date);

        return isValid;
    }

    private boolean matchPattern(String expression, String stringPattern) {
        boolean isValid = false;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(stringPattern);

        if (matcher.matches()) {
            isValid = true;
        }

        return isValid;
    }


    //    /**
    //     * 验证Email
    //     *
    //     * @param email email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkEmail(String email) {
    //        String regex = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
    //        return Pattern.matches(regex, email);
    //    }
    //
    //    /**
    //     * 验证身份证号码
    //     *
    //     * @param idCard 居民身份证号码18位，第一位不能为0，最后一位可能是数字或字母，中间16位为数字 \d同[0-9]
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkIdCard(String idCard) {
    //        String regex = "[1-9]\\d{16}[a-zA-Z0-9]{1}";
    //        return Pattern.matches(regex, idCard);
    //    }
    //
    //    /**
    //     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
    //     *
    //     * @param mobile 移动、联通、电信运营商的号码段
    //     *               <p>移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
    //     *               、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）</p>
    //     *               <p>联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）</p>
    //     *               <p>电信的号段：133、153、180（未启用）、189</p>
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkMobile(String mobile) {
    //        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
    //        return Pattern.matches(regex, mobile);
    //    }
    //
    //    /**
    //     * 验证固定电话号码
    //     *
    //     * @param phone 电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
    //     *              <p><b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9 的一位或多位数字，
    //     *              数字之后是空格分隔的国家（地区）代码。</p>
    //     *              <p><b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
    //     *              对不使用地区或城市代码的国家（地区），则省略该组件。</p>
    //     *              <p><b>电话号码：</b>这包含从 0 到 9 的一个或多个数字 </p>
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkPhone(String phone) {
    //        String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
    //        return Pattern.matches(regex, phone);
    //    }
    //
    //    /**
    //     * 验证整数（正整数和负整数）
    //     *
    //     * @param digit 一位或多位0-9之间的整数
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkDigit(String digit) {
    //        String regex = "\\-?[1-9]\\d+";
    //        return Pattern.matches(regex, digit);
    //    }
    //
    //    /**
    //     * 验证整数和浮点数（正负整数和正负浮点数）
    //     *
    //     * @param decimals 一位或多位0-9之间的浮点数，如：1.23，233.30
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkDecimals(String decimals) {
    //        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
    //        return Pattern.matches(regex, decimals);
    //    }
    //
    //    /**
    //     * 验证空白字符
    //     *
    //     * @param blankSpace 空白字符，包括：空格、\t、\n、\r、\f、\x0B
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkBlankSpace(String blankSpace) {
    //        String regex = "\\s+";
    //        return Pattern.matches(regex, blankSpace);
    //    }
    //
    //    /**
    //     * 验证中文
    //     *
    //     * @param chinese 中文字符
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkChinese(String chinese) {
    //        String regex = "^[\u4E00-\u9FA5]+$";
    //        return Pattern.matches(regex, chinese);
    //    }
    //
    //    /**
    //     * 验证日期（年月日）
    //     *
    //     * @param birthday 日期，格式：1992-09-03，或1992.09.03
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkBirthday(String birthday) {
    //        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
    //        return Pattern.matches(regex, birthday);
    //    }
    //
    //    /**
    //     * 验证URL地址
    //     *
    //     * @param url 格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或 http://www.csdn.net:80
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkURL(String url) {
    //        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
    //        return Pattern.matches(regex, url);
    //    }
    //
    //    /**
    //     * <pre>
    //     * 获取网址 URL 的一级域名
    //     * http://detail.tmall.com/item.htm?spm=a230r.1.10.44.1xpDSH&id=15453106243&_u=f4ve1uq1092 ->> tmall.com
    //     * </pre>
    //     *
    //     * @param url
    //     * @return
    //     */
    //    public static String getDomain(String url) {
    //        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
    //        // 获取完整的域名
    //        // Pattern p=Pattern.compile("[^//]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
    //        Matcher matcher = p.matcher(url);
    //        matcher.find();
    //        return matcher.group();
    //    }
    //
    //    /**
    //     * 匹配中国邮政编码
    //     *
    //     * @param postcode 邮政编码
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkPostcode(String postcode) {
    //        String regex = "[1-9]\\d{5}";
    //        return Pattern.matches(regex, postcode);
    //    }
    //
    //    /**
    //     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
    //     *
    //     * @param ipAddress IPv4标准地址
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkIpAddress(String ipAddress) {
    //        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
    //        return Pattern.matches(regex, ipAddress);
    //    }
    //
    //
    //    /**
    //     * 验证Email
    //     *
    //     * @param email
    //     *            email地址，格式：zhangsan@sina.com，zhangsan@xxx.com.cn，xxx代表邮件服务商
    //     * @return 验证成功返回true，验证失败返回false ^ ：匹配输入的开始位置。 \：将下一个字符标记为特殊字符或字面值。
    //     *         ：匹配前一个字符零次或几次。 + ：匹配前一个字符一次或多次。 (pattern) 与模式匹配并记住匹配。 x|y：匹配 x 或
    //     *         y。 [a-z] ：表示某个范围内的字符。与指定区间内的任何字符匹配。 \w ：与任何单词字符匹配，包括下划线。
    //     *
    //     *         {n,m} 最少匹配 n 次且最多匹配 m 次 $ ：匹配输入的结尾。
    //     */
    //    public static boolean checkEmail(String email) {
    //        String regex = "^(\\w)+(\\.\\w+)*@(\\w)+((\\.\\w{2,3}){1,3})$";
    //        return Pattern.matches(regex, email);
    //    }
    //
    //    /**
    //     * 验证身份证号码
    //     *
    //     * @param idCard
    //     *            居民身份证号码15位或18位，最后一位可能是数字或字母
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkIdCard(String idCard) {
    //        String regex = "[1-9]\\d{13,16}[a-zA-Z0-9]{1}";
    //        return Pattern.matches(regex, idCard);
    //    }
    //
    //    /**
    //     * 验证手机号码（支持国际格式，+86135xxxx...（中国内地），+00852137xxxx...（中国香港））
    //     *
    //     * @param mobile
    //     *            移动、联通、电信运营商的号码段
    //     *            <p>
    //     *            移动的号段：134(0-8)、135、136、137、138、139、147（预计用于TD上网卡）
    //     *            、150、151、152、157（TD专用）、158、159、187（未启用）、188（TD专用）
    //     *            </p>
    //     *            <p>
    //     *            联通的号段：130、131、132、155、156（世界风专用）、185（未启用）、186（3g）
    //     *            </p>
    //     *            <p>
    //     *            电信的号段：133、153、180（未启用）、189
    //     *            </p>
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkMobile(String mobile) {
    //        String regex = "(\\+\\d+)?1[3458]\\d{9}$";
    //        return Pattern.matches(regex, mobile);
    //    }
    //
    //    /**
    //     * 验证固定电话号码
    //     *
    //     * @param phone
    //     *            电话号码，格式：国家（地区）电话代码 + 区号（城市代码） + 电话号码，如：+8602085588447
    //     *            <p>
    //     *            <b>国家（地区） 代码 ：</b>标识电话号码的国家（地区）的标准国家（地区）代码。它包含从 0 到 9
    //     *            的一位或多位数字， 数字之后是空格分隔的国家（地区）代码。
    //     *            </p>
    //     *            <p>
    //     *            <b>区号（城市代码）：</b>这可能包含一个或多个从 0 到 9 的数字，地区或城市代码放在圆括号——
    //     *            对不使用地区或城市代码的国家（地区），则省略该组件。
    //     *            </p>
    //     *            <p>
    //     *            <b>电话号码：</b>这包含从 0 到 9 的一个或多个数字
    //     *            </p>
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkPhone(String phone) {
    //        // String regex = "(\\+\\d+)?(\\d{3,4}\\-?)?\\d{7,8}$";
    //        String regex = "^1\\d{10}$";
    //        return Pattern.matches(regex, phone);
    //    }
    //
    //    /**
    //     * 验证整数（正整数和负整数）
    //     *
    //     * @param digit
    //     *            一位或多位0-9之间的整数
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkDigit(String digit) {
    //        String regex = "\\-?[1-9]\\d+";
    //        return Pattern.matches(regex, digit);
    //    }
    //
    //    /**
    //     * 验证整数和浮点数（正负整数和正负浮点数）
    //     *
    //     * @param decimals
    //     *            一位或多位0-9之间的浮点数，如：1.23，233.30
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkDecimals(String decimals) {
    //        String regex = "\\-?[1-9]\\d+(\\.\\d+)?";
    //        return Pattern.matches(regex, decimals);
    //    }
    //
    //    /**
    //     * 验证空白字符
    //     *
    //     * @param blankSpace
    //     *            空白字符，包括：空格、\t、\n、\r、\f、\x0B
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkBlankSpace(String blankSpace) {
    //        String regex = "\\s+";
    //        return Pattern.matches(regex, blankSpace);
    //    }
    //
    //    /**
    //     * 验证中文
    //     *
    //     * @param chinese
    //     *            中文字符
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkChinese(String chinese) {
    //        String regex = "^[\u4E00-\u9FA5]+$";
    //        return Pattern.matches(regex, chinese);
    //    }
    //
    //    /**
    //     * 验证日期（年月日）
    //     *
    //     * @param birthday
    //     *            日期，格式：1992-09-03，或1992.09.03
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkBirthday(String birthday) {
    //        String regex = "[1-9]{4}([-./])\\d{1,2}\\1\\d{1,2}";
    //        return Pattern.matches(regex, birthday);
    //    }
    //
    //    /**
    //     * 验证URL地址
    //     *
    //     * @param url
    //     *            格式：http://blog.csdn.net:80/xyang81/article/details/7705960? 或
    //     *            http://www.csdn.net:80
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkURL(String url) {
    //        String regex = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
    //        return Pattern.matches(regex, url);
    //    }
    //
    //    /**
    //     * 匹配中国邮政编码
    //     *
    //     * @param postcode
    //     *            邮政编码
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkPostcode(String postcode) {
    //        String regex = "[1-9]\\d{5}";
    //        return Pattern.matches(regex, postcode);
    //    }
    //
    //    /**
    //     * 匹配IP地址(简单匹配，格式，如：192.168.1.1，127.0.0.1，没有匹配IP段的大小)
    //     *
    //     * @param ipAddress
    //     *            IPv4标准地址
    //     * @return 验证成功返回true，验证失败返回false
    //     */
    //    public static boolean checkIpAddress(String ipAddress) {
    //        String regex = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
    //        return Pattern.matches(regex, ipAddress);
    //    }
    public static boolean checkNickname(String nickname) {
        String regex = "^[a-zA-Z0-9\u4E00-\u9FA5_]+$";
        return Pattern.matches(regex, nickname);
    }


    public static boolean hasCrossSciptRiskInAddress(String str) {
        String regx = "[`~!@#$%^&*+=|{}':;',\\[\\].<>~！@#￥%……&*——+|{}【】‘；：”“’。，、？-]";
        if (str != null) {
            str = str.trim();
            Pattern p = Pattern.compile(regx, Pattern.CASE_INSENSITIVE);
            Matcher m = p.matcher(str);
            return m.find();
        }
        return false;
    }


    /**
     * 根据正则表达式返还匹配结果
     */
    private static boolean matcherString(String value, String strRegex) {
        Pattern p = Pattern.compile(strRegex);
        Matcher m = p.matcher(value);
        return m.matches();
    }

    /**
     * 匹配非特殊字符
     */
    public static boolean matcherIllegal(String value) {
        String str = "^([a-zA-Z0-9]|[._]|[\\u4E00-\\u9FA5]){1,20}$";
        return matcherString(value, str);
    }

    /**
     * 字母开头，匹配字母、数字、下划线
     */
    public static boolean matcherPasswordCode(String value) {
        String str = "^[a-zA-Z][a-zA-Z0-9_]{6,16}$";
        return matcherString(value, str);
    }

    /**
     * 匹配字母、数字、下划线
     */
    public static boolean matcherPassword(String value) {
        String str = "[a-zA-Z0-9_]{6,16}$";
        return matcherString(value, str);
    }

    /**
     * 匹配邮箱
     */
    public static Boolean matcherEmail(String value) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{3})$";
        return matcherString(value, str);
    }

    /**
     * 匹配手机号码
     */
    public static Boolean matcherMobileNo(String value) {
        String str = "^((13[0-9])|(14[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$";
        return matcherString(value, str);
    }

    /**
     * 匹配字母和数字
     */
    public static Boolean matcherNumberLetter(String value) {
        String str = "^[A-Za-z0-9]+$";
        return matcherString(value, str);
    }

    /**
     * 匹配数字
     */
    public static Boolean matcherNumber(String value) {
        String str = "^[0-9]+$";
        return matcherString(value, str);
    }

    /**
     * 验证银卡卡号
     */
    public static boolean matcherBankCard(String value) {
        String str = "^\\d{16,19}$|^\\d{6}[- ]\\d{10,13}$|^\\d{4}[- ]\\d{4}[- ]\\d{4}[- ]\\d{4,7}$";
        return matcherString(value, str);
    }

    /**
     * 身份证验证
     */
    public static boolean matcherIdCard(String value) {
        /**15位和18位身份证号码的正则表达式*/
        String str = "^(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])((\\d{4})|\\d{3}[Xx])$)$";
        return matcherString(value, str);
    }

    /**
     * 匹配中文字符的正则表达式： [\u4e00-\u9fa5]
     评注：匹配中文还真是个头疼的事，有了这个表达式就好办了
     匹配双字节字符(包括汉字在内)：[^\x00-\xff]
     评注：可以用来计算字符串的长度（一个双字节字符长度计2，ASCII字符计1）
     匹配空白行的正则表达式：\n\s*\r
     评注：可以用来删除空白行
     匹配HTML标记的正则表达式： <(\S*?)[^>]*>.*? </\1> | <.*? />
     评注：网上流传的版本太糟糕，上面这个也仅仅能匹配部分，对于复杂的嵌套标记依旧无能为力
     匹配首尾空白字符的正则表达式：^\s* |\s*$
     评注：可以用来删除行首行尾的空白字符(包括空格、制表符、换页符等等)，非常有用的表达式
     匹配Email地址的正则表达式：\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*
     评注：表单验证时很实用
     匹配网址URL的正则表达式：[a-zA-z]+://[^\s]*
     评注：网上流传的版本功能很有限，上面这个基本可以满足需求
     匹配帐号是否合法(字母开头，允许5-16字节，允许字母数字下划线)：^[a-zA-Z][a-zA-Z0-9_]{4,15}$
     评注：表单验证时很实用
     匹配国内电话号码：\d{3}-\d{8} |\d{4}-\d{7}
     评注：匹配形式如 0511-4405222 或 021-87888822
     匹配腾讯QQ号：[1-9][0-9]{4,}
     评注：腾讯QQ号从10000开始
     匹配中国邮政编码：[1-9]\d{5}(?!\d)
     评注：中国邮政编码为6位数字
     匹配身份证：\d{15} |\d{18}
     评注：中国的身份证为15位或18位
     匹配ip地址：\d+\.\d+\.\d+\.\d+
     评注：提取ip地址时有用
     匹配特定数字：
     ^[1-9]\d*$　 　 //匹配正整数
     ^-[1-9]\d*$ 　 //匹配负整数
     ^-?[1-9]\d*$　　 //匹配整数
     ^[1-9]\d* |0$　 //匹配非负整数（正整数 + 0）
     ^-[1-9]\d* |0$　　 //匹配非正整数（负整数 + 0）
     ^[1-9]\d*\.\d* |0\.\d*[1-9]\d*$　　 //匹配正浮点数
     ^-([1-9]\d*\.\d* |0\.\d*[1-9]\d*)$　 //匹配负浮点数
     ^-?([1-9]\d*\.\d* |0\.\d*[1-9]\d* |0?\.0+ |0)$　 //匹配浮点数
     ^[1-9]\d*\.\d* |0\.\d*[1-9]\d* |0?\.0+ |0$　　 //匹配非负浮点数（正浮点数 + 0）
     ^(-([1-9]\d*\.\d* |0\.\d*[1-9]\d*)) |0?\.0+ |0$　　//匹配非正浮点数（负浮点数 + 0）
     评注：处理大量数据时有用，具体应用时注意修正
     匹配特定字符串：
     ^[A-Za-z]+$　　//匹配由26个英文字母组成的字符串
     ^[A-Z]+$　　//匹配由26个英文字母的大写组成的字符串
     ^[a-z]+$　　//匹配由26个英文字母的小写组成的字符串
     ^[A-Za-z0-9]+$　　//匹配由数字和26个英文字母组成的字符串
     ^\w+$　　//匹配由数字、26个英文字母或者下划线组成的字符串
     */
    /**
     // 单个字符  
     System.out.println("a".matches("."));
     // 0~1个a  
     System.out.println("a".matches("a?"));
     // 1~N个a  
     System.out.println("aaaa".matches("a+"));
     // 0~N个a  
     System.out.println("".matches("a*"));
     // 1~N个q和1个0~9之间的数字  
     System.out.println("qqqqqq3".matches("q+[0-9]"));
     // 12~100个数字  
     System.out.println("12345667890123".matches("\\d{12,100}"));
     // 0~3个数字分别以.分割  
     System.out.println("192.168.0.1".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));
     // 第一个数字0~2，第二个数字0~9，第三个数字0~9  
     System.out.println("192".matches("[0-2][0-9][0-9]"));
     // 4个任意空白  
     System.out.println(" \n\r\t".matches("\\s{4}"));
     // 特殊字符\需转义  
     System.out.println("\\".matches("\\\\"));
     // 以h开头，中间有0~N个字符，最后以o结尾  
     System.out.println("hello".matches("^.*o$"));
     // 以h开头，中间1~3个字母尾随一个o，接着空白连着0~N个字符并以d结尾  
     System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*d$"));
     // 以任意空白且不以换行开头为开头，并以换行结尾  
     System.out.println("   \n".matches("^[\\s&&[^\\n]]*\\n$"));
     // 0~N个字符，连接4个数字和一个字符  
     System.out.println("aaa 2222q".matches(".*\\d{4}."));
     */
}
