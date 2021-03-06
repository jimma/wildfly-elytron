/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2014 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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

package org.wildfly.security.ssl;

import java.util.EnumSet;

/**
 * The protocol type for SSL/TLS cipher suite selection and protocol selection.
 *
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
public enum Protocol {
    /**
     * The SSL version 2 protocol.
     */
    SSLv2,
    /**
     * The SSL version 3 protocol.
     */
    SSLv3,
    /**
     * The TLS version 1.0 protocol.
     */
    TLSv1,
    /**
     * The TLS version 1.1 protocol.  Note that there are no cipher suites which are specifically defined in this protocol.
     */
    TLSv1_1,
    /**
     * The TLS version 1.2 protocol.
     */
    TLSv1_2,
    /**
     * The TLS version 1.3 protocol.
     */
    TLSv1_3,
    ;
    static final int fullSize = values().length;

    static Protocol forName(final String name) {
        switch (name) {
            case "SSLv2": return SSLv2;
            case "SSLv3": return SSLv3;
            case "TLSv1": return TLSv1;
            case "TLSv1.1": return TLSv1_1;
            case "TLSv1.2": return TLSv1_2;
            case "TLSv1.3": return TLSv1_3;
            default: return null;
        }
    }

    /**
     * Determine whether the given set is "full" (meaning it contains all possible values).
     *
     * @param protocols the set
     * @return {@code true} if the set is full, {@code false} otherwise
     */
    public static boolean isFull(final EnumSet<Protocol> protocols) {
        return protocols != null && protocols.size() == fullSize;
    }

    /**
     * Determine whether this instance is equal to one of the given instances.
     *
     * @param value1 the first instance
     * @param value2 the second instance
     * @return {@code true} if one of the instances matches this one, {@code false} otherwise
     */
    public boolean in(final Protocol value1, final Protocol value2) {
        return this == value1 || this == value2;
    }

    /**
     * Determine whether this instance is equal to one of the given instances.
     *
     * @param value1 the first instance
     * @param value2 the second instance
     * @param value3 the third instance
     * @return {@code true} if one of the instances matches this one, {@code false} otherwise
     */
    public boolean in(final Protocol value1, final Protocol value2, final Protocol value3) {
        return this == value1 || this == value2 || this == value3;
    }

    /**
     * Determine whether this instance is equal to one of the given instances.
     *
     * @param values the values to match against
     * @return {@code true} if one of the instances matches this one, {@code false} otherwise
     */
    public boolean in(final Protocol... values) {
        if (values != null) for (Protocol value : values) {
            if (this == value) return true;
        }
        return false;
    }
}
