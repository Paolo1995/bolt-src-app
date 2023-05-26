package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpRequestPipeline.kt */
/* loaded from: classes5.dex */
public final class HttpRequestPipeline extends Pipeline<Object, HttpRequestBuilder> {

    /* renamed from: h  reason: collision with root package name */
    public static final Phases f46627h = new Phases(null);

    /* renamed from: i  reason: collision with root package name */
    private static final PipelinePhase f46628i = new PipelinePhase("Before");

    /* renamed from: j  reason: collision with root package name */
    private static final PipelinePhase f46629j = new PipelinePhase("State");

    /* renamed from: k  reason: collision with root package name */
    private static final PipelinePhase f46630k = new PipelinePhase("Transform");

    /* renamed from: l  reason: collision with root package name */
    private static final PipelinePhase f46631l = new PipelinePhase("Render");

    /* renamed from: m  reason: collision with root package name */
    private static final PipelinePhase f46632m = new PipelinePhase("Send");

    /* renamed from: g  reason: collision with root package name */
    private final boolean f46633g;

    /* compiled from: HttpRequestPipeline.kt */
    /* loaded from: classes5.dex */
    public static final class Phases {
        private Phases() {
        }

        public /* synthetic */ Phases(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PipelinePhase a() {
            return HttpRequestPipeline.f46628i;
        }

        public final PipelinePhase b() {
            return HttpRequestPipeline.f46631l;
        }

        public final PipelinePhase c() {
            return HttpRequestPipeline.f46632m;
        }

        public final PipelinePhase d() {
            return HttpRequestPipeline.f46630k;
        }
    }

    public HttpRequestPipeline() {
        this(false, 1, null);
    }

    public /* synthetic */ HttpRequestPipeline(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public boolean g() {
        return this.f46633g;
    }

    public HttpRequestPipeline(boolean z7) {
        super(f46628i, f46629j, f46630k, f46631l, f46632m);
        this.f46633g = z7;
    }
}
