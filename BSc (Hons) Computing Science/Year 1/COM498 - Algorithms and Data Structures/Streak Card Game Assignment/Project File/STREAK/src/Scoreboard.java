public class Scoreboard {

    private String name;
    private int score;

    public Scoreboard(String aName, int aScore) {
        name = aName;
        score = aScore;
    }

    private int getScore() { return score; }

    public int compareTo(Scoreboard otherScore) {
        if (this.getScore() < otherScore.getScore()) return 1;
        else if (this.getScore() > otherScore.getScore()) return -1;
        else return 0;
    }

    public String toString() {
        String str = String.format("%-10s %-3s \n", name, ": " + score);
        return str;
    }
}
