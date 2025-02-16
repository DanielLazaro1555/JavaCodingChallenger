package pregunta2;

import java.io.*;
import java.util.*;

/**
 *
 * @author daniel
 */
/*
Seat reservation

A movie theater has N seats numbered 1 to N.

Build a seat reservation system that performs one of the following operations K times:
  - Fetches the smallest-numbered unreserved seat then reserves it and returns its number.
  - Cancels a seat reservation for seat[i].

The result should be an array containing the reserved seat numbers.

Notes:
  - If seat[i] = 0, reserve the seat.
  - If seat[i] > 0, cancel the reservation of a seat.
  - Every time we reserve a seat, it is guaranteed that there is an unreserved seat.
  - Every time we cancel the reservation of a seat, it is guaranteed that the seat is reserved.

Function description:
Complete the function solution() provided in the editor. The function takes the following 3 parameters and returns the solution:
  - N: Represents the number of seats.
  - K: Represents the number of operations.
  - seat: Represents the details of operations.

Input format for custom testing:
Note: Use this input format if you are testing against custom input or writing code in a language where we don’t provide boilerplate code.
  - The first line contains N denoting the number of seats.
  - The second line contains K denoting the number of operations.
  - The third line contains seat denoting the details of operations.

Output format:
Print an array, representing the reserved seat numbers.

Constraints:
  - 1 ≤ N ≤ 10^5
  - 1 ≤ K ≤ 10^5
  - 0 ≤ seat[i] ≤ N

Sample input:
3
3
0 0 0

Sample output:
1 2 3

Explanation:
  - Given:
    N = 3
    K = 3
    seat = [0, 0, 0]
  
  - Output: 1 2 3

  - Approach:
    - The smallest unreserved seat is 1.
    - The smallest unreserved seat is 2.
    - The smallest unreserved seat is 3.

Note:
Your code must be able to print the sample output from the provided sample input. However, your code is run against multiple hidden test cases. Therefore, your code must pass these hidden test cases to solve the problem statement.

Limits:
  - Time Limit: 1.0 sec(s) for each input file.
  - Memory Limit: 256 MB.
  - Source Limit: 1024 KB.

Scoring:
  - Score is assigned if any testcase passes.

Allowed Languages:
  - Bash, C, C++14, C++17, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java 8, Java 14, Java 17, JavaScript(Node.js), Julia, Kotlin, Lisp (SBCL), Lua, Objective-C, OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, Python 3.8, Racket, Ruby, Rust, Scala, Swift, TypeScript, Visual Basic.
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        String[] arr_seat = br.readLine().split(" ");
        int[] seat = new int[K];

        for (int i = 0; i < arr_seat.length; i++) {
            seat[i] = Integer.parseInt(arr_seat[i]);
        }

        int[] out_ = solution(N, K, seat);

        // Imprimir resultado en formato requerido
        System.out.print(out_[0]);
        for (int i = 1; i < out_.length; i++) {
            System.out.print(" " + out_[i]);
        }

        wr.close();
        br.close();
    }

    static int[] solution(int N, int K, int[] seat) {
        TreeSet<Integer> availableSeats = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            availableSeats.add(i); // Inicializamos asientos disponibles
        }

        List<Integer> result = new ArrayList<>();

        for (int operation : seat) {
            if (operation == 0) {
                // Reservar el asiento más pequeño disponible
                int reservedSeat = availableSeats.pollFirst();
                result.add(reservedSeat);
            } else {
                // Cancelar la reserva del asiento
                availableSeats.add(operation);
            }
        }

        // Convertimos la lista en array y la retornamos
        return result.stream().mapToInt(i -> i).toArray();
    }
}
