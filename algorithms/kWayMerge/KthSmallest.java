package kWayMerge;

import java.util.*;

class QueueNode {
    public int data;
    public int row;
    public int column;

    public QueueNode(int data, int row, int column) {
        this.data = data;
        this.row = row;
        this.column = column;
    }
}

class NodeComparator implements Comparator<QueueNode> {
    @Override
    public int compare(QueueNode n1, QueueNode n2) {
        if(n1.data > n2.data) {
            return 1;
        } else if (n1.data < n2.data) {
            return -1;
        }
        return 0;
    }
}

class KthSmallest {
    
    public static int kthSmallestElement(int[][] matrix, int k) {
        PriorityQueue<QueueNode> queue = new PriorityQueue<QueueNode>(k, new NodeComparator());
        
        // Add the first column to the min heap
        for( int i = 0; i < matrix.length; i++) {
            queue.add(new QueueNode(matrix[i][0], i, 0));
        }

        int countRemoved = 0;
        QueueNode head = null;
        while(countRemoved < k) {
            head = queue.poll();
            if(matrix[head.row].length > head.column + 1) {
                queue.add(new QueueNode(matrix[head.row][head.column + 1], head.row, head.column + 1));
            }
            countRemoved += 1;
        }
        return head.data;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{2, 6, 8}, {3, 7, 10}, {5, 8, 11}};
        int result = kthSmallestElement(matrix, 3);
        System.out.print(result);
    }
        
}
