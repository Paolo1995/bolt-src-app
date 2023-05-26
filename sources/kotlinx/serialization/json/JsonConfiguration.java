package kotlinx.serialization.json;

import j$.util.Spliterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: JsonConfiguration.kt */
/* loaded from: classes5.dex */
public final class JsonConfiguration {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f52323a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f52324b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f52325c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f52326d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f52327e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f52328f;

    /* renamed from: g  reason: collision with root package name */
    private final String f52329g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f52330h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f52331i;

    /* renamed from: j  reason: collision with root package name */
    private final String f52332j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f52333k;

    /* renamed from: l  reason: collision with root package name */
    private final boolean f52334l;

    public JsonConfiguration() {
        this(false, false, false, false, false, false, null, false, false, null, false, false, 4095, null);
    }

    public JsonConfiguration(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String prettyPrintIndent, boolean z13, boolean z14, String classDiscriminator, boolean z15, boolean z16) {
        Intrinsics.f(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.f(classDiscriminator, "classDiscriminator");
        this.f52323a = z7;
        this.f52324b = z8;
        this.f52325c = z9;
        this.f52326d = z10;
        this.f52327e = z11;
        this.f52328f = z12;
        this.f52329g = prettyPrintIndent;
        this.f52330h = z13;
        this.f52331i = z14;
        this.f52332j = classDiscriminator;
        this.f52333k = z15;
        this.f52334l = z16;
    }

    public final boolean a() {
        return this.f52333k;
    }

    public final boolean b() {
        return this.f52326d;
    }

    public final String c() {
        return this.f52332j;
    }

    public final boolean d() {
        return this.f52330h;
    }

    public final boolean e() {
        return this.f52323a;
    }

    public final boolean f() {
        return this.f52328f;
    }

    public final boolean g() {
        return this.f52324b;
    }

    public final boolean h() {
        return this.f52327e;
    }

    public final String i() {
        return this.f52329g;
    }

    public final boolean j() {
        return this.f52334l;
    }

    public final boolean k() {
        return this.f52331i;
    }

    public final boolean l() {
        return this.f52325c;
    }

    public String toString() {
        return "JsonConfiguration(encodeDefaults=" + this.f52323a + ", ignoreUnknownKeys=" + this.f52324b + ", isLenient=" + this.f52325c + ", allowStructuredMapKeys=" + this.f52326d + ", prettyPrint=" + this.f52327e + ", explicitNulls=" + this.f52328f + ", prettyPrintIndent='" + this.f52329g + "', coerceInputValues=" + this.f52330h + ", useArrayPolymorphism=" + this.f52331i + ", classDiscriminator='" + this.f52332j + "', allowSpecialFloatingPointValues=" + this.f52333k + ')';
    }

    public /* synthetic */ JsonConfiguration(boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, String str, boolean z13, boolean z14, String str2, boolean z15, boolean z16, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7, (i8 & 2) != 0 ? false : z8, (i8 & 4) != 0 ? false : z9, (i8 & 8) != 0 ? false : z10, (i8 & 16) != 0 ? false : z11, (i8 & 32) != 0 ? true : z12, (i8 & 64) != 0 ? "    " : str, (i8 & 128) != 0 ? false : z13, (i8 & Spliterator.NONNULL) != 0 ? false : z14, (i8 & 512) != 0 ? "type" : str2, (i8 & Spliterator.IMMUTABLE) == 0 ? z15 : false, (i8 & 2048) == 0 ? z16 : true);
    }
}
