package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.cct.CctTransportBackend;
import com.google.android.datatransport.cct.internal.AndroidClientInfo;
import com.google.android.datatransport.cct.internal.BatchedLogRequest;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.LogEvent;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.android.datatransport.cct.internal.LogResponse;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.retries.Function;
import com.google.android.datatransport.runtime.retries.Retries;
import com.google.android.datatransport.runtime.retries.RetryStrategy;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.yalantis.ucrop.view.CropImageView;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class CctTransportBackend implements TransportBackend {

    /* renamed from: a  reason: collision with root package name */
    private final DataEncoder f11867a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectivityManager f11868b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f11869c;

    /* renamed from: d  reason: collision with root package name */
    final URL f11870d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f11871e;

    /* renamed from: f  reason: collision with root package name */
    private final Clock f11872f;

    /* renamed from: g  reason: collision with root package name */
    private final int f11873g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class HttpRequest {

        /* renamed from: a  reason: collision with root package name */
        final URL f11874a;

        /* renamed from: b  reason: collision with root package name */
        final BatchedLogRequest f11875b;

        /* renamed from: c  reason: collision with root package name */
        final String f11876c;

        HttpRequest(URL url, BatchedLogRequest batchedLogRequest, String str) {
            this.f11874a = url;
            this.f11875b = batchedLogRequest;
            this.f11876c = str;
        }

        HttpRequest a(URL url) {
            return new HttpRequest(url, this.f11875b, this.f11876c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class HttpResponse {

        /* renamed from: a  reason: collision with root package name */
        final int f11877a;

        /* renamed from: b  reason: collision with root package name */
        final URL f11878b;

        /* renamed from: c  reason: collision with root package name */
        final long f11879c;

        HttpResponse(int i8, URL url, long j8) {
            this.f11877a = i8;
            this.f11878b = url;
            this.f11879c = j8;
        }
    }

    CctTransportBackend(Context context, Clock clock, Clock clock2, int i8) {
        this.f11867a = BatchedLogRequest.b();
        this.f11869c = context;
        this.f11868b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f11870d = n(CCTDestination.f11859c);
        this.f11871e = clock2;
        this.f11872f = clock;
        this.f11873g = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HttpResponse e(HttpRequest httpRequest) throws IOException {
        Logging.f("CctTransportBackend", "Making request to: %s", httpRequest.f11874a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(httpRequest.f11874a.openConnection()));
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(this.f11873g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.1.7"));
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = httpRequest.f11876c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                this.f11867a.a(httpRequest.f11875b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                gZIPOutputStream.close();
                if (outputStream != null) {
                    outputStream.close();
                }
                int responseCode = httpURLConnection.getResponseCode();
                Logging.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                Logging.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                Logging.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                if (responseCode != 302 && responseCode != 301 && responseCode != 307) {
                    if (responseCode != 200) {
                        return new HttpResponse(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream m8 = m(inputStream, httpURLConnection.getHeaderField("Content-Encoding"));
                        HttpResponse httpResponse = new HttpResponse(responseCode, null, LogResponse.b(new BufferedReader(new InputStreamReader(m8))).c());
                        if (m8 != null) {
                            m8.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        return httpResponse;
                    } catch (Throwable th) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
                return new HttpResponse(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
            } catch (Throwable th3) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th3.addSuppressed(th4);
                    }
                }
                throw th3;
            }
        } catch (EncodingException e8) {
            e = e8;
            Logging.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new HttpResponse(400, null, 0L);
        } catch (ConnectException e9) {
            e = e9;
            Logging.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new HttpResponse(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, null, 0L);
        } catch (UnknownHostException e10) {
            e = e10;
            Logging.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new HttpResponse(CropImageView.DEFAULT_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, null, 0L);
        } catch (IOException e11) {
            e = e11;
            Logging.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new HttpResponse(400, null, 0L);
        }
    }

    private static int f(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.c();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.c();
        }
        if (NetworkConnectionInfo.MobileSubtype.a(subtype) == null) {
            return 0;
        }
        return subtype;
    }

    private static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.NetworkType.NONE.c();
        }
        return networkInfo.getType();
    }

    private static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e8) {
            Logging.d("CctTransportBackend", "Unable to find version code for package", e8);
            return -1;
        }
    }

    private BatchedLogRequest i(BackendRequest backendRequest) {
        LogEvent.Builder j8;
        HashMap hashMap = new HashMap();
        for (EventInternal eventInternal : backendRequest.b()) {
            String j9 = eventInternal.j();
            if (!hashMap.containsKey(j9)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(eventInternal);
                hashMap.put(j9, arrayList);
            } else {
                ((List) hashMap.get(j9)).add(eventInternal);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            EventInternal eventInternal2 = (EventInternal) ((List) entry.getValue()).get(0);
            LogRequest.Builder b8 = LogRequest.a().f(QosTier.DEFAULT).g(this.f11872f.a()).h(this.f11871e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(AndroidClientInfo.a().m(Integer.valueOf(eventInternal2.g("sdk-version"))).j(eventInternal2.b("model")).f(eventInternal2.b("hardware")).d(eventInternal2.b("device")).l(eventInternal2.b("product")).k(eventInternal2.b("os-uild")).h(eventInternal2.b("manufacturer")).e(eventInternal2.b("fingerprint")).c(eventInternal2.b("country")).g(eventInternal2.b("locale")).i(eventInternal2.b("mcc_mnc")).b(eventInternal2.b("application_build")).a()).a());
            try {
                b8.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                b8.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (EventInternal eventInternal3 : (List) entry.getValue()) {
                EncodedPayload e8 = eventInternal3.e();
                Encoding b9 = e8.b();
                if (b9.equals(Encoding.b("proto"))) {
                    j8 = LogEvent.j(e8.a());
                } else if (b9.equals(Encoding.b("json"))) {
                    j8 = LogEvent.i(new String(e8.a(), Charset.forName("UTF-8")));
                } else {
                    Logging.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", b9);
                }
                j8.c(eventInternal3.f()).d(eventInternal3.k()).h(eventInternal3.h("tz-offset")).e(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.a(eventInternal3.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.a(eventInternal3.g("mobile-subtype"))).a());
                if (eventInternal3.d() != null) {
                    j8.b(eventInternal3.d());
                }
                arrayList3.add(j8.a());
            }
            b8.c(arrayList3);
            arrayList2.add(b8.a());
        }
        return BatchedLogRequest.a(arrayList2);
    }

    private static TelephonyManager j(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    static long k() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HttpRequest l(HttpRequest httpRequest, HttpResponse httpResponse) {
        URL url = httpResponse.f11878b;
        if (url != null) {
            Logging.b("CctTransportBackend", "Following redirect to: %s", url);
            return httpRequest.a(httpResponse.f11878b);
        }
        return null;
    }

    private static InputStream m(InputStream inputStream, String str) throws IOException {
        if ("gzip".equals(str)) {
            return new GZIPInputStream(inputStream);
        }
        return inputStream;
    }

    private static URL n(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e8) {
            throw new IllegalArgumentException("Invalid url: " + str, e8);
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public EventInternal a(EventInternal eventInternal) {
        NetworkInfo activeNetworkInfo = this.f11868b.getActiveNetworkInfo();
        return eventInternal.l().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c("product", Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", k()).a("net-type", g(activeNetworkInfo)).a("mobile-subtype", f(activeNetworkInfo)).c("country", Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", j(this.f11869c).getSimOperator()).c("application_build", Integer.toString(h(this.f11869c))).d();
    }

    @Override // com.google.android.datatransport.runtime.backends.TransportBackend
    public BackendResponse b(BackendRequest backendRequest) {
        BatchedLogRequest i8 = i(backendRequest);
        URL url = this.f11870d;
        String str = null;
        if (backendRequest.c() != null) {
            try {
                CCTDestination c8 = CCTDestination.c(backendRequest.c());
                if (c8.d() != null) {
                    str = c8.d();
                }
                if (c8.e() != null) {
                    url = n(c8.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            HttpResponse httpResponse = (HttpResponse) Retries.a(5, new HttpRequest(url, i8, str), new Function() { // from class: com.google.android.datatransport.cct.a
                @Override // com.google.android.datatransport.runtime.retries.Function
                public final Object apply(Object obj) {
                    CctTransportBackend.HttpResponse e8;
                    e8 = CctTransportBackend.this.e((CctTransportBackend.HttpRequest) obj);
                    return e8;
                }
            }, new RetryStrategy() { // from class: com.google.android.datatransport.cct.b
                @Override // com.google.android.datatransport.runtime.retries.RetryStrategy
                public final Object a(Object obj, Object obj2) {
                    CctTransportBackend.HttpRequest l8;
                    l8 = CctTransportBackend.l((CctTransportBackend.HttpRequest) obj, (CctTransportBackend.HttpResponse) obj2);
                    return l8;
                }
            });
            int i9 = httpResponse.f11877a;
            if (i9 == 200) {
                return BackendResponse.e(httpResponse.f11879c);
            }
            if (i9 < 500 && i9 != 404) {
                if (i9 == 400) {
                    return BackendResponse.d();
                }
                return BackendResponse.a();
            }
            return BackendResponse.f();
        } catch (IOException e8) {
            Logging.d("CctTransportBackend", "Could not make request to the backend", e8);
            return BackendResponse.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CctTransportBackend(Context context, Clock clock, Clock clock2) {
        this(context, clock, clock2, 130000);
    }
}
