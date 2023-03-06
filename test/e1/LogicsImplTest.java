package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class LogicsImplTest {

    Logics logic;
    public static final int BOARD_SIZE = 5;

    Pair<Integer, Integer> knightStartPosition = new Pair<>(3,4);
    Pair<Integer, Integer> pawnStartPosition = new Pair<>(1, 3);

    @BeforeEach
    void setUp() {
        this.logic = new LogicsImpl(BOARD_SIZE, knightStartPosition, pawnStartPosition);
    }

    @Test
    void testisKnightOnBoardPosition() {
        assertTrue(this.logic.hasKnight(knightStartPosition.getX(), knightStartPosition.getY()));
    }

    @Test
    void testisPawnOnBoardPosition() {
        assertTrue(this.logic.hasPawn(pawnStartPosition.getX(), pawnStartPosition.getY()));
    }

    @Test
    void testCanHit() {
        assertTrue(this.logic.hit(1, 3));
        assertTrue(this.logic.hasKnight(1, 3));
    }

    @Test
    void testCanMoveNotHit() {
        assertFalse(this.logic.hit(2, 2));
        assertTrue(this.logic.hasKnight(2,2));
        assertFalse(this.logic.hasPawn(2,2));
    }

    @Test
    void testCannotMove() {
        assertFalse(this.logic.hit(3,2));
        assertFalse(this.logic.hasKnight(3,2));
    }


    @Test
    void testIsKnightOnBoardRandomPosition() {
        this.logic = new LogicsImpl(BOARD_SIZE);


        boolean isKnightFound = IntStream.range(0, BOARD_SIZE)
                .boxed()
                .flatMap(x -> IntStream.range(0, BOARD_SIZE)
                        .mapToObj(y -> new Pair<>(x,y)))
                .anyMatch(p -> this.logic.hasKnight(p.getX(), p.getY()));

        assertTrue(isKnightFound);
    }

    @Test
    void testIsmPawnOnBoardRandomPosition() {
        this.logic = new LogicsImpl(BOARD_SIZE);

        boolean isPawnFound = IntStream.range(0, BOARD_SIZE)
                .boxed()
                .flatMap(x -> IntStream.range(0, BOARD_SIZE)
                        .mapToObj(y -> new Pair<>(x,y)))
                .anyMatch(p -> this.logic.hasKnight(p.getX(), p.getY()));

        assertTrue(isPawnFound);

    }








}