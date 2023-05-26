package com.google.firebase.crashlytics.internal.network;

import androidx.fragment.app.FragmentTransaction;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;

/* loaded from: classes3.dex */
public class HttpGetRequest {

    /* renamed from: a  reason: collision with root package name */
    private final String f16113a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, String> f16114b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f16115c = new HashMap();

    public HttpGetRequest(String str, Map<String, String> map) {
        this.f16113a = str;
        this.f16114b = map;
    }

    private String a(Map<String, String> map) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        Map.Entry<String, String> next = it.next();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(next.getKey());
        sb2.append("=");
        if (next.getValue() == null) {
            str = "";
        } else {
            str = next.getValue();
        }
        sb2.append(str);
        sb.append(sb2.toString());
        while (it.hasNext()) {
            Map.Entry<String, String> next2 = it.next();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("&");
            sb3.append(next2.getKey());
            sb3.append("=");
            if (next2.getValue() == null) {
                str2 = "";
            } else {
                str2 = next2.getValue();
            }
            sb3.append(str2);
            sb.append(sb3.toString());
        }
        return sb.toString();
    }

    private String b(String str, Map<String, String> map) {
        String a8 = a(map);
        if (a8.isEmpty()) {
            return str;
        }
        if (str.contains("?")) {
            if (!str.endsWith("&")) {
                a8 = "&" + a8;
            }
            return str + a8;
        }
        return str + "?" + a8;
    }

    private String e(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        char[] cArr = new char[FragmentTransaction.TRANSIT_EXIT_MASK];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                sb.append(cArr, 0, read);
            } else {
                return sb.toString();
            }
        }
    }

    public HttpResponse c() throws IOException {
        HttpsURLConnection httpsURLConnection;
        InputStream inputStream = null;
        String e8 = null;
        inputStream = null;
        try {
            String b8 = b(this.f16113a, this.f16114b);
            Logger.f().i("GET Request URL: " + b8);
            httpsURLConnection = (HttpsURLConnection) new URL(b8).openConnection();
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry<String, String> entry : this.f16115c.entrySet()) {
                    httpsURLConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        e8 = e(inputStream2);
                    } catch (Throwable th) {
                        th = th;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new HttpResponse(responseCode, e8);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpsURLConnection = null;
        }
    }

    public HttpGetRequest d(String str, String str2) {
        this.f16115c.put(str, str2);
        return this;
    }
}
