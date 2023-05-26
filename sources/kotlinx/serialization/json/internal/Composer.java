package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composers.kt */
/* loaded from: classes5.dex */
public class Composer {

    /* renamed from: a  reason: collision with root package name */
    public final JsonWriter f52378a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f52379b;

    public Composer(JsonWriter writer) {
        Intrinsics.f(writer, "writer");
        this.f52378a = writer;
        this.f52379b = true;
    }

    public final boolean a() {
        return this.f52379b;
    }

    public void b() {
        this.f52379b = true;
    }

    public void c() {
        this.f52379b = false;
    }

    public void d(byte b8) {
        this.f52378a.writeLong(b8);
    }

    public final void e(char c8) {
        this.f52378a.a(c8);
    }

    public void f(double d8) {
        this.f52378a.c(String.valueOf(d8));
    }

    public void g(float f8) {
        this.f52378a.c(String.valueOf(f8));
    }

    public void h(int i8) {
        this.f52378a.writeLong(i8);
    }

    public void i(long j8) {
        this.f52378a.writeLong(j8);
    }

    public final void j(String v7) {
        Intrinsics.f(v7, "v");
        this.f52378a.c(v7);
    }

    public void k(short s7) {
        this.f52378a.writeLong(s7);
    }

    public void l(boolean z7) {
        this.f52378a.c(String.valueOf(z7));
    }

    public final void m(String value) {
        Intrinsics.f(value, "value");
        this.f52378a.b(value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void n(boolean z7) {
        this.f52379b = z7;
    }

    public void o() {
    }

    public void p() {
    }
}
