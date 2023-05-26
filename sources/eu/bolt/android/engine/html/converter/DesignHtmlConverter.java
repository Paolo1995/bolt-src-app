package eu.bolt.android.engine.html.converter;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ParagraphStyle;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import eu.bolt.android.engine.html.DesignHtmlSpanBuilder;
import eu.bolt.android.engine.html.font.HtmlFontMapper;
import eu.bolt.android.engine.html.font.HtmlFontStyle;
import eu.bolt.android.engine.html.font.NativeFontStyle;
import eu.bolt.android.engine.html.logger.Logger;
import eu.bolt.android.engine.html.parser.ColorParser;
import eu.bolt.android.engine.html.span.ClickableUrlSpan;
import eu.bolt.android.engine.html.span.FontLineHeightSpan;
import eu.bolt.android.engine.html.span.FontSpan;
import eu.bolt.android.engine.html.span.SemiboldSpan;
import eu.bolt.android.engine.html.span.time.TimeData;
import eu.bolt.android.engine.html.span.time.TimeValueFormatter;
import eu.bolt.android.engine.html.span.timer.TimerData;
import eu.bolt.android.engine.html.span.timer.TimerSpan;
import eu.bolt.android.engine.html.span.timer.TimerValueFormatter;
import eu.bolt.android.engine.html.span.timer.TypeTimer;
import eu.bolt.android.engine.html.util.ContextExtKt;
import java.io.StringReader;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt___StringsKt;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.XMLReader;

/* compiled from: DesignHtmlConverter.kt */
/* loaded from: classes5.dex */
public final class DesignHtmlConverter implements ContentHandler {

    /* renamed from: f  reason: collision with root package name */
    public static final Companion f36826f = new Companion(null);

    /* renamed from: g  reason: collision with root package name */
    private static final Lazy<Pattern> f36827g;

    /* renamed from: h  reason: collision with root package name */
    private static final Lazy<Pattern> f36828h;

    /* renamed from: i  reason: collision with root package name */
    private static final Lazy<Pattern> f36829i;

    /* renamed from: a  reason: collision with root package name */
    private final Context f36830a;

    /* renamed from: b  reason: collision with root package name */
    private final DesignHtmlSpanBuilder f36831b;

    /* renamed from: c  reason: collision with root package name */
    private final XMLReader f36832c;

    /* renamed from: d  reason: collision with root package name */
    private final HtmlFontMapper f36833d;

    /* renamed from: e  reason: collision with root package name */
    private final Logger f36834e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Alignment {

        /* renamed from: a  reason: collision with root package name */
        private final Layout.Alignment f36835a;

        public Alignment(Layout.Alignment alignment) {
            Intrinsics.f(alignment, "alignment");
            this.f36835a = alignment;
        }

        public final Layout.Alignment a() {
            return this.f36835a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Background {

        /* renamed from: a  reason: collision with root package name */
        private final int f36836a;

        public Background(int i8) {
            this.f36836a = i8;
        }

        public final int a() {
            return this.f36836a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Bold {
    }

    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pattern d() {
            Object value = DesignHtmlConverter.f36829i.getValue();
            Intrinsics.e(value, "<get-backgroundColorPattern>(...)");
            return (Pattern) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pattern e() {
            Object value = DesignHtmlConverter.f36828h.getValue();
            Intrinsics.e(value, "<get-foregroundColorPattern>(...)");
            return (Pattern) value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Pattern f() {
            Object value = DesignHtmlConverter.f36827g.getValue();
            Intrinsics.e(value, "<get-textAlignPattern>(...)");
            return (Pattern) value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public final class Font {

        /* renamed from: a  reason: collision with root package name */
        private final NativeFontStyle f36840a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ DesignHtmlConverter f36841b;

        public Font(DesignHtmlConverter this$0, NativeFontStyle nativeFontStyle) {
            Intrinsics.f(this$0, "this$0");
            Intrinsics.f(nativeFontStyle, "nativeFontStyle");
            this.f36841b = this$0;
            this.f36840a = nativeFontStyle;
        }

        public final float a() {
            return b() + ContextExtKt.a(this.f36841b.f36830a, this.f36840a.a());
        }

        public final float b() {
            return ContextExtKt.a(this.f36841b.f36830a, this.f36840a.c());
        }

        public final NativeFontStyle c() {
            return this.f36840a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Foreground {

        /* renamed from: a  reason: collision with root package name */
        private final int f36842a;

        public Foreground(int i8) {
            this.f36842a = i8;
        }

        public final int a() {
            return this.f36842a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Href {

        /* renamed from: a  reason: collision with root package name */
        private final String f36843a;

        public Href(String str) {
            this.f36843a = str;
        }

        public final String a() {
            return this.f36843a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Italic {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Monospace {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Newline {

        /* renamed from: a  reason: collision with root package name */
        private final int f36844a;

        public Newline(int i8) {
            this.f36844a = i8;
        }

        public final int a() {
            return this.f36844a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Paragraph {

        /* renamed from: a  reason: collision with root package name */
        private float f36845a;

        /* renamed from: b  reason: collision with root package name */
        private float f36846b;

        public Paragraph(float f8, float f9) {
            this.f36845a = f8;
            this.f36846b = f9;
        }

        public final float a() {
            return this.f36845a;
        }

        public final float b() {
            return this.f36846b;
        }

        public final void c(float f8) {
            this.f36845a = f8;
        }

        public final void d(float f8) {
            this.f36846b = f8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Strikeout {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Time {

        /* renamed from: a  reason: collision with root package name */
        private final Long f36847a;

        /* renamed from: b  reason: collision with root package name */
        private final String f36848b;

        /* renamed from: c  reason: collision with root package name */
        private final String f36849c;

        public Time(Long l8, String str, String str2) {
            this.f36847a = l8;
            this.f36848b = str;
            this.f36849c = str2;
        }

        public final String a() {
            return this.f36849c;
        }

        public final String b() {
            return this.f36848b;
        }

        public final Long c() {
            return this.f36847a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Timer {

        /* renamed from: a  reason: collision with root package name */
        private final Long f36850a;

        /* renamed from: b  reason: collision with root package name */
        private final String f36851b;

        /* renamed from: c  reason: collision with root package name */
        private final TypeTimer f36852c;

        /* renamed from: d  reason: collision with root package name */
        private final String f36853d;

        /* renamed from: e  reason: collision with root package name */
        private final String f36854e;

        /* renamed from: f  reason: collision with root package name */
        private final String f36855f;

        /* renamed from: g  reason: collision with root package name */
        private final String f36856g;

        /* renamed from: h  reason: collision with root package name */
        private final String f36857h;

        public Timer(Long l8, String str, TypeTimer typeTimer, String str2, String str3, String str4, String str5, String str6) {
            this.f36850a = l8;
            this.f36851b = str;
            this.f36852c = typeTimer;
            this.f36853d = str2;
            this.f36854e = str3;
            this.f36855f = str4;
            this.f36856g = str5;
            this.f36857h = str6;
        }

        public final String a() {
            return this.f36853d;
        }

        public final String b() {
            return this.f36854e;
        }

        public final String c() {
            return this.f36851b;
        }

        public final String d() {
            return this.f36857h;
        }

        public final String e() {
            return this.f36856g;
        }

        public final String f() {
            return this.f36855f;
        }

        public final Long g() {
            return this.f36850a;
        }

        public final TypeTimer h() {
            return this.f36852c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Underline {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public static final class Uppercase {
    }

    /* compiled from: DesignHtmlConverter.kt */
    /* loaded from: classes5.dex */
    public /* synthetic */ class WhenMappings {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36858a;

        static {
            int[] iArr = new int[HtmlFontStyle.values().length];
            iArr[HtmlFontStyle.BODY_XS.ordinal()] = 1;
            iArr[HtmlFontStyle.BODY_S.ordinal()] = 2;
            iArr[HtmlFontStyle.BODY_M.ordinal()] = 3;
            iArr[HtmlFontStyle.BODY_L.ordinal()] = 4;
            iArr[HtmlFontStyle.HEADING_S_REGULAR.ordinal()] = 5;
            iArr[HtmlFontStyle.HEADING_XS_REGULAR.ordinal()] = 6;
            iArr[HtmlFontStyle.BODY_SEMIBOLD_XS.ordinal()] = 7;
            iArr[HtmlFontStyle.BODY_SEMIBOLD_S.ordinal()] = 8;
            iArr[HtmlFontStyle.BODY_SEMIBOLD_M.ordinal()] = 9;
            iArr[HtmlFontStyle.BODY_SEMIBOLD_L.ordinal()] = 10;
            iArr[HtmlFontStyle.HEADING_XS.ordinal()] = 11;
            iArr[HtmlFontStyle.HEADING_S.ordinal()] = 12;
            iArr[HtmlFontStyle.HEADING_M.ordinal()] = 13;
            iArr[HtmlFontStyle.HEADING_L.ordinal()] = 14;
            iArr[HtmlFontStyle.STORY_HEADLINE.ordinal()] = 15;
            iArr[HtmlFontStyle.CAPS_S.ordinal()] = 16;
            iArr[HtmlFontStyle.CAPS_M.ordinal()] = 17;
            iArr[HtmlFontStyle.CAPS_L.ordinal()] = 18;
            f36858a = iArr;
        }
    }

    static {
        Lazy<Pattern> b8;
        Lazy<Pattern> b9;
        Lazy<Pattern> b10;
        b8 = LazyKt__LazyJVMKt.b(new Function0<Pattern>() { // from class: eu.bolt.android.engine.html.converter.DesignHtmlConverter$Companion$textAlignPattern$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Pattern invoke() {
                return Pattern.compile("text-align\\s*:\\s*(\\S*)\\b");
            }
        });
        f36827g = b8;
        b9 = LazyKt__LazyJVMKt.b(new Function0<Pattern>() { // from class: eu.bolt.android.engine.html.converter.DesignHtmlConverter$Companion$foregroundColorPattern$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Pattern invoke() {
                return Pattern.compile("color\\s*:\\s*(\\S*)\\b");
            }
        });
        f36828h = b9;
        b10 = LazyKt__LazyJVMKt.b(new Function0<Pattern>() { // from class: eu.bolt.android.engine.html.converter.DesignHtmlConverter$Companion$backgroundColorPattern$2
            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b */
            public final Pattern invoke() {
                return Pattern.compile("background\\s*:\\s*(\\S*)\\b");
            }
        });
        f36829i = b10;
    }

    public DesignHtmlConverter(Context context, DesignHtmlSpanBuilder spanBuilder, XMLReader reader, HtmlFontMapper htmlFontMapper, Logger logger) {
        Intrinsics.f(context, "context");
        Intrinsics.f(spanBuilder, "spanBuilder");
        Intrinsics.f(reader, "reader");
        Intrinsics.f(htmlFontMapper, "htmlFontMapper");
        Intrinsics.f(logger, "logger");
        this.f36830a = context;
        this.f36831b = spanBuilder;
        this.f36832c = reader;
        this.f36833d = htmlFontMapper;
        this.f36834e = logger;
    }

    private final void A(Editable editable, Attributes attributes) {
        Integer b8;
        Integer b9;
        String value = attributes.getValue("", "style");
        if (value != null) {
            Companion companion = f36826f;
            Matcher matcher = companion.e().matcher(value);
            if (matcher.find() && (b9 = ColorParser.b(ColorParser.f36879a, matcher.group(1), this.f36834e, 0, 4, null)) != null) {
                F(editable, new Foreground(b9.intValue()));
            }
            Matcher matcher2 = companion.d().matcher(value);
            if (matcher2.find() && (b8 = ColorParser.b(ColorParser.f36879a, matcher2.group(1), this.f36834e, 0, 4, null)) != null) {
                F(editable, new Background(b8.intValue()));
            }
        }
    }

    private final void B(Editable editable, Attributes attributes) {
        HtmlFontStyle q8;
        Integer b8;
        String value = attributes.getValue("", "color");
        String value2 = attributes.getValue("", "name");
        if (!TextUtils.isEmpty(value) && (b8 = ColorParser.b(ColorParser.f36879a, value, this.f36834e, 0, 4, null)) != null) {
            F(editable, new Foreground(b8.intValue()));
        }
        if (value2 == null) {
            q8 = null;
        } else {
            q8 = q(value2);
        }
        if (q8 != null) {
            Font font = new Font(this, this.f36833d.a(q8));
            F(editable, font);
            I(editable, font);
            if (u(q8)) {
                F(editable, new Bold());
            }
            if (v(q8)) {
                F(editable, new Uppercase());
            }
        }
    }

    private final void C(Editable editable) {
        Object V;
        Object[] spans = editable.getSpans(0, editable.length(), Bold.class);
        Object obj = null;
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Bold bold = (Bold) V;
        if (bold != null) {
            SemiboldSpan semiboldSpan = new SemiboldSpan(this.f36830a);
            Object[] spans2 = editable.getSpans(0, editable.length(), Bold.class);
            if (spans2 != null) {
                obj = ArraysKt___ArraysKt.V(spans2);
            }
            if (obj != null) {
                w(editable, obj, semiboldSpan);
            }
            obj = bold;
        }
        F(editable, new Italic());
        if (obj != null) {
            F(editable, new Bold());
        }
    }

    private final void D(Editable editable, float f8, float f9) {
        F(editable, new Paragraph(f8, f9));
    }

    static /* synthetic */ void E(DesignHtmlConverter designHtmlConverter, Editable editable, float f8, float f9, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            f8 = 0.0f;
        }
        if ((i8 & 4) != 0) {
            f9 = 0.0f;
        }
        designHtmlConverter.D(editable, f8, f9);
    }

    private final void F(Editable editable, Object obj) {
        int length = editable.length();
        editable.setSpan(obj, length, length, 17);
    }

    private final void G(Editable editable, Attributes attributes) {
        Long o8;
        String value = attributes.getValue("timestamp");
        if (value == null) {
            o8 = null;
        } else {
            o8 = StringsKt__StringNumberConversionsKt.o(value);
        }
        F(editable, new Time(o8, attributes.getValue("format"), attributes.getValue("amformat")));
    }

    private final void H(Editable editable, Attributes attributes) {
        Long o8;
        Long l8;
        TypeTimer typeTimer;
        String value = attributes.getValue("timestamp");
        if (value == null) {
            l8 = null;
        } else {
            o8 = StringsKt__StringNumberConversionsKt.o(value);
            l8 = o8;
        }
        String value2 = attributes.getValue("format");
        String value3 = attributes.getValue("countdownendtext");
        String value4 = attributes.getValue("lessthanminuteformat");
        String value5 = attributes.getValue("lessthanhourformat");
        String value6 = attributes.getValue("lessthandayformat");
        String value7 = attributes.getValue("fallback");
        String value8 = attributes.getValue("type");
        TypeTimer[] values = TypeTimer.values();
        int length = values.length;
        int i8 = 0;
        while (true) {
            if (i8 < length) {
                TypeTimer typeTimer2 = values[i8];
                if (Intrinsics.a(typeTimer2.c(), value8)) {
                    typeTimer = typeTimer2;
                    break;
                }
                i8++;
            } else {
                typeTimer = null;
                break;
            }
        }
        F(editable, new Timer(l8, value2, typeTimer, value3, value7, value4, value5, value6));
    }

    private final void I(Editable editable, Font font) {
        Object V;
        Object[] spans = editable.getSpans(0, editable.length(), Paragraph.class);
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Paragraph paragraph = (Paragraph) V;
        if (paragraph == null) {
            return;
        }
        float a8 = font.a();
        if (a8 > paragraph.a()) {
            paragraph.c(a8);
            paragraph.d(font.b());
        }
    }

    private final void f(Editable editable, int i8) {
        int length = editable.length();
        if (length == 0) {
            return;
        }
        int i9 = 0;
        for (int i10 = length - 1; i10 >= 0 && editable.charAt(i10) == '\n'; i10--) {
            i9++;
        }
        if (i9 < i8) {
            do {
                i9++;
                editable.append("\n");
            } while (i9 < i8);
        }
    }

    private final void h(Editable editable) {
        Object V;
        String a8;
        Object[] spans = editable.getSpans(0, editable.length(), Href.class);
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Href href = (Href) V;
        if (href == null || (a8 = href.a()) == null) {
            return;
        }
        w(editable, href, new ClickableUrlSpan(a8));
    }

    private final void i(Editable editable) {
        Object V;
        Object[] spans = editable.getSpans(0, editable.length(), Newline.class);
        Object obj = null;
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Newline newline = (Newline) V;
        if (newline != null) {
            f(editable, newline.a());
            editable.removeSpan(newline);
        }
        m(editable);
        Object[] spans2 = editable.getSpans(0, editable.length(), Alignment.class);
        if (spans2 != null) {
            obj = ArraysKt___ArraysKt.V(spans2);
        }
        Alignment alignment = (Alignment) obj;
        if (alignment != null) {
            w(editable, alignment, new AlignmentSpan.Standard(alignment.a()));
        }
    }

    private final void j(Editable editable) {
        Object V;
        Object V2;
        Object[] spans = editable.getSpans(0, editable.length(), Strikeout.class);
        Object obj = null;
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Object obj2 = (Strikeout) V;
        if (obj2 != null) {
            w(editable, obj2, new StrikethroughSpan());
        }
        Object[] spans2 = editable.getSpans(0, editable.length(), Background.class);
        if (spans2 == null) {
            V2 = null;
        } else {
            V2 = ArraysKt___ArraysKt.V(spans2);
        }
        Background background = (Background) V2;
        if (background != null) {
            w(editable, background, new BackgroundColorSpan(background.a()));
        }
        Object[] spans3 = editable.getSpans(0, editable.length(), Foreground.class);
        if (spans3 != null) {
            obj = ArraysKt___ArraysKt.V(spans3);
        }
        Foreground foreground = (Foreground) obj;
        if (foreground != null) {
            w(editable, foreground, new ForegroundColorSpan(foreground.a()));
        }
    }

    private final void k(Editable editable) {
        Object V;
        Object V2;
        Object V3;
        Object[] spans = editable.getSpans(0, editable.length(), Uppercase.class);
        Object obj = null;
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Object obj2 = (Uppercase) V;
        if (obj2 != null) {
            x(editable, obj2);
        }
        Object[] spans2 = editable.getSpans(0, editable.length(), Bold.class);
        if (spans2 == null) {
            V2 = null;
        } else {
            V2 = ArraysKt___ArraysKt.V(spans2);
        }
        Object obj3 = (Bold) V2;
        if (obj3 != null) {
            w(editable, obj3, new SemiboldSpan(this.f36830a));
        }
        Object[] spans3 = editable.getSpans(0, editable.length(), Font.class);
        if (spans3 == null) {
            V3 = null;
        } else {
            V3 = ArraysKt___ArraysKt.V(spans3);
        }
        Font font = (Font) V3;
        if (font != null) {
            w(editable, font, new FontSpan(this.f36830a, font.c()));
        }
        Object[] spans4 = editable.getSpans(0, editable.length(), Foreground.class);
        if (spans4 != null) {
            obj = ArraysKt___ArraysKt.V(spans4);
        }
        Foreground foreground = (Foreground) obj;
        if (foreground != null) {
            w(editable, foreground, new ForegroundColorSpan(foreground.a()));
        }
    }

    private final void l(Editable editable) {
        Object V;
        Object V2;
        Object[] spans = editable.getSpans(0, editable.length(), Bold.class);
        Object obj = null;
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Bold bold = (Bold) V;
        if (bold == null) {
            bold = null;
        } else {
            SemiboldSpan semiboldSpan = new SemiboldSpan(this.f36830a);
            Object[] spans2 = editable.getSpans(0, editable.length(), Bold.class);
            if (spans2 == null) {
                V2 = null;
            } else {
                V2 = ArraysKt___ArraysKt.V(spans2);
            }
            if (V2 != null) {
                w(editable, V2, semiboldSpan);
            }
        }
        StyleSpan styleSpan = new StyleSpan(2);
        Object[] spans3 = editable.getSpans(0, editable.length(), Italic.class);
        if (spans3 != null) {
            obj = ArraysKt___ArraysKt.V(spans3);
        }
        if (obj != null) {
            w(editable, obj, styleSpan);
        }
        if (bold != null) {
            F(editable, bold);
        }
    }

    private final void m(Editable editable) {
        Object V;
        Object[] spans = editable.getSpans(0, editable.length(), Paragraph.class);
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Paragraph paragraph = (Paragraph) V;
        if (paragraph != null && paragraph.a() > 0.0f) {
            w(editable, paragraph, new FontLineHeightSpan(paragraph.b()));
        }
    }

    private final void n(Editable editable) {
        Object V;
        Object[] spans = editable.getSpans(0, editable.length(), Time.class);
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Time time = (Time) V;
        if (time == null) {
            return;
        }
        editable.delete(editable.getSpanStart(time), editable.length());
        if (time.c() != null && time.b() != null) {
            editable.append(TimeValueFormatter.f36896a.a(new TimeData(TimeUnit.SECONDS.toMillis(time.c().longValue()), time.b(), time.a()), this.f36830a));
            editable.removeSpan(time);
        }
    }

    private final void o(Editable editable) {
        Object V;
        boolean y7;
        boolean z7 = false;
        Object[] spans = editable.getSpans(0, editable.length(), Timer.class);
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Timer timer = (Timer) V;
        if (timer == null) {
            return;
        }
        int spanStart = editable.getSpanStart(timer);
        editable.delete(spanStart, editable.length());
        if (timer.g() != null && timer.c() != null && timer.h() != null) {
            TimerData timerData = new TimerData(TimeUnit.SECONDS.toMillis(timer.g().longValue()), timer.c(), timer.h(), timer.a(), timer.f(), timer.e(), timer.d());
            editable.append(TimerValueFormatter.f36914a.a(timerData));
            Object timerSpan = new TimerSpan(timerData);
            editable.removeSpan(timer);
            editable.setSpan(timerSpan, spanStart, editable.length(), 17);
            return;
        }
        String b8 = timer.b();
        if (b8 != null) {
            y7 = StringsKt__StringsJVMKt.y(b8);
            if (!y7) {
                z7 = true;
            }
        }
        if (z7) {
            editable.append(timer.b());
        }
    }

    private final Pair<Float, Float> p(Editable editable) {
        Object V;
        Object[] spans = editable.getSpans(0, editable.length(), Paragraph.class);
        Pair<Float, Float> pair = null;
        if (spans == null) {
            V = null;
        } else {
            V = ArraysKt___ArraysKt.V(spans);
        }
        Paragraph paragraph = (Paragraph) V;
        if (paragraph != null) {
            pair = TuplesKt.a(Float.valueOf(paragraph.a()), Float.valueOf(paragraph.b()));
        }
        if (pair == null) {
            return TuplesKt.a(Float.valueOf(0.0f), Float.valueOf(0.0f));
        }
        return pair;
    }

    private final HtmlFontStyle q(String str) {
        HtmlFontStyle[] values;
        for (HtmlFontStyle htmlFontStyle : HtmlFontStyle.values()) {
            if (Intrinsics.a(htmlFontStyle.c(), str)) {
                return htmlFontStyle;
            }
        }
        return null;
    }

    private final void r(Editable editable) {
        Pair<Float, Float> p8 = p(editable);
        float floatValue = p8.a().floatValue();
        float floatValue2 = p8.b().floatValue();
        editable.append('\n');
        m(editable);
        D(editable, floatValue, floatValue2);
    }

    private final void s(String str) {
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.e(ENGLISH, "ENGLISH");
        if (str != null) {
            String lowerCase = str.toLowerCase(ENGLISH);
            Intrinsics.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            Object obj = null;
            switch (lowerCase.hashCode()) {
                case -891985998:
                    if (lowerCase.equals("strike")) {
                        DesignHtmlSpanBuilder designHtmlSpanBuilder = this.f36831b;
                        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                        Object[] spans = designHtmlSpanBuilder.getSpans(0, designHtmlSpanBuilder.length(), Strikeout.class);
                        if (spans != null) {
                            obj = ArraysKt___ArraysKt.V(spans);
                        }
                        if (obj != null) {
                            w(designHtmlSpanBuilder, obj, strikethroughSpan);
                            return;
                        }
                        return;
                    }
                    return;
                case 97:
                    if (lowerCase.equals("a")) {
                        h(this.f36831b);
                        return;
                    }
                    return;
                case 98:
                    if (lowerCase.equals("b")) {
                        DesignHtmlSpanBuilder designHtmlSpanBuilder2 = this.f36831b;
                        SemiboldSpan semiboldSpan = new SemiboldSpan(this.f36830a);
                        Object[] spans2 = designHtmlSpanBuilder2.getSpans(0, designHtmlSpanBuilder2.length(), Bold.class);
                        if (spans2 != null) {
                            obj = ArraysKt___ArraysKt.V(spans2);
                        }
                        if (obj != null) {
                            w(designHtmlSpanBuilder2, obj, semiboldSpan);
                            return;
                        }
                        return;
                    }
                    return;
                case 105:
                    if (lowerCase.equals("i")) {
                        l(this.f36831b);
                        return;
                    }
                    return;
                case 112:
                    if (lowerCase.equals("p")) {
                        j(this.f36831b);
                        i(this.f36831b);
                        return;
                    }
                    return;
                case 117:
                    if (lowerCase.equals("u")) {
                        DesignHtmlSpanBuilder designHtmlSpanBuilder3 = this.f36831b;
                        UnderlineSpan underlineSpan = new UnderlineSpan();
                        Object[] spans3 = designHtmlSpanBuilder3.getSpans(0, designHtmlSpanBuilder3.length(), Underline.class);
                        if (spans3 != null) {
                            obj = ArraysKt___ArraysKt.V(spans3);
                        }
                        if (obj != null) {
                            w(designHtmlSpanBuilder3, obj, underlineSpan);
                            return;
                        }
                        return;
                    }
                    return;
                case 3152:
                    if (lowerCase.equals("br")) {
                        r(this.f36831b);
                        return;
                    }
                    return;
                case 3712:
                    if (lowerCase.equals("tt")) {
                        DesignHtmlSpanBuilder designHtmlSpanBuilder4 = this.f36831b;
                        TypefaceSpan typefaceSpan = new TypefaceSpan("monospace");
                        Object[] spans4 = designHtmlSpanBuilder4.getSpans(0, designHtmlSpanBuilder4.length(), Monospace.class);
                        if (spans4 != null) {
                            obj = ArraysKt___ArraysKt.V(spans4);
                        }
                        if (obj != null) {
                            w(designHtmlSpanBuilder4, obj, typefaceSpan);
                            return;
                        }
                        return;
                    }
                    return;
                case 3148879:
                    if (lowerCase.equals("font")) {
                        k(this.f36831b);
                        return;
                    }
                    return;
                case 3536714:
                    if (lowerCase.equals("span")) {
                        j(this.f36831b);
                        return;
                    }
                    return;
                case 3560141:
                    if (lowerCase.equals("time")) {
                        n(this.f36831b);
                        return;
                    }
                    return;
                case 110364485:
                    if (lowerCase.equals("timer")) {
                        o(this.f36831b);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final void t(String str, Attributes attributes) {
        Locale ENGLISH = Locale.ENGLISH;
        Intrinsics.e(ENGLISH, "ENGLISH");
        if (str != null) {
            String lowerCase = str.toLowerCase(ENGLISH);
            Intrinsics.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            switch (lowerCase.hashCode()) {
                case -891985998:
                    if (lowerCase.equals("strike")) {
                        F(this.f36831b, new Strikeout());
                        return;
                    }
                    return;
                case 97:
                    if (lowerCase.equals("a")) {
                        y(this.f36831b, attributes);
                        return;
                    }
                    return;
                case 98:
                    if (lowerCase.equals("b")) {
                        F(this.f36831b, new Bold());
                        return;
                    }
                    return;
                case 105:
                    if (lowerCase.equals("i")) {
                        C(this.f36831b);
                        return;
                    }
                    return;
                case 112:
                    if (lowerCase.equals("p")) {
                        z(this.f36831b, attributes, 1);
                        A(this.f36831b, attributes);
                        return;
                    }
                    return;
                case 117:
                    if (lowerCase.equals("u")) {
                        F(this.f36831b, new Underline());
                        return;
                    }
                    return;
                case 3712:
                    if (lowerCase.equals("tt")) {
                        F(this.f36831b, new Monospace());
                        return;
                    }
                    return;
                case 3148879:
                    if (lowerCase.equals("font")) {
                        B(this.f36831b, attributes);
                        return;
                    }
                    return;
                case 3536714:
                    if (lowerCase.equals("span")) {
                        A(this.f36831b, attributes);
                        return;
                    }
                    return;
                case 3560141:
                    if (lowerCase.equals("time")) {
                        G(this.f36831b, attributes);
                        return;
                    }
                    return;
                case 110364485:
                    if (lowerCase.equals("timer")) {
                        H(this.f36831b, attributes);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    private final boolean u(HtmlFontStyle htmlFontStyle) {
        switch (WhenMappings.f36858a[htmlFontStyle.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return false;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean v(HtmlFontStyle htmlFontStyle) {
        switch (WhenMappings.f36858a[htmlFontStyle.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return false;
            case 16:
            case 17:
            case 18:
                return true;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(Editable editable, Object obj, Object... objArr) {
        int spanStart = editable.getSpanStart(obj);
        editable.removeSpan(obj);
        int length = editable.length();
        if (spanStart != length) {
            int i8 = 0;
            int length2 = objArr.length;
            while (i8 < length2) {
                Object obj2 = objArr[i8];
                i8++;
                editable.setSpan(obj2, spanStart, length, 33);
            }
        }
    }

    private final void x(Editable editable, Object obj) {
        int spanStart = editable.getSpanStart(obj);
        editable.removeSpan(obj);
        int length = editable.length();
        if (spanStart != length) {
            Object[] spans = editable.getSpans(spanStart, length, Object.class);
            Intrinsics.e(spans, "getSpans(startIndex, endIndex, Any::class.java)");
            String obj2 = editable.subSequence(spanStart, length).toString();
            Locale locale = Locale.getDefault();
            Intrinsics.e(locale, "getDefault()");
            if (obj2 != null) {
                String upperCase = obj2.toUpperCase(locale);
                Intrinsics.e(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                SpannableString spannableString = new SpannableString(upperCase);
                int length2 = spans.length;
                int i8 = 0;
                while (i8 < length2) {
                    Object obj3 = spans[i8];
                    i8++;
                    spannableString.setSpan(obj3, editable.getSpanStart(obj3) - spanStart, editable.getSpanEnd(obj3) - spanStart, 0);
                }
                editable.replace(spanStart, length, spannableString);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void y(Editable editable, Attributes attributes) {
        F(editable, new Href(attributes.getValue("", "href")));
    }

    private final void z(Editable editable, Attributes attributes, int i8) {
        String lowerCase;
        if (i8 > 0) {
            f(editable, i8);
            F(editable, new Newline(i8));
        }
        E(this, editable, 0.0f, 0.0f, 6, null);
        String value = attributes.getValue("", "style");
        if (value != null) {
            Matcher matcher = f36826f.f().matcher(value);
            if (matcher.find()) {
                String group = matcher.group(1);
                if (group == null) {
                    lowerCase = null;
                } else {
                    Locale US = Locale.US;
                    Intrinsics.e(US, "US");
                    lowerCase = group.toLowerCase(US);
                    Intrinsics.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                }
                if (lowerCase != null) {
                    int hashCode = lowerCase.hashCode();
                    if (hashCode != -1364013995) {
                        if (hashCode != 100571) {
                            if (hashCode == 109757538 && lowerCase.equals("start")) {
                                F(editable, new Alignment(Layout.Alignment.ALIGN_NORMAL));
                            }
                        } else if (lowerCase.equals("end")) {
                            F(editable, new Alignment(Layout.Alignment.ALIGN_OPPOSITE));
                        }
                    } else if (lowerCase.equals("center")) {
                        F(editable, new Alignment(Layout.Alignment.ALIGN_CENTER));
                    }
                }
            }
        }
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] ch, int i8, int i9) {
        Character d12;
        char charValue;
        Intrinsics.f(ch, "ch");
        StringBuilder sb = new StringBuilder();
        d12 = StringsKt___StringsKt.d1(this.f36831b);
        if (d12 == null) {
            charValue = '\n';
        } else {
            charValue = d12.charValue();
        }
        int i10 = 0;
        if (i9 > 0) {
            while (true) {
                int i11 = i10 + 1;
                char c8 = ch[i10 + i8];
                if (c8 != ' ' && c8 != '\n') {
                    sb.append(c8);
                    charValue = c8;
                } else if (charValue != ' ' && charValue != '\n') {
                    sb.append(' ');
                    charValue = ' ';
                }
                if (i11 >= i9) {
                    break;
                }
                i10 = i11;
            }
        }
        this.f36831b.append((CharSequence) sb);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() {
        m(this.f36831b);
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String uri, String localName, String qName) {
        Intrinsics.f(uri, "uri");
        Intrinsics.f(localName, "localName");
        Intrinsics.f(qName, "qName");
        s(localName);
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String prefix) {
        Intrinsics.f(prefix, "prefix");
    }

    public final Spanned g() {
        this.f36832c.setContentHandler(this);
        this.f36832c.parse(new InputSource(new StringReader(this.f36831b.h())));
        DesignHtmlSpanBuilder designHtmlSpanBuilder = this.f36831b;
        int i8 = 0;
        ParagraphStyle[] paragraphStyleArr = (ParagraphStyle[]) designHtmlSpanBuilder.getSpans(0, designHtmlSpanBuilder.length(), ParagraphStyle.class);
        int length = paragraphStyleArr.length - 1;
        if (length >= 0) {
            while (true) {
                int i9 = i8 + 1;
                int spanStart = this.f36831b.getSpanStart(paragraphStyleArr[i8]);
                int spanEnd = this.f36831b.getSpanEnd(paragraphStyleArr[i8]);
                int i10 = spanEnd - 2;
                if (i10 >= 0 && this.f36831b.charAt(spanEnd - 1) == '\n' && this.f36831b.charAt(i10) == '\n') {
                    spanEnd--;
                }
                if (spanEnd == spanStart) {
                    this.f36831b.removeSpan(paragraphStyleArr[i8]);
                } else {
                    this.f36831b.setSpan(paragraphStyleArr[i8], spanStart, spanEnd, 51);
                }
                if (i9 > length) {
                    break;
                }
                i8 = i9;
            }
        }
        return this.f36831b;
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] ch, int i8, int i9) {
        Intrinsics.f(ch, "ch");
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String target, String data) {
        Intrinsics.f(target, "target");
        Intrinsics.f(data, "data");
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        Intrinsics.f(locator, "locator");
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String name) {
        Intrinsics.f(name, "name");
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() {
        E(this, this.f36831b, 0.0f, 0.0f, 6, null);
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        Intrinsics.f(uri, "uri");
        Intrinsics.f(localName, "localName");
        Intrinsics.f(qName, "qName");
        Intrinsics.f(attributes, "attributes");
        t(localName, attributes);
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String prefix, String uri) {
        Intrinsics.f(prefix, "prefix");
        Intrinsics.f(uri, "uri");
    }
}
