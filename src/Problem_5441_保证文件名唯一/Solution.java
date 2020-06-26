package Problem_5441_保证文件名唯一;

import java.util.HashMap;

class Solution {
    HashMap<String, boolean[]> set = new HashMap<>();
    String[] names;

    public String[] getFolderNames(String[] names) {
        this.names = names;
        for (int i = 0; i < names.length; i++) {
            processStr(names[i], i);
        }
        return names;
    }

    private void processStr(String name, int i) {
        Entry excludeStr = getExcludeStr(name);
        if (set.containsKey(excludeStr.text)) {
            boolean[] booleans = set.get(excludeStr.text);
            if (booleans[excludeStr.index] == false) booleans[excludeStr.index] = true;
            else if (!booleans[0]) booleans[1] = true;
            else if (booleans[1]) {
                if (name.equals(excludeStr.text)) {
                    for (int j = 2; j < booleans.length; j++) {
                        if (!booleans[j]) {
                            booleans[j] = true;
                            names[i] = excludeStr.text + "(" + j + ")";
                            break;
                        }
                    }
                } else {
                    processStr(name + "(1)", i);
                }
            } else {
                booleans[1] = true;
                names[i] = excludeStr.text + "(1)";
            }
        } else {
            boolean[] indexs = new boolean[5 * 10000];
            set.put(excludeStr.text, indexs);
            indexs[excludeStr.index] = true;
            names[i] = name;
        }
    }

    public Entry getExcludeStr(String name) {
        if (name == null || name.isEmpty()) return new Entry(name, 0);
        char[] chars = name.toCharArray();
        int left;
        if (chars[chars.length - 1] == ')') {
            for (left = chars.length - 2; left >= 0; left--) {
                if (!Character.isDigit(chars[left]) && chars[left] != '(') {
                    return new Entry(name, 0);
                } else if (chars[left] == '(') {
                    break;
                }
            }
            if (left < 0) return new Entry(name, 0);
            if (chars[left + 1] == '0') return new Entry(name, 0);
            int index = Integer.parseInt(name.substring(left + 1, chars.length - 1));
            return new Entry(name.substring(0, left), index);
        } else
            return new Entry(name, 0);
    }

    static class Entry {
        public Entry(String text, int index) {
            this.text = text;
            this.index = index;
        }

        String text;
        int index;
    }
}


class Test {
    public static void main(String[] args) {
        String[] folderNames = new Solution().getFolderNames(new String[]{
                "pes","fifa","gta","pes(2019)"
        });
        System.out.println(folderNames);
    }
}