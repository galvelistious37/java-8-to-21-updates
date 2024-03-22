package com.johnny.annotations.custom;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Example - "Value" element for shorthand
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Team{
    // "value" element is the key!
    String value() default "Soccer"; // required or optional is fine
    int numPlayers() default 2;
}

class Sport{
    @Team(numPlayers = 6, value="Volleyball") void beach(){}
    @Team(value = "Tennis") void strawberriesAndCream(){}
    @Team("Curling") void slow(){};
}

@interface Quiz{
    String[] topics();
}

class Competitor{
    @Quiz(topics={"General Knowledge", "Music"}) String favoriteTopic;
    @Quiz(topics={"Sport"}) String leastFavoriteTopic;
    @Quiz(topics="Sport") String leastOtherFavoriteTopic;
}

@interface Colors{
    String[] value();
}

class TestRainbow{
    @Colors(value={"Red"}) String color1;
    @Colors(value="Red") String color2;
    @Colors({"Red"}) String color3;
    @Colors("Red") String color4;
}

public class ShortHand {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Sport> classReflection = Sport.class;
        Method method = classReflection.getDeclaredMethod("beach");
        if(method.isAnnotationPresent(Team.class)){
            Team teamAnnotation = method.getAnnotation(Team.class);
            String value = teamAnnotation.value();
            int players = teamAnnotation.numPlayers();
            System.out.println("Value: " + value);
            System.out.println("Players: " + players);
        }
    }
}
