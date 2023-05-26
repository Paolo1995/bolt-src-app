package androidx.work;

import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkInfo {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private UUID f8306a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private State f8307b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private Data f8308c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f8309d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private Data f8310e;

    /* renamed from: f  reason: collision with root package name */
    private int f8311f;

    /* loaded from: classes.dex */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean a() {
            if (this != SUCCEEDED && this != FAILED && this != CANCELLED) {
                return false;
            }
            return true;
        }
    }

    public WorkInfo(@NonNull UUID uuid, @NonNull State state, @NonNull Data data, @NonNull List<String> list, @NonNull Data data2, int i8) {
        this.f8306a = uuid;
        this.f8307b = state;
        this.f8308c = data;
        this.f8309d = new HashSet(list);
        this.f8310e = data2;
        this.f8311f = i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f8311f != workInfo.f8311f || !this.f8306a.equals(workInfo.f8306a) || this.f8307b != workInfo.f8307b || !this.f8308c.equals(workInfo.f8308c) || !this.f8309d.equals(workInfo.f8309d)) {
            return false;
        }
        return this.f8310e.equals(workInfo.f8310e);
    }

    public int hashCode() {
        return (((((((((this.f8306a.hashCode() * 31) + this.f8307b.hashCode()) * 31) + this.f8308c.hashCode()) * 31) + this.f8309d.hashCode()) * 31) + this.f8310e.hashCode()) * 31) + this.f8311f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f8306a + "', mState=" + this.f8307b + ", mOutputData=" + this.f8308c + ", mTags=" + this.f8309d + ", mProgress=" + this.f8310e + '}';
    }
}
