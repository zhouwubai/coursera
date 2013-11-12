package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class GenerateParenthesis {

	
	public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        
        ArrayList<String> rtn = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        Set<String> seeds = new HashSet<String>();
        Set<String> newSeeds = new HashSet<String>();
        Set<String> swap = seeds;
        seeds.add("");
        for(int level = 1; level <= n; level++) {
            for(String seed : seeds) {
                for(int pos = 0; pos <= seed.length(); pos ++) {
                    sb.append(seed);
                    sb.insert(pos,"()");
                    newSeeds.add(sb.toString());
                    sb.setLength(0);
                }
            }
            
            swap = seeds;
            seeds = newSeeds;
            newSeeds = swap;
            newSeeds.clear();
        }
        
        for(String seed : seeds) {
            rtn.add(seed);
        }
        
        return rtn;
    }
	
}
