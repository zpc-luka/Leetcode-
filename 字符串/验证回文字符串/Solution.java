class Solution{
    public boolean isPalindrome(String s){
        StringBuilder sgood = new StringBuilder();
        int length = s.length();
        for(int i=0; i<length;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder sgood_rev = new StringBuilder(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }
}

