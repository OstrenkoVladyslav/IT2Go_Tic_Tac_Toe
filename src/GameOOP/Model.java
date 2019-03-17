package GameOOP;

import java.util.Arrays;
import java.util.Observable;

public class Model extends Observable{
    private char[][] field;
    private int size;
    public final char X_CELL = 'X';
    public final char O_CELL = 'O';
    public final char EMPTY_CELL = '.';

    public Model(int s){
        this.size = s;
        field = new char[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++){
                field[i][j] = EMPTY_CELL;
            }
        }
    }

    public boolean setField(int i, int j, char sign){
        //boolean moveIsCorrect = true;
        if (sign != X_CELL && sign != O_CELL && sign != EMPTY_CELL){
            return false;
        }
        if (field[j][i]!= EMPTY_CELL){
            return false;
        }
        field[j][i] = sign;
        setChanged();
        return true;
    }

    public void setChanged(){
        super.setChanged();
        notifyObservers();
    }

    public char getCell(int i, int j){
        return field[j][i];
    }

    public int getSize(){
        return size;
    }

    public char getX_CELL() {
        return X_CELL;
    }

    public char getO_CELL() {
        return O_CELL;
    }

//    public char getEMPTY_CELL() {
//        return EMPTY_CELL;
//    }

    @Override
    public String toString() {
        return "Model{" +
                "field=" + Arrays.deepToString(field) +
                '}';
    }
}
