package com.mixpanel.android.util;

import android.content.Context;
import java.io.IOException;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes3.dex */
public interface RemoteService {

    /* loaded from: classes3.dex */
    public static class ServiceUnavailableException extends Exception {

        /* renamed from: f  reason: collision with root package name */
        private final int f19434f;

        public ServiceUnavailableException(String str, String str2) {
            super(str);
            int i8;
            try {
                i8 = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                i8 = 0;
            }
            this.f19434f = i8;
        }

        public int a() {
            return this.f19434f;
        }
    }

    byte[] a(String str, Map<String, Object> map, SSLSocketFactory sSLSocketFactory) throws ServiceUnavailableException, IOException;

    boolean b(Context context, OfflineMode offlineMode);

    void c();
}
