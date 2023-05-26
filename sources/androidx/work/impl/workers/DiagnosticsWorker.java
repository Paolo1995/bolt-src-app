package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.SystemIdInfo;
import androidx.work.impl.model.SystemIdInfoDao;
import androidx.work.impl.model.WorkNameDao;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.model.WorkTagDao;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {

    /* renamed from: l  reason: collision with root package name */
    private static final String f8783l = Logger.f("DiagnosticsWrkr");

    public DiagnosticsWorker(@NonNull Context context, @NonNull WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @NonNull
    private static String s(@NonNull WorkSpec workSpec, String str, Integer num, @NonNull String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", workSpec.f8618a, workSpec.f8620c, num, workSpec.f8619b.name(), str, str2);
    }

    @NonNull
    private static String t(@NonNull WorkNameDao workNameDao, @NonNull WorkTagDao workTagDao, @NonNull SystemIdInfoDao systemIdInfoDao, @NonNull List<WorkSpec> list) {
        String str;
        StringBuilder sb = new StringBuilder();
        if (Build.VERSION.SDK_INT >= 23) {
            str = "Job Id";
        } else {
            str = "Alarm Id";
        }
        sb.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", str));
        for (WorkSpec workSpec : list) {
            Integer num = null;
            SystemIdInfo a8 = systemIdInfoDao.a(workSpec.f8618a);
            if (a8 != null) {
                num = Integer.valueOf(a8.f8596b);
            }
            sb.append(s(workSpec, TextUtils.join(",", workNameDao.b(workSpec.f8618a)), num, TextUtils.join(",", workTagDao.a(workSpec.f8618a))));
        }
        return sb.toString();
    }

    @Override // androidx.work.Worker
    @NonNull
    public ListenableWorker.Result r() {
        WorkDatabase o8 = WorkManagerImpl.k(a()).o();
        WorkSpecDao P = o8.P();
        WorkNameDao N = o8.N();
        WorkTagDao Q = o8.Q();
        SystemIdInfoDao M = o8.M();
        List<WorkSpec> c8 = P.c(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<WorkSpec> q8 = P.q();
        List<WorkSpec> k8 = P.k(200);
        if (c8 != null && !c8.isEmpty()) {
            Logger c9 = Logger.c();
            String str = f8783l;
            c9.d(str, "Recently completed work:\n\n", new Throwable[0]);
            Logger.c().d(str, t(N, Q, M, c8), new Throwable[0]);
        }
        if (q8 != null && !q8.isEmpty()) {
            Logger c10 = Logger.c();
            String str2 = f8783l;
            c10.d(str2, "Running work:\n\n", new Throwable[0]);
            Logger.c().d(str2, t(N, Q, M, q8), new Throwable[0]);
        }
        if (k8 != null && !k8.isEmpty()) {
            Logger c11 = Logger.c();
            String str3 = f8783l;
            c11.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            Logger.c().d(str3, t(N, Q, M, k8), new Throwable[0]);
        }
        return ListenableWorker.Result.c();
    }
}
