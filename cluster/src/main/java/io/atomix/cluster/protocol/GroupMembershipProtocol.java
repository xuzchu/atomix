/*
 * Copyright 2018-present Open Networking Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.atomix.cluster.protocol;

import io.atomix.cluster.Member;
import io.atomix.cluster.MemberId;
import io.atomix.cluster.discovery.NodeDiscoveryConfig;
import io.atomix.utils.ConfiguredType;
import io.atomix.utils.config.Configured;
import io.atomix.utils.event.ListenerService;

import java.util.Set;

/**
 * Group membership protocol.
 */
public interface GroupMembershipProtocol
    extends ListenerService<GroupMembershipEvent, GroupMembershipEventListener>,
    Configured<NodeDiscoveryConfig> {

  /**
   * Membership provider type.
   */
  interface Type<C extends GroupMembershipConfig> extends ConfiguredType<C> {

    /**
     * Creates a new instance of the protocol.
     *
     * @param config the protocol configuration
     * @return the protocol instance
     */
    GroupMembershipProtocol newProtocol(C config);
  }

  /**
   * Returns the set of current cluster members.
   *
   * @return set of cluster members
   */
  Set<Member> getMembers();

  /**
   * Returns the specified member.
   *
   * @param memberId the member identifier
   * @return the member or {@code null} if no node with the given identifier exists
   */
  Member getMember(MemberId memberId);

}
