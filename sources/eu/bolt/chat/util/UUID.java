package eu.bolt.chat.util;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: UUID.kt */
/* loaded from: classes5.dex */
public final class UUID {

    /* renamed from: a  reason: collision with root package name */
    public static final UUID f39707a = new UUID();

    private UUID() {
    }

    public final String a() {
        String uuid = java.util.UUID.randomUUID().toString();
        Intrinsics.e(uuid, "randomUUID().toString()");
        return uuid;
    }
}
