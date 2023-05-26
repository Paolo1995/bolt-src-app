package io.ktor.client.plugins.logging;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.LoggerFactory;

/* compiled from: LoggerJvm.kt */
/* loaded from: classes5.dex */
public final class LoggerJvmKt {
    public static final Logger a(Logger.Companion companion) {
        Intrinsics.f(companion, "<this>");
        return new Logger() { // from class: io.ktor.client.plugins.logging.LoggerJvmKt$DEFAULT$1

            /* renamed from: b  reason: collision with root package name */
            private final org.slf4j.Logger f46534b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                org.slf4j.Logger i8 = LoggerFactory.i(HttpClient.class);
                Intrinsics.c(i8);
                this.f46534b = i8;
            }

            @Override // io.ktor.client.plugins.logging.Logger
            public void log(String message) {
                Intrinsics.f(message, "message");
                this.f46534b.info(message);
            }
        };
    }
}
