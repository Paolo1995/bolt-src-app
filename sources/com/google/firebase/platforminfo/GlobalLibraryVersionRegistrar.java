package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class GlobalLibraryVersionRegistrar {

    /* renamed from: b  reason: collision with root package name */
    private static volatile GlobalLibraryVersionRegistrar f17007b;

    /* renamed from: a  reason: collision with root package name */
    private final Set<LibraryVersion> f17008a = new HashSet();

    GlobalLibraryVersionRegistrar() {
    }

    public static GlobalLibraryVersionRegistrar a() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar = f17007b;
        if (globalLibraryVersionRegistrar == null) {
            synchronized (GlobalLibraryVersionRegistrar.class) {
                globalLibraryVersionRegistrar = f17007b;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    f17007b = globalLibraryVersionRegistrar;
                }
            }
        }
        return globalLibraryVersionRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<LibraryVersion> b() {
        Set<LibraryVersion> unmodifiableSet;
        synchronized (this.f17008a) {
            unmodifiableSet = Collections.unmodifiableSet(this.f17008a);
        }
        return unmodifiableSet;
    }
}
