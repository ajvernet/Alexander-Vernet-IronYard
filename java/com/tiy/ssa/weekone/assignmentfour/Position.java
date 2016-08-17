package com.tiy.ssa.weekone.assignmentfour;

public class Position {
    public final int x;
    public final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Position other) {
        if (x == other.x && y == other.y)
            return true;

        return false;
    }

    public Position move(int x, int y) {

        return new Position(this.x + x, this.y + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Position is: (" + x + ", " + y + ").";
    }
}
