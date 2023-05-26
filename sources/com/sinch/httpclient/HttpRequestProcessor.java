package com.sinch.httpclient;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
final class HttpRequestProcessor {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    private static final int RESPONSE_BUFFER_SIZE = 1024;
    private final HttpURLConnection mConnection;
    private final Request mRequest;
    private final AtomicBoolean mRun = new AtomicBoolean(false);

    public HttpRequestProcessor(Request request, HttpURLConnection httpURLConnection) {
        this.mRequest = request;
        this.mConnection = httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void closeStreamsQuietly(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            closeQuietly(httpURLConnection.getInputStream());
        } catch (Exception unused) {
        }
        try {
            closeQuietly(httpURLConnection.getOutputStream());
        } catch (Exception unused2) {
        }
    }

    private static Map<String, String> flattenHeaders(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        for (String str : map.keySet()) {
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = map.get(str).iterator();
                if (it.hasNext()) {
                    while (true) {
                        sb.append(it.next());
                        if (!it.hasNext()) {
                            break;
                        }
                        sb.append(", ");
                    }
                }
                hashMap.put(str, sb.toString());
            }
        }
        return hashMap;
    }

    private static byte[] readResponseBody(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return EMPTY_BYTE_ARRAY;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } finally {
            closeQuietly(inputStream);
        }
    }

    private void setConnectionProperties() throws ProtocolException {
        Map<String, String> map = this.mRequest.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.mConnection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        String str = this.mRequest.method;
        if (str == null) {
            throw new IllegalArgumentException("Http method cannot be null.");
        }
        this.mConnection.setRequestMethod(str);
    }

    private static boolean shouldDoOutput(Request request) {
        byte[] bArr;
        return (request.method.equals("PUT") || request.method.equals("POST") || request.method.equals("DELETE")) && (bArr = request.body) != null && bArr.length > 0;
    }

    private void writeRequestBody() throws IOException {
        OutputStream outputStream = this.mConnection.getOutputStream();
        outputStream.write(this.mRequest.body);
        outputStream.flush();
        closeQuietly(outputStream);
    }

    public Response run() throws IOException, IllegalStateException {
        Response response;
        if (this.mRun.get()) {
            throw new IllegalStateException(HttpRequestProcessor.class.getSimpleName() + ".run() can only be called once");
        }
        this.mRun.set(true);
        try {
            setConnectionProperties();
            if (shouldDoOutput(this.mRequest)) {
                this.mConnection.setDoOutput(true);
            }
            this.mConnection.connect();
            if (shouldDoOutput(this.mRequest)) {
                writeRequestBody();
            }
            int responseCode = this.mConnection.getResponseCode();
            Map<String, String> flattenHeaders = flattenHeaders(this.mConnection.getHeaderFields());
            if (responseCode == 200) {
                response = new Response(responseCode, flattenHeaders, readResponseBody(this.mConnection.getInputStream()));
            } else if (responseCode == 204) {
                return new Response(responseCode, flattenHeaders);
            } else {
                response = new Response(responseCode, flattenHeaders, readResponseBody(this.mConnection.getErrorStream()));
            }
            return response;
        } finally {
            closeStreamsQuietly(this.mConnection);
        }
    }
}
