Java
Submission.java

We compile and run with java:

javac Submition.java
java Submition

The input file must be in the directory and the output file (output.txt) will be created. The program uses BigInteger internally so that it can handle arbitrary sized problems.

* What is the worst case computation time of this algorithm? What is the best case time complexity of the algorithm?

Since we have no conditions that allow the algoirthm to finish early depending on the data, both the worst case and the beset case complexity is  2 ^ nj

* Approximately how much time will the program need for n=40? n=50?

The output.txt for our machine is:

20 552 0
21 547 1
22 361 2
23 380 4
24 609 10
25 422 19
26 539 41
27 508 85
28 612 172
29 499 354

Assuming that the execution of one cycle takes a seconds and that the complexity is as described above, then we have a * repeats = time. So if we have two different number of repeats, r1 and r2 with times t1 and t2 respectively it will be t1/r1 = a and t2/r2 = a, which means that t1/r1 = t2/r2. This means that t2 = t1 * (r2/r1). As a result, from the table above we have:

nj | repeats  |   time
-------------------------
29 | 2^29     |    354
40 | 2^40     |   t40?
50 | 2^50     |   t50?

which means that

t40 = 354 * (2^40 / 2^29) = 354 * 2^11 = 2048 * 354 = 724992 = 8.4 days and 

t50 = 354 * (2^50 / 2^29) = 354 * 2^21 = 2097152 * 354 = 742391808 = 24 years
