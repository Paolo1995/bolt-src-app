package com.sinch.httpclient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class RequestEntry {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final int id;
    public final Logger logger;
    private ResponseHandler mHandler;
    private HttpRequestTask mTask;
    public final RequestOptions options;
    public final Request request;
    public long retryAt;
    public final RetryPolicy retryPolicy;

    public RequestEntry(int i8, Request request, ResponseHandler responseHandler, RequestOptions requestOptions) {
        this.id = i8;
        this.request = request;
        this.options = requestOptions;
        this.logger = requestOptions.logger;
        this.retryPolicy = requestOptions.retry;
        this.mHandler = responseHandler;
    }

    public final void invokeError(Exception exc) {
        ResponseHandler responseHandler = this.mHandler;
        if (responseHandler != null) {
            this.mHandler = null;
            responseHandler.onError(exc);
        }
    }

    public final void invokeSuccess(Response response) {
        ResponseHandler responseHandler = this.mHandler;
        if (responseHandler != null) {
            this.mHandler = null;
            responseHandler.onSuccess(response);
        }
    }

    public final String loggingIdentifier() {
        return this.request.id + "|" + this.id;
    }

    public void setTask(HttpRequestTask httpRequestTask) {
        this.mTask = httpRequestTask;
    }

    public HttpRequestTask task() {
        return this.mTask;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append("id='" + this.id + "'");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(", request=");
        sb2.append(this.request.asString(false));
        sb.append(sb2.toString());
        sb.append(", priority=" + String.valueOf(this.options.priority));
        sb.append('}');
        return sb.toString();
    }
}
