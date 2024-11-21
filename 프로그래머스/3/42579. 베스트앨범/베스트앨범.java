import java.util.*;
import java.util.stream.*;

class Solution {
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, ArrayList<int[]>> genreMap = new HashMap<>();
        Map<String, Integer> playMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (!genreMap.containsKey(genre)) {
                genreMap.put(genre, new ArrayList<>());
                playMap.put(genre, 0);
            }
            
            genreMap.get(genre).add(new int[]{i, play});
            playMap.put(genre, playMap.get(genre) + play);
        }
        
        Stream<Map.Entry<String, Integer>> sortedGenre = playMap.entrySet().stream()
            .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        sortedGenre.forEach (entry -> {
            Stream<int[]> sortedSongs = genreMap.get(entry.getKey()).stream()
                .sorted((o1, o2) -> Integer.compare(o2[1], o1[1]))
                .limit(2);
            sortedSongs.forEach (song -> answer.add(song[0]));
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}