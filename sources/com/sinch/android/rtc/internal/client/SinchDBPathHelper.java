package com.sinch.android.rtc.internal.client;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;

/* loaded from: classes3.dex */
public class SinchDBPathHelper {
    private static final String DATABASE_SUBDIR = DefaultSinchClient.PAYLOAD_TAG_SINCH + File.separator + "db";
    private static final String PERSISTENCE_DATABASE_FILENAME = "main.sqlite";
    private final Context mContext;

    public SinchDBPathHelper(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context must not be null");
        }
        this.mContext = context;
    }

    private static synchronized String getDatabasePath(Context context, String str, String str2) throws IOException {
        String str3;
        synchronized (SinchDBPathHelper.class) {
            File filesDir = context.getFilesDir();
            if (filesDir == null) {
                Log.e("Sinch", "Error during Sinch DB initialization: Context.getFilesDir() fails.");
                throw new IOException("Error during Sinch DB initialization: Context.getFilesDir() fails.");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(filesDir.getAbsolutePath());
            String str4 = File.separator;
            sb.append(str4);
            sb.append(DATABASE_SUBDIR);
            sb.append(str4);
            sb.append(str);
            String sb2 = sb.toString();
            if (!new File(sb2).isDirectory() && !new File(sb2).mkdirs()) {
                Log.e("Sinch", "Error during Sinch DB initialization: File(...).mkdirs() fails.");
                throw new IOException("Error during Sinch DB initialization: File(...).mkdirs() fails.");
            }
            str3 = sb2 + str4 + str2;
        }
        return str3;
    }

    private static String persistentStoragePathForApp(String str) {
        return Sha1Utils.bytesToHex(Sha1Utils.sha1(str)).substring(0, 8);
    }

    public String getPathForPersistenceServiceDatabase(String str) throws IOException {
        return getDatabasePath(this.mContext, persistentStoragePathForApp(str), PERSISTENCE_DATABASE_FILENAME);
    }
}
