package com.sinch.android.rtc.internal.natives;

/* loaded from: classes3.dex */
public class ConnectionInfo {
    private String connectionType;
    private String host;
    private String id;
    private int port;
    private String protocol;

    public ConnectionInfo(String str, String str2, String str3, String str4, int i8) {
        this.id = str;
        this.connectionType = str2;
        this.protocol = str3;
        this.host = str4;
        this.port = i8;
    }

    public String getConnectionType() {
        return this.connectionType;
    }

    public String getHost() {
        return this.host;
    }

    public String getId() {
        return this.id;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }
}
