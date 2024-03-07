package com.machinecoding.snakeandladder;

import com.machinecoding.snakeandladder.service.GameService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RunnerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter snakes detail(total count): ");
        Map<Integer, Integer> snakes = snakesAndLadder(sc);

        System.out.println("Enter ladders detail(total count): ");
        Map<Integer, Integer> ladder = snakesAndLadder(sc);

        // validate input(snakes & ladder, is any formed or not)
        if (isLoopPresent(snakes, ladder)) {
            System.out.println("Loop formed by input(snakes & ladders)");
            return;
        } else {
            System.out.println("No loop by input(snakes & ladders)");
        }

        System.out.println("Enter total players count: ");
        Integer usersCount = sc.nextInt();
        GameService gameService = new GameService(usersCount, snakes, ladder);
        gameService.gameStart();
    }

    private static Map<Integer, Integer> snakesAndLadder(Scanner sc) {
        int count = sc.nextInt();
        Map<Integer, Integer> snakes = new HashMap<>(count);
        for (int i = 0; i < count; i++) {
            System.out.print(String.format("Enter %sth starting position: ", i+1));
            Integer starting = sc.nextInt();
            System.out.print(String.format("Enter %sth ending position: ", i+1));
            Integer ending = sc.nextInt();
            snakes.put(starting, ending);
            System.out.println();
        }
        return snakes;
    }

    private static boolean isLoopPresent(Map<Integer, Integer> snakes, Map<Integer, Integer> ladders) {
        /*
        * Some possible cases:
        * snake: 40-20, ladder: 20-30, 30-40
        * snake: 20-40, ladder: 25-20, 30-25, 30-40
        * snake 40-36, 36-20 ladder: 20-25, 25-30, 30-40
        * snake 40-20, 25-20 ladder: 20-25, 25-30
        * snake 40-35, 35-20 ladder: 20-25, 25-40
        * */
        Set<Integer> visited = new HashSet<>();
        for (Integer startPoint : snakes.keySet()) {
            if (validate(startPoint, snakes, ladders, visited, new HashSet<>())) {
                return true;
            }
        }
        return false;
    }

    private static boolean validate(Integer startPoint, Map<Integer, Integer> snakes, Map<Integer, Integer> ladders,
                                    Set<Integer> visited, Set<Integer> path) {
        if (visited.contains(startPoint)) {
            return true;
        }
        visited.add(startPoint);
        path.add(startPoint);

        Integer nextNode = snakes.get(startPoint);
        if (nextNode != null && validate(nextNode, snakes, ladders, visited, path)) {
            return true;
        }

        nextNode = ladders.get(startPoint);
        if (nextNode != null && validate(nextNode, snakes, ladders, visited, path)) {
            return true;
        }

        path.remove(startPoint);
        return false;
    }

}
