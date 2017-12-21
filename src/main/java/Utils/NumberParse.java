package Utils;/*
 *  Copyright (c) 2014-2017. 墨博云舟 All Rights Reserved.
 */

import java.text.DecimalFormat;

/**
 * Utils.NumberParse :
 *
 * @author zhang.lei
 * @version 1.00
 * @since 2017/12/11 11:04
 */
public class NumberParse {

    public NumberParse(){
        super();
    }

    /**
     * double转string
     * @param number
     * @return
     */
    public static String  getDouble(Double number){
        DecimalFormat df = new DecimalFormat("#0.00");
        return df.format(number);
    }


    public static void main(String[] args) {
        System.out.print(getDouble(0.01));
    }
}
