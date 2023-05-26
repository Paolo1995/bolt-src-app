package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public interface Operation {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final State.SUCCESS f8300a = new State.SUCCESS();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final State.IN_PROGRESS f8301b = new State.IN_PROGRESS();

    /* loaded from: classes.dex */
    public static abstract class State {

        /* loaded from: classes.dex */
        public static final class FAILURE extends State {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f8302a;

            public FAILURE(@NonNull Throwable th) {
                this.f8302a = th;
            }

            @NonNull
            public Throwable a() {
                return this.f8302a;
            }

            @NonNull
            public String toString() {
                return String.format("FAILURE (%s)", this.f8302a.getMessage());
            }
        }

        /* loaded from: classes.dex */
        public static final class IN_PROGRESS extends State {
            @NonNull
            public String toString() {
                return "IN_PROGRESS";
            }

            private IN_PROGRESS() {
            }
        }

        /* loaded from: classes.dex */
        public static final class SUCCESS extends State {
            @NonNull
            public String toString() {
                return "SUCCESS";
            }

            private SUCCESS() {
            }
        }

        State() {
        }
    }
}
