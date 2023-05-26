package com.google.crypto.tink.shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.GeneratedMessageLite;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.internal.http2.Settings;

/* loaded from: classes.dex */
public class ExtensionRegistryLite {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f15033b = true;

    /* renamed from: c  reason: collision with root package name */
    private static volatile ExtensionRegistryLite f15034c;

    /* renamed from: d  reason: collision with root package name */
    static final ExtensionRegistryLite f15035d = new ExtensionRegistryLite(true);

    /* renamed from: a  reason: collision with root package name */
    private final Map<ObjectIntPair, GeneratedMessageLite.GeneratedExtension<?, ?>> f15036a;

    /* loaded from: classes.dex */
    private static final class ObjectIntPair {

        /* renamed from: a  reason: collision with root package name */
        private final Object f15037a;

        /* renamed from: b  reason: collision with root package name */
        private final int f15038b;

        ObjectIntPair(Object obj, int i8) {
            this.f15037a = obj;
            this.f15038b = i8;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ObjectIntPair)) {
                return false;
            }
            ObjectIntPair objectIntPair = (ObjectIntPair) obj;
            if (this.f15037a != objectIntPair.f15037a || this.f15038b != objectIntPair.f15038b) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (System.identityHashCode(this.f15037a) * Settings.DEFAULT_INITIAL_WINDOW_SIZE) + this.f15038b;
        }
    }

    ExtensionRegistryLite() {
        this.f15036a = new HashMap();
    }

    public static ExtensionRegistryLite b() {
        ExtensionRegistryLite extensionRegistryLite = f15034c;
        if (extensionRegistryLite == null) {
            synchronized (ExtensionRegistryLite.class) {
                extensionRegistryLite = f15034c;
                if (extensionRegistryLite == null) {
                    if (f15033b) {
                        extensionRegistryLite = ExtensionRegistryFactory.a();
                    } else {
                        extensionRegistryLite = f15035d;
                    }
                    f15034c = extensionRegistryLite;
                }
            }
        }
        return extensionRegistryLite;
    }

    public <ContainingType extends MessageLite> GeneratedMessageLite.GeneratedExtension<ContainingType, ?> a(ContainingType containingtype, int i8) {
        return (GeneratedMessageLite.GeneratedExtension<ContainingType, ?>) this.f15036a.get(new ObjectIntPair(containingtype, i8));
    }

    ExtensionRegistryLite(boolean z7) {
        this.f15036a = Collections.emptyMap();
    }
}
