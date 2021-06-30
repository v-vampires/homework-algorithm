package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L811_SubdomainVisitCount {
    public static void main(String[] args) {
        Solution solution = new L811_SubdomainVisitCount().new Solution();
        System.out.println(solution.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map<String, Integer> map = new HashMap<>();
            for (String cpdomain : cpdomains) {
                final String[] arr = cpdomain.split(" ");
                int count = Integer.parseInt(arr[0]);
                String domain = arr[1];
                final String[] domainArr = domain.split("\\.");
                String d = "";
                for (int i = domainArr.length - 1; i >= 0; i--) {
                    d = d == "" ? domainArr[i] + d : domainArr[i] + "." + d;
                    map.put(d, map.getOrDefault(d, 0) + count);
                }
            }
            List<String> res = new ArrayList<>();
            map.forEach((k, v) -> {
                res.add(v + " " + k);
            });
            return res;
        }
    }

}