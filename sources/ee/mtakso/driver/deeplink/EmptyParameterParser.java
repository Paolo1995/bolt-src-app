package ee.mtakso.driver.deeplink;

import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class EmptyParameterParser implements DeepLinkParameterParser {

    /* renamed from: a  reason: collision with root package name */
    private final DeeplinkCall f20021a;

    public EmptyParameterParser(DeeplinkCall call) {
        Intrinsics.f(call, "call");
        this.f20021a = call;
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall a(Intent intent) {
        Intrinsics.f(intent, "intent");
        return null;
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    public DeeplinkCall b(Uri uri) {
        Intrinsics.f(uri, "uri");
        return this.f20021a;
    }
}
