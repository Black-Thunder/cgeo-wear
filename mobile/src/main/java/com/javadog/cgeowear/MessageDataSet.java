package com.javadog.cgeowear;

import com.google.android.gms.wearable.DataMap;

/**
 * A Bundle-like solution to passing a set of objects between the phone and Wear device.
 */
public class MessageDataSet {
	public static final String KEY_CACHE_NAME = "cacheName";
	public static final String KEY_GEOCODE = "geocode";
	public static final String KEY_DISTANCE = "distance";
	public static final String KEY_DIRECTION = "direction";

	private final String cacheName, geocode;
	private final float distance, direction;

	/**
	 * Do not call directly, use MessageDataSet.Builder to obtain a new instance.
	 */
	private MessageDataSet(String name, String code, float dist, float dir) {
		cacheName = name;
		geocode = code;
		distance = dist;
		direction = dir;
	}

	/**
	 * Constructs the new object using the supplied DataMap.
	 *
	 * @param map The DataMap containing values to instantiate.
	 */
	public MessageDataSet(DataMap map) {
		this(
				map.getString(KEY_CACHE_NAME),
				map.getString(KEY_GEOCODE),
				map.getFloat(KEY_DISTANCE),
				map.getFloat(KEY_DIRECTION)
		);
	}

	public DataMap putToDataMap() {
		DataMap map = new DataMap();

		map.putString(KEY_CACHE_NAME, cacheName);
		map.putString(KEY_GEOCODE, geocode);
		map.putFloat(KEY_DISTANCE, distance);
		map.putFloat(KEY_DIRECTION, direction);

		return map;
	}

	public String getCacheName() {
		return cacheName;
	}

	public String getGeocode() {
		return geocode;
	}

	public float getDistance() {
		return distance;
	}

	public float getDirection() {
		return direction;
	}

	public static class Builder {
		private String nestedCacheName, nestedGeocode;
		private float nestedDistance, nestedDirection;

		public Builder(float dist, float dir) {
			nestedDistance = dist;
			nestedDirection = dir;
		}

		public Builder cacheName(String name) {
			nestedCacheName = name;
			return this;
		}

		public Builder geocode(String code) {
			nestedGeocode = code;
			return this;
		}

		public MessageDataSet build() {
			return new MessageDataSet(nestedCacheName, nestedGeocode, nestedDistance, nestedDirection);
		}
	}
}