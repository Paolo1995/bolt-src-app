package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpClientPlugin.kt */
/* loaded from: classes5.dex */
public final class HttpClientPluginKt {

    /* renamed from: a  reason: collision with root package name */
    private static final AttributeKey<Attributes> f46320a = new AttributeKey<>("ApplicationPluginRegistry");

    public static final AttributeKey<Attributes> a() {
        return f46320a;
    }

    public static final <B, F> F b(HttpClient httpClient, HttpClientPlugin<? extends B, F> plugin) {
        Intrinsics.f(httpClient, "<this>");
        Intrinsics.f(plugin, "plugin");
        F f8 = (F) c(httpClient, plugin);
        if (f8 != null) {
            return f8;
        }
        throw new IllegalStateException("Plugin " + plugin + " is not installed. Consider using `install(" + plugin.getKey() + ")` in client config first.");
    }

    public static final <B, F> F c(HttpClient httpClient, HttpClientPlugin<? extends B, F> plugin) {
        Intrinsics.f(httpClient, "<this>");
        Intrinsics.f(plugin, "plugin");
        Attributes attributes = (Attributes) httpClient.getAttributes().f(f46320a);
        if (attributes != null) {
            return (F) attributes.f(plugin.getKey());
        }
        return null;
    }
}
