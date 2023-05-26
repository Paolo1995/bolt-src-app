package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HttpResponsePipeline.kt */
/* loaded from: classes5.dex */
public final class HttpResponsePipeline extends Pipeline<HttpResponseContainer, HttpClientCall> {

    /* renamed from: h  reason: collision with root package name */
    public static final Phases f46667h = new Phases(null);

    /* renamed from: i  reason: collision with root package name */
    private static final PipelinePhase f46668i = new PipelinePhase("Receive");

    /* renamed from: j  reason: collision with root package name */
    private static final PipelinePhase f46669j = new PipelinePhase("Parse");

    /* renamed from: k  reason: collision with root package name */
    private static final PipelinePhase f46670k = new PipelinePhase("Transform");

    /* renamed from: l  reason: collision with root package name */
    private static final PipelinePhase f46671l = new PipelinePhase("State");

    /* renamed from: m  reason: collision with root package name */
    private static final PipelinePhase f46672m = new PipelinePhase("After");

    /* renamed from: g  reason: collision with root package name */
    private final boolean f46673g;

    /* compiled from: HttpResponsePipeline.kt */
    /* loaded from: classes5.dex */
    public static final class Phases {
        private Phases() {
        }

        public /* synthetic */ Phases(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PipelinePhase a() {
            return HttpResponsePipeline.f46669j;
        }

        public final PipelinePhase b() {
            return HttpResponsePipeline.f46668i;
        }

        public final PipelinePhase c() {
            return HttpResponsePipeline.f46670k;
        }
    }

    public HttpResponsePipeline() {
        this(false, 1, null);
    }

    public /* synthetic */ HttpResponsePipeline(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? false : z7);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public boolean g() {
        return this.f46673g;
    }

    public HttpResponsePipeline(boolean z7) {
        super(f46668i, f46669j, f46670k, f46671l, f46672m);
        this.f46673g = z7;
    }
}
