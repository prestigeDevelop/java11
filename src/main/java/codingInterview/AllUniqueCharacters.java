package codingInterview;

public class AllUniqueCharacters {
    //Implement an algorithm to determine if a string has all unique characters. What if you
    //can not use additional data structures?
    public static void main(String[] args) {
        String name="avbnmkjhgrtyuiopwq";
        IsUniqueCharacters(name);

    }



    private static void IsUniqueCharacters(String name) {
        int originalSize=name.length();
        char[] nameChar=name.toLowerCase().toCharArray();
        boolean isDuplicate=false;
        // 97   1   2   3   4   97  6
        //[a] [v] [i] [s] [h]  [a] [i]
        int[] asciiArray=new int[256];
        for (int i = 0; i < originalSize; i++) {
            //convert from char to ascii code
            int index = (int) nameChar[i];
            if(asciiArray[index]==1){
                char duplicate=(char)index;
                System.out.println("The duplicate char is :"+duplicate);
                isDuplicate=true;
                break;
            }else {
                asciiArray[index] = 1;
            }
        }
        if(!isDuplicate){
            System.out.println("The string has all unique characters");
        }
    }
}
