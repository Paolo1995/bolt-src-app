package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: SerialKinds.kt */
/* loaded from: classes5.dex */
public abstract class SerialKind {

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class CONTEXTUAL extends SerialKind {

        /* renamed from: a  reason: collision with root package name */
        public static final CONTEXTUAL f52122a = new CONTEXTUAL();

        private CONTEXTUAL() {
            super(null);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class ENUM extends SerialKind {

        /* renamed from: a  reason: collision with root package name */
        public static final ENUM f52123a = new ENUM();

        private ENUM() {
            super(null);
        }
    }

    private SerialKind() {
    }

    public /* synthetic */ SerialKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        String d8 = Reflection.b(getClass()).d();
        Intrinsics.c(d8);
        return d8;
    }
}
