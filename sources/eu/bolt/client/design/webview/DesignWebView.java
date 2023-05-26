package eu.bolt.client.design.webview;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.WebView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class DesignWebView extends WebView {

    /* renamed from: f  reason: collision with root package name */
    public static final a f40263f = new a(null);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Context a(Context context) {
            if (Build.VERSION.SDK_INT <= 22) {
                Context createConfigurationContext = context.createConfigurationContext(new Configuration());
                Intrinsics.e(createConfigurationContext, "{\n                contex…guration())\n            }");
                return createConfigurationContext;
            }
            return context;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesignWebView(Context context, AttributeSet attributeSet) {
        super(f40263f.a(context), attributeSet);
        Intrinsics.f(context, "context");
    }
}
