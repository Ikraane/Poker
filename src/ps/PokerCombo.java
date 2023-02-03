package ps;

public enum PokerCombo {
    NONE(0), PAIR(1), TWOPAIR(3), TRISS(6), FOUR(16), FLUSH(8);

    public int getValue() {return value;}

    private final int value;

    private PokerCombo(int value) {this.value = value;}
}
