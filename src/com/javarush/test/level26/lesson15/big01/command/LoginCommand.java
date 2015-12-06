package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by nakoryakov on 04.12.15.
 */
class LoginCommand implements Command {
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true){
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String userCreditCardNumber = ConsoleHelper.readString().trim();
            if (userCreditCardNumber == null || userCreditCardNumber.length() != 12){
                ConsoleHelper.writeMessage(res.getString("try.again"));
                continue;
            }
            String userPin = ConsoleHelper.readString().trim();
            if (userPin == null || userPin.length() != 4){
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }
            if (validCreditCards.containsKey(userCreditCardNumber) && validCreditCards.getString(userCreditCardNumber).equals(userPin)){
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), userCreditCardNumber));
                break;
            }
            else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), userCreditCardNumber));
            }
            ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
        }
    }
}
