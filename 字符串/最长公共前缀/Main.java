class solution{
    public String longestCommonPrefix(String[] strs){
        int len = strs.length;
        
        if(strs==null || len==0){
            return "";
        }

        // String prefix = longestCommonPrefix(strs[0], strs[1]);    if  strs=[""]  就会出现ArrayIndexOutofBoundx错误
        String prefix = strs[0];
        for(int i=1;i<len;i++){
            prefix = longestCommonPrefix(prefix, strs[i]);
            
            if(prefix.length() == 0) 
                break;
        }

        return prefix;
    }

    public String longestCommonPrefix(String str1,String str2){
        int length = Math.min(str1.length(), str2.length());
        int index = 0; 

        while(index<length && str1.charAt(index) == str2.charAt(index)){
            index ++;
        }

        return str1.substring(0, index);
    }
}

//纵向扫描。纵向扫描时，从前往后遍历所有字符串的每一列，比较相同列上的字符是否相同，如果相同则继续对下一列进行比较，如果不相同则当前列不再属于公共前缀，当前列之前的部分为最长公共前缀。

class Solution2{
    public String longestCommonPrefix(String[] strs){
        int count = strs.length;
        if(count==0 || strs==null) return "";

        int len = strs[0].length();

        for(int i=0;i<len;i--){
            char c = strs[0].charAt(i);
            for(int j=1;j<count;j++){
                if(i==strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0,i);
                }
            }
        }

        return strs[0];
    }
}