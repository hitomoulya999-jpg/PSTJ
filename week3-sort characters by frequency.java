class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];

        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        StringBuilder[] buckets = new StringBuilder[s.length() + 1];

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                if (buckets[freq[i]] == null) {
                    buckets[freq[i]] = new StringBuilder();
                }
                buckets[freq[i]].append((char) i);
            }
        }

        StringBuilder result = new StringBuilder();

        for (int count = s.length(); count >= 1; count--) {
            if (buckets[count] == null) {
                continue;
            }

            for (char c : buckets[count].toString().toCharArray()) {
                for (int j = 0; j < count; j++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}