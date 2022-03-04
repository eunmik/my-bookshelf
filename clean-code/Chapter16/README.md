## How refactoring processed 
1. the opening comment is long out of date, so I shortened and improved it. 
2. I moved all the remaining enums out into their own files. 
3. I moved the static variable (*dateFormatSymbols*) and three static methods (*getMonthNames, isLeapYear, lastDayOfMonth*) into a new class named DateUtil. 
4. I moved the abstract methods up to the top where they belong. 
5. I changed Month.make to Month.fromInt and did the same for all the other enums. 
6. I also created a toInt() accessor for all the enums and made the index field private. 
7. Duplication in plusYears and plusMonths are eliminated by extracting a new method named correctLastDayOfMonth, making the all three methods much clearer.
8. I got rid of the magic number 1, replacing it with Month.JANUARY.toInt() or Day.SUNDAY.toInt(), as appropriate.
9. I spent a little time with *SpreadsheetDate*, cleaning up the algorithms a bit. 


"Clean Code by Robert C. Martin"   
