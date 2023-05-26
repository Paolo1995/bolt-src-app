package com.sinch.android.rtc.internal.client.libloader;

import android.content.Context;
import android.util.Log;

/* loaded from: classes3.dex */
public final class NativeLibLoader {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String TAG = "NativeLibLoader";
    private static boolean sLoaded = false;
    private static LibraryLoader sLoader;

    /* loaded from: classes3.dex */
    public interface LibraryLoader {
        void loadLibrary(Context context, String str, String str2);
    }

    private static synchronized LibraryLoader getLibraryLoader() {
        synchronized (NativeLibLoader.class) {
            LibraryLoader libraryLoader = sLoader;
            if (libraryLoader != null) {
                return libraryLoader;
            }
            return ReLinkerLibraryLoader.getGlobalInstance();
        }
    }

    private static boolean isReserveAddressSpaceOomError(Throwable th) {
        if (th == null || th.getMessage() == null) {
            return false;
        }
        return th.getMessage().contains("couldn't reserve");
    }

    public static synchronized void loadAllRequiredLibraries(Context context) throws UnsatisfiedLinkError {
        synchronized (NativeLibLoader.class) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            if (sLoaded) {
                Log.i(TAG, "Sinch native libraries already loaded, returning early");
                return;
            }
            loadAllRequiredLibrariesInternal(context);
            sLoaded = true;
        }
    }

    private static void loadAllRequiredLibrariesInternal(Context context) throws UnsatisfiedLinkError {
        try {
            getLibraryLoader().loadLibrary(context, "sinch-android-rtc", "5.10.7");
        } catch (UnsatisfiedLinkError e8) {
            try {
                Log.e(TAG, "Failed to load Sinch native libraries", e8);
            } catch (Throwable unused) {
            }
            if (!isReserveAddressSpaceOomError(e8)) {
                throw e8;
            }
            throw new OutOfMemoryError(e8.getMessage());
        }
    }

    public static synchronized void setLibraryLoader(LibraryLoader libraryLoader) {
        synchronized (NativeLibLoader.class) {
            if (libraryLoader == null) {
                throw new IllegalArgumentException("LibraryLoader must not be null");
            }
            if (sLoader != null) {
                Log.w(TAG, "Re-assigning LibraryLoader");
            }
            sLoader = libraryLoader;
        }
    }
}
