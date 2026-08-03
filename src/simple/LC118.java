package simple;

import java.util.*;

public class LC118 {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> initRow = new ArrayList<>();
        initRow.add(1);
        res.add(initRow);
        ArrayList<Integer> preRow = initRow;
        for(int i=1; i<numRows; i++){
            ArrayList<Integer> curRow = new ArrayList<>();
            for(int j=0; j<preRow.size(); j++){
                if(j == 0){
                    curRow.add(preRow.get(j));
                }else{
                    curRow.add(preRow.get(j-1) + preRow.get(j));
                }
            }
            curRow.add(preRow.get(preRow.size()-1));
            res.add(curRow);
            preRow = curRow;
        }
        return res;
    }
}
