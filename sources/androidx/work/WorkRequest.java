package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public abstract class WorkRequest {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private UUID f8320a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private WorkSpec f8321b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f8322c;

    /* loaded from: classes.dex */
    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {

        /* renamed from: c  reason: collision with root package name */
        WorkSpec f8325c;

        /* renamed from: e  reason: collision with root package name */
        Class<? extends ListenableWorker> f8327e;

        /* renamed from: a  reason: collision with root package name */
        boolean f8323a = false;

        /* renamed from: d  reason: collision with root package name */
        Set<String> f8326d = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        UUID f8324b = UUID.randomUUID();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            this.f8327e = cls;
            this.f8325c = new WorkSpec(this.f8324b.toString(), cls.getName());
            a(cls.getName());
        }

        @NonNull
        public final B a(@NonNull String str) {
            this.f8326d.add(str);
            return d();
        }

        @NonNull
        public final W b() {
            boolean z7;
            W c8 = c();
            Constraints constraints = this.f8325c.f8627j;
            int i8 = Build.VERSION.SDK_INT;
            if ((i8 < 24 || !constraints.e()) && !constraints.f() && !constraints.g() && (i8 < 23 || !constraints.h())) {
                z7 = false;
            } else {
                z7 = true;
            }
            if (this.f8325c.f8634q && z7) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            this.f8324b = UUID.randomUUID();
            WorkSpec workSpec = new WorkSpec(this.f8325c);
            this.f8325c = workSpec;
            workSpec.f8618a = this.f8324b.toString();
            return c8;
        }

        @NonNull
        abstract W c();

        @NonNull
        abstract B d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public WorkRequest(@NonNull UUID uuid, @NonNull WorkSpec workSpec, @NonNull Set<String> set) {
        this.f8320a = uuid;
        this.f8321b = workSpec;
        this.f8322c = set;
    }

    @NonNull
    public String a() {
        return this.f8320a.toString();
    }

    @NonNull
    public Set<String> b() {
        return this.f8322c;
    }

    @NonNull
    public WorkSpec c() {
        return this.f8321b;
    }
}
