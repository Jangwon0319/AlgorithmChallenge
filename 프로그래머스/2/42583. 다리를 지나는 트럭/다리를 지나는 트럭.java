import java.io.*;
import java.util.*;


class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        int totalWeight = 0;

        for (int truckWeight : truck_weights) {
            while (true) {
                // 큐(=다리)가 비었을 경우
                if (queue.isEmpty()) {
                    queue.offer(truckWeight);
                    totalWeight += truckWeight;
                    answer++;
                    break;
                }
                // 큐가 다리 길이랑 같을 경우
                else if (queue.size() == bridge_length) {
                    totalWeight -= queue.poll();
                }
                // 큐가 존재할 경우
                // 1. 무게를 벗어난 경우 2. 무게 이내인 경우
                else {
                    if (totalWeight + truckWeight > weight) {
                        queue.offer(0);
                        answer++;
                    }
                    else {
                        queue.offer(truckWeight);
                        totalWeight += truckWeight;
                        answer++;
                        break;
                    }
                }

            }
        }

        return answer + bridge_length;
    }
}