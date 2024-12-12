package A2;

import java.util.*;

public class Ride implements RideInterface {
    private String rideName;              // 游乐设施名称
    private int maxRiders;                // 每次游乐设施最大承载游客数
    private Employee operator;            // 操作员（负责管理该游乐设施）
    private Queue<Visitor> queue;         // 游客排队队列
    private LinkedList<Visitor> rideHistory;  // 游客游玩历史记录

    // 构造函数：初始化游乐设施的名称和最大承载人数
    public Ride(String rideName, int maxRiders) {
        this.rideName = rideName;
        this.maxRiders = maxRiders;
        this.queue = new LinkedList<>();   // 使用LinkedList实现队列
        this.rideHistory = new LinkedList<>(); // 游乐历史使用LinkedList保存
    }

    // 给游乐设施分配操作员
    public void assignOperator(Employee operator) {
        this.operator = operator;
        System.out.println(operator.getName() + " is now the operator of " + rideName);
    }

    // 添加游客到排队队列
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.offer(visitor); // 使用offer方法将游客添加到队列末尾
        System.out.println(visitor.getName() + " added to the queue.");
    }

    // 从排队队列中移除游客
    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " removed from the queue.");
        } else {
            System.out.println("Visitor not found in the queue.");
        }
    }

    // 打印当前排队中的所有游客
    @Override
    public void printQueue() {
        System.out.println("Visitors in queue: ");
        for (Visitor v : queue) {
            System.out.println(v.getName());
        }
    }

    // 游乐设施运行一次：接纳游客，并移除已乘坐的游客
    @Override
    public void runOneCycle() {
        if (operator == null) {
            System.out.println("No operator assigned to the ride.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }

        // 按最大承载人数取游客
        int cycleCount = Math.min(queue.size(), maxRiders);
        for (int i = 0; i < cycleCount; i++) {
            Visitor v = queue.poll(); // 从队列中移除游客
            rideHistory.add(v); // 将游客添加到历史记录
            System.out.println(v.getName() + " is riding the " + rideName);
        }
    }

    // 获取游乐历史中的游客数量
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    // 打印所有乘坐过游乐设施的游客历史
    @Override
    public void printRideHistory() {
        System.out.println("Ride history: ");
        for (Visitor v : rideHistory) {
            System.out.println(v.getName());
        }
    }

    // 判断某个游客是否已经乘坐过游乐设施
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    // 将游客添加到历史记录
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
    }
}



