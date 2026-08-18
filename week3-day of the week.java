class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
         java.time.LocalDate date = java.time.LocalDate.of(year, month, day);
        return date.getDayOfWeek().toString().substring(0, 1)
                + date.getDayOfWeek().toString().substring(1).toLowerCase();
    }
}