package vn.binhhq.fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vn.binhhq.fun.service.validate_driven.inout.MethodData;
import vn.binhhq.fun.service.validate_driven.inout.UpdateDrivenReq;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StreamTest {

    @Test
    public void testList() {
        List<String> t = new ArrayList<>();

        t.add("6");
        t.add("1");
        t.add("2");
        t.add("3");
        t.add("4");
        t.add("5");
//        t.stream().
//        t.stream().forEach(System.out::println);
//        System.out.println("---------------------------");
//        t.stream().forEach(t1 -> System.out.println(t1));
//        t.stream().filter(t1 -> t1.equals("1"))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

//        t.stream().map(t1 -> t1 + "x").forEach(System.out::println);
//        System.out.println("---------------------------");
//        t.stream().limit(6).forEach(System.out::println);
//        System.out.println("---------------------------");
//        t.stream().sorted().forEach(System.out::println);

//        t.stream().forEach(System.out::println);
//        System.out.println("---------------------------");
//        t.parallelStream().forEach(System.out::println);
//        System.out.println("---------------------------");
//        t.parallelStream().sorted().forEach(System.out::println);

//        List<Integer> n = new ArrayList<>();
//
//
//        n.add(1);
//        n.add(2);
//        n.add(3);
//        n.add(4);
//        n.add(5);
//        n.add(6);
//        n.add(5);
//        n.add(6);
//        n.add(2);
////        n.parallelStream().map(t1 ->t1*t1).forEach(System.out::println);
////
////        int sum = n.stream().reduce(0, (x,y) -> x + y);
////        System.out.println(sum);
////        sum = n.stream().reduce(0, Integer::sum);
////        IntSummaryStatistics stats = n.parallelStream().mapToInt((t1) ->t1*t1 - t1).summaryStatistics();
////        System.out.println("Highest number in List : " + stats.getMax());
////        System.out.println("Lowest number in List : " + stats.getMin());
////        System.out.println("Sum of all numbers : " + stats.getSum());
////        System.out.println("Average of all numbers : " + stats.getAverage());
//
////        Set<Integer> seen = Collections.synchronizedSet(new HashSet<>());
////        n.stream().map(e -> { if (seen.add(e)) return 0; else return e; }).forEach(System.out::println);
////        n.stream().distinct().forEach(System.out::println);
////        n.stream().sorted();
////        int result = Integer.MAX_VALUE + 1;
////        result = Integer.MIN_VALUE - 1;
////        System.out.println(result);
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
//        getList().orElseGet(() -> new ArrayList<>());
//        List<String> x = getList().orElseGet(() -> new ArrayList<>());
//        Optional<UpdateDrivenReq> y = Optional.ofNullable(new UpdateDrivenReq());
//        Long result = y.map(UpdateDrivenReq::getMethod).map(MethodData::getMethodId).orElse(0L);
//        Optional.ofNullable(x).orElse(new ArrayList<>()).stream().sorted().forEach(System.out::println);

    }

    public Optional<List<String>> getList(){
        return null;
    }
}
