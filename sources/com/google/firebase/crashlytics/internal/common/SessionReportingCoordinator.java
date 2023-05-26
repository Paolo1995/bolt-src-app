package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public class SessionReportingCoordinator {

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReportDataCapture f15718a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsReportPersistence f15719b;

    /* renamed from: c  reason: collision with root package name */
    private final DataTransportCrashlyticsReportSender f15720c;

    /* renamed from: d  reason: collision with root package name */
    private final LogFileManager f15721d;

    /* renamed from: e  reason: collision with root package name */
    private final UserMetadata f15722e;

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata) {
        this.f15718a = crashlyticsReportDataCapture;
        this.f15719b = crashlyticsReportPersistence;
        this.f15720c = dataTransportCrashlyticsReportSender;
        this.f15721d = logFileManager;
        this.f15722e = userMetadata;
    }

    private CrashlyticsReport.Session.Event c(CrashlyticsReport.Session.Event event) {
        return d(event, this.f15721d, this.f15722e);
    }

    private CrashlyticsReport.Session.Event d(CrashlyticsReport.Session.Event event, LogFileManager logFileManager, UserMetadata userMetadata) {
        CrashlyticsReport.Session.Event.Builder g8 = event.g();
        String c8 = logFileManager.c();
        if (c8 != null) {
            g8.d(CrashlyticsReport.Session.Event.Log.a().b(c8).a());
        } else {
            Logger.f().i("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> k8 = k(userMetadata.e());
        List<CrashlyticsReport.CustomAttribute> k9 = k(userMetadata.f());
        if (!k8.isEmpty() || !k9.isEmpty()) {
            g8.b(event.b().g().c(ImmutableList.b(k8)).e(ImmutableList.b(k9)).a());
        }
        return g8.a();
    }

    private static CrashlyticsReport.ApplicationExitInfo e(ApplicationExitInfo applicationExitInfo) {
        String str = null;
        try {
            InputStream traceInputStream = applicationExitInfo.getTraceInputStream();
            if (traceInputStream != null) {
                str = f(traceInputStream);
            }
        } catch (IOException e8) {
            Logger f8 = Logger.f();
            f8.k("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e8);
        }
        return CrashlyticsReport.ApplicationExitInfo.a().b(applicationExitInfo.getImportance()).d(applicationExitInfo.getProcessName()).f(applicationExitInfo.getReason()).h(applicationExitInfo.getTimestamp()).c(applicationExitInfo.getPid()).e(applicationExitInfo.getPss()).g(applicationExitInfo.getRss()).i(str).a();
    }

    public static String f(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
        }
    }

    public static SessionReportingCoordinator g(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter) {
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy), new CrashlyticsReportPersistence(fileStore, settingsProvider), DataTransportCrashlyticsReportSender.b(context, settingsProvider, onDemandCounter), logFileManager, userMetadata);
    }

    private ApplicationExitInfo j(String str, List<ApplicationExitInfo> list) {
        long q8 = this.f15719b.q(str);
        for (ApplicationExitInfo applicationExitInfo : list) {
            if (applicationExitInfo.getTimestamp() < q8) {
                return null;
            }
            if (applicationExitInfo.getReason() == 6) {
                return applicationExitInfo;
            }
        }
        return null;
    }

    @NonNull
    private static List<CrashlyticsReport.CustomAttribute> k(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.a().b(entry.getKey()).c(entry.getValue()).a());
        }
        Collections.sort(arrayList, new Comparator() { // from class: com.google.firebase.crashlytics.internal.common.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int m8;
                m8 = SessionReportingCoordinator.m((CrashlyticsReport.CustomAttribute) obj, (CrashlyticsReport.CustomAttribute) obj2);
                return m8;
            }
        });
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int m(CrashlyticsReport.CustomAttribute customAttribute, CrashlyticsReport.CustomAttribute customAttribute2) {
        return customAttribute.b().compareTo(customAttribute2.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p(@NonNull Task<CrashlyticsReportWithSessionId> task) {
        if (task.isSuccessful()) {
            CrashlyticsReportWithSessionId result = task.getResult();
            Logger f8 = Logger.f();
            f8.b("Crashlytics report successfully enqueued to DataTransport: " + result.d());
            File c8 = result.c();
            if (c8.delete()) {
                Logger f9 = Logger.f();
                f9.b("Deleted report file: " + c8.getPath());
                return true;
            }
            Logger f10 = Logger.f();
            f10.k("Crashlytics could not delete report file: " + c8.getPath());
            return true;
        }
        Logger.f().l("Crashlytics report could not be enqueued to DataTransport", task.getException());
        return false;
    }

    private void q(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j8, boolean z7) {
        this.f15719b.y(c(this.f15718a.c(th, thread, str2, j8, 4, 8, z7)), str, str2.equals(AppMeasurement.CRASH_ORIGIN));
    }

    public void h(@NonNull String str, @NonNull List<NativeSessionFile> list) {
        Logger.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile nativeSessionFile : list) {
            CrashlyticsReport.FilesPayload.File a8 = nativeSessionFile.a();
            if (a8 != null) {
                arrayList.add(a8);
            }
        }
        this.f15719b.l(str, CrashlyticsReport.FilesPayload.a().b(ImmutableList.b(arrayList)).a());
    }

    public void i(long j8, String str) {
        this.f15719b.k(str, j8);
    }

    public boolean l() {
        return this.f15719b.r();
    }

    public SortedSet<String> n() {
        return this.f15719b.p();
    }

    public void o(@NonNull String str, long j8) {
        this.f15719b.z(this.f15718a.d(str, j8));
    }

    public void r(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j8) {
        Logger f8 = Logger.f();
        f8.i("Persisting fatal event for session " + str);
        q(th, thread, str, AppMeasurement.CRASH_ORIGIN, j8, true);
    }

    public void s(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j8) {
        Logger f8 = Logger.f();
        f8.i("Persisting non-fatal event for session " + str);
        q(th, thread, str, "error", j8, false);
    }

    public void t(String str, List<ApplicationExitInfo> list, LogFileManager logFileManager, UserMetadata userMetadata) {
        ApplicationExitInfo j8 = j(str, list);
        if (j8 == null) {
            Logger f8 = Logger.f();
            f8.i("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.Session.Event b8 = this.f15718a.b(e(j8));
        Logger f9 = Logger.f();
        f9.b("Persisting anr for session " + str);
        this.f15719b.y(d(b8, logFileManager, userMetadata), str, true);
    }

    public void u() {
        this.f15719b.i();
    }

    public Task<Void> v(@NonNull Executor executor) {
        return w(executor, null);
    }

    public Task<Void> w(@NonNull Executor executor, String str) {
        boolean z7;
        List<CrashlyticsReportWithSessionId> w7 = this.f15719b.w();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId crashlyticsReportWithSessionId : w7) {
            if (str == null || str.equals(crashlyticsReportWithSessionId.d())) {
                DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender = this.f15720c;
                if (str != null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                arrayList.add(dataTransportCrashlyticsReportSender.c(crashlyticsReportWithSessionId, z7).continueWith(executor, new Continuation() { // from class: com.google.firebase.crashlytics.internal.common.d
                    @Override // com.google.android.gms.tasks.Continuation
                    public final Object then(Task task) {
                        boolean p8;
                        p8 = SessionReportingCoordinator.this.p(task);
                        return Boolean.valueOf(p8);
                    }
                }));
            }
        }
        return Tasks.whenAll(arrayList);
    }
}
