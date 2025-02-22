/*******************************************************************************
 * Copyright (c) 2015 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.ibm.ws.cdi.beansxml.implicit.fat.implicitWarLibJars.war.discoveryModeAll;

import javax.enterprise.context.Dependent;

import com.ibm.ws.cdi.beansxml.implicit.fat.utils.SimpleAbstract;

/**
 * This bean is in an archive with {@code bean-discovery-mode=all}. This is an <em>explicit</em> bean archive.
 */
@Dependent
public class InExplicitBeanArchive extends SimpleAbstract {}
