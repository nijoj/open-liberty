/*******************************************************************************
 * Copyright (c) 2022 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 * IBM Corporation - initial API and implementation
 *******************************************************************************/
package oidc.client.useNonceTrueWithEL.servlets;

import jakarta.annotation.security.DeclareRoles;
import jakarta.security.enterprise.authentication.mechanism.http.OpenIdAuthenticationMechanismDefinition;
import jakarta.security.enterprise.authentication.mechanism.http.openid.ClaimsDefinition;
import jakarta.servlet.annotation.HttpConstraint;
import jakarta.servlet.annotation.ServletSecurity;
import jakarta.servlet.annotation.WebServlet;
import oidc.client.base.servlets.BaseServlet;

@WebServlet("/UseNonceTrueWithELServlet")
@OpenIdAuthenticationMechanismDefinition(providerURI = "${providerBean.providerSecureRoot}/oidc/endpoint/OP1",
                                         clientId = "client_1",
                                         clientSecret = "mySharedKeyNowHasToBeLongerStrongerAndMoreSecureAndForHS512EvenLongerToBeStronger",
                                         claimsDefinition = @ClaimsDefinition(callerNameClaim = "sub", callerGroupsClaim = "groupIds"),
                                         redirectURI = "${baseURL}/Callback",
                                         useNonce = true,
                                         useNonceExpression = "${openIdConfig.useNonceExpression}",
                                         jwksReadTimeoutExpression = "${openIdConfig.jwksReadTimeoutExpression}")
@DeclareRoles("all")
@ServletSecurity(@HttpConstraint(rolesAllowed = "all"))
public class UseNonceTrueWithELServlet extends BaseServlet {

    private static final long serialVersionUID = 1L;

}
