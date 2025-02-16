package pregunta3;

import java.io.*;
import java.util.*;

/**
 *
 * @author daniel
 */
/*
The best subsequence

You are given the following:
  - An array a of size n
  - An integer k

The special value of a subsequence p is equal to:
    ∑|pᵢ - pᵢ₋₁|  for i = 2 to k
where pᵢ denotes the i-th element of the subsequence p.

Find out the minimum special value among all the subsequences of array a having length k.
If not possible to apply operations, print 0.

Note:
  - A subsequence is a sequence that can be derived from the given sequence 
    by deleting zero or more elements without changing the order of the remaining elements.

Function description:
  Complete the solve function. This function takes the following 3 parameters and returns 
  the minimum special value:
    - N: Represents the size of the array
    - A: Represents the elements of the array
    - K: Represents the given integer value

Input format for custom testing:
  - The first line contains a single integer n.
  - The second line contains n space-separated integers denoting the elements of array a.
  - The third line contains a single integer k.

Output format:
  Print a single integer representing the minimum special value among all subsequences 
  of array a having length k.

Constraints:
  - 1 ≤ n ≤ 10⁵
  - 1 ≤ k ≤ min(n, 50)
  - 1 ≤ aᵢ ≤ 10⁶

Example:
  Sample Input:
    5
    9 5 1 4 9
    2

  Sample Output:
    0

  Explanation:
    - Given:
        N = 5
        A = [9, 5, 1, 4, 9]
        K = 2
    - Approach:
        The special value of subsequence (9, 9) is 0.

Notes:
  - Your code must be able to print the sample output from the provided sample input.
  - However, your code is run against multiple hidden test cases.
  - Therefore, your code must pass these hidden test cases to solve the problem statement.

Limits:
  - Time Limit: 5.0 sec(s) for each input file
  - Memory Limit: 512 MB
  - Source Limit: 1024 KB

Scoring:
  - Score is assigned if any testcase passes.

Allowed Languages:
  - Bash, C, C++14, C++17, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java 8, Java 14, Java 17, 
    JavaScript(Node.js), Julia, Kotlin, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, 
    Python, Python 3, Python 3.8, R(RScript), Racket, Ruby, Rust, Scala, Swift, TypeScript, Visual Basic.

Deberia salir 30
 */

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_a = br.readLine().split(" ");
        int[] a = new int[n];
        
        for (int i_a = 0; i_a < arr_a.length; i_a++) {
            a[i_a] = Integer.parseInt(arr_a[i_a]);
        }
        
        int k = Integer.parseInt(br.readLine().trim());

        long out_ = solve(n, a, k);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static long solve(int n, int[] a, int k) {
        if (k > n) return 0; // No podemos formar una subsecuencia de tamaño k
        
        Arrays.sort(a); // Ordenamos el array para facilitar la búsqueda
        
        long minSpecialValue = Long.MAX_VALUE;
        
        // Iteramos sobre todas las subsecuencias de tamaño k
        for (int i = 0; i <= n - k; i++) {
            long specialValue = 0;
            for (int j = i + 1; j < i + k; j++) {
                specialValue += Math.abs(a[j] - a[j - 1]);
            }
            minSpecialValue = Math.min(minSpecialValue, specialValue);
        }
        
        return minSpecialValue;
    }
}

