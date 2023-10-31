package org.jeometry.common.data.refresh;

import java.util.function.Supplier;

public interface RefreshableValue<V> extends Refreshable, Supplier<V> {
  static <T> SupplierRefreshableValue<T> supplier(final Supplier<T> supplier) {
    return new SupplierRefreshableValue<>(supplier);
  }

  void clearValue();

  @Override
  default V get() {
    return getValue();
  }

  V getValue();

  @Override
  default void refresh() {
    refreshValue();
  }

  V refreshValue();

  V refreshValueIfNeeded();
}
