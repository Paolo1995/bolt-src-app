package io.ktor.utils.io.core;

import io.ktor.utils.io.core.internal.ChunkBuffer;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Buffer.kt */
/* loaded from: classes5.dex */
public class Buffer {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f47369g = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final ByteBuffer f47370a;

    /* renamed from: b  reason: collision with root package name */
    private int f47371b;

    /* renamed from: c  reason: collision with root package name */
    private int f47372c;

    /* renamed from: d  reason: collision with root package name */
    private int f47373d;

    /* renamed from: e  reason: collision with root package name */
    private int f47374e;

    /* renamed from: f  reason: collision with root package name */
    private final int f47375f;

    /* compiled from: Buffer.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Buffer a() {
            return ChunkBuffer.f47400j.a();
        }
    }

    private Buffer(ByteBuffer byteBuffer) {
        this.f47370a = byteBuffer;
        this.f47374e = byteBuffer.limit();
        this.f47375f = byteBuffer.limit();
    }

    public /* synthetic */ Buffer(ByteBuffer byteBuffer, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteBuffer);
    }

    public final void a(int i8) {
        int i9 = this.f47372c + i8;
        if (i8 >= 0 && i9 <= this.f47374e) {
            this.f47372c = i9;
        } else {
            BufferKt.a(i8, g() - k());
            throw new KotlinNothingValueException();
        }
    }

    public final boolean b(int i8) {
        int i9 = this.f47374e;
        int i10 = this.f47372c;
        if (i8 >= i10) {
            if (i8 >= i9) {
                if (i8 == i9) {
                    this.f47372c = i8;
                    return false;
                }
                BufferKt.a(i8 - i10, g() - k());
                throw new KotlinNothingValueException();
            }
            this.f47372c = i8;
            return true;
        }
        BufferKt.a(i8 - i10, g() - k());
        throw new KotlinNothingValueException();
    }

    public final void c(int i8) {
        if (i8 == 0) {
            return;
        }
        int i9 = this.f47371b + i8;
        if (i8 >= 0 && i9 <= this.f47372c) {
            this.f47371b = i9;
        } else {
            BufferKt.b(i8, k() - i());
            throw new KotlinNothingValueException();
        }
    }

    public final void d(int i8) {
        if (i8 >= 0 && i8 <= this.f47372c) {
            if (this.f47371b != i8) {
                this.f47371b = i8;
                return;
            }
            return;
        }
        BufferKt.b(i8 - this.f47371b, k() - i());
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Buffer copy) {
        Intrinsics.f(copy, "copy");
        copy.f47374e = this.f47374e;
        copy.f47373d = this.f47373d;
        copy.f47371b = this.f47371b;
        copy.f47372c = this.f47372c;
    }

    public final int f() {
        return this.f47375f;
    }

    public final int g() {
        return this.f47374e;
    }

    public final ByteBuffer h() {
        return this.f47370a;
    }

    public final int i() {
        return this.f47371b;
    }

    public final int j() {
        return this.f47373d;
    }

    public final int k() {
        return this.f47372c;
    }

    public final byte l() {
        int i8 = this.f47371b;
        if (i8 != this.f47372c) {
            this.f47371b = i8 + 1;
            return this.f47370a.get(i8);
        }
        throw new EOFException("No readable bytes available.");
    }

    public final void m() {
        this.f47374e = this.f47375f;
    }

    public final void n() {
        o(0);
        m();
    }

    public final void o(int i8) {
        boolean z7;
        boolean z8 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 > this.f47371b) {
                z8 = false;
            }
            if (z8) {
                this.f47371b = i8;
                if (this.f47373d > i8) {
                    this.f47373d = i8;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException(("newReadPosition shouldn't be ahead of the read position: " + i8 + " > " + this.f47371b).toString());
        }
        throw new IllegalArgumentException(("newReadPosition shouldn't be negative: " + i8).toString());
    }

    public final void p(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i9 = this.f47375f - i8;
            if (i9 >= this.f47372c) {
                this.f47374e = i9;
                return;
            }
            if (i9 < 0) {
                BufferKt.c(this, i8);
            }
            if (i9 < this.f47373d) {
                BufferKt.e(this, i8);
            }
            if (this.f47371b == this.f47372c) {
                this.f47374e = i9;
                this.f47371b = i9;
                this.f47372c = i9;
                return;
            }
            BufferKt.d(this, i8);
            return;
        }
        throw new IllegalArgumentException(("endGap shouldn't be negative: " + i8).toString());
    }

    public final void q(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            int i9 = this.f47371b;
            if (i9 >= i8) {
                this.f47373d = i8;
                return;
            } else if (i9 == this.f47372c) {
                if (i8 <= this.f47374e) {
                    this.f47372c = i8;
                    this.f47371b = i8;
                    this.f47373d = i8;
                    return;
                }
                BufferKt.h(this, i8);
                throw new KotlinNothingValueException();
            } else {
                BufferKt.g(this, i8);
                throw new KotlinNothingValueException();
            }
        }
        throw new IllegalArgumentException(("startGap shouldn't be negative: " + i8).toString());
    }

    public void r() {
        n();
        s();
    }

    public final void s() {
        t(this.f47375f - this.f47373d);
    }

    public final void t(int i8) {
        int i9 = this.f47373d;
        this.f47371b = i9;
        this.f47372c = i9;
        this.f47374e = i8;
    }

    public String toString() {
        return "Buffer(" + (k() - i()) + " used, " + (g() - k()) + " free, " + (this.f47373d + (f() - g())) + " reserved of " + this.f47375f + ')';
    }
}
