class Solution {
    public int dayOfYear(String date) {
       java.time.LocalDate d = java.time.LocalDate.parse(date);
        return d.getDayOfYear();
    }
}