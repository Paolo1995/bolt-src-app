package ee.mtakso.driver.deeplink;

import android.net.Uri;
import ee.mtakso.driver.deeplink.DeeplinkCall;
import ee.mtakso.driver.ui.screens.contact_methods.chat.ChatFragment$ChatParams;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeepLinkParameterParser.kt */
/* loaded from: classes3.dex */
public final class ChatParser extends NoIntentDeeplinkParser {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f19969a = new Companion(null);

    /* compiled from: DeepLinkParameterParser.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // ee.mtakso.driver.deeplink.DeepLinkParameterParser
    /* renamed from: c */
    public DeeplinkCall.Chat b(Uri uri) {
        String str;
        String str2;
        Intrinsics.f(uri, "uri");
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            str = "";
        } else {
            str = lastPathSegment;
        }
        String queryParameter = uri.getQueryParameter("title");
        if (queryParameter == null) {
            str2 = "";
        } else {
            str2 = queryParameter;
        }
        return new DeeplinkCall.Chat(new ChatFragment$ChatParams(str, str2, uri.getQueryParameter("description"), null, 8, null));
    }
}
