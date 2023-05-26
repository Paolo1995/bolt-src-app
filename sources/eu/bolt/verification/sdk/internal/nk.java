package eu.bolt.verification.sdk.internal;

import eu.bolt.verification.R$color;
import eu.bolt.verification.R$dimen;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class nk {

    /* renamed from: a  reason: collision with root package name */
    private CharSequence f44346a = "";

    /* renamed from: b  reason: collision with root package name */
    private int f44347b;

    /* renamed from: c  reason: collision with root package name */
    private int f44348c;

    /* renamed from: d  reason: collision with root package name */
    private int f44349d;

    /* renamed from: e  reason: collision with root package name */
    private int f44350e;

    public nk() {
        int i8 = R$dimen.f41702k;
        this.f44347b = i8;
        this.f44348c = i8;
        this.f44349d = R$color.f41697y;
    }

    public final mk a() {
        return new mk(this.f44346a, this.f44349d, this.f44347b, this.f44348c, Integer.valueOf(this.f44350e));
    }

    public final nk b(int i8) {
        this.f44349d = i8;
        return this;
    }

    public final nk c(CharSequence text) {
        Intrinsics.f(text, "text");
        this.f44346a = text;
        return this;
    }

    public final nk d(Integer num) {
        this.f44350e = num != null ? num.intValue() : 0;
        return this;
    }

    public final nk e(int i8) {
        this.f44348c = i8;
        return this;
    }

    public final nk f(int i8) {
        this.f44347b = i8;
        return this;
    }
}
