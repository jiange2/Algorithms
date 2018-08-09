package com.jiange2.argorithms.leetcode;

public class P12Integer2Roman {

    private static final String[] ROMAN_NUMBER = {"I","V","X","L","C","D","M"};
    private static final int[] ROMAN_VALUE = {1,5,10,50,100,500,1000};

    public String intToRoman(int num) throws Exception {
        if(num <= 0){
            return "";
        }
        if(num > 3999){
            throw new Exception("Unsuport cast");
        }
        StringBuilder sb = new StringBuilder();

        int base = 1000;
        int remainder = 100;

        while (base > 0 && remainder > 0){
            int count = num / base;
            int remain = num % base;
            char baseChar = toRomanChar(base);
            for(int i=0; i<count;++i){
                sb.append(baseChar);
            }
            base /= 10;
            if(remain >= base){
                count = remain / base;
                char nextBaseChar = toRomanChar(base);
                if(count >= 9){
                    sb.append(nextBaseChar).append(baseChar);
                }else if(count >= 5){
                    sb.append(toRomanChar(base * 5));
                    for (int i = 0; i < count - 5; i++) {
                        sb.append(nextBaseChar);
                    }
                }else if(count == 4){
                    sb.append(nextBaseChar);
                    sb.append(toRomanChar(base * 5));
                }else{
                    for (int i = 0; i < count; i++) {
                        sb.append(nextBaseChar);
                    }
                }
            }
            num %= remainder;
            remainder /= 10;
        }

        return sb.toString();
    }

    private char toRomanChar(int num){
        switch (num){
            case 1: return 'I';
            case 5: return 'V';
            case 10: return 'X';
            case 50: return 'L';
            case 100: return 'C';
            case 500: return 'D';
            case 1000: return 'M';
        }

        return ' ';
    }
}
