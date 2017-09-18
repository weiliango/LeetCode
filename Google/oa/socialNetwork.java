import java.util.*;
public class Solution {
    public static void main(String[] args) {
        new Solution().socialNetwork(new int[]{4, 4, 3, 3, 3, 1, 4, 4});
    }
    static class User {
        int user_id;
        int group_size;
        public User(int user_id, int group_size) {
            this.user_id = user_id;
            this.group_size = group_size;
        }
    }
    public void socialNetwork(int[] arr) {
        User[] users = new User[arr.length];
        for(int i = 0; i < arr.length; i++) {
            users[i] = new User(i, arr[i]);
        }
        Arrays.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                if(u1.group_size != u2.group_size)
                    return u2.group_size - u1.group_size;
                else
                    return u1.user_id - u2.user_id;
            }
        });
        int counter = 0;
        int max_group = 0;
        StringBuilder sb = new StringBuilder();
        // new code
        List<String> res = new LinkedList<>();
        // new code end
        for(int i = 0; i < users.length; i++) {
            max_group = users[i].group_size;
            counter++;
            sb.append(users[i].user_id + " ");
            if(counter == max_group) {
                sb.deleteCharAt(sb.length() - 1);
                
                //new code
                res.add(sb.toString());
                // new code end
                
                sb = new StringBuilder();
                counter = 0;
            }
        }
        // new code
        Collections.sort(res);
        for(String s: res)
            System.out.println(s);
        // new code end
    }
}