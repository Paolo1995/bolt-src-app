package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpRequestPipeline.kt */
/* loaded from: classes5.dex */
public final class HttpSendPipeline extends Pipeline<Object, HttpRequestBuilder> {

    /* renamed from: h  reason: collision with root package name */
    public static final Phases f46641h = new Phases(null);

    /* renamed from: i  reason: collision with root package name */
    private static final PipelinePhase f46642i = new PipelinePhase("Before");

    /* renamed from: j  reason: collision with root package name */
    private static final PipelinePhase f46643j = new PipelinePhase("State");

    /* renamed from: k  reason: collision with root package name */
    private static final PipelinePhase f46644k = new PipelinePhase("Monitoring");

    /* renamed from: l  reason: collision with root package name */
    private static final PipelinePhase f46645l = new PipelinePhase("Engine");

    /* renamed from: m  reason: collision with root package name */
    private static final PipelinePhase f46646m = new PipelinePhase("Receive");

    /* renamed from: g  reason: collision with root package name */
    private final boolean f46647g;

    /* compiled from: HttpRequestPipeline.kt */
    /* loaded from: classes5.dex */
    public static final class Phases {
        private Phases() {
        }

        public /* synthetic */ Phases(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PipelinePhase a() {
            return HttpSendPipeline.f46645l;
        }

        public final PipelinePhase b() {
            return HttpSendPipeline.f46644k;
        }

        public final PipelinePhase c() {
            return HttpSendPipeline.f46646m;
        }

        public final PipelinePhase d() {
            return HttpSendPipeline.f46643j;
        }
    }

    public HttpSendPipeline() {
        this(false, 1, null);
    }

    public /* synthetic */ HttpSendPipeline(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public boolean g() {
        return this.f46647g;
    }

    public HttpSendPipeline(boolean z7) {
        super(f46642i, f46643j, f46644k, f46645l, f46646m);
        this.f46647g = z7;
    }
}
