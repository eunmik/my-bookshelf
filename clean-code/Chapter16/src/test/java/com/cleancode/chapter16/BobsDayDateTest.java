package com.cleancode.chapter16;

import junit.framework.TestCase;
import java.util.*;
import static com.cleancode.chapter16.Day.*;

import static com.cleancode.chapter16.DayDate.*;

public class BobsDayDateTest extends TestCase {

//    public void testIsValidWeekdayCode() throws Exception {
//        for (int day = 1; day <= 7; day++)
//            assertTrue(isValidWeekdayCode(day));
//        assertFalse(isValidWeekdayCode(0));
//        assertFalse(isValidWeekdayCode(8));
//    }

    public void testStringToWeekdayCode() throws Exception {

        assertEquals(-1, Day.parse("Hello"));
        assertEquals(MONDAY, Day.parse("Monday"));
        assertEquals(MONDAY, Day.parse("Mon"));
        //todo    assertEquals(MONDAY,Day.parse("monday"));
        //    assertEquals(MONDAY,Day.parse("MONDAY"));
        //    assertEquals(MONDAY, Day.parse("mon"));

        assertEquals(TUESDAY, Day.parse("Tuesday"));
        assertEquals(TUESDAY, Day.parse("Tue"));
        //    assertEquals(TUESDAY,Day.parse("tuesday"));
        //    assertEquals(TUESDAY,Day.parse("TUESDAY"));
        //    assertEquals(TUESDAY, Day.parse("tue"));
        //    assertEquals(TUESDAY, Day.parse("tues"));

        assertEquals(WEDNESDAY, Day.parse("Wednesday"));
        assertEquals(WEDNESDAY, Day.parse("Wed"));
        //    assertEquals(WEDNESDAY,Day.parse("wednesday"));
        //    assertEquals(WEDNESDAY,Day.parse("WEDNESDAY"));
        //    assertEquals(WEDNESDAY, Day.parse("wed"));

        assertEquals(THURSDAY, Day.parse("Thursday"));
        assertEquals(THURSDAY, Day.parse("Thu"));
        //    assertEquals(THURSDAY,Day.parse("thursday"));
        //    assertEquals(THURSDAY,Day.parse("THURSDAY"));
        //    assertEquals(THURSDAY, Day.parse("thu"));
        //    assertEquals(THURSDAY, Day.parse("thurs"));

        assertEquals(FRIDAY, Day.parse("Friday"));
        assertEquals(FRIDAY, Day.parse("Fri"));
        //    assertEquals(FRIDAY,Day.parse("friday"));
        //    assertEquals(FRIDAY,Day.parse("FRIDAY"));
        //    assertEquals(FRIDAY, Day.parse("fri"));

        assertEquals(SATURDAY, Day.parse("Saturday"));
        assertEquals(SATURDAY, Day.parse("Sat"));
        //    assertEquals(SATURDAY,Day.parse("saturday"));
        //    assertEquals(SATURDAY,Day.parse("SATURDAY"));
        //    assertEquals(SATURDAY, Day.parse("sat"));

        assertEquals(SUNDAY, Day.parse("Sunday"));
        assertEquals(SUNDAY, Day.parse("Sun"));
        //    assertEquals(SUNDAY,Day.parse("sunday"));
        //    assertEquals(SUNDAY,Day.parse("SUNDAY"));
        //    assertEquals(SUNDAY, Day.parse("sun"));
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

//    public void testIsValidMonthCode() throws Exception {
//        for (int i = 1; i <= 12; i++)
//            assertTrue(isValidMonthCode(i));
//        assertFalse(isValidMonthCode(0));
//        assertFalse(isValidMonthCode(13));
//    }

    public void testMonthToQuarter() throws Exception {
        assertEquals(1, Month.JANUARY.quarter());
        assertEquals(1, Month.FEBRUARY.quarter());
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
            Month.make(-1);
            fail("Invalid Month Code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testMonthCodeToString() throws Exception {
        assertEquals("January", Month.JANUARY.toString());
        assertEquals("February", Month.FEBRUARY.toString());
        assertEquals("March", Month.MARCH.toString());
        assertEquals("April", Month.APRIL.toString();
        assertEquals("May", Month.MAY.toString());
        assertEquals("June", Month.JUNE.toString());
        assertEquals("July", Month.JULY.toString());
        assertEquals("August", Month.AUGUST.toString());
        assertEquals("September", Month.SEPTEMBER.toString());
        assertEquals("October", Month.OCTOBER.toString());
        assertEquals("November", Month.NOVEMBER.toString());
        assertEquals("December", Month.DECEMBER.toString());

        assertEquals("Jan", Month.JANUARY.toShortString());
        assertEquals("Feb", Month.FEBRUARY.toShortString());
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
//        assertEquals(JANUARY, stringToMonthCode("1"));
//        assertEquals(FEBRUARY, stringToMonthCode("2"));
//        assertEquals(MARCH, stringToMonthCode("3"));
//        assertEquals(APRIL, stringToMonthCode("4"));
//        assertEquals(MAY, stringToMonthCode("5"));
//        assertEquals(JUNE, stringToMonthCode("6"));
//        assertEquals(JULY, stringToMonthCode("7"));
//        assertEquals(AUGUST, stringToMonthCode("8"));
//        assertEquals(SEPTEMBER, stringToMonthCode("9"));
//        assertEquals(OCTOBER, stringToMonthCode("10"));
//        assertEquals(NOVEMBER, stringToMonthCode("11"));
//        assertEquals(DECEMBER, stringToMonthCode("12"));
//
//        //todo    assertEquals(-1, stringToMonthCode("0"));
//        //     assertEquals(-1, stringToMonthCode("13"));
//
//        assertEquals(-1, stringToMonthCode("Hello"));
//
//        for (int m = 1; m <= 12; m++) {
//            assertEquals(m, stringToMonthCode(monthCodeToString(m, false)));
//            assertEquals(m, stringToMonthCode(monthCodeToString(m, true)));
//        }

            assertEquals(1,stringToMonthCode("jan"));
            assertEquals(2,stringToMonthCode("feb"));
            assertEquals(3,stringToMonthCode("mar"));
            assertEquals(4,stringToMonthCode("apr"));
            assertEquals(5,stringToMonthCode("may"));
            assertEquals(6,stringToMonthCode("jun"));
            assertEquals(7,stringToMonthCode("jul"));
            assertEquals(8,stringToMonthCode("aug"));
            assertEquals(9,stringToMonthCode("sep"));
            assertEquals(10,stringToMonthCode("oct"));
            assertEquals(11,stringToMonthCode("nov"));
            assertEquals(12,stringToMonthCode("dec"));

            assertEquals(1,stringToMonthCode("JAN"));
            assertEquals(2,stringToMonthCode("FEB"));
            assertEquals(3,stringToMonthCode("MAR"));
            assertEquals(4,stringToMonthCode("APR"));
            assertEquals(5,stringToMonthCode("MAY"));
            assertEquals(6,stringToMonthCode("JUN"));
            assertEquals(7,stringToMonthCode("JUL"));
            assertEquals(8,stringToMonthCode("AUG"));
            assertEquals(9,stringToMonthCode("SEP"));
            assertEquals(10,stringToMonthCode("OCT"));
            assertEquals(11,stringToMonthCode("NOV"));
            assertEquals(12,stringToMonthCode("DEC"));

            assertEquals(1,stringToMonthCode("january"));
            assertEquals(2,stringToMonthCode("february"));
            assertEquals(3,stringToMonthCode("march"));
            assertEquals(4,stringToMonthCode("april"));
            assertEquals(5,stringToMonthCode("may"));
            assertEquals(6,stringToMonthCode("june"));
            assertEquals(7,stringToMonthCode("july"));
            assertEquals(8,stringToMonthCode("august"));
            assertEquals(9,stringToMonthCode("september"));
            assertEquals(10,stringToMonthCode("october"));
            assertEquals(11,stringToMonthCode("november"));
            assertEquals(12,stringToMonthCode("december"));

            assertEquals(1,stringToMonthCode("JANUARY"));
            assertEquals(2,stringToMonthCode("FEBRUARY"));
            assertEquals(3,stringToMonthCode("MAR"));
            assertEquals(4,stringToMonthCode("APRIL"));
            assertEquals(5,stringToMonthCode("MAY"));
            assertEquals(6,stringToMonthCode("JUNE"));
            assertEquals(7,stringToMonthCode("JULY"));
            assertEquals(8,stringToMonthCode("AUGUST"));
            assertEquals(9,stringToMonthCode("SEPTEMBER"));
            assertEquals(10,stringToMonthCode("OCTOBER"));
            assertEquals(11,stringToMonthCode("NOVEMBER"));
            assertEquals(12,stringToMonthCode("DECEMBER"));
    }

    public void testIsValidWeekInMonthCode() throws Exception {
        for (int w = 0; w <= 4; w++) {
            assertTrue(isValidWeekInMonthCode(w));
        }
        assertFalse(isValidWeekInMonthCode(5));
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
        assertEquals(31, lastDayOfMonth(1, 1901));
        assertEquals(28, lastDayOfMonth(2, 1901));
        assertEquals(31, lastDayOfMonth(3, 1901));
        assertEquals(30, lastDayOfMonth(4, 1901));
        assertEquals(31, lastDayOfMonth(5, 1901));
        assertEquals(30, lastDayOfMonth(6, 1901));
        assertEquals(31, lastDayOfMonth(7, 1901));
        assertEquals(31, lastDayOfMonth(8, 1901));
        assertEquals(30, lastDayOfMonth(9, 1901));
        assertEquals(31, lastDayOfMonth(10, 1901));
        assertEquals(30, lastDayOfMonth(11, 1901));
        assertEquals(31, lastDayOfMonth(12, 1901));
        assertEquals(29, lastDayOfMonth(2, 1904));
    }

    public void testAddDays() throws Exception {
        DayDate newYears = d(1, 1, 1900);
        assertEquals(d(2, 1, 1900), addDays(1, newYears));
        assertEquals(d(1, 2, 1900), addDays(31, newYears));
        assertEquals(d(1, 1, 1901), addDays(365, newYears));
        assertEquals(d(31, 12, 1904), addDays(5 * 365, newYears));
    }

    private static SpreadsheetDate d(int day, int month, int year) {
        return new SpreadsheetDate(day, month, year);
    }

    public void testAddMonths() throws Exception {
        assertEquals(d(1, 2, 1900), addMonths(1, d(1, 1, 1900)));
        assertEquals(d(28, 2, 1900), addMonths(1, d(31, 1, 1900)));
        assertEquals(d(28, 2, 1900), addMonths(1, d(30, 1, 1900)));
        assertEquals(d(28, 2, 1900), addMonths(1, d(29, 1, 1900)));
        assertEquals(d(28, 2, 1900), addMonths(1, d(28, 1, 1900)));
        assertEquals(d(27, 2, 1900), addMonths(1, d(27, 1, 1900)));

        assertEquals(d(30, 6, 1900), addMonths(5, d(31, 1, 1900)));
        assertEquals(d(30, 6, 1901), addMonths(17, d(31, 1, 1900)));

        assertEquals(d(29, 2, 1904), addMonths(49, d(31, 1, 1900)));

    }

    public void testAddYears() throws Exception {
        assertEquals(d(1, 1, 1901), plusYears(1, d(1, 1, 1900)));
        assertEquals(d(28, 2, 1905), plusYears(1, d(29, 2, 1904)));
        assertEquals(d(28, 2, 1905), plusYears(1, d(28, 2, 1904)));
        assertEquals(d(28, 2, 1904), plusYears(1, d(28, 2, 1903)));
    }

    public void testGetPreviousDayOfWeek() throws Exception {
        assertEquals(d(24, 2, 2006), getPreviousDayOfWeek(FRIDAY, d(1, 3, 2006)));
        assertEquals(d(22, 2, 2006), getPreviousDayOfWeek(WEDNESDAY, d(1, 3, 2006)));
        assertEquals(d(29, 2, 2004), getPreviousDayOfWeek(SUNDAY, d(3, 3, 2004)));
        assertEquals(d(29, 12, 2004), getPreviousDayOfWeek(WEDNESDAY, d(5, 1, 2005)));

        try {
            getPreviousDayOfWeek(-1, d(1, 1, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetFollowingDayOfWeek() throws Exception {
        assertEquals(d(1, 1, 2005),getFollowingDayOfWeek(SATURDAY, d(25, 12, 2004)));
        assertEquals(d(1, 1, 2005), getFollowingDayOfWeek(SATURDAY, d(26, 12, 2004)));
        assertEquals(d(3, 3, 2004), getFollowingDayOfWeek(WEDNESDAY, d(28, 2, 2004)));

        try {
            getFollowingDayOfWeek(-1, d(1, 1, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testGetNearestDayOfWeek() throws Exception {
        assertEquals(d(16, 4, 2006), getNearestDayOfWeek(SUNDAY, d(16, 4, 2006)));
        assertEquals(d(16, 4, 2006), getNearestDayOfWeek(SUNDAY, d(17, 4, 2006)));
        assertEquals(d(16, 4, 2006), getNearestDayOfWeek(SUNDAY, d(18, 4, 2006)));
        assertEquals(d(16, 4, 2006), getNearestDayOfWeek(SUNDAY, d(19, 4, 2006)));
        assertEquals(d(23, 4, 2006), getNearestDayOfWeek(SUNDAY, d(20, 4, 2006)));
        assertEquals(d(23, 4, 2006), getNearestDayOfWeek(SUNDAY, d(21, 4, 2006)));
        assertEquals(d(23, 4, 2006), getNearestDayOfWeek(SUNDAY, d(22, 4, 2006)));

        //todo    assertEquals(d(17, 4, 2006), getNearestDayOfWeek(MONDAY, d(16, 4, 2006)));
        assertEquals(d(17, 4, 2006), getNearestDayOfWeek(MONDAY, d(17, 4, 2006)));
        assertEquals(d(17, 4, 2006), getNearestDayOfWeek(MONDAY, d(18, 4, 2006)));
        assertEquals(d(17, 4, 2006), getNearestDayOfWeek(MONDAY, d(19, 4, 2006)));
        assertEquals(d(17, 4, 2006), getNearestDayOfWeek(MONDAY, d(20, 4, 2006)));
        assertEquals(d(24, 4, 2006), getNearestDayOfWeek(MONDAY, d(21, 4, 2006)));
        assertEquals(d(24, 4, 2006), getNearestDayOfWeek(MONDAY, d(22, 4, 2006)));

        assertEquals(d(18, 4, 2006), getNearestDayOfWeek(TUESDAY, d(16, 4, 2006)));
        assertEquals(d(18, 4, 2006), getNearestDayOfWeek(TUESDAY, d(17, 4, 2006)));
        assertEquals(d(18, 4, 2006), getNearestDayOfWeek(TUESDAY, d(18, 4, 2006)));
        assertEquals(d(18, 4, 2006), getNearestDayOfWeek(TUESDAY, d(19, 4, 2006)));
        assertEquals(d(18, 4, 2006), getNearestDayOfWeek(TUESDAY, d(20, 4, 2006)));
        assertEquals(d(18, 4, 2006), getNearestDayOfWeek(TUESDAY, d(21, 4, 2006)));
        assertEquals(d(25, 4, 2006), getNearestDayOfWeek(TUESDAY, d(22, 4, 2006)));

        //    assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(16, 4, 2006)));
        //    assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(17, 4, 2006)));
        //    assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(18, 4, 2006)));
        assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(19, 4, 2006)));
        assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(20, 4, 2006)));
        assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(21, 4, 2006)));
        assertEquals(d(19, 4, 2006), getNearestDayOfWeek(WEDNESDAY, d(22, 4, 2006)));

        //    assertEquals(d(13, 4, 2006), getNearestDayOfWeek(THURSDAY, d(16, 4, 2006)));
        //    assertEquals(d(20, 4, 2006), getNearestDayOfWeek(THURSDAY, d(17, 4, 2006)));
        //    assertEquals(d(20, 4, 2006), getNearestDayOfWeek(THURSDAY, d(18, 4, 2006)));
        //    assertEquals(d(20, 4, 2006), getNearestDayOfWeek(THURSDAY, d(19, 4, 2006)));
        assertEquals(d(20, 4, 2006), getNearestDayOfWeek(THURSDAY, d(20, 4, 2006)));
        assertEquals(d(20, 4, 2006), getNearestDayOfWeek(THURSDAY, d(21, 4, 2006)));
        assertEquals(d(20, 4, 2006), getNearestDayOfWeek(THURSDAY, d(22, 4, 2006)));

        //    assertEquals(d(14, 4, 2006), getNearestDayOfWeek(FRIDAY, d(16, 4, 2006)));
        //    assertEquals(d(14, 4, 2006), getNearestDayOfWeek(FRIDAY, d(17, 4, 2006)));
        //    assertEquals(d(21, 4, 2006), getNearestDayOfWeek(FRIDAY, d(18, 4, 2006)));
        //    assertEquals(d(21, 4, 2006), getNearestDayOfWeek(FRIDAY, d(19, 4, 2006)));
        //    assertEquals(d(21, 4, 2006), getNearestDayOfWeek(FRIDAY, d(20, 4, 2006)));
        assertEquals(d(21, 4, 2006), getNearestDayOfWeek(FRIDAY, d(21, 4, 2006)));
        assertEquals(d(21, 4, 2006), getNearestDayOfWeek(FRIDAY, d(22, 4, 2006)));

        //    assertEquals(d(15, 4, 2006), getNearestDayOfWeek(SATURDAY, d(16, 4, 2006)));
        //    assertEquals(d(15, 4, 2006), getNearestDayOfWeek(SATURDAY, d(17, 4, 2006)));
        //    assertEquals(d(15, 4, 2006), getNearestDayOfWeek(SATURDAY, d(18, 4, 2006)));
        //    assertEquals(d(22, 4, 2006), getNearestDayOfWeek(SATURDAY, d(19, 4, 2006)));
        //    assertEquals(d(22, 4, 2006), getNearestDayOfWeek(SATURDAY, d(20, 4, 2006)));
        //    assertEquals(d(22, 4, 2006), getNearestDayOfWeek(SATURDAY, d(21, 4, 2006)));
        assertEquals(d(22, 4, 2006), getNearestDayOfWeek(SATURDAY, d(22, 4, 2006)));

        try {
            getNearestDayOfWeek(-1, d(1, 1, 2006));
            fail("Invalid day of week code should throw exception");
        } catch (IllegalArgumentException e) {
        }
    }

    public void testEndOfCurrentMonth() throws Exception {
        DayDate d = DayDate.createInstance(2);
        assertEquals(d(31, 1, 2006), d.getEndOfCurrentMonth(d(1, 1, 2006)));
        assertEquals(d(28, 2, 2006), d.getEndOfCurrentMonth(d(1, 2, 2006)));
        assertEquals(d(31, 3, 2006), d.getEndOfCurrentMonth(d(1, 3, 2006)));
        assertEquals(d(30, 4, 2006), d.getEndOfCurrentMonth(d(1, 4, 2006)));
        assertEquals(d(31, 5, 2006), d.getEndOfCurrentMonth(d(1, 5, 2006)));
        assertEquals(d(30, 6, 2006), d.getEndOfCurrentMonth(d(1, 6, 2006)));
        assertEquals(d(31, 7, 2006), d.getEndOfCurrentMonth(d(1, 7, 2006)));
        assertEquals(d(31, 8, 2006), d.getEndOfCurrentMonth(d(1, 8, 2006)));
        assertEquals(d(30, 9, 2006), d.getEndOfCurrentMonth(d(1, 9, 2006)));
        assertEquals(d(31, 10, 2006), d.getEndOfCurrentMonth(d(1, 10, 2006)));
        assertEquals(d(30, 11, 2006), d.getEndOfCurrentMonth(d(1, 11, 2006)));
        assertEquals(d(31, 12, 2006), d.getEndOfCurrentMonth(d(1, 12, 2006)));
        assertEquals(d(29, 2, 2008), d.getEndOfCurrentMonth(d(1, 2, 2008)));
    }

    public void testWeekInMonthToString() throws Exception {
        assertEquals("First", weekInMonthToString(WeekInMonth.FIRST));
        assertEquals("Second", weekInMonthToString(WeekInMonth.SECOND));
        assertEquals("Third", weekInMonthToString(WeekInMonth.THIRD));
        assertEquals("Fourth", weekInMonthToString(WeekInMonth.FOURTH));
        assertEquals("Last", weekInMonthToString(WeekInMonth.LAST));

        try {
              weekInMonthToString(-1);
              fail("Invalid week code should throw exception");
        } catch (IllegalArgumentException e) { }
    }

    public void testRelativeToString() throws Exception {
        assertEquals("Preceding", relativeToString(PRECEDING));
        assertEquals("Nearest", relativeToString(NEAREST));
        assertEquals("Following", relativeToString(FOLLOWING));

        try {
             relativeToString(-1000);
              fail("Invalid relative code should throw exception");
            } catch (IllegalArgumentException e) { }
    }

    public void testCreateInstanceFromDDMMYYY() throws Exception {
        DayDate date = createInstance(1, 1, 1900);
        assertEquals(1, date.getDayOfMonth());
        assertEquals(1, date.getMonth());
        assertEquals(1900, date.getYear());
        assertEquals(2, date.toSerial());
    }

    public void testCreateInstanceFromSerial() throws Exception {
        assertEquals(d(1, 1, 1900), createInstance(2));
        assertEquals(d(1, 1, 1901), createInstance(367));
    }

    public void testCreateInstanceFromJavaDate() throws Exception {
        assertEquals(d(1, 1, 1900), createInstance(new GregorianCalendar(1900, 0, 1).getTime()));
        assertEquals(d(1, 1, 2006), createInstance(new GregorianCalendar(2006, 0, 1).getTime()));
    }

//  public static void main(String[] args) {
//    junit.textui.TestRunner.run(BobsSerialDateTest.class);
//  }
}