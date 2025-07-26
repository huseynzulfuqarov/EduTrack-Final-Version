package projects.interfaces;

public interface Notifiable {

    static final String SYSTEM_NAME="EduTracker: ";

    void sendNotification(String message);

    default void notifyWithPrefix(String message){
        System.out.print(SYSTEM_NAME + message);
    }

}
