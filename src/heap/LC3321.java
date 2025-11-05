package heap;
import java.util.TreeSet;
import java.util.HashMap;
import java.util.Map;

public class LC3321  {
    class Pair implements Comparable<Pair>{
        int key, value;
        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        Pair(Map.Entry<Integer, Integer> entry){
            this.key = entry.getKey();
            this.value = entry.getValue();
        }
        long getMul(){
            return (long)key*value; 
        }

        // 定义比较
        @Override
        public int compareTo(Pair other){
            // value 降序，相同时 key 降序
            if(this.value != other.value){
                return other.value - this.value;
            }
            return other.key - this.key;
        }
    }
    private TreeSet<Pair> large = new TreeSet<>();
    private TreeSet<Pair> small = new TreeSet<>();
    private HashMap<Integer, Integer> map = new HashMap<>();
    
    public long[] findXSum(int[] nums, int k, int x) {
        
        for(int i=0; i<k; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Pair pair = new Pair(entry);
            small.add(pair);
        }
        long sum = 0;
        for(int i=0; i<x && !small.isEmpty(); i++){
            Pair firstPair = small.first();
            small.remove(firstPair);
            large.add(firstPair);
            sum += firstPair.getMul();
        }

        long[] results = new long[nums.length-k+1];
        results[0] = sum;
        for(int i=k; i<nums.length; i++){
            
            // 添加新的元素，删除过时的元素
            // 新元素 i 的旧 Pair
            Pair oldPair = new Pair(nums[i], map.getOrDefault(nums[i], -1));
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            
            // 新元素 i 的新 Pair
            Pair newPair = new Pair(nums[i], map.get(nums[i]));

            if(large.contains(oldPair)){ // 原来在 large
                large.remove(oldPair);
                large.add(newPair);
                sum += nums[i];
            }else{ // 原来在 small，或是不存在两者
                Pair lastPair = large.last();
                if(oldPair.value!=-1) {
                    small.remove(oldPair);
                }

                // 比较是否能上 large，或是 large 长度不够
                if(large.size() < x){
                    large.add(newPair);
                    sum += newPair.getMul();
                }else if(newPair.compareTo(lastPair) < 0){
                    large.remove(lastPair);
                    large.add(newPair);
                    small.add(lastPair);
                    sum = sum - lastPair.getMul() + newPair.getMul();
                }else{
                    small.add(newPair);
                }
            }

            // 待删除元素 i-k
            oldPair = new Pair(nums[i-k], map.get(nums[i-k]));
            map.put(nums[i-k], map.get(nums[i-k])-1);
            newPair = new Pair(nums[i-k], map.get(nums[i-k]));
            if(large.contains(oldPair)){ // 原来在 large
                // 删除原来的 pair
                large.remove(oldPair);
                sum -= oldPair.getMul();

                // 直接加入 small 后一起比较，选择比较大的加入 large
                if(newPair.value > 0){
                    small.add(newPair);
                }
                if(!small.isEmpty()){
                    Pair firstPair = small.first();
                    small.remove(firstPair); 
                    large.add(firstPair);
                    sum += firstPair.getMul();
                }
                
            }else{ // 原来在 small 
                small.remove(oldPair);
                if(newPair.value > 0){
                    small.add(newPair);
                }
            }
            results[i-k+1] = sum;
        }

        return results;

    }
    public static void main(String[] args) {
        LC3321 solution = new LC3321();
        long[] result = solution.findXSum(new int[]{2,2,3,3,4,2}, 3, 3);
        for(long x : result){
            System.out.print(x + " ");
        }

    }
}
