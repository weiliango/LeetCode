
    /*
     * Complete the function below.
     */
    static int[] getTheGroups(int n, String[] queryType, int[] students1, int[] students2) {
        int[] roots = new int[n+1];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < roots.length; i++)
            roots[i] = i;
        for(int i = 0; i < queryType.length; i++) {
            int root1 = findRoot(roots, students1[i]);
            int root2 = findRoot(roots, students2[i]);
            if(queryType[i].equals("Friend")) {
                if(root1 != root2)
                    roots[root1] = root2;
            } else {
                int result = 0;
                if(root1 == root2) {
                    result = total(roots, root1);
                } else {
                    result = total(roots, root1) + total(roots, root2);
                }
                list.add(result);
            }
        }
        
        int[] rst = new int[list.size()];
        for(int i = 0; i < rst.length; i++)
            rst[i] = list.get(i);
        return rst;
    }
    static int total(int[] roots, int target) {
        int rst = 0;
        for(int i = 0; i < roots.length; i++) {
            if(findRoot(roots, i) == target)
                rst++;
        }
        return rst;
    }
    static int findRoot(int[] roots, int idx) {
        if(roots[idx] != idx)
            roots[idx] = findRoot(roots, roots[idx]);
        return roots[idx];
    }
