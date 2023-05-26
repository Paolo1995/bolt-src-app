package androidx.work;

import android.os.Build;
import androidx.annotation.NonNull;
import androidx.work.WorkRequest;

/* loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {

    /* loaded from: classes.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        public Builder(@NonNull Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f8325c.f8621d = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        /* renamed from: e */
        public OneTimeWorkRequest c() {
            if (this.f8323a && Build.VERSION.SDK_INT >= 23 && this.f8325c.f8627j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new OneTimeWorkRequest(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.WorkRequest.Builder
        @NonNull
        /* renamed from: f */
        public Builder d() {
            return this;
        }
    }

    OneTimeWorkRequest(Builder builder) {
        super(builder.f8324b, builder.f8325c, builder.f8326d);
    }

    @NonNull
    public static OneTimeWorkRequest d(@NonNull Class<? extends ListenableWorker> cls) {
        return new Builder(cls).b();
    }
}
