package com.onyas.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/4
 * Time: 下午3:37
 * <p/>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * click to show more hints.
 * Subscribe to see which companies asked this question
 * Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
 * Hide Similar Problems (M) Course Schedule (H) Alien Dictionary (M) Minimum Height Trees
 */
public class P210CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        if (numCourses == 0 || prerequisites == null) {
            return result;
        }

        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                result[i] = i;
            }
            return result;
        }


        int[] courseCount = new int[numCourses];//recode the course count
        int len = prerequisites.length;

        for (int i = 0; i < len; i++) {
            courseCount[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (courseCount[i] == 0) {
                queue.offer(i);
            }
        }

        int numNoPre = queue.size();
        int k = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            result[k++] = course;
            for (int i = 0; i < len; i++) {
                if (prerequisites[i][1] == course) {
                    courseCount[prerequisites[i][0]]--;
                    if (courseCount[prerequisites[i][0]] == 0) {
                        numNoPre++;
                        queue.add(prerequisites[i][0]);
                    }
                }
            }
        }
        if (numCourses == numNoPre) {
            return result;
        } else {
            return new int[0];
        }
    }


    public static void main(String[] args) {
//        int[] result = new P210CourseScheduleII().findOrder(2, new int[][]{new int[]{0, 1}});
        int[] result = new P210CourseScheduleII().findOrder(4, new int[][]{new int[]{1, 0},new int[]{2, 0},new int[]{3, 1},new int[]{3, 2}});

        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        }
    }
}
