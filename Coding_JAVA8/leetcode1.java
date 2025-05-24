Q. ou are given a 0-indexed array of strings words and a character x.

Return an array of indices representing the words that contain the character x.

Note that the returned array may be in any order.

 

Example 1:

Input: words = ["leet","code"], x = "e"
Output: [0,1]
Explanation: "e" occurs in both words: "leet", and "code". Hence, we return indices 0 and 1.
Example 2:

Input: words = ["abc","bcd","aaaa","cbc"], x = "a"
Output: [0,2]
Explanation: "a" occurs in "abc", and "aaaa". Hence, we return indices 0 and 2.
Example 3:

Input: words = ["abc","bcd","aaaa","cbc"], x = "z"
Output: []
Explanation: "z" does not occur in any of the words. Hence, we return an empty array.


Solution:
import java.util.*;
import java.io.*;
import java.util.stream.Stream;
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
    
    // List<String> li = Arrays.stream(words)
    // .filter(y-> y.contains(String.valueOf(x))).collect(Collectors.toList());

     List<Integer> li = IntStream.range(0,words.length)
     .filter(i-> words[i].contains(String.valueOf(x))).boxed().collect(Collectors.toList());

// In Java, .boxed() is used to convert a primitive stream (like IntStream, LongStream, DoubleStream) 
// into a stream of wrapper objects (Stream<Integer>, Stream<Long>, etc.).
// List<Integer> indices = IntStream.range(0, 5)
//     .boxed()
//     .collect(Collectors.toList());
// Without .boxed(), this won't compile because collect(Collectors.toList()) expects a stream of objects,
//  not primitives.



    return li;

    }
}
