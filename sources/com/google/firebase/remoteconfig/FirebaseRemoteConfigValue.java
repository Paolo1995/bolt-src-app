package com.google.firebase.remoteconfig;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public interface FirebaseRemoteConfigValue {
    @NonNull
    String a();

    long b() throws IllegalArgumentException;

    double c() throws IllegalArgumentException;

    boolean d() throws IllegalArgumentException;

    int getSource();
}
