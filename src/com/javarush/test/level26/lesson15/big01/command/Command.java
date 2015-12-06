package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

/**
 * Created by nakoryakov on 07.09.15.
 */
interface Command {
    void execute() throws InterruptOperationException;
}
