package com.sinch.android.rtc.internal.client.libloader;

import android.content.Context;
import android.util.Log;
import com.sinch.android.rtc.internal.client.libloader.NativeLibLoader;
import com.sinch.relinker.ReLinker;
import com.sinch.relinker.ReLinkerInstance;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ReLinkerLibraryLoader implements NativeLibLoader.LibraryLoader {
    private final ReLinkerInstance mReLinker;

    /* loaded from: classes3.dex */
    public static class GlobalHolder {
        public static final ReLinkerLibraryLoader INSTANCE = new ReLinkerLibraryLoader();

        private GlobalHolder() {
        }
    }

    private ReLinkerLibraryLoader() {
        this.mReLinker = ReLinker.log(new ReLinker.Logger() { // from class: com.sinch.android.rtc.internal.client.libloader.ReLinkerLibraryLoader.1
            @Override // com.sinch.relinker.ReLinker.Logger
            public void log(String str) {
                Log.d("ReLinkerLibraryLoader", str);
            }
        });
    }

    public static NativeLibLoader.LibraryLoader getGlobalInstance() {
        return GlobalHolder.INSTANCE;
    }

    @Override // com.sinch.android.rtc.internal.client.libloader.NativeLibLoader.LibraryLoader
    public void loadLibrary(Context context, String str, String str2) {
        this.mReLinker.loadLibrary(context, str, str2);
    }
}
