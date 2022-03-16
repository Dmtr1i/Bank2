package com.company;

public class Data {
    private Worker[] workerList;
    private Bank bank;
    private int customerPeriod;

    Data(int numOfWorkers, int newCustomerPeriod) {
        bank = new Bank();
        workerList = new Worker[numOfWorkers];
        for (int i = 0; i < numOfWorkers; i++) workerList[i] = new Worker(i);
        customerPeriod = newCustomerPeriod;
    }

    public Bank getBank() {
        return bank;
    }

    public Worker[] getWorkerList() {
        return workerList;
    }

    public int getCustomerPeriod() {
        return customerPeriod;
    }
}
