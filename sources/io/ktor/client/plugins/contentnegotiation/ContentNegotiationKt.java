package io.ktor.client.plugins.contentnegotiation;

import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: ContentNegotiation.kt */
/* loaded from: classes5.dex */
public final class ContentNegotiationKt {

    /* renamed from: a  reason: collision with root package name */
    private static final Set<KClass<?>> f46493a;

    static {
        Set<KClass<?>> f8;
        f8 = SetsKt__SetsKt.f(Reflection.b(byte[].class), Reflection.b(String.class), Reflection.b(HttpStatusCode.class), Reflection.b(ByteReadChannel.class), Reflection.b(OutgoingContent.class));
        f46493a = f8;
    }

    public static final Set<KClass<?>> a() {
        return f46493a;
    }
}
