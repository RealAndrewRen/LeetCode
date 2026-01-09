class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> negs = new ArrayList<Integer>();
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < asteroids.length; i++){
            if (asteroids[i] >= 0){
                st.push(asteroids[i]);
            }
            else{
                while (!st.isEmpty() && Math.abs(asteroids[i]) > st.peek()){
                    st.pop();
                    continue;
                }
                if (!st.isEmpty() && Math.abs(asteroids[i]) == st.peek()){
                    System.out.println(st.peek());
                    st.pop();
                    continue;
                }
                if (st.isEmpty()){
                    negs.add(asteroids[i]);
                }
            }
        }
        while (!st.isEmpty()){
            list.add(st.pop());
        }
        int result[] = new int[list.size() + negs.size()];
        for (int j = list.size() - 1; j >= 0; j--){
            result[negs.size() + list.size() - 1 - j] = list.get(j);
        }
        for (int i = 0; i < negs.size(); i++){
            result[i] = negs.get(i);
        }
        return result;
    }
}