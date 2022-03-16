package com.company;

public class Worker implements Runnable {
    private int ID;
    private Customer[] custList;
    private Bank bank;

    Worker(int id) {
        custList = new Customer[0];
        ID = id;
    }

    public void setBank(Bank newBank) {
        bank = newBank;
    }

    public Customer[] getCustList() {
        return custList;
    }

    public void addCustomer(Customer customer) {
        Customer[] temp = new Customer[custList.length + 1];
        for (int i = 0; i < custList.length; i++) temp[i] = custList[i];
        temp[temp.length - 1] = customer;
        custList = temp;
    }

    public void removeCustomer() {
        if (custList.length > 0) {
            if (custList.length != 1) {
                Customer[] temp = new Customer[custList.length - 1];
                for (int i = 1; i < temp.length + 1; i++) temp[i - 1] = custList[i];
                custList = temp;
            } else custList = new Customer[0];
        }
    }

    public int getID() {
        return ID;
    }

    @Override
    public void run() {
        System.out.println("Работник №" + ID + " вышел на работу!\n");
        while (System.currentTimeMillis() - bank.getWorkTime() < bank.getStartTime()) {
            if (custList.length > 0) {
                System.out.println("Работник №" + ID + " начал работу с клиентом! Заполняем необходимые документы!\n\n");
                long tempTime = System.currentTimeMillis();
                try { Thread.sleep(custList[0].getServiseTime() * 1000); } catch (InterruptedException e) { System.out.println("Error in worker sleeping"); }
                System.out.println("Работник №" + ID + " заполнил необходимые документы, выполняем перевод!\n");
                bank.workWithMoney(ID, custList[0].getMoney());
                System.out.println("Работник №" + ID + " прекратил работу с клиентом, время выполнения составило: " + (int) (System.currentTimeMillis() - tempTime) / 1000 + " секунд\n\n");
                removeCustomer();
            }
            try { Thread.sleep(1); } catch (InterruptedException e) { System.out.println("Error in waiting customer\n"); }
        }
    }
}
