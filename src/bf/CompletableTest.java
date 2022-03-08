package bf;


import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;


class CompletableTest {
    public static void main(String[] args) {

//        ExecutorService executor = Executors.newSingleThreadExecutor();
//        CompletableFuture<Void> rFuture = CompletableFuture
//                .runAsync(() -> System.out.println("hello siting"), executor);
//        //supplyAsync的使用
//        CompletableFuture<String> future = CompletableFuture
//                .supplyAsync(() -> {
//                    System.out.print("hello ");
//                    return "siting";
//                }, executor);
//
//        //阻塞等待，runAsync 的future 无返回值，输出null
//        System.out.println("===================...==================");
//        Void join = rFuture.join();
//        System.out.println(join);
//        //阻塞等待
//        String name = future.join();
//        System.out.println(name);
//
//
//        System.out.println("===================...==================");
//        CompletableFuture<Void> async = CompletableFuture
//                .supplyAsync(() -> {
//                    System.out.println("hello siting");
//                    return "11";
//                }, executor)
//                .thenRunAsync(() -> System.out.println("OK"), executor);
//
//        System.out.println("===================...==================");
//        CompletableFuture<Void> async1 = CompletableFuture.supplyAsync(() -> {
//                    System.out.println("hello test");
//                    return "111";
//                }, executor)
//                .thenAcceptAsync(t -> {
//                    System.out.print("");
//                    System.out.println(t);
//                }, executor);
//
//        CompletableFuture<String> future1 = CompletableFuture
//                .supplyAsync(() -> "hello world", executor)
//                .thenApplyAsync(data -> {
//                    System.out.println(data);
//                    return "OK";
//                }, executor);
//
        ThreadFactory namedThread = new ThreadFactoryBuilder().setNameFormat("abyss-%d").setDaemon(true).build();

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(namedThread);
        List<Integer> list = new CopyOnWriteArrayList<>();
        IntStream.rangeClosed(1, 7).forEach(list::add);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            if (CollectionUtils.isEmpty(list)) {
                System.out.println("empty");
                return;
            }
            Integer integer = list.get(0);
            System.out.println(integer);
            list.remove(0);
        }, 1, 1, TimeUnit.SECONDS);
        IntStream.rangeClosed(9, 11).forEach(list::add);
        ThreadUtil.sleep(20, TimeUnit.SECONDS);
        scheduledExecutorService.shutdown();


//        ExecutorService executor = Executors.newFixedThreadPool(5, namedThread);
//
//        final String formatter = "%s - %s - %s%n";
//        List<Integer> requests = Arrays.asList(1, 2, 3, 4, 5);
//
//        CompletableFuture<Object> any = CompletableFuture.anyOf(requests
//                .stream()
//                .map(request ->
//                        CompletableFuture.supplyAsync(() -> {
//                            ThreadUtil.sleep(1000L * request);
//                            System.out.printf(formatter, request, Instant.now().toEpochMilli(), Thread.currentThread().getName());
//                            return "hello " + request;
//                        }, executor))
//                .toArray(CompletableFuture[]::new)
//        );
//
//        Object join = any.join();
//        System.out.println("end ========== " + join.toString());
//
//
//        CompletableFuture<Void> all = CompletableFuture.allOf(requests
//                .stream()
//                .map(request ->
//                        CompletableFuture.supplyAsync(() -> {
//                            ThreadUtil.sleep(1000L * request);
//                            System.out.printf(formatter, request, Instant.now().toEpochMilli(), Thread.currentThread().getName());
//                            return "hello " + request;
//                        }, executor))
//                .toArray(CompletableFuture[]::new)
//        );
//
//        Void join1 = all.join();
//        System.out.println("end ========== " + join1);
////        System.out.println(future1.join());
//        executor.shutdown(); // 线程池需要关闭
    }
}