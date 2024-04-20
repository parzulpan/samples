package _testjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testcountry {
    public static void main(String[] args) {
        String country = "AD\t71\n" +
                "AE\t64\n" +
                "AG\t73\n" +
                "AM\t74\n" +
                "AO\t72\n" +
                "AR\t65\n" +
                "AT\t33\n" +
                "AU\t10\n" +
                "AW\t75\n" +
                "AZ\t34\n" +
                "BA\t83\n" +
                "BB\t78\n" +
                "BD\t1169\n" +
                "BE\t36\n" +
                "BG\t37\n" +
                "BH\t35\n" +
                "BI\t85\n" +
                "BJ\t80\n" +
                "BN\t84\n" +
                "BO\t81\n" +
                "BR\t68\n" +
                "BS\t76\n" +
                "BT\t77\n" +
                "BW\t82\n" +
                "BY\t66\n" +
                "BZ\t79\n" +
                "CA\t9\n" +
                "CG\t90\n" +
                "CH\t29\n" +
                "CL\t93\n" +
                "CM\t86\n" +
                "CN\t166\n" +
                "CO\t39\n" +
                "CR\t91\n" +
                "CV\t87\n" +
                "CY\t40\n" +
                "CZ\t41\n" +
                "DE\t5\n" +
                "DJ\t94\n" +
                "DK\t23\n" +
                "DM\t95\n" +
                "DO\t96\n" +
                "EC\t97\n" +
                "EE\t42\n" +
                "EG\t67\n" +
                "ER\t100\n" +
                "ES\t4\n" +
                "FI\t43\n" +
                "FJ\t102\n" +
                "FO\t101\n" +
                "FR\t3\n" +
                "GA\t103\n" +
                "GB\t6\n" +
                "GD\t109\n" +
                "GE\t106\n" +
                "GG\t165\n" +
                "GH\t105\n" +
                "GI\t107\n" +
                "GL\t108\n" +
                "GM\t104\n" +
                "GN\t111\n" +
                "GP\t163\n" +
                "GQ\t98\n" +
                "GR\t24\n" +
                "GU\t110\n" +
                "GY\t112\n" +
                "HK\t44\n" +
                "HN\t114\n" +
                "HR\t92\n" +
                "HT\t113\n" +
                "HU\t45\n" +
                "ID\t31\n" +
                "IE\t13\n" +
                "IL\t47\n" +
                "IN\t32\n" +
                "IS\t46\n" +
                "IT\t11\n" +
                "JM\t115\n" +
                "JO\t116\n" +
                "JP\t18\n" +
                "KE\t117\n" +
                "KG\t118\n" +
                "KH\t38\n" +
                "KM\t89\n" +
                "KR\t17\n" +
                "KW\t49\n" +
                "KZ\t48\n" +
                "LA\t119\n" +
                "LB\t51\n" +
                "LC\t142\n" +
                "LI\t122\n" +
                "LK\t148\n" +
                "LR\t121\n" +
                "LS\t120\n" +
                "LT\t52\n" +
                "LU\t53\n" +
                "LV\t50\n" +
                "MA\t132\n" +
                "MD\t129\n" +
                "ME\t131\n" +
                "MG\t124\n" +
                "ML\t126\n" +
                "MM\t134\n" +
                "MN\t130\n" +
                "MO\t123\n" +
                "MQ\t164\n" +
                "MT\t54\n" +
                "MU\t127\n" +
                "MW\t125\n" +
                "MX\t20\n" +
                "MY\t15\n" +
                "MZ\t133\n" +
                "NA\t135\n" +
                "NC\t137\n" +
                "NG\t168\n" +
                "NI\t138\n" +
                "NL\t25\n" +
                "NO\t8\n" +
                "NP\t136\n" +
                "NZ\t55\n" +
                "OM\t56\n" +
                "PA\t139\n" +
                "PE\t57\n" +
                "PG\t140\n" +
                "PH\t19\n" +
                "PK\t167\n" +
                "PL\t27\n" +
                "PR\t162\n" +
                "PT\t28\n" +
                "QA\t58\n" +
                "RO\t69\n" +
                "RS\t145\n" +
                "RU\t12\n" +
                "RW\t141\n" +
                "SA\t30\n" +
                "SC\t146\n" +
                "SE\t7\n" +
                "SG\t16\n" +
                "SI\t59\n" +
                "SK\t70\n" +
                "SL\t147\n" +
                "SM\t143\n" +
                "SN\t144\n" +
                "SR\t149\n" +
                "SV\t99\n" +
                "SZ\t150\n" +
                "TC\t155\n" +
                "TD\t88\n" +
                "TH\t14\n" +
                "TJ\t151\n" +
                "TO\t153\n" +
                "TR\t62\n" +
                "TT\t154\n" +
                "TW\t61\n" +
                "TZ\t152\n" +
                "UA\t63\n" +
                "UG\t156\n" +
                "US\t2\n" +
                "UZ\t157\n" +
                "VI\t159\n" +
                "VN\t22\n" +
                "VUT\t158\n" +
                "YT\t128\n" +
                "ZA\t60\n" +
                "ZM\t160\n" +
                "ZW\t161";

        String[] split = country.split("\n");
        for (String s : split) {
            Pattern pattern = Pattern.compile("\\b(\\S+)\\s+(\\d+)\\b");

            // 创建一个Matcher对象来查找匹配项
            Matcher matcher = pattern.matcher(s);

            // 遍历所有匹配项
            while (matcher.find()) {
                // 获取国家码
                String countryCode = matcher.group(1);
                // 获取ID
                String id = matcher.group(2);
                System.out.println(String.format("put(\"%s\", %s);", countryCode, id));
            }
        }
    }
}
