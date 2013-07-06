import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;;

public class Juggle{
	//define an inner class jugglers
	private static class jugglers{
		public boolean added;
		public int id;
		public int hand;
		public int endurance ;
		public int pizzazz;
		public int curscore;
		String pref;
		public ArrayList<Integer> preference=new ArrayList<Integer> ();
		public ArrayList<Integer> dotpro=new ArrayList<Integer> ();
		public jugglers(int id, int h,int e,int p, String pre){
			this.added=false;
			this.id=id;
			this.hand=h;
			this.endurance=e;
			this.pizzazz=p;
			this.pref=pre;
		}

		//add jugglers preference 
		public void addPreference(String pref){
			//split by comma
			String[] rank = pref.split(",");
			for(String number:rank)
				preference.add(Integer.parseInt(number.substring(1)));				
		}
	}
	//define an inner class circuit
	private static class circuit{
		ArrayList<jugglers> jArray;//an array to store jugglers that are assigned to this circuit
		public int id;
		public int hand;
		public int endurance ;
		public int pizzazz;
		public circuit(int id, int h,int e,int p){
			this.id=id;
			this.hand=h;
			this.endurance=e;
			this.pizzazz=p;
			this.jArray=new ArrayList<jugglers>();
		}		
		private void sortJugglers(){
			Collections.sort(jArray, new Comparator<jugglers>(){
				public int compare(jugglers j1, jugglers j2) {
					if(j1.curscore==j2.curscore)
						return 0;
					else if (j1.curscore<j2.curscore)
						return 1;
					else
						return -1;
				}
			});
		}
	}
	//a function to calculate dot product
	static int dotProduct(jugglers juggler,circuit circ){
		return juggler.hand*circ.hand+juggler.endurance*circ.endurance+juggler.pizzazz*circ.pizzazz;
	}
	static boolean arrayEmpty(ArrayList<jugglers> jugglersArray){
		for(jugglers j:jugglersArray)
			if (!j.added)
				return false;
		return true;
	}
	// find the highest preference of current juggler
	static int findJpre(boolean[] circuitIndex,jugglers juggler){
		for(int value:juggler.preference){
			if(!circuitIndex[value])
				return value;
		}
		return 0;
	}
	//find the circuit that is the most popular among jugglers
	static int findHighestPre(boolean[] circuitIndex,int length, ArrayList<jugglers> jugglersArray){
		int total=0;
		int current_index=-1;
		int current_max=-1;
		for(int i=0;i<length;i++){
			int count=0;
			for(jugglers ite:jugglersArray){
				if(findJpre(circuitIndex,ite)==i)
					count++;
			}
			total+=count;
			if(count>current_max){
				current_max=count;
				current_index=i;
			}
		}
		return current_index;	
	}
    public static void main (String[] args){
    int circuit_count=0;
    int juggler_count=0;
    int id;
    int average;
    int hand;
    int endurance;
    int pizzazz;
    String preference;
    //create new ArrayLists for circuit and jugglers
    ArrayList<circuit> circuitArray= new ArrayList<circuit>();
    ArrayList<jugglers> jugglersArray= new ArrayList<jugglers>();
    try{
        File file = new File(args[0]);
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while ((line = in.readLine()) != null) {
            String[] lineArray = line.split(" ");
            if (lineArray.length > 0) {
            	//add new circuits to the circuitArray
            	if (lineArray[0].equals("C")){
            		circuit_count++;
            		id = Integer.parseInt(lineArray[1].substring(1));
            		hand = Integer.parseInt(lineArray[2].substring(2));
            		endurance = Integer.parseInt(lineArray[3].substring(2));
            		pizzazz = Integer.parseInt(lineArray[4].substring(2));
            		circuitArray.add(new circuit(id, hand, endurance, pizzazz));
            	}
            	//add new jugglers to the jugglerArray
            	else if (lineArray[0].equals("J")){
            		juggler_count++;
            		id = Integer.parseInt(lineArray[1].substring(1));
            		hand = Integer.parseInt(lineArray[2].substring(2));
            		endurance = Integer.parseInt(lineArray[3].substring(2));
            		pizzazz = Integer.parseInt(lineArray[4].substring(2));
            		preference = lineArray[5];
            		jugglersArray.add(new jugglers(id, hand, endurance, pizzazz, preference));
            	}
            }
        }
        //add preferences of each juggler
        for(jugglers itej:jugglersArray)
    		itej.addPreference(itej.pref);
        //calculate how many jugglers should be in a circuit      
        average=juggler_count/circuit_count;
        
        //find preference by ranking and add to each circuit
        //iterate until all jugglers are assigned
        while(!arrayEmpty(jugglersArray)){
        	for(jugglers j:jugglersArray){
    			for(int p:j.preference){
    				if(!j.added){
    					j.curscore=dotProduct(j,circuitArray.get(p));    				
        				if(circuitArray.get(p).jArray.size()<average){
        					circuitArray.get(p).jArray.add(j);        					
        					circuitArray.get(p).sortJugglers();
        					j.added=true;
        				}
        				else if(dotProduct(circuitArray.get(p).jArray.get(average-1), circuitArray.get(p))<j.curscore){
        					jugglersArray.get(circuitArray.get(p).jArray.get(average-1).id).added=false;
        					circuitArray.get(p).jArray.remove(circuitArray.get(p).jArray.get(average-1));        					
        					circuitArray.get(p).jArray.add(j);
        					j.added=true;
        					circuitArray.get(p).sortJugglers();
        				}
    				}
    			}
    			if(!j.added){
    				for(circuit c:circuitArray){
    					j.curscore=dotProduct(j,c); 
        				if(c.jArray.size()<average){
        					c.jArray.add(j);
        					c.sortJugglers();
        					j.added=true;
        					break;
        				}
        				else if(dotProduct(c.jArray.get(average-1), c)<j.curscore){
        					jugglersArray.get(c.jArray.get(average-1).id).added=false;
        					c.jArray.remove(c.jArray.get(average-1));
        					j.added=true;
        					c.jArray.add(j);
        					c.sortJugglers();
        					break;
        				}
    				}
    			}
        	}
        } 
            //output the sum of the names of the jugglers that are assigned to circuit C1970            
            if(circuitArray.size()>1970){
                circuit c1970=circuitArray.get(1970);
                int sum=0;
                for(jugglers j:c1970.jArray)
                	sum+=j.id;
                System.out.println(+sum);            	
            }
    }
	catch (IOException e){
		e.printStackTrace();
	}
   }
}