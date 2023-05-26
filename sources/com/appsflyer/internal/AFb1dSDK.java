package com.appsflyer.internal;

import android.app.Activity;
import android.content.Context;

/* loaded from: classes.dex */
public interface AFb1dSDK {
    public static final AFa1xSDK AFa1xSDK = AFa1xSDK.AFKeystoreWrapper;

    /* loaded from: classes.dex */
    public interface AFa1wSDK {
        void AFKeystoreWrapper(Context context);

        void valueOf(Activity activity);
    }

    /* loaded from: classes.dex */
    public static final class AFa1xSDK {
        static final /* synthetic */ AFa1xSDK AFKeystoreWrapper = new AFa1xSDK();
        private static long valueOf = 500;

        private AFa1xSDK() {
        }

        public static long AFKeystoreWrapper() {
            return valueOf;
        }
    }

    void AFKeystoreWrapper(Context context);

    boolean valueOf();

    void values(Context context, AFa1wSDK aFa1wSDK);
}
