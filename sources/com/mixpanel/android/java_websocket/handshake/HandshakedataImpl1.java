package com.mixpanel.android.java_websocket.handshake;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes3.dex */
public class HandshakedataImpl1 implements HandshakeBuilder {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f19047a;

    /* renamed from: b  reason: collision with root package name */
    private TreeMap<String, String> f19048b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public boolean b(String str) {
        return this.f19048b.containsKey(str);
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public Iterator<String> d() {
        return Collections.unmodifiableSet(this.f19048b.keySet()).iterator();
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public byte[] getContent() {
        return this.f19047a;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.HandshakeBuilder
    public void h(byte[] bArr) {
        this.f19047a = bArr;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.Handshakedata
    public String i(String str) {
        String str2 = this.f19048b.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Override // com.mixpanel.android.java_websocket.handshake.HandshakeBuilder
    public void put(String str, String str2) {
        this.f19048b.put(str, str2);
    }
}
