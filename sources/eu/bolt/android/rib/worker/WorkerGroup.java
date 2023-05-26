package eu.bolt.android.rib.worker;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkerGroup.kt */
/* loaded from: classes5.dex */
public interface WorkerGroup {

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f37378a = Companion.f37379a;

    /* compiled from: WorkerGroup.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ Companion f37379a = new Companion();

        private Companion() {
        }

        public final WorkerGroup a(final Set<? extends Worker> set) {
            Intrinsics.f(set, "set");
            return new WorkerGroup() { // from class: eu.bolt.android.rib.worker.WorkerGroup$Companion$fromSet$1
                @Override // eu.bolt.android.rib.worker.WorkerGroup
                public Set<Worker> a() {
                    return set;
                }
            };
        }
    }

    Set<Worker> a();
}
