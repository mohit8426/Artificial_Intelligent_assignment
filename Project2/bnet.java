/*

Assignment 2: Bayesian Networks
 Name: Mohit Kulkarni
 UTA ID: 1002031021

 */


import java.io.IOException;
import java.io.BufferedWriter;
import java.util.ArrayList;

public class bnet {
	static ArrayList<String> arrayString1 = new ArrayList<String>();
	static ArrayList<String> arrayString2 = new ArrayList<String>();

	// These are the values which are given to us from the Figure 1 stating for burglaryas P(B),earthquake as P(E),alarm P(A|B,E) , Johncalls as P(M|A) and Marycalls as P(M|A) 
	static double burglary=0.001;
	static double earthquake=0.002;
	
	static double alarm[]= {0.95,0.94,0.29,0.001};
	static double JohnCalls[]= {0.90,0.05};
	static double MaryCalls[]= {0.70,0.01};

	public static void main(String[] args) {				
		int bur_Counter=0, ear_Counter=0, alm_Counter=0, jcalls_Counter=0, mcalls_counter=0;
		if (args.length <1 || args.length > 6) { // checking the arguments length for the output
			System.exit(0);
		}

		int index =-1;
		for(int i=0;i<args.length;i++) {
			if(args[i].equals("given")){    // putting arguments fror array string 1 and array string 2
				index=0;
				continue;
			}
			if(index==-1) {
				arrayString1.add(args[i]);
			} else{
				arrayString2.add(args[i]);
			}
		}	
		if (arrayString1.size() <1 || arrayString1.size() > 6) { // checking the arguments for array string 1 and array string 2
			System.exit(0);
		}
		if(index==0) {
			if (arrayString2.size() <1 || arrayString2.size() > 4) {
				System.exit(0);
			}		
		}

		System.out.println(arrayString1 + "given" + arrayString2);
		arrayString1.addAll(arrayString2); //arrayString1 elements appending to arrayString2 elements

		//the numerators and the denoinators in the array string and array string 2 are added if they are missing.
		for(int i=0;i< arrayString1.size();i++) {
            if (!arrayString1.contains("Mt")&&!arrayString1.contains("Mf")) {   // if array string1 contains Mf then marrycalls false or Mt then Marrycalls is true
				arrayString1.add("Mt");
				arrayString1.add("Mf");
				mcalls_counter=1;
			}
            if (!(arrayString1.contains("Jt"))&&!arrayString1.contains("Jf")) {  // if array string1 contains Jf then Johncalls false or Jt then Johncalls is true
				arrayString1.add("Jt");
				arrayString1.add("Jf");
				jcalls_Counter=1;
			}  			
			if (!arrayString1.contains("Bt")&&!arrayString1.contains("Bf")) {   // if array string1 contains Mf then burglary false or Mt then burglary is true
				arrayString1.add("Bt");
				arrayString1.add("Bf");
				bur_Counter=1;
			}
			if (!arrayString1.contains("Et")&&!arrayString1.contains("Ef")) {   // if array string1 contains Mf then earthquake false or Mt then earthquake is true
				arrayString1.add("Et");
				arrayString1.add("Ef");
				ear_Counter=1;
			}			
			
		}

		double numerator_Val = compute(bur_Counter, ear_Counter, alm_Counter, jcalls_Counter, mcalls_counter, arrayString1);     // using compute function to calculate numeratro value for array string 2

		if(arrayString2.size()==0) {
			System.out.println("Probability: "+ numerator_Val);         // printing the final probability
		}

		bur_Counter = ear_Counter = alm_Counter = jcalls_Counter = mcalls_counter=0;

		for(int j=0;j< arrayString2.size();j++) {	
            
            if (!arrayString2.contains("Mt") && !arrayString2.contains("Mf")) {     // if array string2 contains Mf then marrycalls false or Mt then Marrycalls is true
				arrayString2.add("Mt");
				arrayString2.add("Mf");
				mcalls_counter=1;
			}

            if (!arrayString2.contains("Jt") && !arrayString2.contains("Jf")) {     // if array string2 contains Jf then Johncalls false or Jt then Johncalls is true
				arrayString2.add("Jt");
				arrayString2.add("Jf");
				jcalls_Counter=1;
			}

            if (!arrayString2.contains("At") && !arrayString2.contains("Af")) {     // if array string2 contains Af then alarm false or At then alarm is true
				arrayString2.add("At");
				arrayString2.add("Af");
				alm_Counter=1;
			}
		
			if (!arrayString2.contains("Bt") && !arrayString2.contains("Bf")) {     // if array string2 contains Mf then burglary false or Mt then burglary is true
				arrayString2.add("Bt");
				arrayString2.add("Bf");
				bur_Counter=1;
			}
			if (!arrayString2.contains("Et") && !arrayString2.contains("Ef")) {     // if array string2 contains Mf then earthquake false or Mt then earthquake is true
				arrayString2.add("Et");
				arrayString2.add("Ef");
				ear_Counter=1;
			}
			
		
			
		}

		double denominator_Val = compute(bur_Counter, ear_Counter, alm_Counter, jcalls_Counter, mcalls_counter, arrayString2); // compute function used to calculate denominator value

		if(arrayString2.size()>0) {
			System.out.println("Probability: " + numerator_Val / denominator_Val);            // this prints the final output as the probability which is send through the argument
		}		
	}
	
	public static double computeProbability(boolean b, boolean e, boolean a, boolean j, boolean m) {        // computeProbability function as asked in the assignment to compute the probabilities for b as sburglary, e as earthquake, m as Marrycalls , j as johny calls and a as alarm
		double burglary_val = 0.0;
		if(b) {
			burglary_val = burglary;    // calculating for burglary probability
		} else {
			burglary_val = 1 - burglary;
		}

		double earthquake_val;
		if(e) {
			earthquake_val=  earthquake; // calculating for earthquake probability
		}
		else {
			earthquake_val = 1-earthquake;
		}

		double alarm_val = 0.0;

		if(a) {
			if(b==true && e==true)
				alarm_val = alarm[0];
			else if(b==true && e==false) // calculating the probability for ralarm 
				alarm_val = alarm[1];
			else if(b==false && e==true)
				alarm_val = alarm[2];
			else if(b==false && e==false)
				alarm_val = alarm[3];
		} else {
			if(b==true && e==true )
				alarm_val = 1-alarm[0];
			else if(b==true && e==false )
				alarm_val = 1-alarm[1];
			else if(b==false && e==true )
				alarm_val = 1-alarm[2];
			else if(b==false && e==false )
				alarm_val = 1-alarm[3];
		}

		double JohnCalls_val = 0.0;
		if(j) {
			if(a == true)
				JohnCalls_val = JohnCalls[0];
			else if(a==false )                  // calculating probability for johncalls 
				JohnCalls_val = JohnCalls[1];
		} else {
			if(a == true)
				JohnCalls_val =1-JohnCalls[0];
			else if(a==false )
				JohnCalls_val =1-JohnCalls[1];
		}

		double MaryCalls_val = 0.0;
		if(m) {
			if(a == true)
				MaryCalls_val = MaryCalls[0];
			else if(a==false )
				MaryCalls_val = MaryCalls[1];       // calculating probability for marycalls
		} else {
			if(a == true)
				MaryCalls_val =1-MaryCalls[0];
			else if(a==false)
				MaryCalls_val =1-MaryCalls[1];
		}

		return (burglary_val) * (earthquake_val) * (alarm_val) * (JohnCalls_val) * (MaryCalls_val);      // returning the final formula to calculate 
	}

	public static double compute(int bc, int ec, int ac, int jc, int mc, ArrayList<String> arrayString) {				
		Boolean burglary_bool=false, earthquake_bool=false, alarm_bool=false, JohnCalls_bool=false, MaryCalls_bool=false; // intializing all the boolean values to false 

		if(bc==0) {
			if(arrayString.contains("Bt")) {
				burglary_bool=true;
			}                                               // if the boolean value contains Bt then burglary is true otherwise Bf is false
			else burglary_bool=false;
		}
		if(ec==0) {
			if(arrayString.contains("Et")) {
				earthquake_bool=true;
			}                                               // if the boolean value contains Et then earthquake is true otherwise Ef is false 
			else earthquake_bool=false;
		}
		if(ac==0) {
			if(arrayString.contains("At")) {
				alarm_bool=true;
			}                                               // if the boolean value contains At then alarm is true otherwise Af is false
			else alarm_bool=false;
		}
		if(jc==0) {
			if(arrayString.contains("Jt")) {
				JohnCalls_bool=true;                        // if the boolean value contains Jt then it is true otherwise Jf is false
			}
			else JohnCalls_bool=false;
		}
		if(mc==0) {
			if(arrayString.contains("Mt")) {            // if the boolean value contains Mt then it is true otherwise Mf is false
				MaryCalls_bool=true;
			}
			else MaryCalls_bool=false;
		}

		double probValue = 0.0;

		for(int iter1=0; iter1<=bc; iter1++) {      // iterations for calculating probabilities of the boolean numbers 

			for(int iter2=0; iter2<=ec; iter2++) {

				for(int iter3=0; iter3<=ac; iter3++) {

					for(int iter4=0; iter4<=jc; iter4++) {

						for(int iter5=0; iter5<=mc; iter5++) {
							probValue += computeProbability(burglary_bool, earthquake_bool, alarm_bool, JohnCalls_bool, MaryCalls_bool); // calling the funtion computeProbability function for calculating probability for the boolean values

							if(mc==1 && MaryCalls_bool==false) {
								MaryCalls_bool=true;
							} else if(mc==1 && MaryCalls_bool==true) {
								MaryCalls_bool=false;
							}
						}

						if(jc==1 && JohnCalls_bool==false) {
							JohnCalls_bool=true;
						} else if(jc==1 && JohnCalls_bool==true) {
							JohnCalls_bool=false;
						}
					} 

					if(ac==1 && alarm_bool==false){
						alarm_bool=true;	
					} else if(ac==1 && alarm_bool==true) {
						alarm_bool=false;
					}
				} 
				if(ec==1 && earthquake_bool==false){ 
					earthquake_bool=true;
				} else if(ec==1 && earthquake_bool==true){ 
					earthquake_bool=false;
				}
			}
			if(bc==1 && burglary_bool==false){
				 burglary_bool=true;
			} else if(bc==1 && burglary_bool==true) {
				burglary_bool=false;
			}
		}

		return probValue;
	}
}