class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        boolean[] isVisit = new boolean[tiles.length()];

        dfs(tiles, isVisit, "", result);

        return result.size();
    }

    public static void dfs(String tiles, boolean[] isVisit, String substr, Set<String> result) {
        if (!substr.isEmpty()) {
            result.add(substr);
        }

        for (int i = 0; i < tiles.length(); i ++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                dfs(tiles, isVisit, substr + tiles.charAt(i), result);
                isVisit[i] = false;
            }
        }
    }
}