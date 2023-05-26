package io.ktor.client.statement;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpResponsePipeline.kt */
/* loaded from: classes5.dex */
public final class HttpReceivePipeline extends Pipeline<HttpResponse, Unit> {

    /* renamed from: h  reason: collision with root package name */
    public static final Phases f46657h = new Phases(null);

    /* renamed from: i  reason: collision with root package name */
    private static final PipelinePhase f46658i = new PipelinePhase("Before");

    /* renamed from: j  reason: collision with root package name */
    private static final PipelinePhase f46659j = new PipelinePhase("State");

    /* renamed from: k  reason: collision with root package name */
    private static final PipelinePhase f46660k = new PipelinePhase("After");

    /* renamed from: g  reason: collision with root package name */
    private final boolean f46661g;

    /* compiled from: HttpResponsePipeline.kt */
    /* loaded from: classes5.dex */
    public static final class Phases {
        private Phases() {
        }

        public /* synthetic */ Phases(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PipelinePhase a() {
            return HttpReceivePipeline.f46660k;
        }

        public final PipelinePhase b() {
            return HttpReceivePipeline.f46659j;
        }
    }

    public HttpReceivePipeline() {
        this(false, 1, null);
    }

    public /* synthetic */ HttpReceivePipeline(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public boolean g() {
        return this.f46661g;
    }

    public HttpReceivePipeline(boolean z7) {
        super(f46658i, f46659j, f46660k);
        this.f46661g = z7;
    }
}
