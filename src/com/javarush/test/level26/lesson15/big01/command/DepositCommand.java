package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by nakoryakov on 07.09.15.
 */
class DepositCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominations = ConsoleHelper.getValidTwoDigits(currencyCode);
        try {
            int current = Integer.parseInt(denominations[0]);
            int amount = Integer.parseInt(denominations[1]);
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), current * amount, currencyCode));
        } catch (NumberFormatException e){
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        manipulator.addAmount(Integer.parseInt(denominations[0]), Integer.parseInt(denominations[1]));
    }
}
