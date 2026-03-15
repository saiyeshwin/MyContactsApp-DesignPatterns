package com.seveneleven.mycontactapp.observer;
public interface ContactSubject {
    void addObserver(ContactObserver observer);
    void removeObserver(ContactObserver observer);
    void notifyObservers();
}