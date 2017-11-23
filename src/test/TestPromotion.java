package test;

import game.Board;
import game.Cell;
import game.PlayerColor;

/**
 * Created by Martial on 07/09/2017.
 */
public class TestPromotion {
    final static Object lock = new Object();
    public static void main(String[] args){
        Board b = new Board(lock);
        b.move(Cell.E2,Cell.E4, PlayerColor.WHITE);
        b.move(Cell.D7,Cell.D5, PlayerColor.BLACK);
        b.move(Cell.E4,Cell.D5, PlayerColor.WHITE);
        b.move(Cell.E7,Cell.E6, PlayerColor.BLACK);
        b.move(Cell.D5,Cell.D6, PlayerColor.WHITE);
        b.move(Cell.D8,Cell.G5, PlayerColor.BLACK);
        b.move(Cell.D6,Cell.D7, PlayerColor.WHITE);
        b.move(Cell.E8,Cell.E7, PlayerColor.BLACK);
        //b.move(Cell.D7,Cell.D8, PlayerColor.WHITE);
        //b.move(Cell.E8,Cell.E7, PlayerColor.BLACK);
        synchronized (lock){
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        b.terminate();
    }

}
