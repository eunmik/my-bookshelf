package com.cleancode.chapter16;

import java.text.DateFormatSymbols;

public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);


    private static  int[] LAST_DAY_OF_MONTH =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};


    Month(int index){
        this.index = index;
    }

    private static DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();

    public static Month make(String s){
        for(Month m: Month.values()){
            if(m.matches(s))
                return m;
        }
        throw new IllegalArgumentException("Invalid month index" + s);
    }
    public  int index;

    public int quarter() {
        return 1+ (index-1)/3;
    }

    public String toString(){
        return dateFormatSymbols.getMonths()[index -1];
    }

    public String toShortString() {
        return dateFormatSymbols.getShortMonths()[index-1];
    }

    private boolean matches(String s){
        return s.equalsIgnoreCase(toString()) || s.equalsIgnoreCase(toShortString());
    }

    public static int lastDayOfMonth(Month month, int year){
        if (month == Month.FEBRUARY && DayDate.isLeapYear(year))
            return month.lastDay() + 1;
        else
            return month.lastDay();
    }

    public int lastDay() {
        return LAST_DAY_OF_MONTH[index];
    }

}
