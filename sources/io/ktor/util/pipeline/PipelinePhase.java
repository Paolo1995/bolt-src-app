package io.ktor.util.pipeline;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelinePhase.kt */
/* loaded from: classes5.dex */
public final class PipelinePhase {

    /* renamed from: a  reason: collision with root package name */
    private final String f47130a;

    public PipelinePhase(String name) {
        Intrinsics.f(name, "name");
        this.f47130a = name;
    }

    public final String a() {
        return this.f47130a;
    }

    public String toString() {
        return "Phase('" + this.f47130a + "')";
    }
}
