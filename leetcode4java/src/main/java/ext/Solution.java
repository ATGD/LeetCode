package ext;

class Solution{
public String q(){
char q=34;
StringBuffer sb=new StringBuffer();
String[] l={
"class Solution{ public String q(){",
"char q=34;",
"StringBuffer sb=new StringBuffer();",
"String[] l={",
"};",
"for(int i=0;i<5;i++)",
"sb.append(l[i]);",
"for(int i=0;i<l.length;i++)",
"sb.append(q+l[i]+q+',');",
"for(int i=5;i<l.length;i++)",
"sb.append(l[i]);",
"return sb.toString();",
"}",
"}",
};
for(int i=0;i<5;i++)
sb.append(l[i]);
for(int i=0;i<l.length;i++)
sb.append(q+l[i]+q+',');
for(int i=5;i<l.length;i++)
sb.append(l[i]);
return sb.toString();
}
}

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().q());
    }
}
