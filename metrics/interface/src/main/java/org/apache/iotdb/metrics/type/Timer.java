/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.iotdb.metrics.type;

import java.util.concurrent.TimeUnit;

public interface Timer extends Metric {
  void update(long duration, TimeUnit unit);

  default void updateMillis(long durationMillis) {
    update(durationMillis, TimeUnit.NANOSECONDS);
  }

  default void updateMicros(long durationMicros) {
    update(durationMicros, TimeUnit.MICROSECONDS);
  }

  default void updateNanos(long durationNanos) {
    update(durationNanos, TimeUnit.NANOSECONDS);
  }

  Snapshot takeSnapshot();

  Meter getMeter();
}
