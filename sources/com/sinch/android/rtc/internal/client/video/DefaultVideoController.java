package com.sinch.android.rtc.internal.client.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.sinch.android.rtc.internal.client.DefaultSinchClient;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.DefaultPeerConnectionFactoryProvider;
import com.sinch.android.rtc.internal.client.calling.PeerConnection.PeerConnectionClientInterface;
import com.sinch.android.rtc.video.LocalVideoFrameListener;
import com.sinch.android.rtc.video.RemoteVideoFrameListener;
import com.sinch.android.rtc.video.VideoScalingType;
import org.webrtc.EglBase;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceViewRenderer;

/* loaded from: classes3.dex */
public class DefaultVideoController implements VideoControllerInternal {
    private static final String TAG = "DefaultVideoController";
    private EglBase.Context eglBaseContext;
    private SurfaceViewRenderer localRenderer;
    private RendererViewContainer localRendererContainer;
    private int mCameraDevicePosition;
    private final Context mContext;
    private RendererCommon.ScalingType mLocalVideoScalingBehaviour;
    private RendererCommon.ScalingType mScalingBehaviour;
    private final DefaultSinchClient mSinchClient;
    private SurfaceViewRenderer remoteRenderer;
    private RendererViewContainer remoteRendererContainer;
    private EglBase rootEglBase;
    private LocalVideoFrameListener localVideoFrameListener = null;
    private RemoteVideoFrameListener remoteVideoFrameListener = null;
    private PeerConnectionClientInterface peerConnectionClientInterface = null;

    @TargetApi(11)
    public DefaultVideoController(Context context, DefaultSinchClient defaultSinchClient) {
        this.mContext = context;
        this.mSinchClient = defaultSinchClient;
        RendererCommon.ScalingType scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
        this.mScalingBehaviour = scalingType;
        this.mLocalVideoScalingBehaviour = scalingType;
        this.mCameraDevicePosition = 1;
        this.localRenderer = new SurfaceViewRenderer(context);
        this.remoteRenderer = new SurfaceViewRenderer(context);
        EglBase rootEglBase = DefaultPeerConnectionFactoryProvider.getRootEglBase();
        this.rootEglBase = rootEglBase;
        if (rootEglBase != null) {
            this.eglBaseContext = rootEglBase.getEglBaseContext();
        }
        this.localRenderer.init(this.eglBaseContext, null);
        this.remoteRenderer.init(this.eglBaseContext, null);
        this.localRenderer.setZOrderMediaOverlay(true);
        this.localRenderer.setMirror(true);
        this.remoteRenderer.setScalingType(this.mScalingBehaviour);
        this.localRenderer.setScalingType(this.mLocalVideoScalingBehaviour);
        this.localRendererContainer = new RendererViewContainer(context);
        this.remoteRendererContainer = new RendererViewContainer(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.localRendererContainer.addView(this.localRenderer, layoutParams);
        this.remoteRendererContainer.addView(this.remoteRenderer, layoutParams);
    }

    private void throwIfDisposed() {
        if (this.mSinchClient.isDisposed()) {
            throw new IllegalStateException("SinchClient is stopped, further calls will throw Exceptions.");
        }
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public void dispose() {
        SurfaceViewRenderer surfaceViewRenderer = this.localRenderer;
        if (surfaceViewRenderer != null) {
            this.localRendererContainer.removeView(surfaceViewRenderer);
            this.localRenderer.release();
            this.localRenderer = null;
        }
        SurfaceViewRenderer surfaceViewRenderer2 = this.remoteRenderer;
        if (surfaceViewRenderer2 != null) {
            this.remoteRendererContainer.removeView(surfaceViewRenderer2);
            this.remoteRenderer.release();
            this.remoteRenderer = null;
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public int getCaptureDevicePosition() {
        return this.mCameraDevicePosition;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public EglBase getEglBase() {
        return this.rootEglBase;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public SurfaceViewRenderer getLocalRenderer() {
        return this.localRenderer;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public LocalVideoFrameListener getLocalVideoFrameListener() {
        return this.localVideoFrameListener;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public View getLocalView() {
        throwIfDisposed();
        return this.localRendererContainer;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public SurfaceViewRenderer getRemoteRenderer() {
        return this.remoteRenderer;
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public RemoteVideoFrameListener getRemoteVideoFrameListener() {
        return this.remoteVideoFrameListener;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public View getRemoteView() {
        throwIfDisposed();
        return this.remoteRendererContainer;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setCaptureDevicePosition(int i8) {
        if (i8 != 0 && i8 != 1) {
            throw new IllegalArgumentException("Camera facing should be 0 or 1");
        }
        if (i8 != this.mCameraDevicePosition) {
            this.mCameraDevicePosition = i8;
            PeerConnectionClientInterface peerConnectionClientInterface = this.peerConnectionClientInterface;
            if (peerConnectionClientInterface != null) {
                peerConnectionClientInterface.switchCamera();
            }
            SurfaceViewRenderer surfaceViewRenderer = this.localRenderer;
            if (surfaceViewRenderer != null) {
                surfaceViewRenderer.setMirror(this.mCameraDevicePosition == 1);
            }
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setLocalVideoFrameListener(LocalVideoFrameListener localVideoFrameListener) {
        this.localVideoFrameListener = localVideoFrameListener;
        PeerConnectionClientInterface peerConnectionClientInterface = this.peerConnectionClientInterface;
        if (peerConnectionClientInterface != null) {
            peerConnectionClientInterface.setLocalVideoFrameListener(localVideoFrameListener);
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setLocalVideoResizeBehaviour(VideoScalingType videoScalingType) {
        RendererCommon.ScalingType scalingType;
        throwIfDisposed();
        if (videoScalingType == VideoScalingType.ASPECT_FIT) {
            scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
        } else if (videoScalingType == VideoScalingType.ASPECT_FILL) {
            scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FILL;
        } else if (videoScalingType != VideoScalingType.ASPECT_BALANCED) {
            throw new IllegalArgumentException("Invalid scaling type.");
        } else {
            scalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
        }
        this.mLocalVideoScalingBehaviour = scalingType;
        SurfaceViewRenderer surfaceViewRenderer = this.localRenderer;
        if (surfaceViewRenderer != null) {
            surfaceViewRenderer.setScalingType(this.mLocalVideoScalingBehaviour);
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setLocalVideoZOrder(boolean z7) {
        this.localRenderer.setZOrderMediaOverlay(z7);
        this.remoteRenderer.setZOrderMediaOverlay(!z7);
    }

    @Override // com.sinch.android.rtc.internal.client.video.VideoControllerInternal
    public void setPeerConnectionClient(PeerConnectionClientInterface peerConnectionClientInterface) {
        this.peerConnectionClientInterface = peerConnectionClientInterface;
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setRemoteVideoFrameListener(RemoteVideoFrameListener remoteVideoFrameListener) {
        this.remoteVideoFrameListener = remoteVideoFrameListener;
        PeerConnectionClientInterface peerConnectionClientInterface = this.peerConnectionClientInterface;
        if (peerConnectionClientInterface != null) {
            peerConnectionClientInterface.setRemoteVideoFrameListener(remoteVideoFrameListener);
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setResizeBehaviour(VideoScalingType videoScalingType) {
        RendererCommon.ScalingType scalingType;
        throwIfDisposed();
        if (videoScalingType == VideoScalingType.ASPECT_FIT) {
            scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FIT;
        } else if (videoScalingType == VideoScalingType.ASPECT_FILL) {
            scalingType = RendererCommon.ScalingType.SCALE_ASPECT_FILL;
        } else if (videoScalingType != VideoScalingType.ASPECT_BALANCED) {
            throw new IllegalArgumentException("Invalid scaling type.");
        } else {
            scalingType = RendererCommon.ScalingType.SCALE_ASPECT_BALANCED;
        }
        this.mScalingBehaviour = scalingType;
        SurfaceViewRenderer surfaceViewRenderer = this.remoteRenderer;
        if (surfaceViewRenderer != null) {
            surfaceViewRenderer.setScalingType(this.mScalingBehaviour);
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void setTorchMode(boolean z7) {
        PeerConnectionClientInterface peerConnectionClientInterface = this.peerConnectionClientInterface;
        if (peerConnectionClientInterface != null) {
            peerConnectionClientInterface.setTorchMode(z7);
        }
    }

    @Override // com.sinch.android.rtc.video.VideoController
    public void toggleCaptureDevicePosition() {
        int i8 = this.mCameraDevicePosition;
        if (i8 == 1) {
            setCaptureDevicePosition(0);
        } else if (i8 == 0) {
            setCaptureDevicePosition(1);
        }
    }
}
