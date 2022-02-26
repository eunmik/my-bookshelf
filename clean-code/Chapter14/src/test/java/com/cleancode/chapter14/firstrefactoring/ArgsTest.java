package com.cleancode.chapter14.firstrefactoring;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class ArgsTest {
    @Test
    public void testCreateWithNoSchemaOrArguments() throws Exception {
        Args args = new Args("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    @Test
    public void testWithNoSchemaButWithOneArgument() throws Exception {
        try{
            new Args("", new String[]{"-x"});
            fail();
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testWithNoSchemaButWithMultipleArguments() throws Exception {
        try {
            new Args("", new String[]{"-x", "-y"});
            fail();
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testNonLetterSchema() throws Exception{
        try {
            new Args("*", new String[]{});
            fail("Args constructor should have thrown exception");
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testInvalidArgumentFormat() throws Exception {
        try {
            new Args("f~", new String[]{});
            fail("Args constructor should have throws exception");
        } catch (ParseException e){
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testSimpleBooleanPresent() throws Exception {
        Args args = new Args("x", new String[]{"-x"});
        assertEquals(1, args.cardinality());
        assertTrue(args.getBoolean('x'));
    }

    @Test
    public void testSimpleStringPresent() throws Exception {
        Args args = new Args("x*", new String[]{"-x", "param"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals("param", args.getString('x'));
    }

    @Test
    public void testMissingStringArgument() {
        try {
            new Args("x*", new String[]{"-x"});
            fail();
        } catch (ParseException e) {

        }
//        } catch (ArgsException e) {
//            assertEquals(ArgsException.ErrorCode.MISSING_STRING, e.getErrorCode());
//            assertEquals('x', e.getErrorArgumentId());
//        }
    }

    @Test
    public void testSpacesInFormat() throws Exception {
        Args args = new Args("x, y", new String[]{"-xy", "true", "false"});
        assertEquals(2, args.cardinality());
        assertTrue(args.has('x'));
        assertTrue(args.has('y'));
    }

    @Test
    public void testSimpleIntPresent() throws Exception {
        Args args = new Args("x#", new String[]{"-x", "42"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
      //  assertEquals(42, args.getInt('x'));
    }

    @Test
    public void testInvalidInteger() {
        try {
            new Args("x#", new String[]{"-x", "Forty two"});
            fail();
        } catch (ParseException e) {

        }
//        } catch (ArgsException e) {
//            assertEquals(ArgsException.ErrorCode.INVALID_INTEGER, e.getErrorCode());
//            assertEquals('x', e.getErrorArgumentId());
//            assertEquals("Forty two", e.getErrorParameter());
//        }

    }

    @Test
    public void testMissingInteger() {
        try {
            new Args("x#", new String[]{"-x"});
            fail();
        } catch (ParseException e) {

        }
//        } catch (ArgsException e) {
//            assertEquals(ArgsException.ErrorCode.MISSING_INTEGER, e.getErrorCode());
//            assertEquals('x', e.getErrorArgumentId());
//        }
    }

    @Test
    public void testSimpleDoublePresent() throws Exception {
        Args args = new Args("x##", new String[]{"-x", "42.3"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
     //   assertEquals(42.3, args.getDouble('x'), .001);
    }

    @Test
    public void testInvalidDouble() {
        try {
            new Args("x##", new String[]{"-x", "Forty two"});
            fail();
        } catch (ParseException e) {

        }
//        } catch (ArgsException e) {
//            assertEquals(ArgsException.ErrorCode.INVALID_DOUBLE, e.getErrorCode());
//            assertEquals('x', e.getErrorArgumentId());
//            assertEquals("Forty two", e.getErrorParameter());
//        }
    }

    @Test
    public void testMissingDouble() {
        try {
            new Args("x##", new String[]{"-x"});
            fail();
        } catch (ParseException e) {

        }
//        } catch (ArgsException e) {
//            assertEquals(ArgsException.ErrorCode.MISSING_DOUBLE, e.getErrorCode());
//            assertEquals('x', e.getErrorArgumentId());
//        }
    }


}