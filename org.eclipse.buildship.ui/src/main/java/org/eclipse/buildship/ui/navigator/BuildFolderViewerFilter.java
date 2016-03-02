/*
 * Copyright (c) 2016 the original author or authors.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Etienne Studer & Donát Csikós (Gradle Inc.) - initial API and implementation and initial documentation
 */

package org.eclipse.buildship.ui.navigator;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import org.eclipse.buildship.core.CorePlugin;

/**
 * Allows users to show or hide the build folder in the Navigator, Project and Package Explorer.
 *
 * @author Stefan Oehme
 */
public class BuildFolderViewerFilter extends ViewerFilter {

    @SuppressWarnings({"cast", "RedundantCast"})
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        IResource resource = (IResource) Platform.getAdapterManager().getAdapter(element, IResource.class);
        if (resource == null) {
            return true;
        }
        return !isBuildFolder(resource);
    }

    private boolean isBuildFolder(IResource resource) {
        if (resource instanceof IFolder) {
            return CorePlugin.workspaceOperations().isBuildFolder((IFolder) resource);
        }
        return false;
    }

}
