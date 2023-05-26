package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.appsflyer.AppsFlyerProperties;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class GmsRpc {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f16516a;

    /* renamed from: b  reason: collision with root package name */
    private final Metadata f16517b;

    /* renamed from: c  reason: collision with root package name */
    private final Rpc f16518c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserAgentPublisher> f16519d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<HeartBeatInfo> f16520e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseInstallationsApi f16521f;

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f16516a = firebaseApp;
        this.f16517b = metadata;
        this.f16518c = rpc;
        this.f16519d = provider;
        this.f16520e = provider2;
        this.f16521f = firebaseInstallationsApi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.j()), provider, provider2, firebaseInstallationsApi);
    }

    private static String a(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> b(Task<Bundle> task) {
        return task.continueWith(GmsRpc$$Lambda$0.f16522f, new Continuation(this) { // from class: com.google.firebase.messaging.GmsRpc$$Lambda$1

            /* renamed from: a  reason: collision with root package name */
            private final GmsRpc f16523a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16523a = this;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object then(Task task2) {
                return this.f16523a.g(task2);
            }
        });
    }

    private String c() {
        try {
            return a(MessageDigest.getInstance("SHA-1").digest(this.f16516a.l().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String e(Bundle bundle) throws IOException {
        if (bundle != null) {
            String string = bundle.getString("registration_id");
            if (string != null) {
                return string;
            }
            String string2 = bundle.getString("unregistered");
            if (string2 != null) {
                return string2;
            }
            String string3 = bundle.getString("error");
            if (!"RST".equals(string3)) {
                if (string3 != null) {
                    throw new IOException(string3);
                }
                String valueOf = String.valueOf(bundle);
                StringBuilder sb = new StringBuilder(valueOf.length() + 21);
                sb.append("Unexpected response: ");
                sb.append(valueOf);
                Log.w("FirebaseMessaging", sb.toString(), new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            }
            throw new IOException("INSTANCE_ID_RESET");
        }
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(String str) {
        if (!"SERVICE_NOT_AVAILABLE".equals(str) && !"INTERNAL_SERVER_ERROR".equals(str) && !"InternalServerError".equals(str)) {
            return false;
        }
        return true;
    }

    private Bundle h(String str, String str2, String str3, Bundle bundle) {
        HeartBeatInfo.HeartBeat b8;
        bundle.putString("scope", str3);
        bundle.putString("sender", str2);
        bundle.putString("subtype", str2);
        bundle.putString(AppsFlyerProperties.APP_ID, str);
        bundle.putString("gmp_app_id", this.f16516a.m().c());
        bundle.putString("gmsv", Integer.toString(this.f16517b.d()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", this.f16517b.a());
        bundle.putString("app_ver_name", this.f16517b.b());
        bundle.putString("firebase-app-name-hash", c());
        try {
            String b9 = ((InstallationTokenResult) Tasks.await(this.f16521f.a(false))).b();
            if (!TextUtils.isEmpty(b9)) {
                bundle.putString("Goog-Firebase-Installations-Auth", b9);
            } else {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            }
        } catch (InterruptedException | ExecutionException e8) {
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e8);
        }
        bundle.putString("cliv", "fcm-20.1.7_1p");
        HeartBeatInfo heartBeatInfo = this.f16520e.get();
        UserAgentPublisher userAgentPublisher = this.f16519d.get();
        if (heartBeatInfo != null && userAgentPublisher != null && (b8 = heartBeatInfo.b("fire-iid")) != HeartBeatInfo.HeartBeat.NONE) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(b8.a()));
            bundle.putString("Firebase-Client", userAgentPublisher.a());
        }
        return bundle;
    }

    private Task<Bundle> i(String str, String str2, String str3, Bundle bundle) {
        h(str, str2, str3, bundle);
        return this.f16518c.send(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<String> d(String str) {
        return b(i(str, Metadata.c(this.f16516a), "*", new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ String g(Task task) throws Exception {
        return e((Bundle) task.getResult(IOException.class));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> j(String str, String str2, String str3) {
        String str4;
        String str5;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "/topics/".concat(valueOf);
        } else {
            str4 = new String("/topics/");
        }
        bundle.putString("gcm.topic", str4);
        String valueOf2 = String.valueOf(str3);
        if (valueOf2.length() != 0) {
            str5 = "/topics/".concat(valueOf2);
        } else {
            str5 = new String("/topics/");
        }
        return b(i(str, str2, str5, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> k(String str, String str2, String str3) {
        String str4;
        String str5;
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf(str3);
        if (valueOf.length() != 0) {
            str4 = "/topics/".concat(valueOf);
        } else {
            str4 = new String("/topics/");
        }
        bundle.putString("gcm.topic", str4);
        bundle.putString("delete", "1");
        String valueOf2 = String.valueOf(str3);
        if (valueOf2.length() != 0) {
            str5 = "/topics/".concat(valueOf2);
        } else {
            str5 = new String("/topics/");
        }
        return b(i(str, str2, str5, bundle));
    }
}
