package com.cleancode.chapter15.defactoring;
//import junit.framework.ComparisonCompactor;
import com.cleancode.chapter15.ComparisonCompactor;
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;


public class ComparisonCompactorTest extends TestCase{

    @Test
    public void testMessage() {
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, "b", "c").compact("a");
        assertTrue("a expected:<[b]> but was:<[c]>".equals(failure));
    }

    @Test
    public void testStartSame(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(1, "ba", "bc").compact(null);
        assertEquals("expected:<b[a]> but was:<b[c]>", failure);
    }

    @Test
    public void testEndSame() {
        String failure = new com.cleancode.chapter15.ComparisonCompactor(1, "ab", "cb").compact(null);
        assertEquals("expected:<[a]b> but was:<[c]b>", failure);
    }

    @Test
    public void testSame(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(1, "ab", "ab").compact(null);
        assertEquals("expected:<ab> but was:<ab>", failure);
    }

    @Test
    public void testNoContextStartAndEndSame(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, "abc", "adc").compact(null);
        assertEquals("expected:<...[b]...> but was:<...[d]...>", failure);
    }

    @Test
    public void testStartAndEndContext(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(1, "abc", "adc").compact(null);
        assertEquals("expected:<a[b]c> but was:<a[d]c>", failure);
    }

    @Test
    public void testStartAndEndContextWithEllipses(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(1, "abcde", "abfde").compact(null);
        assertEquals("expected:<...b[c]d...> but was:<...b[f]d...>", failure);
    }

    @Test
    public void testComparisonErrorStartSameComplete(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(2, "ab", "abc").compact(null);
        assertEquals("expected:<ab[]> but was:<ab[c]>", failure);
    }

    @Test
    public void testComparisonErrorEndSameComplete(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, "bc", "abc").compact(null);
        assertEquals("expected:<[]...> but was:<[a]...>", failure);
    }

    @Test
    public void testComparisonErrorEndSameCompleteContext(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(2, "bc", "abc").compact(null);
        assertEquals("expected:<[]bc> but was:<[a]bc>", failure);
    }

    @Test
    public void testComparisonErrorOverlapingMatches(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, "abc", "abbc").compact(null);
        assertEquals("expected:<...[]...> but was:<...[b]...>", failure);
    }

    @Test
    public void testComparisonErrorOverlapingMatchesContext(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(2, "abc", "abbc").compact(null);
        assertEquals("expected:<ab[]c> but was:<ab[b]c>", failure);
    }

    @Test
    public void testComparisonErrorOverlapingMatches2(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, "abcdde", "abcde").compact(null);
        assertEquals("expected:<...[d]...> but was:<...[]...>", failure);
    }

    @Test
    public void testComparisonErrorOverlapingMatches2Context(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(2, "abcdde", "abcde").compact(null);
        assertEquals("expected:<...cd[d]e> but was:<...cd[]e>", failure);
    }

    @Test
    public void testComparisonErrorWithActualNull(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, "a", null).compact(null);
        assertEquals("expected:<a> but was:<null>", failure);
    }

    @Test
    public void testComparisonErrorWithActualNullContext(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(2, "a", null).compact(null);
        assertEquals("expected:<a> but was:<null>", failure);
    }

    @Test
    public void testComparisonErrorWithExpectedNull(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(0, null, "a").compact(null);
        assertEquals("expected:<null> but was:<a>", failure);
    }

    @Test
    public void testComparisonErrorWithExpectedNullContext(){
        String failure = new com.cleancode.chapter15.ComparisonCompactor(2, null, "a").compact(null);
        assertEquals("expected:<null> but was:<a>", failure);
    }

    @Test
    public void testBug609972(){
        String failure = new ComparisonCompactor(10, "S&P500", "0").compact(null);
        assertEquals("expected:<[S&P50]0> but was:<[]0>", failure);
    }





}
