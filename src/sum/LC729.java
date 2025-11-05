package sum;

import java.util.HashSet;
import java.util.Set;

public class LC729 {
    class MyCalendar {
        // 线段树

        // 动态线段树，并不直接分配数组空间(4*n)
        private Set<Integer> tree;
        private Set<Integer> lazy;
        public MyCalendar() {
            // 区间有预定
            tree = new HashSet<>();
            // 区间完全被预订
            lazy = new HashSet<>();
        }

        public boolean book(int startTime, int endTime) {
            int MAX = 10_0000_0000;
            // 根节点是1，而不是0
            if(query(startTime, endTime-1, 0, MAX, 1)){
                return false;
            }
            update(startTime, endTime-1, 0, MAX, 1);
            
            // System.out.println("tree");
            // for(int x : tree){
            //     System.out.print(x + " ");
            // }
            // System.out.println();
            // System.out.println("lazy");
            // for(int x : lazy){
            //     System.out.print(x + " ");
            // }
            // System.out.println();
            return true;
            
        }

        // start, end：要查询的区间
        // l, r：当前节点管理的区间范围
        // idx：当前节点的索引
        private boolean query(int start, int end ,int l, int r, int idx){
            if(start > r || end < l){
                // 无交集，没有重叠
                return false;
            }

            // 如果区间已都被预订，直接返回
            if(lazy.contains(idx)){
                return true;
            }

            // 若当前节点管理的区间范围被完全包含
            if(start <= l && r<=end){
                return tree.contains(idx);
            }else{
                // 拆分
                int mid = (l+r)/2;
                if(end <= mid){ // 查询的区间在左子树
                    return query(start, end, l, mid, 2*idx);
                }else if(start > mid){ // 查询的区间在右子树
                    return query(start, end, mid+1, r, 2*idx+1);
                }else{ // 查询的区间在两个子树上
                    return query(start, end, l, mid, 2*idx) | query(start, end, mid+1, r, 2*idx+1);
                }

            }
        }

        public void update(int start, int end, int l, int r, int idx){
            // 不重叠，不需要更新
            if(r < start || end < l){
                return;
            }

            // [l,r] 被 [start, end] 包含
            if(start <= l && r<=end){
                tree.add(idx);
                lazy.add(idx);
            } else{ // 交叉，或者包含 [start, end]
                int mid = (l+r)/2;
                update(start, end, l, mid, idx*2);
                update(start, end, mid+1, r, idx*2+1);
                // 有出现预定就要标记
                tree.add(idx);
            }
        }
    }

    
    public static void main(String[] args) {
        LC729 solution = new LC729();
        MyCalendar obj = solution.new MyCalendar();
        // 调用列表中的预约
        System.out.println(obj.book(10, 20)); // true
        System.out.println(obj.book(15, 25));  // false
        System.out.println(obj.book(20, 30)); // true (与[97,100]冲突)
        // System.out.println(obj.book(83, 100)); // false (与[97,100]冲突)
    }
}

