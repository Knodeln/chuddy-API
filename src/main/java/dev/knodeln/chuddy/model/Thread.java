package dev.knodeln.chuddy.model;

import java.util.ArrayList;
import java.util.List;

public class Thread {
    private List<Message> messages;


    public void ChatThread() {
        this.messages = new ArrayList<>();
    }

    public void addMessage(ChuddyUser sender, String content) {
        Message message = new Message(sender, content);
        messages.add(message);
    }

    public List<Message> getMessages() {
        return messages;
    }
}