package search;


public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // 目标是找到第 k 大的值
        // 不断比较 k/2 的值
        int n = nums1.length;
        int m = nums2.length;
        double midNum;
        if((n + m) % 2 == 0){
            int mid1 = findTarget(nums1, nums2, (n+m)/2);
            int mid2 = findTarget(nums1, nums2, (n+m)/2);
            midNum = (mid1 + mid2) * 1.0 / 2;
        }else{
            midNum = findTarget(nums1, nums2, (n+m)/2);
        }
        return midNum;
    }

    // 寻找第 k 大的值，即刚好满足 >= k-1 个 nums[i] 的值
    int findTarget(int[] nums1, int[] nums2, int k){
        int n = nums1.length;
        int m = nums2.length;
        int pre1 = 0, pre2 = 0;
        int res = -1;
        while (k != 0 && pre1 < n && pre2 < m){
            int i = Math.max(pre1 + k/2 - 1, n);
            int j = Math.max(pre2 + k/2 - 1, m);
            if(nums1[i] > nums2[j]){ // 前 j 个数不可能是要找的值，排除
                k -= j - pre2;
                pre2 = j;
                res = nums1[i];
            }else{
                k -= i - pre1;
                pre1 = i;
                res = nums2[j];
            }
        }

        if(k != 0){
            if(pre1 < n){
                res = nums1[pre1 + k];
            }else{
                res = nums2[pre2 + k];
            }

        }
        return res;
    }

}
