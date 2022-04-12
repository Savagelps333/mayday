package com.mayday.util;


public class AutoSizeTool {


    //TODO  宽度待优化
    public static double getWidth(String msg) {
        int len = msg.length();
        double width = 0;
        for (int i = 0; i < len; i++) {
            if (isChinese(msg.charAt(i))) {
//                width += 16;
                width += 16;
            } else {
//                width += 16;
                width += 12;
            }
        }

        width += 22; // 补全前后空格

        if (width > 450) {
            return 450;
        }

        return width < 50 ? 50 : width;
    }

    public static double getHeight(String msg) {
        int len = msg.length();
        double width = 0;
        for (int i = 0; i < len; i++) {
            if (isChinese(msg.charAt(i))) {
                width += 16;
            } else {
                width += 16;
            }
        }

        width += 22; // 补全前后空格

        double remainder = width % 450;
        int line = (int) (width / 450);

        if (remainder != 0) {
            line = line + 1;
        }

        //根据  \n换行增加高度
        String match = "\n";
        for (int i = 0; i < msg.length() + 1 - match.length(); i++) {
            if (msg.substring(i,match.length()+i).equals(match)){
                line++;
            }
        }

//        System.out.println("count: " + line);


        double autoHeight = line * 22 + 10;

        return autoHeight < 33 ? 25 : autoHeight;

    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }
}
