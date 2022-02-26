package com.cleancode.chapter14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import static com.cleancode.chapter14.ArgsException.ErrorCode.*;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {
    private List<String> stringArrayValue = new ArrayList<>();

    public void set(Iterator<String> currentArgument) throws ArgsException{

        try{
            stringArrayValue.add(currentArgument.next());
        }catch (NoSuchElementException e){
            throw new ArgsException(MISSING_STRING);
        }
    }
    
    public static String[] getValue(ArgumentMarshaler am){
        if (am!=null && am instanceof StringArrayArgumentMarshaler)
            return ((StringArrayArgumentMarshaler) am).stringArrayValue.toArray(new String[0]);
        else
            return new String[0];
    }
}
