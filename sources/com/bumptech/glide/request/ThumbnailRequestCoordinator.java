package com.bumptech.glide.request;

import com.bumptech.glide.request.RequestCoordinator;

/* loaded from: classes.dex */
public class ThumbnailRequestCoordinator implements RequestCoordinator, Request {

    /* renamed from: a  reason: collision with root package name */
    private final RequestCoordinator f10715a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f10716b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Request f10717c;

    /* renamed from: d  reason: collision with root package name */
    private volatile Request f10718d;

    /* renamed from: e  reason: collision with root package name */
    private RequestCoordinator.RequestState f10719e;

    /* renamed from: f  reason: collision with root package name */
    private RequestCoordinator.RequestState f10720f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10721g;

    public ThumbnailRequestCoordinator(Object obj, RequestCoordinator requestCoordinator) {
        RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
        this.f10719e = requestState;
        this.f10720f = requestState;
        this.f10716b = obj;
        this.f10715a = requestCoordinator;
    }

    private boolean l() {
        RequestCoordinator requestCoordinator = this.f10715a;
        if (requestCoordinator != null && !requestCoordinator.k(this)) {
            return false;
        }
        return true;
    }

    private boolean m() {
        RequestCoordinator requestCoordinator = this.f10715a;
        if (requestCoordinator != null && !requestCoordinator.c(this)) {
            return false;
        }
        return true;
    }

    private boolean n() {
        RequestCoordinator requestCoordinator = this.f10715a;
        if (requestCoordinator != null && !requestCoordinator.d(this)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator, com.bumptech.glide.request.Request
    public boolean a() {
        boolean z7;
        synchronized (this.f10716b) {
            if (!this.f10718d.a() && !this.f10717c.a()) {
                z7 = false;
            }
            z7 = true;
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void b() {
        synchronized (this.f10716b) {
            if (!this.f10720f.a()) {
                this.f10720f = RequestCoordinator.RequestState.PAUSED;
                this.f10718d.b();
            }
            if (!this.f10719e.a()) {
                this.f10719e = RequestCoordinator.RequestState.PAUSED;
                this.f10717c.b();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean c(Request request) {
        boolean z7;
        synchronized (this.f10716b) {
            if (m() && request.equals(this.f10717c) && !a()) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void clear() {
        synchronized (this.f10716b) {
            this.f10721g = false;
            RequestCoordinator.RequestState requestState = RequestCoordinator.RequestState.CLEARED;
            this.f10719e = requestState;
            this.f10720f = requestState;
            this.f10718d.clear();
            this.f10717c.clear();
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean d(Request request) {
        boolean z7;
        synchronized (this.f10716b) {
            if (n() && (request.equals(this.f10717c) || this.f10719e != RequestCoordinator.RequestState.SUCCESS)) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void e(Request request) {
        synchronized (this.f10716b) {
            if (!request.equals(this.f10717c)) {
                this.f10720f = RequestCoordinator.RequestState.FAILED;
                return;
            }
            this.f10719e = RequestCoordinator.RequestState.FAILED;
            RequestCoordinator requestCoordinator = this.f10715a;
            if (requestCoordinator != null) {
                requestCoordinator.e(this);
            }
        }
    }

    @Override // com.bumptech.glide.request.Request
    public boolean f() {
        boolean z7;
        synchronized (this.f10716b) {
            if (this.f10719e == RequestCoordinator.RequestState.CLEARED) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public void g(Request request) {
        synchronized (this.f10716b) {
            if (request.equals(this.f10718d)) {
                this.f10720f = RequestCoordinator.RequestState.SUCCESS;
                return;
            }
            this.f10719e = RequestCoordinator.RequestState.SUCCESS;
            RequestCoordinator requestCoordinator = this.f10715a;
            if (requestCoordinator != null) {
                requestCoordinator.g(this);
            }
            if (!this.f10720f.a()) {
                this.f10718d.clear();
            }
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public RequestCoordinator getRoot() {
        RequestCoordinator requestCoordinator;
        synchronized (this.f10716b) {
            RequestCoordinator requestCoordinator2 = this.f10715a;
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
        synchronized (this.f10716b) {
            if (this.f10719e == RequestCoordinator.RequestState.SUCCESS) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean i(Request request) {
        if (!(request instanceof ThumbnailRequestCoordinator)) {
            return false;
        }
        ThumbnailRequestCoordinator thumbnailRequestCoordinator = (ThumbnailRequestCoordinator) request;
        if (this.f10717c == null) {
            if (thumbnailRequestCoordinator.f10717c != null) {
                return false;
            }
        } else if (!this.f10717c.i(thumbnailRequestCoordinator.f10717c)) {
            return false;
        }
        if (this.f10718d == null) {
            if (thumbnailRequestCoordinator.f10718d != null) {
                return false;
            }
        } else if (!this.f10718d.i(thumbnailRequestCoordinator.f10718d)) {
            return false;
        }
        return true;
    }

    @Override // com.bumptech.glide.request.Request
    public boolean isRunning() {
        boolean z7;
        synchronized (this.f10716b) {
            if (this.f10719e == RequestCoordinator.RequestState.RUNNING) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    @Override // com.bumptech.glide.request.Request
    public void j() {
        synchronized (this.f10716b) {
            this.f10721g = true;
            if (this.f10719e != RequestCoordinator.RequestState.SUCCESS) {
                RequestCoordinator.RequestState requestState = this.f10720f;
                RequestCoordinator.RequestState requestState2 = RequestCoordinator.RequestState.RUNNING;
                if (requestState != requestState2) {
                    this.f10720f = requestState2;
                    this.f10718d.j();
                }
            }
            if (this.f10721g) {
                RequestCoordinator.RequestState requestState3 = this.f10719e;
                RequestCoordinator.RequestState requestState4 = RequestCoordinator.RequestState.RUNNING;
                if (requestState3 != requestState4) {
                    this.f10719e = requestState4;
                    this.f10717c.j();
                }
            }
            this.f10721g = false;
        }
    }

    @Override // com.bumptech.glide.request.RequestCoordinator
    public boolean k(Request request) {
        boolean z7;
        synchronized (this.f10716b) {
            if (l() && request.equals(this.f10717c) && this.f10719e != RequestCoordinator.RequestState.PAUSED) {
                z7 = true;
            } else {
                z7 = false;
            }
        }
        return z7;
    }

    public void o(Request request, Request request2) {
        this.f10717c = request;
        this.f10718d = request2;
    }
}
