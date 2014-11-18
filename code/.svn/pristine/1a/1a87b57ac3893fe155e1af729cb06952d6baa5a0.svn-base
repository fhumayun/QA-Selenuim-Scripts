# Readme for Java 1.6, Java 1.7 and Java 1.8 Compatibility

## 1.6 Compatibility

### switch on String not allowed in Java 1.6

In the  videos you will see one Java 1.7 feature.

I use a switch statement that takes a string as an argument.

            switch (defaultBrowser){
                case "FIREFOX":
                    useThisDriver = BrowserName.FIREFOX;
                    break;

Because a common FAQ has been related to this e.g. Why do I get the error ""java: strings in switch are not supported in -source 1.6 (use -source 7 or higher to enable strings in switch)"

Which I describe on my Java For Testers blog.

http://javafortesters.blogspot.co.uk/2014/03/how-to-fix-java-language-level-issues.html

And because some people have tried to run the code using Java 1.6 (no reason why they shouldn't, it should mostly work).

I've decided to make the code base 'mostly' 1.6 compatible.

I have amended the code which uses the switch statement, so this is no longer in use. I now have a set of 'if' statements instead. But have left in the switch statements as comments so that those people interested can see the old code.

### Additional Amendments Required to use 1.6

I have left the pom configuration using 1.7, to allow those of you who want the editor to support 1.7 and use 1.7 features to be able to.

If you want to use Java 1.6 JDK then you should do the following:

* In the pom.xml amend apache maven compiler plugin to use source and target of 1.6 rather than 1.7, or delete this section from the pom.xml
* In the test class JUnitExercisesTest and in the method assertThatBonusQuestion you should comment out the assert line which uses both and .and

Other than these changes I know of nothing else in the code base which should prevent it from running on 1.6

## 1.7 Compatibility

And those of you that want to use 1.7 should be fine. No changes required. This was the JDK version used to create the course.

## 1.8 Compatibility

If you want to use 1.8 features in your code then you might want to amend the pom.xml to have a source of 1.8, and possibly amend the target as well.

The code will work fine on a Java 1.8 JDK, but unless you make the change to the pom.xml file, you might find that the IDE does not allow you to use 1.8 syntax in your code.

