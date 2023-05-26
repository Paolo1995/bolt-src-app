package com.google.android.gms.maps.internal;

import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.gms.maps.model.StreetViewSource;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public interface IStreetViewPanoramaDelegate extends IInterface {
    void animateTo(@NonNull StreetViewPanoramaCamera streetViewPanoramaCamera, long j8) throws RemoteException;

    void enablePanning(boolean z7) throws RemoteException;

    void enableStreetNames(boolean z7) throws RemoteException;

    void enableUserNavigation(boolean z7) throws RemoteException;

    void enableZoom(boolean z7) throws RemoteException;

    @NonNull
    StreetViewPanoramaCamera getPanoramaCamera() throws RemoteException;

    @NonNull
    StreetViewPanoramaLocation getStreetViewPanoramaLocation() throws RemoteException;

    boolean isPanningGesturesEnabled() throws RemoteException;

    boolean isStreetNamesEnabled() throws RemoteException;

    boolean isUserNavigationEnabled() throws RemoteException;

    boolean isZoomGesturesEnabled() throws RemoteException;

    IObjectWrapper orientationToPoint(@NonNull StreetViewPanoramaOrientation streetViewPanoramaOrientation) throws RemoteException;

    @NonNull
    StreetViewPanoramaOrientation pointToOrientation(@NonNull IObjectWrapper iObjectWrapper) throws RemoteException;

    void setOnStreetViewPanoramaCameraChangeListener(@Nullable zzbk zzbkVar) throws RemoteException;

    void setOnStreetViewPanoramaChangeListener(@Nullable zzbm zzbmVar) throws RemoteException;

    void setOnStreetViewPanoramaClickListener(@Nullable zzbo zzboVar) throws RemoteException;

    void setOnStreetViewPanoramaLongClickListener(@Nullable zzbq zzbqVar) throws RemoteException;

    void setPosition(@NonNull LatLng latLng) throws RemoteException;

    void setPositionWithID(@NonNull String str) throws RemoteException;

    void setPositionWithRadius(@NonNull LatLng latLng, int i8) throws RemoteException;

    void setPositionWithRadiusAndSource(@NonNull LatLng latLng, int i8, @Nullable StreetViewSource streetViewSource) throws RemoteException;

    void setPositionWithSource(@NonNull LatLng latLng, @Nullable StreetViewSource streetViewSource) throws RemoteException;
}
