package com.sinch.httpclient;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public class Response {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final byte[] body;
    public final Map<String, String> headers;
    public final int status;

    public Response(int i8, Map<String, String> map) {
        this(i8, map, new byte[0]);
    }

    public Response(int i8, Map<String, String> map, byte[] bArr) {
        this.status = i8;
        this.headers = map == null ? Collections.emptyMap() : map;
        this.body = bArr == null ? new byte[0] : bArr;
    }
}
