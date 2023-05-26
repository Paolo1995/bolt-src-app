package eu.bolt.android.audio_recording_engine.engine;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RecorderState.kt */
/* loaded from: classes5.dex */
public abstract class RecorderState {

    /* compiled from: RecorderState.kt */
    /* loaded from: classes5.dex */
    public static final class Complete extends RecorderState {

        /* renamed from: a  reason: collision with root package name */
        public static final Complete f36677a = new Complete();

        private Complete() {
            super(null);
        }
    }

    /* compiled from: RecorderState.kt */
    /* loaded from: classes5.dex */
    public static final class InProgress extends RecorderState {

        /* renamed from: a  reason: collision with root package name */
        private final long f36678a;

        public InProgress(long j8) {
            super(null);
            this.f36678a = j8;
        }

        public final long a() {
            return this.f36678a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof InProgress) && this.f36678a == ((InProgress) obj).f36678a;
        }

        public int hashCode() {
            return a.a(this.f36678a);
        }

        public String toString() {
            return "InProgress(startTimeMs=" + this.f36678a + ')';
        }
    }

    /* compiled from: RecorderState.kt */
    /* loaded from: classes5.dex */
    public static final class Initial extends RecorderState {

        /* renamed from: a  reason: collision with root package name */
        public static final Initial f36679a = new Initial();

        private Initial() {
            super(null);
        }
    }

    /* compiled from: RecorderState.kt */
    /* loaded from: classes5.dex */
    public static final class Paused extends RecorderState {

        /* renamed from: a  reason: collision with root package name */
        private final long f36680a;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paused) && this.f36680a == ((Paused) obj).f36680a;
        }

        public int hashCode() {
            return a.a(this.f36680a);
        }

        public String toString() {
            return "Paused(durationSeconds=" + this.f36680a + ')';
        }
    }

    private RecorderState() {
    }

    public /* synthetic */ RecorderState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
