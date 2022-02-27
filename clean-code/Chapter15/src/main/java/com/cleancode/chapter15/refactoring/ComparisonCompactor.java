package com.cleancode.chapter15.refactoring;

import junit.framework.Assert;

public class ComparisonCompactor {
    private static final String ELLIPSIS = "...";
    private static final String DELTA_END = "]";
    private static final String DELTA_START = "[";

    private int contextLength;
    private String expected;
    private String actual;
    private int prefixIndex;
    private int suffixIndex;
    private int suffixLength;
    private int prefixLength;
    private String compactExpected;
    private String compactActual;

    public ComparisonCompactor(int contextLength, String expected, String actual) {
        this.contextLength = contextLength;
        this.expected = expected;
        this.actual = actual;

    }

    public String formatCompactedComparison(String message){
        if(canBeCompacted())
            compactExpectedAndActual();
            return Assert.format(message, compactExpected, compactActual);
    }

    private boolean canBeCompacted() {
        return expected != null && actual != null && !areStringEqual();
    }

    private void compactExpectedAndActual() {
        findCommonPrefixAndSuffix();
        compactExpected = compactString(expected);
        compactActual = compactString(actual);
    }

    private void findCommonPrefixAndSuffix(){
        findCommonPrefix();
        suffixLength = 0;
        for (;  !suffixOverlapsPrefix(suffixLength); suffixLength++){
            if( charFromEnd(expected, suffixLength) != charFromEnd(actual, suffixLength))
                break;
        }
        suffixIndex = suffixLength;
    }

    private char charFromEnd(String s, int i){
        return s.charAt(s.length() - i);
    }

    private boolean suffixOverlapsPrefix(int suffixLength){
        return actual.length() - suffixLength < prefixIndex || expected.length() - suffixLength < prefixIndex;
    }

    private String compactString(String source){
        return computeCommonPrefix() + DELTA_START + source.substring(prefixIndex, source.length() - suffixLength) + DELTA_END + computeCommonSuffix();
    }

    private void findCommonPrefix() {
        prefixIndex = 0;
        int end = Math.min(expected.length(), actual.length());
        for (;prefixIndex < end; prefixIndex++) {
            if (expected.charAt(prefixIndex) != actual.charAt(prefixIndex))
            break;
        }
    }

    private int findCommonSuffix(int prefixIndex){
        int expectedSuffix = expected.length() -1;
        int actualSuffix = actual.length() -1;
        for (; actualSuffix >= prefixIndex && expectedSuffix >= prefixIndex; actualSuffix--, expectedSuffix--) {
            if(expected.charAt(expectedSuffix) != actual.charAt(actualSuffix))
                break;
        }
        return expected.length() - expectedSuffix;
    }

    private String computeCommonPrefix() {
        return (prefixLength > contextLength ? ELLIPSIS : "") + expected.substring(Math.max(0, prefixIndex - contextLength), prefixIndex);

    }

    private String computeCommonSuffix() {
        int end = Math.min(expected.length() - suffixLength + contextLength, expected.length());
        return expected.substring(expected.length() - suffixLength, end) + (expected.length() - suffixLength < expected.length() - contextLength ? ELLIPSIS : "");
    }

    private  boolean areStringEqual() {
        return expected.equals(actual);
    }
}
