package com.bumptech.glide.request;

/* loaded from: classes.dex */
public interface RequestCoordinator {

    /* loaded from: classes.dex */
    public enum RequestState {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        

        /* renamed from: f  reason: collision with root package name */
        private final boolean f10670f;

        RequestState(boolean z7) {
            this.f10670f = z7;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a() {
            return this.f10670f;
        }
    }

    boolean a();

    boolean c(Request request);

    boolean d(Request request);

    void e(Request request);

    void g(Request request);

    RequestCoordinator getRoot();

    boolean k(Request request);
}
