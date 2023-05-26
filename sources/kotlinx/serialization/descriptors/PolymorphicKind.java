package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SerialKinds.kt */
/* loaded from: classes5.dex */
public abstract class PolymorphicKind extends SerialKind {

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class OPEN extends PolymorphicKind {

        /* renamed from: a  reason: collision with root package name */
        public static final OPEN f52090a = new OPEN();

        private OPEN() {
            super(null);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class SEALED extends PolymorphicKind {

        /* renamed from: a  reason: collision with root package name */
        public static final SEALED f52091a = new SEALED();

        private SEALED() {
            super(null);
        }
    }

    private PolymorphicKind() {
        super(null);
    }

    public /* synthetic */ PolymorphicKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
