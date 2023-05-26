package eu.bolt.client.chatdb.room.chat;

/* compiled from: OrderHandleDbModel.kt */
/* loaded from: classes5.dex */
public final class OrderHandleDbModel {

    /* renamed from: a  reason: collision with root package name */
    private final long f39819a;

    /* renamed from: b  reason: collision with root package name */
    private final String f39820b;

    /* renamed from: c  reason: collision with root package name */
    private final Long f39821c;

    public OrderHandleDbModel(long j8, String str, Long l8) {
        this.f39819a = j8;
        this.f39820b = str;
        this.f39821c = l8;
    }

    public final Long a() {
        return this.f39821c;
    }

    public final long b() {
        return this.f39819a;
    }

    public final String c() {
        return this.f39820b;
    }

    public OrderHandleDbModel() {
        this(0L, null, null);
    }
}
