package eu.bolt.driver.core.network.response;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: BasicServerResponse.kt */
/* loaded from: classes5.dex */
public final class BasicServerResponseKt {
    public static final <T> T a(ServerResponse<T> serverResponse) {
        Intrinsics.f(serverResponse, "<this>");
        T b8 = serverResponse.b();
        if (b8 != null) {
            return b8;
        }
        throw new NullPointerException("Data is null. " + serverResponse);
    }
}
