class Checker implements Comparator<Player> {

    public int compare(Player a, Player b) {

        if (a.score != b.score) {
            return Integer.compare(b.score, a.score);
        }

        return a.name.compareTo(b.name);
    }
}