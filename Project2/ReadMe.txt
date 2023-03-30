Name : Mohit Shailesh Kulkarni

UTA ID: 1002031021

Programming language used Java

Code structure: 
1.	At first giving the values for all the Constraints as per the Figure 1
2. 	Checking the earguments for array string 1 and array string 2 wwhether it is Bf or Bt and Et or Ef and so on.
3. 	Checking if the numerator and denominator values are missing if they are then appended to the corresponding array strings.
4.	The computeProbability function is called to calculate probabilty of boolean b, boolean e, boolean a, boolean j, boolean m)
	for b as burglary, e as earthquake, m as Marrycalls , j as johny calls and a as alarm
5. 	The normal compute function calls the computeProbability function for getting different combinations of values for numerators and denominators.

How to run the program: 
javac bnet.java
java bnet Bt Ef Af Mf Jt

output: Probability: 2.9640600000000024E-6




Also tried with given set as:  
java bnet Bt Ef At Jt Mt
output: Probability: 5.910156E-4

PS C:\Users\mohit\OneDrive\Desktop\AI\assig\ass2> java bnet Jt given Et Bt
[Jt]given[Et, Bt]
Probability: 0.0025000000000000027 

PS C:\Users\mohit\OneDrive\Desktop\AI\assig\ass2> java bnet Bt given At Et
[Bt]given[At, Et]
Probability: 0.003268423587696965