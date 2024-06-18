package edu.patterns.shapes.observer;

public interface Observable {
    void attach();
    void detach();
    void notifyObservers();
}