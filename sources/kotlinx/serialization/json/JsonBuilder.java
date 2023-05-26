package kotlinx.serialization.json;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.modules.SerializersModule;

/* compiled from: Json.kt */
/* loaded from: classes5.dex */
public final class JsonBuilder {

    /* renamed from: a  reason: collision with root package name */
    private boolean f52310a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52311b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f52312c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f52313d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f52314e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f52315f;

    /* renamed from: g  reason: collision with root package name */
    private String f52316g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52317h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f52318i;

    /* renamed from: j  reason: collision with root package name */
    private String f52319j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f52320k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f52321l;

    /* renamed from: m  reason: collision with root package name */
    private SerializersModule f52322m;

    public JsonBuilder(Json json) {
        Intrinsics.f(json, "json");
        this.f52310a = json.g().e();
        this.f52311b = json.g().f();
        this.f52312c = json.g().g();
        this.f52313d = json.g().l();
        this.f52314e = json.g().b();
        this.f52315f = json.g().h();
        this.f52316g = json.g().i();
        this.f52317h = json.g().d();
        this.f52318i = json.g().k();
        this.f52319j = json.g().c();
        this.f52320k = json.g().a();
        this.f52321l = json.g().j();
        this.f52322m = json.a();
    }

    public final JsonConfiguration a() {
        if (this.f52318i && !Intrinsics.a(this.f52319j, "type")) {
            throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
        }
        if (!this.f52315f) {
            if (!Intrinsics.a(this.f52316g, "    ")) {
                throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
            }
        } else if (!Intrinsics.a(this.f52316g, "    ")) {
            String str = this.f52316g;
            boolean z7 = false;
            int i8 = 0;
            while (true) {
                boolean z8 = true;
                if (i8 < str.length()) {
                    char charAt = str.charAt(i8);
                    if (charAt != ' ' && charAt != '\t' && charAt != '\r' && charAt != '\n') {
                        z8 = false;
                    }
                    if (!z8) {
                        break;
                    }
                    i8++;
                } else {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f52316g).toString());
            }
        }
        return new JsonConfiguration(this.f52310a, this.f52312c, this.f52313d, this.f52314e, this.f52315f, this.f52311b, this.f52316g, this.f52317h, this.f52318i, this.f52319j, this.f52320k, this.f52321l);
    }

    public final SerializersModule b() {
        return this.f52322m;
    }

    public final void c(boolean z7) {
        this.f52320k = z7;
    }

    public final void d(boolean z7) {
        this.f52314e = z7;
    }

    public final void e(boolean z7) {
        this.f52317h = z7;
    }

    public final void f(boolean z7) {
        this.f52310a = z7;
    }

    public final void g(boolean z7) {
        this.f52312c = z7;
    }

    public final void h(boolean z7) {
        this.f52313d = z7;
    }

    public final void i(boolean z7) {
        this.f52315f = z7;
    }

    public final void j(boolean z7) {
        this.f52318i = z7;
    }
}
