package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: HttpClientPlugin.kt */
/* loaded from: classes5.dex */
public interface HttpClientPlugin<TConfig, TPlugin> {
    void a(TPlugin tplugin, HttpClient httpClient);

    TPlugin b(Function1<? super TConfig, Unit> function1);

    AttributeKey<TPlugin> getKey();
}
