import jdk.nashorn.internal.runtime.ECMAException;
import org.omg.CORBA.INITIALIZE;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ChessTester {

    public static void main(String[] args) {

        //NO ARG CONSTRUCTOR (5PTS)
        SquareSet ss = new SquareSet();


        Square s1 = new Square("a1");   //valid
        Square s1Copy = new Square("a1"); //valid, but same as s1
        Square s2 = new Square("b2");   //valid
        Square s3 = new Square("c3");   //valid
        Square s4 = new Square("d4");   //valid
        Square s5 = new Square("e5");   //valid
        Square s6 = new Square("a9");   //invalid

        //ADDS A VALID SQUARE NOT ALREADY IN THE SET (5PTS)
        ss.add(s1);
        //DOESN'T ADD A SQUARE ALREADY IN THE SET (5PTS)
        ss.add(s1Copy);
        printSquareSet(ss);

        ss.add(s2);
        ss.add(s3);
        ss.add(s4);
        ss.add(s5);
        //THROWS AN EXCEPTION FOR INVALID SQUARES (5PTS)
        try {
            ss.add(s6);
        } catch (InvalidSquareException isE) {
            System.out.println("There was an issue adding piece: " + isE.getMessage());
        }
        printSquareSet(ss);

        //CONTAINS METHOD (10PTS)
        System.out.println("<contains> Should be true: " + ss.contains(new Square("a1")));  //does contain this
        System.out.println("<contains> Should be false: " + ss.contains(new Square("a2")));  //does not contain this

        System.out.println();

        //CONTAINS ALL METHOD (10PTS)
        ArrayList<Square> containsAllTrue = new ArrayList<>();
        containsAllTrue.add(s1);
        containsAllTrue.add(s2);
        containsAllTrue.add(s3);
        containsAllTrue.add(s4);
        containsAllTrue.add(s5);
        ArrayList<Square> containsAllFalse = new ArrayList<>();
        containsAllFalse.add(s1);
        containsAllFalse.add(s2);
        containsAllFalse.add(s3);
        containsAllFalse.add(s4);
        containsAllFalse.add(s6);    //this is not in the list
        System.out.println("<containsAll> Should be true: " + ss.containsAll(containsAllTrue));    //check1
        System.out.println("<containsAll> Should be false: " + ss.containsAll(containsAllFalse));   //check2

        System.out.println();

        //EQUALS (10PTS)
        SquareSet ssEquals = new SquareSet();
        ssEquals.add(new Square("e5"));
        ssEquals.add(new Square("a1"));
        ssEquals.add(new Square("b2"));
        ssEquals.add(new Square("c3"));
        ssEquals.add(new Square("d4"));
        SquareSet ssNotEquals = new SquareSet();
        ssNotEquals.add(new Square("a1"));
        ssNotEquals.add(new Square("b2"));
        ssNotEquals.add(new Square("c3"));
        ssNotEquals.add(new Square("d4"));
        ssNotEquals.add(new Square("e5"));
        ssNotEquals.remove(new Square("b2"));
        ssNotEquals.add(new Square("b7"));
        printSquareSet(ssEquals);
        printSquareSet(ssNotEquals);
        System.out.println("<equals> Should be true: " + ss.equals(ssEquals));
        System.out.println("<equals> Should be false: " + ss.equals(ssNotEquals));
        System.out.println("<equals> should be false: " + ss.equals(new SquareSet()));

        System.out.println();

        //ISEMPTY (10 PTS)
        System.out.println("<isEmpty> Should be true: " + (new SquareSet()).isEmpty());
        System.out.println("<isEmpty> Should be false: " + ss.isEmpty());

        System.out.println();

        //ITERATOR (10PTS)
        printSquareSet(ss); //this prints using the iterator

        System.out.println();

        //SIZE (5PTS)
        System.out.println("<size> Should be 5: " + ss.size());

        System.out.println();

        //TO ARRAY (5 PTS)
        printObjectArray(ss.toArray());
        System.out.println(ss.toArray().getClass().getCanonicalName());

        System.out.println();

        //HASH CODE
        System.out.println("<hashCode> This should print a number: " + ss.hashCode());

        //ADD ALL (10 PTS)
        System.out.println("Here are the values in the original list:");
        printSquareSet(ss);
        ArrayList<Square> listToAdd = new ArrayList<>();
        listToAdd.add(new Square("a5"));
        listToAdd.add(new Square("b4"));
        listToAdd.add(new Square("c3"));
        listToAdd.add(new Square("d2"));
        listToAdd.add(new Square("e1"));
        ss.addAll(listToAdd);
        System.out.println("Here is after adding the valid list:");
        printSquareSet(ss); //notice that the addAll didn't add the c3 because it is already there
        ArrayList<Square> listToAddException = new ArrayList<>();
        listToAddException.add(new Square("q7"));
        try {
            ss.addAll(listToAddException);  //this should throw an exception
        } catch (InvalidSquareException isE) {
            System.out.println("There was a problem with the following square: " + isE.getMessage());
        }

        /**
         * I DONT KNOW WHAT TO DO WITH THE OTHER TOARRAY METHOD
         *
         * WILL LOOK INTO IT
         *
         * SO FAR THIS HW WOULD EARN 130 PTS I THINK
         */

    }

    public static void printSquaresInList(List<Square> squares) {
        for (Square s : squares) {
            System.out.println(s);
        }
    }

    //this will be a good way to test the iterator
    public static void printSquareSet(SquareSet ss) {

        Iterator<Square> iterator = ss.iterator();

        System.out.println("Here are the squares in the square set:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println();

    }

    public static void printObjectArray(Object[] objects) {

        for (Object o : objects) {
            System.out.println(o);
        }
        System.out.println();

    }

    public static void printSquareArray(Square[] squares) {

        if (squares.length == 0) {
            System.out.print("None");
        }

        printObjectArray(squares);

    }

}
