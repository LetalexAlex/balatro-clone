package blinds;

import java.math.BigInteger;

public abstract class Blind {
    protected String name;
    protected BigInteger chipGoal;
    protected BigInteger currentChips;

    public Blind(String name, BigInteger chipGoal) {
        this.name = name;
        this.chipGoal = chipGoal;
        this.currentChips = new BigInteger("0");
    }

    public void addCurrentChips(BigInteger currentChips) {
        this.currentChips = this.currentChips.add(currentChips);
    }

    public boolean isWin() {
        return currentChips.compareTo(chipGoal) >= 0;
    }

}
