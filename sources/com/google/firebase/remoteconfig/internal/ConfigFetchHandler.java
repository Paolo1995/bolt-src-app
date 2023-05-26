package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import j$.util.Spliterator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ConfigFetchHandler {

    /* renamed from: j  reason: collision with root package name */
    public static final long f17075j = TimeUnit.HOURS.toSeconds(12);

    /* renamed from: k  reason: collision with root package name */
    static final int[] f17076k = {2, 4, 8, 16, 32, 64, 128, Spliterator.NONNULL};

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstallationsApi f17077a;

    /* renamed from: b  reason: collision with root package name */
    private final AnalyticsConnector f17078b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f17079c;

    /* renamed from: d  reason: collision with root package name */
    private final Clock f17080d;

    /* renamed from: e  reason: collision with root package name */
    private final Random f17081e;

    /* renamed from: f  reason: collision with root package name */
    private final ConfigCacheClient f17082f;

    /* renamed from: g  reason: collision with root package name */
    private final ConfigFetchHttpClient f17083g;

    /* renamed from: h  reason: collision with root package name */
    private final ConfigMetadataClient f17084h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f17085i;

    /* loaded from: classes3.dex */
    public static class FetchResponse {

        /* renamed from: a  reason: collision with root package name */
        private final Date f17095a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17096b;

        /* renamed from: c  reason: collision with root package name */
        private final ConfigContainer f17097c;

        /* renamed from: d  reason: collision with root package name */
        private final String f17098d;

        private FetchResponse(Date date, int i8, ConfigContainer configContainer, String str) {
            this.f17095a = date;
            this.f17096b = i8;
            this.f17097c = configContainer;
            this.f17098d = str;
        }

        public static FetchResponse a(Date date) {
            return new FetchResponse(date, 1, null, null);
        }

        public static FetchResponse b(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.e(), 0, configContainer, str);
        }

        public static FetchResponse c(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        public ConfigContainer d() {
            return this.f17097c;
        }

        String e() {
            return this.f17098d;
        }

        int f() {
            return this.f17096b;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, AnalyticsConnector analyticsConnector, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.f17077a = firebaseInstallationsApi;
        this.f17078b = analyticsConnector;
        this.f17079c = executor;
        this.f17080d = clock;
        this.f17081e = random;
        this.f17082f = configCacheClient;
        this.f17083g = configFetchHttpClient;
        this.f17084h = configMetadataClient;
        this.f17085i = map;
    }

    private boolean a(long j8, Date date) {
        Date e8 = this.f17084h.e();
        if (e8.equals(ConfigMetadataClient.f17117d)) {
            return false;
        }
        return date.before(new Date(e8.getTime() + TimeUnit.SECONDS.toMillis(j8)));
    }

    private FirebaseRemoteConfigServerException b(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int a8 = firebaseRemoteConfigServerException.a();
        if (a8 != 401) {
            if (a8 != 403) {
                if (a8 != 429) {
                    if (a8 != 500) {
                        switch (a8) {
                            case 502:
                            case 503:
                            case 504:
                                str = "The server is unavailable. Please try again later.";
                                break;
                            default:
                                str = "The server returned an unexpected error.";
                                break;
                        }
                    } else {
                        str = "There was an internal server error.";
                    }
                } else {
                    throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
                }
            } else {
                str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
            }
        } else {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        }
        int a9 = firebaseRemoteConfigServerException.a();
        return new FirebaseRemoteConfigServerException(a9, "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String c(long j8) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j8)));
    }

    private FetchResponse f(String str, String str2, Date date) throws FirebaseRemoteConfigException {
        try {
            FetchResponse fetch = this.f17083g.fetch(this.f17083g.c(), str, str2, k(), this.f17084h.d(), this.f17085i, date);
            if (fetch.e() != null) {
                this.f17084h.j(fetch.e());
            }
            this.f17084h.g();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e8) {
            ConfigMetadataClient.BackoffMetadata r7 = r(e8.a(), date);
            if (q(r7, e8.a())) {
                throw new FirebaseRemoteConfigFetchThrottledException(r7.a().getTime());
            }
            throw b(e8);
        }
    }

    private Task<FetchResponse> g(String str, String str2, Date date) {
        try {
            FetchResponse f8 = f(str, str2, date);
            if (f8.f() != 0) {
                return Tasks.forResult(f8);
            }
            return this.f17082f.i(f8.d()).onSuccessTask(this.f17079c, ConfigFetchHandler$$Lambda$4.a(f8));
        } catch (FirebaseRemoteConfigException e8) {
            return Tasks.forException(e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task<FetchResponse> h(Task<ConfigContainer> task, long j8) {
        Task continueWithTask;
        Date date = new Date(this.f17080d.currentTimeMillis());
        if (task.isSuccessful() && a(j8, date)) {
            return Tasks.forResult(FetchResponse.c(date));
        }
        Date i8 = i(date);
        if (i8 != null) {
            continueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(c(i8.getTime() - date.getTime()), i8.getTime()));
        } else {
            Task<String> id = this.f17077a.getId();
            Task<InstallationTokenResult> a8 = this.f17077a.a(false);
            continueWithTask = Tasks.whenAllComplete(id, a8).continueWithTask(this.f17079c, ConfigFetchHandler$$Lambda$2.a(this, id, a8, date));
        }
        return continueWithTask.continueWithTask(this.f17079c, ConfigFetchHandler$$Lambda$3.a(this, date));
    }

    private Date i(Date date) {
        Date a8 = this.f17084h.a().a();
        if (date.before(a8)) {
            return a8;
        }
        return null;
    }

    private long j(int i8) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f17076k;
        long millis = timeUnit.toMillis(iArr[Math.min(i8, iArr.length) - 1]);
        return (millis / 2) + this.f17081e.nextInt((int) millis);
    }

    private Map<String, String> k() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.f17078b;
        if (analyticsConnector == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector.d(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean l(int i8) {
        return i8 == 429 || i8 == 502 || i8 == 503 || i8 == 504;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Task o(ConfigFetchHandler configFetchHandler, Task task, Task task2, Date date, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException()));
        }
        return configFetchHandler.g((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).b(), date);
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.tasks.Task p(com.google.firebase.remoteconfig.internal.ConfigFetchHandler r0, java.util.Date r1, com.google.android.gms.tasks.Task r2) throws java.lang.Exception {
        /*
            r0.t(r2, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.ConfigFetchHandler.p(com.google.firebase.remoteconfig.internal.ConfigFetchHandler, java.util.Date, com.google.android.gms.tasks.Task):com.google.android.gms.tasks.Task");
    }

    private boolean q(ConfigMetadataClient.BackoffMetadata backoffMetadata, int i8) {
        if (backoffMetadata.b() > 1 || i8 == 429) {
            return true;
        }
        return false;
    }

    private ConfigMetadataClient.BackoffMetadata r(int i8, Date date) {
        if (l(i8)) {
            s(date);
        }
        return this.f17084h.a();
    }

    private void s(Date date) {
        int b8 = this.f17084h.a().b() + 1;
        this.f17084h.h(b8, new Date(date.getTime() + j(b8)));
    }

    private void t(Task<FetchResponse> task, Date date) {
        if (task.isSuccessful()) {
            this.f17084h.l(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.f17084h.m();
        } else {
            this.f17084h.k();
        }
    }

    public Task<FetchResponse> d() {
        return e(this.f17084h.f());
    }

    public Task<FetchResponse> e(long j8) {
        return this.f17082f.c().continueWithTask(this.f17079c, ConfigFetchHandler$$Lambda$1.a(this, j8));
    }
}
