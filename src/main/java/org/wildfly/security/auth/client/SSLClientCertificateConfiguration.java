/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2015 Red Hat, Inc., and individual contributors
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

package org.wildfly.security.auth.client;

import java.security.GeneralSecurityException;

import org.wildfly.security.SecurityFactory;
import org.wildfly.security.credential.X509CertificateChainPrivateCredential;

/**
 * @author <a href="mailto:david.lloyd@redhat.com">David M. Lloyd</a>
 */
class SSLClientCertificateConfiguration extends AuthenticationConfiguration {

    private final SecurityFactory<X509CertificateChainPrivateCredential> credentialFactory;

    SSLClientCertificateConfiguration(final AuthenticationConfiguration parent, final SecurityFactory<X509CertificateChainPrivateCredential> credentialFactory) {
        super(parent.without(SSLClientKeyManagerConfiguration.class), true);
        this.credentialFactory = credentialFactory;
    }

    AuthenticationConfiguration reparent(final AuthenticationConfiguration newParent) {
        return new SSLClientCertificateConfiguration(newParent, credentialFactory);
    }

    void configureKeyManager(final ConfigurationKeyManager.Builder builder) throws GeneralSecurityException {
        super.configureKeyManager(builder);
        builder.addCredential(credentialFactory.create());
    }
}
