package com.cleancode.chapter16;

public enum WeekdayRange {
    LAST(-1), NEXT(1), NEAREST(0);
    private int index;
    WeekdayRange(int index) {
        this.index = index;}

    public int toInt() {
        return index;
    }

}
