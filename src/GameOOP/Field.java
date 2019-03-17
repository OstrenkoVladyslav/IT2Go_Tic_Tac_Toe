package GameOOP;

public class Field implements Cloneable {
    private char[][] field;
    private int size;
    private char x_cell;
    private char o_cell;
    private char empty_cell;
    private int lastMoveX, lastMoveY;
    private int dotsToWin;

    public Field(int size, char x_cell, char o_cell, char emptyCell, int dotsToWin) {
        field = new char[size][size];
        this.size = size;
        this.x_cell = x_cell;
        this.o_cell = o_cell;
        this.empty_cell = emptyCell;
        this.dotsToWin = dotsToWin;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = emptyCell;
            }
        }
    }

    public char getCell(int i, int j) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            return field[i][j];
        }
        return '\u0000';
    }

    public void setCell(int i, int j, char cell) {
        if (i >= 0 && i < size && j >= 0 && j < size) {
            field[j][i] = cell;
            lastMoveY = i;
            lastMoveX = j;
        }
    }

    public int getSize(){
        return size;
    }

    public void clone(Field newField){
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){
                newField.setCell(i,j,this.getCell(i,j));
            }
        }
    }

    public char getX_cell() {
        return x_cell;
    }

    public char getO_cell() {
        return o_cell;
    }

    public char getEmpty_cell() {
        return empty_cell;
    }

    public int getDotsToWin() {
        return dotsToWin;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= size; i++){
            stringBuilder.append(i);
            stringBuilder.append(' ');
        }
        stringBuilder.append('\n');
        for (int i = 0; i < size; i++){
            stringBuilder.append(i+1);
            stringBuilder.append(' ');
            for (int j = 0; j < size; j++){
                stringBuilder.append(field[i][j]);
                stringBuilder.append(' ');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
