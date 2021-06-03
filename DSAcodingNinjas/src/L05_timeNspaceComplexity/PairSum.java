package L05_timeNspaceComplexity;

import java.util.Arrays;

public class PairSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int pairSum(int[] arr, int num) {
		Arrays.sort(arr);
		int si = 0;
		int ei = (arr.length-1);
		int numPair = 0;
		while(si < ei) {
			if(arr[si]+arr[ei]<num) si++;
			else if(arr[si]+arr[ei]>num) ei--;
			else {
				int elementAtStart = arr[si];
				int elementAtEnd = arr[ei];
				
				if(elementAtStart == elementAtEnd) {
					int totalElementsFromStartToEnd = (ei - si) + 1;
					numPair += (totalElementsFromStartToEnd*(totalElementsFromStartToEnd-1)/2);
					
					return numPair;
				}
				
				int tempStartIndex = si + 1;
				int tempEndIndex = ei - 1;
				
				while(tempEndIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart) {
					tempStartIndex += 1;
				}
				
				while(tempEndIndex >= tempEndIndex && arr[tempEndIndex] == elementAtEnd) {
					tempEndIndex -= 1;
				}
				
				int totalElementFromStart = (tempStartIndex - si);
				int totalElementFromEnd = (ei - tempEndIndex);
				
				numPair += (totalElementFromStart * totalElementFromEnd);
				
				si = tempStartIndex;
				ei = tempEndIndex;
				
			}
		}
		return numPair;
	}

}
