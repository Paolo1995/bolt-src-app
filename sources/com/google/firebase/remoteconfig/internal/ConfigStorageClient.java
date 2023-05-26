package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ConfigStorageClient {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, ConfigStorageClient> f17124c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private final Context f17125a;

    /* renamed from: b  reason: collision with root package name */
    private final String f17126b;

    private ConfigStorageClient(Context context, String str) {
        this.f17125a = context;
        this.f17126b = str;
    }

    public static synchronized ConfigStorageClient c(Context context, String str) {
        ConfigStorageClient configStorageClient;
        synchronized (ConfigStorageClient.class) {
            Map<String, ConfigStorageClient> map = f17124c;
            if (!map.containsKey(str)) {
                map.put(str, new ConfigStorageClient(context, str));
            }
            configStorageClient = map.get(str);
        }
        return configStorageClient;
    }

    public synchronized Void a() {
        this.f17125a.deleteFile(this.f17126b);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f17126b;
    }

    @Nullable
    public synchronized ConfigContainer d() throws IOException {
        FileInputStream fileInputStream;
        Throwable th;
        try {
            fileInputStream = this.f17125a.openFileInput(this.f17126b);
        } catch (FileNotFoundException | JSONException unused) {
            fileInputStream = null;
        } catch (Throwable th2) {
            fileInputStream = null;
            th = th2;
        }
        try {
            int available = fileInputStream.available();
            byte[] bArr = new byte[available];
            fileInputStream.read(bArr, 0, available);
            ConfigContainer b8 = ConfigContainer.b(new JSONObject(new String(bArr, "UTF-8")));
            fileInputStream.close();
            return b8;
        } catch (FileNotFoundException | JSONException unused2) {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public synchronized Void e(ConfigContainer configContainer) throws IOException {
        FileOutputStream openFileOutput = this.f17125a.openFileOutput(this.f17126b, 0);
        openFileOutput.write(configContainer.toString().getBytes("UTF-8"));
        openFileOutput.close();
        return null;
    }
}
