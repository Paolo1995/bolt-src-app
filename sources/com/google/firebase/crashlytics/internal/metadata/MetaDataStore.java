package com.google.firebase.crashlytics.internal.metadata;

import androidx.annotation.NonNull;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class MetaDataStore {

    /* renamed from: b  reason: collision with root package name */
    private static final Charset f15738b = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    private final FileStore f15739a;

    public MetaDataStore(FileStore fileStore) {
        this.f15739a = fileStore;
    }

    private static Map<String, String> d(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, k(jSONObject, next));
        }
        return hashMap;
    }

    private String e(String str) throws JSONException {
        return k(new JSONObject(str), "userId");
    }

    private static String f(Map<String, String> map) {
        return new JSONObject(map).toString();
    }

    private static void i(File file) {
        if (file.exists() && file.delete()) {
            Logger f8 = Logger.f();
            f8.g("Deleted corrupt file: " + file.getAbsolutePath());
        }
    }

    private static String j(String str) throws JSONException {
        return new JSONObject(str) { // from class: com.google.firebase.crashlytics.internal.metadata.MetaDataStore.1

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ String f15740a;

            {
                this.f15740a = str;
                put("userId", str);
            }
        }.toString();
    }

    private static String k(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    @NonNull
    public File a(String str) {
        return this.f15739a.o(str, "internal-keys");
    }

    @NonNull
    public File b(String str) {
        return this.f15739a.o(str, "keys");
    }

    @NonNull
    public File c(String str) {
        return this.f15739a.o(str, "user-data");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> g(String str, boolean z7) {
        File b8;
        FileInputStream fileInputStream;
        Exception e8;
        if (z7) {
            b8 = a(str);
        } else {
            b8 = b(str);
        }
        if (b8.exists() && b8.length() != 0) {
            FileInputStream fileInputStream2 = null;
            try {
                fileInputStream = new FileInputStream(b8);
            } catch (Exception e9) {
                fileInputStream = null;
                e8 = e9;
            } catch (Throwable th) {
                th = th;
                CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
            try {
                try {
                    Map<String, String> d8 = d(CommonUtils.C(fileInputStream));
                    CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                    return d8;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e10) {
                e8 = e10;
                Logger.f().l("Error deserializing user metadata.", e8);
                i(b8);
                CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                return Collections.emptyMap();
            }
        }
        i(b8);
        return Collections.emptyMap();
    }

    public String h(String str) {
        FileInputStream fileInputStream;
        File c8 = c(str);
        FileInputStream fileInputStream2 = null;
        if (c8.exists() && c8.length() != 0) {
            try {
                fileInputStream = new FileInputStream(c8);
            } catch (Exception e8) {
                e = e8;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
                throw th;
            }
            try {
                try {
                    String e9 = e(CommonUtils.C(fileInputStream));
                    Logger.f().b("Loaded userId " + e9 + " for session " + str);
                    CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                    return e9;
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    CommonUtils.e(fileInputStream2, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Exception e10) {
                e = e10;
                Logger.f().l("Error deserializing user metadata.", e);
                i(c8);
                CommonUtils.e(fileInputStream, "Failed to close user metadata file.");
                return null;
            }
        }
        Logger.f().b("No userId set for session " + str);
        i(c8);
        return null;
    }

    public void l(String str, Map<String, String> map, boolean z7) {
        File b8;
        if (z7) {
            b8 = a(str);
        } else {
            b8 = b(str);
        }
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String f8 = f(map);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(b8), f15738b));
                try {
                    bufferedWriter2.write(f8);
                    bufferedWriter2.flush();
                    CommonUtils.e(bufferedWriter2, "Failed to close key/value metadata file.");
                } catch (Exception e8) {
                    e = e8;
                    bufferedWriter = bufferedWriter2;
                    Logger.f().l("Error serializing key/value metadata.", e);
                    i(b8);
                    CommonUtils.e(bufferedWriter, "Failed to close key/value metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.e(bufferedWriter, "Failed to close key/value metadata file.");
                    throw th;
                }
            } catch (Exception e9) {
                e = e9;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void m(String str, String str2) {
        File c8 = c(str);
        BufferedWriter bufferedWriter = null;
        try {
            try {
                String j8 = j(str2);
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(c8), f15738b));
                try {
                    bufferedWriter2.write(j8);
                    bufferedWriter2.flush();
                    CommonUtils.e(bufferedWriter2, "Failed to close user metadata file.");
                } catch (Exception e8) {
                    e = e8;
                    bufferedWriter = bufferedWriter2;
                    Logger.f().l("Error serializing user metadata.", e);
                    CommonUtils.e(bufferedWriter, "Failed to close user metadata file.");
                } catch (Throwable th) {
                    th = th;
                    bufferedWriter = bufferedWriter2;
                    CommonUtils.e(bufferedWriter, "Failed to close user metadata file.");
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e9) {
            e = e9;
        }
    }
}
