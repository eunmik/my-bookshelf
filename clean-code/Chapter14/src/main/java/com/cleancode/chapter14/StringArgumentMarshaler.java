package com.cleancode.chapter14;
import static com.cleancode.chapter14.ArgsException.ErrorCode.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringArgumentMarshaler implements ArgumentMarshaler {
    private String stringValue = "";
    public void set(Iterator<String> currentArgument) throws ArgsException{
        try{
            stringValue = currentArgument.next();
        }catch (NoSuchElementException e){
            throw new ArgsException(MISSING_STRING);
        }
    }
    
    public static String getValue(ArgumentMarshaler am){
        if (am!=null && am instanceof StringArgumentMarshaler)
            return ((StringArgumentMarshaler) am).stringValue;
        else
            return "";
    }
}
