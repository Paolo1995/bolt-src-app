package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public final class ErrorRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    private final Object f10658a;

    /* renamed from: b  reason: collision with root package name */
    private final RequestCoordinator f10659b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f10660c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Request f10661d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f10662e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f10663f;

    public ErrorRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f10662e = requestState;
        this.f10663f = requestState;
        this.f10658a = obj;
        this.f10659b = requestCoordinator;
    }

    private boolean l(Request request) {
        if (!request.equals(this.f10660c) && (this.f10662e != RequestCoordinator.RequestState.FAILED || !request.equals(this.f10661d))) {
            return false;
        }
        return true;
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f10659b;
        if (requestCoordinator != null && !requestCoordinator.k(this)) {
            return false;
        }
        return true;
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f10659b;
        if (requestCoordinator != null && !requestCoordinator.c(this)) {
            return false;
        }
        return true;
    }

    private boolean o() {
        RequestCoordinator requestCoordinator = this.f10659b;
        if (requestCoordinator != null && !requestCoordinator.d(this)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean a() {
        boolean z7;
        synchronized (this.f10658a) {
            if (!this.f10660c.a() && !this.f10661d.a()) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void b() {
        synchronized (this.f10658a) {
            RequestCoordinator.RequestState requestState = this.f10662e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState == requestState2) {
                this.f10662e = RequestCoordinator.RequestState.PAUSED;
                this.f10660c.b();
            }
            if (this.f10663f == requestState2) {
                this.f10663f = RequestCoordinator.RequestState.PAUSED;
                this.f10661d.b();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(Request request) {
        boolean z7;
        synchronized (this.f10658a) {
            if (n() && l(request)) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f10658a) {
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f10662e = requestState;
            this.f10660c.clear();
            if (this.f10663f != requestState) {
                this.f10663f = requestState;
                this.f10661d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(Request request) {
        boolean z7;
        synchronized (this.f10658a) {
            if (o() && l(request)) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(Request request) {
        synchronized (this.f10658a) {
            if (!request.equals(this.f10661d)) {
                this.f10662e = RequestCoordinator.RequestState.FAILED;
                RequestCoordinator.RequestState requestState = this.f10663f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f10663f = requestState2;
                    this.f10661d.j();
                }
                return;
            }
            this.f10663f = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f10659b;
            if (requestCoordinator != null) {
                requestCoordinator.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean f() {
        boolean z7;
        synchronized (this.f10658a) {
            RequestCoordinator.RequestState requestState = this.f10662e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.CLEARED;
            if (requestState == requestState2 && this.f10663f == requestState2) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(Request request) {
        synchronized (this.f10658a) {
            if (request.equals(this.f10660c)) {
                this.f10662e = RequestCoordinator.RequestState.SUCCESS;
            } else if (request.equals(this.f10661d)) {
                this.f10663f = RequestCoordinator.RequestState.SUCCESS;
            }
            RequestCoordinator requestCoordinator = this.f10659b;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f10658a) {
            RequestCoordinator requestCoordinator2 = this.f10659b;
            if (requestCoordinator2 != null) {
                requestCoordinator = requestCoordinator2.getRoot();
            } else {
                requestCoordinator = this;
            }
        }
        return requestCoordinator;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean h() {
        boolean z7;
        synchronized (this.f10658a) {
            RequestCoordinator.RequestState requestState = this.f10662e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.SUCCESS;
            if (requestState != requestState2 && this.f10663f != requestState2) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean i(Request request) {
        if (!(request instanceof ErrorRequestCoordinator)) {
            return false;
        }
        ErrorRequestCoordinator errorRequestCoordinator = (ErrorRequestCoordinator) request;
        if (!this.f10660c.i(errorRequestCoordinator.f10660c) || !this.f10661d.i(errorRequestCoordinator.f10661d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z7;
        synchronized (this.f10658a) {
            RequestCoordinator.RequestState requestState = this.f10662e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2 && this.f10663f != requestState2) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void j() {
        synchronized (this.f10658a) {
            RequestCoordinator.RequestState requestState = this.f10662e;
            RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
            if (requestState != requestState2) {
                this.f10662e = requestState2;
                this.f10660c.j();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean k(Request request) {
        boolean z7;
        synchronized (this.f10658a) {
            if (m() && l(request)) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    public void p(Request request, Request request2) {
        this.f10660c = request;
        this.f10661d = request2;
    }
}
