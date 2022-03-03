package com.cleancode.chapter16;

import java.text.DateFormatSymbols;

public enum WeekInMonth {
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), LAST(0);
    public  int index;
    WeekInMonth(int index) {
        this.index = index;
    }
    private static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();


    public int toInt(){
        return index;
    }

}