class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<Integer> st = new Stack<Integer>();
        st.push(0);
        for (int i = 1; i < temperatures.length; i++){
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int j = st.pop();
                result[j] = i - j;
            }
            st.push(i);
        }
        return result;
    }
}