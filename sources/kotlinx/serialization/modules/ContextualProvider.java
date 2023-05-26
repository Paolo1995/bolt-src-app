package kotlinx.serialization.modules;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

/* compiled from: SerializersModule.kt */
/* loaded from: classes5.dex */
public abstract class ContextualProvider {

    /* compiled from: SerializersModule.kt */
    /* loaded from: classes5.dex */
    public static final class Argless extends ContextualProvider {

        /* renamed from: a  reason: collision with root package name */
        private final KSerializer<?> f52453a;

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f52453a;
        }

        public final KSerializer<?> b() {
            return this.f52453a;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Argless) && Intrinsics.a(((Argless) obj).f52453a, this.f52453a)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.f52453a.hashCode();
        }
    }

    /* compiled from: SerializersModule.kt */
    /* loaded from: classes5.dex */
    public static final class WithTypeArguments extends ContextualProvider {

        /* renamed from: a  reason: collision with root package name */
        private final Function1<List<? extends KSerializer<?>>, KSerializer<?>> f52454a;

        @Override // kotlinx.serialization.modules.ContextualProvider
        public KSerializer<?> a(List<? extends KSerializer<?>> typeArgumentsSerializers) {
            Intrinsics.f(typeArgumentsSerializers, "typeArgumentsSerializers");
            return this.f52454a.invoke(typeArgumentsSerializers);
        }

        public final Function1<List<? extends KSerializer<?>>, KSerializer<?>> b() {
            return this.f52454a;
        }
    }

    private ContextualProvider() {
    }

    public abstract KSerializer<?> a(List<? extends KSerializer<?>> list);
}
