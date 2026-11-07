package Module3.adapter;

public class ThirdPartySmsApi {
    public void sendSms(String phoneNumber, String text) {
        System.out.println("SMS" + " → " + phoneNumber + ": " + text);
    }
}
