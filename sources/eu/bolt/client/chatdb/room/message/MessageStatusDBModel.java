package eu.bolt.client.chatdb.room.message;

/* compiled from: MessageStatusDBModel.kt */
/* loaded from: classes5.dex */
public enum MessageStatusDBModel {
    SENDING_ERROR(0),
    SENDING(0),
    PRELIMINARY_DELIVERED_TO_BACKEND(1),
    DELIVERED_TO_BACKEND(2),
    DELIVERED_TO_RECIPIENT(3),
    LOCAL_SEEN_BY_RECIPIENT(4),
    SEEN_BY_RECIPIENT(5);
    

    /* renamed from: f  reason: collision with root package name */
    private final int f39844f;

    MessageStatusDBModel(int i8) {
        this.f39844f = i8;
    }

    public final int c() {
        return this.f39844f;
    }
}
