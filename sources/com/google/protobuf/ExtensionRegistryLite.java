package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
public class ExtensionRegistryLite {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f17326b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ExtensionRegistryLite f17327c;

    /* renamed from: d  reason: collision with root package name */
    static final ExtensionRegistryLite f17328d = new ExtensionRegistryLite(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> f17329a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class ObjectIntPair {

        /* renamed from: a  reason: collision with root package name */
        private final Object f17330a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17331b;

        ObjectIntPair(Object obj, int i8) {
            this.f17330a = obj;
            this.f17331b = i8;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.f17330a != objectIntPair.f17330a || this.f17331b != objectIntPair.f17331b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f17330a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f17331b;
        }
    }

    ExtensionRegistryLite() {
        this.f17329a = new HashMap();
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite extensionRegistryLite = f17327c;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = f17327c;
                if (extensionRegistryLite == null) {
                    if (f17326b) {
                        extensionRegistryLite = ExtensionRegistryFactory.a();
                    } else {
                        extensionRegistryLite = f17328d;
                    }
                    f17327c = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> a(ContainingType containingtype, int i8) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.f17329a.get(new ObjectIntPair(containingtype, i8));
    }

    ExtensionRegistryLite(boolean z7) {
        this.f17329a = Collections.emptyMap();
    }
}
