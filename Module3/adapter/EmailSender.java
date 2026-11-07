package Module3.adapter;

import Module3.adapter.NotificationSender;

public class EmailSender implements NotificationSender {
    @Override
    public void send(String recipient, String message) {
        System.out.println("Email → " + recipient + ": " + message);
    }
}

