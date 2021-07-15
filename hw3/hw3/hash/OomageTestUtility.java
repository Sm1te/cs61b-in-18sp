package hw3.hash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OomageTestUtility {
    public static boolean haveNiceHashCodeSpread(List<Oomage> oomages, int M) {
        /* TODO:
         * Write a utility function that returns true if the given oomages
         * have hashCodes that would distribute them fairly evenly across
         * M buckets. To do this, convert each oomage's hashcode in the
         * same way as in the visualizer, i.e. (& 0x7FFFFFFF) % M.
         * and ensure that no bucket has fewer than N / 50
         * Oomages and no bucket has more than N / 2.5 Oomages.
         */
        Map<Integer,Integer> bucketmap = new HashMap<>();
        for(Oomage o: oomages){
            int hashcode=o.hashCode();
            int bucket = (hashcode & 0x7FFFFFFF) % M;
            if(bucketmap.containsKey(bucket)){
                int key = bucketmap.get(bucket);
                bucketmap.put(bucket,key+1);
            }else{
                bucketmap.put(bucket,1);
            }
        }

        int N = oomages.size();
        for(int bucketkey: bucketmap.keySet()){
            int value = bucketmap.get(bucketkey);
            if (value >= N / 2.5 || value <= N / 50) {
                return false;
            }


        }
        return true;
    }
}
