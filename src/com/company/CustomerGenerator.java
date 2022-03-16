package com.company;

public class CustomerGenerator implements Runnable {
    private Data data;

    CustomerGenerator(Data newData) {
        data = newData;
        for (int i = 0; i < data.getWorkerList().length; i++) data.getWorkerList()[i].setBank(data.getBank());
    }

    private Worker getFreeWorker() {
        Worker worker = data.getWorkerList()[0];
        int workerList = 99999;
        for (int i = 0; i < data.getWorkerList().length; i++) {
            if (data.getWorkerList()[i].getCustList().length == 0) return data.getWorkerList()[i];
            if (data.getWorkerList()[i].getCustList().length < workerList) {
                worker = data.getWorkerList()[i];
                workerList = data.getWorkerList()[i].getCustList().length;
            }
        }
        return worker;
    }

    @Override
    public void run() {
        System.out.println("Банк открывает двери, ожидайте клиентов!");
        while (System.currentTimeMillis() - data.getBank().getWorkTime() < data.getBank().getStartTime()) {
            Customer cust = new Customer();
            Worker worker = getFreeWorker();
            worker.addCustomer(cust);
            System.out.println("Работнику №" + worker.getID() + " добавлен клиент: сумма операции: " + cust.getMoney() + ", время обслуживания: " + cust.getServiseTime() + ", его очередь равна " + worker.getCustList().length + " человек\n\n");
            try { Thread.sleep(data.getCustomerPeriod() * 1000); } catch (InterruptedException e) { System.out.println("Error in customerGenerator"); }
        }
        System.out.println("Прием клиентов закончен!");
    }
}
