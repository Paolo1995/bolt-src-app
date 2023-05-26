package io.ktor.client.utils;

import io.ktor.http.content.OutgoingContent;

/* compiled from: Content.kt */
/* loaded from: classes5.dex */
public final class EmptyContent extends OutgoingContent.NoContent {

    /* renamed from: a  reason: collision with root package name */
    public static final EmptyContent f46708a = new EmptyContent();

    /* renamed from: b  reason: collision with root package name */
    private static final long f46709b = 0;

    private EmptyContent() {
    }

    @Override // io.ktor.http.content.OutgoingContent
    public Long a() {
        return Long.valueOf(f46709b);
    }

    public String toString() {
        return "EmptyContent";
    }
}
