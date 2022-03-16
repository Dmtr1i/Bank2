package com.company;

public class Main {

    public static void main(String[] args) {
	    int numOfWorkers = 5;
        int customerPeriod = 3;
        Data wtb = new Data(numOfWorkers, customerPeriod);
        CustomerGenerator generator = new CustomerGenerator(wtb);
        Thread generatorThread = new Thread(generator);
        for (int i = 0; i < wtb.getWorkerList().length; i++) {
            Thread workerThread = new Thread(wtb.getWorkerList()[i]);
            workerThread.start();
        }
        generatorThread.start();
    }
}
