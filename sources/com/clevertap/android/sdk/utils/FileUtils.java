package com.clevertap.android.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.Logger;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class FileUtils {

    /* renamed from: a  reason: collision with root package name */
    private final CleverTapInstanceConfig f11817a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f11818b;

    public FileUtils(@NonNull Context context, @NonNull CleverTapInstanceConfig cleverTapInstanceConfig) {
        this.f11818b = context;
        this.f11817a = cleverTapInstanceConfig;
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            synchronized (FileUtils.class) {
                File file = new File(this.f11818b.getFilesDir(), str);
                if (file.exists()) {
                    if (file.delete()) {
                        Logger n8 = this.f11817a.n();
                        String c8 = this.f11817a.c();
                        n8.s(c8, "File Deleted:" + str);
                    } else {
                        Logger n9 = this.f11817a.n();
                        String c9 = this.f11817a.c();
                        n9.s(c9, "Failed to delete file" + str);
                    }
                }
            }
        } catch (Exception e8) {
            e8.printStackTrace();
            Logger n10 = this.f11817a.n();
            String c10 = this.f11817a.c();
            n10.s(c10, "writeFileOnInternalStorage: failed" + str + " Error:" + e8.getLocalizedMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b(java.lang.String r8) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            r1.<init>()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            android.content.Context r2 = r7.f11818b     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            java.io.File r2 = r2.getFilesDir()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            r1.append(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            r1.append(r8)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            java.lang.String r8 = r1.toString()     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            r1.<init>(r8)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            r8.<init>(r1)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L68
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5d
            r1.<init>()     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5d
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5d
            r2.<init>(r8)     // Catch: java.lang.Throwable -> L58 java.lang.Exception -> L5d
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L55
        L34:
            java.lang.String r0 = r3.readLine()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> La3
            if (r0 == 0) goto L3e
            r1.append(r0)     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> La3
            goto L34
        L3e:
            r8.close()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> La3
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L50 java.lang.Throwable -> La3
            r8.close()
            r2.close()
            r3.close()
            goto La2
        L50:
            r0 = move-exception
            goto L6d
        L52:
            r1 = move-exception
            r3 = r0
            goto L5b
        L55:
            r1 = move-exception
            r3 = r0
            goto L60
        L58:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L5b:
            r0 = r1
            goto La4
        L5d:
            r1 = move-exception
            r2 = r0
            r3 = r2
        L60:
            r0 = r1
            goto L6d
        L62:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
            goto La4
        L68:
            r8 = move-exception
            r2 = r0
            r3 = r2
            r0 = r8
            r8 = r3
        L6d:
            com.clevertap.android.sdk.CleverTapInstanceConfig r1 = r7.f11817a     // Catch: java.lang.Throwable -> La3
            com.clevertap.android.sdk.Logger r1 = r1.n()     // Catch: java.lang.Throwable -> La3
            com.clevertap.android.sdk.CleverTapInstanceConfig r4 = r7.f11817a     // Catch: java.lang.Throwable -> La3
            java.lang.String r4 = r4.c()     // Catch: java.lang.Throwable -> La3
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La3
            r5.<init>()     // Catch: java.lang.Throwable -> La3
            java.lang.String r6 = "[Exception While Reading: "
            r5.append(r6)     // Catch: java.lang.Throwable -> La3
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch: java.lang.Throwable -> La3
            r5.append(r0)     // Catch: java.lang.Throwable -> La3
            java.lang.String r0 = r5.toString()     // Catch: java.lang.Throwable -> La3
            r1.s(r4, r0)     // Catch: java.lang.Throwable -> La3
            if (r8 == 0) goto L96
            r8.close()
        L96:
            if (r2 == 0) goto L9b
            r2.close()
        L9b:
            if (r3 == 0) goto La0
            r3.close()
        La0:
            java.lang.String r0 = ""
        La2:
            return r0
        La3:
            r0 = move-exception
        La4:
            if (r8 == 0) goto La9
            r8.close()
        La9:
            if (r2 == 0) goto Lae
            r2.close()
        Lae:
            if (r3 == 0) goto Lb3
            r3.close()
        Lb3:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.clevertap.android.sdk.utils.FileUtils.b(java.lang.String):java.lang.String");
    }

    public void c(String str, String str2, JSONObject jSONObject) throws IOException {
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                try {
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        synchronized (FileUtils.class) {
                            try {
                                File file = new File(this.f11818b.getFilesDir(), str);
                                if (!file.exists() && !file.mkdir()) {
                                    return;
                                }
                                FileWriter fileWriter2 = new FileWriter(new File(file, str2), false);
                                try {
                                    fileWriter2.append((CharSequence) jSONObject.toString());
                                    fileWriter2.flush();
                                    fileWriter2.close();
                                    return;
                                } catch (Throwable th) {
                                    th = th;
                                    fileWriter = fileWriter2;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                    throw th3;
                }
            } catch (Exception e8) {
                e8.printStackTrace();
                Logger n8 = this.f11817a.n();
                String c8 = this.f11817a.c();
                n8.s(c8, "writeFileOnInternalStorage: failed" + e8.getLocalizedMessage());
                if (fileWriter != null) {
                    fileWriter.close();
                }
            }
        }
    }
}
