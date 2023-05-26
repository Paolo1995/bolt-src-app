package eu.bolt.android.audio_recording_engine.db;

import eu.bolt.android.audio_recording_engine.engine.OrderData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DatabaseUtils.kt */
/* loaded from: classes5.dex */
public final class DatabaseUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final DatabaseUtils f36600a = new DatabaseUtils();

    private DatabaseUtils() {
    }

    public final String a(OrderData orderData) {
        Intrinsics.f(orderData, "orderData");
        return orderData.c() + orderData.a() + orderData.b();
    }
}
