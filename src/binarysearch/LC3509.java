package binarysearch;
import java.util.TreeSet;

public class LC3509 {
    static class Pair {
        int key;
        long value;
        
        Pair(int key, long value) {
            this.key = key;
            this.value = value;
        }
    }
    private int addSumPair(TreeSet<Pair> pairSumSet, TreeSet<Integer> idxSet, long[] a, int desc){
        // 找到最小的 pair
        Pair minPair = pairSumSet.first();
        int minPairFirstIdx = minPair.key;
        // System.out.print(minPairFirstIdx + "\n");
        // for(Integer idx : idxSet){
        //     System.out.print(a[idx] +" ");
        // }
        // System.out.println();
        // for(int[] pairSum : pairSumSet){
        //     System.out.print(pairSum[0] +":"+pairSum[1]+" ");
        // }
        // System.out.println("desc: "+ desc + "\n ");

        int minPairSecondIdx = idxSet.higher(minPairFirstIdx);
        long minPairNum = minPair.value;
        
        // 处理 desc 的变化，可能为负值
        // 前序的 pair
        Integer preIdx = idxSet.lower(minPairFirstIdx);
        if(preIdx!=null){
            if(a[preIdx] > a[minPairFirstIdx] && a[preIdx] <= minPairNum){
                desc--;
            }else if(a[preIdx] <= a[minPairFirstIdx] && a[preIdx] > minPairNum){
                desc++;
            }
        }
        // 后序的 pair
        Integer postIdx = idxSet.higher(minPairSecondIdx);
        if(postIdx!=null){
            if(a[minPairSecondIdx] <= a[postIdx] && minPairNum > a[postIdx]){
                desc++;
            }else if(a[minPairSecondIdx] > a[postIdx] && minPairNum <= a[postIdx]){
                desc--;
            }
        }
        // pair 自身
        if(a[minPairFirstIdx] > a[minPairSecondIdx]){
            desc--;
        }

        // 更新 idxSet，一个 idx 的删除
        idxSet.remove(minPairSecondIdx);
        
        // 更新 pairSumSet，三个 pair 的更新
        pairSumSet.remove(minPair);
        if(preIdx != null){
            // System.out.println("pre: "+ preIdx + " " + (a[preIdx]+a[minPairFirstIdx]));
            pairSumSet.remove(new Pair(preIdx, a[preIdx]+a[minPairFirstIdx]));
            pairSumSet.add(new Pair(preIdx, a[preIdx]+minPairNum));
        }
        if(postIdx != null){
            // System.out.println("post: "+postIdx +" " + a[postIdx]+a[minPairSecondIdx]);
            pairSumSet.remove(new Pair(minPairSecondIdx, a[minPairSecondIdx]+a[postIdx]));
            // 这里是 minPairFirstIdx
            pairSumSet.add(new Pair(minPairFirstIdx, minPairNum+a[postIdx]));
        }
        
        // 更新 a
        a[minPairFirstIdx] = minPairNum;
         

        return desc;
    }
    public int minimumPairRemoval(int[] nums) {
        // 因为这里又删除的操作，不只是弹出，所以用Set比堆更好？
        TreeSet<Pair> pairSumSet = new TreeSet<>((a, b) -> a.value!=b.value ? Long.compare(a.value, b.value) : a.key-b.key);
        TreeSet<Integer> idxSet = new TreeSet<>((a, b) -> a - b);
        long[] a = new long[nums.length];
        for(int i=0; i<nums.length; i++){
            a[i] = nums[i];
        }
        for(int i=0; i<a.length-1; i++){
            pairSumSet.add(new Pair(i, a[i] + a[i+1]));
            idxSet.add(i);
        }
        idxSet.add(a.length-1);
        
        // 处理 desc 是关键，这是我没想到的
        // 通过 desc 简化 check 是否非递减的过程
        int desc = 0;
        for(int i=0; i<a.length-1; i++){
            if(a[i] > a[i+1]) desc++;
        }

        int result = 0;
        while(desc > 0){
            result++;
            desc = addSumPair(pairSumSet, idxSet, a, desc);
        }

        return result;
    }

    public static void main(String[] args) {
        LC3509 solution = new LC3509();
        System.out.println(solution.minimumPairRemoval(new int[]{633957901,102850764,-468072016,682717064,-619718816,-349792728,128963411,504318948,-573530862,368696146,-380687609,-562859030,-569644720,-504858426,-168098615,-607760763,203726749,541082861,-474164087,-158936197,-693412874,-620985786,-215960192,-286317716,-357794810,296985537,-525484530,-313295350,-369451846,-473344048,-467598875,-235254639,248196822,-342921254,-107165594,-412588063,-332905278,-508440944,-419421931,187934799,-380988507,-31993859,-376428270,148876388,574879690,276267925,-570424947,544015799,637058373,-328986135,474861252,454845598,28453003,324989384,122578331,-180908662,-339639290,515715778,-541305914,-491204507,-216097424,677764155,265998757,-156919804,-302749216,191596460,589415282,-349813358,-177189057,447166007,-342407787,-401742502,686300528,390740495,452482653,677408714,60927472,336914601,253930222,251819217,-302916513,-566058340,-60340819,255661306,-252165176,242514559,-86714961,520379142,50431598,648758384,190699519,570859273,342322688,262364482,-101371265,-489128626,69538224,-481706643,-411193414,-605333878,-390524911,-188364731,-272113438,-333881224,-697311151,668126236,336393198,682227962,-336428778,244459523,165432869,-278101595,491377024,473988041,304876995,614499152,-147488649,-254214562,-577641318,202992112,440490379,-442561707,354939001,-195316021,-190859329,451456006,-503385432,483285274,653837102,-509130595,-397134130,-398746849,-669775855,-401683626,-595534879,-486176539,601403591,-429361579,280191856,-114606554,598592718,-471388873,-336544588,692346335,-611359967,-649128742,-375398346,377963143,-634702127,-204406231,-412067686,212248455,413864181,-321757860,398552526,-312923901,-147909855,-273200607,210703360,605999134,215360207,-221156874,-346123978,517739622,-343195647,259706683,626476451,340437311,-683592093,486887168,-459958488,-210019333,529599232,-302358570,-114638503,190862616,-341129029,-294458616,568310887,198505793}));
    }
}
