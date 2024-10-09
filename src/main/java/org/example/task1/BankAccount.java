package org.example.task1;

public class BankAccount implements Printable{
    private String accountNumber;
    private int balance;

    public void setBalance(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }

    @Override
    public void print() {
        System.out.println(this.balance);
    }
}
