package com.google.android.gms.maps;

import android.graphics.Bitmap;
import android.location.Location;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
/* loaded from: classes.dex */
public class GoogleMap {
    public static final int MAP_TYPE_HYBRID = 4;
    public static final int MAP_TYPE_NONE = 0;
    public static final int MAP_TYPE_NORMAL = 1;
    public static final int MAP_TYPE_SATELLITE = 2;
    public static final int MAP_TYPE_TERRAIN = 3;
    private final IGoogleMapDelegate zza;
    private final HashMap zzb = new HashMap();
    private UiSettings zzc;

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface InfoWindowAdapter {
        View getInfoContents(@NonNull Marker marker);

        View getInfoWindow(@NonNull Marker marker);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface OnCameraChangeListener {
        void onCameraChange(@NonNull CameraPosition cameraPosition);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 2;
        public static final int REASON_DEVELOPER_ANIMATION = 3;
        public static final int REASON_GESTURE = 1;

        void onCameraMoveStarted(int i8);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnCircleClickListener {
        void onCircleClick(@NonNull Circle circle);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnGroundOverlayClickListener {
        void onGroundOverlayClick(@NonNull GroundOverlay groundOverlay);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnIndoorStateChangeListener {
        void onIndoorBuildingFocused();

        void onIndoorLevelActivated(@NonNull IndoorBuilding indoorBuilding);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnInfoWindowClickListener {
        void onInfoWindowClick(@NonNull Marker marker);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(@NonNull Marker marker);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(@NonNull Marker marker);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMapClickListener {
        void onMapClick(@NonNull LatLng latLng);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMapLoadedCallback {
        void onMapLoaded();
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMapLongClickListener {
        void onMapLongClick(@NonNull LatLng latLng);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMarkerClickListener {
        boolean onMarkerClick(@NonNull Marker marker);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMarkerDragListener {
        void onMarkerDrag(@NonNull Marker marker);

        void onMarkerDragEnd(@NonNull Marker marker);

        void onMarkerDragStart(@NonNull Marker marker);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMyLocationButtonClickListener {
        boolean onMyLocationButtonClick();
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface OnMyLocationChangeListener {
        void onMyLocationChange(@NonNull Location location);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnMyLocationClickListener {
        void onMyLocationClick(@NonNull Location location);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnPoiClickListener {
        void onPoiClick(@NonNull PointOfInterest pointOfInterest);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnPolygonClickListener {
        void onPolygonClick(@NonNull Polygon polygon);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface OnPolylineClickListener {
        void onPolylineClick(@NonNull Polyline polyline);
    }

    /* compiled from: com.google.android.gms:play-services-maps@@18.1.0 */
    /* loaded from: classes.dex */
    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    public GoogleMap(@NonNull IGoogleMapDelegate iGoogleMapDelegate) {
        this.zza = (IGoogleMapDelegate) Preconditions.checkNotNull(iGoogleMapDelegate);
    }

    @NonNull
    public final Circle addCircle(@NonNull CircleOptions circleOptions) {
        try {
            Preconditions.checkNotNull(circleOptions, "CircleOptions must not be null.");
            return new Circle(this.zza.addCircle(circleOptions));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final GroundOverlay addGroundOverlay(@NonNull GroundOverlayOptions groundOverlayOptions) {
        try {
            Preconditions.checkNotNull(groundOverlayOptions, "GroundOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.zzo addGroundOverlay = this.zza.addGroundOverlay(groundOverlayOptions);
            if (addGroundOverlay != null) {
                return new GroundOverlay(addGroundOverlay);
            }
            return null;
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final Marker addMarker(@NonNull MarkerOptions markerOptions) {
        try {
            Preconditions.checkNotNull(markerOptions, "MarkerOptions must not be null.");
            com.google.android.gms.internal.maps.zzaa addMarker = this.zza.addMarker(markerOptions);
            if (addMarker != null) {
                return new Marker(addMarker);
            }
            return null;
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public final Polygon addPolygon(@NonNull PolygonOptions polygonOptions) {
        try {
            Preconditions.checkNotNull(polygonOptions, "PolygonOptions must not be null");
            return new Polygon(this.zza.addPolygon(polygonOptions));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public final Polyline addPolyline(@NonNull PolylineOptions polylineOptions) {
        try {
            Preconditions.checkNotNull(polylineOptions, "PolylineOptions must not be null");
            return new Polyline(this.zza.addPolyline(polylineOptions));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final TileOverlay addTileOverlay(@NonNull TileOverlayOptions tileOverlayOptions) {
        try {
            Preconditions.checkNotNull(tileOverlayOptions, "TileOverlayOptions must not be null.");
            com.google.android.gms.internal.maps.zzaj addTileOverlay = this.zza.addTileOverlay(tileOverlayOptions);
            if (addTileOverlay != null) {
                return new TileOverlay(addTileOverlay);
            }
            return null;
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void animateCamera(@NonNull CameraUpdate cameraUpdate) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.zza.animateCamera(cameraUpdate.zza());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void clear() {
        try {
            this.zza.clear();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public final CameraPosition getCameraPosition() {
        try {
            return this.zza.getCameraPosition();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public IndoorBuilding getFocusedBuilding() {
        try {
            com.google.android.gms.internal.maps.zzr focusedBuilding = this.zza.getFocusedBuilding();
            if (focusedBuilding != null) {
                return new IndoorBuilding(focusedBuilding);
            }
            return null;
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final int getMapType() {
        try {
            return this.zza.getMapType();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final float getMaxZoomLevel() {
        try {
            return this.zza.getMaxZoomLevel();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final float getMinZoomLevel() {
        try {
            return this.zza.getMinZoomLevel();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    @Deprecated
    public final Location getMyLocation() {
        try {
            return this.zza.getMyLocation();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public final Projection getProjection() {
        try {
            return new Projection(this.zza.getProjection());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @NonNull
    public final UiSettings getUiSettings() {
        try {
            if (this.zzc == null) {
                this.zzc = new UiSettings(this.zza.getUiSettings());
            }
            return this.zzc;
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final boolean isBuildingsEnabled() {
        try {
            return this.zza.isBuildingsEnabled();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final boolean isIndoorEnabled() {
        try {
            return this.zza.isIndoorEnabled();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final boolean isMyLocationEnabled() {
        try {
            return this.zza.isMyLocationEnabled();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final boolean isTrafficEnabled() {
        try {
            return this.zza.isTrafficEnabled();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void moveCamera(@NonNull CameraUpdate cameraUpdate) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.zza.moveCamera(cameraUpdate.zza());
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void resetMinMaxZoomPreference() {
        try {
            this.zza.resetMinMaxZoomPreference();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setBuildingsEnabled(boolean z7) {
        try {
            this.zza.setBuildingsEnabled(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setContentDescription(String str) {
        try {
            this.zza.setContentDescription(str);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final boolean setIndoorEnabled(boolean z7) {
        try {
            return this.zza.setIndoorEnabled(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        try {
            if (infoWindowAdapter == null) {
                this.zza.setInfoWindowAdapter(null);
            } else {
                this.zza.setInfoWindowAdapter(new zzf(this, infoWindowAdapter));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        try {
            this.zza.setLatLngBoundsForCameraTarget(latLngBounds);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setLocationSource(LocationSource locationSource) {
        try {
            if (locationSource == null) {
                this.zza.setLocationSource(null);
            } else {
                this.zza.setLocationSource(new zzs(this, locationSource));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public boolean setMapStyle(MapStyleOptions mapStyleOptions) {
        try {
            return this.zza.setMapStyle(mapStyleOptions);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setMapType(int i8) {
        try {
            this.zza.setMapType(i8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setMaxZoomPreference(float f8) {
        try {
            this.zza.setMaxZoomPreference(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setMinZoomPreference(float f8) {
        try {
            this.zza.setMinZoomPreference(f8);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setMyLocationEnabled(boolean z7) {
        try {
            this.zza.setMyLocationEnabled(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @Deprecated
    public final void setOnCameraChangeListener(OnCameraChangeListener onCameraChangeListener) {
        try {
            if (onCameraChangeListener == null) {
                this.zza.setOnCameraChangeListener(null);
            } else {
                this.zza.setOnCameraChangeListener(new zzt(this, onCameraChangeListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        try {
            if (onCameraIdleListener == null) {
                this.zza.setOnCameraIdleListener(null);
            } else {
                this.zza.setOnCameraIdleListener(new zzx(this, onCameraIdleListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnCameraMoveCanceledListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        try {
            if (onCameraMoveCanceledListener == null) {
                this.zza.setOnCameraMoveCanceledListener(null);
            } else {
                this.zza.setOnCameraMoveCanceledListener(new zzw(this, onCameraMoveCanceledListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        try {
            if (onCameraMoveListener == null) {
                this.zza.setOnCameraMoveListener(null);
            } else {
                this.zza.setOnCameraMoveListener(new zzv(this, onCameraMoveListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        try {
            if (onCameraMoveStartedListener == null) {
                this.zza.setOnCameraMoveStartedListener(null);
            } else {
                this.zza.setOnCameraMoveStartedListener(new zzu(this, onCameraMoveStartedListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnCircleClickListener(OnCircleClickListener onCircleClickListener) {
        try {
            if (onCircleClickListener == null) {
                this.zza.setOnCircleClickListener(null);
            } else {
                this.zza.setOnCircleClickListener(new zzn(this, onCircleClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnGroundOverlayClickListener(OnGroundOverlayClickListener onGroundOverlayClickListener) {
        try {
            if (onGroundOverlayClickListener == null) {
                this.zza.setOnGroundOverlayClickListener(null);
            } else {
                this.zza.setOnGroundOverlayClickListener(new zzm(this, onGroundOverlayClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnIndoorStateChangeListener(OnIndoorStateChangeListener onIndoorStateChangeListener) {
        try {
            if (onIndoorStateChangeListener == null) {
                this.zza.setOnIndoorStateChangeListener(null);
            } else {
                this.zza.setOnIndoorStateChangeListener(new zzk(this, onIndoorStateChangeListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        try {
            if (onInfoWindowClickListener == null) {
                this.zza.setOnInfoWindowClickListener(null);
            } else {
                this.zza.setOnInfoWindowClickListener(new zzc(this, onInfoWindowClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        try {
            if (onInfoWindowCloseListener == null) {
                this.zza.setOnInfoWindowCloseListener(null);
            } else {
                this.zza.setOnInfoWindowCloseListener(new zze(this, onInfoWindowCloseListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        try {
            if (onInfoWindowLongClickListener == null) {
                this.zza.setOnInfoWindowLongClickListener(null);
            } else {
                this.zza.setOnInfoWindowLongClickListener(new zzd(this, onInfoWindowLongClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnMapClickListener(OnMapClickListener onMapClickListener) {
        try {
            if (onMapClickListener == null) {
                this.zza.setOnMapClickListener(null);
            } else {
                this.zza.setOnMapClickListener(new zzy(this, onMapClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public void setOnMapLoadedCallback(OnMapLoadedCallback onMapLoadedCallback) {
        try {
            if (onMapLoadedCallback == null) {
                this.zza.setOnMapLoadedCallback(null);
            } else {
                this.zza.setOnMapLoadedCallback(new zzj(this, onMapLoadedCallback));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        try {
            if (onMapLongClickListener == null) {
                this.zza.setOnMapLongClickListener(null);
            } else {
                this.zza.setOnMapLongClickListener(new zzz(this, onMapLongClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        try {
            if (onMarkerClickListener == null) {
                this.zza.setOnMarkerClickListener(null);
            } else {
                this.zza.setOnMarkerClickListener(new zza(this, onMarkerClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnMarkerDragListener(OnMarkerDragListener onMarkerDragListener) {
        try {
            if (onMarkerDragListener == null) {
                this.zza.setOnMarkerDragListener(null);
            } else {
                this.zza.setOnMarkerDragListener(new zzb(this, onMarkerDragListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnMyLocationButtonClickListener(OnMyLocationButtonClickListener onMyLocationButtonClickListener) {
        try {
            if (onMyLocationButtonClickListener == null) {
                this.zza.setOnMyLocationButtonClickListener(null);
            } else {
                this.zza.setOnMyLocationButtonClickListener(new zzh(this, onMyLocationButtonClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    @Deprecated
    public final void setOnMyLocationChangeListener(OnMyLocationChangeListener onMyLocationChangeListener) {
        try {
            if (onMyLocationChangeListener == null) {
                this.zza.setOnMyLocationChangeListener(null);
            } else {
                this.zza.setOnMyLocationChangeListener(new zzg(this, onMyLocationChangeListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnMyLocationClickListener(OnMyLocationClickListener onMyLocationClickListener) {
        try {
            if (onMyLocationClickListener == null) {
                this.zza.setOnMyLocationClickListener(null);
            } else {
                this.zza.setOnMyLocationClickListener(new zzi(this, onMyLocationClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnPoiClickListener(OnPoiClickListener onPoiClickListener) {
        try {
            if (onPoiClickListener == null) {
                this.zza.setOnPoiClickListener(null);
            } else {
                this.zza.setOnPoiClickListener(new zzr(this, onPoiClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        try {
            if (onPolygonClickListener == null) {
                this.zza.setOnPolygonClickListener(null);
            } else {
                this.zza.setOnPolygonClickListener(new zzo(this, onPolygonClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        try {
            if (onPolylineClickListener == null) {
                this.zza.setOnPolylineClickListener(null);
            } else {
                this.zza.setOnPolylineClickListener(new zzp(this, onPolylineClickListener));
            }
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setPadding(int i8, int i9, int i10, int i11) {
        try {
            this.zza.setPadding(i8, i9, i10, i11);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void setTrafficEnabled(boolean z7) {
        try {
            this.zza.setTrafficEnabled(z7);
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void snapshot(@NonNull SnapshotReadyCallback snapshotReadyCallback) {
        Preconditions.checkNotNull(snapshotReadyCallback, "Callback must not be null.");
        snapshot(snapshotReadyCallback, null);
    }

    public final void stopAnimation() {
        try {
            this.zza.stopAnimation();
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void snapshot(@NonNull SnapshotReadyCallback snapshotReadyCallback, Bitmap bitmap) {
        Preconditions.checkNotNull(snapshotReadyCallback, "Callback must not be null.");
        try {
            this.zza.snapshot(new zzq(this, snapshotReadyCallback), (ObjectWrapper) (bitmap != null ? ObjectWrapper.wrap(bitmap) : null));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void animateCamera(@NonNull CameraUpdate cameraUpdate, int i8, CancelableCallback cancelableCallback) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.zza.animateCameraWithDurationAndCallback(cameraUpdate.zza(), i8, cancelableCallback == null ? null : new zzaa(cancelableCallback));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }

    public final void animateCamera(@NonNull CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        try {
            Preconditions.checkNotNull(cameraUpdate, "CameraUpdate must not be null.");
            this.zza.animateCameraWithCallback(cameraUpdate.zza(), cancelableCallback == null ? null : new zzaa(cancelableCallback));
        } catch (RemoteException e8) {
            throw new RuntimeRemoteException(e8);
        }
    }
}
