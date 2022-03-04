package com.cleancode.chapter16;

/* ========================================================================
 * JCommon : a free general purpose class library for the Java(tm) platform
 * ========================================================================
 *
 * (C) Copyright 2000-2005, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jcommon/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * --------------------------
 * RelativeDayOfWeekRule.java
 * --------------------------
 * (C) Copyright 2000-2003, by Object Refinery Limited and Contributors.
 *
 */

/**
 * An annual date rule that returns a date for each year based on (a) a
 * reference rule; (b) a day of the week; and (c) a selection parameter
 * (DayDate.PRECEDING, DayDate.NEAREST, DayDate.FOLLOWING).
 * <P>
 * For example, Good Friday can be specified as 'the Friday PRECEDING Easter
 * Sunday'.
 *
 * @author David Gilbert
 */
public class RelativeDayOfWeekRule extends AnnualDateRule {

    /** A reference to the annual date rule on which this rule is based. */
    private AnnualDateRule subrule;

    private Day dayOfWeek;

    private WeekdayRange relative;


    public RelativeDayOfWeekRule() {
        this(new DayAndMonthRule(), Day.MONDAY, WeekdayRange.NEXT);
    }

    /**
     * Standard constructor - builds rule based on the supplied sub-rule.
     *
     * @param subrule  the rule that determines the reference date.
     * @param dayOfWeek  the day-of-the-week relative to the reference date.
     * @param relative  indicates *which* day-of-the-week (preceding, nearest
     *                  or following).
     */
    public RelativeDayOfWeekRule(final AnnualDateRule subrule,
                                 final Day dayOfWeek, final WeekdayRange relative) {
        this.subrule = subrule;
        this.dayOfWeek = dayOfWeek;
        this.relative = relative;
    }

    /**
     * Returns the sub-rule (also called the reference rule).
     *
     * @return The annual date rule that determines the reference date for this
     *         rule.
     */
    public AnnualDateRule getSubrule() {
        return this.subrule;
    }

    /**
     * Sets the sub-rule.
     *
     * @param subrule  the annual date rule that determines the reference date
     *                 for this rule.
     */
    public void setSubrule(final AnnualDateRule subrule) {
        this.subrule = subrule;
    }

    public Day getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(final Day dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public WeekdayRange getRelative() {
        return this.relative;
    }


    public void setRelative(final WeekdayRange relative) {
        this.relative = relative;
    }


    public Object clone() throws CloneNotSupportedException {
        final RelativeDayOfWeekRule duplicate
                = (RelativeDayOfWeekRule) super.clone();
        duplicate.subrule = (AnnualDateRule) duplicate.getSubrule().clone();
        return duplicate;
    }

    public DayDate getDate(final int year) {

        // check argument...
        if ((year < SpreadsheetDate.MINIMUM_YEAR_SUPPORTED)
                || (year > SpreadsheetDate.MAXIMUM_YEAR_SUPPORTED)) {
            throw new IllegalArgumentException(
                    "RelativeDayOfWeekRule.getDate(): year outside valid range.");
        }

        // calculate the date...
        DayDate result = null;
        final DayDate base = this.subrule.getDate(year);

        if (base != null) {
            switch (this.relative) {
                case LAST:
                    result = new SpreadsheetDate(this.dayOfWeek.toInt()).getFollowingDayOfWeek(this.dayOfWeek);
                    break;
                case NEAREST:
                    result = new SpreadsheetDate(this.dayOfWeek.toInt()).getNearestDayOfWeek(this.dayOfWeek);
                    break;
                case NEXT:
                    result = new SpreadsheetDate(this.dayOfWeek.toInt()).getFollowingDayOfWeek(this.dayOfWeek);
                    break;
                default:
                    break;
            }
        }
        return result;

    }

}