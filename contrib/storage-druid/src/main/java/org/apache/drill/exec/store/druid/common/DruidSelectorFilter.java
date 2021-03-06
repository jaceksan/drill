/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.drill.exec.store.druid.common;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = DruidSelectorFilter.class)
@JsonPropertyOrder({ "type", "dimension", "value" })
public class DruidSelectorFilter extends DruidFilterBase {
  private final String type = DruidCompareOp.TYPE_SELECTOR.getCompareOp();
  private final String dimension;
  private final String value;

  @JsonCreator
  public DruidSelectorFilter(@JsonProperty("dimension") String dimension,
                             @JsonProperty("value") String value) {
    this.dimension = dimension;
    this.value = value;
  }

  public String getType() {
    return type;
  }

  public String getDimension() {
    return dimension;
  }

  public String getValue() {
    return value;
  }
}
