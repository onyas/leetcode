package com.onyas.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by IntelliJ IDEA
 * User: zhenglinlin
 * Date: 16/6/4
 * Time: 下午12:17
 * <p/>
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * click to show more hints.
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
 * Topological sort could also be done via BFS.
 * Subscribe to see which companies asked this question
 * Hide Tags Depth-first Search Breadth-first Search Graph Topological Sort
 * Hide Similar Problems (M) Course Schedule II (M) Graph Valid Tree (M) Minimum Height Trees
 */
public class P207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
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
        while (!queue.isEmpty()) {
            int course = queue.poll();
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
        return numCourses == numNoPre;
    }


    public static void main(String[] args) {

        System.out.println(new P207CourseSchedule().canFinish(2, new int[][]{new int[]{0, 1}}));
        System.out.println(new P207CourseSchedule().canFinish(2, new int[][]{new int[]{0, 1},new int[]{1,0}}));
    }
}
