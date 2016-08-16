package com.tiy.ssa.week3.chess;

public interface Piece extends Comparable<Piece>
    {

        Location where();

        boolean canMove(Location where);

        @Override
        String toString();

        @Override
        public int compareTo(Piece o);

        /**
         * take into account intrinsic value and location
         * @param other
         * @return
         */
        @Override
        boolean equals(Object other);

        @Override
        public int hashCode();

        public int getValue();

    }