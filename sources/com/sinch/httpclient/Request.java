package com.sinch.httpclient;

import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes3.dex */
public class Request {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final byte[] body;
    public final Map<String, String> headers;
    public final String id;
    public final String method;
    public final URL url;

    public Request(String str, URL url, String str2, Map<String, String> map, byte[] bArr) {
        this.id = str;
        this.url = url;
        this.method = str2;
        this.headers = map;
        this.body = bArr;
    }

    private static String bodyStringRepresentation(byte[] bArr) {
        if (bArr == null) {
            return "null";
        }
        try {
            return new String(bArr, Charset.forName("UTF-8"));
        } catch (Exception unused) {
            return bArr.toString();
        }
    }

    public String asString(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id='" + this.id + '\'');
        sb.append(", url='" + this.url + '\'');
        sb.append(", method='" + this.method + '\'');
        StringBuilder sb2 = new StringBuilder();
        sb2.append(", headers=");
        sb2.append(this.headers);
        sb.append(sb2.toString());
        if (z7) {
            sb.append(", body='" + bodyStringRepresentation(this.body) + '\'');
        }
        sb.append('}');
        return sb.toString();
    }

    public String toString() {
        return asString(false);
    }
}
