package uz.pdp.ForkJoinPool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        CustomRecursiveTask task = new CustomRecursiveTask("hfgvyuvgbryvjhbshjvblysjbvhjrgsvlwhfowhfowigugbvhjbvsjvbshbvh");
        forkJoinPool.execute(task);
        task.join();
        ExecutorService executorService = Executors.newWorkStealingPool();


    }
}

class PessedApplicantsCounterTesk extends RecursiveTask<Integer>{
    private double[] res;
    private static final int Threshold = 10;
    private static final Logger log = Logger.getAnonymousLogger();

    public PessedApplicantsCounterTesk(double[] res) {
        this.res = res;
    }

    @Override
    protected Integer compute() {
        if (res.length> Threshold){
            PessedApplicantsCounterTesk.invokeAll(applicantsCounterTesks());
            for (PessedApplicantsCounterTesk tesk : applicantsCounterTesks()){

            }
        }else {
            return proccess();
        }

        return null;
    }

    private Integer proccess() {
        int counter = 0;
        for(double res : res){
            if(res > 57.7){
                counter++;
            }
        }
        return counter;
    }

    private List<PessedApplicantsCounterTesk> applicantsCounterTesks(){
        return List.of(
                new PessedApplicantsCounterTesk(Arrays.copyOfRange(res,0,res.length/2)),
                new PessedApplicantsCounterTesk(Arrays.copyOfRange(res,res.length/2,res.length))
        );

    }
}
class CustomRecursiveTask extends RecursiveAction {
    private String content;

    public CustomRecursiveTask(String content) {
        this.content = content;
    }

    private static final int THRESHOLD = 4;
    private static final Logger log = Logger.getAnonymousLogger();

    @Override
    protected void compute() {
        if (content.length() > 4 ){
            CustomRecursiveTask.invokeAll(customRecursiveTasks());
        }
    }
    private List<CustomRecursiveTask> customRecursiveTasks(){
        String partOne = content.substring(0,content.length()/2);
        String partTwo = content.substring(content.length()/2);
        new CustomRecursiveTask(partOne);
        new CustomRecursiveTask(partTwo);

        return List.of(
                new CustomRecursiveTask(partOne),
                new CustomRecursiveTask(partTwo)
        );
    }
//    private void processing(){
//        log.info(content + " is    " + );
//    }
}
// erwe
