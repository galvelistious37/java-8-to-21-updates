package com.johnny.privateinterfacemethods;

/**
 * Why 'private' interface methods?
 *   1. Reduce code duplications
 *   2. Improve encapsulation by hiding implementation details
 */
interface InefficientTennis {
    static void forehand(){
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into ready position");
    }

    default void backhand(){
        System.out.println("Move into position");
        System.out.println("Hitting a backhand");
        System.out.println("Move back into ready position");
    }

    default void smash(){
        System.out.println("Move into position");
        System.out.println("Hitting a smash");
        System.out.println("Move back into ready position");
    }
}

/**
 * NOe: If 'hit' is simply 'private' and not 'private static' then 'forehand'
 * has an issue. This is the same as with classes. Instanct to static is ok, but
 * not the other way around.
 */
interface Tennis{
    private static void hit(String stroke){
        System.out.println("Move into position");
        System.out.println("Hitting a " + stroke);
        System.out.println("Move back into ready position");
    }
    static void forehand(){hit("forehand");}
    default void backhand(){hit("backhand");}
    private void smash(){hit("smash");}
}

class ProfessionalTennis implements Tennis{}

public class PrivateInterfaceMethods{
    public static void main(String[] args) {
        // The hit() method is hidden/inaccessible from inhereted classes
        Tennis tennis = new ProfessionalTennis();
        tennis.backhand();
        Tennis.forehand();
    }
}