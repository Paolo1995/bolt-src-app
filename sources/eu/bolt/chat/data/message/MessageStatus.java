package eu.bolt.chat.data.message;

/* compiled from: MessageStatus.kt */
/* loaded from: classes5.dex */
public enum MessageStatus {
    ERROR(-1),
    SENDING(0),
    SENT(1),
    DELIVERED_TO_BACKEND(2),
    DELIVERED_TO_RECIPIENT(3),
    SEEN(4);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f39005f;

    MessageStatus(int i8) {
        this.f39005f = i8;
    }

    public final int c() {
        return this.f39005f;
    }
}
