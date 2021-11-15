package algorithm.amazon202111.programmers.hash;

import util.CheckUtil;
import util.InputSet;
import util.PrintUtil;

import java.util.*;

public class Hash_BestAlbum {
    public static void main(String[] args){
        Hash_BestAlbum mClass = new Hash_BestAlbum();
        CheckUtil<Integer[]> mCheck = new CheckUtil<>();
//        mCheck.checkAnswerIntegerArray(new InputSet[]{
//                new InputSet(
//                        new int[]{4,1,3,0},
//                        mClass.solve(
//                                new String[]{"classic", "pop", "classic", "classic", "pop"},
//                                new int[]{500, 600, 150, 800, 2500}
//                                )
//                )
//        });
        int[] result = mClass.solve(
                new String[]{"classic", "pop", "classic", "classic", "pop"},
                new int[]{500, 600, 150, 800, 2500}
                );
        PrintUtil.println(Arrays.toString(result));
        PrintUtil.println("[4, 1, 3, 0]");
    }

    private int[] solve(String[] genres, int[] plays){
        Map<String, Integer> totalPlayedMap = new HashMap<>();
        Map<String, ArrayList<Album>> topPlayedMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(totalPlayedMap.containsKey(genres[i])){
                totalPlayedMap.put(genres[i], totalPlayedMap.get(genres[i])+plays[i]);
                ArrayList<Album> savedAlbumList = topPlayedMap.get(genres[i]);
                savedAlbumList.add(new Album(genres[i], plays[i], i));
                savedAlbumList.sort(new Comparator<Album>() {
                    @Override
                    public int compare(Album o1, Album o2) {
                        return o2.getPlayed() - o1.getPlayed();
                    }
                });
                if(savedAlbumList.size() > 2) savedAlbumList.remove(2);
                topPlayedMap.put(genres[i], savedAlbumList);
            } else {
                totalPlayedMap.put(genres[i], plays[i]);
                ArrayList<Album> newAlbumList = new ArrayList<>();
                newAlbumList.add(new Album(genres[i], plays[i], i));
                topPlayedMap.put(genres[i], newAlbumList);
            }
        }

        PriorityQueue<Album> pQueuePlayed = new PriorityQueue<>(new Comparator<Album>() {
            @Override
            public int compare(Album o1, Album o2) {
                return o2.getPlayed() - o1.getPlayed();
            }
        });

        for(Map.Entry<String, Integer> entry: totalPlayedMap.entrySet()){
            pQueuePlayed.add(new Album(entry.getKey(), entry.getValue()));
        }

        int pqSize = pQueuePlayed.size();
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int i=0; i<pqSize; i++){
            Album curAlbum = pQueuePlayed.poll();
            ArrayList<Album> genereAlbums = topPlayedMap.get(curAlbum.genere);
            for(Album album: genereAlbums){
                resultList.add(album.index);
            }
        }

        int[] finalResult = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++){
            finalResult[i] = resultList.get(i);
        }
        return finalResult;
    }

    class Album{
        private String genere;
        private int played;
        private int index;

        public Album(String genere, int played){
            this.genere = genere;
            this.played = played;
        }

        public Album(String genere, int played, int index){
            this.genere = genere;
            this.played = played;
            this.index = index;
        }

        public String getGenere(){
            return this.genere;
        }

        public int getPlayed(){
            return this.played;
        }

        public int getIndex(){
            return this.index;
        }

        public void setGenere(String genere){
            this.genere = genere;
        }

        public void setPlayed(int played){
            this.played = played;
        }

        public void setIndex(int index){
            this.index = index;
        }
    }
}
