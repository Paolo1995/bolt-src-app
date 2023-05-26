package eu.bolt.chat.async;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.atomicfu.AtomicRef;
import kotlinx.coroutines.Job;

/* compiled from: JobExtensions.kt */
/* loaded from: classes5.dex */
public final class JobExtensionsKt {
    public static final void a(Job job, AtomicRef<Job> jobRef) {
        Intrinsics.f(job, "<this>");
        Intrinsics.f(jobRef, "jobRef");
        Job a8 = jobRef.a(job);
        if (a8 != null) {
            Job.DefaultImpls.a(a8, null, 1, null);
        }
    }
}
