package androidx.work.impl.constraints;

import androidx.annotation.NonNull;
import j$.util.Spliterator;

/* loaded from: classes.dex */
public class NetworkState {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8516a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8517b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8518c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8519d;

    public NetworkState(boolean z7, boolean z8, boolean z9, boolean z10) {
        this.f8516a = z7;
        this.f8517b = z8;
        this.f8518c = z9;
        this.f8519d = z10;
    }

    public boolean a() {
        return this.f8516a;
    }

    public boolean b() {
        return this.f8518c;
    }

    public boolean c() {
        return this.f8519d;
    }

    public boolean d() {
        return this.f8517b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkState)) {
            return false;
        }
        NetworkState networkState = (NetworkState) obj;
        if (this.f8516a == networkState.f8516a && this.f8517b == networkState.f8517b && this.f8518c == networkState.f8518c && this.f8519d == networkState.f8519d) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public int hashCode() {
        ?? r02 = this.f8516a;
        int i8 = r02;
        if (this.f8517b) {
            i8 = r02 + 16;
        }
        int i9 = i8;
        if (this.f8518c) {
            i9 = i8 + Spliterator.NONNULL;
        }
        if (this.f8519d) {
            return i9 + 4096;
        }
        return i9;
    }

    @NonNull
    public String toString() {
        return String.format("[ Connected=%b Validated=%b Metered=%b NotRoaming=%b ]", Boolean.valueOf(this.f8516a), Boolean.valueOf(this.f8517b), Boolean.valueOf(this.f8518c), Boolean.valueOf(this.f8519d));
    }
}
