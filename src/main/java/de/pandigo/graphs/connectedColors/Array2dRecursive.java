package de.pandigo.graphs.connectedColors;

import java.util.*;

/**
 * The recursive way is only valid for not too big 2d arrays since the java stack where the recursion is done has a limit.
 * For bigger arrays the iterative solution should be used.
 */
public class Array2dRecursive {

    /**
     * Performs the dfs operation for each field in the grid.
     *
     * @param fields the fields to be checked for connected colors.
     */
    public void calculateConnectedFields(int [][] fields) {
        int maxCount = 0;
        int maxColor = 0;

        int columnLength = 0;
        if(fields.length > 0) {
            columnLength = fields[0].length;
        }
        int[][] visitedFields = new int[fields.length][columnLength];

        for(int row = 0; row < fields.length; row++) {
            for(int column = 0; column < columnLength; column++) {
                int currentCount = dfs(visitedFields, fields, row, column, 0, fields[row][column]);
                if(currentCount > maxCount) {
                    maxColor = fields[row][column];
                    maxCount = currentCount;
                }
            }
        }

        System.out.println("Maximal connected fields ("+maxCount+") are from color: "+ maxColor);
    }

    /**
     * The core function, recursively checks the neighbour fields of a given start field until no neighbour fields with the
     * same color are left.
     *
     * @param visitedFields the same grid as the color grid just with information about if a field was already visited.
     * @param fields the color grid
     * @param row the current row
     * @param column the current column
     * @param currentCount the current count of the color we are searching for
     * @param color the current color we are searching for.
     * @return the number of connected fields for the currentColor
     */
    public int dfs(int[][] visitedFields, int[][] fields, int row, int column, int currentCount, int color) {
        if (visitedFields[row][column] != 1 && fields[row][column] == color) {
            currentCount++;
            visitedFields[row][column] = 1;
            for(Field field : getNeighbours(fields, row, column)) {
                currentCount = dfs(visitedFields, fields, field.getY(), field.getX(), currentCount, color);
            }
        }
        return currentCount;
    }

    /**
     * we get any neighbours and check them in the recursive function, it could also be checked here if they fulfill
     * the criteria.
     *
     * @param fields the fields with the color information
     * @param row the current row
     * @param column the current column
     * @return a list of neighbour fields, which are still placed on a valid position in the grid.
     */
    private List<Field> getNeighbours(int[][] fields, int row, int column) {
        List<Field> fieldList = new ArrayList<>();
        if(row - 1 >= 0) {
            fieldList.add(new Field(column,row-1));
        }
        if(row + 1 < fields.length) {
            fieldList.add(new Field(column,row+1));
        }
        if(column - 1 >= 0) {
            fieldList.add(new Field(column-1,row));
        }
        if(column + 1 < fields[0].length) {
            fieldList.add(new Field(column+1,row));
        }
        return fieldList;
    }

    public class Field {
        private int x;
        private int y;

        public Field(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}
