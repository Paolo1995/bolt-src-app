package eu.bolt.android.engine.html;

import android.content.Context;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.logger.Logger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.ccil.cowan.tagsoup.HTMLSchema;

/* compiled from: DesignHtmlEngine.kt */
/* loaded from: classes5.dex */
public final class DesignHtmlEngine implements HtmlEngine {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f36734d = new Companion(null);

    /* renamed from: e  reason: collision with root package name */
    private static final Lazy<HTMLSchema> f36735e = LazyKt.b(new Function0<HTMLSchema>() { // from class: eu.bolt.android.engine.html.DesignHtmlEngine$Companion$schema$2
        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final HTMLSchema invoke() {
            return new HTMLSchema();
        }
    });

    /* renamed from: a  reason: collision with root package name */
    private final HtmlFontMapper f36736a;

    /* renamed from: b  reason: collision with root package name */
    private final Logger f36737b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f36738c;

    /* compiled from: DesignHtmlEngine.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final HTMLSchema b() {
            return (HTMLSchema) DesignHtmlEngine.f36735e.getValue();
        }
    }

    public DesignHtmlEngine(Context context, HtmlFontMapper mapper, Logger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(mapper, "mapper");
        Intrinsics.f(logger, "logger");
        this.f36736a = mapper;
        this.f36737b = logger;
        this.f36738c = context.getApplicationContext();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x000e  */
    @Override // eu.bolt.android.engine.html.HtmlEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.CharSequence a(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 == 0) goto Lb
            boolean r0 = kotlin.text.StringsKt.y(r8)
            if (r0 == 0) goto L9
            goto Lb
        L9:
            r0 = 0
            goto Lc
        Lb:
            r0 = 1
        Lc:
            if (r0 == 0) goto L1c
            if (r8 != 0) goto L12
            java.lang.String r8 = ""
        L12:
            android.text.SpannableString r8 = android.text.SpannableString.valueOf(r8)
            java.lang.String r0 = "valueOf(source ?: \"\")"
            kotlin.jvm.internal.Intrinsics.e(r8, r0)
            return r8
        L1c:
            boolean r0 = r7.c(r8)
            if (r0 != 0) goto L23
            return r8
        L23:
            org.ccil.cowan.tagsoup.Parser r4 = new org.ccil.cowan.tagsoup.Parser
            r4.<init>()
            eu.bolt.android.engine.html.DesignHtmlEngine$Companion r0 = eu.bolt.android.engine.html.DesignHtmlEngine.f36734d
            org.ccil.cowan.tagsoup.HTMLSchema r0 = eu.bolt.android.engine.html.DesignHtmlEngine.Companion.a(r0)
            java.lang.String r1 = "http://www.ccil.org/~cowan/tagsoup/properties/schema"
            r4.setProperty(r1, r0)
            eu.bolt.android.engine.html.DesignHtmlSpanBuilder r3 = new eu.bolt.android.engine.html.DesignHtmlSpanBuilder
            r3.<init>(r8, r7)
            eu.bolt.android.engine.html.converter.DesignHtmlConverter r8 = new eu.bolt.android.engine.html.converter.DesignHtmlConverter
            android.content.Context r2 = r7.f36738c
            java.lang.String r0 = "appContext"
            kotlin.jvm.internal.Intrinsics.e(r2, r0)
            eu.bolt.android.engine.html.font.HtmlFontMapper r5 = r7.f36736a
            eu.bolt.android.engine.html.logger.Logger r6 = r7.f36737b
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r6)
            android.text.Spanned r8 = r8.g()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.bolt.android.engine.html.DesignHtmlEngine.a(java.lang.String):java.lang.CharSequence");
    }

    public final boolean c(String source) {
        int a02;
        int a03;
        Intrinsics.f(source, "source");
        a02 = StringsKt__StringsKt.a0(source, '<', 0, false, 6, null);
        if (a02 < 0) {
            return false;
        }
        a03 = StringsKt__StringsKt.a0(source, '>', a02 + 1, false, 4, null);
        if (a03 < 0) {
            return false;
        }
        return true;
    }
}
