package com.sinch.android.rtc.internal.natives.jni;

import java.util.ArrayList;
import java.util.Date;
import org.webrtc.CalledByNative;

/* loaded from: classes3.dex */
public class WebRtcIceServer {
    private final CredentialType credentialType;
    private final OAuthCredential oAuthCredential;
    private final String password;
    private final ArrayList<String> urls;
    private final String username;
    private final Date validUntil;

    /* loaded from: classes3.dex */
    public enum CredentialType {
        OAUTH("oauth"),
        PASSWORD("password");
        
        public final String credentialType;

        CredentialType(String str) {
            this.credentialType = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.credentialType;
        }
    }

    /* loaded from: classes3.dex */
    public static class OAuthCredential {
        private String macKey;
        private String oauthToken;

        @CalledByNative("OAuthCredential")
        public OAuthCredential(String str, String str2) {
            this.oauthToken = str;
            this.macKey = str2;
        }

        public String getAccessToken() {
            return this.oauthToken;
        }

        public String getMacKey() {
            return this.macKey;
        }
    }

    private WebRtcIceServer(ArrayList<String> arrayList, String str, OAuthCredential oAuthCredential, Date date) {
        this.urls = arrayList;
        this.username = str;
        this.credentialType = CredentialType.OAUTH;
        this.oAuthCredential = oAuthCredential;
        this.validUntil = date;
        this.password = null;
    }

    private WebRtcIceServer(ArrayList<String> arrayList, String str, String str2, Date date) {
        this.urls = arrayList;
        this.username = str;
        this.credentialType = CredentialType.PASSWORD;
        this.password = str2;
        this.oAuthCredential = null;
        this.validUntil = date;
    }

    @CalledByNative
    public static WebRtcIceServer createWithOAuthCredential(ArrayList<String> arrayList, String str, OAuthCredential oAuthCredential, Date date) {
        return new WebRtcIceServer(arrayList, str, oAuthCredential, date);
    }

    @CalledByNative
    public static WebRtcIceServer createWithPassword(ArrayList<String> arrayList, String str, String str2, Date date) {
        return new WebRtcIceServer(arrayList, str, str2, date);
    }

    public CredentialType getCredentialType() {
        return this.credentialType;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<String> getUrls() {
        return this.urls;
    }

    public String getUsername() {
        return this.username;
    }

    public Date getValidUntil() {
        return this.validUntil;
    }

    public OAuthCredential getoAuthCredential() {
        return this.oAuthCredential;
    }
}
