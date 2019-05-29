/*
 * Copyright 2017-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.client.idgenerator;

import io.atomix.client.PrimitiveBuilder;
import io.atomix.client.PrimitiveManagementService;
import io.atomix.service.protocol.PrimitiveProtocol;
import io.atomix.service.protocol.ProxyCompatibleBuilder;
import io.atomix.service.protocol.ServiceProtocol;

/**
 * Builder for AtomicIdGenerator.
 */
public abstract class AtomicIdGeneratorBuilder
    extends PrimitiveBuilder<AtomicIdGeneratorBuilder, AtomicIdGeneratorConfig, AtomicIdGenerator>
    implements ProxyCompatibleBuilder<AtomicIdGeneratorBuilder> {

  protected AtomicIdGeneratorBuilder(String name, AtomicIdGeneratorConfig config, PrimitiveManagementService managementService) {
    super(AtomicIdGeneratorType.instance(), name, config, managementService);
  }

  @Override
  public AtomicIdGeneratorBuilder withProtocol(ServiceProtocol protocol) {
    return withProtocol((PrimitiveProtocol) protocol);
  }
}