package com.company;

public class Bank {
    private double money;
    private long workTime;
    private long startTime;

    Bank() {
        System.out.println("Банк начинает работу!\n");
        money = 1000;
        workTime = 60000;
        startTime = System.currentTimeMillis();
    }

    public synchronized void workWithMoney(int workerID ,double customerMoney) {
        if (customerMoney > 0) {
            money += customerMoney;
            System.out.println("Работник №" + workerID + " выполнил операцию на " + customerMoney + " рублей, остаток в банке: " + money + ", заполняем оставшиеся документы!\n\n");
        } else {
            if (money + customerMoney > 0) {
                money += customerMoney;
                System.out.println("Работник №" + workerID + " выполнил операцию на " + customerMoney + " рублей, остаток в банке: " + money + ", заполняем оставшиеся документы!\n\n");
            } else System.out.println("В банке не достаточно денег!\n\n");
        }
    }

    public long getStartTime() {
        return startTime;
    }

    public long getWorkTime() {
        return workTime;
    }
}
