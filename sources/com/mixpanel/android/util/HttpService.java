package com.mixpanel.android.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.fragment.app.FragmentTransaction;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes3.dex */
public class HttpService implements RemoteService {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f19425a;

    private boolean f(OfflineMode offlineMode) {
        if (offlineMode == null) {
            return false;
        }
        try {
            if (!offlineMode.a()) {
                return false;
            }
            return true;
        } catch (Exception e8) {
            MPLog.j("MixpanelAPI.Message", "Client State should not throw exception, will assume is not on offline mode", e8);
            return false;
        }
    }

    private static byte[] g(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[FragmentTransaction.TRANSIT_EXIT_MASK];
        while (true) {
            int read = inputStream.read(bArr, 0, FragmentTransaction.TRANSIT_EXIT_MASK);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0149 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0132 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x001a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0150  */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v10, types: [java.io.OutputStream, java.io.BufferedOutputStream] */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v17 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r9v9 */
    @Override // com.mixpanel.android.util.RemoteService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public byte[] a(java.lang.String r12, java.util.Map<java.lang.String, java.lang.Object> r13, javax.net.ssl.SSLSocketFactory r14) throws com.mixpanel.android.util.RemoteService.ServiceUnavailableException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.HttpService.a(java.lang.String, java.util.Map, javax.net.ssl.SSLSocketFactory):byte[]");
    }

    @Override // com.mixpanel.android.util.RemoteService
    @SuppressLint({"MissingPermission"})
    public boolean b(Context context, OfflineMode offlineMode) {
        String str;
        if (f19425a || f(offlineMode)) {
            return false;
        }
        boolean z7 = true;
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                MPLog.i("MixpanelAPI.Message", "A default network has not been set so we cannot be certain whether we are offline");
            } else {
                boolean isConnectedOrConnecting = activeNetworkInfo.isConnectedOrConnecting();
                StringBuilder sb = new StringBuilder();
                sb.append("ConnectivityManager says we ");
                if (isConnectedOrConnecting) {
                    str = "are";
                } else {
                    str = "are not";
                }
                sb.append(str);
                sb.append(" online");
                MPLog.i("MixpanelAPI.Message", sb.toString());
                z7 = isConnectedOrConnecting;
            }
        } catch (SecurityException unused) {
            MPLog.i("MixpanelAPI.Message", "Don't have permission to check connectivity, will assume we are online");
        }
        return z7;
    }

    @Override // com.mixpanel.android.util.RemoteService
    public void c() {
        new Thread(new Runnable() { // from class: com.mixpanel.android.util.HttpService.1
            /* JADX WARN: Removed duplicated region for block: B:15:0x0031 A[Catch: Exception -> 0x0038, TRY_LEAVE, TryCatch #0 {Exception -> 0x0038, blocks: (B:2:0x0000, B:4:0x0012, B:6:0x0018, B:8:0x001e, B:13:0x0028, B:15:0x0031), top: B:18:0x0000 }] */
            /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    r3 = this;
                    java.lang.String r0 = "api.mixpanel.com"
                    java.net.InetAddress r0 = java.net.InetAddress.getByName(r0)     // Catch: java.lang.Exception -> L38
                    java.lang.String r1 = "decide.mixpanel.com"
                    java.net.InetAddress r1 = java.net.InetAddress.getByName(r1)     // Catch: java.lang.Exception -> L38
                    boolean r2 = r0.isLoopbackAddress()     // Catch: java.lang.Exception -> L38
                    if (r2 != 0) goto L27
                    boolean r0 = r0.isAnyLocalAddress()     // Catch: java.lang.Exception -> L38
                    if (r0 != 0) goto L27
                    boolean r0 = r1.isLoopbackAddress()     // Catch: java.lang.Exception -> L38
                    if (r0 != 0) goto L27
                    boolean r0 = r1.isAnyLocalAddress()     // Catch: java.lang.Exception -> L38
                    if (r0 == 0) goto L25
                    goto L27
                L25:
                    r0 = 0
                    goto L28
                L27:
                    r0 = 1
                L28:
                    com.mixpanel.android.util.HttpService.e(r0)     // Catch: java.lang.Exception -> L38
                    boolean r0 = com.mixpanel.android.util.HttpService.d()     // Catch: java.lang.Exception -> L38
                    if (r0 == 0) goto L38
                    java.lang.String r0 = "MixpanelAPI.Message"
                    java.lang.String r1 = "AdBlocker is enabled. Won't be able to use Mixpanel services."
                    com.mixpanel.android.util.MPLog.i(r0, r1)     // Catch: java.lang.Exception -> L38
                L38:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.util.HttpService.AnonymousClass1.run():void");
            }
        }).start();
    }
}
