package test;

import java.util.*;

public class Test 
{
	
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		List<Integer> result = new ArrayList<>();
        List<Integer> goats = new ArrayList<>();
        int count = scan.nextInt();
        int N = scan.nextInt(); 
		 for(int i = 0; i < count; i++) 
		 { 
			 goats.add(scan.nextInt()); 
		 }
		 goats.add(0);
		 //System.out.println(goats);
        //Collections.addAll(goats, 0,  26,  10, 30, 7, 5, 4); // Теглата на козичките
        boolean flag = true; 
        int totalWeight = goats.stream().mapToInt(Integer::intValue).sum();
        int P = totalWeight / N; 
        if(P < goats.get(goats.size()-1))
        {
        	P = goats.get(goats.size()-1);
        }

        Collections.sort(goats, Collections.reverseOrder());
        
        for(int j = P; ; P++)
        {
        	List<List<Integer>> groups = new ArrayList<>();
            for (int i = 0; i < N; i++) 
            {
                groups.add(new ArrayList<>());
            }

            int[] sums = new int[N];
            
	        for (int weight : goats) 
	        {
	            int bestGroup = -1;
	            int minDifference = Integer.MAX_VALUE;
	
	            for (int i = 0; i < N; i++) 
	            {
	                int newSum = sums[i] + weight;
	                int difference = Math.abs(P - newSum);
	                
	                if (newSum <= P && difference <= minDifference) 
	                {
	                    minDifference = difference;
	                    bestGroup = i;
	                }
	            }
	
	            if (bestGroup != -1) 
	            {
	                groups.get(bestGroup).add(weight);
	                sums[bestGroup] += weight;
	            } 
	            else 
	            {
	            
	               //System.out.println("Не може да се добави " + weight + " в нито една група без да надвиши P.");
	                flag = false;
	                break;
	            }
	        }
        
        if(flag)
        {
	        for (int i = 0; i < N; i++) 
	        {
	        	result.add(sums[i]);
	           //System.out.println("Курс " + (i + 1) + ": " + groups.get(i) + " (Сума: " + sums[i] + ")");
	        }
	        break;
        }
        else
        {
        	flag = true;
        }
    }
        Collections.sort(result, Collections.reverseOrder());
        System.out.println(result.get(0));
        scan.close();
  }
}

	
	

