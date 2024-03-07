package com.machinecoding.snakeandladder.service;

import com.machinecoding.snakeandladder.Entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.machinecoding.snakeandladder.utility.CommonMethods.getUserId;
import static com.machinecoding.snakeandladder.utility.CommonMethods.rollDice;

public class GameService {
    private Map<Integer, Integer> snake;
    private Map<Integer, Integer> ladder;
    private List<User> userList;
    private static int gameWinningPoint = 100;

    public GameService(Integer userCount, Map<Integer, Integer> snake, Map<Integer, Integer> ladder) {
        this.ladder = ladder;
        this.snake = snake;
        userList = new ArrayList<>(userCount);
        for (int counter = 0; counter < userCount; counter++) {
            userList.add(new User(getUserId(), 0));
        }
    }

    public void gameStart() {
        while (true) {
            boolean flag = false;
            for (User user : userList) {
                int diceRoll = rollDice();
                int newPosition = user.getPosition() + diceRoll;
                if (newPosition == gameWinningPoint) {
                    System.out.println(String.format("Player: %s win the game", user.getId()));
                    flag = true;
                    break;
                } else if (newPosition < gameWinningPoint) {
                    newPosition = getNextPosition(user.getId(), newPosition);
                    System.out.println(String.format("Player: %s moved from position: %s to %s position", user.getId(),
                            user.getPosition(), newPosition));
                    user.setPosition(newPosition);
                } else{
                    System.out.println(String.format("Player: %s can't move to next position: %s", user.getId(), newPosition));
                }
            }
            if (flag) {
                break;
            }
        }
    }

    private int getNextPosition(Integer userId, int newPosition) {
        if (snake.containsKey(newPosition)) {
            System.out.println(String.format("Player: %s cut by snake at position %s to position %s", userId, newPosition,
                    snake.get(newPosition)));
            newPosition = getNextPosition(userId, snake.get(newPosition));
        } else if (ladder.containsKey(newPosition)) {
            System.out.println(String.format("Player: %s get ladder at position %s to position %s", userId, newPosition,
                    ladder.get(newPosition)));
            newPosition = getNextPosition(userId, ladder.get(newPosition));
        }
        return newPosition;
    }
}


