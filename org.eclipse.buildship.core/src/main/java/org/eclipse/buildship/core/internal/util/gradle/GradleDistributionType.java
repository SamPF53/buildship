/*
 * Copyright (c) 2018 the original author or authors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.eclipse.buildship.core.internal.util.gradle;

import org.eclipse.buildship.core.internal.GradlePluginsRuntimeException;
import org.eclipse.buildship.core.internal.util.gradle.GradleDistribution.Type;

/**
 * Enumerates the different types of Gradle distributions.
 */
public enum GradleDistributionType {
    INVALID, WRAPPER, LOCAL_INSTALLATION, REMOTE_DISTRIBUTION, VERSION;

    Type toType() {
        if (this == INVALID) {
            throw new GradlePluginsRuntimeException("Invalid gradle distribution");
        } else {
            return Type.valueOf(name());
        }
    }
}