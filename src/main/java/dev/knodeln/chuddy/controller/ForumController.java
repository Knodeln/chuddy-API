package dev.knodeln.chuddy.controller;

import dev.knodeln.chuddy.model.ChuddyUser;
import dev.knodeln.chuddy.model.DiscussionThread;
import dev.knodeln.chuddy.model.Forum;
import dev.knodeln.chuddy.model.ForumInitializer;

import java.util.List;
import java.util.ArrayList;

public class ForumController {

    private static final Forum forum = new Forum();

    public static void createThread(String threadName) {
        forum.createThread(threadName);
    }

    public static List<DiscussionThread> getDiscussionThreads() {
        return forum.getThreads();
    }

    public static DiscussionThread getSelectedThread() {
        return forum.getSelectedThread();

    }

    public static void selectThread(String selectedThread) {
        forum.selectThread(selectedThread);
    }

    public static void addMessage(String message, ChuddyUser sender) {
        forum.addMessage(message, sender);
    }

    public static void initDefaultForums() {

        ForumInitializer.initializeDefaultThreads();

    }

    public static List<DiscussionThread> getUserThreads(ChuddyUser user) {
        
        List<DiscussionThread> userThreads = new ArrayList<>();

        for (DiscussionThread thread : forum.getThreads()) {
            if (thread.containsUser(user)) {
                userThreads.add(thread);
            }
        }
        return userThreads;

    }
}
