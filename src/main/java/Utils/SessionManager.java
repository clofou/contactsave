package Utils;


import java.time.LocalDateTime;

public class SessionManager {

    public static void createSession(String uid) {
        FileOperations.writeIntegerToFile("session.txt", uid);
        DateTimeOperations.saveCurrentDateTime();
    }

    public static void destroySession() {
        FileOperations.writeIntegerToFile("session.txt", "");
    }

    public static String getSessionUserUid() {
        LocalDateTime savedDateTime = DateTimeOperations.readSavedDateTime();
        if(savedDateTime != null){
            if (!DateTimeOperations.is15MinutesElapsed(savedDateTime)){
                return FileOperations.readIntegerFromFile("session.txt");
            }else{
                return null;
            }
        } else{
            return null;
        }

    }
}
