package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

/**
 * Created by nakoryakov on 06.09.15.
 */
public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH +"common_en");
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static String readString() throws InterruptOperationException {
        String result = "";
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if ("EXIT".equalsIgnoreCase(result)) throw new InterruptOperationException();
        return result;
    }
    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = readString();
        while (currencyCode.length() != 3){
            writeMessage(res.getString("invalid.data"));
            currencyCode = readString();
        }
        return currencyCode.toUpperCase();
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        Integer firstInt;
        Integer secondInt;
        String twoDigits;
        writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
        while (true){
            twoDigits = readString();
            if (twoDigits.split(" ").length == 2){
                firstInt = Integer.parseInt(twoDigits.split(" ")[0]);
                secondInt = Integer.parseInt(twoDigits.split(" ")[1]);
                if (firstInt > 0 && secondInt > 0){
                    return twoDigits.split(" ");
                }
            }
            else {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
        }
    }
    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        while (true) {
            try {
                ConsoleHelper.writeMessage(res.getString("operation.INFO") + " 1: \n");
                ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT") + " 2: \n");
                ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW") + " 3: \n");
                ConsoleHelper.writeMessage(res.getString("operation.EXIT") + " 4: \n");
                Operation operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                return operation;
            } catch (IllegalArgumentException e){
                System.out.println(res.getString("invalid.data"));
                continue;
            }
        }
    }
    public static void printExitMessage(){
        writeMessage(res.getString("the.end"));
    }
}
