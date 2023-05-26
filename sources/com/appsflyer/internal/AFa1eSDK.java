package com.appsflyer.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import com.appsflyer.AFLogger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

@Deprecated
/* loaded from: classes.dex */
public final class AFa1eSDK {
    public final String[] AFInAppEventType;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class AFa1ySDK {
        final String valueOf;
        private final boolean values;

        AFa1ySDK(String str, boolean z7) {
            this.valueOf = str;
            this.values = z7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean AFKeystoreWrapper() {
            return this.values;
        }
    }

    /* loaded from: classes.dex */
    static final class AFa1zSDK implements IInterface {
        private final IBinder AFInAppEventParameterName;

        AFa1zSDK(IBinder iBinder) {
            this.AFInAppEventParameterName = iBinder;
        }

        public final String AFInAppEventParameterName() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.AFInAppEventParameterName.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        final boolean AFKeystoreWrapper() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z7 = true;
                obtain.writeInt(1);
                this.AFInAppEventParameterName.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z7 = false;
                }
                return z7;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return this.AFInAppEventParameterName;
        }
    }

    AFa1eSDK() {
    }

    public AFa1eSDK(String... strArr) {
        if (strArr != null && strArr.length != 0) {
            Pattern compile = Pattern.compile("[\\w]{1,45}");
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (str != null && compile.matcher(str).matches()) {
                    arrayList.add(str.toLowerCase(Locale.getDefault()));
                } else {
                    AFLogger.afWarnLog("Invalid partner name: ".concat(String.valueOf(str)));
                }
            }
            if (arrayList.contains("all")) {
                this.AFInAppEventType = new String[]{"all"};
                return;
            } else if (!arrayList.isEmpty()) {
                this.AFInAppEventType = (String[]) arrayList.toArray(new String[0]);
                return;
            } else {
                this.AFInAppEventType = null;
                return;
            }
        }
        this.AFInAppEventType = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AFa1ySDK values(Context context) throws Exception {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            AFa1wSDK aFa1wSDK = new AFa1wSDK((byte) 0);
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, aFa1wSDK, 1)) {
                    if (!aFa1wSDK.valueOf) {
                        aFa1wSDK.valueOf = true;
                        IBinder poll = aFa1wSDK.AFKeystoreWrapper.poll(10L, TimeUnit.SECONDS);
                        if (poll != null) {
                            AFa1zSDK aFa1zSDK = new AFa1zSDK(poll);
                            return new AFa1ySDK(aFa1zSDK.AFInAppEventParameterName(), aFa1zSDK.AFKeystoreWrapper());
                        }
                        throw new TimeoutException("Timed out waiting for the service connection");
                    }
                    throw new IllegalStateException("Cannot call get on this connection more than once");
                }
                context.unbindService(aFa1wSDK);
                throw new IOException("Google Play connection failed");
            } finally {
                context.unbindService(aFa1wSDK);
            }
        }
        throw new IllegalStateException("Cannot be called from the main thread");
    }

    /* loaded from: classes.dex */
    static final class AFa1wSDK implements ServiceConnection {
        final LinkedBlockingQueue<IBinder> AFKeystoreWrapper;
        boolean valueOf;

        private AFa1wSDK() {
            this.AFKeystoreWrapper = new LinkedBlockingQueue<>(1);
            this.valueOf = false;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.AFKeystoreWrapper.put(iBinder);
            } catch (InterruptedException e8) {
                AFLogger.afErrorLogForExcManagerOnly("onServiceConnected Interrupted", e8);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
        }

        /* synthetic */ AFa1wSDK(byte b8) {
            this();
        }
    }
}
