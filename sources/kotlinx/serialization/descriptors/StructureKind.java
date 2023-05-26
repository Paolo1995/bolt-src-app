package kotlinx.serialization.descriptors;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: SerialKinds.kt */
/* loaded from: classes5.dex */
public abstract class StructureKind extends SerialKind {

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class CLASS extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final CLASS f52124a = new CLASS();

        private CLASS() {
            super(null);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class LIST extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final LIST f52125a = new LIST();

        private LIST() {
            super(null);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class MAP extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final MAP f52126a = new MAP();

        private MAP() {
            super(null);
        }
    }

    /* compiled from: SerialKinds.kt */
    /* loaded from: classes5.dex */
    public static final class OBJECT extends StructureKind {

        /* renamed from: a  reason: collision with root package name */
        public static final OBJECT f52127a = new OBJECT();

        private OBJECT() {
            super(null);
        }
    }

    private StructureKind() {
        super(null);
    }

    public /* synthetic */ StructureKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
