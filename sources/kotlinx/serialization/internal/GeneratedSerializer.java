package kotlinx.serialization.internal;

import kotlinx.serialization.KSerializer;

/* compiled from: PluginHelperInterfaces.kt */
/* loaded from: classes5.dex */
public interface GeneratedSerializer<T> extends KSerializer<T> {

    /* compiled from: PluginHelperInterfaces.kt */
    /* loaded from: classes5.dex */
    public static final class DefaultImpls {
        public static <T> KSerializer<?>[] a(GeneratedSerializer<T> generatedSerializer) {
            return PluginHelperInterfacesKt.f52246a;
        }
    }

    KSerializer<?>[] d();

    KSerializer<?>[] e();
}
