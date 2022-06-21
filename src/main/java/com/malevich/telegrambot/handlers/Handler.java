package com.malevich.telegrambot.handlers;

public interface Handler<T> {
    void choose(T t);
}
