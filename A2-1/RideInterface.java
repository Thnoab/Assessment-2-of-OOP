package A2;

public interface RideInterface {
    void addVisitorToQueue(Visitor visitor);          // 添加游客到排队队列
    void removeVisitorFromQueue(Visitor visitor);     // 从队列中移除游客
    void printQueue();                                // 打印当前排队的游客
    void runOneCycle();                               // 运行一次游乐设施
    void addVisitorToHistory(Visitor visitor);        // 添加游客到游乐历史
    boolean checkVisitorFromHistory(Visitor visitor); // 检查游客是否已乘坐过游乐设施
    int numberOfVisitors();                           // 返回已乘坐游客数量
    void printRideHistory();                          // 打印游乐历史
}

