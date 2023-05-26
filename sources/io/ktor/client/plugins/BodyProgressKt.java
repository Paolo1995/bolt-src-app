package io.ktor.client.plugins;

import io.ktor.client.plugins.observer.DelegatedCallKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.utils.ByteChannelUtilsKt;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodyProgress.kt */
/* loaded from: classes5.dex */
public final class BodyProgressKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<Function3<Long, Long, Continuation<? super Unit>, Object>> f46238a = new AttributeKey<>("UploadProgressListenerAttributeKey");

    /* renamed from: b  reason: collision with root package name */
    private static final AttributeKey<Function3<Long, Long, Continuation<? super Unit>, Object>> f46239b = new AttributeKey<>("DownloadProgressListenerAttributeKey");

    public static final HttpResponse c(HttpResponse httpResponse, Function3<? super Long, ? super Long, ? super Continuation<? super Unit>, ? extends Object> listener) {
        Intrinsics.f(httpResponse, "<this>");
        Intrinsics.f(listener, "listener");
        return DelegatedCallKt.b(httpResponse, ByteChannelUtilsKt.a(httpResponse.a(), httpResponse.j(), HttpMessagePropertiesKt.c(httpResponse), listener));
    }
}
