import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SquareSet implements Set<Square> {

    public Square[] squares;

    class SquareIterator implements Iterator<Square> {

        int currentIndex;

        SquareIterator() {
            currentIndex = -1;
        }

        @Override
        public boolean hasNext() {
            return (currentIndex + 1) <= (squares.length - 1);
        }

        @Override
        public Square next() {
            currentIndex++;
            return squares[currentIndex];
        }
    }

    public SquareSet() {
        squares = new Square[0];
    }

    @Override
    public boolean add(Square newSquare) throws InvalidSquareException {

        if (!Square.isInBounds(newSquare)) {
            throw new InvalidSquareException(newSquare);
        }

        Square[] newSquares = new Square[squares.length+1];
        for (int i = 0; i < squares.length; i++) {

            if (squares[i].equals(newSquare)) {
                return false;
            }

            newSquares[i] = squares[i];
        }
        newSquares[newSquares.length-1] = newSquare;

        squares = newSquares;

        return true;
    }

    @Override
    public boolean contains(Object o) {

        for (int i = 0; i < squares.length; i++) {
            if (squares[i].equals(o)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {

        for (Object c : collection) {
            if (!this.contains(c)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof SquareSet)) {
            return false;
        }

        SquareSet ss = (SquareSet) obj;

        if (ss.size() != this.size()) {
            return false;
        }

        Iterator<Square> iteratorObj = ss.iterator();
        Square currentSquare = null;
        boolean found = false;
        while (iteratorObj.hasNext()) {

            currentSquare = iteratorObj.next();

            Iterator<Square> iteratorThis = this.iterator();
            while (iteratorThis.hasNext()) {
                if (currentSquare.equals(iteratorThis.next())) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }

            found = false;

        }

        return true;
    }

    @Override
    public int hashCode() {

        int hash = 0;

        for (int i = 0; i < squares.length; i++) {

            if (squares[i] == null) {
                continue;
            }

            hash += squares[i].hashCode();

        }

        return hash;

    }

    @Override
    public boolean isEmpty() {
        return squares.length == 0;
    }

    @Override
    public Iterator<Square> iterator() {
        return new SquareIterator();
    }

    @Override
    public int size() {
        return squares.length;
    }

    @Override
    public Object[] toArray() {
        return squares;
    }

    @Override
    public <T> T[] toArray(T[] a) {

        if (a.length < this.size()) {
            a = (T[]) Array.newInstance(a.getClass().getComponentType(), this.size());
        } else if (a.length > this.size()) {
            a[this.size()] = null;
        }

        for (int i = 0; i < this.size(); i++) {
            a[i] = (T) squares[i];
        }

        return a;
    }

    @Override
    public boolean addAll(Collection<? extends Square> c) throws InvalidSquareException {

        SquareSet sqNew = new SquareSet();
        sqNew.squares = squares;

        for (Square s : c) {
            sqNew.add(s);
        }

        squares = sqNew.squares;

        return true;
    }

    //I don't know the optimal way to do this, so I'll just loop through the damn thing twice
    @Override
    public boolean remove(Object o) {

        boolean hasMatch = false;

        for (int i = 0; i < squares.length; i++) {
            if (o.equals(squares[i])) {
                hasMatch = true;
                break;
            }
        }

        if (!hasMatch) {
            return false;
        }

        int j = 0;
        Square[] newSquares = new Square[this.size() - 1];

        for (int i = 0; i < squares.length; i++) {
            if (squares[i].equals(o)) {
                continue;
            }

            newSquares[j] = squares[i];
            j++;
        }

        squares = newSquares;

        return true;
    }

    /*
        EVERYTHING BELOW HERE IS NOT NEEDED FOR THE ASSIGNMENT
        BUT I ADDED THEM ANYWAY BECAUSE THEY MIGHT BE USEFUL
        FOR FUTURE ASSIGNMENTS
     */

    @Override
    public boolean retainAll(Collection<?> collection) {

        ArrayList<Object> notInSquares = new ArrayList<>();

        for (Object s : this) {
            if (!collection.contains(s)) {
                notInSquares.add(s);
            }
        }

        return remove(notInSquares);
    }

    @Override
    public boolean removeAll(Collection<?> collection) {

        boolean didChange = false;

        for (Object c : collection) {
            if (this.remove(c)) {
                didChange = true;
            }
        }

        return didChange;
    }

    @Override
    public void clear() {
        squares = new Square[0];
    }

}
