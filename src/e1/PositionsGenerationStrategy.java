package e1;

import java.util.Iterator;

@FunctionalInterface
public interface PositionsGenerationStrategy<X> {
    Iterator<X> getPositionIterator();
}
