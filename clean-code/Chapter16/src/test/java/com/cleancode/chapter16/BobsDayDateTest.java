package com.cleancode.chapter16;

import junit.framework.TestCase;
import java.util.*;

import static com.cleancode.chapter16.DateUtil.*;
import static com.cleancode.chapter16.Day.*;

import static com.cleancode.chapter16.DayDate.*;
import static com.cleancode.chapter16.Month.*;


public class BobsDayDateTest extends TestCase {

//    public void testIsValidWeekdayCode() throws Exception {
//        for (int day = 1; day <= 7; day++)
//            assertTrue(isValidWeekdayCode(day));
//        assertFalse(isValidWeekdayCode(0));
//        assertFalse(isValidWeekdayCode(8));
//    }

    public void testStringToWeekdayCode() throws Exception {

        try {
            Day.parse("Hello");
            fail("Invalid Month Code should throw exception");
        } catch (IllegalArgumentException e) {
        }

        assertEquals(MONDAY, Day.parse("Monday"));
        assertEquals(MONDAY, Day.parse("Mon"));
        assertEquals(MONDAY,Day.parse("monday"));
        assertEquals(MONDAY,Day.parse("MONDAY"));
        assertEquals(MONDAY, Day.parse("mon"));

        assertEquals(TUESDAY, Day.parse("Tuesday"));
        assertEquals(TUESDAY, Day.parse("Tue"));
        assertEquals(TUESDAY,Day.parse("tuesday"));
        assertEquals(TUESDAY,Day.parse("TUESDAY"));
        assertEquals(TUESDAY, Day.parse("tue"));
    //    assertEquals(TUESDAY, Day.parse("tues"));

        assertEquals(WEDNESDAY, Day.parse("Wednesday"));
        assertEquals(WEDNESDAY, Day.parse("Wed"));
        assertEquals(WEDNESDAY,Day.parse("wednesday"));
        assertEquals(WEDNESDAY,Day.parse("WEDNESDAY"));
        assertEquals(WEDNESDAY, Day.parse("wed"));

        assertEquals(THURSDAY, Day.parse("Thursday"));
        assertEquals(THURSDAY, Day.parse("Thu"));
        assertEquals(THURSDAY,Day.parse("thursday"));
        assertEquals(THURSDAY,Day.parse("THURSDAY"));
        assertEquals(THURSDAY, Day.parse("thu"));
          //  assertEquals(THURSDAY, Day.parse("thurs"));

        assertEquals(FRIDAY, Day.parse("Friday"));
        assertEquals(FRIDAY, Day.parse("Fri"));
        assertEquals(FRIDAY,Day.parse("friday"));
        assertEquals(FRIDAY,Day.parse("FRIDAY"));
        assertEquals(FRIDAY, Day.parse("fri"));

        assertEquals(SATURDAY, Day.parse("Saturday"));
        assertEquals(SATURDAY, Day.parse("Sat"));
        assertEquals(SATURDAY,Day.parse("saturday"));
        assertEquals(SATURDAY,Day.parse("SATURDAY"));
        assertEquals(SATURDAY, Day.parse("sat"));

        assertEquals(SUNDAY, Day.parse("Sunday"));
        assertEquals(SUNDAY, Day.parse("Sun"));
        assertEquals(SUNDAY,Day.parse("sunday"));
        assertEquals(SUNDAY,Day.parse("SUNDAY"));
        assertEquals(SUNDAY, Day.parse("sun"));
    }

    public void testWeekdayCodeToString() throws Exception {
        assertEquals("Sunday", SUNDAY.toString());
        assertEquals("Monday", MONDAY.toString());
        assertEquals("Tuesday", TUESDAY.toString());
        assertEquals("Wednesday", WEDNESDAY.toString());
        assertEquals("Thursday", THURSDAY.toString());
        assertEquals("Friday", FRIDAY.toString());
        assertEquals("Saturday", SATURDAY.toString());
    }

    public void testMonthToQuarter() throws Exception {
        assertEquals(1, JANUARY.quarter());
        assertEquals(1, FEBRUARY.quarter());
        assertEquals(1, Month.MARCH.quarter());
        assertEquals(2, Month.APRIL.quarter());
        assertEquals(2, Month.MAY.quarter());
        assertEquals(2, Month.JUNE.quarter());
        assertEquals(3, Month.JULY.quarter());
        assertEquals(3, Month.AUGUST.quarter());
        assertEquals(3, Month.SEPTEMBER.quarter());
        assertEquals(4, Month.OCTOBER.quarter());
        assertEquals(4, Month.NOVEMBER.quarter());
        assertEquals(4, Month.DECEMBER.quarter());

        try {
            Month.fromInt(-1);
            fail("Invalid Month Code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testMonthCodeToString() throws Exception {
        assertEquals("January", JANUARY.toString());
        assertEquals("February", FEBRUARY.toString());
        assertEquals("March", Month.MARCH.toString());
        assertEquals("April", Month.APRIL.toString());
        assertEquals("May", Month.MAY.toString());
        assertEquals("June", Month.JUNE.toString());
        assertEquals("July", Month.JULY.toString());
        assertEquals("August", Month.AUGUST.toString());
        assertEquals("September", Month.SEPTEMBER.toString());
        assertEquals("October", Month.OCTOBER.toString());
        assertEquals("November", Month.NOVEMBER.toString());
        assertEquals("December", Month.DECEMBER.toString());

        assertEquals("Jan", JANUARY.toShortString());
        assertEquals("Feb", FEBRUARY.toShortString());
        assertEquals("Mar", Month.MARCH.toShortString());
        assertEquals("Apr", Month.APRIL.toShortString());
        assertEquals("May", Month.MAY.toShortString());
        assertEquals("Jun", Month.JUNE.toShortString());
        assertEquals("Jul", Month.JULY.toShortString());
        assertEquals("Aug", Month.AUGUST.toShortString());
        assertEquals("Sep", Month.SEPTEMBER.toShortString());
        assertEquals("Oct", Month.OCTOBER.toShortString());
        assertEquals("Nov", Month.NOVEMBER.toShortString());
        assertEquals("Dec", Month.DECEMBER.toShortString());

        try {
            Month.fromInt(-1);
            fail("Invalid month code should throw exception");
        } catch (IllegalArgumentException e) {
        }

    }
    public void testStringToMonthCode() throws Exception {
        assertEquals(JANUARY, Month.fromInt(1));
        assertEquals(FEBRUARY, Month.fromInt(2));
        assertEquals(MARCH, Month.fromInt(3));
        assertEquals(APRIL, Month.fromInt(4));
        assertEquals(MAY, Month.fromInt(5));
        assertEquals(JUNE, Month.fromInt(6));
        assertEquals(JULY, Month.fromInt(7));
        assertEquals(AUGUST, Month.fromInt(8));
        assertEquals(SEPTEMBER, Month.fromInt(9));
        assertEquals(OCTOBER, Month.fromInt(10));
        assertEquals(NOVEMBER, Month.fromInt(11));
        assertEquals(DECEMBER, Month.fromInt(12));

        try{
            Month.fromInt(0);
            fail();

            Month.fromInt(13);
            fail();

            Month.make("Hello").toInt();
            fail();

        }catch (IllegalArgumentException e){

        }

//        for (int m = 1; m <= 12; m++) {
//            assertEquals(m, stringToMonthCode(monthCodeToString(m, false)));
//            assertEquals(m, stringToMonthCode(monthCodeToString(m, true)));
//        }


            assertEquals(1,Month.make("jan").toInt());
            assertEquals(2,Month.make("feb").toInt());
            assertEquals(3,Month.make("mar").toInt());
            assertEquals(4,Month.make("apr").toInt());
            assertEquals(5,Month.make("may").toInt());
            assertEquals(6,Month.make("jun").toInt());
            assertEquals(7,Month.make("jul").toInt());
            assertEquals(8,Month.make("aug").toInt());
            assertEquals(9,Month.make("sep").toInt());
            assertEquals(10,Month.make("oct").toInt());
            assertEquals(11,Month.make("nov").toInt());
            assertEquals(12,Month.make("dec").toInt());

            assertEquals(1,Month.make("JAN").toInt());
            assertEquals(2,Month.make("FEB").toInt());
            assertEquals(3,Month.make("MAR").toInt());
            assertEquals(4,Month.make("APR").toInt());
            assertEquals(5,Month.make("MAY").toInt());
            assertEquals(6,Month.make("JUN").toInt());
            assertEquals(7,Month.make("JUL").toInt());
            assertEquals(8,Month.make("AUG").toInt());
            assertEquals(9,Month.make("SEP").toInt());
            assertEquals(10,Month.make("OCT").toInt());
            assertEquals(11,Month.make("NOV").toInt());
            assertEquals(12,Month.make("DEC").toInt());

            assertEquals(1,Month.make("january").toInt());
            assertEquals(2,Month.make("february").toInt());
            assertEquals(3,Month.make("march").toInt());
            assertEquals(4,Month.make("april").toInt());
            assertEquals(5,Month.make("may").toInt());
            assertEquals(6,Month.make("june").toInt());
            assertEquals(7,Month.make("july").toInt());
            assertEquals(8,Month.make("august").toInt());
            assertEquals(9,Month.make("september").toInt());
            assertEquals(10,Month.make("october").toInt());
            assertEquals(11,Month.make("november").toInt());
            assertEquals(12,Month.make("december").toInt());

            assertEquals(1,Month.make("JANUARY").toInt());
            assertEquals(2,Month.make("FEBRUARY").toInt());
            assertEquals(3,Month.make("MAR").toInt());
            assertEquals(4,Month.make("APRIL").toInt());
            assertEquals(5,Month.make("MAY").toInt());
            assertEquals(6,Month.make("JUNE").toInt());
            assertEquals(7,Month.make("JULY").toInt());
            assertEquals(8,Month.make("AUGUST").toInt());
            assertEquals(9,Month.make("SEPTEMBER").toInt());
            assertEquals(10,Month.make("OCTOBER").toInt());
            assertEquals(11,Month.make("NOVEMBER").toInt());
            assertEquals(12,Month.make("DECEMBER").toInt());
    }

    public void testIsLeapYear() throws Exception {
        assertFalse(isLeapYear(1900));
        assertFalse(isLeapYear(1901));
        assertFalse(isLeapYear(1902));
        assertFalse(isLeapYear(1903));
        assertTrue(isLeapYear(1904));
        assertTrue(isLeapYear(1908));
        assertFalse(isLeapYear(1955));
        assertTrue(isLeapYear(1964));
        assertTrue(isLeapYear(1980));
        assertTrue(isLeapYear(2000));
        assertFalse(isLeapYear(2001));
        assertFalse(isLeapYear(2100));
    }

    public void testLeapYearCount() throws Exception {
        assertEquals(0, leapYearCount(1900));
        assertEquals(0, leapYearCount(1901));
        assertEquals(0, leapYearCount(1902));
        assertEquals(0, leapYearCount(1903));
        assertEquals(1, leapYearCount(1904));
        assertEquals(1, leapYearCount(1905));
        assertEquals(1, leapYearCount(1906));
        assertEquals(1, leapYearCount(1907));
        assertEquals(2, leapYearCount(1908));
        assertEquals(24, leapYearCount(1999));
        assertEquals(25, leapYearCount(2001));
        assertEquals(49, leapYearCount(2101));
        assertEquals(73, leapYearCount(2201));
        assertEquals(97, leapYearCount(2301));
        assertEquals(122, leapYearCount(2401));
    }

    public void testLastDayOfMonth() throws Exception {
        assertEquals(31, lastDayOfMonth(JANUARY, 1901));
        assertEquals(28, lastDayOfMonth(FEBRUARY, 1901));
        assertEquals(31, lastDayOfMonth(MARCH, 1901));
        assertEquals(30, lastDayOfMonth(APRIL, 1901));
        assertEquals(31, lastDayOfMonth(MAY, 1901));
        assertEquals(30, lastDayOfMonth(JUNE, 1901));
        assertEquals(31, lastDayOfMonth(JULY, 1901));
        assertEquals(31, lastDayOfMonth(AUGUST, 1901));
        assertEquals(30, lastDayOfMonth(SEPTEMBER, 1901));
        assertEquals(31, lastDayOfMonth(OCTOBER, 1901));
        assertEquals(30, lastDayOfMonth(NOVEMBER, 1901));
        assertEquals(31, lastDayOfMonth(DECEMBER, 1901));
        assertEquals(29, lastDayOfMonth(FEBRUARY, 1904));
    }

    public void testAddDays() throws Exception {
        DayDate newYears = DayDateFactory.makeDate(1, 1, 1900);
        assertEquals(DayDateFactory.makeDate(2, 1, 1900), newYears.plusDays(1));
        assertEquals(DayDateFactory.makeDate(1, 2, 1900), newYears.plusDays(31));
        assertEquals(DayDateFactory.makeDate(1, 1, 1901), newYears.plusDays(365));
        assertEquals(DayDateFactory.makeDate(31, 12, 1904), newYears.plusDays(5 * 365));
    }

    private static SpreadsheetDate d(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public void testAddMonths() throws Exception {

        assertEquals(d(1, 2, 1900), d(1, 1, 1900).plusMonths(1));
        assertEquals(d(28, 2, 1900), d(31, 1, 1900).plusMonths(1));
        assertEquals(d(28, 2, 1900), d(30, 1, 1900).plusMonths(1));
        assertEquals(d(28, 2, 1900), d(29, 1, 1900).plusMonths(1));
        assertEquals(d(28, 2, 1900), d(28, 1, 1900).plusMonths(1));
        assertEquals(d(27, 2, 1900), d(27, 1, 1900).plusMonths(1));

        assertEquals(d(30, 6, 1900), d(31, 1, 1900).plusMonths(5));
        assertEquals(d(30, 6, 1901), d(31, 1, 1900).plusMonths(17));

        assertEquals(d(29, 2, 1904), d(31, 1, 1900).plusMonths(49));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, 1, 1901), d(1, 1, 1900).plusYears(1));
        assertEquals(d(28, 2, 1905),  d(29, 2, 1904).plusYears(1));
        assertEquals(d(28, 2, 1905), d(28, 2, 1904).plusYears(1));
        assertEquals(d(28, 2, 1904), d(28, 2, 1903).plusYears(1));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(d(24, 2, 2006), d(1, 3, 2006).getPreviousDayOfWeek(FRIDAY));
        assertEquals(d(22, 2, 2006), d(1, 3, 2006).getPreviousDayOfWeek(WEDNESDAY));
        assertEquals(d(29, 2, 2004), d(3, 3, 2004).getPreviousDayOfWeek(SUNDAY));
        assertEquals(d(29, 12, 2004), d(5, 1, 2005).getPreviousDayOfWeek(WEDNESDAY));

        try {
            d(1, 1, 2006).getPreviousDayOfWeek(Day.fromInt(-1));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, 1, 2005), d(25, 12, 2004).getFollowingDayOfWeek(SATURDAY));
        assertEquals(d(1, 1, 2005), d(26, 12, 2004).getFollowingDayOfWeek(SATURDAY));
        assertEquals(d(3, 3, 2004), d(28, 2, 2004).getFollowingDayOfWeek(WEDNESDAY));

        try {
            d(1, 1, 2006).getFollowingDayOfWeek(Day.fromInt(-1));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(d(16, 4, 2006), d(16, 4, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(16, 4, 2006), d(17, 4, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(16, 4, 2006), d(19, 4, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(16, 4, 2006), d(18, 4, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(23, 4, 2006), d(20, 4, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(23, 4, 2006), d(21, 4, 2006).getNearestDayOfWeek(SUNDAY));
        assertEquals(d(23, 4, 2006), d(22, 4, 2006).getNearestDayOfWeek(SUNDAY));

        assertEquals(d(17, 4, 2006), d(16, 4, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, 4, 2006), d(17, 4, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, 4, 2006), d(18, 4, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, 4, 2006), d(19, 4, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(17, 4, 2006), d(20, 4, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(24, 4, 2006), d(21, 4, 2006).getNearestDayOfWeek(MONDAY));
        assertEquals(d(24, 4, 2006), d(22, 4, 2006).getNearestDayOfWeek(MONDAY));

        assertEquals(d(18, 4, 2006),  d(16, 4, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, 4, 2006),  d(17, 4, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, 4, 2006),  d(18, 4, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, 4, 2006),  d(19, 4, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, 4, 2006),  d(20, 4, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(18, 4, 2006),  d(21, 4, 2006).getNearestDayOfWeek(TUESDAY));
        assertEquals(d(25, 4, 2006),  d(22, 4, 2006).getNearestDayOfWeek(TUESDAY));

        assertEquals(d(19, 4, 2006), d(16, 4, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, 4, 2006), d(17, 4, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, 4, 2006), d(18, 4, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, 4, 2006), d(19, 4, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, 4, 2006), d(20, 4, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, 4, 2006), d(21, 4, 2006).getNearestDayOfWeek(WEDNESDAY));
        assertEquals(d(19, 4, 2006), d(22, 4, 2006).getNearestDayOfWeek(WEDNESDAY));

        assertEquals(d(13, 4, 2006), d(16, 4, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, 4, 2006), d(17, 4, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, 4, 2006), d(18, 4, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, 4, 2006), d(19, 4, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, 4, 2006), d(20, 4, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, 4, 2006), d(21, 4, 2006).getNearestDayOfWeek(THURSDAY));
        assertEquals(d(20, 4, 2006), d(22, 4, 2006).getNearestDayOfWeek(THURSDAY));

        assertEquals(d(14, 4, 2006), d(16, 4, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(14, 4, 2006), d(17, 4, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, 4, 2006), d(18, 4, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, 4, 2006), d(19, 4, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, 4, 2006), d(20, 4, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, 4, 2006), d(21, 4, 2006).getNearestDayOfWeek(FRIDAY));
        assertEquals(d(21, 4, 2006), d(22, 4, 2006).getNearestDayOfWeek(FRIDAY));

        assertEquals(d(15, 4, 2006), d(16, 4, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(15, 4, 2006), d(17, 4, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(15, 4, 2006), d(18, 4, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, 4, 2006), d(19, 4, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, 4, 2006), d(20, 4, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, 4, 2006), d(21, 4, 2006).getNearestDayOfWeek(SATURDAY));
        assertEquals(d(22, 4, 2006), d(22, 4, 2006).getNearestDayOfWeek(SATURDAY));

        try {
            d(1, 1, 2006).getNearestDayOfWeek(Day.fromInt(-1));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = DayDateFactory.makeDate(2);
        assertEquals(d(31, 1, 2006), d(1, 1, 2006).getEndOfMonth());
        assertEquals(d(28, 2, 2006), d(1, 2, 2006).getEndOfMonth());
        assertEquals(d(31, 3, 2006), d(1, 3, 2006).getEndOfMonth());
        assertEquals(d(30, 4, 2006), d(1, 4, 2006).getEndOfMonth());
        assertEquals(d(31, 5, 2006), d(1, 5, 2006).getEndOfMonth());
        assertEquals(d(30, 6, 2006), d(1, 6, 2006).getEndOfMonth());
        assertEquals(d(31, 7, 2006), d(1, 7, 2006).getEndOfMonth());
        assertEquals(d(31, 8, 2006), d(1, 8, 2006).getEndOfMonth());
        assertEquals(d(30, 9, 2006), d(1, 9, 2006).getEndOfMonth());
        assertEquals(d(31, 10, 2006), d(1, 10, 2006).getEndOfMonth());
        assertEquals(d(30, 11, 2006), d(1, 11, 2006).getEndOfMonth());
        assertEquals(d(31, 12, 2006), d(1, 12, 2006).getEndOfMonth());
        assertEquals(d(29, 2, 2008), d(1, 2, 2008).getEndOfMonth());
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        DayDate date = DayDateFactory.makeDate(1, 1, 1900);
        assertEquals(1, date.getDayOfMonth());
        assertEquals(1, date.getMonth().toInt());
        assertEquals(1900, date.getYear());
        assertEquals(2, date.getOrdinalDay());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, 1, 1900), DayDateFactory.makeDate(2));
        assertEquals(d(1, 1, 1901), DayDateFactory.makeDate(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, 1, 1900), DayDateFactory.makeDate(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, 1, 2006), DayDateFactory.makeDate(new GregorianCalendar(2006, 0, 1).getTime()));
    }

//  public static void main(String[] args) {
//    junit.textui.TestRunner.run(BobsSerialDateTest.class);
//  }
}