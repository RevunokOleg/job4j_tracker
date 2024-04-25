package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder even = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i += 2) {
            even.append(evenElements.removeFirst());
            evenElements.removeFirst();
        }
        return "" + even;
    }

    private String getDescendingElements() {
        StringBuilder descending = new StringBuilder();
        for (int i = descendingElements.size(); i > 0; i--) {
            descending.append(descendingElements.pollLast());
        }
        return "" + descending;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}