/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import  java.util.stream.Collectors.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main
{
	public static void lenOfLongestSTring(String[] s)
	{
		/*  List<String> s1= Arrays.stream(s).map(x-> x.toUpperCase())
		  .collect(Collectors.toList());
		  [APPLE,BANANA]*/

		/* Returning a map String with its string uppercase*/
		//     Map<String,String> s1=  Arrays.stream(s).collect(Collectors.toMap(x-> x , x-> x.toUpperCase()));

		//freq of each String
		Map<String,Integer> frq=  Arrays.stream(s).collect(Collectors.toMap(x-> x, x-> x.length()));

		//lengthofmaxstring
		int s1= Arrays.stream(s).mapToInt(x-> x.length()).max().orElse(-1);
		System.out.println(frq);
		System.out.println(s1);
	}
	public static void reverse(int[] arr)
	{
		IntStream.range(0,arr.length/2).forEach( i-> {
			int temp=arr[i];
			arr[i]=arr[arr.length-i-1];
			arr[arr.length-i-1] = temp;
		});

		System.out.println("Reverse "+Arrays.toString(arr));
	}
	public static void commonElement(int[]arr1, int[] arr2)
	{
		Set<Integer> s1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		Set<Integer> s2= Arrays.stream(arr2).boxed().filter( x -> s1.contains(x)).collect(Collectors.toSet());
		System.out.println("Common elelmets " +s2);

		//Approach 2
		List<Integer> li=
		    Arrays.stream(arr1).filter(x -> Arrays.stream(arr2)
		                               .anyMatch(arr2no -> arr2no == x)).boxed().collect(Collectors.toList());

		System.out.println("Common elelmets " +li);
	}
	public static void fetchSecondSmallest(int[] arr)
	{
		int secondSmallest = Arrays.stream(arr)
		                     .sorted()
		                     .distinct()
		                     .skip(1)
		                     .findFirst()
		                     .orElseThrow( ()-> new RuntimeException("Not Found") );

		System.out.println("2nd smallest "+secondSmallest);
	}
	public static void main(String[] args) {
		System.out.println("Hello World");
		int[] no = {1,3,2,2,5,6,4};
		int[] no2 = {3,4,5,8,9};
		commonElement(no,no2);
		//	int[] no= {1};
		fetchSecondSmallest(no);
		reverse(no);
		String[] s= {"apple","banana","mango","grapes"};
		lenOfLongestSTring(s);
	}
}