import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class SpellResult {

    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private ArrayList<String> s;

    public SpellResult() {

    }

    public SpellResult(@JsonProperty("code") int code, @JsonProperty("pos") int pos, @JsonProperty("row") int row, @JsonProperty("col") int col, @JsonProperty("len") int len, @JsonProperty("word") String word, @JsonProperty("s") ArrayList<String> s) {
        this.code = code;
        this.pos = pos;
        this.row = row;
        this.col = col;
        this.len = len;
        this.word = word;
        this.s = s;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public ArrayList<String> getS() {
        return s;
    }

    public void setS(ArrayList<String> s) {
        this.s = s;
    }
}
