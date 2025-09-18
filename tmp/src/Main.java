import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class TaskManager {
    private HashMap<Integer, int[]> taskMap;
    private PriorityQueue<int[]> heap;
    public TaskManager(List<List<Integer>> tasks) {
        // key taskId, 0 priority, 1 userId
        taskMap = new HashMap<>();
        // 0 priority, 1 taskId
        // 最大堆，优先级高的先执行
        heap = new PriorityQueue<>((a, b) -> (b[0] - a[0] == 0) ? b[1] - a[1] : b[0] - a[0]);

        for(List<Integer> task: tasks){
            add(task.get(0), task.get(1), task.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        int[] task_info = new int[]{priority, userId};
        int[] queue_task_info = new int[]{priority, taskId};
        taskMap.put(taskId, task_info);
        heap.add(queue_task_info);
    }

    public void edit(int taskId, int newPriority) {
        this.add(taskMap.get(taskId)[1], taskId, newPriority);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while(!heap.isEmpty()){
            int[] queue_task_info = heap.poll();
            int priority = queue_task_info[0];
            int taskId = queue_task_info[1];
            if(taskMap.containsKey(taskId)){
                int[] task_info = taskMap.get(taskId);
                if(task_info[0] == priority){
                    rmv(taskId);
                    return task_info[1];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        TaskManager tm = new TaskManager(new ArrayList<>());

    }
}