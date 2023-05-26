package ee.mtakso.driver.service.modules.polling;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PollingSigned.kt */
/* loaded from: classes3.dex */
public final class PollingSigned<T> {

    /* renamed from: a  reason: collision with root package name */
    private final T f25138a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25139b;

    public PollingSigned(T t7, int i8) {
        this.f25138a = t7;
        this.f25139b = i8;
    }

    public final T a() {
        return this.f25138a;
    }

    public final int b() {
        return this.f25139b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PollingSigned) {
            PollingSigned pollingSigned = (PollingSigned) obj;
            return Intrinsics.a(this.f25138a, pollingSigned.f25138a) && this.f25139b == pollingSigned.f25139b;
        }
        return false;
    }

    public int hashCode() {
        T t7 = this.f25138a;
        return ((t7 == null ? 0 : t7.hashCode()) * 31) + this.f25139b;
    }

    public String toString() {
        T t7 = this.f25138a;
        int i8 = this.f25139b;
        return "PollingSigned(data=" + t7 + ", fingerprint=" + i8 + ")";
    }
}
