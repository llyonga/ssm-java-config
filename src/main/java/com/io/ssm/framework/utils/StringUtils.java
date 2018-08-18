package com.io.ssm.framework.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: llyong
 * @date: 2018/8/10
 * @time: 23:10
 * @version: 1.0
 */

public class StringUtils extends org.springframework.util.StringUtils {
    public StringUtils() {
    }

    public static Integer[] toIntegerArray(String[] objs) {
        if (objs == null) {
            return null;
        } else {
            Integer[] integers = new Integer[objs.length];

            for(int i = 0; i < objs.length; ++i) {
                integers[i] = Integer.valueOf(objs[i]);
            }

            return integers;
        }
    }

    public static List<Integer> toIntegerList(String[] objs) {
        if (objs == null) {
            return null;
        } else {
            List<Integer> integers = new ArrayList();

            for(int i = 0; i < objs.length; ++i) {
                integers.add(Integer.valueOf(objs[i]));
            }

            return integers;
        }
    }

    /***
     * 下划线命名转为驼峰命名
     *
     * @param para
     *        下划线命名的字符串
     */

    public static String UnderlineToHump(String para){
        StringBuilder result=new StringBuilder();
        String a[]=para.split("_");
        for(String s:a){
            if(result.length()==0){
                result.append(s.toLowerCase());
            }else{
                result.append(s.substring(0, 1).toUpperCase());
                result.append(s.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }

    public static String HumpToUnderline(String fieldName) {
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < fieldName.length(); ++i) {
            if (fieldName.charAt(i) >= 'A' && fieldName.charAt(i) <= 'Z') {
                stringBuilder.append("_").append(fieldName.charAt(i));
            } else {
                stringBuilder.append(fieldName.charAt(i));
            }
        }

        return stringBuilder.toString().toLowerCase();

//        StringBuilder sb=new StringBuilder(para);
//        int temp=0;//定位
//        for(int i=0;i<para.length();i++){
//            if(Character.isUpperCase(para.charAt(i))){
//                sb.insert(i+temp, "_");
//                temp+=1;
//            }
//        }
//        return sb.toString().toUpperCase();
    }

    public static Long[] toLongArray(String[] objs) {
        if (objs == null) {
            return null;
        } else {
            Long[] longs = new Long[objs.length];

            for(int i = 0; i < objs.length; ++i) {
                longs[i] = Long.valueOf(objs[i]);
            }

            return longs;
        }
    }

    public static String changeID(String do_id, int leng) {
        String do_id_1 = do_id.replaceAll("，", ",");
        String[] do_id_items = do_id_1.split(",");
        StringBuffer sbf = new StringBuffer();

        for(int i = 0; i < do_id_items.length; ++i) {
            String s_DO_ID = do_id_items[i];
            sbf.append("'");
            int len = do_id_items[i].length();

            for(int j = 0; j < leng - len; ++j) {
                s_DO_ID = "0" + s_DO_ID;
            }

            sbf.append(s_DO_ID);
            sbf.append("',");
        }

        if (do_id_items.length > 0) {
            sbf.delete(sbf.length() - 1, sbf.length());
        }

        return sbf.toString();
    }

    public static String padLeft(String str, int strLength) {
        return padLeft(str, '0', strLength);
    }

    public static String padLeft(String str, char c, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while(strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append(c).append(str);
                str = sb.toString();
                strLen = str.length();
            }
        }

        return str;
    }

    public static String padRight(String str, int strLength) {
        return padRight(str, '0', strLength);
    }

    public static String padRight(String str, char c, int strLength) {
        int strLen = str.length();
        if (strLen < strLength) {
            while(strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                sb.append(str).append("0");
                str = sb.toString();
                strLen = str.length();
            }
        }

        return str;
    }

    public static List<Long> toLongList(String[] objs) {
        if (objs == null) {
            return null;
        } else {
            List<Long> longs = new ArrayList();

            for(int i = 0; i < objs.length; ++i) {
                longs.add(Long.valueOf(objs[i]));
            }

            return longs;
        }
    }

    public static String[] toStringArr(List<String> stringList) {
        String[] result = new String[stringList.size()];

        for(int i = 0; i < stringList.size(); ++i) {
            result[i] = (String)stringList.get(i);
        }

        return result;
    }

    public static List<String> toStringList(String[] objs) {
        if (objs == null) {
            return null;
        } else {
            List<String> strings = new ArrayList();

            for(int i = 0; i < objs.length; ++i) {
                strings.add(objs[i]);
            }

            return strings;
        }
    }

    public static String JoinStringList(List<String> strlist, String seperater, String startStr, String endStr, String itemStartStr, String itemEndStr) {
        if (strlist != null && strlist.size() != 0) {
            int i;
            if (strlist.size() > 10) {
                StringBuilder sbStr = new StringBuilder(startStr == null ? "" : startStr);

                for(i = 0; i < strlist.size(); ++i) {
                    if (strlist.get(i) != null) {
                        sbStr.append(itemStartStr == null ? "" : itemStartStr).append((String)strlist.get(i)).append(itemEndStr == null ? "" : itemEndStr);
                        if (i < strlist.size() - 1) {
                            sbStr.append(seperater == null ? "" : seperater);
                        }
                    }
                }

                sbStr.append(endStr == null ? "" : endStr);
                return sbStr.toString();
            } else {
                String result = startStr == null ? "" : startStr;

                for(i = 0; i < strlist.size(); ++i) {
                    if (strlist.get(i) != null) {
                        result = result + (itemStartStr == null ? "" : itemStartStr);
                        result = result + (String)strlist.get(i);
                        result = result + (itemEndStr == null ? "" : itemEndStr);
                        if (i < strlist.size() - 1) {
                            result = result + (seperater == null ? "" : seperater);
                        }
                    }
                }

                result = result + (endStr == null ? "" : endStr);
                return result;
            }
        } else {
            return "";
        }
    }
}
