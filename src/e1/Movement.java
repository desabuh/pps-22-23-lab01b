package e1;

import java.util.Optional;

@FunctionalInterface
public interface Movement<X> {
    Optional<X> move(X startPosition);
}
