package Problem_5382_HTML_实体解析器;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "\'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            text = text.replace(next.getKey(), next.getValue());
        }
        return text;
    }
}

class Test {
    public static void main(String[] args) {
        String s = new Solution().entityParser("x &gt; y &amp;&amp; x &lt; y is always false");
        System.out.println(s);
    }
}