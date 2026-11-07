package Module3.adapter;

public class SmsAdapter implements NotificationSender{
    private final ThirdPartySmsApi smsApi;

    public SmsAdapter(ThirdPartySmsApi smsApi) {
        this.smsApi = smsApi;
    }

    @Override
    public void send(String recipient, String message) {
        smsApi.sendSms(recipient,message);
    }
}
