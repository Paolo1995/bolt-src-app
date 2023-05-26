package ee.mtakso.driver.ui.screens.safety_toolkit.safety_toolkit_home;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecorderEventState.kt */
/* loaded from: classes3.dex */
public abstract class RecorderEventState {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f32757b = new Companion(null);

    /* renamed from: a  reason: collision with root package name */
    private final String f32758a;

    /* compiled from: RecorderEventState.kt */
    /* loaded from: classes3.dex */
    public static final class AvailableDuringActiveState extends RecorderEventState {

        /* renamed from: c  reason: collision with root package name */
        private final String f32759c;

        public AvailableDuringActiveState() {
            this(null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AvailableDuringActiveState(String value) {
            super(value, null);
            Intrinsics.f(value, "value");
            this.f32759c = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AvailableDuringActiveState) && Intrinsics.a(this.f32759c, ((AvailableDuringActiveState) obj).f32759c);
        }

        public int hashCode() {
            return this.f32759c.hashCode();
        }

        public String toString() {
            String str = this.f32759c;
            return "AvailableDuringActiveState(value=" + str + ")";
        }

        public /* synthetic */ AvailableDuringActiveState(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "Available During Active Trips" : str);
        }
    }

    /* compiled from: RecorderEventState.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: RecorderEventState.kt */
    /* loaded from: classes3.dex */
    public static final class GrantPermission extends RecorderEventState {

        /* renamed from: c  reason: collision with root package name */
        private final String f32760c;

        public GrantPermission() {
            this(null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GrantPermission(String value) {
            super(value, null);
            Intrinsics.f(value, "value");
            this.f32760c = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GrantPermission) && Intrinsics.a(this.f32760c, ((GrantPermission) obj).f32760c);
        }

        public int hashCode() {
            return this.f32760c.hashCode();
        }

        public String toString() {
            String str = this.f32760c;
            return "GrantPermission(value=" + str + ")";
        }

        public /* synthetic */ GrantPermission(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "Grant Permission " : str);
        }
    }

    /* compiled from: RecorderEventState.kt */
    /* loaded from: classes3.dex */
    public static final class Paused extends RecorderEventState {

        /* renamed from: c  reason: collision with root package name */
        private final String f32761c;

        public Paused() {
            this(null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paused(String value) {
            super(value, null);
            Intrinsics.f(value, "value");
            this.f32761c = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paused) && Intrinsics.a(this.f32761c, ((Paused) obj).f32761c);
        }

        public int hashCode() {
            return this.f32761c.hashCode();
        }

        public String toString() {
            String str = this.f32761c;
            return "Paused(value=" + str + ")";
        }

        public /* synthetic */ Paused(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "Paused" : str);
        }
    }

    /* compiled from: RecorderEventState.kt */
    /* loaded from: classes3.dex */
    public static final class Recording extends RecorderEventState {

        /* renamed from: c  reason: collision with root package name */
        private final String f32762c;

        public Recording() {
            this(null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Recording(String value) {
            super(value, null);
            Intrinsics.f(value, "value");
            this.f32762c = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Recording) && Intrinsics.a(this.f32762c, ((Recording) obj).f32762c);
        }

        public int hashCode() {
            return this.f32762c.hashCode();
        }

        public String toString() {
            String str = this.f32762c;
            return "Recording(value=" + str + ")";
        }

        public /* synthetic */ Recording(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "Recording" : str);
        }
    }

    /* compiled from: RecorderEventState.kt */
    /* loaded from: classes3.dex */
    public static final class StartRecording extends RecorderEventState {

        /* renamed from: c  reason: collision with root package name */
        private final String f32763c;

        public StartRecording() {
            this(null, 1, null);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StartRecording(String value) {
            super(value, null);
            Intrinsics.f(value, "value");
            this.f32763c = value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StartRecording) && Intrinsics.a(this.f32763c, ((StartRecording) obj).f32763c);
        }

        public int hashCode() {
            return this.f32763c.hashCode();
        }

        public String toString() {
            String str = this.f32763c;
            return "StartRecording(value=" + str + ")";
        }

        public /* synthetic */ StartRecording(String str, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? "Start Recording" : str);
        }
    }

    private RecorderEventState(String str) {
        this.f32758a = str;
    }

    public /* synthetic */ RecorderEventState(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public final String a() {
        return this.f32758a;
    }
}
