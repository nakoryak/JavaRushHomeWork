package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * Created by nakoryakov on 07.09.15.
 */
class InfoCommand implements Command {
    private ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "resources.info_en");
    @Override
    public void execute() {
        System.out.println(res.getString("before"));
        Set<String> manipulators = (Set)CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if (manipulators.isEmpty()) ConsoleHelper.writeMessage(res.getString("no.money"));
        else {
            for (String map : manipulators) {
                CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(map);
                if (!manipulator.hasMoney()) {
                    ConsoleHelper.writeMessage(res.getString("no.money"));
                } else {
                    ConsoleHelper.writeMessage(map + " - " + manipulator.getTotalAmount());
                }
            }
        }
    }
}
