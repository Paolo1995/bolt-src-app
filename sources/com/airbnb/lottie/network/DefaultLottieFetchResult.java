package com.airbnb.lottie.network;

import androidx.annotation.NonNull;
import com.airbnb.lottie.utils.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

/* loaded from: classes.dex */
public class DefaultLottieFetchResult implements LottieFetchResult {
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final HttpURLConnection f9516f;

    public DefaultLottieFetchResult(@NonNull HttpURLConnection httpURLConnection) {
        this.f9516f = httpURLConnection;
    }

    private String a(HttpURLConnection httpURLConnection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append('\n');
                } else {
                    try {
                        break;
                    } catch (Exception unused) {
                    }
                }
            } finally {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
            }
        }
        return sb.toString();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String P() {
        return this.f9516f.getContentType();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    @NonNull
    public InputStream T() throws IOException {
        return this.f9516f.getInputStream();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f9516f.disconnect();
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public String i() {
        try {
            if (isSuccessful()) {
                return null;
            }
            return "Unable to fetch " + this.f9516f.getURL() + ". Failed with " + this.f9516f.getResponseCode() + "\n" + a(this.f9516f);
        } catch (IOException e8) {
            Logger.d("get error failed ", e8);
            return e8.getMessage();
        }
    }

    @Override // com.airbnb.lottie.network.LottieFetchResult
    public boolean isSuccessful() {
        try {
            if (this.f9516f.getResponseCode() / 100 != 2) {
                return false;
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
