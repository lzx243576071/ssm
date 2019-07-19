package com.soecode.web.dto;

/**
 * 从guava拷贝过来的助手类
 *add by luzx 2019/07/14
 */

public final class ToStringHelper {
	private final String className;
	private ToStringHelper.ValueHolder holderHead = new ToStringHelper.ValueHolder();
	private ToStringHelper.ValueHolder holderTail;
	private boolean omitNullValues;

	public static ToStringHelper create(Object object) {
		return new ToStringHelper(object.getClass().getSimpleName());
	}

	private ToStringHelper(String className) {
		this.holderTail = this.holderHead;
		this.omitNullValues = false;
		this.className = className;
	}

	public ToStringHelper omitNullValues() {
		this.omitNullValues = true;
		return this;
	}

	public ToStringHelper add(String name, Object value) {
		return this.addHolder(name, value);
	}

	public ToStringHelper add(String name, boolean value) {
		return this.addHolder(name, String.valueOf(value));
	}

	public ToStringHelper add(String name, char value) {
		return this.addHolder(name, String.valueOf(value));
	}

	public ToStringHelper add(String name, double value) {
		return this.addHolder(name, String.valueOf(value));
	}

	public ToStringHelper add(String name, float value) {
		return this.addHolder(name, String.valueOf(value));
	}

	public ToStringHelper add(String name, int value) {
		return this.addHolder(name, String.valueOf(value));
	}

	public ToStringHelper add(String name, long value) {
		return this.addHolder(name, String.valueOf(value));
	}

	public ToStringHelper addValue(Object value) {
		return this.addHolder(value);
	}

	public ToStringHelper addValue(boolean value) {
		return this.addHolder(String.valueOf(value));
	}

	public ToStringHelper addValue(char value) {
		return this.addHolder(String.valueOf(value));
	}

	public ToStringHelper addValue(double value) {
		return this.addHolder(String.valueOf(value));
	}

	public ToStringHelper addValue(float value) {
		return this.addHolder(String.valueOf(value));
	}

	public ToStringHelper addValue(int value) {
		return this.addHolder(String.valueOf(value));
	}

	public ToStringHelper addValue(long value) {
		return this.addHolder(String.valueOf(value));
	}

	public String toString() {
		boolean omitNullValuesSnapshot = this.omitNullValues;
		String nextSeparator = "";
		StringBuilder builder = (new StringBuilder(32)).append(this.className).append('{');

		for(ToStringHelper.ValueHolder valueHolder = this.holderHead.next; valueHolder != null; valueHolder = valueHolder.next) {
			if (!omitNullValuesSnapshot || valueHolder.value != null) {
				builder.append(nextSeparator);
				nextSeparator = ", ";
				if (valueHolder.name != null) {
					builder.append(valueHolder.name).append('=');
				}

				builder.append(valueHolder.value);
			}
		}

		return builder.append('}').toString();
	}

	private ToStringHelper.ValueHolder addHolder() {
		ToStringHelper.ValueHolder valueHolder = new ToStringHelper.ValueHolder();
		this.holderTail = this.holderTail.next = valueHolder;
		return valueHolder;
	}

	private ToStringHelper addHolder(Object value) {
		ToStringHelper.ValueHolder valueHolder = this.addHolder();
		valueHolder.value = value;
		return this;
	}

	private ToStringHelper addHolder(String name, Object value) {
		ToStringHelper.ValueHolder valueHolder = this.addHolder();
		valueHolder.value = value;
		valueHolder.name = name;
		return this;
	}

	private static final class ValueHolder {
		String name;
		Object value;
		ToStringHelper.ValueHolder next;

		private ValueHolder() {
		}
	}
}
