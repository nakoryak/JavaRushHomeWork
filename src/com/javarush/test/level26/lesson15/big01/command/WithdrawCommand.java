package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by nakoryakov on 07.09.15.
 */
class WithdrawCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        while (true){
            try {
                ConsoleHelper.writeMessage(res.getString("specify.amount"));
                Integer amount = Integer.parseInt(ConsoleHelper.readString());
                if (!manipulator.isAmountAvailable(amount)){
                    ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                }
                else {
                    Map<Integer,Integer> amounts = manipulator.withdrawAmount(amount);
                    for (Map.Entry<Integer,Integer> map : amounts.entrySet()){
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"),map.getKey(), map.getValue()));
                    }
                }
            } catch (NumberFormatException e){
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
            } catch (NotEnoughMoneyException e){
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
            }
        }
    }
}
