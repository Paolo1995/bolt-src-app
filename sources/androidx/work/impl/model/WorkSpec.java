package androidx.work.impl.model;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import com.sinch.android.rtc.internal.client.calling.DefaultCallController;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public final class WorkSpec {

    /* renamed from: s  reason: collision with root package name */
    private static final String f8616s = Logger.f("WorkSpec");

    /* renamed from: t  reason: collision with root package name */
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> f8617t = new Function<List<WorkInfoPojo>, List<WorkInfo>>() { // from class: androidx.work.impl.model.WorkSpec.1
        @Override // androidx.arch.core.util.Function
        /* renamed from: a */
        public List<WorkInfo> apply(List<WorkInfoPojo> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (WorkInfoPojo workInfoPojo : list) {
                arrayList.add(workInfoPojo.a());
            }
            return arrayList;
        }
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public String f8618a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public WorkInfo.State f8619b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public String f8620c;

    /* renamed from: d  reason: collision with root package name */
    public String f8621d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public Data f8622e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public Data f8623f;

    /* renamed from: g  reason: collision with root package name */
    public long f8624g;

    /* renamed from: h  reason: collision with root package name */
    public long f8625h;

    /* renamed from: i  reason: collision with root package name */
    public long f8626i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public Constraints f8627j;

    /* renamed from: k  reason: collision with root package name */
    public int f8628k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public BackoffPolicy f8629l;

    /* renamed from: m  reason: collision with root package name */
    public long f8630m;

    /* renamed from: n  reason: collision with root package name */
    public long f8631n;

    /* renamed from: o  reason: collision with root package name */
    public long f8632o;

    /* renamed from: p  reason: collision with root package name */
    public long f8633p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f8634q;
    @NonNull

    /* renamed from: r  reason: collision with root package name */
    public OutOfQuotaPolicy f8635r;

    /* loaded from: classes.dex */
    public static class IdAndState {

        /* renamed from: a  reason: collision with root package name */
        public String f8636a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f8637b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            if (this.f8637b != idAndState.f8637b) {
                return false;
            }
            return this.f8636a.equals(idAndState.f8636a);
        }

        public int hashCode() {
            return (this.f8636a.hashCode() * 31) + this.f8637b.hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static class WorkInfoPojo {

        /* renamed from: a  reason: collision with root package name */
        public String f8638a;

        /* renamed from: b  reason: collision with root package name */
        public WorkInfo.State f8639b;

        /* renamed from: c  reason: collision with root package name */
        public Data f8640c;

        /* renamed from: d  reason: collision with root package name */
        public int f8641d;

        /* renamed from: e  reason: collision with root package name */
        public List<String> f8642e;

        /* renamed from: f  reason: collision with root package name */
        public List<Data> f8643f;

        @NonNull
        public WorkInfo a() {
            Data data;
            List<Data> list = this.f8643f;
            if (list != null && !list.isEmpty()) {
                data = this.f8643f.get(0);
            } else {
                data = Data.f8268c;
            }
            return new WorkInfo(UUID.fromString(this.f8638a), this.f8639b, this.f8640c, this.f8642e, data, this.f8641d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            if (this.f8641d != workInfoPojo.f8641d) {
                return false;
            }
            String str = this.f8638a;
            if (str == null ? workInfoPojo.f8638a != null : !str.equals(workInfoPojo.f8638a)) {
                return false;
            }
            if (this.f8639b != workInfoPojo.f8639b) {
                return false;
            }
            Data data = this.f8640c;
            if (data == null ? workInfoPojo.f8640c != null : !data.equals(workInfoPojo.f8640c)) {
                return false;
            }
            List<String> list = this.f8642e;
            if (list == null ? workInfoPojo.f8642e != null : !list.equals(workInfoPojo.f8642e)) {
                return false;
            }
            List<Data> list2 = this.f8643f;
            List<Data> list3 = workInfoPojo.f8643f;
            if (list2 != null) {
                return list2.equals(list3);
            }
            if (list3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i8;
            int i9;
            int i10;
            int i11;
            String str = this.f8638a;
            int i12 = 0;
            if (str != null) {
                i8 = str.hashCode();
            } else {
                i8 = 0;
            }
            int i13 = i8 * 31;
            WorkInfo.State state = this.f8639b;
            if (state != null) {
                i9 = state.hashCode();
            } else {
                i9 = 0;
            }
            int i14 = (i13 + i9) * 31;
            Data data = this.f8640c;
            if (data != null) {
                i10 = data.hashCode();
            } else {
                i10 = 0;
            }
            int i15 = (((i14 + i10) * 31) + this.f8641d) * 31;
            List<String> list = this.f8642e;
            if (list != null) {
                i11 = list.hashCode();
            } else {
                i11 = 0;
            }
            int i16 = (i15 + i11) * 31;
            List<Data> list2 = this.f8643f;
            if (list2 != null) {
                i12 = list2.hashCode();
            }
            return i16 + i12;
        }
    }

    public WorkSpec(@NonNull String str, @NonNull String str2) {
        this.f8619b = WorkInfo.State.ENQUEUED;
        Data data = Data.f8268c;
        this.f8622e = data;
        this.f8623f = data;
        this.f8627j = Constraints.f8237i;
        this.f8629l = BackoffPolicy.EXPONENTIAL;
        this.f8630m = DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS;
        this.f8633p = -1L;
        this.f8635r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f8618a = str;
        this.f8620c = str2;
    }

    public long a() {
        long j8;
        long scalb;
        boolean z7 = false;
        if (c()) {
            if (this.f8629l == BackoffPolicy.LINEAR) {
                z7 = true;
            }
            if (z7) {
                scalb = this.f8630m * this.f8628k;
            } else {
                scalb = Math.scalb((float) this.f8630m, this.f8628k - 1);
            }
            return this.f8631n + Math.min(18000000L, scalb);
        }
        long j9 = 0;
        if (d()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j10 = this.f8631n;
            if (j10 == 0) {
                j8 = currentTimeMillis + this.f8624g;
            } else {
                j8 = j10;
            }
            long j11 = this.f8626i;
            long j12 = this.f8625h;
            if (j11 != j12) {
                z7 = true;
            }
            if (z7) {
                if (j10 == 0) {
                    j9 = j11 * (-1);
                }
                return j8 + j12 + j9;
            }
            if (j10 != 0) {
                j9 = j12;
            }
            return j8 + j9;
        }
        long j13 = this.f8631n;
        if (j13 == 0) {
            j13 = System.currentTimeMillis();
        }
        return j13 + this.f8624g;
    }

    public boolean b() {
        return !Constraints.f8237i.equals(this.f8627j);
    }

    public boolean c() {
        if (this.f8619b == WorkInfo.State.ENQUEUED && this.f8628k > 0) {
            return true;
        }
        return false;
    }

    public boolean d() {
        if (this.f8625h != 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkSpec.class != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.f8624g != workSpec.f8624g || this.f8625h != workSpec.f8625h || this.f8626i != workSpec.f8626i || this.f8628k != workSpec.f8628k || this.f8630m != workSpec.f8630m || this.f8631n != workSpec.f8631n || this.f8632o != workSpec.f8632o || this.f8633p != workSpec.f8633p || this.f8634q != workSpec.f8634q || !this.f8618a.equals(workSpec.f8618a) || this.f8619b != workSpec.f8619b || !this.f8620c.equals(workSpec.f8620c)) {
            return false;
        }
        String str = this.f8621d;
        if (str == null ? workSpec.f8621d != null : !str.equals(workSpec.f8621d)) {
            return false;
        }
        if (this.f8622e.equals(workSpec.f8622e) && this.f8623f.equals(workSpec.f8623f) && this.f8627j.equals(workSpec.f8627j) && this.f8629l == workSpec.f8629l && this.f8635r == workSpec.f8635r) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i8;
        int hashCode = ((((this.f8618a.hashCode() * 31) + this.f8619b.hashCode()) * 31) + this.f8620c.hashCode()) * 31;
        String str = this.f8621d;
        if (str != null) {
            i8 = str.hashCode();
        } else {
            i8 = 0;
        }
        long j8 = this.f8624g;
        long j9 = this.f8625h;
        long j10 = this.f8626i;
        long j11 = this.f8630m;
        long j12 = this.f8631n;
        long j13 = this.f8632o;
        long j14 = this.f8633p;
        return ((((((((((((((((((((((((((((hashCode + i8) * 31) + this.f8622e.hashCode()) * 31) + this.f8623f.hashCode()) * 31) + ((int) (j8 ^ (j8 >>> 32)))) * 31) + ((int) (j9 ^ (j9 >>> 32)))) * 31) + ((int) (j10 ^ (j10 >>> 32)))) * 31) + this.f8627j.hashCode()) * 31) + this.f8628k) * 31) + this.f8629l.hashCode()) * 31) + ((int) (j11 ^ (j11 >>> 32)))) * 31) + ((int) (j12 ^ (j12 >>> 32)))) * 31) + ((int) (j13 ^ (j13 >>> 32)))) * 31) + ((int) (j14 ^ (j14 >>> 32)))) * 31) + (this.f8634q ? 1 : 0)) * 31) + this.f8635r.hashCode();
    }

    @NonNull
    public String toString() {
        return "{WorkSpec: " + this.f8618a + "}";
    }

    public WorkSpec(@NonNull WorkSpec workSpec) {
        this.f8619b = WorkInfo.State.ENQUEUED;
        Data data = Data.f8268c;
        this.f8622e = data;
        this.f8623f = data;
        this.f8627j = Constraints.f8237i;
        this.f8629l = BackoffPolicy.EXPONENTIAL;
        this.f8630m = DefaultCallController.ICE_SERVERS_VALID_WINDOW_MS;
        this.f8633p = -1L;
        this.f8635r = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f8618a = workSpec.f8618a;
        this.f8620c = workSpec.f8620c;
        this.f8619b = workSpec.f8619b;
        this.f8621d = workSpec.f8621d;
        this.f8622e = new Data(workSpec.f8622e);
        this.f8623f = new Data(workSpec.f8623f);
        this.f8624g = workSpec.f8624g;
        this.f8625h = workSpec.f8625h;
        this.f8626i = workSpec.f8626i;
        this.f8627j = new Constraints(workSpec.f8627j);
        this.f8628k = workSpec.f8628k;
        this.f8629l = workSpec.f8629l;
        this.f8630m = workSpec.f8630m;
        this.f8631n = workSpec.f8631n;
        this.f8632o = workSpec.f8632o;
        this.f8633p = workSpec.f8633p;
        this.f8634q = workSpec.f8634q;
        this.f8635r = workSpec.f8635r;
    }
}
