package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzg;
import com.google.android.gms.internal.firebase_messaging.zzh;
import com.google.android.gms.internal.firebase_messaging.zzo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes3.dex */
public class ImageDownload implements Closeable {

    /* renamed from: f  reason: collision with root package name */
    private final URL f16524f;

    /* renamed from: g  reason: collision with root package name */
    private Task<Bitmap> f16525g;

    /* renamed from: h  reason: collision with root package name */
    private volatile InputStream f16526h;

    private ImageDownload(URL url) {
        this.f16524f = url;
    }

    private byte[] c() throws IOException {
        URLConnection openConnection = this.f16524f.openConnection();
        if (openConnection.getContentLength() <= 1048576) {
            InputStream inputStream = openConnection.getInputStream();
            try {
                this.f16526h = inputStream;
                byte[] zza = zzg.zza(zzg.zzb(inputStream, 1048577L));
                if (inputStream != null) {
                    inputStream.close();
                }
                if (Log.isLoggable("FirebaseMessaging", 2)) {
                    String valueOf = String.valueOf(this.f16524f);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 34);
                    sb.append("Downloaded ");
                    sb.append(zza.length);
                    sb.append(" bytes from ");
                    sb.append(valueOf);
                    Log.v("FirebaseMessaging", sb.toString());
                }
                if (zza.length <= 1048576) {
                    return zza;
                }
                throw new IOException("Image exceeds max size of 1048576");
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        zzo.zza(th, th2);
                    }
                }
                throw th;
            }
        }
        throw new IOException("Content-Length exceeds max size of 1048576");
    }

    public static ImageDownload e(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new ImageDownload(new URL(str));
        } catch (MalformedURLException unused) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Not downloading image, bad URL: ".concat(valueOf);
            } else {
                str2 = new String("Not downloading image, bad URL: ");
            }
            Log.w("FirebaseMessaging", str2);
            return null;
        }
    }

    public Bitmap a() throws IOException {
        String valueOf = String.valueOf(this.f16524f);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Starting download of: ");
        sb.append(valueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] c8 = c();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(c8, 0, c8.length);
        if (decodeByteArray != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf2 = String.valueOf(this.f16524f);
                StringBuilder sb2 = new StringBuilder(valueOf2.length() + 31);
                sb2.append("Successfully downloaded image: ");
                sb2.append(valueOf2);
                Log.d("FirebaseMessaging", sb2.toString());
            }
            return decodeByteArray;
        }
        String valueOf3 = String.valueOf(this.f16524f);
        StringBuilder sb3 = new StringBuilder(valueOf3.length() + 24);
        sb3.append("Failed to decode image: ");
        sb3.append(valueOf3);
        throw new IOException(sb3.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            zzh.zza(this.f16526h);
        } catch (NullPointerException e8) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e8);
        }
    }

    public Task<Bitmap> g() {
        return (Task) Preconditions.checkNotNull(this.f16525g);
    }

    public void h(Executor executor) {
        this.f16525g = Tasks.call(executor, new Callable(this) { // from class: com.google.firebase.messaging.ImageDownload$$Lambda$0

            /* renamed from: f  reason: collision with root package name */
            private final ImageDownload f16527f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f16527f = this;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return this.f16527f.a();
            }
        });
    }
}
