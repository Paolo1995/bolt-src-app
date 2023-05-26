package io.ktor.client.plugins.logging;

import io.ktor.util.AttributeKey;
import kotlin.Unit;

/* compiled from: Logging.kt */
/* loaded from: classes5.dex */
public final class LoggingKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<HttpClientCallLogger> f46567a = new AttributeKey<>("CallLogger");

    /* renamed from: b  reason: collision with root package name */
    private static final AttributeKey<Unit> f46568b = new AttributeKey<>("DisableLogging");
}
