package io.ktor.util.pipeline;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PipelinePhaseRelation.kt */
/* loaded from: classes5.dex */
public abstract class PipelinePhaseRelation {

    /* compiled from: PipelinePhaseRelation.kt */
    /* loaded from: classes5.dex */
    public static final class After extends PipelinePhaseRelation {

        /* renamed from: a  reason: collision with root package name */
        private final PipelinePhase f47131a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public After(PipelinePhase relativeTo) {
            super(null);
            Intrinsics.f(relativeTo, "relativeTo");
            this.f47131a = relativeTo;
        }

        public final PipelinePhase a() {
            return this.f47131a;
        }
    }

    /* compiled from: PipelinePhaseRelation.kt */
    /* loaded from: classes5.dex */
    public static final class Before extends PipelinePhaseRelation {

        /* renamed from: a  reason: collision with root package name */
        private final PipelinePhase f47132a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Before(PipelinePhase relativeTo) {
            super(null);
            Intrinsics.f(relativeTo, "relativeTo");
            this.f47132a = relativeTo;
        }
    }

    /* compiled from: PipelinePhaseRelation.kt */
    /* loaded from: classes5.dex */
    public static final class Last extends PipelinePhaseRelation {

        /* renamed from: a  reason: collision with root package name */
        public static final Last f47133a = new Last();

        private Last() {
            super(null);
        }
    }

    private PipelinePhaseRelation() {
    }

    public /* synthetic */ PipelinePhaseRelation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
