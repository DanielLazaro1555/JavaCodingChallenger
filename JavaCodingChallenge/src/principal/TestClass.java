package principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author daniel
 */
/*
Question 1

Comment section

A new video about the recent developments in coding has been published on the 
HackerEarth social media handle. After some time, it is seen that there are N comments 
added. The admin wants to see if there are any derogatory comments. Hence, he searched 
the comment section with a keyword S.

Task

Give the count of the comments that will be returned as a result of the search.

Notes:
- The count can be 0.
- The algorithm searches the keyword irrespective of the case of the word.
- The separator here is "_".

Example 1

Assumptions

Input:
- N = 3
- S = "hate"
- comments = ["The_video_is_good", "I_hate_this", "Informative"]

Output:
1

Approach:
Only the second comment contains the word "hate".

Function description

Complete the function solution() provided in the editor. The function takes the following 
3 parameters and returns the solution:
- N: Represents the number of comments
- S: Represents the keyword
- comments: Represents the array of comments

Input format

Note: This is the input format that you must use to provide custom input 
(available above the Compile and Test button).
- The first line contains N denoting the number of comments.
- The second line contains S denoting the keyword.
- Each of the next N lines contains a string denoting a comment.

Output format
Print an integer representing the number of comments containing the keyword.

Constraints:
1 ≤ N ≤ 10^5
1 ≤ |S| ≤ 10
1 ≤ Sum of length of all comments ≤ 10^5

S and comments contain only lower and upper case Latin characters and underscore.

Sample input:
2
bad
The_video_is_BAD
bad_bad_bad

Sample output:
2

Explanation:

Given
- N = 2
- S = "bad"
- comments = ["The_video_is_BAD", "bad_bad_bad"]

Output: 2

Approach:
Both comments contain the keyword "bad".

Note:
- Your code must be able to print the sample output from the provided sample input.
  However, your code is run against multiple hidden test cases.
  Therefore, your code must pass these hidden test cases to solve the problem statement.

Limits:
- Time Limit: 1.0 sec(s) for each input file
- Memory Limit: 256 MB
- Source Limit: 1024 KB

Scoring:
- Score is assigned if any testcase passes.

Allowed Languages:
- Bash, C, C++14, C++17, Clojure, C#, D, Erlang, F#, Go, Groovy, Haskell, Java 8, 
  Java 14, Java 17, JavaScript(Node.js), Julia, Kotlin, Lisp (SBCL), Lua, Objective-C, 
  OCaml, Octave, Pascal, Perl, PHP, Python, Python 3, Python 3.8, R(RScript), Racket, 
  Ruby, Rust, Scala, Swift, TypeScript, Visual Basic.
 */
public class TestClass {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        String S = br.readLine();
        String[] comments = new String[N];
        for (int i = 0; i < N; i++) {
            comments[i] = br.readLine();
        }
        int out_ = solution(N, S, comments);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static int solution(int N, String S, String[] comments) {
        int result = 0;
        String keyword = S.toLowerCase();
        for (String comment : comments) {
            String lowerComment = comment.toLowerCase();
            if (lowerComment.contains(keyword)) {
                result++;
            }
        }
        return result;

    }
}
