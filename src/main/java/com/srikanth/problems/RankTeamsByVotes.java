package com.srikanth.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.*;

public class RankTeamsByVotes {
	public static void main(String[] args) {
		String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
		String[] votes1 = {"ABC","CAB","CBA","ABC","ACB","ACB"};
		String[] votes3 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
	
		      printTeams( rankTeams(votes));
		      printTeams( rankTeams(votes1));
		      printTeams( rankTeams(votes3));
		
		}

		public static String rankTeams(String[] votes){
		   int length = votes[0].length();
		   HashMap<Character, int[]> map = new HashMap<>();
		   for(String str : votes){
		       for(int i = 0; i < length; i++){
		           char c = str.charAt(i);
		           map.putIfAbsent(c, new int[length]);
		           map.get(c)[i]++;
		       }
		   }
		   
		   List<Character> teams = new ArrayList<>(map.keySet());
		    
		   Collections.sort(teams, (a, b) -> {
		            for(int i = 0; i < length; i++){
		                if(map.get(a)[i] != map.get(b)[i]){
		                    return map.get(b)[i] - map.get(a)[i];
		                }
		            }
		            return b - a;
		        });
		       
		   /*Collections.sort(teams, new Comparator<Character>() {
           public int compare(Character rank, Character rank1) {
               for(int i = 0; i < length; i++){
                   if(map.get(rank)[i] != map.get(rank1)[i]){
                       return map.get(rank1)[i] - map.get(rank)[i];
                      
                   }
               }
                   return rank1 - rank;
               }
           }
  );*/ 
		   String sortedTeams =  teams.stream().map(String::valueOf).collect(Collectors.joining());
		
		   return sortedTeams;
		}
		
		public static void printTeams(String teams) {
			System.out.println(teams);
		}
}


